package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.TestimonianzaDAO;

import gui.LoginGUI;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Color;



public class CreaTestimonianzaGUI extends JFrame {

	
	private JPanel contentPane;
	public JFrame finestra = this ;
	public String percorso;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreaTestimonianzaGUI frame = new CreaTestimonianzaGUI();
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
	public CreaTestimonianzaGUI (int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 484);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LoginGUI login = new LoginGUI();
		percorso = login.DirectoryProgramma;
		
		System.out.println(percorso);
		
		
		
		//RICAVO DISCIPLINE RECENSIBILI
		
		DisciplinaDAO  ricava = new DisciplinaDAO ();
	
		
		
		
		JLabel lblInserisciLaTua = new JLabel("INSERISCI LA TUA TESTIMONIANZA:");
		lblInserisciLaTua.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		lblInserisciLaTua.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciLaTua.setBounds(10, 11, 414, 24);
		contentPane.add(lblInserisciLaTua);
		
		JLabel lblScegliLaDisciplina = new JLabel("Scegli la Disciplina:");
		lblScegliLaDisciplina.setBounds(20, 43, 404, 14);
		contentPane.add(lblScegliLaDisciplina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 68, 398, 24);
		contentPane.add(comboBox);
		
		//POPOLO COMBOBOX DISCIPLINE RECENSIBILI
		
		
		for (int i =0; i< ricava.getidDisciplineTesserato(id).size() ;i++) 
		{
		    DisciplinaDAO  ricavanome = new DisciplinaDAO ();
			String NOME = ricavanome.getNomeDisciplina(Integer.parseInt(ricava.getidDisciplineTesserato(id).get(i)[0])).get(0)[0];
			
		    DisciplinaDAO  ricavalivello = new DisciplinaDAO();
			String LIVELLO = ricavalivello.getLivelloDisciplina(Integer.parseInt(ricava.getidDisciplineTesserato(id).get(i)[0])).get(0)[0];
			
			comboBox.addItem(NOME +"  "+LIVELLO);
			
		}
		
		
		JLabel lblScriviCosaPensi = new JLabel("Scrivi cosa pensi della nostra disciplina:");
		lblScriviCosaPensi.setBounds(20, 103, 404, 14);
		contentPane.add(lblScriviCosaPensi);
		
		JLabel lblDacciUnVoto = new JLabel("Dacci un voto!");
		lblDacciUnVoto.setBounds(58, 308, 79, 24);
		contentPane.add(lblDacciUnVoto);
		
		JComboBox comboBox_1 = new JComboBox();
		
		
		comboBox_1.addItem("1");
		comboBox_1.addItem("2");
		comboBox_1.addItem("3");
		comboBox_1.addItem("4");
		comboBox_1.addItem("5");
		
		comboBox_1.setBounds(10, 354, 185, 24);
		contentPane.add(comboBox_1);
		
		JLabel faccina = new JLabel("");
		faccina.setBounds(224, 308, 163, 126);
		contentPane.add(faccina);
	
		
		
		JButton btnNewButton = new JButton("INSERISCI TESTIMONIANZA");
		
		btnNewButton.setBounds(10, 394, 204, 40);
		contentPane.add(btnNewButton);
		
		
		JEditorPane testo = new JEditorPane();
		testo.setBounds(115, 128, 206, 110);
		contentPane.add(testo);
		
		JScrollPane barra = new JScrollPane(testo);
		barra.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		barra.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		barra.setBounds(10, 128, 398, 169);
		contentPane.add(barra);
		
		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object oggetto = comboBox_1.getSelectedItem();
				String valore = oggetto.toString();
				
				if(valore.equals("1"))
				{
					//ADATTAMENTO IMMAGINE AL LABEL
					
					String path = percorso + "/img/voti/1.jpg";
					ImageIcon image = new ImageIcon(path);
					Image IMAGE = image.getImage();
					IMAGE = IMAGE.getScaledInstance( 163, 126, IMAGE.SCALE_REPLICATE);
					image.setImage(IMAGE);
					faccina.setIcon(image);
				}
				if(valore.equals("2"))
				{
					String path = percorso + "/img/voti/2.jpg";
					ImageIcon image = new ImageIcon(path);
					Image IMAGE = image.getImage();
					IMAGE = IMAGE.getScaledInstance( 163, 126, IMAGE.SCALE_REPLICATE);
					image.setImage(IMAGE);
					faccina.setIcon(image);
				}
				if(valore.equals("3"))
				{
					String path = percorso + "/img/voti/3.jpg";
					ImageIcon image = new ImageIcon(path);
					Image IMAGE = image.getImage();
					IMAGE = IMAGE.getScaledInstance( 163, 126, IMAGE.SCALE_REPLICATE);
					image.setImage(IMAGE);
					faccina.setIcon(image);
				}
				if(valore.equals("4"))
				{
					String path = percorso + "/img/voti/4.png";
					ImageIcon image = new ImageIcon(path);
					Image IMAGE = image.getImage();
					IMAGE = IMAGE.getScaledInstance( 163, 126, IMAGE.SCALE_REPLICATE);
					image.setImage(IMAGE);
					faccina.setIcon(image);
				}
				if(valore.equals("5"))
				{
					String path = percorso + "/img/voti/5.jpg";
					ImageIcon image = new ImageIcon(path);
					Image IMAGE = image.getImage();
					IMAGE = IMAGE.getScaledInstance( 163, 126, IMAGE.SCALE_REPLICATE);
					image.setImage(IMAGE);
					faccina.setIcon(image);
				}
				
			}
		});
		
		//AGGIUNGO TESTIMONIANZA 
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				//RICAVO DATI PER QUERY
				Object oggetto = new Object();
				oggetto = comboBox.getSelectedItem();
				String stringa = oggetto.toString();
				
				Object oggetto1 = new Object();
				oggetto1 = comboBox_1.getSelectedItem();
				String stringa1 = oggetto1.toString();
				
				int voto = Integer.parseInt(stringa1);
			
				String nome = stringa.split("  ")[0];
				String livello = stringa.split("  ")[1];
				
				DisciplinaDAO ricavaidDisc = new DisciplinaDAO ();
				int idDisc =Integer.parseInt(ricavaidDisc.getIdDisciplinafromNameandLivello(nome, livello).get(0)[0]);
				
				String Testimonianza = testo.getText();
				
				System.out.println("nome : " + nome);
				System.out.println("livello : " + livello);
				System.out.println("testimonianza : " + Testimonianza);
				
				//INSERISCO TESTIMONIANZA
				
				TestimonianzaDAO aggiunta = new TestimonianzaDAO();
				aggiunta.createTestimonianza(id, idDisc, Testimonianza, voto);
				
				
				JFrame testimonianzaaggiunta = new JFrame();
				JOptionPane.showMessageDialog(testimonianzaaggiunta,"<html>LA TESTIMONIANZA E' STATA AGGIUNTA CORRETTAMENTE!<br>Grazie per averla inserita!<html>");
				
				finestra.dispose();
			}
		});
		
		
		
		
	}
}



