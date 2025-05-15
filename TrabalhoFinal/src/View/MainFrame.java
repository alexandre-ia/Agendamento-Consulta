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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setTitle("Sistema de Agendamento de Consultas");
        setSize(987, 720);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        contentPane.setLayout(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.setBounds(10, 53, 953, 571);
        tabs.addTab("Pacientes", new TelaCadastroPaciente());
        tabs.addTab("Médicos", new TelaCadastroMedico());
        tabs.addTab("Consultas", new TelaAgendamentoConsulta());

        getContentPane().add(tabs);
        
        JLabel lblNewLabel = new JLabel("Clinica UniFam");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(391, 22, 151, 37);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Salvar");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton.setBounds(313, 634, 85, 21);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("Limpar");
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_1.setBounds(510, 634, 85, 21);
        contentPane.add(btnNewButton_1);
	}
}
