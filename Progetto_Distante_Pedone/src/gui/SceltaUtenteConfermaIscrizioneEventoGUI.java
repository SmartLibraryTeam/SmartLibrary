package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;
import DAO.UtenteRegistratoDAO;

import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class SceltaUtenteConfermaIscrizioneEventoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaUtenteConfermaIscrizioneEventoGUI frame = new SceltaUtenteConfermaIscrizioneEventoGUI();
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
	public SceltaUtenteConfermaIscrizioneEventoGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 224);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scegli Evento");
		lblNewLabel.setBounds(10, 11, 274, 24);
		contentPane.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(10, 35, 274, 24);
		contentPane.add(comboBox);
		
		JLabel lblScegliTesserato = new JLabel("Scegli Tesserato");
		lblScegliTesserato.setBounds(10, 70, 274, 24);
		contentPane.add(lblScegliTesserato);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 105, 274, 24);
		contentPane.add(comboBox_1);
		
		JButton btnOk = new JButton("OK");
		
		btnOk.setBounds(98, 151, 89, 23);
		contentPane.add(btnOk);
		
		//POPOLO COMBOBOX CON TUTTI GLI EVENTI ACCETTATI
		
		EventoDAO letturaeventiiscrizione = new EventoDAO();
		
		int y = 0;
		int lunghezza1 = letturaeventiiscrizione.getEventiAccettati().size();
		while( y < lunghezza1 )
		{
			System.out.println(letturaeventiiscrizione.getEventiAccettati().get(y)[0]);
			
			comboBox.addItem(letturaeventiiscrizione.getEventiAccettati().get(y)[0].toString());
			
			y++;
		}
		
		//POPOLO LA COMBOBOX CON IL NOME DEGLI UTENTI CHE DEVO ESSERE ACCETTATI PER L'EVENTO SCELTO
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//CANCELLIAMO I VALORI GIA' PRESENTI NELLA COMBOBOX 
				DefaultComboBoxModel model = (DefaultComboBoxModel)comboBox_1.getModel();
				model.removeAllElements();
				
				//PRENDO IL VALORE DELL'EVENTO
				
				Object oggetto = new Object();
				oggetto = comboBox.getSelectedItem();
				String nomeEvento= oggetto.toString();
				
				//RICAVO ID EVENTO
				
			    EventoDAO idEvento = new EventoDAO();
				int IDEVENTO = idEvento.getIdEvento(nomeEvento);
				
				//RICAVO L'ID DI TUTTI I TESSERATI ISCRITTI ALL'EVENTO CON STATO NEGATO
				
				EventoDAO tesseratiEventoNeato = new EventoDAO();
				
				
				int i = 0;
				int lunghezza2 = tesseratiEventoNeato.getTesseratiEventoNegato(IDEVENTO).size();
				while( i < lunghezza2 )
				{
					//RICAVO NOME E COGNOME UTENTE DA ID
					
					 UtenteRegistratoDAO nomeutente = new UtenteRegistratoDAO();
					
				     String Nome = nomeutente.getNomeUtente(Integer.parseInt(tesseratiEventoNeato.getTesseratiEventoNegato(IDEVENTO).get(i)[0])).get(0)[0];
				     String Cognome =  nomeutente.getNomeUtente(Integer.parseInt(tesseratiEventoNeato.getTesseratiEventoNegato(IDEVENTO).get(i)[0])).get(0)[1];
					
					
					//tesseratiEventoNeato.getTeseratiEventoNegato(id.getIdEvento(nomeEvento))
					
					comboBox_1.addItem(Nome + "  "+ Cognome);
					
					i++;
				}
					
				
			}
		});

		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//PRENDO L'ID DEL TESSERATO 
				
			  
				

				Object oggetto = comboBox_1.getSelectedItem();
				String stringa = oggetto.toString();
				
				String[] nomecognome  = new String[2];
				nomecognome = stringa.split("  ");
				
				String nome = nomecognome[0];
				String cognome = nomecognome[1];
				
				UtenteRegistratoDAO ricavaidUtente = new UtenteRegistratoDAO();
				
				int idUtente = ricavaidUtente.getIdFromNomeCognome(  nome, cognome); 
				
				//PRENDO L'ID DELL' EVENTO
				
				Object oggetto1 = new Object();
				oggetto1 = comboBox.getSelectedItem();
				String nomeEvento= oggetto1.toString();
				
		        EventoDAO ricavaidEvento = new EventoDAO();
				int idEvento = ricavaidEvento.getIdEvento(nomeEvento);
				
				
				ConfermaEventoTesseratoGUI confermaTesseratoEvento = new ConfermaEventoTesseratoGUI(idEvento,idUtente);
				confermaTesseratoEvento.setVisible(true);
			}
		});	
		
		
	}

}

