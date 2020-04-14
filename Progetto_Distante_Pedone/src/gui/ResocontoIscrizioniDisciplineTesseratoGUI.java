package gui;


import java.awt.Desktop;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import business.CreaPDF;

import DAO.DisciplinaDAO;

import java.io.IOException;

import modelli.IscrizioneDisciplina;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ResocontoIscrizioniDisciplineTesseratoGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this ;
	int numeroaperture = 0;
	public boolean aperturadistinta = false;
	public String  modPagamento;
	public String percorso;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResocontoIscrizioniDisciplineTesseratoGUI frame = new ResocontoIscrizioniDisciplineTesseratoGUI();
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
	public ResocontoIscrizioniDisciplineTesseratoGUI(ArrayList<IscrizioneDisciplina> Iscrizioni, int id, int in) {
		
		
		numeroaperture = in;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 552, 535);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		LoginGUI logingui = new LoginGUI();
		
		percorso = logingui.DirectoryProgramma;
		
		
		
		JLabel LabelResoconto = new JLabel("RESOCONTO ISCRIZIONE ALLE DISCIPLINE");
		LabelResoconto.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		LabelResoconto.setHorizontalAlignment(SwingConstants.CENTER);
		LabelResoconto.setBounds(10, 11, 516, 30);
		contentPane.add(LabelResoconto);
		
		JButton BottoneNuovaDisciplina = new JButton("ISCRIVITI AD UNA NUOVA DISCIPLINA!");
		
		BottoneNuovaDisciplina.setBounds(10, 52, 516, 30);
		contentPane.add(BottoneNuovaDisciplina);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 93, 516, 249);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel Intestazione = new JPanel();
		Intestazione.setBounds(10, 11, 496, 19);
		panel.add(Intestazione);
		Intestazione.setLayout(null);
		
		JLabel lblNome = new JLabel("NOME");
		lblNome.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setBounds(10, 0, 97, 19);
		Intestazione.add(lblNome);
		
		JLabel lblLivello = new JLabel("LIVELLO");
		lblLivello.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblLivello.setHorizontalAlignment(SwingConstants.LEFT);
		lblLivello.setBounds(141, 0, 87, 19);
		Intestazione.add(lblLivello);
		
		JLabel lblGiorno = new JLabel("GIORNO");
		lblGiorno.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblGiorno.setHorizontalAlignment(SwingConstants.LEFT);
		lblGiorno.setBounds(261, 0, 87, 19);
		Intestazione.add(lblGiorno);
		
		JLabel lblOra = new JLabel("ORA");
		lblOra.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblOra.setHorizontalAlignment(SwingConstants.LEFT);
		lblOra.setBounds(399, 0, 87, 19);
		Intestazione.add(lblOra);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 35, 496, 214);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		//System.out.println("LA LUNGHEZZA DI ISCRIZIONI E': "+Iscrizioni.size());
		
		int u =0;
		if(Iscrizioni.size() > 0)
		{
			
			for(int i =0; i < Iscrizioni.size(); i++)
			{
				
			
				JPanel Panellodisciplina = new JPanel();
				Panellodisciplina.setBounds(10, 11+u, 476, 39);
				panel_2.add(Panellodisciplina);
				Panellodisciplina.setLayout(null);
		
				JLabel Nomedisciplina = new JLabel(Iscrizioni.get(i).getnomeDisciplina());
				Nomedisciplina.setBounds(0, 0, 122, 27);
				Panellodisciplina.add(Nomedisciplina);
		
				JLabel Livellodisciplina = new JLabel(Iscrizioni.get(i).getLivello());
				Livellodisciplina.setBounds(120, 0, 122, 27);
				Panellodisciplina.add(Livellodisciplina);
		
				JLabel Giornodisciplina = new JLabel(Iscrizioni.get(i).getGiorno());
				Giornodisciplina.setBounds(242, 0, 129, 27);
				Panellodisciplina.add(Giornodisciplina);
		
				JLabel Oradisciplina = new JLabel(Iscrizioni.get(i).getOra());
				Oradisciplina.setBounds(373, 0, 103, 27);
				Panellodisciplina.add(Oradisciplina);
		
				panel_2.add(Panellodisciplina);
				
				u = u + 40;
			}	
		}
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 353, 516, 76);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblScegliModalitPagamento = new JLabel("Scegli Modalit\u00E0 Pagamento:");
		lblScegliModalitPagamento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblScegliModalitPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliModalitPagamento.setBounds(277, 11, 229, 22);
		panel_1.add(lblScegliModalitPagamento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Paypal");
		comboBox.addItem("Carta di credito");
		comboBox.addItem("Contanti");
		comboBox.setBounds(277, 44, 229, 22);
		panel_1.add(comboBox);
		
		JButton btnScaricaDistintaPdf = new JButton("SCARICA DISTINTA PDF ");
		
		btnScaricaDistintaPdf.setBounds(10, 23, 229, 43);
		panel_1.add(btnScaricaDistintaPdf);
		
		JButton btnNewButton = new JButton("INVIA RICHIESTA ISCRIZIONE");
		
		btnNewButton.setBounds(128, 440, 283, 37);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		BottoneNuovaDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				IscrizioneDisciplinaTesseratoGUI iscrizione = new IscrizioneDisciplinaTesseratoGUI(Iscrizioni,id,in);
				iscrizione.setVisible(true);
				
				finestra.dispose();
				
			}
		});
		
		
		
		btnScaricaDistintaPdf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)  
			{
				System.out.println("clicci il tasto");
				
				if(numeroaperture == 0)
				{
					System.out.println("VALORE DI IN: " + numeroaperture);
					JFrame avviso = new JFrame();
					JOptionPane.showMessageDialog(avviso,"NON HAI SCELTO ALCUNA DISCIPLINA, NON E' POSSIBILE STAMPARE UNA DISTINTA!");
				}
				else
				{
					System.out.println("SONO NELL'ELSE diverso da 0");
					System.out.println("VALORE DI IN: " + numeroaperture);
					
					if (in == 1 || numeroaperture == 1)
					{
						//CREA FILE 
						System.out.println("SONO NELL'if = 1");
						CreaPDF pdf = new CreaPDF();
					
						System.out.println("VALORE DI IN: " + numeroaperture);
						//APERTURA FILE
				
						try 
						{
							
							Object oggetto = new Object();
							oggetto = comboBox.getSelectedItem();
							String modPagamento = oggetto.toString();
						
							Desktop.getDesktop().open(pdf.newPDF(Iscrizioni,id,modPagamento));
							
							numeroaperture = numeroaperture +1;
							
							System.out.println("VALORE NUMERO APERTURE DOPO CREAZIONE FILE: " + numeroaperture);
							
							aperturadistinta = true;
						}
						catch (IOException e1) 
						{
						
							e1.printStackTrace();
					
						}
					
					}
						
					else	
					{
						System.out.println("SONO NELL'else diverso da 1");
						if(numeroaperture >=2)
						{
						
							JFrame avviso = new JFrame();
						
							JOptionPane.showMessageDialog(avviso,"ATTENZIONE, PREOCCUPATI DI AVER CHIUSO IL FILE DI DISTINTA PRECEDENTE");
						
						
							numeroaperture = 1;
						
						
							System.out.println("VALORE NUMERO APERTURE DOPO MESS: " + numeroaperture);
						}
						
					}
				
			
				}
			
			}
			
		});
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//SE NON HA AGGIUNTO ALCUNA DISCIPLINA STAMPA MESSAGGIO DI ERRORE
				if(numeroaperture == 0)
				{
					JFrame avviso = new JFrame();
					JOptionPane.showMessageDialog(avviso,"NON HAI SCELTO ALCUNA DISCIPLINA, NON E' POSSIBILE INVIARE LA TUA RICHIESTA!");
				}
				else
				{
				
					//CREA IL FILE DI DISTINTA NEL CASO IN CUI IL TESSERATO NON LO HA VISUALIZZATO
				
					if(aperturadistinta == false)
					{
						CreaPDF pdf = new CreaPDF();
						Object oggetto = new Object();
						oggetto = comboBox.getSelectedItem();
						modPagamento = oggetto.toString();
						pdf.newPDF(Iscrizioni,id,modPagamento);
					}
				
					//ESEGUO QUERY PER POPOLARE IL DB
				
					for (int j =0; j<Iscrizioni.size(); j++)
					{
					
					
						//ricavo idDisc
					
						//id Lezione
						Object oggetto = new Object();
						oggetto = comboBox.getSelectedItem();
						modPagamento = oggetto.toString();
						//EseguoAggiornamento
					
						DisciplinaDAO aggiunta = new DisciplinaDAO();
						aggiunta.setIscrizioneTesserato(id, Iscrizioni.get(j).getIdDisc(), Iscrizioni.get(j).getIdLez(),modPagamento);
					
					
					}
				
					//STAMPO MESSAGGIO OPERAZIONE RIUSCITA
				
					JFrame iscrizioneeffettuata = new JFrame();
					JOptionPane.showMessageDialog(iscrizioneeffettuata,"RICHIESTA ISCRIZIONE EFFETTUATA");
				
					finestra.dispose();
				
				}
				
				
			}
		});
		
		
		
	}
	
	
	
	
	
	
	
	

}
		
	

