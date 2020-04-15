package it.unisalento.dao;

public class ResponsabileDAO {
	
	private static ResponsabileDAO instance;
	
	public static synchronized ResponsabileDAO getInstance(){
		if(instance == null){
			instance = new ResponsabileDAO();
		}
		return instance;
	}

}
