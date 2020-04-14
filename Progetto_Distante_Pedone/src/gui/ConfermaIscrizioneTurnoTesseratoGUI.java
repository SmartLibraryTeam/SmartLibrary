package gui;

import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.UtenteRegistratoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class ConfermaIscrizioneTurnoTesseratoGUI extends JFrame {

	private JPanel contentPane;
	public String Nome;
	public String Cognome;
	public String modalit‡pagamento;
	public int idTesserato;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfermaIscrizioneTurnoTesseratoGUI frame = new ConfermaIscrizioneTurnoTesseratoGUI();
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
	public ConfermaIscrizioneTurnoTesseratoGUI(Vector<String[]> idtesserati, int idlezione) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 310, 293);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 274, 173);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScegliTesserato = new JLabel("Scegli Tesserato");
		lblScegliTesserato.setBounds(10, 11, 191, 24);
		panel.add(lblScegliTesserato);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 35, 254, 24);
		panel.add(comboBox);
		
		/*Popoliamo la combobox con il nome e il cognome dei tesserati che hanno richiesto l'iscrizione alla lezione e per i quali 
		 * iscrizione_disciplina nel db ha StatoPagamento = Non pagato */
	
		int lunghezza1 = idtesserati.size();
		System.out.println("lunghezza Ë : " + lunghezza1);
		int y = 0;
		
		
	    UtenteRegistratoDAO ricavanome = new UtenteRegistratoDAO();
		while( y < lunghezza1)
			
		{
		    //DAO CHE PRENDE L'ID DEL TESSERATO E RESTITUISCE IL NOME E IL COGNOME 
			int id1 = Integer.parseInt(idtesserati.get(y)[0]);
			System.out.println(id1);
		    Nome = ricavanome.getNomeUtente(id1).get(0)[0];
		    Cognome= ricavanome.getNomeUtente (id1).get(0)[1];
	        System.out.println(Nome);
	        System.out.println(Cognome); 
	        comboBox.addItem(Nome +"  "+ Cognome);
	        y++;
		} 
		
	
		
		
		JLabel lblIlTesseratoHa = new JLabel("<html>IL TESSERATO HA EFFETTUATO IL PAGAMENTO <br> TRAMITE LA SEGUENTE MODALITA':  <html>");
		lblIlTesseratoHa.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblIlTesseratoHa.setBounds(10, 89, 239, 42);
		panel.add(lblIlTesseratoHa);
	
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 199, 274, 48);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnConfermaAvvenutoPagamento = new JButton("CONFERMA AVVENUTO PAGAMENTO");
		btnConfermaAvvenutoPagamento.setBounds(10, 11, 254, 23);
		panel_1.add(btnConfermaAvvenutoPagamento);
		
		JLabel lblNewLabel = new JLabel();
		//Stampiamo la modalit‡ di pagamento nel label
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(82, 142, 119, 20);
		panel.add(lblNewLabel);
		
		comboBox.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.out.println("Ho cliccato");
				
				Object oggetto = comboBox.getSelectedItem();
				String stringa = oggetto.toString();
				
				String[] nomecognome  = new String[2];
				nomecognome = stringa.split("  ");
				
				String nome = nomecognome[0];
				String cognome = nomecognome[1];
				

				UtenteRegistratoDAO ricavanome1 = new UtenteRegistratoDAO();
				int idTesserato = ricavanome1.getIdFromNomeCognome(nome ,cognome);
				
				//Dao che prende l'id del tesserato e l'id della lezione e restituisce la modalit‡ di pagamento
				DisciplinaDAO ricavamodalit‡ = new DisciplinaDAO();
				modalit‡pagamento = ricavamodalit‡.getModalit‡PagamentoDisciplina (idTesserato, idlezione);
				
				
			    //Stampiamo la modalit‡ di pagamento nel label
				lblNewLabel.setText(modalit‡pagamento);
				
				
				
			}
		});
		
		
		btnConfermaAvvenutoPagamento.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				Object oggetto = comboBox.getSelectedItem();
				String stringa = oggetto.toString();
				
				String[] nomecognome  = new String[2];
				nomecognome = stringa.split("  ");
				
				String nome = nomecognome[0];
				String cognome = nomecognome[1];
				

				UtenteRegistratoDAO ricavanome1 = new UtenteRegistratoDAO();
				int idTesserato = ricavanome1.getIdFromNomeCognome(nome ,cognome);
				
			    DisciplinaDAO modificastato =  new DisciplinaDAO();
				modificastato.setStatoPagamento (idTesserato, idlezione);
				
				
				JFrame statopagamentomodificato = new JFrame();
				JOptionPane.showMessageDialog( statopagamentomodificato ,"IL PAGAMENTO E' STATO SALVATO CORRETTAMENTE");
				
			//	finestra.dispose();
			
				
				//GestisciTurnoGUI gestisciturno1 = new GestisciTurnoGUI(giorno, ora);
				//gestisciturno1.setVisible(true);
				
			}
		});
		
	}
}

