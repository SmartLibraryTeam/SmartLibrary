package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

import DAO.DisciplinaDAO;
import DAO.LezioneDAO;
import DAO.UtenteRegistratoDAO;

import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;

public class GestioneTurnoGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;
    public String Nome;
	public String Cognome;
	public int iddisciplina;
	public int id;
	public int idlezione;
	public JComboBox comboBox;
	public String Giorno;
	public String Ora;
	/**

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneTurnoGUI frame = new GestioneTurnoGUI();
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
	public GestioneTurnoGUI(String giorno, String ora)  {
		Giorno = giorno;
		Ora = ora;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 320, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 11, 304, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblTurno = new JLabel("TURNO:  " + " " + giorno + " " +  ora );
		lblTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblTurno.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		lblTurno.setBounds(38, 11, 209, 29);
		panel.add(lblTurno);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 55, 304, 111);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNumeroIscritti = new JLabel("NUMERO ISCRITTI:");
		lblNumeroIscritti.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNumeroIscritti.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroIscritti.setBounds(82, 0, 125, 30);
		panel_1.add(lblNumeroIscritti);
		
		
		//Ricaviamo l'id della lezione 
		//DAO CHE PRENDE IL GIORNO E L'ORA E RESTITUISCE L'ID DELLA LEZIONE 
		LezioneDAO letturaidlezione = new LezioneDAO();
		idlezione = Integer.parseInt(letturaidlezione.getIDLezioneGiornoOra( giorno, ora).get(0)[0]);
		System.out.println(idlezione);
		
		//Ricaviamo gli id dei tesserati iscritti alla lezione 
		//DAO CHE PRENDE L'ID DELLA LEZIONE E RESTITUISCE UN VETTORE DI ARRAY DI STRINGHE CONTENENTE GLI ID DEGLI ISCRITTI
		DisciplinaDAO ricavaidiscritti = new DisciplinaDAO();
		Vector<String[]> idIscritti = ricavaidiscritti.getIDIscrittiLezioneDisciplina (idlezione);
		int lunghezza = idIscritti.size();
		String numeroiscritti = Integer.toString(lunghezza) ;
		System.out.println(numeroiscritti);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(105, 26, 78, 22);
		panel_1.add(lblNewLabel);
		//Stampiamo nel label il numero di iscritti
		lblNewLabel.setText(numeroiscritti);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(0, 173, 304, 177);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		/*JLabel lblAggiungiIscritto = new JLabel("AGGIUNGI ISCRITTO:");
		lblAggiungiIscritto.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblAggiungiIscritto.setHorizontalAlignment(SwingConstants.CENTER);
		lblAggiungiIscritto.setBounds(83, 11, 134, 28);
		panel_2.add(lblAggiungiIscritto);*/
		
		
		
		/*POPOLIAMO LA COMBOBOX CON I TESSERATI CHE HANNO RICHIESTO L'ISCRIZIONE ALLA LEZIONE MA NON SONO ANCORA STATI ACCETTATI
		 *  E PER I QUALI QUINDI L'ISCRIZIONE ALLA DISCIPLINA HA STATOPAGAMENTO PAGATO E STATO NEGATO */
		
		
		/*Dao che prende l'id della lezione e restituisce gli id dei tesserati che hanno richiesto l'iscrizione alla lezione,
		  ma non sono ancora stati accettati*/
		DisciplinaDAO ricavaid = new DisciplinaDAO();
		Vector<String[]> idNonIscritti = ricavaidiscritti.getIDIscrittiNonAccettatiLezioneDisciplina (idlezione);
		
		
		//Ricaviamo il nome e il cognome degli iscritti
		
		
		int lunghezza1 = idNonIscritti.size();
		System.out.println("lunghezza è : " + lunghezza1);
		int y = 0;
		
		
	    UtenteRegistratoDAO ricavanome = new UtenteRegistratoDAO();
		
		if (idNonIscritti.size() == 0 )
		{
			JLabel lblAggiungiIscritto = new JLabel("<html> Nessun tesserato ha richiesto <br> l'iscrizione a quest'evento <html>");
			lblAggiungiIscritto.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
			lblAggiungiIscritto.setHorizontalAlignment(SwingConstants.CENTER);
			lblAggiungiIscritto.setBounds(80, 10, 150, 50);
			panel_2.add(lblAggiungiIscritto);
			
			
			JButton btnOk = new JButton("OK");
			
			btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
			btnOk.setBounds(104, 131, 89, 23);
			panel_2.add(btnOk);
			
			btnOk.addActionListener(new ActionListener() 
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					finestra.dispose();
					
					
				}
			});
			
			
		
		}
		
		else
		
		{
			
			JLabel lblAggiungiIscritto = new JLabel("AGGIUNGI ISCRITTO:");
			lblAggiungiIscritto.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			lblAggiungiIscritto.setHorizontalAlignment(SwingConstants.CENTER);
			lblAggiungiIscritto.setBounds(83, 11, 134, 28);
			panel_2.add(lblAggiungiIscritto);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(69, 37, 157, 20);
			panel_2.add(comboBox);
			
			while( y < lunghezza1)
		
			{
			
			
				//DAO CHE PRENDE L'ID DEL TESSERATO E RESTITUISCE IL NOME E IL COGNOME 
				int id1 = Integer.parseInt(idNonIscritti.get(y)[0]);
				System.out.println(id1);
			    Nome = ricavanome.getNomeUtente(id1).get(0)[0];
			    Cognome= ricavanome.getNomeUtente (id1).get(0)[1];
		        System.out.println(Nome);
		        System.out.println(Cognome); 
		        comboBox.addItem(Nome +"  "+ Cognome);
		        y++;
			}    
		      
				
				
				JButton btnOk = new JButton("OK");
				
				btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
				btnOk.setBounds(104, 131, 89, 23);
				panel_2.add(btnOk);
				
				
				btnOk.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent arg0) 
					{
						
						System.out.println("HO CLICCATO");
						//DAO che prende il nome e il cognome e restituisce l'id del tesserato
						
				        Object oggetto = comboBox.getSelectedItem();
						String stringa = oggetto.toString();
						
						String[] nomecognome  = new String[2];
						nomecognome = stringa.split("  ");
						
						String nome = nomecognome[0];
						String cognome = nomecognome[1];
						
						

						UtenteRegistratoDAO ricavanome1 = new UtenteRegistratoDAO();
						int idUTENTE = ricavanome1.getIdFromNomeCognome(nome ,cognome);
				        
						System.out.println("il nome è " + nome);
						System.out.println("il cognome è " + cognome);
						
						
						//DAO che popola il db con la nuova iscrizione
					    DisciplinaDAO aggiuntaiscrizione =  new DisciplinaDAO();
						aggiuntaiscrizione.setIscrizione(idUTENTE, idlezione);
						
						
						JFrame iscrizioneavvenuta = new JFrame();
						JOptionPane.showMessageDialog(iscrizioneavvenuta ,"L'UTENTE E' STATO AGGIUNTO ALLA LISTA DEGLI ISCRITTI AL TURNO");
						
						finestra.dispose();
					
						
						GestioneTurnoGUI gestisciturno1 = new GestioneTurnoGUI(Giorno, Ora);
						gestisciturno1.setVisible(true);
						
					}
				
				
				
				});

		}
				
				
		    
		JButton btnNewButton = new JButton("Clicca qui per visionare la lista degli iscritti");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ListaIscrittiLezioneDisciplinaGUI listaiscritti = new ListaIscrittiLezioneDisciplinaGUI (idIscritti);
				listaiscritti.setVisible(true);		
	        }
		});
		btnNewButton.setBounds(10, 60, 284, 37);
		panel_1.add(btnNewButton);
		
	
	}
}
	
		