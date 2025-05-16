package Controller;

import java.sql.SQLException;
import java.util.List;

import Classes.Medico;
import Classes.Paciente;
import dao.MedicoDAO;


public class MedicoController {
	private MedicoDAO medicoDAO;
	
	 public MedicoController() {
	        // Aqui você precisa instanciar
	        this.medicoDAO = new MedicoDAO(); 
	    }

    public void cadastrarMedico(Medico medico) throws SQLException {
        this.medicoDAO.salvar(medico);
    }
    
    public void atualizarMedico(Medico medico)throws SQLException{
    	medicoDAO.update(medico);
    }
    
    public void excluirMedico(Medico medico)throws SQLException{
    	medicoDAO.delete(medico);
    }


    /*
    public List<Medico> listarProdutos() {
        return this.medicoDAO.listarTodos();
    }
    */
}
