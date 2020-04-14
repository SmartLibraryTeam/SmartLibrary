package DAO;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DbConnection.DbConnection;
import modelli.Evento;

public class EventoDAO 
{

      //PARAMETRI 
      
	  public Vector<String[]> e ;
	  public Vector<String[]> Nome;
	  public Vector<String[]> Stato;
		
	  public static ArrayList<Evento> l = new ArrayList<Evento>();
     
	  int e1 = 0;
	  int id ;
	  int idNew;
      
	  public String is;

     
      
      //METODI
      
      

  	
  	  //METODI UTILIZZATI PER RICAVARE DATI RELATIVI AGLI EVENTI
      
  	  
      //Prende il nome dell'evento e restituisce il suo id

      public int getIdEvento (String nomeEvento)

      {

	        String query = "SELECT idEvento FROM `evento` WHERE Nome='"+ nomeEvento +"'";
	        e = DbConnection.getInstance().eseguiQuery(query);
	        e1= Integer.parseInt(e.get(0)[0]);
	

	        DbConnection.disconnetti();// disconnessione.
	        return  e1;
				
      }

      
      
      //Prende il nome dell'evento e restituisce il suo tipo

      public Vector<String[]> getTipoEvento (String nomeEvento)
       
      {
		
	
	       String query =  "SELECT Tipo FROM evento WHERE Nome LIKE '"+ nomeEvento+ "'";
	       e = DbConnection.getInstance().eseguiQuery(query);
		   DbConnection.disconnetti();// disconnessione.
		
		   return e;
					
       }
	

       //Prende l'id dell'evento e restituisce il suo tipo

       public Vector<String[]> getTipoEventoFromId (int idEvento)
       
       {
		
	
	       String query =  "SELECT Tipo FROM evento WHERE idEvento LIKE '"+idEvento+ "'";
	       e = DbConnection.getInstance().eseguiQuery(query);
		   DbConnection.disconnetti();// disconnessione.
		
		   return  e;
					
       } 



        //Prende l'id dell'evento e restituisce il suo nome

        public Vector<String[]> getNomeEvento (int idEvento)

        {
	

            String query =  "SELECT Nome FROM evento WHERE idEvento LIKE '"+ idEvento + "'";
            e = DbConnection.getInstance().eseguiQuery(query);
	        DbConnection.disconnetti();// disconnessione.
	
	        return  e;
				
        }


        //Prende il nome dell'evento e restituisce tutti i dati dell'evento 

        public Vector<String[]> getDatiEventoFromNome (String nomeEvento)

        {
		
	         String query = "SELECT DISTINCT * FROM `evento` WHERE `Nome` LIKE '" + nomeEvento + "'";;
       	     e = DbConnection.getInstance().eseguiQuery(query);
		     DbConnection.disconnetti();// disconnessione.
			
		     return  e;
			
        }

        
        //Prende l'id dell'istruttore e restituisce tutti gli eventi gestiti dall'istruttore stesso

        public Vector<String[]> getEventiIstruttore(int idIstruttore)

        {
	

             String query = "SELECT Nome FROM `evento` WHERE Istruttore_Utente_Registrato_idUtente_Registrato='"+ idIstruttore + "'";
             e= DbConnection.getInstance().eseguiQuery(query);
	         DbConnection.disconnetti();// disconnessione.
	
	         return  e;
				
        } 



        //Restituisce tutti i nomi degli eventi presenti nel db

        public Vector<String[]> getEventi()
        
        {
	

             String query =  "SELECT DISTINCT Nome FROM `evento`";
             e= DbConnection.getInstance().eseguiQuery(query);
 	         DbConnection.disconnetti();// disconnessione.
	
	         return e;
				
        }

      
        
       
        //Restituisce i nomi degli eventi che hanno Stato = Negato e che quindi devono essere ancora confermati dal responsabile 

        public Vector<String[]> getEventiDaConfermare() 

        {
	
		
	          String query = "SELECT Nome FROM `evento` WHERE `Stato` LIKE 'Negato'";
              e= DbConnection.getInstance().eseguiQuery(query);
              DbConnection.disconnetti();// disconnessione.
		
              return  e;
					
        }



        //Prende il nome dell'evento e restituisce l'id della lezione, nella quale si terr‡ l'evento

        public Vector<String[]> getIdLezione (String nomeEvento)

        {
		
	
	         String query =  "SELECT idLezione FROM evento WHERE Nome LIKE '"+ nomeEvento+ "'";;
             e = DbConnection.getInstance().eseguiQuery(query);
	       	 DbConnection.disconnetti();// disconnessione.
		
		     return  e;
		 
					
        }



        //Prende il nome dell'evento e restituisce l'id dell'istruttore che ha organizzato l'evento

        public Vector<String[]> getIdIstruttore (String nomeEvento)

        {
 		
		
	         String query = "SELECT Istruttore_Utente_Registrato_idUtente_Registrato FROM `evento` WHERE Nome='"+ nomeEvento +"'";
 	         e = DbConnection.getInstance().eseguiQuery(query);
		     DbConnection.disconnetti();// disconnessione.
		
		     return  e;
					

        }



        //Prende il nome dell'evento e restituisce l'id della disciplina 
  
        public Vector<String[]> getIdDisciplina (String nomeEvento)
	
        {
			
			
		     String query = "SELECT Disciplina_idDisciplina FROM `evento` WHERE Nome='"+ nomeEvento +"'";
     	     e = DbConnection.getInstance().eseguiQuery(query);
		     DbConnection.disconnetti();// disconnessione.
			
		     return  e;
					

        }
 
 

        //Prende l'id della disciplina e l'id dell'istruttore e restituisce l'id della lezione, nella quale si terr‡ l'evento
 
        public Vector<String[]> getIDLezioneFromIdIStruttoreAndIdDisciplina (int idDisciplina, int idIstruttore)
	
        {
	     
	        
	         String query = "SELECT idLezione FROM evento WHERE Disciplina_idDisciplina = '"+ idDisciplina+"' AND Istruttore_Utente_Registrato_idUtente_Registrato = '"+idIstruttore+"'";
	         e = DbConnection.getInstance().eseguiQuery(query);
	         DbConnection.disconnetti();// disconnessione.
			
   		     return e;
	 		
	    
        }
 
 

        //Prende l'id della disciplina e restituisce gli id degli eventi organizzati all'interno della disciplina stessa
 
        public Vector<String[]> getidEventifromidDisciplina(int idDisc)
	
        {
		
		
	         String query = "SELECT idEvento FROM `evento` WHERE `Disciplina_idDisciplina` = "+idDisc+" ORDER BY `idEvento` ASC";
		     e = DbConnection.getInstance().eseguiQuery(query);
		     DbConnection.disconnetti();// disconnessione.
		
		     return e;
	
        }
        
        
        
        //Restituisce tutti i nomi degli eventi che sono gi‡ stati accettati dal responsabile del centro 
        
        public Vector<String[]> getEventiAccettati()
        
        {
    		
    	
    	     String query =  "SELECT DISTINCT Nome FROM `evento` WHERE Stato='Accettato'";
    	     e= DbConnection.getInstance().eseguiQuery(query);
    		 DbConnection.disconnetti();// disconnessione.
    		
    		 return e;
    					
        }
        
        
    	
        //Prende il nome dell'evento e restituisce il costo
        
    	public Vector<String[]> getCostoEvento(String nomeEvento)
    	
    	{
    		
    		 String query = "SELECT costo FROM `evento` WHERE Nome='" + nomeEvento + "'";
    		 e = DbConnection.getInstance().eseguiQuery(query);
    		 DbConnection.disconnetti();
    		 
    		 return e;
    		
    		
    	}
    	
    	
    	
    	
    	//Prende l'id dell'istruttore e restituisce un arraylist di eventi, ciascuno dei quali Ë formato dal suo nome e dal suo stato
    	
    	public ArrayList<Evento> getEventi(int idIstruttore)
    	
    	{
    		
    		//SVUOTO ARRAYLIST DA PASSARE
    		
    		l.clear();
    		
    		
    	    //RICAVO NOMI DAL DB
    		
    	    String query1 = "SELECT Nome FROM evento WHERE Istruttore_Utente_Registrato_idUtente_Registrato='"+ idIstruttore +"' ORDER BY Nome";
    	
    		Nome = DbConnection.getInstance().eseguiQuery(query1);
    		
    		//RICAVO STATI DAL DB
    	    
    		String query2 = "SELECT Stato FROM evento WHERE Istruttore_Utente_Registrato_idUtente_Registrato='"+idIstruttore+"' ORDER BY Nome";
    		
    	    Stato = DbConnection.getInstance().eseguiQuery(query2);
    		
    	
    	    //POPOLO EVENTO
    	    
    		System.out.println("nome.size()= " + Nome.size());
    		
    		for(int i = 0;  i < Nome.size(); i++ )
    		{
    		
    			Evento a = new Evento();
    			
    			a.setNome(Nome.get(i)[0]);

    			a.setStato(Stato.get(i)[0]);
    			
    			l.add(a);
    		}
    		
    		DbConnection.disconnetti();
    		
    		return l;
    	
    	}
    	
    	
    	
    	
        

  	  
  	    
        
        //METODI UTILIZZATI PER RICAVARE DATI RELATIVI ALLE ISCRIZIONI AI VARI EVENTI
        
        
        //Prende l'id dell'evento e l'id del tesserato e restituisce lo stato dell'iscrizione del tesserato all'evento
  	    
	    public Vector<String[]> getStatoIscrizioneEvento (int idEvento, int id)
        
        {
	
	
             String query =  "SELECT Stato FROM iscrizione_evento WHERE Evento_idEvento LIKE '"+ idEvento + "' AND Tesserato_Utente_Registrato_idUtente_Registrato LIKE '"+id+"'";
             e = DbConnection.getInstance().eseguiQuery(query);
	         DbConnection.disconnetti();// disconnessione.
	
	         return  e;
	        
				
        }
	    
	    
	    
	    
	    //Prende l'id dell'evento e l'id del tesserato e restituisce lo stato del pagamento dell'iscrizione 
	    
		public Vector<String[]> getStatoPagamentoEvento (int idEvento, int id)
		
		{
				
				
			  String query =  "SELECT StatoPagamento FROM iscrizione_evento WHERE Evento_idEvento LIKE '"+ idEvento + "' AND Tesserato_Utente_Registrato_idUtente_Registrato LIKE '"+id+"'";
			  e = DbConnection.getInstance().eseguiQuery(query);
		   	  DbConnection.disconnetti();// disconnessione.
				
			  return  e;
				
							
		}

		
		 
		//Prende l'id dell'evento e l'id del tesserato e restituisce la modalit‡ di pagamento dell'iscrizione 
		
		public String getModalit‡PagamentoEvento (int idEvento, int idTesserato)
		
		{
			
			  String query = "SELECT Modalit‡Pagamento FROM iscrizione_evento WHERE Evento_idEvento='"+idEvento+"' AND Tesserato_Utente_Registrato_idUtente_Registrato='"+idTesserato+"'";
			  is = DbConnection.getInstance().eseguiQuery(query).get(0)[0];
			  DbConnection.disconnetti();// disconnessione.
		
	       	  return is;
			    
			    
		}
		
		
		
		//Prende l'id dell'evento e restituisce gli id dei tesserati non ancora iscritti all'evento stesso 
		
		public Vector<String[]> getTesseratiEventoNegato (int id)
		
		{
			
			  String query = "SELECT Tesserato_Utente_Registrato_idUtente_Registrato FROM `iscrizione_evento` WHERE Stato='Negato' AND Evento_idEvento='"+id+"'";
			  e = DbConnection.getInstance().eseguiQuery(query);
			  DbConnection.disconnetti();// disconnessione.
			
			  return e;
		
		}
		
		
        
		//Prende l'id del tesserato e restituisce gli id degli eventi ai quali Ë iscritto
		
		public Vector<String[]>  getIdEventiIscrizioneEffettuata(int id)
	
		{
		
		    String query =  "SELECT Evento_idEvento FROM iscrizione_evento WHERE Tesserato_Utente_Registrato_idUtente_Registrato LIKE '"+id+"'";
		    e = DbConnection.getInstance().eseguiQuery(query);
		    DbConnection.disconnetti();// disconnessione.
			
			return e;
						
	
		}
		
		
		
		//Prende il nome dell'evento e restituisce gli id dei tesserati che hanno richiesto l'iscizione all'evento
		
		public Vector<String[]> getIscrittiEvento(String nomeEvento)
		
		{
			
			EventoDAO nome = new EventoDAO();
			int idEvento = nome.getIdEvento(nomeEvento);
			String query ="SELECT Tesserato_Utente_Registrato_idUtente_Registrato FROM `iscrizione_evento` WHERE Evento_idEvento="+idEvento+"";
			e = DbConnection.getInstance().eseguiQuery(query);
			
			return e;
		
		}
		
		
		
		//Prende l'id del tesserato e l'id dell'evento e conferma definitivamente l'iscrizione del tesserato all'evento
		
		public void setStatoIscrizioneEvento(int idEvento, int idTesserato)
		
		{
			
			String query = "UPDATE `iscrizione_evento` SET `Stato` = 'Accettato', `StatoPagamento` = 'Pagato' WHERE `iscrizione_evento`.`Evento_idEvento` = "+idEvento +" AND `iscrizione_evento`.`Tesserato_Utente_Registrato_idUtente_Registrato` = "+idTesserato+";";
			DbConnection.getInstance().eseguiAggiornamento(query);
			DbConnection.disconnetti();
			
		}
		
		
		
		
		
		
		
		//METODI UTILIZZATI PER AGGIUNGERE UN NUOVO EVENTO AL DATABASE 
		
		
		//Metodo usato in CreaEventoGUI per creare un nuovo evento
		
		public boolean newEvento (int IdLezione, String NomeEvento,String TipoEvento, String IdDisciplina, String IdIstruttore)
			         
		{
				     		
			    try 
		      {
				     		
			    String query = "INSERT INTO `evento` ( `idLezione`, `Nome`, `Tipo`, `Stato`, `Costo`, `Disciplina_idDisciplina`, `Istruttore_Utente_Registrato_idUtente_Registrato`) VALUES ('"+ IdLezione +"', '"+NomeEvento+"', '"+TipoEvento+"', 'Negato', '0', '"+ IdDisciplina +"', '"+ IdIstruttore +"')";
				     		
				DbConnection.getInstance().eseguiAggiornamento(query);
				     		
				DbConnection.disconnetti();
				     		
				return true;
				     	
		      }
				     		
			    catch (Exception e) 
				     	
			  {
				     			
			    System.out.println("query non Ë andata a buon fine");
			     			
		    	return false;
				     			
				     	
			  }
				     		
				
		}

	    
	    
		
		
		//Metodo tramite il quale il responsabile del centro cambia lo stato di un evento creato da un istruttore e aggiunge il relativo costo
		         
		public void setCostoEvento(int idEvento ,String costo, String stato)
		      
		{
		     		    
				String query =  "UPDATE `evento` SET `Costo` = '"+ costo +"',Stato = '"+ stato +"' WHERE `evento`.`idEvento` = "+ idEvento +"";
		     	DbConnection.getInstance().eseguiAggiornamento(query);
		        DbConnection.disconnetti();
		     			
		     			
		}
		
		
		
		
		
		
		
		//METODO UTILIZZATO PER VERIFICARE L'EVENTUALE PRESENZA NEL DB DI UN DATO EVENTO

		public boolean controlloEvento(String nomeEvento) 
		
		{
			 
			    String query = "SELECT * FROM `evento` WHERE `Nome` LIKE '"+nomeEvento+"'";
				
				if(DbConnection.getInstance().eseguiQuery(query).size() != 0)
				{
					return true;
				}
				else
				{
					return false;
				}
		
		}
		
		
		
		
		
		
		//METODO UTILIZZATO PER VERIFICARE L'ISCRIZIONE DI UN TESSERATO AD UN DATO EVENTO

		public Vector<String[]> controlloIscrizioneEvento (int idEvento, int id)
	
		{
			
		
		       String query =  "SELECT * FROM iscrizione_evento WHERE Evento_idEvento = '"+idEvento+"' AND`Tesserato_Utente_Registrato_idUtente_Registrato` = '"+id+"'";
		       e = DbConnection.getInstance().eseguiQuery(query);
			   DbConnection.disconnetti();// disconnessione.
			
			   return  e;
						
	
		}
	


		
		
		
		//METODI CHE PERMETTONO AD UN TESSERATO DI EFFETTUARE L'ISCRIZIONE AD UN EVENTO
		
		
		//Metodo usato per popolare il db con la nuova iscrizione all'evento nel caso in cui l'evento sia una gara
		
		public void setAggiuntaEventoGara(int idEvento, int id , String modalit‡pagamento)
		
		{
			//POPOLA DB CON LA NUOVA ISCRIZIONE ALL'EVENTO
			
			/*Lo stato Ë sempre 'Negato' finchË il responsabile del centro non accetta la richiesta di iscrizione del tesserato
		     * e la colonna certificato Ë sempre '0' finchË il responsabile non verifica che il certificato di sana e robusta costituzione sia idoneo*/
			
			String query = "INSERT INTO `iscrizione_evento` (`Evento_idEvento`, `Tesserato_Utente_Registrato_idUtente_Registrato`, `Stato`, `Modalit‡Pagamento`, `Certificato`, `StatoPagamento`) VALUES ('"+idEvento+"', '"+id+"', 'Negato', '"+modalit‡pagamento+"', 'Si', 'Non pagato');";
			DbConnection.getInstance().eseguiAggiornamento(query);
	        DbConnection.disconnetti();
	     			
		    
	        JFrame iscrizioneaggiunta = new JFrame();
			JOptionPane.showMessageDialog( iscrizioneaggiunta," La tua richiesta di iscrizione Ë stata inviata ");
			
		}
		

		//Metodo usato per popolare il db con la nuova iscrizione all'evento nel caso in cui l'evento sia uno stage
		
		public void setAggiuntaEventoStage(int idEvento, int id , String modalit‡pagamento)
		
		{
			//POPOLA DB CON LA NUOVA ISCRIZIONE ALL'EVENTO
			
			/*Lo stato Ë sempre 'Negato' finchË il responsabile del centro non accetta la richiesta di iscrizione del tesserato
		     * e la colonna certificato Ë sempre 'NULL'*/
			
			String query = "INSERT INTO `iscrizione_evento` (`Evento_idEvento`, `Tesserato_Utente_Registrato_idUtente_Registrato`, `Stato`, `Modalit‡Pagamento`, `Certificato`, `StatoPagamento`) VALUES ('"+idEvento+"', '"+id+"', 'Negato', '"+modalit‡pagamento+"', 'Non necessario', 'Non pagato');";
			DbConnection.getInstance().eseguiAggiornamento(query);
	        DbConnection.disconnetti();
			
			JFrame iscrizioneaggiunta = new JFrame();
			JOptionPane.showMessageDialog( iscrizioneaggiunta," La tua richiesta di iscrizione Ë stata inviata ");
			
		}
		
		 
		
		
		
		//METODO UTILIZZATO PER CANCELLARE L'ISCRIZIONE DI UN TESSERATO AD UN DETERMINATO EVENTO
			
		public void cancellaiscrizione (int idEvento, int id)
		
		{
				
			  String query = "DELETE FROM iscrizione_evento WHERE Evento_idEvento LIKE '"+ idEvento +"' AND Tesserato_Utente_Registrato_idUtente_Registrato LIKE '"+id+"'";  
			  DbConnection.getInstance().eseguiAggiornamento(query);
		      DbConnection.disconnetti();// disconnessione.
				
				
	    }
		

		
		
		
		 
		//METODO UTILIZZATO PER ELIMINARE UN EVENTO
		
		public void eliminaEvento (int idEvento)
		
		{
			
			
			//ELIMINA ISCRITTI ALL' EVENT0
			
			String query1 = "DELETE iscrizione_evento FROM `iscrizione_evento` WHERE Evento_idEvento = '"+idEvento+"'";
			
			DbConnection.getInstance().eseguiAggiornamento(query1);
			DbConnection.disconnetti();
			
			System.out.println("query1 ok :  ELIMINA ISCRITTI AD EVENT0");
			
			
			//ELIMINA EVENTO
			
			String query2 = "DELETE FROM evento WHERE idEvento='"+idEvento+"'";
				
			DbConnection.getInstance().eseguiAggiornamento(query2);
			DbConnection.disconnetti();	
		
			System.out.println("query2 ok :  ELIMINA  EVENTO ");
		
		
		}

		
	
	
	



}
