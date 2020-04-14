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

import DAO.DisciplinaDAO;


public class ConfermaCancellazioneIscrizioneTurnoGUI extends JFrame {

    
	private JPanel contentPane;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfermaCancellazioneIscrizioneTurnoGUI frame = new ConfermaCancellazioneIscrizioneTurnoGUI();
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
	public ConfermaCancellazioneIscrizioneTurnoGUI(int idTesserato,int idLez) {
		setTitle("\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 417, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 381, 57);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SEI SICURO DI VOLER CANCELLARE L'ISCRIZIONE A QUESTO TURNO?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 11, 361, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 77, 381, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnConferma = new JButton("CONFERMA");
		
		btnConferma.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				//ESEGUO CANCELLAZIONE 
				DisciplinaDAO cancellazione = new DisciplinaDAO();
				cancellazione.cancellaTurno(idTesserato, idLez);
				 
				JFrame eventoesistente = new JFrame();
				JOptionPane.showMessageDialog(eventoesistente,"ELIMINAZIONE DAL TURNO SCELTO EFFETTUATA");
				
				finestra.dispose();
				
			}
		});
		btnConferma.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		btnConferma.setBounds(117, 11, 156, 40);
		panel_1.add(btnConferma);
	}

}

