package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class GestioneEventiTesseratoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneEventiTesseratoGUI frame = new GestioneEventiTesseratoGUI();
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
	public GestioneEventiTesseratoGUI(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 332);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 514, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblGestisciITuoi = new JLabel("GESTISCI I TUOI EVENTI");
		lblGestisciITuoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestisciITuoi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		lblGestisciITuoi.setBounds(124, 21, 270, 24);
		panel.add(lblGestisciITuoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 65, 514, 217);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("ISCRIVITI AD UN EVENTO");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				SceltaEventoIscrizioneGUI sceglievento= new SceltaEventoIscrizioneGUI(id);
				sceglievento.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 22, 270, 32);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCELLA ISCRIZIONE AD UN EVENTO");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				SceltaEventoCancellazioneIscrizioneGUI sceglievento= new SceltaEventoCancellazioneIscrizioneGUI(id);
				sceglievento.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton_1.setBounds(116, 89, 270, 32);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSULTA STATO DEI TUOI EVENTI");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				ConsultaStatoEventiTesseratoGUI consultastatoeventi = new ConsultaStatoEventiTesseratoGUI (id);
				consultastatoeventi.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton_2.setBounds(218, 157, 270, 32);
		panel_1.add(btnNewButton_2);
	}
}
