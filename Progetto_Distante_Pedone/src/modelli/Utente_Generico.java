package modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Utente_Generico
{
	//PARAMETRI UTENTE GENERICO
		private String nome;
		private String cognome;
		private int id;
		private String password;
		private int età;
		private String ruolo;
		private String accessoeffettuato;
		private String telefono;
		
		//COSTRUTTORE Utente_Generico
		public Utente_Generico()
		{
			int id = 0;
		}
		;
		
		//METODI UTENTE GENERICO
		
		//Restituisce nome
		public String getNome() 
		{
			
			return nome;
		}
		
		//Assegna nome utente
		public void setNome(String nome) 
		{
			this.nome = nome;
		}
		
		
		//Restituisce Cognome
		public String getCognome() 
		{
			return cognome;
		}
		
		//Assegna Cognome
		public void setCognome(String cognome) 
		{
			this.cognome = cognome;
		}
		
		//Restituisce Id
		public int getId() 
		{
			return id ;
		}
		
		//Assegna Id
		public void setId(int id)
		{
			this.id = id;
		}
		
		//Restituisce Pass
		public String getPassword() 
		
		{
			return password;
		}
		
		//Assegna Pass
		public void setPassword(String password)
		{
			
			this.password = password;
		}
		
		//Restituisce età
		public int getEtà() 
		{
			return età;
		}
		
		//Assegna età
		public void setEtà(int età)
		{
			this.età = età;
	 	}

		//Ritonra il ruolo utente
		public String getruoloutente() 
		{
			return ruolo;
		}
			
		//Assegna il ruolo
		public void setruoloutente(String ruolo) 
		{
			this.ruolo = ruolo;
		}
			
		//Ritorna se l'accesso è effettuato
		public String isAccessoeffettuato()
		{
			return accessoeffettuato;
		}
		
		//Assegna valore all'accesso
		public void setAccessoeffettuato(String accessoeffettuato) 
		{
			this.accessoeffettuato = accessoeffettuato;
		}
		
		//Restituisce telefono
		public String getTelefono() 
		{
			return telefono;
		}
				
		//Assegna telefono
				
		public void setTelefono(String telefono)
		{
			this.telefono = telefono;
		}

		//Preleva ID di Login dall'utente generico
		public int getIDLogin()
		{

			Scanner valore = new Scanner(System.in); //costruttore valore
			System.out.println("Inserisci ID:");
			int ID = valore.nextInt();
			return ID;
		}	
		
		//preleva PASSWORD di login dall'utente generico
		public String getPASSWORDLogin() 
		{
			Scanner valore2 = new Scanner(System.in);
			System.out.println("Inserisci PASS:");
			String PASSWORD = valore2.nextLine();
			return PASSWORD;
			
		}
		
		
	//metodo generazione nuovo id
 	public int generatenewId() 
	{
 		try
		{
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch(ClassNotFoundException e) //eccezione utilizzat per verificare l'acceso al db
		{
			e.printStackTrace();
			//return false;
		}
	
		String jdbcURL = "jdbc:mysql://localhost/mydb?user=root&password=";
	
		try 
		{
			//APERTURA
			Connection conn =DriverManager.getConnection(jdbcURL);
			
			//CODICE
			
			//creiamo una Statement
			
			Statement st = conn.createStatement();
			
			String sql = "SELECT MAX(idUtente_Registrato) FROM `utente_registrato`";
			
			ResultSet rs =  st.executeQuery(sql);
			
			rs.next();
			int id = rs.getInt(1);
			
			//System.out.print(id);
			
			conn.close();
			return id;
		
		}
		catch(SQLException e) //eccezione utilizzata per verificare il corretto funzionamento della query
		{
			e.printStackTrace();
			return 0;
			
		}
		
	}
 	
 	
 
}
