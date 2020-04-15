package DbConnection;

import java.sql.*;
import java.util.Vector;




public class DbConnection {
	
	private static String url = "jdbc:mysql://127.0.0.1/";
	public static Connection db;
	public static boolean connesso;
	public static DbConnection instance;
	@SuppressWarnings("unused")
	private int numero;
	
	
	
	
	public static DbConnection getInstance() {
		if(instance == null)
			instance = new DbConnection();
		if(connesso != true)
				connetti("database", "root", "");
			return instance;
	}

	public static boolean connetti (String nomeDB, String nomeUtente, String pwdUtente)
{
	connesso = false;
	
try {
Class.forName("com.mysql.jdbc.Driver");
db = DriverManager.getConnection(url + nomeDB + "?user=" + nomeUtente + "&password=" + pwdUtente);
connesso=true;
   } catch (Exception e) {
	    	  e.printStackTrace(); 
	     }
	      return connesso;
	   }

// Esegue una query di selezione dati sul Database
// ritorna un Vector contenente tutte le tuple del risultato
	  public Vector<String[]> eseguiQuery(String query) {
	      Vector<String[]> v = null;
	      String [] record;
	      int colonne = 0;
	      try {
	         Statement stmt = db.createStatement();     // Creo lo Statement per l'esecuzione della query
	         ResultSet rs = stmt.executeQuery(query);   // Ottengo il ResultSet dell'esecuzione della query
	         v = new Vector<String[]>();
	         ResultSetMetaData rsmd = rs.getMetaData();
	         colonne = rsmd.getColumnCount();

	         while(rs.next()) {   // Creo il vettore risultato scorrendo tutto il ResultSet
	            record = new String[colonne];
	            for (int i=0; i<colonne; i++) record[i] = rs.getString(i+1);
	            v.add( (String[]) record.clone() );
	         }
	         rs.close();     // Chiudo il ResultSet
	         stmt.close();   // Chiudo lo Statement
	      } catch (Exception e) { e.printStackTrace(); }

	      return v;
	   }
	   
	  
			
		  
	

	   // Esegue una query di aggiornamento sul Database
	   // query: una stringa che rappresenta un'istuzione SQL di tipo UPDATE da eseguire
	   // ritorna TRUE se l'esecuzione � adata a buon fine, FALSE se c'� stata un'eccezione
	   public boolean eseguiAggiornamento(String query) {
	      numero = 0;
	      boolean risultato = false;
	      try {
	         Statement stmt = db.createStatement();
	         numero = stmt.executeUpdate(query);
	         risultato = true;
	         stmt.close();
	      } catch (Exception e) {
	         e.printStackTrace();
	         risultato = false;
	      }
	      return risultato;
	   }

	   // Chiude la connessione con il Database
	   public static void disconnetti() {
	      try {
	         db.close();
	         connesso = false;
	      } catch (Exception e) { e.printStackTrace(); }
	   }

	  
	  
	
}
