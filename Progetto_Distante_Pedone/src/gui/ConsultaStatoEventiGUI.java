package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConsultaStatoEventiGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaStatoEventiGUI frame = new ConsultaStatoEventiGUI();
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
	public ConsultaStatoEventiGUI( int idIstruttore) {
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
		
		JLabel lblQuestoLo = new JLabel("QUESTO E' LO STATO DEI TUOI EVENTI :");
		lblQuestoLo.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		lblQuestoLo.setBounds(147, 11, 250, 18);
		panel.add(lblQuestoLo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 62, 549, 291);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnChiudi = new JButton("CHIUDI");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finestra.dispose();
			}
		});
		btnChiudi.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnChiudi.setBounds(226, 366, 125, 42);
		contentPane.add(btnChiudi);
		
		
		
		EventoDAO letturaStatoEventi = new EventoDAO();
		
		int lunghezza = letturaStatoEventi.getEventi(idIstruttore).size();
		
		System.out.println("La Lunghezza è= " + lunghezza);
		
		JLabel[] labelNomi = new JLabel[lunghezza];
		JLabel[] labelStato = new JLabel[lunghezza];
		 
		int u=0;
		
		for(int i = 0; i <lunghezza; i++ )
		{
			//System.out.println(letturaStatoEventi.getEventi(idIstruttore).get(i).getNome());
			//System.out.println(letturaStatoEventi.getEventi(idIstruttore).get(i).getStato());
			
			labelNomi[i]=new JLabel();
			labelStato[i]=new JLabel();
			labelNomi[i].setText("NOME EVENTO :  " + letturaStatoEventi.getEventi(idIstruttore).get(i).getNome());
			labelStato[i].setText("STATO:  " + letturaStatoEventi.getEventi(idIstruttore).get(i).getStato());
			labelNomi[i].setBounds(10, 11 + u , 350, 29);
			labelStato[i].setBounds(400, 11 + u , 200, 29);
			panel_1.add(labelNomi[i]);
			panel_1.add(labelStato[i]);
			
			u= u + 40;	
			
		}
	
	}
}
