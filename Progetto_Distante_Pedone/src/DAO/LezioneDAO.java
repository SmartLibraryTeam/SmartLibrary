package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

import DbConnection.DbConnection;
import modelli.Lezione;

public class LezioneDAO 
{	
	
	 
	 //PARAMETRI 
	
	 public Vector<String[]> id;
	 public Vector<String[]> l;
	 public Vector<String[]> Giorni;
     public Vector<String[]> Ore;
 
     public static ArrayList<Lezione> le = new ArrayList<Lezione>();
		 
	 int id1 ;
	 int idNew;
		
	  
	
	 
	 
	 //METODI
	
	
	
	 //METODI UTILIZZATI PER RICAVARE DATI RELATIVI ALLE LEZIONI
	 
	 //Prende l'id della disciplina a cui appartiene una data lezione e restituisce l'id della lezione stessa
	   
	 public Vector<String[]> getIDLezione(int idDisciplina)
 
     {

         String query = "SELECT idLezione FROM `lezione` WHERE Disciplina_idDisciplina= "+ idDisciplina+"";
         id = DbConnection.getInstance().eseguiQuery(query);
         DbConnection.disconnetti();// disconnessione.

         return  id;
			
     }

    
	 
	 //Prende il giorno e l'ora in cui si svolge una data lezione e restituisce l'id della lezione stessa
	   
	 public Vector<String[]> getIDLezioneGiornoOra(String giorno, String ora)
 
	 {
	
		 String query = "SELECT idLezione FROM `lezione` WHERE Giorno = '"+ giorno +"' AND Ora = '" + ora + "'";
         id = DbConnection.getInstance().eseguiQuery(query);
	     DbConnection.disconnetti();// disconnessione.
	
	     return  id;

	 }

	   
	   
	 //Prende l'id della lezione e restituisce il giorno in cui si svolgerà la lezione (nella quale si terrà un determinato evento)
	   
	 public Vector<String[]> getGiornoEvento (int idLezione)
	   
     {
				
		 String query =  "SELECT Giorno FROM lezione WHERE idLezione LIKE '"+ idLezione+ "'";;
         l = DbConnection.getInstance().eseguiQuery(query);
		 DbConnection.disconnetti();// disconnessione.
				
		 return l;
							
	 }
	 
	 
	   
	 //Prende l'id della lezione e restituisce l'ora in cui si svolgerà la lezione (nella quale si terrà un determinato evento)
	   
	 public Vector<String[]> getOraEvento (int idLezione)
	   
     {
	   	

	       String query =  "SELECT Ora FROM lezione WHERE idLezione LIKE '"+ idLezione+ "'";;
	       l = DbConnection.getInstance().eseguiQuery(query);
	   	   DbConnection.disconnetti();// disconnessione.
	   	
	   	   return  l;
	   				
	   
     }

	   
	   
	 //Prende l'id della lezione e restituisce l'id della disciplina 
	   
	 public Vector<String[]> getIdDisciplinaFromIdLezione (int idLezione)
		
	 {
				
		   
		   String query = "SELECT Disciplina_idDisciplina FROM `lezione` WHERE idLezione LIKE '"+idLezione+"'";
		   l= DbConnection.getInstance().eseguiQuery(query);
           DbConnection.disconnetti();// disconnessione.
				
		   return  l;
				
	 }	
	 
	 
	 
	 //Restituisce tutti i nomi delle aule disponibili
	 
	 public Vector<String[]> getAule()
		
	 {
			
			String query = "SELECT DISTINCT Aula FROM `lezione`";
		    l = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();
			
			return l;
			
			
	 }
		
		 
	 
	 //Prende l'id della lezione e restituisce l'aula in cui si svolgerà la lezione stessa
	 
	 public Vector<String[]> getAula(int idLez)
	
	 {
			
		    System.out.println("Eseguo query");
		    
			String query = "SELECT Aula FROM `lezione` WHERE idLezione="+idLez+"";
            l = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();
			
			return l;
			
			
     }
		
	 
	 
	 
	 
	 
	 
	 //METODO UTILIZZATO PER AGGIUNGERE UNA NUOVA LEZIONE AL DATABASE 
	  
	  
	 //Aggiunge una nuova lezione al database
	 
	 public void setLezione(String disciplina, String livello, String giorno ,String ora,String aula)
		
	 {
			
		   DisciplinaDAO idDisc = new  DisciplinaDAO();
		   
		   String query = "INSERT INTO `lezione` (`Giorno`, `Disciplina_idDisciplina`, `Ora`, `Aula`) VALUES ('"+ giorno +"', '"+ idDisc.getIdDisciplina(disciplina, livello) +"', '"+ ora +"', '"+aula+"');";
		   DbConnection.getInstance().eseguiAggiornamento(query);
		   DbConnection.disconnetti();
			
	 }
	 
	 
	 
	 
	 
	 
	 //METODO UTILIZZATO PER VERIFICARE L'EVENTUALE PRESENZA DI UN'ALTRA LEZIONE DELLA STESSA DISCIPLINA E DELLO STESSO LIVELLO NELLO STESSO GIORNO
	  
	 //Prende l'id della disciplina e il giorno e restituisce i dati delle lezioni della relativa disciplina nel giorno dato
	 
	 public boolean verificaGiornoLezione( String giorno,int idDisc)
		
	 {
			
		    String query = "SELECT * FROM `lezione` WHERE `Giorno` LIKE '"+giorno+"' AND `Disciplina_idDisciplina` = "+idDisc+" ORDER BY `Disciplina_idDisciplina` ASC";
			
			if(DbConnection.getInstance().eseguiQuery(query).size()>0)
			{
				return true;
			}
			else
			{
				return false;
			}
			
			
		
	 }
	 
	 
	 
	 
	 
	 
	 
	 //METODI CHE RESTITUISCONO ARRAYLIST DI LEZIONI
	 
	 
	 //Prende l'id della disciplina e restituisce un arraylist di lezioni, ciascuna delle quali è formata dal giorno e dall'ora in cui si svolge la lezione stessa
	 
	 public ArrayList<Lezione> getLezioni(int idDisciplina)
		
	 {
	     
	   
	    //RICAVO GIORNI DAL DB
	    
	    String query1 = "SELECT Giorno FROM lezione WHERE Disciplina_idDisciplina="+ idDisciplina +"";
		
		Giorni = DbConnection.getInstance().eseguiQuery(query1);
		
		//RICAVO ORE DAL DB
		
	    String query2 = "SELECT Ora FROM lezione WHERE Disciplina_idDisciplina="+ idDisciplina +"";
		
	    Ore = DbConnection.getInstance().eseguiQuery(query2);
		
		//POPOLO LEZIONE
	    
	    //System.out.println("I GIORNI SONO :  " + Giorni.size());
		
		for(int i = 0;  i < Giorni.size(); i++ )
		{
		
			Lezione a = new Lezione();
			
			a.setGiorno(Giorni.get(i)[0]);

			a.setOra(Ore.get(i)[0]);
			
			le.add(a);
			
		}
		
		
		
		DbConnection.disconnetti();
		
		return le;
		
		
	 
	 }
	 
	 

	
	 /*Prende il giorno e l'aula e restituisce un arraylist di lezioni, ciascuna delle quali è formata dal nome della disciplina, 
	  * dal suo livello e dall'ora in cui si svolge la lezione stessa */
	 
	 public ArrayList<Lezione> getOrarioComplessivo( String giorno, String aula)
	
	 {
	     
	   
	    
	    //RICAVO GLI ID DELLE DISCIPLINE DAL DB
		 
	    String query1 = "SELECT Disciplina_idDisciplina FROM lezione WHERE Giorno = '"+ giorno +"'AND Aula = '"+aula+"'";   

	    id = DbConnection.getInstance().eseguiQuery(query1);
	    
	   
		
		//RICAVO ORE DAL DB
	    
	    String query2 = "SELECT Ora FROM lezione WHERE Giorno = '"+ giorno + "'AND Aula = '"+aula+"'";   
		
	    Ore = DbConnection.getInstance().eseguiQuery(query2);
		
	    //POPOLO LE LEZIONI
	    
	    if (id.size () > 0)
	    {
		
	    	for(int i = 0;  i <id.size() ; i++ )
		
	    	{
		
			
	    		Lezione a = new Lezione();
	    		
	    		//POPOLO NOME E LIVELLO
	    		
	    		// DAO CHE PRENDE L'ID DELLA DISCIPLINA E RESTITUISCE IL NOME E IL LIVELLO
	    		
	    	    DisciplinaDAO ricavadisciplinalivello = new DisciplinaDAO();
			
	    		a.setDisciplina(ricavadisciplinalivello.getDisciplinaLivello(Integer.parseInt(id.get(i)[0])).get(0)[0]);
			
	    		a.setLivello(ricavadisciplinalivello.getDisciplinaLivello(Integer.parseInt(id.get(i)[0])).get(0)[1]);	
		
			
	    		//POPOLO ORA
	    		
	    		if (Ore.size () > 0)	
	    		
	    		{
				
	    			a.setOra(Ore.get(i)[0]);
				
	    			le.add(a);
			
	    		}
	    	}
	    	
	    	DbConnection.disconnetti();
	    	
	    	return le;
	   
	    }
	    
		else 
			
		{
			DbConnection.disconnetti();
			
			//RITORNA ARRAYLIST VUOTA
			
			return le;
	    }
		
	    
     }
	 
	 
	 
	 
	 
	 
	 //METODO UTILIZZATO IN FASE DI CREAZIONE DI UNA NUOVA LEZIONE 
	 
	 /*Prende il giorno, l'aula e un array che contiene gli 11 orari possibili e restituisce gli orari disponibili per 
	   la creazione di una nuova lezione nel giorno dato*/
	 
	 public String[] getOraCreaLezione(String Giorno, String[] arrayOrario, String aula)
	 
	 {
		   
		    //RICAVO ORE DAL DB
		    
		    String query2 = "SELECT Ora FROM `lezione` WHERE Giorno='"+ Giorno +"'";
			
		    Ore = DbConnection.getInstance().eseguiQuery(query2);
			
			//POPOLO LEZIONE
		    
		    //System.out.println("I GIORNI SONO :  " + Giorni.size());
			
			for(int i = 0;  i < Ore.size(); i++ )
			{
				
				if(Ore.get(i)[0].equals("09:00:00"))
				{
					arrayOrario[0]="-";	
				}
				if(Ore.get(i)[0].equals("10:00:00"))
				{
					arrayOrario[1]="-";	
				}
				if(Ore.get(i)[0].equals("11:00:00"))
				{
					arrayOrario[2]="-";	
				}
				if(Ore.get(i)[0].equals("12:00:00"))
				{
					arrayOrario[3]="-";	
				}
				if(Ore.get(i)[0].equals("15:00:00"))
				{
					arrayOrario[4]="-";	
				}
				if(Ore.get(i)[0].equals("16:00:00"))
				{
					arrayOrario[5]="-";	
				}
				if(Ore.get(i)[0].equals("17:00:00"))
				{
					arrayOrario[6]="-";	
				}
				if(Ore.get(i)[0].equals("18:00:00"))
				{
					arrayOrario[7]="-";	
				}
				if(Ore.get(i)[0].equals("19:00:00"))
				{
					arrayOrario[8]="-";	
				}
				if(Ore.get(i)[0].equals("20:00:00"))
				{
					arrayOrario[9]="-";	
				}
				if(Ore.get(i)[0].equals("21:00:00"))
				{
					arrayOrario[10]="-";	
				}
				
			}
			
			DbConnection.disconnetti();
			
			return arrayOrario;
			
		}
	   
		


	 
	 
}
