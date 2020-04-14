package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import business.DirectoryCorrente;

import DAO.DisciplinaDAO;
import DAO.EventoDAO;
import DAO.LezioneDAO;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import java.awt.Color;





public class IscrizioneEventoTesseratoGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;
	private JTextField textField;
	public String nomedocumento;
	public String path;
	public File fileselezionatoingresso;
	public String modalitàpagamento;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IscrizioneEventoTesseratoGUI frame = new IscrizioneEventoTesseratoGUI();
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
	public IscrizioneEventoTesseratoGUI (String nomeEvento, int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 50, 545, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 524, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConsultaIDati = new JLabel("ISCRIVITI ALL'EVENTO");
		lblConsultaIDati.setBackground(Color.WHITE);
		lblConsultaIDati.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaIDati.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblConsultaIDati.setBounds(111, 11, 301, 26);
		panel.add(lblConsultaIDati);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 78, 524, 71);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//Salviamo nella stringa nomeevento il valore di nomeEvento
		String nomeevento = nomeEvento;
		
		JLabel lblNomeEvento = new JLabel("NOME EVENTO ");
		lblNomeEvento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNomeEvento.setBounds(22, 11, 93, 20);
		panel_1.add(lblNomeEvento);
		
		JLabel lblTipoEvento = new JLabel("TIPO EVENTO");
		lblTipoEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoEvento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblTipoEvento.setBounds(367, 11, 93, 20);
		panel_1.add(lblTipoEvento);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//Rendiamo visibile il nome dell'evento nel label
		lblNewLabel.setText(nomeevento);
		
		lblNewLabel.setBounds(22, 36, 285, 20);
		panel_1.add(lblNewLabel);
		
		//Vogliamo ricavare il tipo dell'evento
		
		//DAO CHE PRENDE IL NOME DELL'EVENTO E RESTITUISCE IL TIPO ( PRENDE STRING E RITORNA VECTOR )
	    EventoDAO ricavatipoevento = new EventoDAO();
	    String tipoEvento = ricavatipoevento.getTipoEvento(nomeEvento).get(0)[0];
		System.out.println(tipoEvento);
				
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		//Rendiamo visibile il tipo dell'evento nel label
		lblNewLabel_1.setText(tipoEvento);
		lblNewLabel_1.setBounds(357, 36, 103, 20);
		panel_1.add(lblNewLabel_1);
		
		
		
		
		
		//Vogliamo ricavare la disciplina a cui appartiene l'evento
		
		//DAO CHE PRENDE IN INGRESSO IL NOME DELL'EVENTO E RESTITUISCE L'ID DELLA DISCIPLINA
		EventoDAO ricavaiddisciplina = new EventoDAO();
	    int idDisc = Integer.parseInt(ricavaiddisciplina .getIdDisciplina (nomeEvento).get(0)[0]);
	    System.out.println(idDisc);
					    
					    
	    //DAO CHE PRENDE L'ID DELLA DISCIPLINA E RESTITUISCE IL SUO NOME
		DisciplinaDAO ricavanomedisciplina = new DisciplinaDAO();
	    String nomeDisc = ricavanomedisciplina.getNomeDisciplina (idDisc).get(0)[0];
	    System.out.println(nomeDisc);
	    
	    
        //Vogliamo ricavare il livello della disciplina a cui appartiene l'evento
		
	    //DAO CHE PRENDE L'ID DELLA DISCIPLINA E RESTITUISCE IL SUO LIVELLO
	    DisciplinaDAO ricavalivellodisciplina = new DisciplinaDAO();
	  	String livelloDisc = ricavalivellodisciplina.getLivelloDisciplina (idDisc).get(0)[0];
	  	System.out.println(livelloDisc);
	  				
		
						
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 170, 524, 71);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("DISCIPLINA");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(22, 11, 93, 20);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LIVELLO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(389, 11, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//Rendiamo visibile il nome della disciplina nel label
	    lblNewLabel_4.setText(nomeDisc);
		lblNewLabel_4.setBounds(22, 36, 285, 20);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//Rendiamo visibile il livello della disciplina nel label
	    lblNewLabel_8.setText(livelloDisc);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(366, 36, 103, 20);
		panel_2.add(lblNewLabel_8);
		
		//Vogliamo ricavare il giorno e l'ora in cui si svolgerà l'evento
		
		//DAO CHE PRENDE IN INGRESSO IL NOME DELL'EVENTO E RESTITUISCE L'ID DELLA LEZIONE

		EventoDAO letturaidlezione = new EventoDAO();
		int idLez = Integer.parseInt(letturaidlezione.getIdLezione (nomeEvento).get(0)[0] ); 
				
		//DAO CHE PRENDE L'ID DELLA LEZIONE E RESTITUISCE IL GIORNO IN CUI SI SVOLGERA' L'EVENTO
	    LezioneDAO ricavagiorno = new LezioneDAO();
		String giorno = ricavagiorno.getGiornoEvento(idLez).get(0)[0];
		System.out.println(giorno);
				
		//DAO CHE PRENDE L'ID DELLA LEZIONE E RESTITUISCE L'ORA IN CUI SI SVOLGERA' L'EVENTO
		LezioneDAO ricavaora = new LezioneDAO();
		String ora = ricavaora.getOraEvento(idLez).get(0)[0];
		System.out.println(ora);
		
	    EventoDAO ricavacosto = new EventoDAO();
		int costo = Integer.parseInt(ricavacosto.getCostoEvento(nomeEvento).get(0)[0]);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 258, 524, 83);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//Rendiamo visibile il giorno dell'evento nel label
	    lblNewLabel_6.setText(giorno);
		lblNewLabel_6.setBounds(22, 36, 285, 20);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		//Rendiamo visibile l'ora dell'evento nel label
		lblNewLabel_7.setText(ora);
		lblNewLabel_7.setBounds(360, 36, 103, 20);
		panel_3.add(lblNewLabel_7);
	    JLabel lblData = new JLabel("GIORNO");
		lblData.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblData.setBounds(22, 11, 93, 20);
		panel_3.add(lblData);
		
		JLabel lblOra = new JLabel("ORA");
		lblOra.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblOra.setHorizontalAlignment(SwingConstants.CENTER);
		lblOra.setBounds(389, 11, 46, 14);
		panel_3.add(lblOra);
		
		//DAO CHE PRENDE IN INGRESSO IL NOME DELL'EVENTO E RESTITUISCE IL TIPO
		EventoDAO ricavatipoevento1 = new EventoDAO();
		
		//Se l'evento è una gara, avvertiamo l'utente che è necessario inserire la dichiarazione di sana e robusta costituzione
		
	     if (ricavatipoevento1.getTipoEvento(nomeEvento).get(0)[0].equals("Gara"))
	   {
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 342, 524, 180);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 132, 151, 23);
		panel_5.add(textField);
		textField.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(164, 132, 80, 23);
		panel_5.add(btnNewButton);
		
		
		//Cliccando il bottone "search" è possibile selezionare il certificato tra i propri documenti e salvare il percorso del file
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
                 JFileChooser chooser = new JFileChooser();
				
				if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION)
				{
				
					fileselezionatoingresso = chooser.getSelectedFile();
					
					textField.setText(fileselezionatoingresso.getPath());
					
					
					//SALVA IL PERCORSO DEL FILE
					path = fileselezionatoingresso.getPath();
					
					//PREPARA LA STRINGA PER PRELEVARE IL NOME DEL FILE
					
					path = path.replace("\\", "/");
					
					//RICAVA LE VARIE CARTELLE DEL PERCORSO E LE SALVA IN UN ARRAY
					String[] items = path.split("/");
					
					//CALCOLA LUNGHEZZA DEI LIVELLI DELLE CARTELLE
					int lunghezza = items.length;
					
					//PRENDE L'ULTIMO LIVELLO, CIOE' IL NOME DEL DOCUMENTO
					nomedocumento = new String(items[lunghezza - 1]);
					
					
				}
			}
		});
		
		JLabel lblAttenzioneIlTipo = new JLabel("<html>Il tipo di evento scelto è una GARA. <br> E' necessario fornire la <br> DICHIARAZIONE DI SANA E ROBUSTA COSTITUZIONE in formato PDF <html> ");
		lblAttenzioneIlTipo.setVerticalAlignment(SwingConstants.TOP);
		lblAttenzioneIlTipo.setBounds(22, 40, 205, 90);
		panel_5.add(lblAttenzioneIlTipo);
		
	    JLabel lblAttenzione = new JLabel("ATTENZIONE!");
		lblAttenzione.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		lblAttenzione.setHorizontalAlignment(SwingConstants.CENTER);
		lblAttenzione.setBounds(42, 24, 119, 14);
		panel_5.add(lblAttenzione);
		
		JLabel lblModalitaDiPagamento = new JLabel("MODALITA' DI PAGAMENTO");
		lblModalitaDiPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblModalitaDiPagamento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblModalitaDiPagamento.setBounds(330, 24, 157, 14);
		panel_5.add(lblModalitaDiPagamento);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox.setBounds(330, 45, 151, 20);
		if( costo !=0)
		{
		comboBox.addItem("Contanti");

		comboBox.addItem("Carta di credito");

		comboBox.addItem("Paypal");
		
		panel_5.add(comboBox);
		}
		else
		{
			comboBox.addItem("Non Previsto");
		}
		

		JButton btnOk = new JButton("INVIA RICHIESTA ISCRIZIONE");
		btnOk.setBounds(250, 132, 207, 23);
		panel_5.add(btnOk);
		/*Cliccando il bottone "invia richiesta iscrizione" è possibile richiedere l' iscrizione all'evento e copiare
		 * il file del certificato nella cartella dei documenti*/
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//Controlliamo che l'utente abbia inserito il certificato 
				//Se non lo ha inserito, lo avvisiamo con un messaggio
				if(textField.getText().equals(""))
				{
				JFrame certificatononinserito = new JFrame();
				JOptionPane.showMessageDialog( certificatononinserito," Attenzione, non hai inserito il certificato di sana e robusta costituzione!");
				}
				
				
				/*Se ha inserito il certificato, è possibile procedere all'invio della richiesta
				e alla copia del file del certificato nella cartella dei documenti*/
				else
				{
				//DAO CHE PRENDE IN INGRESSO IL NOME DELL'EVENTO E RESTITUISCE L'ID DELL'EVENTO
                  EventoDAO ricavaid =new EventoDAO();
                  int idEvento = ricavaid.getIdEvento(nomeEvento);
                  
                //Salviamo la modalità di pagamento selezionata in una stringa  
                  Object selectedItem = new Object();
 				  selectedItem = comboBox.getSelectedItem();
 				  modalitàpagamento = selectedItem.toString();
 				  
 				//DAO che popola la tabella `iscrizione_evento`
 				  EventoDAO iscrizioneevento =  new EventoDAO();
 				  iscrizioneevento.setAggiuntaEventoGara(idEvento, id, modalitàpagamento);
 				  
 				  finestra.dispose();
				
 				 
		        //COPIA IL FILE NELLA CARTELLA DEI DOCUMENTI
				
		        File sfile = new File(path);
		        
		        DirectoryCorrente percorsoProgramma = new DirectoryCorrente();
				String DirectoryProgramma = percorsoProgramma.getDir().replace("\\", "/");
				
				File dfile = new File(DirectoryProgramma+"/documents/CertificatoUtente-" + id + ".pdf");
				
				try 
				{
					
					FileInputStream fileInputStream = new FileInputStream(sfile);
					FileOutputStream fileOutputStream = new FileOutputStream(dfile);
					
					FileChannel source = fileInputStream.getChannel();
					FileChannel dest = fileOutputStream.getChannel();
					source.transferTo(0, source.size(), dest);
					source.close();
					dest.close();
					fileInputStream.close();
					fileOutputStream.close();
					
				}
				catch (FileNotFoundException e2) 
				{
					
					e2.printStackTrace();
				}
				catch (IOException e1) 
				{
					
					e1.printStackTrace();
				}
				 
			
			}
	      }
		});
	   }

	   else
	   {
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 342, 524, 155);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		
		JLabel lblModalitaDiPagamento = new JLabel("MODALITA' DI PAGAMENTO");
		lblModalitaDiPagamento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblModalitaDiPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblModalitaDiPagamento.setBounds(10, 27, 157, 14);
		panel_5.add(lblModalitaDiPagamento);
		
		
		JComboBox comboBox1 = new JComboBox();
		comboBox1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		comboBox1.setBounds(20, 52, 151, 20);
		
		if( costo != 0)
		{
		comboBox1.addItem("Contanti");

		comboBox1.addItem("Carta di credito");

		comboBox1.addItem("Paypal");
		}
		else
		{
			comboBox1.addItem("Non Previsto");
		}
			
		
		
	     panel_5.add(comboBox1);
		
		
		JButton btnOk = new JButton("INVIA RICHIESTA ISCRIZIONE");
		btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		btnOk.setBounds(181, 121, 207, 23);
		panel_5.add(btnOk);
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
		

		       //DAO CHE PRENDE IN INGRESSO IL NOME DELL'EVENTO E RESTITUISCE L'ID DELL'EVENTO
                 EventoDAO ricavaid = new EventoDAO();
                 int idEvento = ricavaid.getIdEvento(nomeEvento);
          
		
		       //Salviamo la modalità di pagamento selezionata in una stringa  
                 Object selectedItem = new Object();
		         selectedItem = comboBox1.getSelectedItem();
		         String modalitàpagamento= new String();
		         modalitàpagamento = selectedItem.toString();
		         
		       //DAO che popola la tabella `iscrizione_evento`
				 EventoDAO iscrizioneevento =  new EventoDAO ();
				 iscrizioneevento.setAggiuntaEventoStage(idEvento, id, modalitàpagamento);
				 finestra.dispose();
				
            }
			
		});
		
	   }
	}
}
		
		

		
	
	

