package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.io.*;
import java.awt.Image;


import business.DirectoryCorrente;

import DAO.DisciplinaDAO;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.nio.channels.FileChannel;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;



@SuppressWarnings("serial")
public class CreaDisciplinaGUI extends JFrame {

	public JPanel contentPane;
	public JTextField textField;
	public JTextField textField_1;
	public JTextField textField_2;
	public JTextField textField_3;
	public JTextField textField_4;
	public JTextField textField_5;
	public String livello;
	public String immagine;
    public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreaDisciplinaGUI frame = new CreaDisciplinaGUI();
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
	public CreaDisciplinaGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 539, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 57, 493, 524);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(25, 19, 458, 27);
		textField.setColumns(10);
		panel_1.add(textField);
		
		JLabel lblIdResponsabileCentro = new JLabel("ID Responsabile Centro ");
		lblIdResponsabileCentro.setBounds(326, 167, 157, 14);
		panel_1.add(lblIdResponsabileCentro);
		
		textField_1 = new JTextField();
		textField_1.setBounds(326, 192, 157, 20);
		textField_1.setColumns(10);
		panel_1.add(textField_1);
		
		JLabel lblCosto = new JLabel("Costo\r\n");
		lblCosto.setBounds(326, 223, 68, 14);
		panel_1.add(lblCosto);
		
		JButton btnConferma = new JButton("CONFERMA");	
		
		btnConferma.setBounds(367, 384, 103, 32);
		btnConferma.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		panel_1.add(btnConferma);

	    //btnConferma.addActionListener(new CreaDisciplinaListener(this));
		
		textField_2 = new JTextField();
		textField_2.setBounds(326, 136, 157, 20);
		textField_2.setColumns(10);
		panel_1.add(textField_2);
		
		JLabel lblIdIstruttore = new JLabel("ID Istruttore");
		lblIdIstruttore.setBounds(326, 108, 126, 14);
		panel_1.add(lblIdIstruttore);
		
		/*textField_3 = new JTextField();
		textField_3.setBounds(25, 82, 268, 130);
		textField_3.setColumns(10);
		panel_1.add(textField_3);*/
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(25, 82, 268, 130);
		panel_1.add(editorPane);
		
		
		JLabel lblDescrizione = new JLabel("Descrizione");
		lblDescrizione.setBounds(25, 57, 126, 14);
		panel_1.add(lblDescrizione);
		
		JLabel lblImmginePercorso = new JLabel("Immagine ( Percorso File )");
		lblImmginePercorso.setBounds(25, 223, 200, 14);
		panel_1.add(lblImmginePercorso);
		
		textField_4 = new JTextField();
		
		
		textField_4.setBounds(25, 248, 200, 29);
		textField_4.setColumns(10);
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
		
		comboBox.addItem("Principiante");

		comboBox.addItem("Amatoriale");

		comboBox.addItem("Agonistico");
		
		
	
		textField_5 = new JTextField();
		textField_5.setBounds(326, 248, 157, 20);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.setBounds(224, 248, 92, 29);
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(25, 288, 301, 225);
		panel_1.add(lblNewLabel);
		
		
		
		JLabel lblNomeDisciplina = new JLabel("Nome Disciplina");
		lblNomeDisciplina.setBounds(45, 67, 185, 20);
		contentPane.add(lblNomeDisciplina);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 11, 493, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInserisciIDati = new JLabel("INSERISCI I DATI PER CREARE UNA NUOVA DISCIPLINA");
		lblInserisciIDati.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciIDati.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblInserisciIDati.setBounds(65, 11, 357, 23);
		panel.add(lblInserisciIDati);

		
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				
				String livello = new String ();
				livello =selectedItem.toString();
				
				
				String nomeDisciplina = textField.getText();
				
				//String livello1 = selectedItem.toString();  //creaDisciplinaWindow.livello;
				
				//System.out.println("IL LIVELLO é "+ livello);
				
				int idIstruttore = Integer.parseInt (textField_2.getText());
				
				int idResponsabileCentro = Integer.parseInt(textField_1.getText());
			
				double costo = Integer.parseInt (textField_5.getText());
				
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
				
				String descrizione = editorPane.getText();
				
					
					//VERIFICA CHE NON SI STIA CERCANDO DI CREARE UNA DISCIPLINA GIA' ESISTENTE
					
					DisciplinaDAO verificadisciplinanelDB = new DisciplinaDAO ();
					
					if(verificadisciplinanelDB.controlloDisciplinaeLivello(nomeDisciplina, livello))
					{
						JFrame disciplinaesistente = new JFrame();
						JOptionPane.showMessageDialog(disciplinaesistente,"DISCIPLINA GIA' ESISTENTE");
					}
					else
					{
				    
					//VERIFICA CHE L'IMMAGINE INSERITA NON ABBIA LO STESSO NOME DI UNA SALVATA DELLA CARTELLA
						
					DisciplinaDAO verificaimmagine = new DisciplinaDAO();
					if(verificaimmagine.verificaImmagine(immagine)) 
					{
						JFrame immagineesistente = new JFrame();
						JOptionPane.showMessageDialog(immagineesistente,"L'IMMAGINE SELEZIONATA E' GIA' PRESENTE! SCEGLI UN'ALTRA");
						
					}
					else
					{
						
						//COPIA IL FILE NELLA CARTELLA
						
						File sfile = new File(path);
						DirectoryCorrente percorsoProgramma = new DirectoryCorrente();
						String DirectoryProgramma = percorsoProgramma.getDir().replace("\\", "/");
						
						File dfile = new File(DirectoryProgramma +"/img/"+ immagine);
						
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
						
						
						
						//CREA LA DISCIPLINA (salvando il nome del file nel DB)
						
						DisciplinaDAO aggiuntadisciplina = new DisciplinaDAO();
				        aggiuntadisciplina.aggiuntaNuovaDisciplina (nomeDisciplina, livello, idIstruttore ,idResponsabileCentro, costo, immagine, descrizione);
						
				        finestra.dispose();
						
					
					}
					
						
				    }
			}
		});
	   
	    
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser chooser = new JFileChooser();
				
				if(chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
				
					File fileselezionatoingresso = chooser.getSelectedFile();
				
					//ADATTAMENTO IMMAGINE AL LABEL
					ImageIcon image = new ImageIcon(fileselezionatoingresso.getPath());
					Image IMAGE = image.getImage();
					IMAGE = IMAGE.getScaledInstance(301, 225, IMAGE.SCALE_REPLICATE);
					image.setImage(IMAGE);
					
					
					
					lblNewLabel.setIcon(image);
					
					textField_4.setText(fileselezionatoingresso.getPath());
					
					
				}
			}
		});
	}
}
