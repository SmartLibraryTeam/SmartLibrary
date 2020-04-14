package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


import DAO.UtenteRegistratoDAO;

import gui.GestioneDisciplineGUI;
import java.awt.Color;



public class HomeResponsabileCentroGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeResponsabileCentroGUI frame = new HomeResponsabileCentroGUI();
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
	public HomeResponsabileCentroGUI(int id) {
		setTitle("HomeResponsabileCentro");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 372);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 51);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//DAO CHE RICAVA IL NOME DELL'UTENTE DATO L'ID
		UtenteRegistratoDAO ricavanomeutente = new UtenteRegistratoDAO();
		String nomeUt = ricavanomeutente.getNomeUtente (id).get(0)[0];
	    String cognomeUt=ricavanomeutente.getNomeUtente (id).get(0)[1];
	    System.out.println(nomeUt);
	    System.out.println(cognomeUt); 
	   
		JLabel lblNewLabel = new JLabel("BENVENUTO  "+ nomeUt +"  "+ cognomeUt +" !");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 25));
		lblNewLabel.setBounds(24, 11, 364, 29);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(20, 79, 243, 65);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("GESTISCI LE DISCIPLINE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				GestioneDisciplineGUI gestionediscipline = new GestioneDisciplineGUI(id);
				gestionediscipline.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 11, 221, 43);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(20, 168, 376, 65);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnGestisciNuoveIscrizioni = new JButton("GESTISCI LE NUOVE ISCRIZIONI ALLE DISCIPLINE E AGLI EVENTI");
		
		btnGestisciNuoveIscrizioni.setBounds(10, 11, 338, 43);
		panel_2.add(btnGestisciNuoveIscrizioni);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(20, 258, 243, 64);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnGestisciEventi = new JButton("CONFERMA STATO EVENTI");
		
		btnGestisciEventi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnGestisciEventi.setBounds(10, 11, 223, 42);
		panel_3.add(btnGestisciEventi);
		
		
		btnGestisciNuoveIscrizioni.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		
		
		
		LoginGUI logingui = new LoginGUI();
		String path1 =logingui.DirectoryProgramma+"/img/imgSistem/responsabile.png";
		String path2 =logingui.DirectoryProgramma+"/img/imgSistem/iscrizioni.png";
		String path3 =logingui.DirectoryProgramma+"/img/imgSistem/eventi.png";
	
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon image1 = new ImageIcon(path1);
		Image IMAGE1 = image1.getImage();
		IMAGE1 = IMAGE1.getScaledInstance( 89, 86, IMAGE1.SCALE_REPLICATE);
		image1.setImage(IMAGE1);
		lblNewLabel_1.setIcon(image1);
		lblNewLabel_1.setBounds(314, 73, 89, 86);
		contentPane.add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		ImageIcon image2 = new ImageIcon(path2);
		Image IMAGE2 = image2.getImage();
		IMAGE2 = IMAGE2.getScaledInstance( 89, 86, IMAGE2.SCALE_REPLICATE);
		image2.setImage(IMAGE2);
		label.setIcon(image2);
		label.setBounds(431, 143, 89, 86);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		
		
		ImageIcon image3 = new ImageIcon(path3);
		Image IMAGE3 = image3.getImage();
		IMAGE3 = IMAGE3.getScaledInstance( 89, 86, IMAGE3.SCALE_REPLICATE);
		image3.setImage(IMAGE3);
		label_1.setIcon(image3);
		label_1.setBounds(314, 236, 89, 86);
		contentPane.add(label_1);
		btnGestisciNuoveIscrizioni.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				GestioneIscrizioniResponsabileCentroGUI gestioneiscrizione = new GestioneIscrizioniResponsabileCentroGUI();
				gestioneiscrizione.setVisible(true);
			
			}
		});
		
		
		btnGestisciEventi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SceltaEventoConfermaGUI sceltaevento = new SceltaEventoConfermaGUI();
				sceltaevento.setVisible(true);
			}
		});
		
		
		
	}





}
