package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Medico;
import Classes.Paciente;

public class MedicoDAO {
	
	public void salvar(Medico medico) {
        String sql = "INSERT INTO medicos (nome, crm, especialidade, sexo) VALUES (?, ?, ?, ?)";
        
        try (Connection conexao = BancoDeDados.getConnection();  // Usa a conexão centralizada
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, medico.getNome());
            stmt.setString(2, medico.getCrm());
            stmt.setString(3, medico.getEspecialidade());
            stmt.setString(4, medico.getSexo());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar medico: " + e.getMessage());
        }
    }
	
	// 2) Listar todas os pacientes
		public static  List<Medico> lerTodas() {
			 List<Medico> lista = new ArrayList<>();
			 String sql = "SELECT id, nome, crm, especialidade, sexo FROM medicos";
			 try (Connection conexao = BancoDeDados.getConnection();  // Usa a conexão centralizada
					 PreparedStatement stmt = conexao.prepareStatement(sql);
					 ResultSet rs = stmt.executeQuery(sql)){
				 while (rs.next()) {
					 int id = rs.getInt("id");
					 String nome = rs.getString("nome");
					 String crm = rs.getString("crm");
					 String especialidade = rs.getString("especialidade");
					 String sexo = rs.getString("sexo");
					 Medico m = new Medico(nome, crm, especialidade, id, sexo);
					 lista.add(m);
			 }
			 
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
			 
			 return lista;
			 }

}
