package gui;


import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.DirectoryCorrente;

import listener.LoginListener;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

import gui.SceltaDisciplinaEventoConsultareGUI;


@SuppressWarnings("serial")
public class LoginGUI extends JFrame 
{
	
	private JPanel contentPane;
	public JTextField textField;
	public JPasswordField passwordField;
	
	//RICAVO LA DIRECTORY DOVE E' ESEGUITO IL PROGRAMMA E LA SCRIVO NEL FILE "percorsoprogramma"
	public DirectoryCorrente percorsoProgramma = new DirectoryCorrente();
	public String DirectoryProgramma = percorsoProgramma.getDir().replace("\\", "/");
	
	
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) 
{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
}*/

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	public LoginGUI() 
	{
		/*//RICAVO LA DIRECTORY DOVE E' ESEGUITO IL PROGRAMMA E LA SCRIVO NEL FILE "percorsoprogramma"
		DirectoryCorrente percorsoProgramma = new DirectoryCorrente();
		String DirectoryProgramma = percorsoProgramma.getDir().replace("\\", "/");
		*/
		
		
		
		setBackground(new Color(0, 0, 255));
		setFont(new Font("Arial", Font.PLAIN, 12));
		setTitle("LOGIN\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 494);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		String path1 =DirectoryProgramma+"/img/imgSistem/immagine1.jpg";
		String path2 =DirectoryProgramma+"/img/imgSistem/immagine2.jpg";
		String path3 =DirectoryProgramma+"/img/imgSistem/immagine3.jpg";
		String pathLOGO =DirectoryProgramma+"/img/imgSistem/logo.png";
		
		JPanel pannelloBenvenuto = new JPanel();
		pannelloBenvenuto.setBackground(Color.WHITE);
		pannelloBenvenuto.setBounds(10, 11, 664, 113);
		contentPane.add(pannelloBenvenuto);
		pannelloBenvenuto.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(pathLOGO));
		label.setBounds(169, 11, 321, 91);
		pannelloBenvenuto.add(label);
		
		JPanel pannelloConsulta = new JPanel();
		pannelloConsulta.setBackground(Color.WHITE);
		pannelloConsulta.setBounds(10, 132, 342, 67);
		contentPane.add(pannelloConsulta);
		pannelloConsulta.setLayout(null);
		
		JButton BottoneConsulta = new JButton("CONSULTA LE NOSTRE DISCIPLINE E I NOSTRI EVENTI");
		BottoneConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SceltaDisciplinaEventoConsultareGUI sceltadisciplinaevento = new SceltaDisciplinaEventoConsultareGUI();
				sceltadisciplinaevento.setVisible(true);
			}
		});
		BottoneConsulta.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		BottoneConsulta.setBounds(10, 11, 301, 53);
		pannelloConsulta.add(BottoneConsulta);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 235, 183, -36);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 209, 342, 235);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon image1 = new ImageIcon(path1);
		Image IMAGE1 = image1.getImage();
		IMAGE1 = IMAGE1.getScaledInstance(172, 137, IMAGE1.SCALE_REPLICATE);
		image1.setImage(IMAGE1);
		lblNewLabel.setIcon(image1);
		lblNewLabel.setBounds(10, 87, 172, 137);
		panel_3.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("");
		
		ImageIcon image2 = new ImageIcon(path2);
		Image IMAGE2 = image2.getImage();
		IMAGE2 = IMAGE2.getScaledInstance(172, 137, IMAGE2.SCALE_REPLICATE);
		image2.setImage(IMAGE2);
		label_1.setIcon(image2);
		label_1.setBounds(101, 33, 172, 137);
		panel_3.add(label_1);
		
		JLabel label_2 = new JLabel("");
		
		ImageIcon image3 = new ImageIcon(path3);
		Image IMAGE3 = image3.getImage();
		IMAGE3 = IMAGE3.getScaledInstance(172, 137, IMAGE3.SCALE_REPLICATE);
		image3.setImage(IMAGE3);
		label_2.setIcon(image3);
		label_2.setBounds(192, 0,172, 137);
		panel_3.add(label_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(402, 132, 272, 312);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ACCEDI CON LE TUE CREDENZIALI");
		lblNewLabel_1.setBounds(10, 11, 252, 53);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 65, 30, 22);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblId);
		
		
		
		textField= new JTextField();
		textField.setBounds(88, 67, 158, 20);
		panel_4.add(textField);
		textField.setColumns(10);
		

		
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(0, 116, 73, 22);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblPassword);
		
		passwordField = new JPasswordField();
		
		passwordField.setBounds(88, 116, 158, 22);
		panel_4.add(passwordField);
		
		JButton btnConferma = new JButton("CONFERMA");
		btnConferma.setBounds(157, 168, 89, 23);
		btnConferma.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		panel_4.add(btnConferma);
		
		JButton btnNonSeiAncora = new JButton("Non sei ancora regitrato? Registrati!");
		//APRE FNESTRA REGISTRAZIONE
		btnNonSeiAncora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistrazioneGUI registrazionegui = new RegistrazioneGUI();
				registrazionegui.setVisible(true);
			}
		});
		btnNonSeiAncora.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 12));
		btnNonSeiAncora.setBounds(26, 237, 220, 53);
		panel_4.add(btnNonSeiAncora);
		
		JLabel IDFeedback = new JLabel("\r\n");
		IDFeedback.setBounds(200, 91, 46, 14);
		panel_4.add(IDFeedback);
		
		JLabel PasswordFeedback = new JLabel("");
		PasswordFeedback.setBounds(200, 143, 46, 14);
		panel_4.add(PasswordFeedback);
		
		
		
	
	btnConferma.addActionListener(new LoginListener(this));
	
	
	
	
	
	
	
	
	
	
	}
}