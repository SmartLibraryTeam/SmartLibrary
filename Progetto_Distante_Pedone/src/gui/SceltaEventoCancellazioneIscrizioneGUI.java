package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;


public class SceltaEventoCancellazioneIscrizioneGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaEventoCancellazioneIscrizioneGUI frame = new SceltaEventoCancellazioneIscrizioneGUI();
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
	public SceltaEventoCancellazioneIscrizioneGUI(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 308, 180);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 272, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScegl = new JLabel("SCEGLI UN EVENTO");
		lblScegl.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblScegl.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegl.setBounds(0, 11, 272, 26);
		panel.add(lblScegl);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 44, 272, 20);
		panel.add(comboBox);
		
		//Popoliamo la combobox con tutti gli eventi a cui l'utente è iscritto
		
		//DAO che prende l'id dell'utente e restituisce gli id degli eventi a cui egli è iscritto
		EventoDAO letturaideventiiscrizioneeffettuata = new EventoDAO();
		Vector<String[]> ideventi=  letturaideventiiscrizioneeffettuata.getIdEventiIscrizioneEffettuata(id);
		
		
		int y = 0;
		int lunghezza = letturaideventiiscrizioneeffettuata.getIdEventiIscrizioneEffettuata(id).size();
		while( y < lunghezza)
		{
			
			//DAO che premde l'id dell'evento e ricava il nome
			EventoDAO ricavanomeevento= new EventoDAO();
            int idEvento = Integer.parseInt(letturaideventiiscrizioneeffettuata.getIdEventiIscrizioneEffettuata(id).get(y)[0]);
    		String nomeEvento = ricavanomeevento.getNomeEvento(idEvento).get(0)[0];
			comboBox.addItem(nomeEvento);
			
			y++;
		}
				
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 88, 272, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				//Salviamo in una stringa il nome dell'evento selezionato
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				String nomeEvento = new String();
			    nomeEvento = selectedItem.toString();
			   
			    
			   
			    CancellazioneIscrizioneEventiGUI cancellaiscrizione = new CancellazioneIscrizioneEventiGUI(nomeEvento, id);
				cancellaiscrizione.setVisible(true);
				
			
			}
		});
		btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnOk.setBounds(103, 11, 66, 23);
		panel_1.add(btnOk);
		
		
	}
}
		
      
