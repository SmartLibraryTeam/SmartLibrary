package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EliminazioneEventiGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminazioneEventiGUI frame = new EliminazioneEventiGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    */
	/**
	 * Create the frame.
	 */
	public EliminazioneEventiGUI(String nomeEvento) 
	{
		setTitle("EliminazioneEventi");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 374, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 338, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEI SICURO DI VOLER ELIMINARE QUESTO EVENTO?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 305, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 77, 338, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnConferma = new JButton("CONFERMA");
		
		btnConferma.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				 EventoDAO eliminaeventoDao = new  EventoDAO();
				 
				 EventoDAO evento = new	EventoDAO();
				 
				 int idEvento = evento.getIdEvento(nomeEvento);
				 
				 eliminaeventoDao.eliminaEvento (idEvento);
				 
				 JFrame eventoesistente = new JFrame();
				
				 JOptionPane.showMessageDialog(eventoesistente,"EVENTO ELIMINATO CORRETTAMENTE");	 
				 
				 finestra.dispose();
			}
		});
		
		btnConferma.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		btnConferma.setBounds(88, 11, 156, 40);
		panel_1.add(btnConferma);
	}
}
