package DAO;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DbConnection.DbConnection;

public class DisciplinaDAO 
{	
	
	//PARAMETRI 
	
    public Vector<String[]> dl ;
	public Vector<String[]> d;
    public Vector<String[]> r;
	
	int i = 0;
	int id ;
	int idNew;
	   
	public String is;

	  
	//METODI
	
	
	
	
	
	//METODI UTILIZZATI PER RICAVARE DATI RELATIVI ALLE DISCIPLINE
	
	
	//Prende l'id della disciplina e restituisce il nome e il livello
	
    public Vector<String[]> getDisciplinaLivello (int idDisciplina)
    
   {
	        
    	String query =  "SELECT Nome, Livello FROM `disciplina` WHERE idDisciplina LIKE '" +idDisciplina+ "'";
    
        dl = DbConnection.getInstance().eseguiQuery(query);

	    if (dl.size()>0) 
	    {
		 d= dl;
	    }
	
	    DbConnection.disconnetti();// disconnessione.
	
	    return  d;
				
   }
    
    
    //Prende l'id della disciplina e restituisce il nome 
    
	public Vector<String[]> getNomeDisciplina (int idDisciplina)
  
   {
		
	    String query =  "SELECT Nome FROM `disciplina` WHERE idDisciplina LIKE '" +idDisciplina+ "'";
	    d = DbConnection.getInstance().eseguiQuery(query);
		DbConnection.disconnetti();// disconnessione.
		
		return  d;
					
   }
	
	 
	//Prende l'id della disciplina e restituisce il livello
	
	public Vector<String[]> getLivelloDisciplina (int idDisciplina)
   
   {
		
	
	    String query =  "SELECT Livello FROM `disciplina` WHERE idDisciplina LIKE '" +idDisciplina+ "'";
	    d = DbConnection.getInstance().eseguiQuery(query);
		DbConnection.disconnetti();// disconnessione.
		
		return  d;
					
   }
	
	
	/*Metodo usato in CreaEventoGUI per calcolare l' id della disciplina, dato il nome e il livello, 
	 *in modo poi da popolare la combobox di giorno e ora */
	
	public int getIdDisciplina (String nomedisciplina, String livello)
	
   {
		
		String query = "SELECT idDisciplina FROM `disciplina` WHERE Nome='"+ nomedisciplina +"' AND `Livello` LIKE '"+ livello +"'";
		
		r = DbConnection.getInstance().eseguiQuery(query);
		
		i = Integer.parseInt(r.get(0)[0]);
		
        System.out.println(d);
        
		DbConnection.disconnetti();// disconnessione.
		
		return i;
					
   }
	
	
	
	/*Metodo usato in ConsultaDisciplinaTesserato per ricavare l'id della disciplina, dato il nome, in modo da 
	 * prelevare l'orario della disciplina con livello = principiante  */
	
	public int getIdDisciplinaPrincipiante (String nomedisciplina)
	
   {
		
		
		String query = "SELECT idDisciplina FROM `disciplina` WHERE Nome='"+ nomedisciplina + "'  AND Livello LIKE 'Principiante' " ;
		
		r = DbConnection.getInstance().eseguiQuery(query);
		
		if (r.size()>0) 
		{
			i= Integer.parseInt(r.get(0)[0]);
		}
		
		else
		{
			i = -1;
		}
		
		DbConnection.disconnetti();// disconnessione.
		
		return i ;
					
   }
	
	
	
	/*Metodo usato in ConsultaDisciplinaTesserato per ricavare l'id della disciplina, dato il nome, in modo da 
	 * prelevare l'orario della disciplina con livello = amatoriale  */
	
	public int getIdDisciplinaAmatoriale (String nomedisciplina)
	
   {
			
			String query = "SELECT idDisciplina FROM `disciplina` WHERE Nome='"+ nomedisciplina + "'  AND Livello LIKE 'Amatoriale' " ;
			
			r = DbConnection.getInstance().eseguiQuery(query);
			
			if (r.size()>0) 
			{
				i = Integer.parseInt(r.get(0)[0]);
			}
			
			else
			{
				i = -1;
			}
					
            DbConnection.disconnetti();// disconnessione.
			
			return i;
						
	}
	
	
	/*Metodo usato in ConsultaDisciplinaTesserato per ricavare l'id della disciplina, dato il nome, in modo da 
	 * prelevare l'orario della disciplina con livello = agonistico  */
	
	public int getIdDisciplinaAgonistico (String nomedisciplina)
	
	{
			
			String query = "SELECT idDisciplina FROM `disciplina` WHERE Nome='"+ nomedisciplina + "'  AND Livello LIKE 'Agonistico' " ;
			
			r = DbConnection.getInstance().eseguiQuery(query);
			
			if (r.size()>0) 
			{
				i = Integer.parseInt(r.get(0)[0]);
			}
			else
			{
				i = -1;
			}
					
			DbConnection.disconnetti();// disconnessione.
			
			return i ;
						
	}
	
	
	 
	 //Prende l'id della disciplina e restituisce tutti i dati della disciplina stessa
	
	 public Vector<String[]> getDatiDisciplinaFromId (int id)
	
	{
		
			String query = "SELECT DISTINCT * FROM `disciplina` WHERE idDisciplina='"+ id +"'";
			d = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();// disconnessione.
			
			return  d;
			
	}

	 
	 
	 //Prende il nome della disciplina e restituisce tutti i dati della disciplina stessa
	 
	 public  Vector<String[]> getDatiDisciplinaFromNome (String nomedisciplina)
	 
	{
	 		
	 		String query = "SELECT DISTINCT * FROM `disciplina` WHERE Nome='"+ nomedisciplina +"'";
	 		d = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();// disconnessione.
			
			return  d;
			
	}
	 
	 
     
	 //Prende il nome della disciplina e restituisce il livello
		
	 public  Vector<String[]> getLivelloDisciplina(String nomedisciplina)
	 
	{
	 		
	 		String query = "SELECT Livello FROM `disciplina` WHERE Nome='"+ nomedisciplina +"'";
	 		d = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();// disconnessione.
			
			return  d;
	
	}
	 
	 

	 //Prende l'id dell'istruttore e restituisce i nomi delle discipline gestite dall'istruttore stesso
	 
	 public Vector<String[]> getDisciplineIstruttore(int idIstruttore)
		
	{
			
	        String query = "SELECT DISTINCT Nome FROM disciplina WHERE Istruttore_Utente_Registrato_idUtente_Registrato='"+ idIstruttore +"'";
		    d = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();// disconnessione.
			
			return  d;
						
	}
		
		
	 //Restituisce tutti i nomi delle discipline presenti nel db
		
	 public Vector<String[]> getDiscipline()
		
	{
			
		
		    String query =  "SELECT DISTINCT Nome FROM `disciplina`";
		    d= DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();// disconnessione.
			
			return d;
						
	}
	 	
	 
	 //Prende il nome della disciplina e restituisce l'id 
	 
	 public Vector<String[]> getIdDiscipline (String nomeDisciplina)

	{
				
			String query = "SELECT idDisciplina FROM disciplina WHERE Nome='"+ nomeDisciplina+"'";
			d = DbConnection.getInstance().eseguiQuery(query);
	        DbConnection.disconnetti();// disconnessione.
				
			return  d;
							
	}
	 
	 

		
      //Prende il nome e il livello della disciplina e restituisce l'id 
	 
	  public Vector<String[]> getIdDisciplinafromNameandLivello(String disciplina,String livello)
		
	{
			
			String query = "SELECT idDisciplina FROM `disciplina` WHERE Nome='"+disciplina+"'AND Livello='"+livello+"'";
			d = DbConnection.getInstance().eseguiQuery(query);
            DbConnection.disconnetti();// disconnessione.
			
			return  d;
			
	}
	  
	  
	  
	  
	  //Prende il nome della disciplina e l'id dell'istruttore e restituisce i livelli disponibili
	  
	  public Vector<String[]> getLivelloDisciplinaIstruttore(String nomedisciplina, int idIstr)
		 
	{
			 	
		    String query = "SELECT Livello FROM `disciplina` WHERE Nome='"+nomedisciplina+"' AND Istruttore_Utente_Registrato_idUtente_Registrato = '"+idIstr+"'";
		 	d = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();// disconnessione.
				
			return  d;
			 
			 
	}
	   
     
	  
	  
	 
	  
	  
	  
	  //METODI UTILIZZATI PER RICAVARE DATI RELATIVI ALLE ISCRIZIONI ALLE LEZIONI DELLE VARIE DISCIPLINE
	  
	  
	  //Prende l'id del tesserato e l'id della lezione e restituisce la modalità di pagamento
		
      public String getModalitàPagamentoDisciplina (int idTesserato, int idLezione)
     
    {

   
	        String query ="SELECT ModalitàPagamento FROM iscrizione_disciplina WHERE Tesserato_Utente_Registrato_idUtente_Registrato LIKE '"+idTesserato+"' AND IdLezione LIKE '"+idLezione+"'";
	        is = DbConnection.getInstance().eseguiQuery(query).get(0)[0];
            DbConnection.disconnetti();// disconnessione.
	
	        return is;
	        
    }
      
      

	  
      //Prende l'id del tesserato e restituisce gli id delle discipline a cui appartengono le lezioni a cui è iscritto
	  
	  public Vector<String[]> getidDisciplineTesserato(int id)
	   
	{
			
		    
	    	String query = "SELECT DISTINCT Disciplina_idDisciplina FROM `iscrizione_disciplina` WHERE `Tesserato_Utente_Registrato_idUtente_Registrato` = "+id+" AND `Stato` LIKE 'Accettato' AND `StatoPagamento` LIKE 'Pagato'";
			d = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();
			
			return d;
			
	 }
	  
	  
	    
	  
	  //Prende l'id del tesserato e restituisce gli id delle lezioni a cui è iscritto
	    
	  public Vector<String[]> getIDLezioneTesserato( int idTesserato)
		
	 {
			
	    	
	    	String query = "SELECT IdLezione FROM `iscrizione_disciplina` WHERE `Tesserato_Utente_Registrato_idUtente_Registrato` = "+idTesserato+"";
			d = DbConnection.getInstance().eseguiQuery(query);
			DbConnection.disconnetti();
			
			return d;
			
			
	 }
	  
	  
	  //Prende l'id della lezione e restituisce gli id degli iscritti alla lezione
	  
	  public Vector<String[]> getIDIscrittiLezioneDisciplina (int idLezione)
		
	 {
			
	       String query1 = "SELECT Tesserato_Utente_Registrato_idUtente_Registrato FROM `iscrizione_disciplina` WHERE IdLezione = '" + idLezione +"' AND Stato LIKE 'Accettato' AND StatoPagamento LIKE 'Pagato'";
	       d = DbConnection.getInstance().eseguiQuery(query1);
		   DbConnection.disconnetti();// disconnessione.
		
		   return  d;
					
	 }
		
	  
	 
	  /*Prende l'id della lezione e restituisce gli id dei tesserati che hanno effettuato il pagamento, 
	   * ma sono in attesa della conferma dell'iscrizione alla lezione da parte dell'istruttore*/
		
	  public Vector<String[]> getIDIscrittiNonAccettatiLezioneDisciplina (int idLezione)
		
	 {
			
	       String query2 = "SELECT Tesserato_Utente_Registrato_idUtente_Registrato FROM `iscrizione_disciplina` WHERE IdLezione = '" + idLezione +"' AND Stato LIKE 'Negato' AND StatoPagamento LIKE 'Pagato'";
	       d = DbConnection.getInstance().eseguiQuery(query2);
		   DbConnection.disconnetti();// disconnessione.
		
		   return  d;
					
		
	  }
		
	  
	  
	  //Prende l'id della lezione e restituisce gli id dei tesserati che hanno richiesto l'iscrizione alla lezione
	  
	  public Vector<String[]> getIDIscrittiStatoPagamentoNonPagato (int idLezione)
		
	 {
			
	       String query2 = "SELECT Tesserato_Utente_Registrato_idUtente_Registrato FROM `iscrizione_disciplina` WHERE IdLezione = '" + idLezione +"' AND Stato LIKE 'Negato' AND StatoPagamento LIKE 'Non pagato'";
	       d = DbConnection.getInstance().eseguiQuery(query2);
		   DbConnection.disconnetti();// disconnessione.
		
		   return  d;
					
		
	 }
	  
	  
	  
	  //Prende l'id del tesserato e restituisce tutti i dati relativi alle sue iscrizioni ai vari turni
	  
	  public  Vector<String[]> getTurni( int id)
		
	 {
			
		   String query = "SELECT * FROM `iscrizione_disciplina` WHERE `Tesserato_Utente_Registrato_idUtente_Registrato` = "+id+"";
		   d = DbConnection.getInstance().eseguiQuery(query);
		   DbConnection.disconnetti();// disconnessione.
			
			
	       return d;

		
	 }

	  
	  
	  
	 
	  
	  //METODI UTILIZZATI PER AGGIUNGERE UNA NUOVA DISCIPLINA AL DATABASE O PER MODIFICARNE UNA ESISTENTE
	  
	  
	  //Aggiunge una nuova disciplina al database
	  
	  public  void aggiuntaNuovaDisciplina (String nomeDisciplina, String livello, int idIstruttore ,int idResponsabileCentro, double costo, String immagine, String descrizione)
		
	  {
				
		
					//POPOLA DB CON LA NUOVA DISCIPLINA
		
				 
				    String query = "INSERT INTO `disciplina` ( `Nome`, `Livello`, `Descrizione`, `Immagine`, `Costo`, `Istruttore_Utente_Registrato_idUtente_Registrato`, `Responsabile_Centro_Utente_Registrato_idUtente_Registrato`) VALUES ('"+nomeDisciplina+"', '"+livello+"', '"+descrizione+"', '"+immagine+"', '"+costo+"', '"+idIstruttore+"', '"+idResponsabileCentro+"');";
					
					DbConnection.getInstance().eseguiAggiornamento(query);
					
					DbConnection.disconnetti();
					
					
	                JFrame disciplinaaggiunta = new JFrame();
					
					JOptionPane.showMessageDialog(disciplinaaggiunta,"DISCIPLINA AGGIUNTA CORRETTAMENTE!");
				
				
	
	  }
	  
	  
	  
	 
	  
	  //Modifica una disciplina esistente
	  
	  public void modificaDisciplinaEsistente(String disciplina, String livello, String descrizione, String immagine, int cod_responsabile, int cod_istruttore, String costo,int id) 
		
	  {
		
			
			 System.out.println("SONO DENTRO LA MODIFICA");
			 //System.out.println("IN AGGIUNTA DISCIPLINA GUI L'ISTRUTTORE è:" + cod_istruttore + " e il responsabile è  " + cod_responsabile);
			 //System.out.println("IN AGGIUNTA DISCIPLINA GUI L ' IMMAGINE è:" + immagine);
			
			 DisciplinaDAO verificadisciplinanelDB = new DisciplinaDAO();
		
			
			
			System.out.println("HO DA MODIFICARE QUESTO NUMERO DI CAMPI=  "+verificadisciplinanelDB.controlloDisciplina(disciplina, livello, descrizione, immagine, cod_responsabile, cod_istruttore,costo,id).size());
			
			//PRENDE IN INGRESSO UN' ARRAY LIST DEI VALORI DA MODIFICARE ED ESEGUE LE QUERY UNA AD UNA
			
			int i=0;
			
			int lunghezza = verificadisciplinanelDB.controlloDisciplina(disciplina, livello, descrizione, immagine, cod_responsabile, cod_istruttore,costo,id).size();
			
			//System.out.println("la lunghezza di verificadisciplinaneldb è :  " + lunghezza);
			ArrayList<String> cambio = new ArrayList();
			
			while(i < lunghezza)
			{
				
				//System.out.println(i +" " + verificadisciplinanelDB.controlloDisciplina(disciplina, livello, descrizione, immagine, cod_responsabile, cod_istruttore, costo,id).get(i));
				cambio.add(verificadisciplinanelDB.controlloDisciplina(disciplina, livello, descrizione, immagine, cod_responsabile, cod_istruttore, costo,id).get(i));
				i++;
				
			}
			
			//System.out.print("   " + lunghezza +"   ");
			
			int y = 0;
			
			while(y < lunghezza )
			{
				//System.out.println("y= " + y );
				//String cambio = verificadisciplinanelDB.controlloDisciplina(disciplina, livello, descrizione, immagine, cod_responsabile, cod_istruttore,costo,id).get(y).toString();
				System.out.println("Variabile da sostituire tramite query  "+ y + "  " + cambio.get(y));
				
				if(cambio.get(y).equals("Disciplina"))
				{
					
					//System.out.println("eseguo query disciplina");
					String query = "UPDATE `disciplina` SET `Nome` = '"+disciplina+"' WHERE `disciplina`.`idDisciplina` = "+id+";";
					DbConnection.getInstance().eseguiAggiornamento(query);
					DbConnection.disconnetti();
					
				}
				
				if(cambio.get(y).equals("Livello"))
				{
					//System.out.println("Sono Dentro Livello");
					
					String query = "UPDATE `disciplina` SET `Livello` = '"+ livello+"' WHERE `disciplina`.`idDisciplina` = "+id+";";
					DbConnection.getInstance().eseguiAggiornamento(query);
					DbConnection.disconnetti();	
					

				}
				
				if(cambio.get(y).equals("Cod_Responsabile"))
				{
					//System.out.println("Sono Dentro Responsabile, eseguo query");
					String query = "UPDATE `disciplina` SET `Responsabile_Centro_Utente_Registrato_idUtente_Registrato` = '"+cod_responsabile+"' WHERE `disciplina`.`idDisciplina` = "+id+";";
					DbConnection.getInstance().eseguiAggiornamento(query);
					DbConnection.disconnetti();	
				
				}
				
				if(cambio.get(y).equals("Cod_Istruttore"))
				{
					
					
					String query = "UPDATE `disciplina` SET `Istruttore_Utente_Registrato_idUtente_Registrato` = '"+ cod_istruttore+"' WHERE `disciplina`.`idDisciplina` = "+id+";";
					DbConnection.getInstance().eseguiAggiornamento(query);
					DbConnection.disconnetti();	
				}
				
				if(cambio.get(y).equals("Costo"))
				{
					
					
					String query = "UPDATE `disciplina` SET `Costo` = '"+costo+"' WHERE `disciplina`.`idDisciplina` = "+id+";";
					DbConnection.getInstance().eseguiAggiornamento(query);
					DbConnection.disconnetti();	
				}
				
				if(cambio.get(y).equals("Descrizione"))
				{
					
					System.out.println(descrizione);
					String query = "UPDATE `disciplina` SET `Descrizione` = '"+ descrizione +"' WHERE `disciplina`.`idDisciplina` = "+id+";";
					DbConnection.getInstance().eseguiAggiornamento(query);
					DbConnection.disconnetti();	
				}
				
				//System.out.println("prima della query l'immagine è  "+ immagine);
				if(cambio.get(y).equals("Immagine"))
				{
					//System.out.println("eseguo query immagine");
					String query = "UPDATE `disciplina` SET `Immagine` = '"+immagine+"' WHERE `disciplina`.`idDisciplina` = "+id+";";
					DbConnection.getInstance().eseguiAggiornamento(query);
					DbConnection.disconnetti();	
				}
				
				//System.out.println("ciclo numero " + y);
				y++;
			}
		
		}
		
	  
	  
	  
	  
	  
	  //METODI UTILIZZATI PER VERIFICARE L'EVENTUALE PRESENZA NEL DB DI UNA DATA DISCIPLINA
	  
	
	
	  //Metodo utilizzato in fase di creazione della disciplina per verificare l'eventuale presenza nel database di una disciplina omonima dello stesso livello
	  
	  public boolean controlloDisciplinaeLivello(String nomeDisciplina, String livello) 
	    
	  {
		
		            String query = "SELECT * FROM `disciplina` WHERE `Nome` LIKE '"+nomeDisciplina+"' AND `Livello` LIKE '"+livello+"' ORDER BY `idDisciplina` ASC";
					
					if(DbConnection.getInstance().eseguiQuery(query).size() != 0)
					{
						return true;
					}
					else
					{
						return false;
					}
				
				
	    
	  }
		
		
	  //Metodo utilizzato in fase di modifica di una disciplina già esistente
	  
	  public ArrayList<String> controlloDisciplina(String disciplina, String livello, String descrizione, String immagine, int cod_responsabile, int cod_istruttore, String costo, int id) 
		
	  {
			
	 		
	   	    DisciplinaDAO letturadatidisciplina = new DisciplinaDAO();
			
			//letturadatidisciplina.getDatiDisciplina(disciplina,livello);
			
			//int COD_DISCIPLINA = Integer.parseInt(letturadatidiscipline.getDatiDisciplina(disciplina,livello).get(0)[0]);//0
			
			String NOMEDISCIPLINA = new String();
			
			NOMEDISCIPLINA = letturadatidisciplina.getDatiDisciplinaFromId(id).get(0)[1];//1
			
			String LIVELLO = new String();
			
			LIVELLO = letturadatidisciplina.getDatiDisciplinaFromId(id).get(0)[2];//2
			
			String DESCRIZIONE = new String();
			DESCRIZIONE = letturadatidisciplina.getDatiDisciplinaFromId(id).get(0)[3];//3
			
			String NOMEIMMAGINE = new String();
			
			NOMEIMMAGINE = letturadatidisciplina.getDatiDisciplinaFromId(id).get(0)[4];//4
			
			String COSTO = letturadatidisciplina.getDatiDisciplinaFromId(id).get(0)[5];//5
			
			int COD_ISTRUTTORE = Integer.parseInt(letturadatidisciplina.getDatiDisciplinaFromId(id).get(0)[6]);//6
			
			//RicavaNomeUtente ricavaistruttore = new RicavaNomeUtente();
			
			//String NOMEISTRUTTORE = ricavaistruttore.getNomeUtente(COD_ISTRUTTORE).get(0)[0] + " " + ricavaistruttore.getNomeUtente(COD_ISTRUTTORE).get(0)[1];
			
			int COD_RESPONSABILE= Integer.parseInt(letturadatidisciplina.getDatiDisciplinaFromId(id).get(0)[7]);//7
			
			//RicavaNomeUtente ricavaResponsabile = new RicavaNomeUtente();
			
			//String NOMERESPONSABILE = ricavaResponsabile.getNomeUtente(COD_RESPONSABILE).get(0)[0] + " " + ricavaResponsabile.getNomeUtente(COD_RESPONSABILE).get(0)[1];
			
			ArrayList<String> r = new ArrayList();
			//System.out.println("Sono in Verificadisciplinaesistente");
			
			//System.out.println("NOMEDISCIPLINA: " + NOMEDISCIPLINA);
			//System.out.println("nomedisciplina" + disciplina);
			
			if(NOMEDISCIPLINA.equals(disciplina) != true)
			{	
				//System.out.println("disciplina cambia");
				String a = new String();
				a = "Disciplina";
				r.add(a);
				
			}
			//System.out.println("LIVELLO: " + LIVELLO);
			//System.out.println("livello " + livello);
			
			if(LIVELLO.equals(livello) != true)
			{
				//System.out.println("Livello cambia");
				String a = new String();
				a = "Livello";
				r.add(a);
			}
			//System.out.println("RESPONSABILE nel database =  " + COD_RESPONSABILE);
			//System.out.println("responsabile prelevato= " + cod_responsabile);
			if(COD_RESPONSABILE != cod_responsabile)
			{
				
				//System.out.println("Respo cambia");
				String a = new String();
				a = "Cod_Responsabile";
				r.add(a);
			}
			//System.out.println("ISTRUTTORE:" + COD_ISTRUTTORE);
			//System.out.println("istruttore" +cod_istruttore);
			if(COD_ISTRUTTORE != cod_istruttore)
			{
				//System.out.println("istru cambia");
				String a = new String();
				a = "Cod_Istruttore";
				r.add(a);
			}
			//System.out.println("COSTO:" + COSTO);
			//System.out.println("Costo" +costo);
			if(COSTO.equals(costo) != true)
			{
				//System.out.println("costo cambia");
				String a = new String();
				a = "Costo";
				r.add(a);
				
				
			}
			
			//System.out.println("DESCRIZIONE:" + DESCRIZIONE);
			//System.out.println("descrizione" +descrizione);
			
			if(DESCRIZIONE.equals(descrizione) != true)
			{
				//System.out.println("descriz cambia");
				String a = new String();
				a = "Descrizione";
				r.add(a);
			}
			
			//System.out.println( "Il nome dell' IMMAGINE è : "+NOMEIMMAGINE);
			//System.out.println( "Il nome dell' immagine è : "+ immagine);
			
			if(NOMEIMMAGINE.equals(immagine) != true)
			{
				//System.out.println("immagine cambia");
				String a = new String();
				a = "Immagine";
				r.add(a);
			}
			
			return r;
			
	  }
	  
	  
	  
	  
	  
	  //METODI UTILIZZATI PER VERIFICARE L'EVENTUALE PRESENZA NEL DB DELLA RICHIESTA DI ISCRIZIONE AD UNA LEZIONE DI UNA DATA DISCIPLINA
	  
	  public boolean verificaRichiestaIscrizioneDisciplina(int idDisc, int idTess)
	  {
		  
		    String query = "SELECT * FROM `iscrizione_disciplina` WHERE Tesserato_Utente_Registrato_idUtente_Registrato = '"+idTess+"' AND Disciplina_idDisciplina = '"+idDisc+"'";
		    DbConnection.getInstance().eseguiQuery(query);
		    DbConnection.disconnetti();	
		    if(DbConnection.getInstance().eseguiQuery(query).size() != 0)
			{
				return true;
			}
			else
			{
				return false;
			}
		  
	  }
	  
	  
		
	  
	  
	  
	  
	  //METODO UTILIZZATO PER VERIFICARE L'EVENTUALE PRESENZA NEL DB DI UNA DATA IMMAGINE
	  
	  public boolean verificaImmagine(String nomeimmagine)
		
	  {
			
			String query = "SELECT Nome FROM `disciplina` WHERE Immagine='"+nomeimmagine+"'";
			
			
			if(DbConnection.getInstance().eseguiQuery(query).size() > 0) 
			{
				
				DbConnection.disconnetti();	
				return true;
			}
			else
			{
				DbConnection.disconnetti();	
				return false;
				
			}
			
	  }
	  
	  
	  
	  
	  //METODI CHE PERMETTONO AD UN TESSERATO DI EFFETTUARE L'ISCRIZIONE AD UNA LEZIONE DI UNA DETERMINATA DISCIPLINA
	  
	  
	  
	  /*Metodo tramite il quale viene aggiunta una nuova tupla alla tabella iscrizione_disciplina, con Stato = "Negato" e StatoPagamento = "Non pagato", cioè 
	    tramite il quale il tesserato richiede l'iscrizione alla lezione */
	  
	  public void setIscrizioneTesserato( int id, int idDisc, int idLez, String modPag)
	  
	  {
				
			String query = "INSERT INTO `iscrizione_disciplina` (`Tesserato_Utente_Registrato_idUtente_Registrato`, `Disciplina_idDisciplina`, `IdLezione`, `Stato`, `StatoPagamento`, `ModalitàPagamento`) VALUES ('"+id+"', '"+idDisc+"', '"+idLez+"', 'Negato', 'Non pagato', '"+modPag+"');";
			DbConnection.getInstance().eseguiAggiornamento(query);
			DbConnection.disconnetti();
				
	  }
	  
	  
	  
	  
	  /*Metodo tramite il quale il responsabile del centro cambia il valore del campo StatoPagamento da "Non pagato" a "Pagato", 
	   *cioè conferma l'avvenuto pagamento */
	  
		public void setStatoPagamento (int id, int idLezione)
		
	  {
			
		    String query = "UPDATE `iscrizione_disciplina` SET `StatoPagamento` = 'Pagato' WHERE `iscrizione_disciplina`.`Tesserato_Utente_Registrato_idUtente_Registrato` = '"+id+"' AND `iscrizione_disciplina`.`IdLezione`  = '" + idLezione +"'";
            DbConnection.getInstance().eseguiAggiornamento(query);
		    DbConnection.disconnetti();
			
	  }
	  
		
	  
		
	  /*Metodo tramite il quale l'istruttore che gestisce la disciplina cambia il valore del campo Stato da "Negato" a "Accettato", 
	   *cioè conferma definitivamente l'iscrizione del tesserato alla lezione*/
		  
	  public void setIscrizione(int id, int idLezione)
		
	  {
			
			
			String query = "UPDATE `iscrizione_disciplina` SET `Stato` = 'Accettato' WHERE `iscrizione_disciplina`.`Tesserato_Utente_Registrato_idUtente_Registrato` = '" + id + "' AND `iscrizione_disciplina`.`IdLezione` = '" + idLezione + "'";
			DbConnection.getInstance().eseguiAggiornamento(query);
			DbConnection.disconnetti();
			
			
	  }
	  
	  

	  
	  
	  //METODO UTILIZZATO PER CANCELLARE L'ISCRIZIONE DI UN TESSERATO AD UN DETERMINATO TURNO
		
	  public void cancellaTurno(int idTesserato, int idLEz)
		
	  {
		
		    String query = "DELETE iscrizione_disciplina FROM iscrizione_disciplina WHERE IdLezione='"+idLEz+"' AND Tesserato_Utente_Registrato_idUtente_Registrato='"+ idTesserato+"'";
		    DbConnection.getInstance().eseguiAggiornamento(query);
	        DbConnection.disconnetti();
	        
		
	  }

	  
	  
	  
	  
	  
	  //METODO UTILIZZATO PER ELIMINARE UNA DISCIPLINA 
	  
	  public void eliminaDisciplina(String nomedisciplina,String livello)
	  
	  {
				
				//RICAVA ID DISCIPLINA 
				
		        DisciplinaDAO ricavoid = new DisciplinaDAO();
				int idDisc = Integer.parseInt((ricavoid.getIdDisciplinafromNameandLivello(nomedisciplina, livello).get(0)[0]));
			
				
				//ELIMINA ISCRITTI ALLA DISCIPLINA
				
				String query1 = "DELETE iscrizione_disciplina FROM `iscrizione_disciplina` WHERE Disciplina_idDisciplina ="+idDisc+"";
				
				DbConnection.getInstance().eseguiAggiornamento(query1);
				
				DbConnection.disconnetti();
				
				System.out.println("query1 ok : ELIMINA ISCRITTI ALLA DISCIPLINA");
				
				//ELIMINA ISCRITTI AD EVENTI DELLA DISCIPLINA
				
			    EventoDAO evento = new EventoDAO();
				
				for(int i =0; i< evento.getidEventifromidDisciplina(idDisc).size();i++)
				{
					
					//QUERY CHE ELIMINA LE ISCRIZIONI AD EVENTI
					
					int idEvento = Integer.parseInt((evento.getidEventifromidDisciplina(idDisc).get(i)[0]));
					
					String query2 = "DELETE iscrizione_evento FROM `iscrizione_evento` WHERE Evento_idEvento = '"+idEvento+"'";
					
					DbConnection.getInstance().eseguiAggiornamento(query2);
					DbConnection.disconnetti();
					
					System.out.println("query2 ok :  ELIMINA ISCRITTI AD EVENTI DELLA DISCIPLINA");
				}
				
				
				
				
				String query3 = "DELETE evento FROM `evento` WHERE Disciplina_idDisciplina='"+idDisc+"'";
				
				DbConnection.getInstance().eseguiAggiornamento(query3);
				
				DbConnection.disconnetti();
			
				System.out.println("query3 ok :  ELIMINA EVENTI DELLA DISCIPLINA");
				
				
				//ELIMINA EVENTI DELLA DISCIPLINA
				
				String query4 = "DELETE evento FROM `evento` WHERE Disciplina_idDisciplina='"+idDisc+"'";
			
				DbConnection.getInstance().eseguiAggiornamento(query4);
				
				DbConnection.disconnetti();
			
				System.out.println("query4 ok :  ELIMINA EVENTI DELLA DISCIPLINA");
				
				//ELIMINA LEZIONI DELLA DISCIPLINA
				
				String query5 = "DELETE lezione FROM `lezione` WHERE Disciplina_idDisciplina='"+idDisc+"'";
			
				DbConnection.getInstance().eseguiAggiornamento(query5);
				
				DbConnection.disconnetti();
				System.out.println("query5 ok: ELIMINA LEZIONI DELLA DISCIPLINA");
				
				
				//ELIMINA DISCIPLINA
				
				String query6 = "DELETE FROM `disciplina` WHERE Nome LIKE '"+ nomedisciplina+"' AND Livello LIKE '"+livello+"'";
					
				DbConnection.getInstance().eseguiAggiornamento(query6);
				
				DbConnection.disconnetti();
				System.out.println("query6 ok: ELIMINA LA DISCIPLINA");
		
		}

	
		
		
		
	
		
		
	   
	   	
}



