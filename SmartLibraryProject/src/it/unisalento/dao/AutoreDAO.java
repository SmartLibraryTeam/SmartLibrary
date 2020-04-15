package it.unisalento.dao;

public class AutoreDAO {
	
	private static AutoreDAO instance;
	
	public static synchronized AutoreDAO getInstance(){
		if(instance == null){
			instance = new AutoreDAO();
		}
		return instance;
	}

}
