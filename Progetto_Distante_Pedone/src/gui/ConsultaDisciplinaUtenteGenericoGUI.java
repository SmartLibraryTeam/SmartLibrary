package gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import business.DirectoryCorrente;

import DAO.UtenteRegistratoDAO;
import DAO.DisciplinaDAO;
import DAO.TestimonianzaDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ConsultaDisciplinaUtenteGenericoGUI extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaDisciplinaUtenteGenericoGUI frame = new ConsultaDisciplinaUtenteGenericoGUI();
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
	public ConsultaDisciplinaUtenteGenericoGUI(String disciplina) {
		getContentPane().setBackground(Color.WHITE);
		
		//DAO CHE RICAVA GLI ID DELLE DISCIPLINE CON IL NOME SCELTO
		DisciplinaDAO ricavadiscipline = new  DisciplinaDAO();
		
		
		
		//SE LA DISCIPLINA HA UN SOLO LIVELLO SI APRE QUESTA VIEW
		if(ricavadiscipline.getIdDiscipline(disciplina).size() == 1)
		{
			setTitle("ConsultaDisciplinaUtenteGenerico");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(400, 15, 598, 715);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			// RICAVO I DATI PER POPOLARE LA VIEW AL VARIALE DELLA DISCIPLINA
			
			//Dal nome della disciplina ricavo il livello:
			
			String livello =  new String();
			
			DisciplinaDAO letturalivello = new DisciplinaDAO();
		
			livello = letturalivello.getLivelloDisciplina (disciplina).get(0)[0].toString();
			
			//Dal nome e dal livello ricavo i dati e li salvo nelle variabili;
			
			DisciplinaDAO letturaid = new  DisciplinaDAO();
			
			int ID = letturaid.getIdDisciplina(disciplina, livello);
			
			DisciplinaDAO letturadatidiscipline = new DisciplinaDAO ();
			
			letturadatidiscipline.getDatiDisciplinaFromId(ID);
			
			//int COD_DISCIPLINA = Integer.parseInt(letturadatidiscipline.getDatiDisciplina(disciplina,livello).get(0)[0]);//0
			
			String NOMEDISCIPLINA = new String();
			
			NOMEDISCIPLINA = letturadatidiscipline.getDatiDisciplinaFromId (ID).get(0)[1];//1
			
			String LIVELLO = new String();
			
			LIVELLO = letturadatidiscipline.getDatiDisciplinaFromId (ID).get(0)[2];//2
			
			String DESCRIZIONE = new String();
			DESCRIZIONE = letturadatidiscipline.getDatiDisciplinaFromId (ID).get(0)[3];//3
			
			String PERCORSOFILE = new String();
			DirectoryCorrente percorsoProgramma = new DirectoryCorrente();
			String DirectoryProgramma = percorsoProgramma.getDir().replace("\\", "/");
			
			PERCORSOFILE = DirectoryProgramma+"/img/" + letturadatidiscipline.getDatiDisciplinaFromId (ID).get(0)[4];//4
			
			String COSTO = letturadatidiscipline.getDatiDisciplinaFromId(ID).get(0)[5];//5
			
			int COD_ISTRUTTORE = Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId (ID).get(0)[6]);//6
			
			UtenteRegistratoDAO ricavaistruttore = new UtenteRegistratoDAO();
			
			String NOMEISTRUTTORE = ricavaistruttore.getNomeUtente(COD_ISTRUTTORE).get(0)[0] + " " + ricavaistruttore.getNomeUtente(COD_ISTRUTTORE).get(0)[1];
			
			int COD_RESPONSABILE= Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId (ID).get(0)[7]);//7
			
			UtenteRegistratoDAO ricavaResponsabile = new UtenteRegistratoDAO();
			
			String NOMERESPONSABILE = ricavaResponsabile.getNomeUtente(COD_RESPONSABILE).get(0)[0] + " " + ricavaResponsabile.getNomeUtente(COD_RESPONSABILE).get(0)[1];
			
			
			ImageIcon image = new ImageIcon(PERCORSOFILE);
			
			//ADATTO FORMATO IMMAGINE
			
			Image IMAGE = image.getImage();
			IMAGE = IMAGE.getScaledInstance(564, 267, IMAGE.SCALE_REPLICATE);
			image.setImage(IMAGE);
			
			
			
			JLabel lblNewLabel_3 = new JLabel(NOMEDISCIPLINA);
			lblNewLabel_3.setBounds(10, 230, 554, 48);
			lblNewLabel_3.setForeground(Color.YELLOW);
			lblNewLabel_3.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 56));
			contentPane.add(lblNewLabel_3);
			
			
			JPanel panel_5 = new JPanel();
			panel_5.setBackground(Color.WHITE);
			panel_5.setBounds(10, 606, 614, 70);
			contentPane.add(panel_5);
			panel_5.setLayout(null);
			
			JButton btnVuoiSaperneDi = new JButton("VUOI SAPERNE DI PIU'?  CONSULTA LE TESTIMONIANZE DEI NOSTRI TESSERATI");
			btnVuoiSaperneDi.setBounds(33, 24, 515, 35);
			panel_5.add(btnVuoiSaperneDi);
			
			JLabel lblQualcosaSulLivello = new JLabel("Livello "+ LIVELLO + " :");
			lblQualcosaSulLivello.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			lblQualcosaSulLivello.setBounds(10, 315, 305, 14);
			contentPane.add(lblQualcosaSulLivello);
			
			String descrizione = DESCRIZIONE.replace(".", ".<br>");
			
			
			
			
			JLabel lblNewLabel_2 = new JLabel("<html>"+ descrizione + "<html>");
			lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_2.setToolTipText("");
			lblNewLabel_2.setBounds(10, 340, 562, 125);
			contentPane.add(lblNewLabel_2);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setToolTipText("");
			lblNewLabel.setIcon(null);
			lblNewLabel.setIcon(image);
			lblNewLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 45));
			lblNewLabel.setBounds(10, 11, 564, 267);
			contentPane.add(lblNewLabel);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setLayout(null);
			panel.setBounds(10, 502, 177, 93);
			contentPane.add(panel);
			
			JLabel label = new JLabel("L'istruttore del corso è : ");
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
			label.setBounds(10, 11, 163, 14);
			panel.add(label);
			
			JLabel label_1 = new JLabel(NOMEISTRUTTORE);
			label_1.setHorizontalAlignment(SwingConstants.CENTER);
			label_1.setBounds(10, 36, 142, 46);
			panel.add(label_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(null);
			panel_1.setBounds(199, 502, 177, 93);
			contentPane.add(panel_1);
			
			JLabel lblIlResponsabile = new JLabel("Il responsabile è :");
			lblIlResponsabile.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
			lblIlResponsabile.setHorizontalAlignment(SwingConstants.CENTER);
			lblIlResponsabile.setBounds(10, 11, 163, 14);
			panel_1.add(lblIlResponsabile);
			
			JLabel label_3 = new JLabel(NOMERESPONSABILE);
			label_3.setHorizontalAlignment(SwingConstants.CENTER);
			label_3.setBounds(10, 36, 142, 46);
			panel_1.add(label_3);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setLayout(null);
			panel_2.setBounds(386, 502, 177, 93);
			contentPane.add(panel_2);
			
			JLabel lblIlCosto = new JLabel("Il costo è :  ");
			lblIlCosto.setHorizontalAlignment(SwingConstants.CENTER);
			lblIlCosto.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
			lblIlCosto.setBounds(10, 11, 163, 14);
			panel_2.add(lblIlCosto);
			
			JLabel label_5 = new JLabel("€" + COSTO);
			label_5.setHorizontalAlignment(SwingConstants.CENTER);
			label_5.setBounds(10, 36, 142, 46);
			panel_2.add(label_5);
			
			
			
			
			btnVuoiSaperneDi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				
				{
					int[] IDS  = new int[1];
					IDS[0]=ID;
					
					//MESSAGGIO STAMPATO SE NON CI SONO TESTIMONIANZE PER ALCUN LIVELLO
					TestimonianzaDAO testimonianze = new TestimonianzaDAO();
					
			
					int lunghezza1 =0;
					lunghezza1 = testimonianze.getTestimonianze(IDS[0]).size();
				
					if(lunghezza1 == 0)
					{			
						
							JFrame nessunatestimonianza = new JFrame();
							JOptionPane.showMessageDialog(nessunatestimonianza,"NON E' PRESENTE ANCORA ALCUNA TESTIMONIANZA PER QUESTA DISCIPLINA");	
						
					}
					else
					{
						ConsultaTestimonianzeDisciplinaGUI testimonianza = new ConsultaTestimonianzeDisciplinaGUI(IDS);
						testimonianza.setVisible(true);
					}
				}
				
			
			});
			
			
		}
		
		//SE LA DISCIPLINA HA DUE LIVELLI SI APRE QUESTA VIEW
		
		if(ricavadiscipline.getIdDiscipline(disciplina).size() == 2)
		{
			setTitle("ConsultaDisciplinaUtenteGenerico");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(400, 10, 598, 715);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			//RICAVO LE INFORMAZIONI PER POPOLARE LA VIEW
			
			//Ricavo livelli
			
			DisciplinaDAO livelli = new DisciplinaDAO();
			
			String livello1 = livelli.getLivelloDisciplina(disciplina).get(0)[0].toString();
			String livello2 = livelli.getLivelloDisciplina(disciplina).get(1)[0].toString();
			
			System.out.println("Livello1: " + livello1 + "Livello2: " +  livello2);
			
			//Primo livello
			
			//Dal nome e dal livello ricavo i dati e li salvo nelle variabili;
			
			DisciplinaDAO letturaid = new DisciplinaDAO();
			
			int ID1 = letturaid.getIdDisciplina(disciplina, livello1);
			
			DisciplinaDAO letturadatidiscipline =  new DisciplinaDAO();
			
			String NOMEDISCIPLINA1 = new String();
			
			NOMEDISCIPLINA1 = letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[1];//1
			
			String LIVELLO1 = new String();
			
			LIVELLO1 = letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[2];//2
			
			String DESCRIZIONE1 = new String();
			DESCRIZIONE1 = letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[3];//3
			
			String PERCORSOFILE1 = new String();
			DirectoryCorrente percorsoProgramma = new DirectoryCorrente();
			String DirectoryProgramma = percorsoProgramma.getDir().replace("\\", "/");
			
			PERCORSOFILE1 = DirectoryProgramma+"/img/" + letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[4];//4
			
			String COSTO1 = letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[5];//5
			
			int COD_ISTRUTTORE1 = Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[6]);//6
			
			UtenteRegistratoDAO ricavaistruttore1 = new UtenteRegistratoDAO();
			
			String NOMEISTRUTTORE1 = ricavaistruttore1.getNomeUtente(COD_ISTRUTTORE1).get(0)[0] + " " + ricavaistruttore1.getNomeUtente(COD_ISTRUTTORE1).get(0)[1];
			
			int COD_RESPONSABILE1= Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[7]);//7
			
			UtenteRegistratoDAO ricavaResponsabile1 = new UtenteRegistratoDAO();
			
			String NOMERESPONSABILE1 = ricavaResponsabile1.getNomeUtente(COD_RESPONSABILE1).get(0)[0] + " " + ricavaResponsabile1.getNomeUtente(COD_RESPONSABILE1).get(0)[1];
			
			
			ImageIcon image1 = new ImageIcon(PERCORSOFILE1);
			
			//ADATTO FORMATO IMMAGINE
			
			Image IMAGE1 = image1.getImage();
			IMAGE1 = IMAGE1.getScaledInstance(327,215, IMAGE1.SCALE_REPLICATE);
			image1.setImage(IMAGE1);
			
			//Secondo livello
			
			//dal nome e dal livello ricavo i dati e li salvo nelle variabili;
			
			int ID2 = letturaid.getIdDisciplina(disciplina, livello2);

			String NOMEDISCIPLINA2 = new String();
			
			NOMEDISCIPLINA2 = letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[1];//1
			
			String LIVELLO2 = new String();
			
			LIVELLO2 = letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[2];//2
			
			String DESCRIZIONE2 = new String();
			
			DESCRIZIONE2 = letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[3];//3
			
			String PERCORSOFILE2 = new String();
			
			PERCORSOFILE2 = DirectoryProgramma+"/img/" + letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[4];//4
			
			String COSTO2 = letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[5];//5
			
			int COD_ISTRUTTORE2 = Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[6]);//6
			
		    UtenteRegistratoDAO ricavaistruttore2 = new UtenteRegistratoDAO();
		
			String NOMEISTRUTTORE2 = ricavaistruttore2.getNomeUtente(COD_ISTRUTTORE2).get(0)[0] + " " + ricavaistruttore2.getNomeUtente(COD_ISTRUTTORE2).get(0)[1];
			
			int COD_RESPONSABILE2= Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[7]);//7	
			
		    UtenteRegistratoDAO ricavaResponsabile2 = new UtenteRegistratoDAO();
			
			String NOMERESPONSABILE2 = ricavaResponsabile2.getNomeUtente(COD_RESPONSABILE2).get(0)[0] + " " + ricavaResponsabile2.getNomeUtente(COD_RESPONSABILE2).get(0)[1];
			
			
			ImageIcon image2 = new ImageIcon(PERCORSOFILE2);
			
			//ADATTO FORMATO IMMAGINE
			
			Image IMAGE2 = image2.getImage();
			IMAGE2 = IMAGE2.getScaledInstance(327,215, IMAGE2.SCALE_REPLICATE);
			image2.setImage(IMAGE2);
			
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.setBounds(10, 502, 177, 117);
			contentPane.add(panel_3);
			panel_3.setLayout(null);
			
			
			
			if (COD_ISTRUTTORE1 == COD_ISTRUTTORE2) 
			{
				JLabel lblListruttoreDelCorso = new JLabel("L'istruttore dei corsi è: ");
				lblListruttoreDelCorso.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
				lblListruttoreDelCorso.setBounds(10, 11, 163, 14);
				panel_3.add(lblListruttoreDelCorso);
				JLabel NomiIstruttori = new JLabel("<html>"+ "<br>" + NOMEISTRUTTORE1 +"<html>");
				NomiIstruttori.setBounds(10, 36, 157, 70);
				panel_3.add(NomiIstruttori);
				
			}
			else
			{
				JLabel lblListruttoreDelCorso = new JLabel("Gli istruttori del corso sono : ");
				lblListruttoreDelCorso.setHorizontalAlignment(SwingConstants.CENTER);
				lblListruttoreDelCorso.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
				lblListruttoreDelCorso.setBounds(10, 11, 163, 14);
				panel_3.add(lblListruttoreDelCorso);
				
				JLabel NomiIstruttori = new JLabel("<html>" +livello1+":"+"<br>"+ NOMEISTRUTTORE1 +"<br>"+livello2 +":"+"<br>" +NOMEISTRUTTORE2 +"<html>");
				NomiIstruttori.setHorizontalAlignment(SwingConstants.CENTER);
				NomiIstruttori.setBounds(10, 36, 157, 70);
				panel_3.add(NomiIstruttori);	
			}
			
			
			JPanel panel_4 = new JPanel();
			panel_4.setBackground(Color.WHITE);
			panel_4.setBounds(197, 502, 177, 117);
			contentPane.add(panel_4);
			panel_4.setLayout(null);
			
			JLabel lblIlResponsabileDel = new JLabel("Il responsabile del centro \u00E8:");
			lblIlResponsabileDel.setHorizontalAlignment(SwingConstants.CENTER);
			lblIlResponsabileDel.setBounds(10, 11, 157, 17);
			lblIlResponsabileDel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
			panel_4.add(lblIlResponsabileDel);
			
			JLabel NomeResponsabileCentro = new JLabel(NOMERESPONSABILE1);
			NomeResponsabileCentro.setHorizontalAlignment(SwingConstants.CENTER);
			NomeResponsabileCentro.setBounds(10, 39, 157, 67);
			panel_4.add(NomeResponsabileCentro);
			
			
			JPanel panel_5 = new JPanel();
			panel_5.setBackground(Color.WHITE);
			panel_5.setBounds(10, 630, 562, 46);
			contentPane.add(panel_5);
			panel_5.setLayout(null);
			
			JButton btnVuoiSaperneDi = new JButton("VUOI SAPERNE DI PIU'?  CONSULTA LE TESTIMONIANZE DEI NOSTRI TESSERATI");
			btnVuoiSaperneDi.setBounds(25, 0, 515, 35);
			panel_5.add(btnVuoiSaperneDi);
			
			JLabel Livello1 = new JLabel("Livello "+ livello1);
			Livello1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			Livello1.setBounds(10, 280, 305, 14);
			contentPane.add(Livello1);
			
			//conversioni descrizioni per stamparle nei JLabel
			
			String descrizione2 = new String();
			String descrizione1 = new String();
			
			descrizione2= DESCRIZIONE2.replace(".", ".<br>");
			descrizione1 = DESCRIZIONE1.replace(".", ".<br>");
			
			JLabel Descrizione1 = new JLabel("<html>" + descrizione1 + "<html>");
			Descrizione1.setVerticalAlignment(SwingConstants.TOP);
			Descrizione1.setToolTipText("");
			Descrizione1.setBounds(10, 305, 549, 64);
			contentPane.add(Descrizione1);
			
			JLabel Livello2 = new JLabel("Livello "+ livello2);
			Livello2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			Livello2.setBounds(10, 401, 305, 14);
			contentPane.add(Livello2);
			
			JLabel Descrizione2 = new JLabel("<html>" + descrizione2 + "<html>");
			Descrizione2.setVerticalAlignment(SwingConstants.TOP);
			Descrizione2.setBounds(10, 426, 549, 57);
			contentPane.add(Descrizione2);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 11, 562, 248);
			contentPane.add(panel);
			panel.setLayout(null);
			
			
			JLabel lblNewLabel_3 = new JLabel(disciplina);
			lblNewLabel_3.setBounds(0, 201, 554, 48);
			panel.add(lblNewLabel_3);
			lblNewLabel_3.setForeground(Color.YELLOW);
			lblNewLabel_3.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 56));
			
			
			JLabel Immagine1 = new JLabel();
			Immagine1.setIcon(image1);
			Immagine1.setBounds(0, 34, 327, 215);
			panel.add(Immagine1);
			
			JLabel Immagine2 = new JLabel();
			Immagine2.setIcon(image2);
			Immagine2.setBounds(225, 0, 327, 215);
			panel.add(Immagine2);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.WHITE);
			panel_1.setLayout(null);
			panel_1.setBounds(384, 502, 177, 117);
			contentPane.add(panel_1);
			
			JLabel PrezziLabel = new JLabel();
			PrezziLabel.setHorizontalAlignment(SwingConstants.CENTER);
			PrezziLabel.setText("I costi sono:");
			PrezziLabel.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
			PrezziLabel.setBounds(10, 11, 157, 17);
			panel_1.add(PrezziLabel);
			
			
			JLabel Costi = new JLabel("<html>" +livello1+":"+"<br>"+ "€ " +COSTO1 +"<br>"+livello2+":"+"<br>" + "€ " +COSTO2 +"<html>");
			Costi.setHorizontalAlignment(SwingConstants.CENTER);
			Costi.setBounds(10, 27, 157, 87);
			panel_1.add(Costi);
			
			btnVuoiSaperneDi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				
				{
					int[] IDS = new int[2];
					IDS[0]=ID1;
					IDS[1]=ID2;
					
					TestimonianzaDAO testimonianze = new TestimonianzaDAO();
					int[] lunghezza1 = new int[3];
					lunghezza1[0] = 0;
					lunghezza1[1] = 0;
					for(int t =0;t<IDS.length; t++)
					{
						int idDisc = IDS[t];
						lunghezza1[t] = testimonianze.getTestimonianze(idDisc).size();
					
					}
					if(lunghezza1[0] == 0 && lunghezza1[1] == 0)
					{			
						
						JFrame nessunatestimonianza = new JFrame();
						JOptionPane.showMessageDialog(nessunatestimonianza,"NON E' PRESENTE ANCORA ALCUNA TESTIMONIANZA PER QUESTA DISCIPLINA");		
						
					}
					
					else
					{
						ConsultaTestimonianzeDisciplinaGUI testimonianza = new ConsultaTestimonianzeDisciplinaGUI(IDS);
					
						testimonianza.setVisible(true);
					}
				}
			});
			
		}
		
		//SE LA DISCIPLINA HA TRE LIVELLI SI APRE QUESTA VIEW
		
		if(ricavadiscipline.getIdDiscipline(disciplina).size() == 3)
		{
			setTitle("ConsultaDisciplinaUtenteGenerico");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(400, 15, 598, 756);
			contentPane = new JPanel();
			contentPane.setBackground(Color.WHITE);
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			//RICAVO LE INFORMAZIONI PER POPOLARE LA VIEW
			
			//Ricavo livelli
			
			
			DisciplinaDAO livelli = new DisciplinaDAO();
			
			String livello1 = livelli.getLivelloDisciplina(disciplina).get(0)[0].toString();
			String livello2 = livelli.getLivelloDisciplina(disciplina).get(1)[0].toString();
			String livello3 = livelli.getLivelloDisciplina(disciplina).get(2)[0].toString();
			System.out.println("Livello1: " + livello1 + "Livello2: " +  livello2 + "Livello3: " + livello3);
			
			
			//PRIMO LIVELLO
			
			//Dal nome e dal livello ricavo i dati e li salvo nelle variabili;
			
			DisciplinaDAO letturaid = new DisciplinaDAO ();
			
			int ID1 = letturaid.getIdDisciplina(disciplina, livello1);
			
			 DisciplinaDAO letturadatidiscipline = new  DisciplinaDAO();
			
			String NOMEDISCIPLINA1 = new String();
			
			NOMEDISCIPLINA1 = letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[1];//1
			
			String LIVELLO1 = new String();
			
			LIVELLO1 = letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[2];//2
			
			String DESCRIZIONE1 = new String();
			DESCRIZIONE1 = letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[3];//3
			
			String PERCORSOFILE1 = new String();
			DirectoryCorrente percorsoProgramma = new DirectoryCorrente();
			String DirectoryProgramma = percorsoProgramma.getDir().replace("\\", "/");
			PERCORSOFILE1 = DirectoryProgramma+"/img/" + letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[4];//4
			
			String COSTO1 = letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[5];//5
			
			int COD_ISTRUTTORE1 = Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[6]);//6
			
		    UtenteRegistratoDAO ricavaistruttore1 = new UtenteRegistratoDAO();
			
			String NOMEISTRUTTORE1 = ricavaistruttore1.getNomeUtente(COD_ISTRUTTORE1).get(0)[0] + " " + ricavaistruttore1.getNomeUtente(COD_ISTRUTTORE1).get(0)[1];
			
			int COD_RESPONSABILE1= Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID1).get(0)[7]);//7
			
			UtenteRegistratoDAO ricavaResponsabile1 = new UtenteRegistratoDAO();
			
			String NOMERESPONSABILE1 = ricavaResponsabile1.getNomeUtente(COD_RESPONSABILE1).get(0)[0] + " " + ricavaResponsabile1.getNomeUtente(COD_RESPONSABILE1).get(0)[1];
			
			
			ImageIcon image1 = new ImageIcon(PERCORSOFILE1);
			
			//ADATTO FORMATO IMMAGINE
			
			Image IMAGE1 = image1.getImage();
			IMAGE1 = IMAGE1.getScaledInstance(263,191, IMAGE1.SCALE_REPLICATE);
			image1.setImage(IMAGE1);
			
			
			//Secondo livello
			
			//dal nome e dal livello ricavo i dati e li salvo nelle variabili;
			
			int ID2 = letturaid.getIdDisciplina(disciplina, livello2);

			String NOMEDISCIPLINA2 = new String();
			
			NOMEDISCIPLINA2 = letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[1];//1
			
			String LIVELLO2 = new String();
			
			LIVELLO2 = letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[2];//2
			
			String DESCRIZIONE2 = new String();
			
			DESCRIZIONE2 = letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[3];//3
			
			String PERCORSOFILE2 = new String();
			
			PERCORSOFILE2 = DirectoryProgramma+"/img/" + letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[4];//4
			
			String COSTO2 = letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[5];//5
			
			int COD_ISTRUTTORE2 = Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[6]);//6
			
			UtenteRegistratoDAO ricavaistruttore2 = new UtenteRegistratoDAO();
			
			String NOMEISTRUTTORE2 = ricavaistruttore2.getNomeUtente(COD_ISTRUTTORE2).get(0)[0] + " " + ricavaistruttore2.getNomeUtente(COD_ISTRUTTORE2).get(0)[1];
			
			int COD_RESPONSABILE2= Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID2).get(0)[7]);//7
			
			UtenteRegistratoDAO ricavaResponsabile2 = new UtenteRegistratoDAO();
			
			String NOMERESPONSABILE2 = ricavaResponsabile2.getNomeUtente(COD_RESPONSABILE2).get(0)[0] + " " + ricavaResponsabile2.getNomeUtente(COD_RESPONSABILE2).get(0)[1];
			
			
			ImageIcon image2 = new ImageIcon(PERCORSOFILE2);
			
			//ADATTO FORMATO IMMAGINE
			
			Image IMAGE2 = image2.getImage();
			IMAGE2 = IMAGE2.getScaledInstance(263,191, IMAGE2.SCALE_REPLICATE);
			image2.setImage(IMAGE2);
			
			
			//TERZO LIVELLO
		
			
			//dal nome e dal livello ricavo i dati e li salvo nelle variabili;
			
			int ID3 = letturaid.getIdDisciplina(disciplina, livello3);

			String NOMEDISCIPLINA3 = new String();
			
			NOMEDISCIPLINA3 = letturadatidiscipline.getDatiDisciplinaFromId(ID3).get(0)[1];//1
			
			String LIVELLO3 = new String();
			
			LIVELLO3 = letturadatidiscipline.getDatiDisciplinaFromId(ID3).get(0)[2];//2
			
			String DESCRIZIONE3 = new String();
			
			DESCRIZIONE3 = letturadatidiscipline.getDatiDisciplinaFromId(ID3).get(0)[3];//3
			
			String PERCORSOFILE3 = new String();
			
			PERCORSOFILE3 = DirectoryProgramma +"/img/" + letturadatidiscipline.getDatiDisciplinaFromId(ID3).get(0)[4];//4
			
			
			String COSTO3 = letturadatidiscipline.getDatiDisciplinaFromId(ID3).get(0)[5];//5
			
			int COD_ISTRUTTORE3 = Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID3).get(0)[6]);//6
			
		    UtenteRegistratoDAO ricavaistruttore3 = new UtenteRegistratoDAO();
			
			String NOMEISTRUTTORE3 = ricavaistruttore3.getNomeUtente(COD_ISTRUTTORE3).get(0)[0] + " " + ricavaistruttore3.getNomeUtente(COD_ISTRUTTORE3).get(0)[1];
			
			int COD_RESPONSABILE3= Integer.parseInt(letturadatidiscipline.getDatiDisciplinaFromId(ID3).get(0)[7]);//7	
			
			UtenteRegistratoDAO ricavaResponsabile3 = new UtenteRegistratoDAO();
			
			String NOMERESPONSABILE3 = ricavaResponsabile3.getNomeUtente(COD_RESPONSABILE3).get(0)[0] + " " + ricavaResponsabile3.getNomeUtente(COD_RESPONSABILE3).get(0)[1];
			
			
			ImageIcon image3 = new ImageIcon(PERCORSOFILE3);
			
			//ADATTO FORMATO IMMAGINE
			
			Image IMAGE3 = image3.getImage();
			IMAGE3 = IMAGE3.getScaledInstance(263,191, IMAGE3.SCALE_REPLICATE);
			image2.setImage(IMAGE3);
			
			
			JLabel Livello1 = new JLabel("Livello "+ livello1);
			Livello1.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			Livello1.setBounds(10, 309, 305, 14);
			contentPane.add(Livello1);
			
			String descrizione2 = new String();
			String descrizione1 = new String();
			String descrizione3 = new String();
			
			descrizione2= DESCRIZIONE2.replace(".", "<br>");
			descrizione1 = DESCRIZIONE1.replace(".", "<br>");
			descrizione3 = DESCRIZIONE3.replace(".", "<br>");
			
			
			JLabel Descrizione1 = new JLabel("<html>" + descrizione1 + "<html>");
			Descrizione1.setVerticalAlignment(SwingConstants.TOP);
			Descrizione1.setHorizontalAlignment(SwingConstants.LEFT);
			Descrizione1.setToolTipText("");
			Descrizione1.setBounds(10, 323, 614, 45);
			contentPane.add(Descrizione1);
			
			JLabel Livello2 = new JLabel("Livello" + livello2);
			Livello2.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			Livello2.setBounds(10, 376, 305, 14);
			contentPane.add(Livello2);
			
			JLabel Descrizione2 = new JLabel("<html>" + descrizione2 + "<html>");
			Descrizione2.setVerticalAlignment(SwingConstants.TOP);
			Descrizione2.setBounds(10, 401, 614, 45);
			contentPane.add(Descrizione2);
			
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 11, 562, 287);
			contentPane.add(panel);
			panel.setLayout(null);
			
			
			JLabel lblNewLabel_3 = new JLabel(NOMEDISCIPLINA1);
			lblNewLabel_3.setBounds(0, 239, 554, 48);
			panel.add(lblNewLabel_3);
			lblNewLabel_3.setForeground(Color.YELLOW);
			lblNewLabel_3.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 56));
			
			JLabel Immagine1 = new JLabel();
			Immagine1.setIcon(image1);
			Immagine1.setBounds(0, 96, 263, 191);
			panel.add(Immagine1);
			
			JLabel Immagine2 = new JLabel();
			Immagine2.setIcon(image2);
			Immagine2.setBounds(143, 49, 263, 191);
			panel.add(Immagine2);
			
			JLabel Immagine3 = new JLabel();
			Immagine3.setIcon(image3);
			Immagine3.setBounds(299, 0, 263, 191);
			panel.add(Immagine3);
			
			JLabel Livello3 = new JLabel("Livello " + livello3);
			Livello3.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 12));
			Livello3.setBounds(10, 457, 305, 14);
			contentPane.add(Livello3);
			
			JLabel Descrizione3 = new JLabel("<html>" + descrizione3 + "<html>");
			Descrizione3.setVerticalAlignment(SwingConstants.TOP);
			Descrizione3.setBounds(10, 471, 572, 45);
			contentPane.add(Descrizione3);
			
			
			//Se l'istruttore è sempre lo stesso
			if(COD_ISTRUTTORE1 == COD_ISTRUTTORE2 && COD_ISTRUTTORE1 == COD_ISTRUTTORE3)
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(Color.WHITE);
				panel_1.setLayout(null);
				panel_1.setBounds(10, 527, 177, 93);
				contentPane.add(panel_1);
			
				JLabel Istruttori = new JLabel("L' istruttore del corso è : ");
				Istruttori.setVerticalAlignment(SwingConstants.TOP);
				Istruttori.setHorizontalAlignment(SwingConstants.CENTER);
				Istruttori.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
				Istruttori.setBounds(10, 11, 163, 14);
				panel_1.add(Istruttori);
			
				JLabel listaIstruttori = new JLabel(NOMEISTRUTTORE1);
				listaIstruttori.setVerticalAlignment(SwingConstants.TOP);
				listaIstruttori.setBounds(10, 36, 157, 114);
				panel_1.add(listaIstruttori);
				
			}
			
			else
			{	
				//se due sono uguali e uno diverso
				if(COD_ISTRUTTORE1 == COD_ISTRUTTORE2 && COD_ISTRUTTORE1 != COD_ISTRUTTORE3)//se ci sono due istruttori per tre livelli
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(Color.WHITE);
					panel_1.setLayout(null);
					panel_1.setBounds(10, 527, 177, 161);
					contentPane.add(panel_1);
				
					JLabel Istruttori = new JLabel("Gli istruttori del corso sono : ");
					Istruttori.setVerticalAlignment(SwingConstants.TOP);
					Istruttori.setHorizontalAlignment(SwingConstants.CENTER);
					Istruttori.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
					Istruttori.setBounds(10, 11, 163, 14);
					panel_1.add(Istruttori);
				
					JLabel listaIstruttori = new JLabel("<html>" + livello1 +" e " + livello2 +":"+ "<br>"+ NOMEISTRUTTORE1 +"<br>"+livello3 +":"+"<br>" +NOMEISTRUTTORE3 +"<html>");
					listaIstruttori.setVerticalAlignment(SwingConstants.TOP);
					listaIstruttori.setBounds(10, 36, 157, 114);
					panel_1.add(listaIstruttori);
					
				}
				if(COD_ISTRUTTORE2 == COD_ISTRUTTORE3 && COD_ISTRUTTORE2 != COD_ISTRUTTORE1)//se ci sono due istruttori per tre livelli
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(Color.WHITE);
					panel_1.setLayout(null);
					panel_1.setBounds(10, 527, 177, 161);
					contentPane.add(panel_1);
				
					JLabel Istruttori = new JLabel("Gli istruttori del corso sono : ");
					Istruttori.setVerticalAlignment(SwingConstants.TOP);
					Istruttori.setHorizontalAlignment(SwingConstants.CENTER);
					Istruttori.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
					Istruttori.setBounds(10, 11, 163, 14);
					panel_1.add(Istruttori);
				
					JLabel listaIstruttori = new JLabel("<html>" + livello2 +" e " + livello3 +":"+ "<br>"+ NOMEISTRUTTORE2 +"<br>"+livello1 +":"+"<br>" +NOMEISTRUTTORE1 +"<html>");
					listaIstruttori.setVerticalAlignment(SwingConstants.TOP);
					listaIstruttori.setBounds(10, 36, 157, 114);
					panel_1.add(listaIstruttori);
					
				}
				if(COD_ISTRUTTORE1 == COD_ISTRUTTORE3 && COD_ISTRUTTORE1 != COD_ISTRUTTORE2)//se ci sono due istruttori per tre livelli
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(Color.WHITE);
					panel_1.setLayout(null);
					panel_1.setBounds(10, 527, 177, 161);
					contentPane.add(panel_1);
				
					JLabel Istruttori = new JLabel("Gli istruttori del corso sono : ");
					Istruttori.setVerticalAlignment(SwingConstants.TOP);
					Istruttori.setHorizontalAlignment(SwingConstants.CENTER);
					Istruttori.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
					Istruttori.setBounds(10, 11, 163, 14);
					panel_1.add(Istruttori);
				
					JLabel listaIstruttori = new JLabel("<html>" + livello1 +" e " + livello3 +":"+ "<br>"+ NOMEISTRUTTORE1 +"<br>"+livello2 +":"+"<br>" +NOMEISTRUTTORE2 +"<html>");
					listaIstruttori.setVerticalAlignment(SwingConstants.TOP);
					listaIstruttori.setBounds(10, 36, 157, 114);
					panel_1.add(listaIstruttori);
					
				}
				else //TUTTI DIVERSI
				{
					JPanel panel_1 = new JPanel();
					panel_1.setBackground(Color.WHITE);
					panel_1.setLayout(null);
					panel_1.setBounds(10, 527, 177, 161);
					contentPane.add(panel_1);
			
					JLabel Istruttori = new JLabel("Gli istruttori del corso sono : ");
					Istruttori.setVerticalAlignment(SwingConstants.TOP);
					Istruttori.setHorizontalAlignment(SwingConstants.CENTER);
					Istruttori.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
					Istruttori.setBounds(10, 11, 163, 14);
					panel_1.add(Istruttori);
					
					JLabel listaIstruttori = new JLabel("<html>" + livello1 +":"+"<br>"+ NOMEISTRUTTORE1 +"<br>"+livello2 +":"+"<br>"+ NOMEISTRUTTORE2 +"<br>" +livello3 +":"+"<br>" +NOMEISTRUTTORE3 +"<html>");
					listaIstruttori.setVerticalAlignment(SwingConstants.TOP);
					listaIstruttori.setBounds(10, 36, 157, 114);
					panel_1.add(listaIstruttori);
				}	
				
			}
				
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setLayout(null);
			panel_2.setBounds(194, 527, 177, 114);
			contentPane.add(panel_2);
			
			JLabel lblIlResponsabile = new JLabel("Il responsabile \u00E8:");
			lblIlResponsabile.setHorizontalAlignment(SwingConstants.CENTER);
			lblIlResponsabile.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
			lblIlResponsabile.setBounds(10, 11, 163, 14);
			panel_2.add(lblIlResponsabile);
			
			JLabel NomeResponsabile = new JLabel(NOMERESPONSABILE1);
			NomeResponsabile.setHorizontalAlignment(SwingConstants.CENTER);
			NomeResponsabile.setBounds(10, 36, 157, 67);
			panel_2.add(NomeResponsabile);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.setLayout(null);
			panel_3.setBounds(383, 527, 177, 125);
			contentPane.add(panel_3);
			
			JLabel lblICostiSono = new JLabel("I costi sono :  ");
			lblICostiSono.setHorizontalAlignment(SwingConstants.CENTER);
			lblICostiSono.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 14));
			lblICostiSono.setBounds(10, 11, 163, 14);
			panel_3.add(lblICostiSono);
			
			JLabel listaCosti = new JLabel("<html>" +livello1+":"+"<br>"+ "€ " +COSTO1 +"<br>"+livello2 +":"+"<br>" + "€ " +COSTO2 + "<br>" +livello3 +":"+"<br>" + "€ " +COSTO3 +"<html>");
			listaCosti.setVerticalAlignment(SwingConstants.TOP);
			listaCosti.setHorizontalAlignment(SwingConstants.CENTER);
			listaCosti.setBounds(10, 30, 157, 95);
			panel_3.add(listaCosti);
			
			JButton btnVuoiSaperneDi = new JButton("VUOI SAPERNE DI PIU'? CONSULTA LE TESTIMONIANZE DEI NOSTRI TESSERATI");
			btnVuoiSaperneDi.setBounds(22, 664, 538, 37);
			contentPane.add(btnVuoiSaperneDi);
			
			
			
			btnVuoiSaperneDi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0)
				
				{
					int[] IDS = new int[3];
					IDS[0]=ID1;
					IDS[1]=ID2;
					IDS[2] = ID3;
					
					TestimonianzaDAO testimonianze = new TestimonianzaDAO();
					int[] lunghezza1 = new int[3];
					lunghezza1[0] = 0;
					lunghezza1[1] = 0;
					lunghezza1[2] = 0;
					for(int t =0;t<IDS.length; t++)
					{
						int idDisc = IDS[t];
						lunghezza1[t] = testimonianze.getTestimonianze(idDisc).size();
					
					}
					if(lunghezza1[0] == 0 && lunghezza1[1] == 0)
					{			
						
						JFrame nessunatestimonianza = new JFrame();
						JOptionPane.showMessageDialog(nessunatestimonianza,"NON E' PRESENTE ANCORA ALCUNA TESTIMONIANZA PER QUESTA DISCIPLINA");		
						
					}
					else
					{
						ConsultaTestimonianzeDisciplinaGUI testimonianza = new ConsultaTestimonianzeDisciplinaGUI(IDS);
					
						testimonianza.setVisible(true);
					}
				}
					
				
			});
			
		}
		
	}
}
