package gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import DAO.DisciplinaDAO;
import DAO.TestimonianzaDAO;
import DAO.UtenteRegistratoDAO;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class ConsultaTestimonianzeDisciplinaGUI extends JFrame {

	public String percorso;
	public String path;
	private JPanel contentPane;
    public JFrame finestra = this;
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaTestimonianzeDisciplinaGUI frame = new ConsultaTestimonianzeDisciplinaGUI();
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
	public ConsultaTestimonianzeDisciplinaGUI(int[] idDiscS)  {
	    TestimonianzaDAO testimonianze = new TestimonianzaDAO(); 
		
		LoginGUI login = new LoginGUI();
		percorso = login.DirectoryProgramma;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(50, 50, 1300, 546);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		
		//PANNELLO TESTIMONIANZA
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(0, 0, 864, 47);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);
	
		
	
		JLabel lblTestimonianze = new JLabel("TESTIMONIANZE:  " ); //+ NOMEDISCIPLINA +" " + LIVELLO);
		lblTestimonianze.setBounds(473, 11, 343, 32);
		lblTestimonianze.setFont(new Font("Franklin Gothic Demi Cond", Font.PLAIN, 16));
		lblTestimonianze.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblTestimonianze);
		
		
		//PANNELLO DI SCROLL
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 86, 600, 420);
		panel_1.setLayout(new GridLayout(0,1));
		
		JScrollPane scroll = new JScrollPane(panel_1);
		scroll.setBounds(10, 47, 1260, 400);
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(136, 503, 864, 47);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnChiudi = new JButton("CHIUDI");
		
		btnChiudi.setBounds(449, 459, 374, 37);
		panel_2.add(btnChiudi);
		
		//LetturaTestimonianze testimonianze = new LetturaTestimonianze();
		
		//Vector<String[]> Testimonianze = testimonianze.getTestimonianze(idDisc);
		
		int lung = idDiscS.length;
		
		System.out.println("la disciplina ha " + lung + " discipline");
		
		for(int t =0;t<idDiscS.length; t++)
		{
			int idDisc = idDiscS[t];
		 
		//JLabel articoli[] = new JLabel[30];
		JPanel[] pannelli_1 = new JPanel[testimonianze.getTestimonianze(idDisc).size()]; 
		//int u = 0;
		int lunghezza = testimonianze.getTestimonianze(idDisc).size();
		
		System.out.println("la lunghezza  è " + lunghezza);
		
		
		for(int i=0; i<testimonianze.getTestimonianze(idDisc).size(); i++)
		{
			int IDTESSERATO = Integer.parseInt(testimonianze.getTestimonianze(idDisc).get(i)[1]);
			
			
		    UtenteRegistratoDAO nome = new UtenteRegistratoDAO();
			
			String NOME = nome.getNomeUtente(IDTESSERATO).get(0)[0];
			String COGNOME=	nome.getNomeUtente(IDTESSERATO).get(0)[1];
			
			DisciplinaDAO disciplina = new 	DisciplinaDAO ();
			String NOMEDISCIPLINA = disciplina.getNomeDisciplina(idDisc).get(0)[0];
		    DisciplinaDAO livello = new DisciplinaDAO();
			String LIVELLO = livello.getLivelloDisciplina(idDisc).get(0)[0];
			
			String TESTIMONIANZA = testimonianze.getTestimonianze(idDisc).get(i)[3].toString();
			
			int VOTO = Integer.parseInt(testimonianze.getTestimonianze(idDisc).get(i)[4]);
			
			if(VOTO == 1) 
			{
				path = percorso + "/img/voti/1.jpg";
			}
			if(VOTO == 2) 
			{
				path = percorso + "/img/voti/2.jpg";
			}
			if(VOTO == 3) 
			{
				path = percorso + "/img/voti/3.jpg"; 
			}
			if(VOTO == 4) 
			{
				path = percorso + "/img/voti/4.png";
			}
			if(VOTO == 5) 
			{
				path = percorso + "/img/voti/5.jpg";
			}
			
			pannelli_1[i]= new JPanel();
			pannelli_1[i].setBackground(Color.WHITE);
			pannelli_1[i].setLayout(new GridBagLayout());
			pannelli_1[i].setBounds(10, 38 , 100, 100);

			
			JLabel lblImmagine = new JLabel();
			
		
			
			
			JLabel lblNome = new JLabel(NOME + "  " + COGNOME + "                               ");
			lblNome.setVerticalAlignment(SwingConstants.CENTER);
			lblNome.setHorizontalAlignment(SwingConstants.CENTER);
			lblNome.setBounds(117, 150, 239, 22);
			pannelli_1[i].add(lblNome);
			
			String testimonianza1 = TESTIMONIANZA.replaceAll("\r\n", "<br>");
			
			JLabel lblTestimonianza = new JLabel("<html>"+testimonianza1+"<html>");
			lblTestimonianza.setVerticalAlignment(SwingConstants.CENTER);
			lblTestimonianza.setHorizontalAlignment(SwingConstants.LEFT);
			lblTestimonianza.setBounds(117, 33, 614, 129);
			pannelli_1[i].add(lblTestimonianza);
			
			
			JLabel spazio = new JLabel("            ");
			pannelli_1[i].add(spazio);
			
			//CONVERTO
			ImageIcon image = new ImageIcon(path);
			Image IMAGE = image.getImage();
			IMAGE = IMAGE.getScaledInstance( 93, 88, IMAGE.SCALE_REPLICATE);
			image.setImage(IMAGE);
			lblImmagine.setIcon(image);
			lblImmagine.setVerticalAlignment(SwingConstants.CENTER);
			lblImmagine.setHorizontalAlignment(SwingConstants.CENTER);
			lblImmagine.setBounds(0, 0, 57, 28);
			pannelli_1[i].add(lblImmagine);
		 
			JLabel lblLdisciplinaELivello = new JLabel("                                   "+NOMEDISCIPLINA+"  "+LIVELLO);
			lblLdisciplinaELivello.setVerticalAlignment(SwingConstants.CENTER);
			lblLdisciplinaELivello.setHorizontalAlignment(SwingConstants.LEFT);
			lblLdisciplinaELivello.setBounds(366, 0, 310, 22);
			pannelli_1[i].add(lblLdisciplinaELivello);
			
			
			/*//lbl = new JLabel("Prodotto n. " + i);
			pannelli[i] = new JPanel();
			pannelli[i].setBounds(10, 10+u, 100, 100);
			
			articoli[i] = new JLabel("CIAO");
			articoli[i].setBounds(10, 10, 30, 40);
			
			//p.add(lbl);
			pannelli[i].add(articoli[i]);
			panel_1.add(pannelli[i]);
			*/
			
			
			panel_1.add(pannelli_1[i]);
			
			//u= u+100;
			/*JScrollPane scroll1 = new JScrollPane(pannelli_1[i]);
			
			scroll1.setBounds(10, 47, 852, 446);
			scroll1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
			scroll1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
			panel_1.add(scroll1);
			
			*/
			
		}
		
		
		}
		
		btnChiudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				
				finestra.dispose();
				
			}
		});
		
		
		
		
		
		
	
		
	}
}

		