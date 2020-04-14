package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConfermaStatoEventoGUI extends JFrame {

	private JPanel contentPane;
	public JTextField textField;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfermaStatoEventoGUI frame = new ConfermaStatoEventoGUI();
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
	public ConfermaStatoEventoGUI( String nomeEvento, JFrame finestra1) {
		setTitle("ConfermaStatoEvento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 415, 229);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 379, 168);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(20, 27, 69, 14);
		panel.add(lblNome);
	
		
		JLabel lblNewLabel = new JLabel(nomeEvento);
		lblNewLabel.setBounds(115, 27, 254, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Stato");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(20, 75, 69, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblCosto = new JLabel("Costo");
		lblCosto.setHorizontalAlignment(SwingConstants.CENTER);
		lblCosto.setBounds(20, 126, 69, 14);
		panel.add(lblCosto);
		
		textField = new JTextField();
		textField.setBounds(115, 123, 128, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(116, 72, 253, 20);
		panel.add(comboBox);
		comboBox.addItem("Negato");
		comboBox.addItem("Accettato");
		
		
		JButton btnConferma = new JButton("CONFERMA");
		btnConferma.setBounds(264, 122, 105, 23);
		panel.add(btnConferma);
		btnConferma.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		
		
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String costo = textField.getText();
				
				//System.out.println(costo);
				
				Object selectedItem = new Object();
				selectedItem = comboBox.getSelectedItem();
				String stato = new String ();
				stato =selectedItem.toString();
				
				
                //Ricaviamo l'id dell'evento
			    
			    EventoDAO ricavaidevento = new EventoDAO();
			    int idEvento = ricavaidevento.getIdEvento(nomeEvento);
				
			    
			    //System.out.println(stato);
				EventoDAO inseriscicosto = new EventoDAO();
				inseriscicosto.setCostoEvento(idEvento, costo, stato);
				
				
				if(stato.equals("Negato"))
				{
					
					JFrame statonegato = new JFrame();
					JOptionPane.showMessageDialog(statonegato,"LO STATO DELL'EVENTO E' RIMASTO NEGATO");
					
				}
				
				
				
				JFrame costosalvato = new JFrame();
				JOptionPane.showMessageDialog(costosalvato,"COSTO E STATO SALVATI");
				
				finestra.dispose();
				finestra1.dispose();
				
				SceltaEventoConfermaGUI sceltaEvento = new SceltaEventoConfermaGUI();
				sceltaEvento.setVisible(true);
			}
		});
	}

}
