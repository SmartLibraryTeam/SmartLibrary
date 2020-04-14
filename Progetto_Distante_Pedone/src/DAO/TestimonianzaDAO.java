package DAO;

import java.util.Vector;

import DbConnection.DbConnection;

public class TestimonianzaDAO 
{
    
	 //PARAMETRI 
	
	 Vector<String[]> t;
	   
	
	 //METODI
     
	 
	 
	 
	 //METODO CHE RESTITUISCE TUTTE LE TESTIMONIANZE DEI TESSERATI CHE RIGUARDANO UNA DATA DISCIPLINA
	 
	 public Vector<String[]> getTestimonianze(int idDisc)

     {
	
	     String query ="SELECT * FROM `testimonianze` WHERE `idDisciplina` = "+idDisc+"";
         t = DbConnection.getInstance().eseguiQuery(query);
	     DbConnection.disconnetti();
	
	     return t;

     }
	 

	 
	 
	 
	 
	 //METODO UTILIZZATO PER AGGIUNGERE UNA NUOVA TESTIMONIANZA AL DB
	 
	 public void createTestimonianza(int id, int idDisc, String Testimonianza, int voto)
		
	 {
			
			
			

			String query2 = "INSERT INTO `testimonianze` ( `Tesserato`, `idDisciplina`, `Testimonianza`, `Voto`) VALUES ( '"+id+"', '"+idDisc+"', '"+Testimonianza+"', '"+voto+"');";
			
			DbConnection.getInstance().eseguiAggiornamento(query2);
			
			DbConnection.disconnetti();
			
			
		
	 }
	 

}

