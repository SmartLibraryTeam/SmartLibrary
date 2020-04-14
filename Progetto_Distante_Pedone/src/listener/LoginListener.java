package listener;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.UtenteRegistratoDAO;

import gui.LoginGUI;
import gui.HomeTesseratoGUI;
import gui.HomeIstruttoreGUI;
import gui.HomeResponsabileCentroGUI;


public class LoginListener implements ActionListener
{
	//PARAMETRI 
	private LoginGUI loginWindow;
	public LoginListener questolistener;
	public int id;
	
	
	//COSTRUTTORE
	public LoginListener(LoginGUI loginFrame) 
	{
		super();
		this.loginWindow = loginFrame;

	}
	
	//IMPLEMENTAZIONE VERIFICA UTENTE
	@SuppressWarnings("deprecation")
	public void actionPerformed( ActionEvent e)
	{
		
		
		id= Integer.parseInt(loginWindow.textField.getText());
		
		String password = loginWindow.passwordField.getText();
		
		
		//VERIFICA UTENTE
		
	
		UtenteRegistratoDAO verificautente = new UtenteRegistratoDAO();
		
		if(verificautente.cercautente(id,password))
		{
			
			
			//ACCEDI AL SISTEMA L'utente è registrato
			
		    UtenteRegistratoDAO ruoloutente = new UtenteRegistratoDAO();
			
			//Se si tratta di un tesserato, apri la finestra HomeTesserato
			if("Tesserato".equals(ruoloutente.getRuoloUtente(id).get(0)[0])) 
			{
				
				    HomeTesseratoGUI hometesserato = new HomeTesseratoGUI(id);
				    hometesserato.setVisible(true);
			}	
			//Se si tratta di un istruttore, apri la finestra HomeIstruttore
			if("Istruttore".equals(ruoloutente.getRuoloUtente(id).get(0)[0])) 
			{
					HomeIstruttoreGUI homeistruttore = new HomeIstruttoreGUI(id);
					homeistruttore.setVisible(true);
					
			}
			//Se si tratta di un responsabile, apri la finestra HomeResponsabileCentro
			if("Responsabile".equals(ruoloutente.getRuoloUtente(id).get(0)[0]))
			{
			        HomeResponsabileCentroGUI homeresponsabile = new HomeResponsabileCentroGUI(id);
					homeresponsabile.setVisible(true);
					
					
			}
			
			
			


		}
		else
		{	
			
			//SE L'UTENTE HA SBAGLIATO PASS APRI UNA FINESTRA DI ERRORE
			JFrame accessonegato = new JFrame();
			JOptionPane.showMessageDialog(accessonegato,"I DATI CHE HAI INSERITO NON SONO VALIDI!");
			
			
		}
		
		
	}
	
	

}
