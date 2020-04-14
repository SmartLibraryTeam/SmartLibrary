package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

import gui.SceltaDisciplinaTesseratoGUI;

import DAO.DisciplinaDAO;
import DAO.UtenteRegistratoDAO;


@SuppressWarnings("serial")
public class HomeTesseratoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeTesseratoGUI frame = new HomeTesseratoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public HomeTesseratoGUI(int id) {
		setTitle("HomeTesserato");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 614, 60);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//DAO CHE RICAVA IL NOME DELL'UTENTE DATO L'ID
		UtenteRegistratoDAO ricavanomeutente = new UtenteRegistratoDAO();
		String nomeUt = ricavanomeutente.getNomeUtente (id).get(0)[0];
	    String cognomeUt=ricavanomeutente.getNomeUtente (id).get(0)[1];
	    System.out.println(nomeUt);
	    System.out.println(cognomeUt); 
	   
		
		JLabel lblNewLabel = new JLabel("BENVENUTO   "+ nomeUt +" "+ cognomeUt+" !");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 25));
		lblNewLabel.setBounds(28, 11, 352, 38);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 82, 298, 84);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnConsultaCalendarioDiscipline = new JButton("CONSULTA ORARIO DISCIPLINE");
		btnConsultaCalendarioDiscipline.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				SceltaDisciplinaTesseratoGUI sceltadisciplina = new  SceltaDisciplinaTesseratoGUI ();
				sceltadisciplina.setVisible(true);
				    
			}
		});
		btnConsultaCalendarioDiscipline.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnConsultaCalendarioDiscipline.setBounds(30, 11, 236, 38);
		panel_1.add(btnConsultaCalendarioDiscipline);
		
		JPanel panel_2 = new JPanel(); 
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 177, 298, 72);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnConsultaCalendarioEventi = new JButton("CONSULTA EVENTI");
		btnConsultaCalendarioEventi.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0)
			{

				SceltaEventoTesseratoGUI sceltaeventotesserato = new SceltaEventoTesseratoGUI(id);
				sceltaeventotesserato.setVisible(true);
			}
		});
		btnConsultaCalendarioEventi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnConsultaCalendarioEventi.setBounds(30, 11, 236, 38);
		panel_2.add(btnConsultaCalendarioEventi);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 286, 298, 72);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnNewButton = new JButton("GESTISCI LE TUE DISCIPLINE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GestioneDisciplineTesseratoGUI gestiscidiscipline = new GestioneDisciplineTesseratoGUI(id);
				gestiscidiscipline.setVisible(true);
			}
		});
		btnNewButton.setBounds(30, 11, 236, 38);
		panel_3.add(btnNewButton);
		btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(10, 369, 298, 72);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JButton btnGestisciITuoi = new JButton("GESTISCI I TUOI EVENTI");
		btnGestisciITuoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				GestioneEventiTesseratoGUI gestiscieventi= new GestioneEventiTesseratoGUI(id);
				gestiscieventi.setVisible(true);		
			}
		});
		btnGestisciITuoi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnGestisciITuoi.setBounds(30, 11, 236, 38);
		panel_4.add(btnGestisciITuoi);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(26, 446, 598, 93);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnRecensisciUnaDisciplina = new JButton("RECENSISCI UNA DISCIPLINA");
		
		btnRecensisciUnaDisciplina.setBounds(10, 38, 578, 38);
		panel_5.add(btnRecensisciUnaDisciplina);
		
		JLabel lblSeiSoddisfattoDella = new JLabel("Sei soddisfatto della disciplina che pratichi? D\u00EC la tua!");
		lblSeiSoddisfattoDella.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSeiSoddisfattoDella.setBounds(156, 11, 326, 14);
		panel_5.add(lblSeiSoddisfattoDella);
		
		
		LoginGUI logingui = new LoginGUI();
		String path1 =logingui.DirectoryProgramma+"/img/imgSistem/calendar.png";
		String path2 =logingui.DirectoryProgramma+"/img/imgSistem/eventi.png";
		String path3 =logingui.DirectoryProgramma+"/img/imgSistem/iscrizionetesserato.png";
		
		
		JLabel label = new JLabel("");
		ImageIcon image1 = new ImageIcon(path1);
		Image IMAGE1 = image1.getImage();
		IMAGE1 = IMAGE1.getScaledInstance(122, 93, IMAGE1.SCALE_REPLICATE);
		image1.setImage(IMAGE1);
		label.setIcon(image1);
		label.setBounds(365, 82, 122, 93);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		ImageIcon image2 = new ImageIcon(path2);
		Image IMAGE2 = image2.getImage();
		IMAGE2 = IMAGE2.getScaledInstance( 122, 102, IMAGE2.SCALE_REPLICATE);
		image2.setImage(IMAGE2);
		label_1.setIcon(image2);
		label_1.setBounds(470, 147, 122, 102);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		ImageIcon image3 = new ImageIcon(path3);
		Image IMAGE3 = image3.getImage();
		IMAGE3 = IMAGE3.getScaledInstance( 144, 128, IMAGE3.SCALE_REPLICATE);
		image3.setImage(IMAGE3);
		label_2.setIcon(image3);
		label_2.setBounds(394, 288, 144, 128);
		contentPane.add(label_2);
		
		
		
		btnRecensisciUnaDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DisciplinaDAO ricavaiddiscipline = new DisciplinaDAO();
				int lunghezza = ricavaiddiscipline.getidDisciplineTesserato(id).size();
				if(lunghezza==0)
				{
					
					JFrame nessunadisciplinarecensibile = new JFrame();
					JOptionPane.showMessageDialog( nessunadisciplinarecensibile,"NON PUOI RECENSIRE ANCORA ALCUNA DISCIPLINA");
				}
				else
				{
				
				    CreaTestimonianzaGUI crearecensione = new CreaTestimonianzaGUI(id);
				    crearecensione.setVisible(true);
				}
			}
		});
		
	}
}
