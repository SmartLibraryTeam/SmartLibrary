package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.EliminazioneEventiGUI;
import gui.ConsultaEventoIstruttoreGUI;

import DAO.EventoDAO;


public class SceltaEventoIstruttoreGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaEventoIstruttoreGUI frame = new SceltaEventoIstruttoreGUI();
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
	public SceltaEventoIstruttoreGUI(String opzione,int id)  {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 284, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 246, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScegliUnEvento = new JLabel("SCEGLI UN EVENTO");
		lblScegliUnEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliUnEvento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblScegliUnEvento.setBounds(43, 11, 155, 26);
		panel.add(lblScegliUnEvento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 41, 246, 20);
		panel.add(comboBox);
		
     
		
	    //Popoliamo la combobox degli eventi
		
		//Se l'istruttore intende consultare gli eventi, popoliamo la combobox con tutti gli eventi disponibili nel db
		
		if(opzione.equals("consulta"))
		{
		
			EventoDAO letturaeventi = new EventoDAO();
			
			
			int i = 0;
			
			int lunghezza1 = letturaeventi.getEventiIstruttore(id).size();
				
				while( i < lunghezza1)
				{
					System.out.println(letturaeventi.getEventiIstruttore(id).get(i)[0]);
					
					comboBox.addItem(letturaeventi.getEventiIstruttore(id).get(i)[0]);
					
					i++;
				}
			
		}
		//Se l'istruttore intende eliminare un evento, popoliamo la combobox con gli eventi gestiti dall'istruttore stesso
		
		else 
		{
			
			EventoDAO letturaeventi = new EventoDAO ();
		
			int i = 0;
			
			int lunghezza1 = letturaeventi.getEventiIstruttore(id).size();
				
				while( i < lunghezza1)
				{
					System.out.println(letturaeventi.getEventiIstruttore(id).get(i)[0]);
					
					comboBox.addItem(letturaeventi.getEventiIstruttore(id).get(i)[0]);
					
					i++;
				}
			
		}
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 94, 246, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				if (opzione.equals("consulta"))
				{	
					Object selectedItem = new Object();
					selectedItem = comboBox.getSelectedItem();
					String nomeEvento = new String();
				    nomeEvento = selectedItem.toString();
				    
				    ConsultaEventoIstruttoreGUI consultazioneevento = new  ConsultaEventoIstruttoreGUI(nomeEvento);
				    consultazioneevento.setVisible(true);
				    
				}
				if(opzione.equals("iscriviti")) 
				{
					Object selectedItem = new Object();
					selectedItem = comboBox.getSelectedItem();
					String nomeEvento = new String();
				    nomeEvento = selectedItem.toString();
				    
				    
					
					
				}
				
				
				if(opzione.equals("elimina"))
				{
					Object selectedItem = new Object();
					selectedItem = comboBox.getSelectedItem();
					String nomeEvento = new String();
				    nomeEvento = selectedItem.toString();
				    
				   
				    
				    EventoDAO verifica = new EventoDAO();
				    
				    if(verifica.controlloEvento(nomeEvento))
				    {
				    	System.out.println("ELIMINO!");
				    	
				    	EliminazioneEventiGUI eliminazioneevento =  new EliminazioneEventiGUI(nomeEvento);
				    	
				    	eliminazioneevento.setVisible(true);	
				    }
				    else
				    {
				    	System.out.println("ERRORE");
				    	JFrame accessonegato = new JFrame();
						JOptionPane.showMessageDialog(accessonegato,"IL NOME DELL'EVENTO SCELTO NON E' PRESENTE,NON PUOI ELIMINARLO!");
						
				    }	
				}
			
			}
		});
		btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnOk.setBounds(83, 11, 66 , 23);
		panel_1.add(btnOk);
	}


	}


	