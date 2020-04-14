package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.LezioneDAO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class CancellazioneIscrizioneTurniDisciplineGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancellazioneIscrizioneTurniDisciplineGUI frame = new CancellazioneIscrizioneTurniDisciplineGUI();
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
	public CancellazioneIscrizioneTurniDisciplineGUI(int idTesserato) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 531, 206);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScegliIlTurno = new JLabel("Scegli il turno della disciplina che vuoi abbandonare:");
		lblScegliIlTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliIlTurno.setBounds(10, 11, 495, 35);
		contentPane.add(lblScegliIlTurno);
		
		JButton btnNewButton = new JButton("ABBANDONA TURNO");
		btnNewButton.setBounds(134, 121, 250, 35);
		contentPane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(39, 56, 445, 23);
		contentPane.add(comboBox);
		
		//POPOLO COMBOBOX CON TUTTE LE DISCIPLINE DA CUI L'UTENTE PUO' CANCELLARSI
		
		
		// DAO CHE RICAVA LE DISCIPLINE DISPONIBILI NEL DATABASE
		
				DisciplinaDAO letturalezioni = new DisciplinaDAO  ();
				
				//System.out.println("NUMERO DISCIPLINE = " + letturalezioni.getIDLezioneTesserato(idTesserato).size() );
				
				int y = 0;
				
				int Lunghezza = letturalezioni.getIDLezioneTesserato(idTesserato).size();
				
				
				DisciplinaDAO nomediscipline = new DisciplinaDAO();
				
				
				
				
				
				
				while( y < letturalezioni.getIDLezioneTesserato(idTesserato).size())
				{
					//System.out.println(letturadisciplinetesserato.getDiscipline().get(y)[0]);
					
					//RICAVA L'ID DELLA LEZIONE Y-ESIMA
					String idLez = letturalezioni.getIDLezioneTesserato(idTesserato).get(y)[0]; 
					
					//System.out.println(idLez);
					//CONVERSIONE IN INTERO
					
					int IDLEZ= Integer.parseInt(idLez);
					
					//System.out.println("convertito = " + IDLEZ);
					
					//RICAVO ID DISCIPLINA
			        LezioneDAO ricavaid = new LezioneDAO();
					ricavaid.getIdDisciplinaFromIdLezione(IDLEZ);
					
					//RICAVO NOME DISCIPLINA
					
					int IDDISC =Integer.parseInt(ricavaid.getIdDisciplinaFromIdLezione(IDLEZ).get(0)[0]);
				    DisciplinaDAO ricavodiscliv = new DisciplinaDAO  ();
					String NOMEDISCIPLINA = ricavodiscliv.getDisciplinaLivello(IDDISC).get(0)[0];
					
					//RICAVO LIVELLO DISCIPLINA
					
					String LIVELLO = ricavodiscliv.getDisciplinaLivello(IDDISC).get(0)[1];
					
					//RICAVO ORARIO E GIORNO
					
				    LezioneDAO ricavagiorno = new LezioneDAO();
					String GIORNO = ricavagiorno.getGiornoEvento(IDLEZ).get(0)[0];
					
					LezioneDAO ricavaora = new LezioneDAO();
					String ORA = ricavaora.getOraEvento(IDLEZ).get(0)[0];
					
					
					comboBox.addItem("                           " + NOMEDISCIPLINA + "  " + LIVELLO +  " " + GIORNO + "  " + ORA);
					
					y++;
				}
				
		
		
		
				//CANCELLAZIONE DA TURNO DISCIPLINA
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						
						
						//RICAVO INFORMAZIONI DA COMBOBOX
						
						//String turno = new String[];
						String[] turno  = comboBox.getSelectedItem().toString().split(" ");
						
						int lunghezza = turno.length;
						
						System.out.println("la lunghezza è" + lunghezza);
						
						
						
						String Giorno = turno[30];
						String Ora = turno[32];
						
						System.out.println("il giorno è " + Giorno);
						System.out.println("il turno è "+ Ora);
						
						
						
						//RICAVO ID LEZIONE
						LezioneDAO lettura = new LezioneDAO();
						int idLez = Integer.parseInt(lettura.getIDLezioneGiornoOra(Giorno, Ora).get(0)[0]);
						
						ConfermaCancellazioneIscrizioneTurnoGUI eliminazioneconferma = new ConfermaCancellazioneIscrizioneTurnoGUI(idTesserato,idLez);
						eliminazioneconferma.setVisible(true);
						
						
					}
				});
		
		
		
		
		
	}
}
		