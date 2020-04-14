package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.LezioneDAO;


public class SceltaTurnoResponsabileIscrizioneGUI extends JFrame {

	private JPanel contentPane;
    public JFrame finestra = this;
	public boolean controllo = false;
	public int idDisc = 0;
    public String nomeDisciplina; 
	public String livello;
	public String giorno;
	public String ora;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaTurnoResponsabileIscrizioneGUI frame = new SceltaTurnoResponsabileIscrizioneGUI();
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
	public SceltaTurnoResponsabileIscrizioneGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 313, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
	    contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblScegliDisciplina = new JLabel("Scegli Disciplina:");
		lblScegliDisciplina.setBounds(10, 22, 280, 19);
		contentPane.add(lblScegliDisciplina);
		
		JComboBox comboBox_Disciplina = new JComboBox();
		
		
		
		// DAO CHE RICAVA LE DISCIPLINE DISPONIBILI NEL DATABASE
		
	    DisciplinaDAO letturadisciplinetesserato = new DisciplinaDAO();
		
		System.out.println("NUMERO DISCIPLINE = " + letturadisciplinetesserato.getDiscipline().size() );
		
		int y = 0;
		
		int Lunghezza = letturadisciplinetesserato.getDiscipline().size();
		
		
		
		while( y < letturadisciplinetesserato.getDiscipline().size())
		{
			System.out.println(letturadisciplinetesserato.getDiscipline().get(y)[0]);
			
			comboBox_Disciplina.addItem(letturadisciplinetesserato.getDiscipline().get(y)[0]);
			
			y++;
		}
		
		
		comboBox_Disciplina.setBounds(10, 52, 280, 25);
		contentPane.add(comboBox_Disciplina);
		
		
		
		JLabel lblScegliLivello = new JLabel("Scegli Livello:");
		lblScegliLivello.setBounds(10, 92, 280, 19);
		contentPane.add(lblScegliLivello);
		
		JComboBox comboBox_Livello = new JComboBox();
		comboBox_Livello.setBounds(10, 122, 280, 25);
		contentPane.add(comboBox_Livello);
		
		
		JLabel lblScegliTurno = new JLabel("Scegli Turno:");
		lblScegliTurno.setBounds(10, 162, 280, 19);
		contentPane.add(lblScegliTurno);
		
		JComboBox comboBox_Turno = new JComboBox();
		comboBox_Turno.setBounds(10, 192, 280, 25);
		contentPane.add(comboBox_Turno);
		
		
		//DAO CHE POPOLA LA COMBOBOX LIVELLI SCELTA LA DISCIPLINA
				comboBox_Disciplina.addActionListener(new ActionListener()
				{
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
							System.out.println(letturalivellidisciplina.getLivelloDisciplina(nomeDisciplina).get(y)[0]);
							
							comboBox_Livello.addItem(letturalivellidisciplina.getLivelloDisciplina (nomeDisciplina).get(y)[0]);
							
							y++;
						}
						
						controllo = true;
						
						System.out.println("LA variabile controllo è : " + controllo);
						}
						
					});
				
				//IN BASE AL VALORE DEL LIVELLO SI POPOLA LA COMBOBOX TURNO
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
							 giorno = letturaOrari.getLezioni(idDisc).get(z).getGiorno();
							 
							 ora = letturaOrari.getLezioni(idDisc).get(z).getOra();
						
							 System.out.println(giorno);
						
							 System.out.println(ora);
							 
							
						
							 comboBox_Turno.addItem("                            " + giorno + " " + ora +"");
						
							 
						
						
						 }	  
						 
						 letturaOrari.getLezioni(idDisc).clear();
					
					
						 controllo= false;
					
				
					  
					 }
				
				}
				
			  });
				
				
				JButton btnNewButton = new JButton("OK");
				btnNewButton.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e) 
					{
                          
						String giornoora = comboBox_Turno.getSelectedItem().toString();
						//String stringa = Giornoora.toString().trim();
						
						//System.out.println(stringa);
						
						//int i = Giornoora.toString().trim().length();
						
						//System.out.println("La stringa è lunga = "+ i);
						//ORA = LUNGHEZZA TOTALE - LUNGHEZZA ORA(8 -1) 
						//int partenzaOra = stringa.length() - 8;  
						
						//System.out.println("L'ora la leggo dal valore = "+ partenzaOra);
						
						String Ora = giornoora.toString().trim().substring((giornoora.toString().trim().length() - 8),giornoora.toString().trim().length());
						
						System.out.println("L'ora è  :" + Ora);
						
						// DA ZERO E LUNGO (LUGHEZZA TOTALE - ORA )
						
						String Giorno = giornoora.toString().trim().substring(0,(giornoora.toString().trim().length() - 8));
						
						System.out.println("Il Giorno è  :" + Giorno);
						
						
						
						//Dal giorno e dall'ora della lezione ricaviamo l'id
						//DAO CHE PRENDE IL GIORNO E L'ORA E RESTITUISCE L'ID DELLA LEZIONE 
					    LezioneDAO letturaidlezione = new LezioneDAO();
						int idlezione= Integer.parseInt(letturaidlezione.getIDLezioneGiornoOra( Giorno, Ora).get(0)[0]);
						System.out.println(idlezione);
						
						/*Ricaviamo gli id dei tesserati che hanno richiesto l'iscrizione alla lezione e per i quali iscrizione_disciplina nel db 
						 * ha StatoPagamento = Non pagato */
						 
						//DAO CHE PRENDE L'ID DELLA LEZIONE E RESTITUISCE UN VETTORE DI ARRAY DI STRINGHE CONTENENTE GLI ID DEGLI ISCRITTI
						DisciplinaDAO ricavaidtesserati = new DisciplinaDAO();
						Vector<String[]> idtesserati = ricavaidtesserati.getIDIscrittiStatoPagamentoNonPagato (idlezione);
						int lunghezza = idtesserati.size();
						
						
						 if (lunghezza == 0 )
							{
								JFrame nessuntesserato = new JFrame();
							    JOptionPane.showMessageDialog( nessuntesserato ,"NESSUN TESSERATO HA RICHIESTO L'ISCRIZIONE A QUESTA LEZIONE" );
							    
							}
						 
						 else
						    {
							ConfermaIscrizioneTurnoTesseratoGUI confermaiscrizione = new ConfermaIscrizioneTurnoTesseratoGUI(idtesserati, idlezione);
						    confermaiscrizione.setVisible(true);
						    
					        }
						 
					}
				});
				btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
				btnNewButton.setBounds(105, 235, 90, 30);
				contentPane.add(btnNewButton);
		
	}
  }

