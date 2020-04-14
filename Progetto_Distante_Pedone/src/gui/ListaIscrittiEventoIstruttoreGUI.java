package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.EventoDAO;
import DAO.UtenteRegistratoDAO;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ListaIscrittiEventoIstruttoreGUI extends JFrame {
	
	private JPanel contentPane;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListaIscrittiEventoIstruttoreGUI frame = new ListaIscrittiEventoIstruttoreGUI();
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
	public ListaIscrittiEventoIstruttoreGUI(String nomeEvento) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 331, 485);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		EventoDAO iscritti = new EventoDAO();
	
		
		int y =0;
		int u =0;
		while(y<iscritti.getIscrittiEvento(nomeEvento).size())
		{
			
		    UtenteRegistratoDAO nome = new UtenteRegistratoDAO();
			
			String NOME = nome.getNomeUtente(Integer.parseInt((iscritti.getIscrittiEvento(nomeEvento).get(y)[0]))).get(0)[0];
			String COGNOME = nome.getNomeUtente(Integer.parseInt((iscritti.getIscrittiEvento(nomeEvento).get(y)[0]))).get(0)[1];
			
			JLabel label = new JLabel((y+1)+". "+ NOME + "  "+ COGNOME);
			label.setBounds(100, 1 + u, 200, 100);
			contentPane.add(label);
			
			u = u+ 20;
			y++;
		}
		
		
		
		JLabel lblNewLabel = new JLabel("ISCRITTI ALL'EVENTO");
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(25, 11, 258, 31);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("CHIUDI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				finestra.dispose();
			}
		});
		btnNewButton.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnNewButton.setBounds(117, 412, 89, 23);
		contentPane.add(btnNewButton);
		
	    }
}
