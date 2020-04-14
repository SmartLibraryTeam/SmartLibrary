package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;

import gui.OrganizzaTurniGUI;

public class SceltaDisciplinaLivelloCreaTurniGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra =this;
	
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaDisciplinaLivelloCreaTurniGUI frame = new SceltaDisciplinaLivelloCreaTurniGUI();
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
	public SceltaDisciplinaLivelloCreaTurniGUI(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds (100, 100, 282, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 256, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(22, 45, 205, 20);
		panel.add(comboBox);
		

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 36, 226, 24);
		
		
		//POPOLA LA COMBOBOX DELLE DISCIPLINE 
		
	    DisciplinaDAO letturadiscipline = new DisciplinaDAO();
		
		int y = 0;
		
		int lunghezza = letturadiscipline.getDisciplineIstruttore (id).size();
		
		while( y < lunghezza)
		{
			System.out.println(letturadiscipline.getDisciplineIstruttore (id).get(y)[0]);
			
			comboBox.addItem(letturadiscipline.getDisciplineIstruttore (id).get(y)[0]);
			
			y++;
		}
		
		
		
		 //IN BASE AL VALORE DI DISCIPLINA SI POPOLA LA COMBOBOX DEL LIVELLO 
		
		comboBox.addActionListener(new ActionListener() 	
		
		{
			
				public void actionPerformed(ActionEvent arg0) 
				
			{
				
				DefaultComboBoxModel model = (DefaultComboBoxModel)comboBox_1.getModel();
				model.removeAllElements();
				
			   
				
				//PRELEVIAMO IL VALORE DI DISCIPLINA
				
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				String nomedisciplina = new String();
				nomedisciplina = selectedItem.toString();
				
				System.out.println("LA DISCIPLINA SCELTA E' :   " + nomedisciplina);
					
				
				//DAO CHE PRENDE IL NOME DELLA DISCIPLINA E L'IDISTRUTTORE E RICAVA I LIVELLI ( PRENDE STRING E RITORNA VECTOR )
				
			    DisciplinaDAO letturalivellidisciplina = new DisciplinaDAO();
			
				System.out.println("NUMERO LIVELLI = " + letturalivellidisciplina.getLivelloDisciplinaIstruttore(nomedisciplina, id).size() );
				
				int y = 0;
				
				int Lunghezza = letturalivellidisciplina.getLivelloDisciplinaIstruttore(nomedisciplina, id).size();
				
				
				
				while( y < letturalivellidisciplina.getLivelloDisciplinaIstruttore(nomedisciplina, id).size())
				{
					System.out.println(letturalivellidisciplina.getLivelloDisciplinaIstruttore(nomedisciplina, id).get(y)[0]);
					
					comboBox_1.addItem(letturalivellidisciplina.getLivelloDisciplinaIstruttore(nomedisciplina, id).get(y)[0]);
					
					y++;
				}
				
				
				
				
				}
				
			
			
		});
		
		
		
		JLabel lblNewLabel = new JLabel("SCEGLI UNA DISCIPLINA");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(59, 11, 262, 23);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 175, 249, 44);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		
		JButton btnNewButton = new JButton("OK");
		
		btnNewButton.setBounds(87, 11, 64, 23);
		btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		panel_1.add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 93, 256, 71);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		panel_2.add(comboBox_1);
		
		JLabel lblScegliLivello = new JLabel("SCEGLI LIVELLO");
		lblScegliLivello.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblScegliLivello.setBounds(73, 11, 119, 14);
		panel_2.add(lblScegliLivello);
	
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				//PRELEVIAMO IL VALORE DI DISCIPLINA
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				String nomeDisciplina = new String();
				nomeDisciplina = selectedItem.toString();
				
				System.out.println("nome=" + nomeDisciplina);
				
				//PRELEVIAMO IL VALORE DI LIVELLO
				Object selectedItem1 = new Object();
				selectedItem1 = comboBox_1.getSelectedItem();
				String livello = new String();
				livello = selectedItem1.toString();
				System.out.println("livello=" + livello);
				
				
				OrganizzaTurniGUI organizzaturni = new OrganizzaTurniGUI(nomeDisciplina, livello, id) ;
				organizzaturni.setVisible(true);
				finestra.dispose();
				
			}
		});
	

	}

}

