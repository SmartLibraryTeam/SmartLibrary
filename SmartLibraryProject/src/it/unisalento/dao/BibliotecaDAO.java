package it.unisalento.dao;

public class BibliotecaDAO {
	
	private static BibliotecaDAO instance;
	
	public static synchronized BibliotecaDAO getInstance(){
		if(instance == null){
			instance = new BibliotecaDAO();
		}
		return instance;
	}

}
