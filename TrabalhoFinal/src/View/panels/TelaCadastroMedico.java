package View.panels;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class TelaCadastroMedico extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textNome;
	private JTextField textCrm;
	private JTextField textEspecialidade;
	private JTextField textSexo;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TelaCadastroMedico() {
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
				"Nome Completo", "CRM", "Especialidade", "Sexo"
			}
		));

	}

}
