package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.EventoDAO;

import java.awt.Font;
import java.awt.Image;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import gui.ConsultaDisciplinaUtenteGenericoGUI;
import gui.ConsultaEventoUtenteGenericoGUI;
import java.awt.Color;

public class SceltaDisciplinaEventoConsultareGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel_2;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaDisciplinaEventoConsultareGUI frame = new SceltaDisciplinaEventoConsultareGUI();
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
	public SceltaDisciplinaEventoConsultareGUI() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 593, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblCiaoScegliQuali = new JLabel("Ciao! Scegli quali discipline e quali eventi vuoi visitare! :");
		lblCiaoScegliQuali.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		lblCiaoScegliQuali.setBounds(10, 11, 404, 24);
		panel.add(lblCiaoScegliQuali);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 57, 282, 81);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		//Popoliamo la combobox delle discipline
		
        DisciplinaDAO letturadiscipline = new DisciplinaDAO();
		
		int y = 0;
		
		int lunghezza = letturadiscipline.getDiscipline().size();
		
		while( y < lunghezza)
		{
			System.out.println(letturadiscipline.getDiscipline ().get(y)[0]);
			
			comboBox.addItem(letturadiscipline.getDiscipline ().get(y)[0]);
			y++;
		}
		
		
		
		
		comboBox.setBounds(10, 11, 262, 20);
		panel_1.add(comboBox);
		
		JButton btnNewButton = new JButton("CONSULTA DISCIPLINA");
		btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				String disciplina = new String();
			    disciplina = selectedItem.toString();
				
				ConsultaDisciplinaUtenteGenericoGUI consultadisciplina =  new ConsultaDisciplinaUtenteGenericoGUI (disciplina);
				consultadisciplina.setVisible(true);
			}
		});
		btnNewButton.setBounds(31, 42, 154, 28);
		panel_1.add(btnNewButton);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 149, 282, 90);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox_1 = new JComboBox();
		
		
		//Popoliamo la combobox degli eventi
		
	    EventoDAO letturaeventi = new EventoDAO ();
			
		int i = 0;
			
		int lunghezza1 = letturaeventi.getEventiAccettati().size();
			
			while( i < lunghezza1)
			{
				System.out.println(letturaeventi.getEventiAccettati().get(i)[0]);
				
				comboBox_1.addItem(letturaeventi.getEventiAccettati().get(i)[0]);
				
				i++;
			}
			
		
		comboBox_1.setBounds(10, 21, 262, 20);
		panel_2.add(comboBox_1);
		
		JButton btnNewButton_1 = new JButton("CONSULTA EVENTO");
		btnNewButton_1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{

				Object selectedItem2 = new Object();
				selectedItem2 = comboBox_1.getSelectedItem();
				String evento = new String();
			    evento = selectedItem2.toString();
			    
			    
				ConsultaEventoUtenteGenericoGUI consultaevento =  new ConsultaEventoUtenteGenericoGUI (evento);
				consultaevento.setVisible(true);
			
			}
		});
		btnNewButton_1.setBounds(31, 52, 159, 27);
		panel_2.add(btnNewButton_1);
		
		LoginGUI logingui = new LoginGUI();
		String path1 =logingui.DirectoryProgramma+"/img/imgSistem/discipline.jpg";
		
		JLabel lblNewLabel = new JLabel();
		ImageIcon image1 = new ImageIcon(path1);
		Image IMAGE1 = image1.getImage();
		IMAGE1 = IMAGE1.getScaledInstance(241, 191, IMAGE1.SCALE_REPLICATE);
		image1.setImage(IMAGE1);
		lblNewLabel.setIcon(image1);
		lblNewLabel.setBounds(326, 48, 241, 191);
		contentPane.add(lblNewLabel);
	}
}
