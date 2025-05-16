package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Classes.Paciente;

public class PacienteDAO {
	public void salvar(Paciente paciente) throws SQLException {
		String sql = "INSERT INTO pacientes (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";

		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getCpf());
			stmt.setString(3, paciente.getEmail());
			stmt.setString(4, paciente.getTelefone());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar paciente " + e);
		} finally {
			BancoDeDados.fecharConnection(con, stmt);
		}

	}

	// 2) Listar todas os pacientes
	public static List<Paciente> read() throws SQLException {
		String sql = "SELECT * FROM pacientes";
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Paciente> pacientes = new ArrayList<>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String cpf = rs.getString("cpf");
				String email = rs.getString("email");
				String telefone = rs.getString("telefone");
				Paciente paciente = new Paciente(cpf, nome, email, telefone, id);
				pacientes.add(paciente);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERRO ao Buscar no banco de dados " + e);
		} finally {
			BancoDeDados.fecharConnection(con, stmt, rs);
		}
		return pacientes;
	}

	// 3) Atualizar Pacientes

	public void update(Paciente paciente) throws SQLException {
		String sql = "UPDATE pacientes SET nome = ?, cpf = ?, email = ? , telefone = ? WHERE id = ?";

		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, paciente.getNome());
			stmt.setString(2, paciente.getCpf());
			stmt.setString(3, paciente.getEmail());
			stmt.setString(4, paciente.getTelefone());
			stmt.setInt(5, paciente.getId());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao atualizar " + e);
		} finally {
			BancoDeDados.fecharConnection(con, stmt);
		}

	}

	// 4) Excluir Pacientes
	public void delete(Paciente paciente) throws SQLException {
		String sql = "DELETE FROM pacientes WHERE id = ?";

		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);
			stmt.setInt(1, paciente.getId());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Excluido com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao excluir " + e);
		} finally {
			BancoDeDados.fecharConnection(con, stmt);
		}

	}

}
