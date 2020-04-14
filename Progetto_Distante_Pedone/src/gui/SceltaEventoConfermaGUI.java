package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class SceltaEventoConfermaGUI extends JFrame {

	private JPanel contentPane;
	public String disciplina;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaEventoConfermaGUI frame = new SceltaEventoConfermaGUI();
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
	public SceltaEventoConfermaGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 369, 240);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScegliLeventoChe = new JLabel("Scegli l'evento che vuoi confermare:");
		lblScegliLeventoChe.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliLeventoChe.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		lblScegliLeventoChe.setBounds(10, 11, 333, 45);
		contentPane.add(lblScegliLeventoChe);
		
		JLabel lblEventiDisponibili = new JLabel("Eventi Disponibili :");
		lblEventiDisponibili.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEventiDisponibili.setBounds(10, 54, 209, 31);
		contentPane.add(lblEventiDisponibili);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 98, 333, 20);
		contentPane.add(comboBox);
		
	    EventoDAO lettura = new EventoDAO ();
		
		
		for(int i = 0; i <lettura.getEventiDaConfermare().size() ; i++) 
		{
			comboBox.addItem(lettura.getEventiDaConfermare().get(i)[0].toString());
			
			//System.out.println(arrayDiscipline[i]);
			//System.out.print(i);
		}
		
		
	
		
		
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				
				//String disciplina = new String ();
				disciplina =selectedItem.toString();
				
				ConfermaStatoEventoGUI confermastato =  new ConfermaStatoEventoGUI(disciplina,finestra);
				confermastato.setVisible(true);
			}
		});
		btnConferma.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		btnConferma.setBounds(126, 148, 96, 31);
		contentPane.add(btnConferma);
	}
}
