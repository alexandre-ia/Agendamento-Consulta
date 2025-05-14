package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Classes.Paciente;


public class PacienteDAO {
	public void salvar(Paciente paciente) {
        String sql = "INSERT INTO pacientes (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";
        
        try (Connection conexao = BancoDeDados.getConnection();  // Usa a conexão centralizada
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getCpf());
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getTelefone());
            stmt.executeUpdate();
            
        } catch (SQLException e) {
            System.err.println("Erro ao salvar paciente: " + e.getMessage());
        }
    }
	
	// 2) Listar todas os pacientes
	public static  List<Paciente> lerTodas() {
		 List<Paciente> lista = new ArrayList<>();
		 String sql = "SELECT id, nome, cpf, email, idade FROM pacientes";
		 try (Connection conexao = BancoDeDados.getConnection();  // Usa a conexão centralizada
				 PreparedStatement stmt = conexao.prepareStatement(sql);
				 ResultSet rs = stmt.executeQuery(sql)){
			 while (rs.next()) {
				 int id = rs.getInt("id");
				 String nome = rs.getString("nome");
				 String cpf = rs.getString("cpf");
				 String email = rs.getString("email");
				 String telefone = rs.getString("telefone");
				 Paciente p = new Paciente(cpf, nome, email, telefone, id);
				 lista.add(p);
		 }
		 
		 } catch (SQLException e) {
			 e.printStackTrace();
		 }
		 
		 return lista;
		 }

}
