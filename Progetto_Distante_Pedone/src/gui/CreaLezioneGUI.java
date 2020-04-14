package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.LezioneDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CreaLezioneGUI extends JFrame {

	private JPanel contentPane;
	public String nomeDisciplina;
	
	public String disciplina;
	public String livello;
	public String giorno;
	public String ora;
	
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreaLezioneGUI frame = new CreaLezioneGUI();
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
	public CreaLezioneGUI( JFrame finestra1 , String aula,int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 299, 423);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCreaUnaNuova = new JLabel("CREA UNA NUOVA LEZIONE");
		lblCreaUnaNuova.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		lblCreaUnaNuova.setBounds(71, 11, 146, 27);
		contentPane.add(lblCreaUnaNuova);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 36, 258, 132);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScegliLaDisciplina = new JLabel("Scegli la Disciplina :");
		lblScegliLaDisciplina.setBounds(10, 11, 294, 14);
		panel.add(lblScegliLaDisciplina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 36, 238, 20);
		panel.add(comboBox);
		
		JLabel lblScegliIlLivello = new JLabel("Scegli il Livello:");
		lblScegliIlLivello.setBounds(10, 67, 238, 20);
		panel.add(lblScegliIlLivello);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 87, 238, 20);
		panel.add(comboBox_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 323, 258, 50);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCrea = new JButton("CREA");
		
		btnCrea.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		btnCrea.setBounds(82, 11, 96, 28);
		panel_1.add(btnCrea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 179, 258, 132);
		contentPane.add(panel_2);
		
		JLabel lblScegliIlGiorno = new JLabel("Scegli il giorno :");
		lblScegliIlGiorno.setBounds(10, 11, 238, 14);
		panel_2.add(lblScegliIlGiorno);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.addItem("Lunedì");
		comboBox_2.addItem("Martedì");
		comboBox_2.addItem("Mercoledì");
		comboBox_2.addItem("Giovedì");
		comboBox_2.addItem("Venerdì");
		comboBox_2.addItem("Sabato");
		
		comboBox_2.setBounds(10, 36, 238, 20);
		panel_2.add(comboBox_2);
		
		JLabel lblScegliLoraTra = new JLabel("Scegli l'ora tra quelle disponibili:");
		lblScegliLoraTra.setBounds(10, 67, 238, 20);
		panel_2.add(lblScegliLoraTra);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(10, 87, 238, 20);
		panel_2.add(comboBox_3);
		
		
		//DAO CHE POPOLA LA COMBOBOX CON TUTTE LE DISCIPLINE (L'ISTRUTTORE HA LA POSSIBILITA' DI AGGIUNGERE LEZIONI DI LE TUTTE LE DISCIPLINE)
        DisciplinaDAO letturadiscipline = new DisciplinaDAO();
	
		int y = 0;
		
		while( y < letturadiscipline.getDiscipline().size())
		{
			System.out.println(letturadiscipline.getDiscipline().get(y)[0]);
			
			comboBox.addItem(letturadiscipline.getDiscipline().get(y)[0]);
			
			y++;
		}
		
		
		
		
		comboBox.addActionListener(new ActionListener() 	
		
		{
			
				
			public void actionPerformed(ActionEvent arg0) 
				
			{
				//DAO CHE POPOLA LA COMBOBOX LIVELLI SCELTA LA DISCIPLINA
				
				//Cancello se sono presenti i livelli
				DefaultComboBoxModel model = (DefaultComboBoxModel)comboBox_1.getModel();
				model.removeAllElements();
				
				//PRELEVIAMO IL VALORE DI DISCIPLINA
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				nomeDisciplina = selectedItem.toString();
				
				//System.out.println("LA DISCIPLINA SCELTA E' :   " + nomeDisciplina);
					
				DisciplinaDAO letturalivellidisciplina = new DisciplinaDAO();
				
				//System.out.println("NUMERO LIVELLI = " + letturalivellidisciplina.getLivello(nomeDisciplina).size() );
				
				int y = 0;
				
				//int Lunghezza = letturalivellidisciplina.getLivello(nomeDisciplina).size();
				
				while( y < letturalivellidisciplina.getLivelloDisciplina(nomeDisciplina).size())
				{
					System.out.println(letturalivellidisciplina.getLivelloDisciplina(nomeDisciplina).get(y)[0]);
					
					comboBox_1.addItem(letturalivellidisciplina.getLivelloDisciplina(nomeDisciplina).get(y)[0]);
					
					y++;
				}
				
			}
			
			
			
		});
		
		comboBox_2.addActionListener(new ActionListener() 
		{

			public void actionPerformed(ActionEvent arg0) 
			{
				//DAO CHE RICAVA I GIORNI DISPONIBILI
				
				//Array con tutte le ore disponibili
				
				String[] oredisponibili = new String[11];
				
				oredisponibili[0]="09:00:00";
				oredisponibili[1]="10:00:00";
				oredisponibili[2]="11:00:00";
				oredisponibili[3]="12:00:00";
				oredisponibili[4]="15:00:00";
				oredisponibili[5]="16:00:00";
				oredisponibili[6]="17:00:00";
				oredisponibili[7]="18:00:00";
				oredisponibili[8]="19:00:00";
				oredisponibili[9]="20:00:00";
				oredisponibili[10]="21:00:00";
				
				//Prendo il valore del giorno scelto
				
				Object selectedItem = new Object();
				selectedItem = comboBox_2.getSelectedItem();
				giorno = selectedItem.toString();
				
				//Dao che prende il giorno e ritorna gli orari disponibili
				LezioneDAO oraridisponibili = new LezioneDAO();
				
				int lunghezza = oraridisponibili.getOraCreaLezione(giorno, oredisponibili,aula).length;
				
				
				
				DefaultComboBoxModel model = (DefaultComboBoxModel)comboBox_3.getModel();
				model.removeAllElements();
				
				for(int i = 0; i < lunghezza; i++ )
				{
					//Elimino valori combobox orari se sono già presenti;
					
					
					
					if(oraridisponibili.getOraCreaLezione(giorno,oredisponibili,aula)[i].compareTo("-") != 0)
					{
						
						//Assegna valore alla combobox
						comboBox_3.addItem(oraridisponibili.getOraCreaLezione(giorno,oredisponibili,aula)[i]);
						
						
					}
					
					
				}
						
				
			}
		});
		
		btnCrea.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//DAO CHE CREA LEZIONE
				
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				disciplina = selectedItem.toString();
				
				Object selectedItem1 = new Object();
				selectedItem1 = comboBox_1.getSelectedItem();
				livello = selectedItem1.toString();
				
				Object selectedItem2 = new Object();
				selectedItem2 = comboBox_2.getSelectedItem();
				giorno = selectedItem2.toString();
				
				Object selectedItem3 = new Object();
				selectedItem3 = comboBox_3.getSelectedItem();
				ora = selectedItem3.toString();
				
				//VERIFICA CHE NON CI SIA UNA LEZIONE GIA' QUEL GIORNO
				LezioneDAO verificalezione = new LezioneDAO();
				DisciplinaDAO ricavaid = new DisciplinaDAO();
				
				int idDisc = ricavaid.getIdDisciplina(disciplina, livello);
				
				if(verificalezione.verificaGiornoLezione(giorno, idDisc))
				{
					JFrame lezionepresente = new JFrame();
					JOptionPane.showMessageDialog(lezionepresente,"E' già presente una lezione di  " + nomeDisciplina + " " + livello + " il " +giorno);
				}
				else
				{
							
				
					LezioneDAO aggiuntaLezione =  new LezioneDAO();
				
				
					aggiuntaLezione.setLezione(disciplina, livello, giorno, ora, aula);
				
				
					JFrame lezionecreata = new JFrame();
					
				
					JOptionPane.showMessageDialog(lezionecreata,"LA LEZIONE E' STATA CREATA CORRETTAMENTE");
				
					
					finestra.dispose();
				
					//AGGIORNAMENTO ORARIO IN TEMPO REALE
				
					finestra1.dispose();
				
				
					OrarioComplessivoDisciplineGUI orarioaggiornato = new OrarioComplessivoDisciplineGUI(aula,id);
				
					orarioaggiornato.setVisible(true);
				
				}
				
			}
		});
		
		
		
	}
}
