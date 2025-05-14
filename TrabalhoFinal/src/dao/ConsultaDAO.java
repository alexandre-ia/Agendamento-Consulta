package dao;



import Classes.Consulta;
import Classes.Medico;
import Classes.Paciente;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {
    private final BancoDeDados bancoDeDados;

    public ConsultaDAO() {
        this.bancoDeDados = new BancoDeDados();
    }

 // Método para agendar consulta (INSERT)
    public boolean agendar(Consulta consulta) {
        String sql = "INSERT INTO consultas (data_hora, paciente_id, medico_id, observacoes) VALUES (?, ?, ?, ?) RETURNING id";
        
        try (Connection conn = bancoDeDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setTimestamp(1, Timestamp.valueOf(consulta.getDataHora()));
            stmt.setInt(2, consulta.getPaciente().getId());
            stmt.setInt(3, consulta.getMedico().getId());
            stmt.setString(4, consulta.getObservacoes());
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                consulta.setId(rs.getInt("id")); // Atualiza o ID gerado pelo SERIAL
                return true;
            }
        } catch (SQLException e) {
            System.err.println("[ERRO] Ao agendar consulta no PostgreSQL: " + e.getMessage());
            // Log detalhado para debug (opcional)
            e.printStackTrace();
        }
        return false;
    }

    // Método para verificar disponibilidade do médico (SELECT)
    public boolean verificarDisponibilidade(Medico medico, LocalDateTime dataHora) {
        String sql = "SELECT COUNT(*) FROM consultas WHERE medico_id = ? AND data_hora = ?";
        
        try (Connection conn = bancoDeDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, medico.getId());
            stmt.setTimestamp(2, Timestamp.valueOf(dataHora));
            
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) == 0; // True se não houver conflito
            }
        } catch (SQLException e) {
            System.err.println("[ERRO] Ao verificar disponibilidade: " + e.getMessage());
        }
        return false;
    }

    // Método para listar consultas por médico (JOIN com pacientes)
    public List<Consulta> listarPorMedico(Medico medico) {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT c.id, c.data_hora, c.observacoes, p.id AS paciente_id, p.nome AS paciente_nome " +
                     "FROM consultas c " +
                     "INNER JOIN pacientes p ON c.paciente_id = p.id " +
                     "WHERE c.medico_id = ? " +
                     "ORDER BY c.data_hora";
        
        try (Connection conn = bancoDeDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, medico.getId());
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("paciente_id"));
                paciente.setNome(rs.getString("paciente_nome"));
                
                Consulta consulta = new Consulta(
                    rs.getTimestamp("data_hora").toLocalDateTime(),
                    paciente,
                    medico,
                    rs.getString("observacoes")
                );
                consulta.setId(rs.getInt("id"));
                consultas.add(consulta);
            }
        } catch (SQLException e) {
            System.err.println("[ERRO] Ao listar consultas: " + e.getMessage());
        }
        return consultas;
    }

    // Método adicional: Cancelar consulta por ID (DELETE)
    public boolean cancelar(int idConsulta) {
        String sql = "DELETE FROM consultas WHERE id = ?";
        
        try (Connection conn = bancoDeDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, idConsulta);
            int affectedRows = stmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.err.println("[ERRO] Ao cancelar consulta: " + e.getMessage());
        }
        return false;
    }
}
