package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import DAO.LezioneDAO;
import DAO.DisciplinaDAO;

import javax.swing.SwingConstants;
import java.awt.Color;


public class ConsultaDisciplinaTesseratoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDisciplinaTesseratoGUI frame = new ConsultaDisciplinaTesseratoGUI();
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
	public ConsultaDisciplinaTesseratoGUI(String nomeDisciplina){
		setTitle("ConsultaOrarioDisciplinaTesserato");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Salviamo nella stringa nomedisciplina il valore della disciplina
		String nomedisciplina = nomeDisciplina;
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 564, 48);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DISCIPLINA : ");
		lblNewLabel.setBounds(10, 11, 91, 26);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18));
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		//Rendiamo visibile il nome della disciplina nel label
		lblNewLabel_1.setText(nomeDisciplina);
		lblNewLabel_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(110, 15, 149, 23);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 70, 77, 284);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLunedi = new JLabel("LUNEDI");
		lblLunedi.setBounds(10, 40, 56, 28);
		panel_1.add(lblLunedi);
		
		JLabel lblMartedi = new JLabel("MARTEDI");
		lblMartedi.setBounds(10, 80, 56, 28);
		panel_1.add(lblMartedi);
		
		JLabel lblMercoledi = new JLabel("MERCOLEDI");
		lblMercoledi.setBounds(10, 120, 67, 28);
		panel_1.add(lblMercoledi);
		
		JLabel lblGiovedi = new JLabel("GIOVEDI");
		lblGiovedi.setBounds(10, 160, 56, 28);
		panel_1.add(lblGiovedi);
		
		JLabel lblVenerdi = new JLabel("VENERDI");
		lblVenerdi.setBounds(10, 200, 56, 28);
		panel_1.add(lblVenerdi);
		
		JLabel lblSabato = new JLabel("SABATO");
		lblSabato.setBounds(10, 240, 56, 28);
		panel_1.add(lblSabato);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(97, 70, 152, 284);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLivelloPrincipiante = new JLabel("Livello Principiante");
		lblLivelloPrincipiante.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivelloPrincipiante.setBounds(27, 11, 104, 29);
		lblLivelloPrincipiante.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		panel_2.add(lblLivelloPrincipiante);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(45, 45, 70, 20);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\r\n");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(45, 85, 70, 20);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\r\n");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(45, 125, 70, 20);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(45, 165, 70, 20);
		panel_2.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(45, 205, 70, 20);
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(45, 245, 70, 20);
		panel_2.add(lblNewLabel_7);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(259, 70, 152, 284);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblLivelloAmatoriale = new JLabel("Livello Amatoriale");
		lblLivelloAmatoriale.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivelloAmatoriale.setBounds(21, 11, 110, 30);
		lblLivelloAmatoriale.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		panel_3.add(lblLivelloAmatoriale);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(45, 45, 70, 20);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setBounds(45, 85, 70, 20);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(45, 125, 70, 20);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setBounds(45, 165, 70, 20);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setBounds(45, 205, 70, 20);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setBounds(45, 245, 70, 20);
		panel_3.add(lblNewLabel_13);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(421, 70, 152, 284);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblLivelloAgonistico = new JLabel("Livello Agonistico");
		lblLivelloAgonistico.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivelloAgonistico.setBounds(22, 11, 120, 26);
		lblLivelloAgonistico.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		panel_4.add(lblLivelloAgonistico);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_14.setBounds(45, 45, 70, 20);
		panel_4.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_15.setBounds(45, 85, 70, 20);
		panel_4.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("");
		lblNewLabel_16.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_16.setBounds(45, 125, 70, 20);
		panel_4.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setBounds(45, 165, 70, 20);
		panel_4.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setBounds(45, 205, 70, 20);
		panel_4.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_19.setBounds(45, 245, 70, 20);
		panel_4.add(lblNewLabel_19);

	   
		
	   //STAMPA ORARIO PRINCIPIANTE
		
	   //DAO CHE PRENDE IN INGRESSO IL NOME DELLA DISCIPLINA E CALCOLA L'ID DELLA DISCIPLINA CON LIVELLO = PRINCIPIANTE
		
		 DisciplinaDAO letturaiddisciplina = new DisciplinaDAO();
	     int idDiscP = 0;
	     idDiscP = letturaiddisciplina.getIdDisciplinaPrincipiante(nomeDisciplina); 
		
	   //DAO CHE PRENDE L'ID DELLA DISCIPLINA E PRELEVA L'ORARIO DELLA DISCIPLINA CON LIVELLO = PRINCIPIANTE
			
			
		LezioneDAO letturaOrariPrincipiante = new LezioneDAO();
		 
		 if (idDiscP >= 0) 
     {
		//System.out.println("idDiscP");
			 
		int lunghezzaP = letturaOrariPrincipiante.getLezioni(idDiscP).size();
		
	    for(int e= 0; e < lunghezzaP ; e++) 
	    
		{
	    	//System.out.println("Ciclo");
	    	
			if(letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getGiorno().equals("Lunedì"))
			{
				 String LunedìP = letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getOra();
				 
				 lblNewLabel_2.setText(LunedìP);
				 
				 continue;
				
			}
			if(letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getGiorno().equals("Martedì")) 
			{
				String MartedìP = letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getOra();
				
			    lblNewLabel_3.setText(MartedìP);
			    
			    continue;
			}
			if(letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getGiorno().equals("Mercoledì")) 
			{
				String MercoledìP = letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getOra();
				
			    lblNewLabel_4.setText(MercoledìP);
			    
			    continue;
			}
			if(letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getGiorno().equals("Giovedì")) 
			{
				String GiovedìP = letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getOra();
				
			    lblNewLabel_5.setText(GiovedìP);
			    
			    continue;
			}
			if(letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getGiorno().equals("Venerdì")) 
			{
				String VenerdìP = letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getOra();
				
				//System.out.println("eccomi");
				
			    lblNewLabel_6.setText(VenerdìP);
			    
			    continue;
			}
			if(letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getGiorno().equals("Sabato")) 
			{
				String SabatoP = letturaOrariPrincipiante.getLezioni(idDiscP).get(e).getOra();
				
			    lblNewLabel_7.setText(SabatoP);
			    
			    continue;
			}
			
		}
	    
	    
     }
		 
		 letturaOrariPrincipiante.getLezioni(idDiscP).clear();
	
	
	   //STAMPA ORARIO AMATORIALE
	
	   //DAO CHE PRENDE IN INGRESSO IL NOME DELLA DISCIPLINA E CALCOLA L'ID DELLA DISCIPLINA CON LIVELLO = AMATORIALE
		

		 DisciplinaDAO letturaiddisciplina1 = new  DisciplinaDAO();
	     int idDiscA = 0;
	     idDiscA = letturaiddisciplina1.getIdDisciplinaAmatoriale (nomeDisciplina); 
		
	   //DAO CHE PRENDE L'ID DELLA DISCIPLINA E PRELEVA L'ORARIO DELLA DISCIPLINA CON LIVELLO = AMATORIALE
			
			
		 LezioneDAO letturaOrariAmatoriale = new LezioneDAO();
		
		 if (idDiscA >= 0) 	
      {		
			// System.out.println("idDiscA");
			 
			 int lunghezzaA = letturaOrariAmatoriale.getLezioni(idDiscA).size();
             
			 for(int e= 0; e < lunghezzaA ; e++) 
		    {
				 //System.out.println("LA LUNGHEZZA è :  " + lunghezzaA);
            	 
				 //System.out.println("Ciclo AMATORIALE");
            	 
            	 //System.out.println(letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getGiorno());
                 
            	 if(letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getGiorno().equals("Lunedì"))
			
                 {
				 
                	 String LunedìA = letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getOra();
				 
                	 //System.out.println("eccomi lun ama");
				 
                	 lblNewLabel_8.setText(LunedìA);
				 
                	 continue;
				
			
                 }
                 if(letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getGiorno().equals("Martedì")) 
                 {
                	 String MartedìA = letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getOra();
                	 
                	 //System.out.println("eccomi mar ama");
                	 
                	 lblNewLabel_9.setText(MartedìA);
                	 
                	 continue;
                 }
			if(letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getGiorno().equals("Mercoledì")) 
			     {
				     String MercoledìA = letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getOra();
				     
				     //System.out.println("eccomi mer ama");
				     
				     lblNewLabel_10.setText(MercoledìA);
				     
			         continue;
			     }
			if(letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getGiorno().equals("Giovedì")) 
			     {
				
				      String GiovedìA = letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getOra();
				      
				      //System.out.println("eccomi giov ama");
				
				      lblNewLabel_11.setText(GiovedìA);
				      
			          continue;
			     }
			if(letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getGiorno().equals("Venerdì")) 
			     {
				      String VenerdìA = letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getOra();
				      
				     // System.out.println("eccomi ven ama");
				      
			          lblNewLabel_12.setText(VenerdìA);
			          
			          continue;
			     }
			if(letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getGiorno().equals("Sabato")) 
			     {
				
				      String SabatoA = letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getOra();
				      
				      //System.out.println("eccomi sab ama");
				      
				      lblNewLabel_13.setText(SabatoA);
				      
			          continue;
			     }
			
		}
            
      }
		letturaOrariAmatoriale.getLezioni(idDiscA).clear();
	   
		
		//STAMPA ORARIO AGONISTICO
	
	   //DAO CHE PRENDE IN INGRESSO IL NOME DELLA DISCIPLINA E CALCOLA L'ID DELLA DISCIPLINA CON LIVELLO = AGONISTICO
		

		 DisciplinaDAO letturaiddisciplina2 = new DisciplinaDAO();
	     int idDiscAgo = 0;
	     idDiscAgo = letturaiddisciplina2.getIdDisciplinaAgonistico(nomeDisciplina); 
		
	   //DAO CHE PRENDE L'ID DELLA DISCIPLINA E PRELEVA L'ORARIO DELLA DISCIPLINA CON LIVELLO = AGONISTICO
			
			
		 LezioneDAO letturaOrariAgonistico = new LezioneDAO();
		
		 if (idDiscAgo >= 0) 
		 {
			 //System.out.println("idDiscAgo");
			 
			 int lunghezzaAgo = letturaOrariAgonistico.getLezioni(idDiscAgo).size();
			
			 for(int e= 0; e < lunghezzaAgo ; e++) 
				 {
				 //System.out.println("Ciclo");
					if(letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getGiorno().equals("Lunedì"))
					{
						 String LunedìAgo = letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getOra();
						 
						 //System.out.println("eccomi lun");
						 
						 lblNewLabel_14.setText(LunedìAgo);
						 
						 continue;
						
					}
					if(letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getGiorno().equals("Martedì")) 
					{
						String MartedìAgo = letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getOra();
						
						//System.out.println("eccomi mar");
						
						lblNewLabel_15.setText(MartedìAgo);
						
					    continue;
					}
					if(letturaOrariAmatoriale.getLezioni(idDiscA).get(e).getGiorno().equals("Mercoledì")) 
					{
						String MercoledìAgo = letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getOra();
						
						//System.out.println("eccomi merc");
						
						lblNewLabel_16.setText(MercoledìAgo);
						
					    continue;
					}
					if(letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getGiorno().equals("Giovedì")) 
					{
						String GiovedìAgo = letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getOra();
						
						//System.out.println("eccomi giov");
						
						lblNewLabel_17.setText(GiovedìAgo);
						
					    continue;
					}
					if(letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getGiorno().equals("Venerdì")) 
					{
						String VenerdìAgo = letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getOra();
						
						//System.out.println("eccomi");
						
					    lblNewLabel_18.setText(VenerdìAgo);
					    
					    continue;
					}
					if(letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getGiorno().equals("Sabato")) 
					{
						String SabatoAgo = letturaOrariAgonistico.getLezioni(idDiscAgo).get(e).getOra();
						
						//System.out.println("eccomi sabato");
						
					    lblNewLabel_19.setText(SabatoAgo);
					    
					    continue;
					}
					
				}
			        
	
		 }
		 
		 letturaOrariAgonistico.getLezioni(idDiscAgo).clear();
	
      }
     }

	
		
	
	
	
	
	
	
	
	
	
		

	
	
	
	
		
	