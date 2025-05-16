package View.panels;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import Classes.Paciente;
import Controller.PacienteController;
import dao.PacienteDAO;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaCadastroPaciente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTable tablePacientes;

	/**
	 * Create the panel.
	 */
	public TelaCadastroPaciente() {
		setLayout(null);

		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPacientes.setBounds(413, 262, 121, 13);
		add(lblPacientes);

		JScrollPane JTablePacientes = new JScrollPane();
		JTablePacientes.setBounds(28, 401, 898, 320);
		add(JTablePacientes);

		tablePacientes = new JTable();
		JTablePacientes.setViewportView(tablePacientes);
		tablePacientes.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome Completo", "CPF", "Telefone", "E-mail" }));

		readJTable();
		DefaultTableModel modelo = (DefaultTableModel) tablePacientes.getModel();
		tablePacientes.setRowSorter(new TableRowSorter(modelo));
		
		
		//Mnadar dados selecionados para os campos
		tablePacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tablePacientes.getSelectedRow() != -1){
					textNome.setText(tablePacientes.getValueAt(tablePacientes.getSelectedRow(), 1).toString());
					textCpf.setText(tablePacientes.getValueAt(tablePacientes.getSelectedRow(), 2).toString());
					textTelefone.setText(tablePacientes.getValueAt(tablePacientes.getSelectedRow(), 3).toString());
					textEmail.setText(tablePacientes.getValueAt(tablePacientes.getSelectedRow(), 4).toString());
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um paciente");
				}
			}
		});
		
		tablePacientes.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				if (tablePacientes.getSelectedRow() != -1) {
					try {
						String nome = textNome.getText();
						String cpf = textCpf.getText();
						String telefone = textTelefone.getText();
						String email = textEmail.getText();
						Paciente paciente = new Paciente(cpf, nome, email, telefone);
						paciente.setId((int) tablePacientes.getValueAt(tablePacientes.getSelectedRow(), 0));

						PacienteController controller = new PacienteController();
						limparCampos();
						controller.atualizarPaciente(paciente);

					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}finally {
					limparCampos();
					}
				}
			}
		});

		JLabel lblNewLabel = new JLabel("Cadastro");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(413, 29, 121, 13);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome Completo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(28, 67, 88, 13);
		add(lblNewLabel_1);

		textNome = new JTextField();
		textNome.setBounds(384, 62, 466, 25);
		add(textNome);
		textNome.setColumns(10);

		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(384, 97, 466, 25);
		add(textCpf);

		textTelefone = new JTextField();
		textTelefone.setColumns(10);
		textTelefone.setBounds(384, 132, 466, 25);
		add(textTelefone);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(384, 167, 466, 25);
		add(textEmail);

		JLabel lblNewLabel_1_1 = new JLabel("CPF");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(28, 103, 88, 13);
		add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Telefone");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(28, 138, 88, 13);
		add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_3 = new JLabel("E-mail");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1_3.setBounds(28, 173, 88, 13);
		add(lblNewLabel_1_3);

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

		//Cadastrar
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String nome = textNome.getText();
					String cpf = textCpf.getText();
					String telefone = textTelefone.getText();
					String email = textEmail.getText();

					Paciente paciente = new Paciente(cpf, nome, email, telefone);
					PacienteController controller = new PacienteController();
					controller.cadastrarPaciente(paciente);
					limparCampos();
					readJTable();

				} catch (Exception e1) {

					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Erro ao Cadastrar");
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCadastrar.setBounds(620, 203, 102, 23);
		add(btnCadastrar);

		//Atualizar
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tablePacientes.getSelectedRow() != -1) {
					try {
						String nome = textNome.getText();
						String cpf = textCpf.getText();
						String telefone = textTelefone.getText();
						String email = textEmail.getText();
						Paciente paciente = new Paciente(cpf, nome, email, telefone);
						paciente.setId((int) tablePacientes.getValueAt(tablePacientes.getSelectedRow(), 0));

						PacienteController controller = new PacienteController();
						limparCampos();
						controller.atualizarPaciente(paciente);
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
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(28, 350, 89, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Excluir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tablePacientes.getSelectedRow() != -1) {
					try {
						Paciente paciente = new Paciente();
						paciente.setId((int) tablePacientes.getValueAt(tablePacientes.getSelectedRow(), 0));

						PacienteController controller = new PacienteController();
						limparCampos();
						controller.excluirPaciente(paciente);
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(154, 350, 89, 23);
		add(btnNewButton_1);
	}

	public void readJTable() {
		DefaultTableModel modelo = (DefaultTableModel) tablePacientes.getModel();
		PacienteDAO pacienteDAO = new PacienteDAO();
		modelo.setNumRows(0);

		try {
			for (Paciente p : PacienteDAO.read()) {

				modelo.addRow(new Object[] { p.getId(), p.getNome(), p.getCpf(), p.getTelefone(), p.getEmail() });

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void limparCampos() {
		textNome.setText("");
		textCpf.setText("");
		textEmail.setText("");
		textTelefone.setText("");
	}
}
