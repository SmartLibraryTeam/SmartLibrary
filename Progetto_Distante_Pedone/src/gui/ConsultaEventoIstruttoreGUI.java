package gui;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.EventoDAO;
import DAO.LezioneDAO;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ConsultaEventoIstruttoreGUI extends JFrame {

	private JPanel contentPane;
	public JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaEventoIstruttoreGUI frame = new ConsultaEventoIstruttoreGUI();
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
	public ConsultaEventoIstruttoreGUI(String nomeEvento)
	{
		
	    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 445);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 464, 46);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblConsultaIDati = new JLabel("CONSULTA I DATI DEL TUO EVENTO");
		lblConsultaIDati.setHorizontalAlignment(SwingConstants.CENTER);
		lblConsultaIDati.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 15));
		lblConsultaIDati.setBounds(72, 11, 301, 26);
		panel.add(lblConsultaIDati);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 78, 464, 71);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		//Salviamo nella stringa nomeevento il valore di nomeEvento
		String nomeevento = nomeEvento;
		
		JLabel lblNomeEvento = new JLabel("NOME EVENTO ");
		lblNomeEvento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNomeEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNomeEvento.setBounds(48, 11, 93, 20);
		panel_1.add(lblNomeEvento);
		
		JLabel lblTipoEvento = new JLabel("TIPO EVENTO");
		lblTipoEvento.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoEvento.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblTipoEvento.setBounds(331, 11, 93, 20);
		panel_1.add(lblTipoEvento);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//Rendiamo visibile il nome dell'evento nel label
		lblNewLabel.setText(nomeevento);
		
		lblNewLabel.setBounds(10, 36, 178, 20);
		panel_1.add(lblNewLabel);
		
		//Vogliamo ricavare il tipo dell'evento
		
		//DAO CHE PRENDE IL NOME DELL'EVENTO E RESTITUISCE IL TIPO ( PRENDE STRING E RITORNA VECTOR )
        EventoDAO ricavatipoevento = new EventoDAO();
	    String tipoEvento = ricavatipoevento.getTipoEvento(nomeEvento).get(0)[0];
		System.out.println(tipoEvento);
				
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		//Rendiamo visibile il tipo dell'evento nel label
		lblNewLabel_1.setText(tipoEvento);
		lblNewLabel_1.setBounds(321, 36, 103, 20);
		panel_1.add(lblNewLabel_1);
		
		
		
		
		
		//Vogliamo ricavare la disciplina a cui appartiene l'evento
	
		//DAO CHE PRENDE IN INGRESSO IL NOME DELL'EVENTO E RESTITUISCE L'ID DELLA DISCIPLINA
	    EventoDAO ricavaiddisciplina = new EventoDAO();
	    int idDisc = Integer.parseInt(ricavaiddisciplina .getIdDisciplina (nomeEvento).get(0)[0]);
	    System.out.println(idDisc);
					    
					    
	    //DAO CHE PRENDE L'ID DELLA DISCIPLINA E RESTITUISCE IL SUO NOME
		DisciplinaDAO ricavanomedisciplina = new DisciplinaDAO();
	    String nomeDisc = ricavanomedisciplina.getNomeDisciplina (idDisc).get(0)[0];
	    System.out.println(nomeDisc);
	    
	    
        //Vogliamo ricavare il livello della disciplina a cui appartiene l'evento
		
	    //DAO CHE PRENDE L'ID DELLA DISCIPLINA E RESTITUISCE IL SUO LIVELLO
        DisciplinaDAO ricavalivellodisciplina = new  DisciplinaDAO();
	  	String livelloDisc = ricavalivellodisciplina.getLivelloDisciplina (idDisc).get(0)[0];
	  	System.out.println(livelloDisc);
	  				
		
						
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 170, 464, 71);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("DISCIPLINA");
		lblNewLabel_2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(40, 8, 93, 20);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("LIVELLO");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(351, 11, 46, 14);
		panel_2.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		//Rendiamo visibile il nome della disciplina nel label
	    lblNewLabel_4.setText(nomeDisc);
		lblNewLabel_4.setBounds(40, 36, 103, 20);
		panel_2.add(lblNewLabel_4);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//Rendiamo visibile il livello della disciplina nel label
	    lblNewLabel_8.setText(livelloDisc);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(332, 36, 103, 20);
		panel_2.add(lblNewLabel_8);
		
		//Vogliamo ricavare il giorno e l'ora in cui si svolgerà l'evento
		
		//DAO CHE PRENDE IN INGRESSO IL NOME DELL'EVENTO E RESTITUISCE L'ID DELLA LEZIONE

		EventoDAO letturaidlezione = new EventoDAO();
		int idLez = Integer.parseInt(letturaidlezione.getIdLezione (nomeEvento).get(0)[0] ); 
				
		//DAO CHE PRENDE L'ID DELLA LEZIONE E RESTITUISCE IL GIORNO IN CUI SI SVOLGERA' L'EVENTO
	    LezioneDAO ricavagiorno = new LezioneDAO ();
		String giorno = ricavagiorno.getGiornoEvento(idLez).get(0)[0];
		System.out.println(giorno);
				
		//DAO CHE PRENDE L'ID DELLA LEZIONE E RESTITUISCE L'ORA IN CUI SI SVOLGERA' L'EVENTO
		LezioneDAO ricavaora = new LezioneDAO();
		String ora = ricavaora.getOraEvento(idLez).get(0)[0];
		System.out.println(ora);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(10, 258, 464, 83);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//Rendiamo visibile il giorno dell'evento nel label
	    lblNewLabel_6.setText(giorno);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(30, 36, 122, 20);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		//Rendiamo visibile l'ora dell'evento nel label
		lblNewLabel_7.setText(ora);
		lblNewLabel_7.setBounds(324, 36, 103, 20);
		panel_3.add(lblNewLabel_7);
	    JLabel lblData = new JLabel("GIORNO");
		lblData.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setBounds(43, 8, 93, 20);
		panel_3.add(lblData);
		
		JLabel lblOra = new JLabel("ORA");
		lblOra.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblOra.setHorizontalAlignment(SwingConstants.CENTER);
		lblOra.setBounds(351, 11, 46, 14);
		panel_3.add(lblOra);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(10, 352, 464, 54);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finestra.dispose();
			}
		});
		btnOk.setBounds(313, 11, 102, 23);
		panel_5.add(btnOk);
		btnOk.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		
		JButton btnConsultaLaLista = new JButton("Consulta la lista degli iscritti all'evento");
		btnConsultaLaLista.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		btnConsultaLaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ListaIscrittiEventoIstruttoreGUI lista = new ListaIscrittiEventoIstruttoreGUI(nomeEvento);
				lista.setVisible(true);
			}
		});
		btnConsultaLaLista.setBounds(21, 6, 243, 34);
		panel_5.add(btnConsultaLaLista);
	}
}

