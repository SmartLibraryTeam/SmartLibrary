package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import DAO.DisciplinaDAO;

import gui.ConsultaDisciplinaTesseratoGUI;


public class SceltaDisciplinaTesseratoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaDisciplinaTesseratoGUI frame = new SceltaDisciplinaTesseratoGUI();
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
	public SceltaDisciplinaTesseratoGUI() {
		setTitle("SceltaDisciplinaTesserato");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 282, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 246, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScegliUnaDisciplina = new JLabel("SCEGLI UNA DISCIPLINA");
		lblScegliUnaDisciplina.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblScegliUnaDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliUnaDisciplina.setBounds(43, 11, 155, 26);
		panel.add(lblScegliUnaDisciplina);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(21, 44, 200, 20);
		panel.add(comboBox);
		
       // DAO CHE RICAVA LE DISCIPLINE DISPONIBILI NEL DATABASE
		
		DisciplinaDAO letturadisciplinetesserato = new DisciplinaDAO();
		
		System.out.println("NUMERO DISCIPLINE = " + letturadisciplinetesserato.getDiscipline().size() );
		
		int y = 0;
		
		int Lunghezza = letturadisciplinetesserato.getDiscipline().size();
		
		
		
		while( y < letturadisciplinetesserato.getDiscipline().size())
		{
			System.out.println(letturadisciplinetesserato.getDiscipline().get(y)[0]);
			
			comboBox.addItem(letturadisciplinetesserato.getDiscipline().get(y)[0]);
			
			y++;
		}
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 98, 246, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				String nomeDisciplina = new String();
			    nomeDisciplina = selectedItem.toString();
				
				
				ConsultaDisciplinaTesseratoGUI consultadisciplina = new  ConsultaDisciplinaTesseratoGUI(nomeDisciplina);
				consultadisciplina.setVisible(true);
			    
			}
		});
		btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnOk.setBounds(84 , 11, 66, 23);
		panel_1.add(btnOk);
	}



}

