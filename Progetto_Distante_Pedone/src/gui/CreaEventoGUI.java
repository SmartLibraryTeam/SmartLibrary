package gui;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


import modelli.Lezione;


import DAO.DisciplinaDAO;
import DAO.EventoDAO;
import DAO.LezioneDAO;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.Color;




	
	/**
	 * Launch the application.
	 */
/*public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() {
				try {
					CreaEventoGUI frame = new CreaEventoGUI();
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
	public class CreaEventoGUI extends JFrame 
	{
		
		public JFrame finestra =  this ;
		public JPanel contentPane;
		public JTextField textField;
		public  String disciplina ;
		public  String livello;
		public String istruttore ;
		public  String responsabile ;
		public String nomeEvento;
		public String tipoEvento;
		public String nomeDisciplina;
		public int idDisc = 0;
        public Boolean controllo = false ;

		
		/**
		 * Launch the application.
		 */
	/*public static void main(String[] args)
		{
			EventQueue.invokeLater(new Runnable() 
			{
				public void run() {
					try {
						CreaEventoGUI frame = new CreaEventoGUI();
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
		public CreaEventoGUI(int id) 
		{
			
			
			setTitle("CreaEvento");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 454, 508);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 11, 428, 49);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JLabel lblInserisciDatiPer = new JLabel("INSERISCI I DATI PER CREARE UN NUOVO EVENTO");
			lblInserisciDatiPer.setHorizontalAlignment(SwingConstants.CENTER);
			lblInserisciDatiPer.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
			lblInserisciDatiPer.setBounds(39, 11, 357, 27);
			panel.add(lblInserisciDatiPer);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setBounds(10, 71, 428, 108);
			contentPane.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblNomeEvento = new JLabel("Nome Evento");
			lblNomeEvento.setBounds(10, 22, 100, 20);
			panel_1.add(lblNomeEvento);
			
			textField = new JTextField();
			textField.setBounds(10, 54, 208, 20);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JLabel lblTipoEvento = new JLabel("Tipo Evento");
			lblTipoEvento.setBounds(257, 22, 100, 20);
			panel_1.add(lblTipoEvento);
			
			JComboBox comboBox_5 = new JComboBox();
			comboBox_5.addItem("Stage");
			comboBox_5.addItem("Gara");
			comboBox_5.setBounds(252, 54, 153, 20);
			panel_1.add(comboBox_5);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBackground(Color.WHITE);
			panel_5.setBounds(10, 285, 428, 91);
			contentPane.add(panel_5);
			panel_5.setLayout(null);
			
			JLabel lblGiorno = new JLabel("Giorno e Ora");
			lblGiorno.setBounds(174, 22, 74, 14);
			panel_5.add(lblGiorno);
			
			JComboBox comboBox_4 = new JComboBox();
			comboBox_4.setBounds(10, 47, 399, 20);
			panel_5.add(comboBox_4);
		
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(10, 190, 428, 84);
			contentPane.add(panel_2);
			panel_2.setLayout(null);
			
			JLabel lblDisciplina = new JLabel("Disciplina");
			lblDisciplina.setBounds(10, 11, 86, 14);
			panel_2.add(lblDisciplina);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(10, 36, 181, 20);
			panel_2.add(comboBox);
			
			JComboBox comboBox_3 = new JComboBox();
			comboBox_3.setBounds(249, 36, 150, 20);
			panel_2.add(comboBox_3);

			JLabel lblLivello = new JLabel("Livello");
			lblLivello.setBounds(322, 11, 46, 14);
			panel_2.add(lblLivello);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.setBounds(10, 387, 428, 60);
			contentPane.add(panel_3);
			panel_3.setLayout(null);
			
			JButton btnConferma = new JButton("CONFERMA");
			btnConferma.setBounds(158, 26, 100, 23);
			panel_3.add(btnConferma);
			btnConferma.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			
		
			
			//DAO CHE POPOLA LA COMBOBOX DISCIPLINA
			
			    DisciplinaDAO letturadiscipline = new DisciplinaDAO();
				
				int y = 0;
				
				int lunghezza = letturadiscipline.getDisciplineIstruttore (id).size();
				
				while( y < lunghezza)
				{
					System.out.println(letturadiscipline.getDisciplineIstruttore (id).get(y)[0]);
					
					comboBox.addItem(letturadiscipline.getDisciplineIstruttore (id).get(y)[0]);
					y++;
				}
			
			
			
			
			 //IN BASE AL VALORE DI DISCIPLINA SI POPOLA LA COMBOBOX DEL LIVELLO 
			comboBox.addActionListener(new ActionListener() 	
			
			{
				
					
				public void actionPerformed(ActionEvent arg0) 
					
				{
					
					DefaultComboBoxModel model = (DefaultComboBoxModel)comboBox_3.getModel();
					model.removeAllElements();
					
				   
					
					//PRELEVIAMO IL VALORE DI DISCIPLINA
					Object selectedItem = new Object();
					selectedItem = comboBox.getSelectedItem();
					nomeDisciplina = selectedItem.toString();
					
					System.out.println("LA DISCIPLINA SCELTA E' :   " + nomeDisciplina);
						
					/*Dao che prende in ingresso il nome della disciplina scelta e restituisce 
					 * l'id dell'istruttore */ 
					/*    
					LetturaIdIstruttore letturaidistruttore = new  LetturaIdIstruttore();
				    
					//SETTA IL VALORE DELLA COMBOBOX DELL'ISTRUTTORE   
					
					String istruttore = letturaidistruttore.getIdIstruttore(nomeDisciplina).get(0)[0];
					System.out.println(istruttore);
					*/
					
						
				
					//DAO CHE PRENDE IL NOME DELLA DISCIPLINA E RICAVA I LIVELLI ( PRENDE STRING E RITORNA VECTOR )
					
				    DisciplinaDAO letturalivellidisciplina = new DisciplinaDAO();
					
					
					
					System.out.println("NUMERO LIVELLI = " + letturalivellidisciplina.getLivelloDisciplina(nomeDisciplina).size() );
					
					int y = 0;
					
					int Lunghezza = letturalivellidisciplina.getLivelloDisciplina(nomeDisciplina).size();
					
					
					
					while( y < letturalivellidisciplina.getLivelloDisciplina(nomeDisciplina).size())
					{
						System.out.println(letturalivellidisciplina.getLivelloDisciplina(nomeDisciplina).get(y)[0]);
						
						comboBox_3.addItem(letturalivellidisciplina.getLivelloDisciplina(nomeDisciplina).get(y)[0]);
						
						y++;
					}
					
					
					controllo = true;
					
					System.out.println("LA variabile controllo è : " + controllo);
					
					
				}
				
				
				
			});
			
			//IN BASE AL VALORE DEL LIVELLO SI POPOLA LA COMBOBOX  GIORNO-ORA
			comboBox_3.addActionListener(new ActionListener() 
		
		  {
			public void actionPerformed(ActionEvent e) 
			{
				 DefaultComboBoxModel model2 = (DefaultComboBoxModel)comboBox_4.getModel();
				 model2.removeAllElements();
				
				
				 if(controllo) 
				  
				 {
				
					 Object selectedItem = new Object();
					 selectedItem = comboBox.getSelectedItem();
					 String nomeDisciplina = new String();
					 nomeDisciplina = selectedItem.toString();
				    
				    
				
					 Object selectedItem3 = new Object();
					 selectedItem3 = comboBox_3.getSelectedItem();
					 String livello = new String();
					 livello = selectedItem3.toString();
				
				
				
					 //PRENDE IN INGRESSO NOME DELLA DISCIPLINA E LIVELLO SCELTI E CALCOLA L'ID DELLA DISCIPLINA
				
				      DisciplinaDAO letturaiddisciplina = new DisciplinaDAO();
						
					  idDisc = letturaiddisciplina.getIdDisciplina(nomeDisciplina, livello); 
					  
					  System.out.println("L'id della disciplina é :" + idDisc );
				
				
					
					  //PRENDE L'ID DELLA DISCIPLINA E RESTITUISCE TUTTI GLI ID DELLE LEZIONI DISPONIBILI
					  LezioneDAO letturaidlezione = new LezioneDAO();
					  Vector<String[]> idlezioni = letturaidlezione.getIDLezione(idDisc);
					  int lunghezza = idlezioni.size();
				      System.out.println("Lunghezza = " + lunghezza);
				
					  //PRENDE L'ID DELLA DISCIPLINA E L'ID DELL'ISTRUTTORE E RESTITUISCE TUTTE LE LEZIONI DI QUELLA DISCIPLINA E DI QUELL'ISTRUTTORE
					 
				      EventoDAO letturaidlezione1 = new EventoDAO();
				      Vector<String[]> idlezioniNonDisponibili = letturaidlezione1.getIDLezioneFromIdIStruttoreAndIdDisciplina(idDisc, id);
				      int lunghezza1 = idlezioniNonDisponibili.size();
				      System.out.println("Lunghezza1 = " + lunghezza1);
				      
				      
				      

				      //Creiamo un array di lezioni, in cui salviamo tutti gli id delle lezioni disponibili 
				     
				      Lezione[] lezioni = new Lezione[lunghezza];
				      
				      for (int i = 0; i< lunghezza; i++)
				      {
				    	  
				    	  Lezione lezione = new Lezione();
				    	  lezioni[i] = new Lezione();
				    	  lezioni[i].setIdLezione(Integer.parseInt(idlezioni.get(i)[0]));
				    	  System.out.println("Lezione " + i + " " + lezioni[i].getIdLezione());
				    	  
				      }
					
				  
				      for(int k =0; k< lunghezza ; k++)
				      {
				    	  System.out.println("Lezione"  + k +" "+lezioni[k].getIdLezione());
				    	  for(int j=0; j< lunghezza1 ; j++)
				    	  {
				    		  if(lezioni[k].getIdLezione() == Integer.parseInt((idlezioniNonDisponibili.get(j)[0])))
				    		  {
				    			  
				    			  lezioni[k].setIdLezione(-1);
				    			  System.out.println("Lezione dopo correzione"  + k +" "+lezioni[k].getIdLezione());
				    		  }
				    		  
				    			  
				    	  }
				      }
				    	   
					 
					
				
					 for(int z = 0; z < lunghezza ; z++) 
				
					 {
						 
						 System.out.println("        "+lezioni[z].getIdLezione());
						 if(lezioni[z].getIdLezione() == -1 ) 
						 {
							 continue;	 
						 }
						 else
						 {
							 //Ricavo giorno e ora 
							 
						     LezioneDAO ricavogiorno = new LezioneDAO();
							 String Giorno = ricavogiorno.getGiornoEvento((lezioni[z].getIdLezione())).get(0)[0];
							 
							 LezioneDAO ricavoora = new LezioneDAO();
	                         String Ora = ricavoora.getOraEvento((lezioni[z].getIdLezione())).get(0)[0];
							
							 comboBox_4.addItem(Giorno + "  " + Ora);
							 
						 }
						 
					 }	  
					 
					 
					 controllo= false;
				
			
				  
				 }
			
			}
			
		  });
		  
			//CREAZIONE DELL'EVENTO
			
			btnConferma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					final Vector<String[]> d ;
					String NomeEvento = textField.getText() ;
					String TipoEvento = comboBox_5.getSelectedItem().toString();
					String IdDisciplina = Integer.toString(idDisc);
					String Livello = comboBox_3.getSelectedItem().toString();
					
					String IdIstruttore = Integer.toString(id);
					String IdLezione ;
					
					String Giornoora = comboBox_4.getSelectedItem().toString();
					//System.out.println("QUESTO é L'ORARIO PRESO" + Giornoora);
					
					
					//lunghezza totale
					//String stringa = Giornoora.toString().trim();
					
					//System.out.println(stringa);
					
					//int i = Giornoora.toString().trim().length();
					
					//System.out.println("La stringa è lunga = "+ i);
					//ORA = LUNGHEZZA TOTALE - LUNGHEZZA ORA(8 -1) 
					//int partenzaOra = stringa.length() - 8;  
					
					//System.out.println("L'ora la leggo dal valore = "+ partenzaOra);
					
					String Ora = Giornoora.toString().trim().substring((Giornoora.toString().trim().length() - 8),Giornoora.toString().trim().length());
					
					System.out.println("L'ora è  :" + Ora);
					
					// DA ZERO E LUNGO (LUGHEZZA TOTALE - ORA )
					
					String Giorno = Giornoora.toString().trim().substring(0,(Giornoora.toString().trim().length() - 8));
					
					System.out.println("Il Giorno è  :" + Giorno);
					
		            LezioneDAO letturaid = new LezioneDAO();
					
					IdLezione = letturaid.getIDLezioneGiornoOra(Giorno, Ora).get(0)[0];
					
					int idLez = Integer.parseInt(IdLezione);
					
				
					
					//CREAZIONE NUOVO EVENTO
					
				    EventoDAO creaEvento = new	EventoDAO();
					
					if (creaEvento.newEvento( idLez, NomeEvento, TipoEvento, IdDisciplina, IdIstruttore))
					{
						JFrame eventocreato = new JFrame();
						JOptionPane.showMessageDialog(eventocreato,"L'EVENTO E' STATO CREATO CORRETTAMENTE");
						finestra.dispose();
					}
					else
					{
						JFrame eventocreato = new JFrame();
						JOptionPane.showMessageDialog(eventocreato,"L'EVENTO NON E' STATO CREATO!");
						finestra.dispose();
					}
					
					
					
					
				}
				
			});
			
		}
	
	}
	

		 
	

	
	
	


