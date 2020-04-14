package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.RegistrazioneGUI;

import DAO.UtenteRegistratoDAO;



public class RegistrazioneUtenteListener implements ActionListener
{
		//PARAMETRI 
		private RegistrazioneGUI registrazioneWindow;
		
		
		
		//COSTRUTTORE
		public RegistrazioneUtenteListener(RegistrazioneGUI registrazioneFrame) 
		{
			super();
			this.registrazioneWindow = registrazioneFrame;
		}
		
		//IMPLEMENTAZIONE VERIFICA UTENTE
	
		
		public void actionPerformed( ActionEvent e)
		{
			
			String nome = registrazioneWindow.textField.getText();
			
			@SuppressWarnings("deprecation")
			String password =  registrazioneWindow.passwordField.getText();
			
			String cognome = registrazioneWindow.textField_2.getText();
			
			int età = Integer.parseInt(registrazioneWindow.textField_1.getText());
			
			@SuppressWarnings("deprecation")
			String confermapassword = registrazioneWindow.passwordField_1.getText();
			
			String telefono = registrazioneWindow.textField_3.getText();
			
			String ruolo = "Tesserato";
			
			JFrame finestra = registrazioneWindow.finestra;
			
			
			
			//VERIFICA COINCIDENZA PASSWORD
			
			System.out.println(password);

			System.out.println(confermapassword);
			
		   
	        
			if(password.equals(confermapassword))
			{	
				//VERIFICA CHE I DATI INSERITI NON SI RIFERISCANO AD UN UTENTE GIA REGISTRATO
				
				UtenteRegistratoDAO verificautentenelDB = new UtenteRegistratoDAO();
				
				if(verificautentenelDB.controlloutente(nome, cognome, telefono))
				{
					JFrame accessonegato = new JFrame();
					JOptionPane.showMessageDialog(accessonegato,"UTENTE GIA' REGISTRATO");
					
				}
				else
				{
			        
					
			        //CREAZIONE NUOVO UTENTE 
			        
			        UtenteRegistratoDAO aggiuntanuovoutente = new UtenteRegistratoDAO();
			        aggiuntanuovoutente.aggiuntautenteregistrato(nome, cognome, password, età, ruolo , telefono, finestra);
			        
			        //MESSAGGIO DI BENVENUTO
			        
			        UtenteRegistratoDAO ricavaid = new UtenteRegistratoDAO();
			        
			        int idUtente = ricavaid.getIdFromNomeCognome(nome, cognome);
			    	
			        JFrame utenteaggiunto = new JFrame();
			        
			        JOptionPane.showMessageDialog(utenteaggiunto,"BENVENUTO!"+ " " + "IL TUO ID E':" + "  " + idUtente);
					
					finestra.dispose();

			        
				}
			}
			else
			{
				JFrame accessonegato = new JFrame();
				JOptionPane.showMessageDialog(accessonegato,"LA PASSWORD INSERITA NON COINCIDE CON QUELLA CONFERMATA");
				
			}
			
			
	      }	
			
			
			
}
