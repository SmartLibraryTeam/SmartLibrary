package DAO;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DbConnection.DbConnection;

public class UtenteRegistratoDAO 
{
   
	    
	    //PARAMETRI 

        public Vector<String[]> u ;
        
		public int id ;
		int idNew;
		
		
		
		
		//METODI
		
		 
		//METODI UTILIZZATI PER RICAVARE DATI RELATIVI AGLI UTENTI REGISTRATI
		
		
		//Prende l'id dell'utente e restituisce il suo nome e il suo cognome
		
		public Vector<String[]> getNomeUtente (int id)
	
		{
			
		    String query =  "SELECT Nome, Cognome FROM `utente_registrato` WHERE idUtente_Registrato LIKE '" +id+ "'";
		    u = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();// disconnessione.
			
			return  u;
						
	
		}
		
		
	
		//Prende il nome e il cognome dell'utente e restituisce il suo id
		
		public int getIdFromNomeCognome(String nome, String cognome)
		
		{
			
			String query = "SELECT idUtente_Registrato FROM `utente_registrato` WHERE Nome='"+nome+"' AND Cognome='"+cognome+"'";
			id = Integer.parseInt(DbConnection.getInstance().eseguiQuery(query).get(0)[0]);
			DbConnection.disconnetti();// disconnessione.
			
			return id;
		
		
		}
		
		
		
		//Metodo utilizzato in fase di login per determinare il ruolo dell'utente e aprire di conseguenza la HomeTesserato, la HomeIstruttore o la HomeResponsabile
		
		public Vector<String[]> getRuoloUtente(int id) 
		
		{ 
			
			String query = "SELECT Ruolo FROM `utente_registrato` WHERE idUtente_Registrato="+ id+"";;
	        u = DbConnection.getInstance().eseguiQuery(query);
	        DbConnection.disconnetti();// disconnessione.
		
		     
	        return u;
	        
	        
		}
		

		
		
		
		
		
		
		//METODO UTILIZZATO PER AGGIUNGERE UN NUOVO TESSERATO AL DATABASE 
		
		
		public void aggiuntautenteregistrato(String nome,String cognome ,String password,int età,String ruolo , String telefono, JFrame finestra)
		
		{

	        //POPOLA DB CON IL NUOVO UTENTE
			
	        
			String query = "INSERT INTO `utente_registrato` (`Nome`, `Cognome`, `password`, `Ruolo`, `Età`, `Telefono`) VALUES ('"+nome+"', '"+cognome+"', '"+password+"', '"+ruolo+"', '"+età+"', '"+telefono+"')";
			
	        DbConnection.getInstance().eseguiAggiornamento(query);

	        DbConnection.disconnetti();
			
		
		}
		
		
		
		
		
		
		//METODI UTILIZZATI PER VERIFICARE L'EVENTUALE PRESENZA NEL DB DI UN DATO UTENTE
		
		
		//Metodo utilizzato in fase di login per verificare se l'utente è registrato e quindi può effettuare l'accesso
		
		public boolean cercautente(int id, String password) 
		
		{
	 
			
                    String query = "SELECT * FROM `utente_registrato` WHERE `idUtente_Registrato` ="+ id +" AND `password` LIKE '"+ password +"'";
					
					if(DbConnection.getInstance().eseguiQuery(query).size() != 0)
					{
						return true;
					}
					else
					{
						return false;
					}
			
			
		}
		
		
		
		/*Metodo utilizzato in fase di registrazione per verificare l'eventuale esistenza di un'altro utente con lo stesso nome, 
		lo stesso cognome e lo stesso numero di telefono*/
		
		public boolean controlloutente (String nome, String cognome , String telefono) 
		
		{
			
			
			    String query = "SELECT * FROM `utente_registrato` WHERE `Nome` LIKE '"+ nome +"' AND `Cognome` LIKE '"+ cognome +"' AND `Telefono` LIKE '"+ telefono+"'";
				
				if(DbConnection.getInstance().eseguiQuery(query).size() != 0)
				{
					return true;
				}
				else
				{
					return false;
				}
		
		
		}
		
	
		
		
}

