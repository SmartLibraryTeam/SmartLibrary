package it.unisalento.dao;

public class LibroDAO {
	
	private static LibroDAO instance;
	
	public static synchronized LibroDAO getInstance(){
		if(instance == null){
			instance = new LibroDAO();
		}
		return instance;
	}

}
