package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GestioneIscrizioniResponsabileCentroGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneIscrizioniResponsabileCentroGUI frame = new GestioneIscrizioniResponsabileCentroGUI();
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
	public GestioneIscrizioniResponsabileCentroGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 301, 190);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnIscrizioniADiscipline = new JButton("ISCRIZIONI A DISCIPLINE");
		btnIscrizioniADiscipline.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				SceltaTurnoResponsabileIscrizioneGUI sceltaturno = new SceltaTurnoResponsabileIscrizioneGUI();
				sceltaturno.setVisible(true);
			}
		});
		btnIscrizioniADiscipline.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnIscrizioniADiscipline.setBounds(10, 11, 265, 57);
		contentPane.add(btnIscrizioniADiscipline);
		
		JButton btnIscrizioniAgliEventi = new JButton("ISCRIZIONI AGLI EVENTI");
		btnIscrizioniAgliEventi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		
		btnIscrizioniAgliEventi.setBounds(10, 79, 265, 57);
		contentPane.add(btnIscrizioniAgliEventi);
	
		btnIscrizioniAgliEventi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SceltaUtenteConfermaIscrizioneEventoGUI sceltaUtenteConfermaEvento = new SceltaUtenteConfermaIscrizioneEventoGUI();
				sceltaUtenteConfermaEvento.setVisible(true);
			}
		});
	
	
	}
}
