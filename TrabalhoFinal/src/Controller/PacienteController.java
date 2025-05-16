package Controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Classes.Paciente;
import dao.MedicoDAO;
import dao.PacienteDAO;


public class PacienteController {
	private  PacienteDAO pacienteDAO;
	private List<Paciente> clientes = new ArrayList<>();
	
	public PacienteController() {
        // Aqui você precisa instanciar
        this.pacienteDAO = new PacienteDAO(); 
    }

	

    public void cadastrarPaciente(Paciente paciente) throws SQLException {
        pacienteDAO.salvar(paciente);
    }
    
    public void atualizarPaciente(Paciente paciente)throws SQLException{
    	pacienteDAO.update(paciente);
    }
    
    public void excluirPaciente(Paciente paciente)throws SQLException{
    	pacienteDAO.delete(paciente);
    }

    
   /* public List<Paciente> listarClientes() {
        return pacienteDAO.lerTodas();
    }
    */
}



