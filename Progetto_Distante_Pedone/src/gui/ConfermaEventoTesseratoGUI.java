package gui;


import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import DAO.EventoDAO;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfermaEventoTesseratoGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfermaEventoTesseratoGUI frame = new ConfermaEventoTesseratoGUI();
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
	public ConfermaEventoTesseratoGUI( int idEvento,int idUtente) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 380, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIlTesseratoHa = new JLabel("Il tesserato ha fornito la certificazione");
		lblIlTesseratoHa.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlTesseratoHa.setBounds(10, 11, 344, 34);
		contentPane.add(lblIlTesseratoHa);
		
		JButton btnConsultaIlFile = new JButton("CONSULTA IL FILE ");
		
		btnConsultaIlFile.setBounds(20, 45, 334, 34);
		contentPane.add(btnConsultaIlFile);
		
		JLabel lblIlTesseratoHa_1 = new JLabel("Il tesserato ha scelto il seguente metodo di pagamento:");
		lblIlTesseratoHa_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblIlTesseratoHa_1.setBounds(10, 101, 344, 26);
		contentPane.add(lblIlTesseratoHa_1);
		
		//RICAVO MODALITA' DI PAGAMENTO DEL TESSERATO
		
		EventoDAO modalit‡PagamentoEvento = new EventoDAO();
		
		JLabel label = new JLabel(modalit‡PagamentoEvento.getModalit‡PagamentoEvento(idEvento, idUtente));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(20, 136, 334, 26);
		contentPane.add(label);
		
		JButton btnNewButton = new JButton("CONFERMA ISCRIZIONE E PAGAMENTO");
		btnNewButton.setBounds(30, 182, 304, 23);
		contentPane.add(btnNewButton);
		
		
		btnConsultaIlFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventoDAO tipoEvento = new EventoDAO();
				
			
				
					
				//LETTURA FILE
					
				if(tipoEvento.getTipoEventoFromId(idEvento).get(0)[0].toString().equals("Stage"))
				{
					JFrame stage = new JFrame();
					JOptionPane.showMessageDialog(stage,"Questo evento Ë uno STAGE. Il Tesserato non ha inserito alcun Certificato.");
					
				}
					
					
				else
					
				{
				
					
					String path = new String("C:/Users/PC/Desktop/Java/ProgettoDPMsport/documents/CertificatoUtente-" + idUtente + ".pdf" );
				
				
					File certificatoutente = new File(path);
				
					//APERTURA FILE
					try 
					{
					
						Desktop.getDesktop().open(certificatoutente);
				
					}
					catch (IOException e1) 
				
					{
					
						e1.printStackTrace();
					}
				
				
				}
			}
			
		});
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
				EventoDAO iscrizioneTesseratoEvento = new EventoDAO();
				iscrizioneTesseratoEvento.setStatoIscrizioneEvento(idEvento, idUtente);				
				
				
				JFrame iscrizioneEffettuata = new JFrame();
				JOptionPane.showMessageDialog(iscrizioneEffettuata,"L'utente Ë stato aggiunto!");
				
				finestra.dispose();
				
			}
		});
		
		
		
	}

}
