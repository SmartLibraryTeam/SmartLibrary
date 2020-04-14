package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import gui.LoginGUI;

import DAO.UtenteRegistratoDAO;



@SuppressWarnings("serial")
public class HomeIstruttoreGUI extends JFrame {

	private JPanel contentPane;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeIstruttoreGUI frame = new HomeIstruttoreGUI();
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
	public HomeIstruttoreGUI(int id) {
		setTitle("HomeIstruttore");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 414, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		//DAO CHE RICAVA IL NOME DELL'UTENTE DATO L'ID
		UtenteRegistratoDAO ricavanomeutente = new UtenteRegistratoDAO();
		String nomeUt = ricavanomeutente.getNomeUtente (id).get(0)[0];
	    String cognomeUt=ricavanomeutente.getNomeUtente (id).get(0)[1];
	   
	   
		
		JLabel lblBenvenuto = new JLabel("BENVENUTO  "+ nomeUt +"  "+cognomeUt+" !");
		lblBenvenuto.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 25));
		lblBenvenuto.setBounds(10, 11, 350, 28);
		panel.add(lblBenvenuto);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 72, 332, 87);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCreaTurniDiscipline = new JButton("CREA TURNI DISCIPLINE");
		btnCreaTurniDiscipline.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				
				SceltaDisciplinaLivelloCreaTurniGUI scelta =  new 	SceltaDisciplinaLivelloCreaTurniGUI (id);
				scelta.setVisible(true);
				
			}
		});
		btnCreaTurniDiscipline.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnCreaTurniDiscipline.setBounds(10, 24, 312, 44);
		panel_1.add(btnCreaTurniDiscipline);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 170, 332, 87);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnOrganizzaEvento = new JButton("GESTISCI EVENTI");
		btnOrganizzaEvento.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				GestioneEventiIstruttoreGUI gestioneeventiistruttore = new GestioneEventiIstruttoreGUI (id);
				gestioneeventiistruttore.setVisible(true);
			}
		});
		btnOrganizzaEvento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnOrganizzaEvento.setBounds(10, 24, 312, 44);
		panel_2.add(btnOrganizzaEvento);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 272, 332, 100);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JButton btnStatoDeiTuoi = new JButton("STATO DEI TUOI EVENTI");
		btnStatoDeiTuoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ConsultaStatoEventiGUI consultaStatoEventi = new ConsultaStatoEventiGUI(id);
				consultaStatoEventi.setVisible(true);
			}
		});
		btnStatoDeiTuoi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnStatoDeiTuoi.setBounds(10, 24, 312, 44);
		panel_3.add(btnStatoDeiTuoi);
		
		LoginGUI logingui = new LoginGUI();
		String path1 =logingui.DirectoryProgramma+"/img/imgSistem/iscrizioni.png";
		String path2 =logingui.DirectoryProgramma+"/img/imgSistem/eventi.png";
		String path3 =logingui.DirectoryProgramma+"/img/imgSistem/statoevento.png";
		
		
		
		JLabel lblNewLabel = new JLabel("");
		ImageIcon image1 = new ImageIcon(path1);
		Image IMAGE1 = image1.getImage();
		IMAGE1 = IMAGE1.getScaledInstance( 109, 94, IMAGE1.SCALE_REPLICATE);
		image1.setImage(IMAGE1);
		lblNewLabel.setIcon(image1);
		lblNewLabel.setBounds(384, 61, 109, 94);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		ImageIcon image2 = new ImageIcon(path2);
		Image IMAGE2 = image2.getImage();
		IMAGE2 = IMAGE2.getScaledInstance( 109, 94, IMAGE2.SCALE_REPLICATE);
		image2.setImage(IMAGE2);
		label.setIcon(image2);
		label.setBounds(384, 170, 109, 94);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		ImageIcon image3 = new ImageIcon(path3);
		Image IMAGE3 = image3.getImage();
		IMAGE3 = IMAGE3.getScaledInstance( 109, 94, IMAGE3.SCALE_REPLICATE);
		image3.setImage(IMAGE3);
		label_1.setIcon(image3);
		label_1.setBounds(384, 272, 109, 94);
		contentPane.add(label_1);
		
	}

}
