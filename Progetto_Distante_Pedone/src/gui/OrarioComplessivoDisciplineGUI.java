package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import DAO.LezioneDAO;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OrarioComplessivoDisciplineGUI extends JFrame {
    
	private JPanel contentPane;
	private JFrame finestra = this;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrarioComplessivoDisciplineGUI frame = new OrarioComplessivoDisciplineGUI();
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
	public OrarioComplessivoDisciplineGUI(String aula,int id) {
		setTitle("OrarioComplessivoDiscipline");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 25, 1180, 700);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 1144, 47);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblOrarioComplessivoDiscipline = new JLabel("ORARIO COMPLESSIVO DELLE DISCIPLINE");
		lblOrarioComplessivoDiscipline.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 18));
		lblOrarioComplessivoDiscipline.setHorizontalAlignment(SwingConstants.CENTER);
		lblOrarioComplessivoDiscipline.setBounds(359, 11, 378, 27);
		panel.add(lblOrarioComplessivoDiscipline);
		
		JLabel lblNewLabel_55 = new JLabel(aula);
		lblNewLabel_55.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
		lblNewLabel_55.setBounds(10, 11, 243, 25);
		panel.add(lblNewLabel_55);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 82, 106, 488);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbl9 = new JLabel("09:00-10:00");
		lbl9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl9.setBounds(10, 40, 85, 30);
		panel_1.add(lbl9);
		
		JLabel lbl10 = new JLabel("10:00-11:00");
		lbl10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl10.setBounds(10, 80, 85, 30);
		panel_1.add(lbl10);
		
		JLabel lbl11 = new JLabel("11:00-12:00");
		lbl11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl11.setBounds(10, 120, 85, 30);
		panel_1.add(lbl11);
		
		JLabel lbl12 = new JLabel("12:00-13:00");
		lbl12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl12.setBounds(10, 160, 85, 30);
		panel_1.add(lbl12);
		
		JLabel lbl15 = new JLabel("15:00-16:00");
		lbl15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl15.setBounds(10, 200, 85, 30);
		panel_1.add(lbl15);
		
		JLabel lbl16 = new JLabel("16:00-17:00");
		lbl16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl16.setBounds(10, 240, 85, 30);
		panel_1.add(lbl16);
		
		JLabel lbl17 = new JLabel("17:00-18:00");
		lbl17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl17.setBounds(10, 280, 85, 30);
		panel_1.add(lbl17);
		
		JLabel lbl18 = new JLabel("18:00-19:00");
		lbl18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl18.setBounds(10, 320, 85, 30);
		panel_1.add(lbl18);
		
		JLabel lbl19 = new JLabel("19:00-20:00");
		lbl19.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl19.setBounds(10, 360, 85, 30);
		panel_1.add(lbl19);
		
		JLabel lbl20 = new JLabel("20:00-21:00");
		lbl20.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl20.setBounds(10, 400, 85, 30);
		panel_1.add(lbl20);
		
		JLabel lbl21 = new JLabel("21:00-22:00");
		lbl21.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbl21.setBounds(10, 440, 85, 30);
		panel_1.add(lbl21);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(126, 82, 163, 488);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblLunedì = new JLabel("LUNEDI'");
		lblLunedì.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		lblLunedì.setHorizontalAlignment(SwingConstants.CENTER);
		lblLunedì.setBounds(36, 11, 78, 21);
		panel_2.add(lblLunedì);
		
		JLabel lbllun9 = new JLabel("");
		lbllun9.setForeground(new Color(0, 0, 0));
		lbllun9.setBackground(Color.WHITE);
		lbllun9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun9.setBounds(10, 45, 140, 30);
		panel_2.add(lbllun9);
		
		JLabel lbllun10 = new JLabel("");
		lbllun10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun10.setBounds(10, 85, 140, 30);
		panel_2.add(lbllun10);
		
		JLabel lbllun11 = new JLabel("");
		lbllun11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun11.setBounds(10, 125, 140, 30);
		panel_2.add(lbllun11);
		
		JLabel lbllun12 = new JLabel("");
		lbllun12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun12.setBounds(10, 165, 140, 30);
		panel_2.add(lbllun12);
		
		JLabel lbllun15 = new JLabel("");
		lbllun15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun15.setBounds(10, 205, 140, 30);
		panel_2.add(lbllun15);
		
		JLabel lbllun16 = new JLabel("");
		lbllun16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun16.setBounds(10, 245, 140, 30);
		panel_2.add(lbllun16);
		
		JLabel lbllun17 = new JLabel("");
		lbllun17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun17.setBounds(10, 285, 140, 30);
		panel_2.add(lbllun17);
		
		JLabel lbllun18 = new JLabel("");
		lbllun18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun18.setBounds(10, 325, 140, 30);
		panel_2.add(lbllun18);
		
		JLabel lbllun19 = new JLabel("\r\n");
		lbllun19.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun19.setBounds(10, 365, 140, 30);
		panel_2.add(lbllun19);
		
		JLabel lbllun20 = new JLabel("");
		lbllun20.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun20.setBounds(10, 405, 140, 30);
		panel_2.add(lbllun20);
		
		JLabel lbllun21 = new JLabel("");
		lbllun21.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbllun21.setBounds(10, 445, 140, 30);
		panel_2.add(lbllun21);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(299, 82, 163, 488);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblMartedì = new JLabel("MARTEDI'");
		lblMartedì.setBounds(36, 11, 78, 21);
		panel_3.add(lblMartedì);
		lblMartedì.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		lblMartedì.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(10, 45, 140, 30);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 85, 140, 30);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 125, 140, 30);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 165, 140, 30);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 205, 140, 30);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 245, 140, 30);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 285, 140, 30);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(10, 325, 140, 30);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 365, 140, 30);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(10, 405, 140, 30);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(10, 445, 140, 30);
		panel_3.add(lblNewLabel_10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(472, 82, 163, 488);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblMercoled = new JLabel("MERCOLEDI'");
		lblMercoled.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		lblMercoled.setHorizontalAlignment(SwingConstants.CENTER);
		lblMercoled.setBounds(36, 11, 78, 21);
		panel_4.add(lblMercoled);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(10, 45, 140, 30);
		panel_4.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(10, 85, 140, 30);
		panel_4.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(10, 125, 140, 30);
		panel_4.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_14.setBounds(10, 165, 140, 30);
		panel_4.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_15.setBounds(10, 205, 140, 30);
		panel_4.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("\r\n\r\n");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_16.setBounds(10, 245, 140, 30);
		panel_4.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_17.setBounds(10, 285, 140, 30);
		panel_4.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_18.setBounds(10, 325, 140, 30);
		panel_4.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_19.setBounds(10, 365, 140, 30);
		panel_4.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_20.setBounds(10, 405, 140, 30);
		panel_4.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_21.setBounds(10, 445, 140, 30);
		panel_4.add(lblNewLabel_21);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(645, 82, 163, 488);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblGioved = new JLabel("GIOVEDI'");
		lblGioved.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		lblGioved.setHorizontalAlignment(SwingConstants.CENTER);
		lblGioved.setBounds(36, 11, 78, 21);
		panel_5.add(lblGioved);
		
		JLabel lblNewLabel_22 = new JLabel("");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_22.setBounds(10, 45, 140, 30);
		panel_5.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_23.setBounds(10, 85, 140, 30);
		panel_5.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("");
		lblNewLabel_24.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_24.setBounds(10, 125, 140, 30);
		panel_5.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("");
		lblNewLabel_25.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_25.setBounds(10, 165, 140, 30);
		panel_5.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("");
		lblNewLabel_26.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_26.setBounds(10, 205, 140, 30);
		panel_5.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("");
		lblNewLabel_27.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_27.setBounds(10, 245, 140, 30);
		panel_5.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("");
		lblNewLabel_28.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_28.setBounds(10, 285, 140, 30);
		panel_5.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("");
		lblNewLabel_29.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_29.setBounds(10, 325, 140, 30);
		panel_5.add(lblNewLabel_29);
		
		JLabel lblNewLabel_30 = new JLabel("");
		lblNewLabel_30.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_30.setBounds(10, 365, 140, 30);
		panel_5.add(lblNewLabel_30);
		
		JLabel lblNewLabel_31 = new JLabel("");
		lblNewLabel_31.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_31.setBounds(10, 405, 140, 30);
		panel_5.add(lblNewLabel_31);
		
		JLabel lblNewLabel_32 = new JLabel("");
		lblNewLabel_32.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_32.setBounds(10, 445, 140, 30);
		panel_5.add(lblNewLabel_32);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(818, 82, 163, 488);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblVenerdi = new JLabel("VENERDI'");
		lblVenerdi.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		lblVenerdi.setHorizontalAlignment(SwingConstants.CENTER);
		lblVenerdi.setBounds(36, 11, 78, 21);
		panel_6.add(lblVenerdi);
		
		JLabel lblNewLabel_33 = new JLabel("");
		lblNewLabel_33.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_33.setBounds(10, 45, 140, 30);
		panel_6.add(lblNewLabel_33);
		
		JLabel lblNewLabel_34 = new JLabel("");
		lblNewLabel_34.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_34.setBounds(10, 85, 140, 30);
		panel_6.add(lblNewLabel_34);
		
		JLabel lblNewLabel_35 = new JLabel("");
		lblNewLabel_35.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_35.setBounds(10, 125, 140, 30);
		panel_6.add(lblNewLabel_35);
		
		JLabel lblNewLabel_36 = new JLabel("");
		lblNewLabel_36.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_36.setBounds(10, 165, 140, 30);
		panel_6.add(lblNewLabel_36);
		
		JLabel lblNewLabel_37 = new JLabel("");
		lblNewLabel_37.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_37.setBounds(10, 205, 140, 30);
		panel_6.add(lblNewLabel_37);
		
		JLabel lblNewLabel_38 = new JLabel("");
		lblNewLabel_38.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_38.setBounds(10, 245, 140, 30);
		panel_6.add(lblNewLabel_38);
		
		JLabel lblNewLabel_39 = new JLabel("");
		lblNewLabel_39.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_39.setBounds(10, 285, 140, 30);
		panel_6.add(lblNewLabel_39);
		
		JLabel lblNewLabel_40 = new JLabel("");
		lblNewLabel_40.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_40.setBounds(10, 325, 140, 30);
		panel_6.add(lblNewLabel_40);
		
		JLabel lblNewLabel_41 = new JLabel("");
		lblNewLabel_41.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_41.setBounds(10, 365, 140, 30);
		panel_6.add(lblNewLabel_41);
		
		JLabel lblNewLabel_42 = new JLabel("");
		lblNewLabel_42.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_42.setBounds(10, 405, 140, 30);
		panel_6.add(lblNewLabel_42);
		
		JLabel lblNewLabel_43 = new JLabel("");
		lblNewLabel_43.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_43.setBounds(10, 445, 140, 30);
		panel_6.add(lblNewLabel_43);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(991, 82, 163, 488);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblSabato =new JLabel("SABATO");
		lblSabato.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		lblSabato.setHorizontalAlignment(SwingConstants.CENTER);
		lblSabato.setBounds(36, 11, 78, 21);
		panel_7.add(lblSabato);
		
		JLabel lblNewLabel_44 = new JLabel("");
		lblNewLabel_44.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_44.setBounds(10, 45, 140, 30);
		panel_7.add(lblNewLabel_44);
		
		JLabel lblNewLabel_45 = new JLabel("");
		lblNewLabel_45.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_45.setBounds(10, 85, 140, 30);
		panel_7.add(lblNewLabel_45);
		
		JLabel lblNewLabel_46 = new JLabel("");
		lblNewLabel_46.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_46.setBounds(10, 125, 140, 30);
		panel_7.add(lblNewLabel_46);
		
		JLabel lblNewLabel_47 = new JLabel("");
		lblNewLabel_47.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_47.setBounds(10, 165, 140, 30);
		panel_7.add(lblNewLabel_47);
		
		JLabel lblNewLabel_48 = new JLabel("");
		lblNewLabel_48.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_48.setBounds(10, 205, 140, 30);
		panel_7.add(lblNewLabel_48);
		
		JLabel lblNewLabel_49 = new JLabel("");
		lblNewLabel_49.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_49.setBounds(10, 245, 140, 30);
		panel_7.add(lblNewLabel_49);
		
		JLabel lblNewLabel_50 = new JLabel("");
		lblNewLabel_50.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_50.setBounds(10, 285, 140, 30);
		panel_7.add(lblNewLabel_50);
		
		JLabel lblNewLabel_51 = new JLabel("");
		lblNewLabel_51.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_51.setBounds(10, 325, 140, 30);
		panel_7.add(lblNewLabel_51);
		
		JLabel lblNewLabel_52 = new JLabel("");
		lblNewLabel_52.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_52.setBounds(10, 365, 140, 30);
		panel_7.add(lblNewLabel_52);
		
		JLabel lblNewLabel_53 = new JLabel("");
		lblNewLabel_53.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_53.setBounds(10, 405, 140, 30);
		panel_7.add(lblNewLabel_53);
		
		JLabel lblNewLabel_54 = new JLabel("");
		lblNewLabel_54.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_54.setBounds(10, 445, 140, 30);
		panel_7.add(lblNewLabel_54);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(10, 581, 1144, 69);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JButton btnAggiungiUnaNuova = new JButton("AGGIUNGI UNA NUOVA LEZIONE");
		
		btnAggiungiUnaNuova.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 13));
		btnAggiungiUnaNuova.setBounds(308, 11, 535, 29);
		panel_8.add(btnAggiungiUnaNuova);
		
		
		//STAMPA ORARIO COMPLESSIVO DELLE DISCIPLINE
		
		LezioneDAO letturaorariocomplessivo = new LezioneDAO();
		
		//POPOLO l'ORARIO DEL LUNEDI'
		int lunghezza = letturaorariocomplessivo.getOrarioComplessivo ("Lunedi",aula).size();
		if (lunghezza>0)
		{	
	    for(int i=0; i< lunghezza ; i++)
		
		{
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("09:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun9.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
			
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("10:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun10.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue; 
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("11:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun11.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("12:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun12.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("15:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun15.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("16:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun16.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("17:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun16.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("18:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun17.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("19:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun18.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("20:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun19.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getOra().equals("21:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Lunedi",aula).get(i).getLivello();
				 
				 
				lbllun20.setText("<html>"+disciplina+"<br>"+livello+"</html");
				continue;
			}
		}
	}
		letturaorariocomplessivo.getOrarioComplessivo("Lunedì",aula).clear();
		
		
		
		
		//POPOLO l'ORARIO DEL MARTEDI'
		int lunghezza1 = letturaorariocomplessivo.getOrarioComplessivo ("Martedì",aula).size();
		System.out.println(lunghezza1);
		if (lunghezza1 > 0)
		{	
		for(int i=0; i< lunghezza1 ; i++)
		{
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("09:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("10:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_1.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("11:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_2.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("12:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_3.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("15:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_4.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("16:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_5.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("17:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_6.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("18:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_7.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("19:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_8.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("20:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_9.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getOra().equals("21:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_10.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
			}
		  }
		}
	
		
	          letturaorariocomplessivo.getOrarioComplessivo("Martedì",aula).clear();
		
		
	//POPOLO l'ORARIO DEL MERCOLEDI'
	        int lunghezza2 = letturaorariocomplessivo.getOrarioComplessivo ("Mercoledì",aula).size();
	  		if (lunghezza2 > 0)
	  {
		for(int i=0; i< lunghezza2 ; i++)
		{
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("09:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_11.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
				
			}
			
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("10:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_12.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("11:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_13.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("12:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_14.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("15:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_15.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("16:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_16.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("17:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_17.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("18:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_18.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("19:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_19.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("20:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_20.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
			if(letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getOra().equals("21:00:00"))
			{
				 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getDisciplina();
				 String livello = letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).get(i).getLivello();
				 
				 
				 lblNewLabel_21.setText("<html>"+disciplina+"<br>"+livello+"</html");
				 continue;
					
			}
		}
	  }
		letturaorariocomplessivo.getOrarioComplessivo("Mercoledì",aula).clear();
		
		
		//POPOLO l'ORARIO DEL GIOVEDI'
		int lunghezza3 = letturaorariocomplessivo.getOrarioComplessivo ("Giovedì",aula).size();
		if (lunghezza3 > 0)
		{
				for(int i=0; i< lunghezza3 ; i++)
				{
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("09:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_22.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("10:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_23.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("11:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_24.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("12:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_25.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("15:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_26.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("16:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_27.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("17:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_28.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("18:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_29.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("19:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_30.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("20:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_31.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getOra().equals("21:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_32.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					
				}
			   }
				letturaorariocomplessivo.getOrarioComplessivo("Giovedì",aula).clear();
				


				//POPOLO l'ORARIO DEL VENERDI'
				int lunghezza4 = letturaorariocomplessivo.getOrarioComplessivo ("Venerdì",aula).size();
				if (lunghezza4 > 0)
		  		{
				for(int i=0; i< lunghezza4 ; i++)
				{
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("09:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_33.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("10:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_34.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("11:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_35.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("12:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_36.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("15:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_37.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("16:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_38.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("17:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_39.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("18:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_40.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("19:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_41.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("20:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_42.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getOra().equals("21:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_43.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					
				}	
			   }
				letturaorariocomplessivo.getOrarioComplessivo("Venerdì",aula).clear();
				
	//POPOLO l'ORARIO DEL SABATO
				int lunghezza5 = letturaorariocomplessivo.getOrarioComplessivo ("Sabato",aula).size();
				if (lunghezza5 > 0)
			{
				for(int i=0; i< lunghezza5 ; i++)
				{
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("09:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_44.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("10:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_45.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("11:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_46.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("12:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_47.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("15:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_48.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("16:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_49.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("17:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_50.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("18:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_51.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("19:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_52.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("20:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_53.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					if(letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getOra().equals("21:00:00"))
					{
						 String disciplina = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getDisciplina();
						 String livello = letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).get(i).getLivello();
						 
						 
						 lblNewLabel_54.setText("<html>"+disciplina+"<br>"+livello+"</html");
						 continue;
					}
					
				}
			   }
				letturaorariocomplessivo.getOrarioComplessivo("Sabato",aula).clear();
				
				
				btnAggiungiUnaNuova.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						CreaLezioneGUI crealezione = new CreaLezioneGUI(finestra,aula,id);
						crealezione.setVisible(true);
					}
				});	
		
		
	}
}
