package gui;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.LezioneDAO;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import java.awt.Color;



public class OrganizzaTurniGUI extends JFrame {

	private JPanel contentPane;
	private JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrganizzaTurniGUI frame = new OrganizzaTurniGUI();
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
	public OrganizzaTurniGUI(String nomeDisciplina, String livello, int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 336, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 304, 69);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 100, 95, 289);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(127, 100, 187, 289);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setText("<html>"+ nomeDisciplina + "<br> "+ livello + " <html>");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18));
		lblNewLabel.setBounds(47, 11, 214, 47);
		panel.add(lblNewLabel);
		
		
		JLabel lblLunedi = new JLabel("LUNEDI'");
		lblLunedi.setBounds(10, 10, 56, 28);
		panel_1.add(lblLunedi);
		
		JLabel lblMartedi = new JLabel("MARTEDI'");
		lblMartedi.setBounds(10, 60, 56, 28);
		panel_1.add(lblMartedi);
		
		JLabel lblMercoledi = new JLabel("MERCOLEDI'");
		lblMercoledi.setBounds(10, 110, 75, 28);
		panel_1.add(lblMercoledi);
		
		JLabel lblGiovedi = new JLabel("GIOVEDI'");
		lblGiovedi.setBounds(10, 160, 56, 28);
		panel_1.add(lblGiovedi);
		
		JLabel lblVenerdi = new JLabel("VENERDI'");
		lblVenerdi.setBounds(10, 210, 56, 28);
		panel_1.add(lblVenerdi);
		
		JLabel lblSabato = new JLabel("SABATO");
		lblSabato.setBounds(10, 260, 56, 28);
		panel_1.add(lblSabato);
		
		
		 //DAO CHE PRENDE IN INGRESSO IL NOME DELLA DISCIPLINA E IL LIVELLO E RESTITUISCE L'ID DELLA DISCIPLINA
		

	     DisciplinaDAO letturaiddisciplina = new DisciplinaDAO();
	     //int idDisc= 0;
	     int idDisc = letturaiddisciplina.getIdDisciplina (nomeDisciplina, livello);
		 
	     System.out.println("L'idDisc è = " + idDisc);
		 
		 
	     //DAO CHE PRENDE L'ID DELLA DISCIPLINA E RESTITUISCE UN ARRAYLIST DI LEZIONI
			
			
		 LezioneDAO letturaOrari = new LezioneDAO();
		 
		 int lunghezza = letturaOrari.getLezioni(idDisc).size();
		
		 System.out.println("Ci sono " + lunghezza + " orari");
	     if (lunghezza > 0) 
     
	     {
		
		//String[] array = new String[6] ;
		
		
		
	    /*for(int y =0; y<6; y++) 
		{
			array[y]="sì";
		}*/
		
		
	    	 
	    //STAMPIAMO L'ORARIO DELLA DISCIPLINA CON LIVELLO = livello
		
		
		for(int e= 0; e < 6; e++) 
	    
		{
	    	
	    	/*Se il giorno in cui si svolge l'e-esima lezione della disciplina considerata è lunedì, 
	    	 * crea un bottone in corrispondenza di lunedì e stampa l'ora della lezione sul bottone stesso*/
			if(letturaOrari.getLezioni(idDisc).get(e).getGiorno().equals("Lunedì"))
			{
				 String giorno1= letturaOrari.getLezioni(idDisc).get(e).getGiorno();
			     String ora1 = letturaOrari.getLezioni(idDisc).get(e).getOra();
			     JButton bottone1 = new JButton();
			     bottone1.setText(ora1);
			     bottone1.setBounds (63, 11, 89, 23);
			     panel_2.add(bottone1);
			     bottone1.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							GestioneTurnoGUI turno1 = new GestioneTurnoGUI (giorno1, ora1);
							turno1.setVisible(true);
						}
					});
			     
			   
			    continue;
				
			}
			
			/*Se il giorno in cui si svolge l'e-esima lezione della disciplina considerata è martedì, 
	    	 * crea un bottone in corrispondenza di martedì e stampa l'ora della lezione sul bottone stesso*/	
			if(letturaOrari.getLezioni(idDisc).get(e).getGiorno().equals("Martedì"))    
			{
				 String giorno2= letturaOrari.getLezioni(idDisc).get(e).getGiorno();
				 String ora2 = letturaOrari.getLezioni(idDisc).get(e).getOra();
				 JButton bottone2 = new JButton();
			     bottone2.setText(ora2);
			     bottone2.setBounds (63, 61, 89, 23);
			     panel_2.add(bottone2);
			     bottone2.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							GestioneTurnoGUI turno2 = new GestioneTurnoGUI (giorno2, ora2);
							turno2.setVisible(true);
						}
					});
			     
			   
			     continue;
				
		    }
			
			/*Se il giorno in cui si svolge l'e-esima lezione della disciplina considerata è mercoledì, 
	    	 * crea un bottone in corrispondenza di mercoledì e stampa l'ora della lezione sul bottone stesso*/ 
			if(letturaOrari.getLezioni(idDisc).get(e).getGiorno().equals("Mercoledì"))    
			{
				 String giorno3= letturaOrari.getLezioni(idDisc).get(e).getGiorno();
				 String ora3 = letturaOrari.getLezioni(idDisc).get(e).getOra();
				 JButton bottone3 = new JButton();
			     bottone3.setText(ora3);
			     bottone3.setBounds (63, 111, 89, 23);
			     panel_2.add(bottone3);
			     bottone3.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							GestioneTurnoGUI turno3= new GestioneTurnoGUI (giorno3, ora3);
							turno3.setVisible(true);
						}
					});
			     
			    
			     
			     continue;
				
		    }
			
			/*Se il giorno in cui si svolge l'e-esima lezione della disciplina considerata è giovedì, 
	    	 * crea un bottone in corrispondenza di giovedì e stampa l'ora della lezione sul bottone stesso*/
			if(letturaOrari.getLezioni(idDisc).get(e).getGiorno().equals("Giovedì"))    
			{

				 String giorno4= letturaOrari.getLezioni(idDisc).get(e).getGiorno();
				 String ora4 = letturaOrari.getLezioni(idDisc).get(e).getOra();
				 JButton bottone4 = new JButton();
			     bottone4.setText(ora4);
			     bottone4.setBounds (63, 161, 89, 23);
			     panel_2.add(bottone4);
			     bottone4.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							GestioneTurnoGUI turno4= new GestioneTurnoGUI (giorno4, ora4);
							turno4.setVisible(true);
						}
					});
			     
			  
			     
			     continue;
				
		    }
			
			/*Se il giorno in cui si svolge l'e-esima lezione della disciplina considerata è venerdì, 
	    	 * crea un bottone in corrispondenza di venerdì e stampa l'ora della lezione sul bottone stesso*/

			if(letturaOrari.getLezioni(idDisc).get(e).getGiorno().equals("Venerdì"))    
			{
				 String giorno5= letturaOrari.getLezioni(idDisc).get(e).getGiorno();
				 String ora5 = letturaOrari.getLezioni(idDisc).get(e).getOra();
				 JButton bottone5= new JButton();
			     bottone5.setText(ora5);
			     bottone5.setBounds (63, 211, 89, 23);
			     panel_2.add(bottone5);
			     bottone5.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							GestioneTurnoGUI turno5= new GestioneTurnoGUI (giorno5, ora5);
							turno5.setVisible(true);
						}
					});
			     
			  
			     
			     continue;
				
		    }
	       
			/*Se il giorno in cui si svolge l'e-esima lezione della disciplina considerata è sabato, 
	    	 * crea un bottone in corrispondenza di sabato e stampa l'ora della lezione sul bottone stesso*/
			if(letturaOrari.getLezioni(idDisc).get(e).getGiorno().equals("Sabato"))    
			{
				 String giorno6= letturaOrari.getLezioni(idDisc).get(e).getGiorno();
				 String ora6 = letturaOrari.getLezioni(idDisc).get(e).getOra();
				 JButton bottone6= new JButton();
			     bottone6.setText(ora6);
			     bottone6.setBounds (63, 261, 89, 23);
			     panel_2.add(bottone6);
			     bottone6.addActionListener(new ActionListener() 
					{
						public void actionPerformed(ActionEvent e) 
						{
							GestioneTurnoGUI turno6 = new GestioneTurnoGUI (giorno6, ora6 );
							turno6.setVisible(true);
						}
					});
			     
			    
			     
			     continue;
				
		    }
		  }
		}
	     
	     letturaOrari.getLezioni(idDisc).clear();
	    
    }
   
}

			


	
		/*	for(int i= 0; i < 6; i++) 
		
		{
				if (i==0)
			   {	
				   if(array[i].equals("no"))
				 {
					
				     String Lunedì = letturaOrari.getLezioni(idDisc).get(i).getOra();
				     JLabel label1 = new JLabel();
				     label1.setText(Lunedì);
				     label1.setBounds (63, 11, 89, 23);
				     panel_2.add(label1);
				     
				     continue;
				     
				  }
			    }
				
				if (i==1)
			   {
					
				if(array[i].equals("no"))
				  {
					
				     String Martedì = letturaOrari.getLezioni(idDisc).get(i).getOra();
				     JLabel label2 = new JLabel();
				     label2.setText(Martedì);
				     label2.setBounds (63, 61, 89, 23);
				     panel_2.add(label2);
				     
				     continue;
				     
				   }
				}
				
				if (i==2)
				   {
						
					if(array[i].equals("no"))
					  {
						
					     String Mercoledì = letturaOrari.getLezioni(idDisc).get(i).getOra();
					     JLabel label3 = new JLabel();
					     label3.setText(Mercoledì);
					     label3.setBounds (63, 111, 89, 23);
					     panel_2.add(label3);
					     
					     continue;
					     
					   }
					}
				if (i==3)
				   {
						
					if(array[i].equals("no"))
					  {
						
					     String Giovedì = letturaOrari.getLezioni(idDisc).get(i).getOra();
					     JLabel label4 = new JLabel();
					     label4.setText(Giovedì);
					     label4.setBounds (63, 161, 89, 23);
					     panel_2.add(label4);
					     
					     continue;
					     
					   }
					}
				if (i==4)
				   {
						
					if(array[i].equals("no"))
					  {
						
					     String Venerdì = letturaOrari.getLezioni(idDisc).get(i).getOra();
					     JLabel label5 = new JLabel();
					     label5.setText(Venerdì);
					     label5.setBounds (63, 211, 89, 23);
					     panel_2.add(label5);
					     
					     continue;
					     
					   }
					}
				if (i==5)
				   {
						
					if(array[i].equals("no"))
					  {
						
					     String Sabato = letturaOrari.getLezioni(idDisc).get(i).getOra();
					     JLabel label6 = new JLabel();
					     label6.setText(Sabato);
					     label6.setBounds (63, 261, 89, 23);
					     panel_2.add(label6);
					     
					     continue;
					     
					   }
					}
				
				*/



