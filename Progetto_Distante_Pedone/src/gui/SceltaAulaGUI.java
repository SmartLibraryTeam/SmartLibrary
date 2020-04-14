package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.LezioneDAO;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class SceltaAulaGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaAulaGUI frame = new SceltaAulaGUI();
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
	public SceltaAulaGUI(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 352, 192);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblScegliAula = new JLabel("Scegli Aula:");
		lblScegliAula.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliAula.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		lblScegliAula.setBounds(10, 11, 290, 27);
		contentPane.add(lblScegliAula);
		
		JComboBox comboBox = new JComboBox();
		
		LezioneDAO ricava = new LezioneDAO();
		//POPOLO COMOBOBOX CON TUTTE LE POSSIBILI AULE
		int y = 0;
		while(y<ricava.getAule().size())
		{
			
			System.out.println(ricava.getAule().get(y)[0].toString());
			comboBox.addItem(ricava.getAule().get(y)[0].toString());
			y++;
		}
		
		
		
		
		comboBox.setBounds(30, 49, 268, 27);
		contentPane.add(comboBox);
		
		JButton btnOk = new JButton("OK");
		
		btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnOk.setBounds(118, 105, 89, 23);
		contentPane.add(btnOk);
		
		
		
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Object oggetto = new Object();
				oggetto = comboBox.getSelectedItem();
				String aula = oggetto.toString();
				
				OrarioComplessivoDisciplineGUI orario = new OrarioComplessivoDisciplineGUI(aula,id);
				orario.setVisible(true);
				finestra.dispose();
				
				
			}
		});
	}
}
	
