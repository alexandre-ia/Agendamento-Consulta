package View.panels;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class TelaCadastroPaciente extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textCpf;
	private JTextField textTelefone;
	private JTextField textEmail;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaCadastroPaciente() {
		setLayout(null);
		
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
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPacientes.setBounds(413, 228, 121, 13);
		add(lblPacientes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 269, 888, 320);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome Completo", "CPF", "Telefone", "E-mail"
			}
		));
	}
}
