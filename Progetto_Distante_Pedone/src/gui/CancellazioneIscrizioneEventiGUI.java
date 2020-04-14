package gui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;

public class CancellazioneIscrizioneEventiGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CancellazioneIscrizioneEventiGUI frame = new CancellazioneIscrizioneEventiGUI();
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
	public CancellazioneIscrizioneEventiGUI (String nomeEvento, int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 374, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
        contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 338, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("<html>SEI SICURO DI VOLER CANCELLARE <br> L'ISCRIZIONE A QUESTO EVENTO?<html>");
		lblNewLabel.setBounds(10, 11, 305, 35);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 68, 338, 46);
		contentPane.add(panel_1);
		
		JButton btnConferma = new JButton("CONFERMA");
		btnConferma.setBounds(96, 11, 137, 27);
		

	    //DAO CHE PRENDE IN INGRESSO IL NOME DELL'EVENTO E RESTITUISCE L'ID DELL'EVENTO
		
        EventoDAO ricavaid = new EventoDAO();
        int idEvento = ricavaid.getIdEvento(nomeEvento);
		
		btnConferma.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
			     EventoDAO cancellazioneiscrizione = new EventoDAO();
				 cancellazioneiscrizione.cancellaiscrizione(idEvento, id);
				 
				 JFrame iscrizionecancellata = new JFrame();
				 JOptionPane.showMessageDialog(iscrizionecancellata,"La tua iscrizione è stata cancellata");
				 finestra.dispose();
				 
			}
		});
		panel_1.setLayout(null);
		btnConferma.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		panel_1.add(btnConferma);
		
		
	}
}

