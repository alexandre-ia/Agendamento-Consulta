package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import View.panels.TelaAgendamentoConsulta;
import View.panels.TelaCadastroMedico;
import View.panels.TelaCadastroPaciente;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Sistema de Agendamento de Consultas");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1029, 812);
		setLocationRelativeTo(null); // Centraliza
		setResizable(false); // Impede redimensionamento

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		JLabel lblNewLabel = new JLabel("Clinica UniFam");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(391, 22, 151, 37);
		contentPane.add(lblNewLabel);

		JTabbedPane tabs = new JTabbedPane();
		tabs.setBounds(10, 53, 953, 709);
		tabs.addTab("Pacientes", new TelaCadastroPaciente());
		tabs.addTab("Médicos", new TelaCadastroMedico());
		tabs.addTab("Consultas", new TelaAgendamentoConsulta());
		contentPane.add(tabs);
	}
}
