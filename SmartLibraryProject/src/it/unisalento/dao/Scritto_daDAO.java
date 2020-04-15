package it.unisalento.dao;

public class Scritto_daDAO {
	
	private static Scritto_daDAO instance;
	
	public static synchronized Scritto_daDAO getInstance(){
		if(instance == null){
			instance = new Scritto_daDAO();
		}
		return instance;
	}

}
