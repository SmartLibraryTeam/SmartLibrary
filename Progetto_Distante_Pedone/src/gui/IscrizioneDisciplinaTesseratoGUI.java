package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.LezioneDAO;


import modelli.IscrizioneDisciplina;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class IscrizioneDisciplinaTesseratoGUI extends JFrame {

	private JPanel contentPane;
	public String nomeDisciplina; 
	public String livello;
	//public ArrayList<IscrizioneDisciplina> iscrizioni = new ArrayList<IscrizioneDisciplina>();
	public boolean controllo = false;
	public int idDisc = 0;
	public JFrame finestra = this;
	
	public int valoreincrementato ;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IscrizioneDisciplinaTesseratoGUI frame = new IscrizioneDisciplinaTesseratoGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public IscrizioneDisciplinaTesseratoGUI(ArrayList<IscrizioneDisciplina> iscrizioni,int id,int in) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 316, 361);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIscrizioneDisciplina = new JLabel("ISCRIZIONE DISCIPLINA");
		lblIscrizioneDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblIscrizioneDisciplina.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblIscrizioneDisciplina.setBounds(10, 11, 280, 25);
		contentPane.add(lblIscrizioneDisciplina);
		
		JLabel lblScegliDisciplina = new JLabel("Scegli Disciplina:");
		lblScegliDisciplina.setBounds(10, 41, 280, 19);
		contentPane.add(lblScegliDisciplina);
		
		JComboBox comboBox_Disciplina = new JComboBox();
		
		// DAO CHE RICAVA LE DISCIPLINE DISPONIBILI NEL DATABASE
		
		DisciplinaDAO letturadisciplinetesserato = new 	DisciplinaDAO();
		
		System.out.println("NUMERO DISCIPLINE = " + letturadisciplinetesserato.getDiscipline().size() );
		
		int y = 0;
		
		int Lunghezza = letturadisciplinetesserato.getDiscipline().size();
		
		
		
		while( y < letturadisciplinetesserato.getDiscipline().size())
		{
			System.out.println(letturadisciplinetesserato.getDiscipline().get(y)[0]);
			
			comboBox_Disciplina.addItem(letturadisciplinetesserato.getDiscipline().get(y)[0]);
			
			y++;
		}
		
		
		
		comboBox_Disciplina.setBounds(10, 71, 280, 25);
		contentPane.add(comboBox_Disciplina);
		
		JLabel lblScegliLivello = new JLabel("Scegli Livello:");
		lblScegliLivello.setBounds(10, 114, 280, 19);
		contentPane.add(lblScegliLivello);
		
		JComboBox comboBox_Livello = new JComboBox();
		comboBox_Livello.setBounds(10, 144, 280, 25);
		contentPane.add(comboBox_Livello);
		
		JLabel lblScegliTurno = new JLabel("Scegli Turno:");
		lblScegliTurno.setBounds(10, 190, 280, 19);
		contentPane.add(lblScegliTurno);
		
		JComboBox comboBox_Turno = new JComboBox();
		comboBox_Turno.setBounds(10, 220, 280, 25);
		contentPane.add(comboBox_Turno);
		
		JButton btnNewButton = new JButton("AGGIUNGI AL RESOCONTO");
		
		btnNewButton.setBounds(58, 272, 194, 39);
		contentPane.add(btnNewButton);
		
		
		//DAO CHE POPOLA LA COMBOBOX LIVELLI SCELTA LA DISCIPLINA
		comboBox_Disciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
				{
				//DAO CHE POPOLA LA COMBOBOX LIVELLI SCELTA LA DISCIPLINA
				
				//cancello se sono presenti i livelli
				DefaultComboBoxModel model = (DefaultComboBoxModel)comboBox_Livello.getModel();
				model.removeAllElements();
				
				//PRELEVIAMO IL VALORE DI DISCIPLINA
				Object selectedItem = new Object();
				selectedItem = comboBox_Disciplina.getSelectedItem();
				nomeDisciplina = selectedItem.toString();
				
				//System.out.println("LA DISCIPLINA SCELTA E' :   " + nomeDisciplina);
					
				DisciplinaDAO letturalivellidisciplina = new DisciplinaDAO();
				
				//System.out.println("NUMERO LIVELLI = " + letturalivellidisciplina.getLivello(nomeDisciplina).size() );
				
				int y = 0;
				
				//int Lunghezza = letturalivellidisciplina.getLivello(nomeDisciplina).size();
				
				while( y < letturalivellidisciplina.getLivelloDisciplina (nomeDisciplina).size())
				{
					System.out.println(letturalivellidisciplina.getLivelloDisciplina (nomeDisciplina).get(y)[0]);
					
					comboBox_Livello.addItem(letturalivellidisciplina.getLivelloDisciplina (nomeDisciplina).get(y)[0]);
					
					y++;
				}
				
				controllo = true;
				
				System.out.println("LA variabile controllo è : " + controllo);
				}
				
			});
			
		//IN BASE AL VALORE DEL LIVELLO SI POPOLA LA COMBOBOX  GIORNO-ORA
		comboBox_Livello.addActionListener(new ActionListener() 
	
	  {
		public void actionPerformed(ActionEvent e) 
		{
			 DefaultComboBoxModel model2 = (DefaultComboBoxModel)comboBox_Turno.getModel();
			 model2.removeAllElements();
			
			
			 if(controllo) 
			  
			 {
			
				 Object selectedItem = new Object();
				 selectedItem = comboBox_Disciplina.getSelectedItem();
				 
				 nomeDisciplina = selectedItem.toString();
			    
			    
			
				 Object selectedItem3 = new Object();
				 selectedItem3 = comboBox_Livello.getSelectedItem();
				 
				 livello = selectedItem3.toString();
			
			
			
				 //PRENDE IN INGRESSO NOME DELLA DISCIPLINA E LIVELLO SCELTI E CALCOLA L'ID DELLA DISCIPLINA
			
                  DisciplinaDAO letturaiddisciplina = new DisciplinaDAO();
			
				  idDisc = letturaiddisciplina.getIdDisciplina(nomeDisciplina, livello); 
			
			
				 //PRENDE L'ID DELLA DISCIPLINA E PRELEVA TUTTI I GIORNI E GLI ORARI
			
	             LezioneDAO letturaOrari = new LezioneDAO();
			
				 int lunghezza = letturaOrari.getLezioni(idDisc).size();
				 
				 System.out.println("La lunghezza dell'array è:  " + lunghezza);
			
				 for(int z = 0; z < lunghezza ; z++) 
			
				 {
				
				
					 System.out.println(letturaOrari.getLezioni(idDisc).get(z).getGiorno());
				
					 System.out.println(letturaOrari.getLezioni(idDisc).get(z).getOra());
				
					 comboBox_Turno.addItem("                            " + letturaOrari.getLezioni(idDisc).get(z).getGiorno() + letturaOrari.getLezioni(idDisc).get(z).getOra());
				
					 
				
				
				 }	  
				 
				 letturaOrari.getLezioni(idDisc).clear();
			
			
				 controllo= false;
			
		
			  
			 }
		
		}
		
	  });
		
		
		
	
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			valoreincrementato = in+1;
			
			System.out.println("IN (VALORE INCREMENTATO)=" +valoreincrementato);
			//RICAVO GIORNO E ORA 
			String Giornoora = comboBox_Turno.getSelectedItem().toString();
			
			String Ora = Giornoora.toString().trim().substring((Giornoora.toString().trim().length() - 8),Giornoora.toString().trim().length());
			
			System.out.println("L'ora è  :" + Ora);
			
			// DA ZERO E LUNGO (LUGHEZZA TOTALE - ORA )
			
			String Giorno = Giornoora.toString().trim().substring(0,(Giornoora.toString().trim().length() - 8));
			
			System.out.println("Il Giorno è  :" + Giorno);
			
			//RICAVO IDLEZIONE
			
			LezioneDAO lettura = new LezioneDAO();
			
			int idLez = Integer.parseInt(lettura.getIDLezioneGiornoOra(Giorno, Ora).get(0)[0]);
			
			//RICAVO IDDISCIPLINA
			
			DisciplinaDAO ricava = new DisciplinaDAO();
			int idDisc = Integer.parseInt(ricava.getIdDisciplinafromNameandLivello(nomeDisciplina, livello).get(0)[0]);
			
			//AGGIUNGI ISCRIZIONE ALLA LISTA 
			
			IscrizioneDisciplina iscrizione = new IscrizioneDisciplina();
			
			iscrizione.setnomeDisciplina(nomeDisciplina);
			iscrizione.setLivello(livello);
			iscrizione.setGiorno(Giorno);
			iscrizione.setOra(Ora);
			iscrizione.setIdLez(idLez);
			iscrizione.setIdDisc(idDisc);
			
			//CONTROLLO CHE LA RICHIESTA DI ISCRIZIONE NON SIA STATA GIA' INVIATA
			DisciplinaDAO verificaiscrizione = new DisciplinaDAO();
			
			if(verificaiscrizione.verificaRichiestaIscrizioneDisciplina(idDisc, id))
			{
				JFrame richiestagiàinviata = new JFrame();
				JOptionPane.showMessageDialog(richiestagiàinviata,"HAI GIA' RICHIESTO L'ISCRIZIONE A QUESTA DISCIPLINA");
			}
			else
			{
				
			
				//CONTROLLO CHE LA DISCIPLINA SELEZIONATA NON SIA GIA' AGGIUNTA NEL RESOCONTO
			
				boolean trova = false;
			
				System.out.println(iscrizioni.size());
			
			
				for(int k = 0; k< iscrizioni.size(); k++)
				{
					if(idLez == iscrizioni.get(k).getIdLez())
					{
						trova = true;	
					}
				}
				
				if(trova)
				{
					JFrame avviso = new JFrame();
					JOptionPane.showMessageDialog(avviso,"HAI SCELTO UNA DISCIPLINA GIA' PRESENTE NEL RESOCONTO");
			
				}
			
				else
			
				{
				
					iscrizioni.add(iscrizione);
					ResocontoIscrizioniDisciplineTesseratoGUI resoconto1 = new ResocontoIscrizioniDisciplineTesseratoGUI(iscrizioni,id,valoreincrementato);
					resoconto1.setVisible(true);
					finestra.dispose();
			
				}
			
			
			}	
			
		}
	});
	
	}
		
	
}	




