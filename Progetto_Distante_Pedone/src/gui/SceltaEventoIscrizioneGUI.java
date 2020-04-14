package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import DAO.EventoDAO;


public class SceltaEventoIscrizioneGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaEventoIscrizioneGUI frame = new SceltaEventoIscrizioneGUI();
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
	public SceltaEventoIscrizioneGUI(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 305, 178);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 269, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScegliUnEvento = new JLabel("SCEGLI UN EVENTO");
		lblScegliUnEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliUnEvento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblScegliUnEvento.setBounds(0, 11, 269, 26);
		panel.add(lblScegliUnEvento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 44, 269, 20);
		panel.add(comboBox);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 88, 269, 48);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
        //Popoliamo la combobox con tutti gli eventi disponibili nel db
	    EventoDAO letturaeventiiscrizione = new EventoDAO();
		
		System.out.println("NUMERO EVENTI= " + letturaeventiiscrizione.getEventiAccettati().size() );
		
		int y = 0;
		
		int lunghezza1 = letturaeventiiscrizione.getEventiAccettati().size();
		
		
		
		while( y < lunghezza1 )
		{
			System.out.println(letturaeventiiscrizione.getEventiAccettati().get(y)[0]);
			
			comboBox.addItem(letturaeventiiscrizione.getEventiAccettati().get(y)[0].toString());
			
			y++;
		}
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
		        //Salviamo in una stringa il nome dell'evento selezionato
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				String nomeEvento = new String();
			    nomeEvento = selectedItem.toString();
			  
			    
			    //DAO CHE PRENDE IN INGRESSO IL NOME DELL'EVENTO E RESTITUISCE L'ID DELL'EVENTO
                EventoDAO ricavaid = new EventoDAO();
                int idEvento = ricavaid.getIdEvento(nomeEvento);
			    
			    //DAO CHE VERIFICA SE L'UTENTE E' GIA' ISCRITTO ALL'EVENTO SELEZIONATO
			    EventoDAO verificaiscrizioneevento= new EventoDAO();
			    
			    /*Se la lunghezza del vettore restituito dal metodo controlloIscrizioneEvento(idEvento, id) è zero, allora la coppia 
			     * (idEvento, id) non compare in nessuna riga della tabella iscrizione_evento e quindi è possibile fare la domanda 
			     * d'iscrizione all'evento*/
			    
			    int lunghezza= verificaiscrizioneevento.controlloIscrizioneEvento(idEvento, id).size();
			    if(lunghezza == 0)
			    {
			    IscrizioneEventoTesseratoGUI iscrizioneevento= new IscrizioneEventoTesseratoGUI (nomeEvento, id);
				iscrizioneevento.setVisible(true);
				}
			    
			    //Se invece la coppia (idEvento, id) è già presente, avvisiamo l'utente che si è già iscritto all'evento selezionato*/
			    else
			    {
			    	JFrame iscrizionegiàrichiesta = new JFrame();
					JOptionPane.showMessageDialog( iscrizionegiàrichiesta ," Hai già richiesto l'iscrizione a questo evento!");
			    }
			}
		});
		btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnOk.setBounds(103, 11, 66, 23);
		panel_1.add(btnOk);
		
	}
}

