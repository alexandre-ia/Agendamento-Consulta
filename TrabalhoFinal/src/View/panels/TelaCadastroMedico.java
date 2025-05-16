package View.panels;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Classes.Medico;
import Classes.Paciente;
import Controller.MedicoController;
import Controller.PacienteController;
import dao.MedicoDAO;
import dao.PacienteDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroMedico extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textCrm;
	private JTextField textEspecialidade;
	private JTextField textSexo;
	private JTable tableMedico;

	/**
	 * Create the panel.
	 */
	public TelaCadastroMedico() {
		setLayout(null);
		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(413, 29, 121, 13);
		add(lblNewLabel);
		tableMedico = new JTable();
		
		tableMedico.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "Id", "Nome Completo", "CRM", "Especialidade", "Sexo" }));
		readJTable();
		
		//Mandar Linha selecionada para campos
		JScrollPane scrollPane = new JScrollPane(tableMedico);
		tableMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tableMedico.getSelectedRow() != -1){
					textNome.setText(tableMedico.getValueAt(tableMedico.getSelectedRow(), 1).toString());
					textCrm.setText(tableMedico.getValueAt(tableMedico.getSelectedRow(), 2).toString());
					textEspecialidade.setText(tableMedico.getValueAt(tableMedico.getSelectedRow(), 3).toString());
					textSexo.setText(tableMedico.getValueAt(tableMedico.getSelectedRow(), 4).toString());
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um medico");
				}
			}
		});
		scrollPane.setBounds(28, 401, 898, 320);
		add(scrollPane);

		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(28, 67, 88, 13);
		add(lblNewLabel_1);

		textNome = new JTextField();
		textNome.setBounds(384, 62, 466, 25);
		add(textNome);
		textNome.setColumns(10);

		textCrm = new JTextField();
		textCrm.setColumns(10);
		textCrm.setBounds(384, 97, 466, 25);
		add(textCrm);

		textEspecialidade = new JTextField();
		textEspecialidade.setColumns(10);
		textEspecialidade.setBounds(384, 132, 466, 25);
		add(textEspecialidade);

		textSexo = new JTextField();
		textSexo.setColumns(10);
		textSexo.setBounds(384, 167, 466, 25);
		add(textSexo);

		JLabel lblNewLabel_1_1 = new JLabel("CRM");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(28, 103, 88, 13);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Especialidade");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(28, 138, 88, 13);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("Sexo");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(28, 173, 88, 13);
		add(lblNewLabel_1_3);

		JLabel lblPacientes = new JLabel("Medicos");
		lblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPacientes.setBounds(413, 262, 121, 13);
		add(lblPacientes);

		//Cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String nome = textNome.getText();
					String crm = textCrm.getText();
					String especialidade = textEspecialidade.getText();
					String sexo = textSexo.getText();

					Medico medico = new Medico(nome, crm, especialidade, sexo);
					MedicoController controller = new MedicoController();

					controller.cadastrarMedico(medico);
					limparCampos();
					readJTable();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(620, 203, 102, 23);
		add(btnCadastrar);

		//Limpar
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparCampos();
			}
		});
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLimpar.setBounds(748, 203, 102, 23);
		add(btnLimpar);

		//Atualizar
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableMedico.getSelectedRow() != -1) {
					try {
						String nome = textNome.getText();
						String crm = textCrm.getText();
						String eespecialidade = textEspecialidade.getText();
						String sexo = textSexo.getText();
						Medico medico = new Medico(nome, crm, eespecialidade, sexo);
						medico.setId((int) tableMedico.getValueAt(tableMedico.getSelectedRow(), 0));

						MedicoController controller = new MedicoController();
						limparCampos();
						controller.atualizarMedico(medico);
						readJTable();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} finally {
						limparCampos();
					}
				}
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAtualizar.setBounds(28, 350, 89, 23);
		add(btnAtualizar);

		//Excluir
		JButton btnExluir = new JButton("Excluir");
		btnExluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tableMedico.getSelectedRow() != -1) {
					try {
						Medico medico = new Medico();
						medico.setId((int) tableMedico.getValueAt(tableMedico.getSelectedRow(), 0));

						MedicoController controller = new MedicoController();
						limparCampos();
						controller.excluirMedico(medico);
						readJTable();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
					limparCampos();
					}
				}
			}
		});
		btnExluir.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExluir.setBounds(154, 350, 89, 23);
		add(btnExluir);

	}
	
	//Carregar JTable

	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tableMedico.getModel();
		MedicoDAO pacienteDAO = new MedicoDAO();
		modelo.setNumRows(0);

		try {
			for (Medico m : MedicoDAO.read()) {

				modelo.addRow(new Object[] { m.getId(), m.getNome(), m.getCrm(), m.getEspecialidade(), m.getSexo() });

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Limpaar campos
	public void limparCampos() {
		textNome.setText("");
		textCrm.setText("");
		textEspecialidade.setText("");
		textSexo.setText("");
	}

}
