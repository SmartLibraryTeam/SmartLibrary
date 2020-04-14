package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import gui.SceltaEventoIstruttoreGUI;
import java.awt.Color;

public class GestioneEventiIstruttoreGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneEventiIstruttoreGUI frame = new GestioneEventiIstruttoreGUI();
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
	public GestioneEventiIstruttoreGUI(int id) 
	{
		
		setTitle("GestioneEventi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("CREA UN NUOVO EVENTO");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{

				CreaEventoGUI nuovoevento = new CreaEventoGUI(id);
				nuovoevento.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 11, 251, 37);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 96, 414, 74);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("CONSULTA I TUOI EVENTI");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String operazione = new String();
				operazione = "consulta";
				SceltaEventoIstruttoreGUI scelta1 =  new SceltaEventoIstruttoreGUI (operazione,id);
				scelta1.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton_1.setBounds(154, 11, 251, 37);
		panel_1.add(btnNewButton_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 181, 414, 69);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("ELIMINA UNO DEI TUOI EVENTI");
		btnNewButton_2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				String operazione = new String();
				operazione = "elimina";
				SceltaEventoIstruttoreGUI scelta2 =  new SceltaEventoIstruttoreGUI (operazione,id);
				scelta2.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton_2.setBounds(10, 11, 251, 37);
		panel_2.add(btnNewButton_2);
	}

}
