package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;



public class SceltaEventoTesseratoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SceltaEventoTesseratoGUI frame = new SceltaEventoTesseratoGUI();
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
	public SceltaEventoTesseratoGUI(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 281, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
        contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 246, 72);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblScegliUnEvento = new JLabel("SCEGLI UN EVENTO");
		lblScegliUnEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliUnEvento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblScegliUnEvento.setBounds(43, 11, 155, 26);
		panel.add(lblScegliUnEvento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 44, 246, 20);
		panel.add(comboBox);
		
       // DAO CHE RICAVA GLI EVENTI DISPONIBILI NEL DATABASE
		
		EventoDAO letturaeventitesserato = new EventoDAO();
		
		System.out.println("NUMERO EVENTI= " + letturaeventitesserato.getEventi().size() );
		
		int y = 0;
		
		int Lunghezza = letturaeventitesserato.getEventiAccettati().size();
		
		
		while( y < letturaeventitesserato.getEventiAccettati().size())
		{
			System.out.println(letturaeventitesserato.getEventiAccettati().get(y)[0]);
			
			comboBox.addItem(letturaeventitesserato.getEventiAccettati().get(y)[0]);
			
			y++;
		}
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 94, 246, 56);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnOk.setBounds(87, 11, 66 , 23);
		panel_1.add(btnOk);
	
		

		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e)
			{
				
					Object selectedItem = new Object();
					selectedItem = comboBox.getSelectedItem();
					String nomeEvento = new String();
				    nomeEvento = selectedItem.toString();
				    
				    
				    
				    ConsultaEventoUtenteGenericoGUI consultazioneevento = new   ConsultaEventoUtenteGenericoGUI(nomeEvento);
				    consultazioneevento.setVisible(true);
			}	    
				
				
		
	
	   });



	}

}
