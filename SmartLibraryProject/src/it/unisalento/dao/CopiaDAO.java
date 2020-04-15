package it.unisalento.dao;

public class CopiaDAO {
	
	private static CopiaDAO instance;
	
	public static synchronized CopiaDAO getInstance(){
		if(instance == null){
			instance = new CopiaDAO();
		}
		return instance;
	}

}
