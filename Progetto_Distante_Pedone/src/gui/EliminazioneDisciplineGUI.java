package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


@SuppressWarnings("serial")
public class EliminazioneDisciplineGUI extends JFrame {

	private JPanel contentPane;
	public String chiudi;
	
	
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EliminazioneDisciplineGUI frame = new EliminazioneDisciplineGUI();
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
	public EliminazioneDisciplineGUI(String nomedisciplina,String livello) 
	{
		
		
		setTitle("EliminazioneDiscipline");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 374, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(25, 11, 329, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblSeiSicuroDi = new JLabel("SEI SICURO DI VOLER ELIMINARE QUESTA DISCIPLINA?");
		lblSeiSicuroDi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblSeiSicuroDi.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeiSicuroDi.setBounds(10, 11, 291, 35);
		panel.add(lblSeiSicuroDi);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(25, 72, 329, 67);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnSi = new JButton("CONFERMA");
		final JFrame finestra = this;
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			    DisciplinaDAO eliminadisciplinaDao = new DisciplinaDAO();
				eliminadisciplinaDao.eliminaDisciplina(nomedisciplina,livello);
				 
				 JFrame disciplinaesistente = new JFrame();
				JOptionPane.showMessageDialog(disciplinaesistente,"DISCIPLINA ELIMINATA CORRETTAMENTE");	 
				finestra.dispose();
			}
		
		});
		
		//btnSi.addActionListener(new ChiusuraFinestreListener())
		btnSi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		btnSi.setBounds(72, 21, 161, 35);
		panel_1.add(btnSi);
		
		
	}
	
}

