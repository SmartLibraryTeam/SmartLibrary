package gui;


import java.util.ArrayList;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import modelli.IscrizioneDisciplina;
import java.awt.Color;



public class GestioneDisciplineTesseratoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneDisciplineTesseratoGUI frame = new GestioneDisciplineTesseratoGUI();
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
	public GestioneDisciplineTesseratoGUI(int id ) {
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
		
		JLabel lblGestisciITuoi = new JLabel("GESTISCI LE TUE DISCIPLINE");
		lblGestisciITuoi.setHorizontalAlignment(SwingConstants.CENTER);
		lblGestisciITuoi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 20));
		lblGestisciITuoi.setBounds(124, 21, 270, 24);
		panel.add(lblGestisciITuoi);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 65, 514, 217);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("ISCRIVITI ALLE DISCIPLINE");
		btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton.setBounds(10, 22, 270, 32);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCELLA ISCRIZIONE DISCIPLINA");
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				CancellazioneIscrizioneTurniDisciplineGUI cancellazione = new CancellazioneIscrizioneTurniDisciplineGUI(id);
				cancellazione.setVisible(true);
			}
		});
		
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton_1.setBounds(116, 89, 270, 32);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("CONSULTA STATO DELLE TUE ISCRIZIONI ALLE DISCIPLINE");
		btnNewButton_2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton_2.setBounds(157, 155, 347, 32);
		panel_1.add(btnNewButton_2);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				ArrayList<IscrizioneDisciplina> iscrizioni = new ArrayList<IscrizioneDisciplina>();
				
				ResocontoIscrizioniDisciplineTesseratoGUI resoconto = new ResocontoIscrizioniDisciplineTesseratoGUI(iscrizioni,id,0);
				resoconto.setVisible(true);
				
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ConsultaStatoIscrizioneTurniGUI consultaStato = new ConsultaStatoIscrizioneTurniGUI(id);
				consultaStato.setVisible(true);
			}
		});
		
		
		
		
		
	}

}
	
