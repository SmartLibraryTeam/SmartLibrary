package gui;




import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Font;
import gui.EliminazioneDisciplineGUI;
import gui.ModificaDisciplinaGUI;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Object;

import DAO.DisciplinaDAO;



public class SceltaDisciplinaGUI extends JFrame {

	private JPanel contentPane;
	public EliminazioneDisciplineGUI eliminazioneDisciplina;
	public Object oggetto = eliminazioneDisciplina;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaDisciplinaGUI frame = new SceltaDisciplinaGUI();
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
	public SceltaDisciplinaGUI( String opzione, int id) {
		setTitle("SceltaDisciplina");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 282, 262);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 256, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		
		comboBox.setBounds(22, 45, 205, 20);
		panel.add(comboBox);
		
		//Popoliamo la combobox delle discipline
		
		//DAO CHE POPOLA LA COMBOBOX DELLE DISCIPLINE
		DisciplinaDAO letturadiscipline = new DisciplinaDAO();
		
        int y = 0;
		
		int lunghezza = letturadiscipline.getDiscipline ().size();
		
		while( y < lunghezza)
		{
			System.out.println(letturadiscipline.getDiscipline().get(y)[0]);
			
			comboBox.addItem(letturadiscipline.getDiscipline().get(y)[0]);
			y++;
		}
		
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(10, 36, 226, 24);
				
		
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
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (opzione.equals("modifica"))
				{	
					Object selectedItem = new Object();
					selectedItem = comboBox.getSelectedItem();
					String stringa = new String();
				    stringa = selectedItem.toString();
				    
				    Object selectedItem1 = new Object();
					selectedItem1 = comboBox_1.getSelectedItem();
					String stringa1 = new String();
				    stringa1 = selectedItem1.toString();
					
				
					ModificaDisciplinaGUI modificaDisciplina = new ModificaDisciplinaGUI(stringa,stringa1);
					modificaDisciplina.setVisible(true);
					
					finestra.dispose();
				}
				else
				{
					Object selectedItem = new Object();
					selectedItem = comboBox.getSelectedItem();
					String stringa2 = new String();
				    stringa2 = selectedItem.toString();
				    System.out.println(stringa2);
				   
					Object selectedItem1 = new Object();
					selectedItem1 = comboBox_1.getSelectedItem();
					String stringa3 = new String();
				    stringa3 = selectedItem1.toString();
				    System.out.println(stringa3);
				    
				    DisciplinaDAO verifica = new DisciplinaDAO();
				    
				    if(verifica.controlloDisciplinaeLivello(stringa2, stringa3))
				    {
				    	System.out.println("SONO DENTRO, ELIMINO!");
				    	
				    	EliminazioneDisciplineGUI eliminazioneDisciplina =  new EliminazioneDisciplineGUI(stringa2,stringa3);
				    	
				    	eliminazioneDisciplina.setVisible(true);	
				    }
				    else
				    {
				    	System.out.println("sono fuori errore");
				    	JFrame accessonegato = new JFrame();
						JOptionPane.showMessageDialog(accessonegato,"LA DISCIPLINA E IL LIVELLO SCELTO NON SONO PRESENTI,NON PUOI ELIMINARLI!");
						System.out.println("sono dopo j frame");
				    }	
				}
				
				
				
			}
		});
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
		//Popoliamo la combobox dei livelli
				comboBox.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						DefaultComboBoxModel model = (DefaultComboBoxModel)comboBox_1.getModel();
						model.removeAllElements();
						//DAO CHE POPOLA LA COMBOBOX DEI LIVELLI
						DisciplinaDAO letturalivelli = new DisciplinaDAO();
						
						Object oggetto = new Object();
						oggetto = comboBox.getSelectedItem();
						String nomedisciplina = oggetto.toString();
						
						for(int i=0; i< letturalivelli.getLivelloDisciplina(nomedisciplina).size() ;i++)
						{
							
							
							comboBox_1.addItem(letturalivelli.getLivelloDisciplina(nomedisciplina).get(i)[0]);
							
							
						}
						

		
		
			}
		});
		
		
	}

}
