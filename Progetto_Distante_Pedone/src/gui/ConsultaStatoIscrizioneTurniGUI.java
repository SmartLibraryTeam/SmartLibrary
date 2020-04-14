package gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.LezioneDAO;
import java.awt.Color;




public class ConsultaStatoIscrizioneTurniGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaStatoIscrizioneTurniGUI frame = new ConsultaStatoIscrizioneTurniGUI();
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
	public ConsultaStatoIscrizioneTurniGUI(int id) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 921, 458);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds (10, 43, 885, 312);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 865, 45);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblLivello = new JLabel("LIVELLO");
		lblLivello.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblLivello.setHorizontalAlignment(SwingConstants.CENTER);
		lblLivello.setBounds(130, 11, 100, 23);
		panel.add(lblLivello);
		
		JLabel lblDisciplina = new JLabel("DISCIPLINA");
		lblDisciplina.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisciplina.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblDisciplina.setBounds(10, 11, 110, 23);
		panel.add(lblDisciplina);
		
		JLabel lblGiorno = new JLabel("GIORNO");
		lblGiorno.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiorno.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblGiorno.setBounds(240, 11, 100, 23);
		panel.add(lblGiorno);
		
		JLabel lblOra = new JLabel("ORA");
		lblOra.setHorizontalAlignment(SwingConstants.CENTER);
		lblOra.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblOra.setBounds(350, 11, 110, 23);
		panel.add(lblOra);
		
		JLabel lblStatoTurno = new JLabel("STATO TURNO");
		lblStatoTurno.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatoTurno.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblStatoTurno.setBounds(468, 11, 119, 23);
		panel.add(lblStatoTurno);
		
		JLabel lblStatoPagamento = new JLabel("STATO PAGAMENTO");
		lblStatoPagamento.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatoPagamento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblStatoPagamento.setBounds(599, 11, 119, 23);
		panel.add(lblStatoPagamento);
		
		JLabel lblAula = new JLabel("AULA");
		lblAula.setHorizontalAlignment(SwingConstants.CENTER);
		lblAula.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblAula.setBounds(728, 11, 119, 23);
		panel.add(lblAula);
		
	
		
		DisciplinaDAO lettura = new DisciplinaDAO();
		
		JPanel[] panel_2 = new JPanel[lettura.getTurni(id).size()];
		System.out.println("I turni trovati sono " + lettura.getTurni(id).size());
		int u = 0 ;
		for (int i =0; i< lettura.getTurni(id).size(); i++)
		{
			//CREO PANNELLO
			
			panel_2[i] = new JPanel();
			panel_2[i].setLayout(null);
			panel_2[i].setBounds(10, 67 + u, 870, 45);
			panel_1.add(panel_2[i]);
			
			
			//RICAVO DATI SUI TURNI
			
			int idDisc = Integer.parseInt((lettura.getTurni(id).get(i)[1]));
			DisciplinaDAO nome = new DisciplinaDAO();
			String NOMEDISCIPLINA = nome.getNomeDisciplina(idDisc).get(0)[0];
			
		    DisciplinaDAO livello1 = new DisciplinaDAO();
			String LIVELLO = livello1.getLivelloDisciplina(idDisc).get(0)[0];
		
		
			int idLez = Integer.parseInt(lettura.getTurni(id).get(i)[2]);
		
			LezioneDAO giorno1 = new LezioneDAO();
			String GIORNO = giorno1.getGiornoEvento(idLez).get(0)[0];
		    LezioneDAO ora1 = new LezioneDAO();
			String ORA =  ora1.getOraEvento(idLez).get(0)[0];
		
			String STATOTURNO = lettura.getTurni(id).get(i)[3];
			String STATOPAGAMENTO = lettura.getTurni(id).get(i)[4];
		
		    LezioneDAO ricavaAula = new LezioneDAO();
			String AULA = ricavaAula.getAula(idLez).get(0)[0];
			
			JLabel livello = new JLabel(LIVELLO);
			livello.setHorizontalAlignment(SwingConstants.CENTER);
			livello.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			livello.setBounds(130, 11, 100, 23);
			panel_2[i].add(livello);
		
			JLabel disciplina = new JLabel(NOMEDISCIPLINA);
			disciplina.setHorizontalAlignment(SwingConstants.CENTER);
			disciplina.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			disciplina.setBounds(10, 11, 110, 23);
			panel_2[i].add(disciplina);
		
			JLabel giorno = new JLabel(GIORNO);
			giorno.setHorizontalAlignment(SwingConstants.CENTER);
			giorno.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			giorno.setBounds(240, 11, 100, 23);
			panel_2[i].add(giorno);
		
			JLabel ora = new JLabel(ORA);
			ora.setHorizontalAlignment(SwingConstants.CENTER);
			ora.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			ora.setBounds(350, 11, 110, 23);
			panel_2[i].add(ora);
		
			JLabel statoturno = new JLabel(STATOTURNO);
			statoturno.setHorizontalAlignment(SwingConstants.CENTER);
			statoturno.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			statoturno.setBounds(468, 11, 119, 23);
			panel_2[i].add(statoturno);
		
			JLabel statopagamento = new JLabel(STATOPAGAMENTO);
			statopagamento.setHorizontalAlignment(SwingConstants.CENTER);
			statopagamento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			statopagamento.setBounds(599, 11, 119, 23);
			panel_2[i].add(statopagamento);
			
			JLabel aula = new JLabel(AULA);
			aula.setHorizontalAlignment(SwingConstants.CENTER);
			aula.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			aula.setBounds(730, 11, 119, 23);
			panel_2[i].add(aula);
			
			u = u + 50;
		}
						
		JButton btnChiudi = new JButton("CHIUDI");
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finestra.dispose();
			}
		});
		btnChiudi.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 14));
		btnChiudi.setBounds(386, 366, 165, 42);
		contentPane.add(btnChiudi);
		
		JLabel lblNewLabel = new JLabel("QUESTO E' LO STATO DEI TUOI TURNI:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 885, 29);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		
	}

}
