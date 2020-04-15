package it.unisalento.model;

public class Scritto_da {
	
	private int id_autore;
	private String id_libro;
	
	
	
	//Costruttore Scritto_da
	public Scritto_da(int id_autore, String id_libro) {
		super();
		this.id_autore = id_autore;
		this.id_libro = id_libro;
	}
	//Getter - Setter 
	
	public int getId_autore() {
		return id_autore;
	}
	public void setId_autore(int id_autore) {
		this.id_autore = id_autore;
	}
	public String getId_libro() {
		return id_libro;
	}
	public void setId_libro(String id_libro) {
		this.id_libro = id_libro;
	}
	
	
	//Ulteriori metodi  
	

}
