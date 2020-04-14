package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;

import business.DirectoryCorrente;

import DAO.DisciplinaDAO;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.awt.event.ActionEvent;





public class ModificaDisciplinaGUI extends JFrame 
{

	public JPanel contentPane;
	public JTextField txtRss;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField;
	public String Costo;
	public JFrame finestra = this;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificaDisciplinaGUI frame = new ModificaDisciplinaGUI();
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
	public ModificaDisciplinaGUI(String disciplina,String livello)
	{
		
		//DAO CHE SERVE PER STAMPARE I DATI ALL'INTERNO DEI PANEL ED EVITARE I NULL IN CASO DI NON MODIFICA
		//prende in ingresso il nome della disciplina e il livello e ritorna array che serve per popolare i panel
		

		DisciplinaDAO letturaid = new DisciplinaDAO();
		
		int ID = letturaid.getIdDisciplina(disciplina, livello);
		
		DisciplinaDAO letturadatidiscipline = new DisciplinaDAO();
		
		int lunghezza = letturadatidiscipline.getDatiDisciplinaFromId(ID).size();
		
		
		int COD_DISCIPLINA = Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID).get(0)[0]);//0
		
		String NOMEDISCIPLINA = new String();
		
		NOMEDISCIPLINA = letturadatidiscipline.getDatiDisciplinaFromId(ID).get(0)[1];//1
		
		String LIVELLO = new String();
		
		LIVELLO = letturadatidiscipline.getDatiDisciplinaFromId(ID).get(0)[2];//2
		
		String DESCRIZIONE = new String();
		DESCRIZIONE = letturadatidiscipline.getDatiDisciplinaFromId(ID).get(0)[3];//3
		
		String PERCORSOFILE = new String();
		
		DirectoryCorrente percorsoProgramma = new DirectoryCorrente();
		String DirectoryProgramma = percorsoProgramma.getDir().replace("\\", "/");
		
		PERCORSOFILE = DirectoryProgramma +"/img/" + letturadatidiscipline.getDatiDisciplinaFromId(ID).get(0)[4];//4
		
		String COSTO = letturadatidiscipline.getDatiDisciplinaFromId(ID).get(0)[5];//5
		
		String COD_ISTRUTTORE = letturadatidiscipline.getDatiDisciplinaFromId(ID).get(0)[6];//6
		
		String COD_RESPONSABILE= letturadatidiscipline.getDatiDisciplinaFromId(ID).get(0)[7];//7
		
		
		setTitle("ModificaDisciplina");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(20, 57, 493, 428);
		contentPane.add(panel_1);
		
		txtRss = new JTextField();
		txtRss.setText(NOMEDISCIPLINA);
		txtRss.setColumns(10);
		txtRss.setBounds(25, 19, 458, 27);
		panel_1.add(txtRss);
		
		JLabel lblIdResponsabileCentro = new JLabel("ID Responsabile Centro ");
		lblIdResponsabileCentro.setBounds(326, 167, 126, 14);
		panel_1.add(lblIdResponsabileCentro);
		
		textField_1 = new JTextField();
		textField_1.setText(COD_RESPONSABILE);
		textField_1.setColumns(10);
		textField_1.setBounds(326, 192, 157, 20);
		panel_1.add(textField_1);
		
		JLabel lblCosto = new JLabel("Costo\r\n");
		lblCosto.setBounds(326, 223, 68, 14);
		panel_1.add(lblCosto);
		
		JButton btnNewButton = new JButton("CONFERMA");
		
		btnNewButton.setBounds(344, 279, 103, 32);
		panel_1.add(btnNewButton);
		
		textField_2 = new JTextField();
		textField_2.setText(COD_ISTRUTTORE);
		textField_2.setColumns(10);
		textField_2.setBounds(326, 136, 157, 20);
		panel_1.add(textField_2);
		
		JLabel lblIdIstruttore = new JLabel("ID Istruttore");
		lblIdIstruttore.setBounds(326, 108, 126, 14);
		panel_1.add(lblIdIstruttore);
		
		/*textField_3 = new JTextField();
		textField_3.setText(DESCRIZIONE);
		textField_3.setColumns(10);
		textField_3.setBounds(25, 82, 268, 130);
		panel_1.add(textField_3);*/
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setText(DESCRIZIONE);
		editorPane.setBounds(25, 82, 268, 130);
		panel_1.add(editorPane);
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(25, 57, 126, 14);
		panel_1.add(lblDescrizione);
		
		JLabel lblImmginePercorso = new JLabel("Immagine ( Percorso File )");
		lblImmginePercorso.setBounds(25, 223, 126, 14);
		panel_1.add(lblImmginePercorso);
		
		textField_4 = new JTextField();
		textField_4.setText(PERCORSOFILE);
		textField_4.setColumns(10);
		textField_4.setBounds(25, 248, 192, 20);
		panel_1.add(textField_4);
		
		JLabel lblLivello = new JLabel("Livello");
		lblLivello.setBounds(326, 59, 137, 14);
		panel_1.add(lblLivello);
		
		JLabel lblNomeDisciplina_1 = new JLabel("Nome Disciplina");
		lblNomeDisciplina_1.setBounds(25, 0, 169, 14);
		panel_1.add(lblNomeDisciplina_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(321, 77, 162, 20);
		panel_1.add(comboBox);
		
		
		// IF PER POPOLARE LA COMBOBOX A SECONDA DEL LIVELLO GIA' PRESENTE
		if (LIVELLO.equals("Principiante"))
		{
			comboBox.addItem("Principiante");

			comboBox.addItem("Amatoriale");

			comboBox.addItem("Agonistico");
		}
		else if (LIVELLO.equals("Amatoriale"))
		{
			comboBox.addItem("Amatoriale");
			
			comboBox.addItem("Principiante");
			
			comboBox.addItem("Agonistico");
		}
		else
		{
			comboBox.addItem("Agonistico");
			
			comboBox.addItem("Principiante");

			comboBox.addItem("Amatoriale");
			
		}
	
		
		textField = new JTextField();
		textField.setText(COSTO);
		textField.setBounds(326, 248, 157, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(218, 246, 75, 27);
		panel_1.add(btnSearch);
		
		JLabel label = new JLabel("");
		//adattamento immagine al label
		ImageIcon image = new ImageIcon(PERCORSOFILE);
		Image IMAGE = image.getImage();
		IMAGE = IMAGE.getScaledInstance(223, 129, IMAGE.SCALE_REPLICATE);
		image.setImage(IMAGE);
		
		label.setIcon(image);
		label.setBounds(45, 288, 223, 129);
		panel_1.add(label);
		
		JLabel lblNomeDisciplina = new JLabel("Nome Disciplina");
		lblNomeDisciplina.setBounds(45, 67, 185, 20);
		contentPane.add(lblNomeDisciplina);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 493, 35);
		
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInserisciIDati = new JLabel("MODIFICA I DATI DI UNA DISCIPLINA ESISTENTE\r\n");
		lblInserisciIDati.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciIDati.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblInserisciIDati.setBounds(65, 11, 357, 23);
		panel.add(lblInserisciIDati);
	
		//BOTTONE CERCA
		btnSearch.addActionListener(new ActionListener() {
				
					public void actionPerformed(ActionEvent arg0) {
					
					JFileChooser chooser = new JFileChooser();
					
					if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
					{
						
					
						//	SELEZIONE DEL FILE DAL TASTO "SEARCH" 
						
						File fileselezionatoingresso = chooser.getSelectedFile();
						
						//MOSTRA LA FOTO APPENA SCELTA
						ImageIcon image = new ImageIcon(fileselezionatoingresso.getPath());
						Image IMAGE = image.getImage();
						IMAGE = IMAGE.getScaledInstance(223, 129, IMAGE.SCALE_REPLICATE);
						image.setImage(IMAGE);

						label.setIcon(image);
						
						//INSERISCE IL PERCORSO DELLA FOTO SCELTA NEL TEXTFIELD
						
						
						textField_4.setText(fileselezionatoingresso.getPath());
					
					}
				
					}
			
				});
	
		//BOTTONE CONFERMA
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				
				String livello = new String ();
				livello =selectedItem.toString();
				
				
				String nomeDisciplina = txtRss.getText();
				
				//String livello1 = selectedItem.toString();  //creaDisciplinaWindow.livello;
				
				//System.out.println("IL LIVELLO é "+ livello);
				
				int idIstruttore = Integer.parseInt (textField_2.getText());
				
				int idResponsabileCentro = Integer.parseInt(textField_1.getText());
				
				//System.out.println("IN MODIFICA DISCIPLINA GUI L'ISTRUTTORE è:" + idIstruttore + " e il responsabile è  " + idResponsabileCentro);
			
				double costo = Integer.parseInt (textField.getText());
				
				 Costo = textField.getText();
				
				 	//SALVA IL PERCORSO DEL FILE
					String path = textField_4.getText();
					
					//PREPARA LA STRINGA PER PRELEVARE IL NOME DEL FILE
					
					path = path.replace("\\", "/");
					
					//RICAVA LE VARIE CARTELLE DEL PERCORSO E LE SALVA IN UN ARRAY
					String[] items = path.split("/");
					
					//CALCOLA LUNGHEZZA DEI LIVELLI DELLE CARTELLE
					int lunghezza = items.length;
					
					//PRENDE L'ULTIMO LIVELLO, CIOE' IL NOME DELL'IMMAGINE
					String immagine = new String(items[lunghezza - 1]);
				
					String descrizione = editorPane.getText().replace("\n", "");
				
					DisciplinaDAO verificadisciplinanelDB = new DisciplinaDAO();
				        
				    String stringadaStampare = new String();
				    //stringadaStampare = "";
				        
				        
				    //RICAVA UN ARRAY DI STRINGHE CHE INDICANO I VALORI DA MODIFICARE CHE VERRANNO STAMPATI PER COMUNICARE CHE VALORI SONO STATI CAMBIATI
				   
				   int i =0; 
				  
				   int lunghezza1 = verificadisciplinanelDB.controlloDisciplina(nomeDisciplina, livello, descrizione,immagine,idResponsabileCentro,idIstruttore,Costo,COD_DISCIPLINA).size();
				   
				   System.out.println("lunghezza1 = " + lunghezza1);
				   
				   while(i < lunghezza1 )
				        
				    {	        		
				    	stringadaStampare = "<html>"+ stringadaStampare + "<br>" + verificadisciplinanelDB.controlloDisciplina(nomeDisciplina, livello, descrizione,immagine,idResponsabileCentro,idIstruttore,Costo,COD_DISCIPLINA).get(i)+ "<htlm>";
				        i++;
				    }	
				     
				   	
				   //SALVA L'IMMAGINE NELLA CARTELLA SE UNA DELLE OPERAZIONI DA FARE E' CAMBIARE L'IMMAGINE.
				    
				   int k =0;
				   
				    while( k < lunghezza1)
				   {
					   
					   if(verificadisciplinanelDB.controlloDisciplina(nomeDisciplina, livello, descrizione,immagine,idResponsabileCentro,idIstruttore,Costo,COD_DISCIPLINA).get(k).equals("Immagine"))
					   {
						   //COPIA IL FILE NELLA CARTELLA
						   
						   System.out.println("AGGIUNGO L'IMMAGINE!");
					
						   File sfile = new File(textField_4.getText());
						   System.out.println(sfile.getPath());
						  
						   File dfile = new File(DirectoryProgramma+"/img/"+ immagine);
						   System.out.println(dfile.getPath());
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
				   
					   k++;
				   }
				   
				   
				   System.out.println("STO PARTENDO CON LA MODIFICA DEI DATI");
				        
				    //MODIFICA I VALORI DELLA DISCIPLINA
						
				    DisciplinaDAO modificadisciplina = new DisciplinaDAO();
						
				    modificadisciplina.modificaDisciplinaEsistente(nomeDisciplina, livello, descrizione, immagine, idResponsabileCentro, idIstruttore, Costo,COD_DISCIPLINA);
				    
				   
				       
				    //STAMPA I VALORI ELIMINATI CON UN MESSAGGIO
				        
				    JFrame disciplinaesistente = new JFrame();
						
				    JOptionPane.showMessageDialog(disciplinaesistente,"<html>"+"Hai Modificato i seguenti campi:" + "<br>"+ stringadaStampare +"<html>");
				        
				   
				    finestra.dispose();
				    
				        
				    }
				
				
				
			
					
			
		});
	
		
   
	}

}

	
	