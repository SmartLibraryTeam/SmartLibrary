package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import listener.RegistrazioneUtenteListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class RegistrazioneGUI extends JFrame {

	private JPanel contentPane;
	public  JTextField textField;
	public JTextField textField_1;
	public JPasswordField passwordField;
	public JTextField textField_2;
	public JTextField textField_3;
	public JPasswordField passwordField_1;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrazioneGUI frame = new RegistrazioneGUI();
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
	public RegistrazioneGUI() {
		setTitle("REGISTRAZIONE");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 72, 210, 178);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(25, 32, 137, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCognome = new JLabel("Et\u00E0\r\n");
		lblCognome.setBounds(25, 63, 46, 14);
		panel.add(lblCognome);
		
		textField_1 = new JTextField();
		textField_1.setBounds(25, 80, 137, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password\r\n");
		lblPassword.setBounds(24, 119, 69, 14);
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(25, 140, 137, 20);
		panel.add(passwordField);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(26, 11, 53, 20);
		panel.add(lblNome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(230, 72, 194, 178);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblCognome_1 = new JLabel("Cognome");
		lblCognome_1.setBounds(32, 11, 94, 14);
		panel_1.add(lblCognome_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(25, 32, 137, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(32, 61, 94, 14);
		panel_1.add(lblTelefono);
		
		textField_3 = new JTextField();
		textField_3.setBounds(25, 80, 137, 20);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblRipetiPassword = new JLabel("Ripeti Password");
		lblRipetiPassword.setBounds(34, 117, 137, 20);
		panel_1.add(lblRipetiPassword);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(25, 140, 137, 20);
		panel_1.add(passwordField_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 414, 45);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblInserisciITuoi = new JLabel("INSERISCI I TUOI DATI PER EFFETTUARE LA REGISTRAZIONE");
		lblInserisciITuoi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblInserisciITuoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciITuoi.setBounds(33, 11, 357, 23);
		panel_2.add(lblInserisciITuoi);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 280, 414, 57);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnConferma = new JButton("CONFERMA\r\n");
		btnConferma.setBounds(156, 11, 100, 35);
		btnConferma.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		panel_3.add(btnConferma);
		
		 btnConferma.addActionListener(new RegistrazioneUtenteListener(this));
	}
	 
	 

}
