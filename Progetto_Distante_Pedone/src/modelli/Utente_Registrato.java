package modelli;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class Utente_Registrato extends Utente_Generico
{
	public  Utente_Registrato(String nome,String cognome, int id ,String password,int et�,String ruolo, String accessoeffettuato , String telefono)
	{
		setNome(nome);
		setCognome(cognome);
		setId(id);
		setPassword(password);
		setEt�(et�);
		setTelefono(telefono);
		setruoloutente(ruolo);
		setAccessoeffettuato(accessoeffettuato);
		
		
		
	}
	

}
