package gui;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UtenteRegistratoDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class ListaIscrittiLezioneDisciplinaGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaIscrittiLezioneDisciplinaGUI frame = new ListaIscrittiLezioneDisciplinaGUI();
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
	public ListaIscrittiLezioneDisciplinaGUI (Vector<String[]> idIscritti ){
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 250, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 214, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblListaIscritti = new JLabel("LISTA ISCRITTI:");
		lblListaIscritti.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaIscritti.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		lblListaIscritti.setBounds(46, 11, 121, 19);
		panel.add(lblListaIscritti);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 107, 43, -37);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 60, 214, 340);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		
		//Ricaviamo il nome e il cognome degli iscritti
		//DAO CHE PRENDE L'ID DEL TESSERATO E RESTITUISCE IL NOME E IL COGNOME 
		UtenteRegistratoDAO ricavanome = new UtenteRegistratoDAO();	
		
		//Dichiariamo un intero u, che servirà per settare la dimensione corretta di ogni label creato all'interno del ciclo for
		int u = 0;
		
		//Salviamo la lunghezza del vettore idIscritti che rappresenterà il limite del for
		int lunghezza = idIscritti.size();
		
		//Creiamo un array di label 
		JLabel[] label = new JLabel[lunghezza];
		
		//Stampiamo la lista degli iscritti
		for (int i= 0; i < lunghezza; i++) 
		{
			
		int id = Integer.parseInt(idIscritti.get(i)[0]);
		String nome = ricavanome.getNomeUtente(id).get(0)[0];
		String cognome= ricavanome.getNomeUtente (id).get(0)[1];
	    System.out.println(nome);
	    System.out.println(cognome); 
	    label[i] = new JLabel();
	    label[i].setText((i+1)+". "+nome + " " + cognome );
	    label[i].setBounds (33, 0 + u, 143, 30);
	    panel_2.add(label[i]);
	    u= u + 20;
	   
	    
	     
		}

	}
}
