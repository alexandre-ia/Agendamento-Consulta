package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Classes.Medico;
import Classes.Paciente;

public class MedicoDAO {
	
	public void salvar(Medico medico) throws SQLException {
		String sql = "INSERT INTO medicos (nome, crm, especialidade, sexo) VALUES (?, ?, ?, ?)";

		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		try {
			stmt = con.prepareStatement(sql);

			stmt.setString(1, medico.getNome());
			stmt.setString(2, medico.getCrm());
			stmt.setString(3, medico.getEspecialidade());
			stmt.setString(4, medico.getSexo());
			stmt.executeUpdate();

			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro ao salvar medico " + e);
		} finally {
			BancoDeDados.fecharConnection(con, stmt);
		}

	}
	
	// 2) Listar todas os pacientes
	public static List<Medico> read() throws SQLException {
		String sql = "SELECT * FROM medicos";
		Connection con = BancoDeDados.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

		List<Medico> medicos = new ArrayList<>();

		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				String crm = rs.getString("crm");
				String especialidade = rs.getString("especialidade");
				String sexo = rs.getString("sexo");
				Medico medico = new Medico(nome, crm, especialidade, id, sexo);
				medicos.add(medico);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERRO ao Buscar no banco de dados " + e);
		} finally {
			BancoDeDados.fecharConnection(con, stmt, rs);
		}
		return medicos;
	}
	
	// 3) Atualizar Pacientes

		public void update(Medico medico) throws SQLException {
			String sql = "UPDATE medicos SET nome = ?, crm = ?, especialidade = ? , sexo = ? WHERE id = ?";

			Connection con = BancoDeDados.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement(sql);

				stmt.setString(1, medico.getNome());
				stmt.setString(2, medico.getCrm());
				stmt.setString(3, medico.getEspecialidade());
				stmt.setString(4, medico.getSexo());
				stmt.setInt(5, medico.getId());
				stmt.executeUpdate();

				JOptionPane.showMessageDialog(null, "Atualizado com sucesso");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao atualizar " + e);
			} finally {
				BancoDeDados.fecharConnection(con, stmt);
			}

		}

		// 4) Excluir Pacientes
		public void delete(Medico medico) throws SQLException {
			String sql = "DELETE FROM medicos WHERE id = ?";

			Connection con = BancoDeDados.getConnection();
			PreparedStatement stmt = null;
			try {
				stmt = con.prepareStatement(sql);
				stmt.setInt(1, medico.getId());
				stmt.executeUpdate();

				JOptionPane.showMessageDialog(null, "Excluido com sucesso");

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao excluir " + e);
			} finally {
				BancoDeDados.fecharConnection(con, stmt);
			}

		}
		
}
