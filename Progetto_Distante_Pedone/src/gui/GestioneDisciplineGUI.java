package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.CreaDisciplinaGUI;
import gui.SceltaDisciplinaGUI;
import java.awt.Color;


public class GestioneDisciplineGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestioneDisciplineGUI frame = new GestioneDisciplineGUI();
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
	public GestioneDisciplineGUI(int id) {
		setTitle("GestioneDiscipline");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 364);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 58);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnCreaUnaNuova = new JButton("CREA UNA NUOVA DISCIPLINA");
		btnCreaUnaNuova.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CreaDisciplinaGUI nuovadisciplina = new CreaDisciplinaGUI();
				nuovadisciplina.setVisible(true);
			}
		});
		btnCreaUnaNuova.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnCreaUnaNuova.setBounds(10, 11, 251, 37);
		panel.add(btnCreaUnaNuova);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 80, 414, 58);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton = new JButton("CONSULTA O MODIFICA ORARIO COMPLESSIVO DISCIPLINE");
		btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton.setBounds(82, 11, 323, 37);
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 158, 414, 58);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnModificaDisciplineEsistenti = new JButton("MODIFICA DISCIPLINE ESISTENTI");
		btnModificaDisciplineEsistenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String operazione = new String();
				operazione = "modifica";
				SceltaDisciplinaGUI scelta1 =  new SceltaDisciplinaGUI(operazione,id);
				scelta1.setVisible(true);
			}
		});
		btnModificaDisciplineEsistenti.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnModificaDisciplineEsistenti.setBounds(10, 11, 251, 37);
		panel_2.add(btnModificaDisciplineEsistenti);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 241, 414, 58);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnEliminaDisciplineEsistenti = new JButton("ELIMINA DISCIPLINE ESISTENTI");
		btnEliminaDisciplineEsistenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String operazione = new String();
				operazione = "elimina";
				SceltaDisciplinaGUI scelta2 =  new SceltaDisciplinaGUI(operazione,id);
				scelta2.setVisible(true);
			}
		});
		btnEliminaDisciplineEsistenti.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnEliminaDisciplineEsistenti.setBounds(85, 11, 320, 37);
		panel_3.add(btnEliminaDisciplineEsistenti);
	
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				SceltaAulaGUI sceltaaula = new SceltaAulaGUI(id);
				sceltaaula.setVisible(true);
			}
		});
		
	
	}
	
}
