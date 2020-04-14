package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;


public class ConsultaStatoEventiTesseratoGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaStatoEventiTesseratoGUI frame = new ConsultaStatoEventiTesseratoGUI();
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
	public ConsultaStatoEventiTesseratoGUI(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 584, 458);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 549, 40);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUESTO E' LO STATO DEI TUOI EVENTI:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		lblNewLabel.setBounds (10, 11, 529, 18);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds (10, 62, 549, 291);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		lblNome.setBounds(20, 26, 90, 28);
		panel_1.add(lblNome);
		
		JLabel lblStato = new JLabel("STATO");
		lblStato.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		lblStato.setBounds(300, 26, 90, 28);
		panel_1.add(lblStato);
		
		JLabel lblStatoPagamento = new JLabel("STATO PAGAMENTO");
		lblStatoPagamento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		lblStatoPagamento.setBounds(415, 26, 121, 28);
		panel_1.add(lblStatoPagamento);
		
		//DAO che prende l'id dell'utente e restituisce gli id degli eventi per i quali ha richiesto l'iscrizione
		
		EventoDAO letturaideventiiscrizioneeffettuata = new EventoDAO();
		
		
		int lunghezza = letturaideventiiscrizioneeffettuata.getIdEventiIscrizioneEffettuata(id).size();

	    //Creiamo degli array di label che conterranno per ogni evento rispettivamente il nome, lo stato dell'iscrizione e lo statoPagamento
		
		JLabel[] labelNome = new JLabel[lunghezza];
		JLabel[] labelStato = new JLabel[lunghezza];
		JLabel[] labelStatoPagamento = new JLabel[lunghezza];
		 
		
		
		//Inseriamo all'interno dell'i-esimo pannello l'i-esimo valore dei tre array di label
		int u=0;
	    for(int i = 0; i <lunghezza; i++ )
		{
			
			labelNome[i]=new JLabel();
			labelStato[i]=new JLabel();
			labelStatoPagamento[i]=new JLabel();
			
			//DAO che prende l'id dell'evento e ricava il nome
			
			EventoDAO ricavanomeevento = new EventoDAO();
            int idEvento = Integer.parseInt(letturaideventiiscrizioneeffettuata.getIdEventiIscrizioneEffettuata(id).get(i)[0]);
    		String nomeEvento = ricavanomeevento.getNomeEvento(idEvento).get(0)[0];
    		
    		//DAO che prende l'id dell'evento e ricava lo stato dell'iscrizione
		    EventoDAO ricavastatoevento= new EventoDAO();
            String statoEvento = ricavastatoevento.getStatoIscrizioneEvento(idEvento,id).get(0)[0];
            
            //DAO che prende l'id dell'evento e ricava lo statoPagamento
            EventoDAO ricavastatopagamentoevento = new EventoDAO();
            String statoPagamentoEvento = ricavastatopagamentoevento.getStatoPagamentoEvento(idEvento,id).get(0)[0];
            
            
			labelNome[i].setText(nomeEvento);
			labelStato[i].setText(statoEvento);
			labelStatoPagamento[i].setText(statoPagamentoEvento);
			
			
			labelNome[i].setBounds(20, 65 + u , 225, 25);
			labelStato[i].setBounds(260, 65 + u , 110, 25);
			labelStatoPagamento[i].setBounds(430, 65 + u , 110, 25);
			
			labelNome[i].setHorizontalAlignment(SwingConstants.LEFT);
			labelStato[i].setHorizontalAlignment(SwingConstants.CENTER);
			labelStatoPagamento[i].setHorizontalAlignment(SwingConstants.LEFT);
			
			
			panel_1.add(labelNome[i]);
			panel_1.add(labelStato[i]);
			panel_1.add(labelStatoPagamento[i]);
			
			u= u + 40;	
			
		}
		
	
			
						
		JButton btnChiudi = new JButton("CHIUDI");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finestra.dispose();
			}
		});
		btnChiudi.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnChiudi.setBounds(226, 366, 125, 42);
		contentPane.add(btnChiudi);
		
		
	
	}
}
