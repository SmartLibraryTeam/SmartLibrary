package it.unisalento.model;

public class Copia {
	private int cod_copia;
	private float prezzo;
	private String id_libro;
	private int id_biblioteca;
	private int id_responsabile;
	private String scaffale;
	private String ripiano;
	private String posizione;
	public Copia(int cod_copia, float prezzo, String id_libro, int id_biblioteca, int id_responsabile, String scaffale,
			String ripiano, String posizione) {
		super();
		this.cod_copia = cod_copia;
		this.prezzo = prezzo;
		this.id_libro = id_libro;
		this.id_biblioteca = id_biblioteca;
		this.id_responsabile = id_responsabile;
		this.scaffale = scaffale;
		this.ripiano = ripiano;
		this.posizione = posizione;
	}
	public int getCod_copia() {
		return cod_copia;
	}
	public void setCod_copia(int cod_copia) {
		this.cod_copia = cod_copia;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public String getId_libro() {
		return id_libro;
	}
	public void setId_libro(String id_libro) {
		this.id_libro = id_libro;
	}
	public int getId_biblioteca() {
		return id_biblioteca;
	}
	public void setId_biblioteca(int id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}
	public int getId_responsabile() {
		return id_responsabile;
	}
	public void setId_responsabile(int id_responsabile) {
		this.id_responsabile = id_responsabile;
	}
	public String getScaffale() {
		return scaffale;
	}
	public void setScaffale(String scaffale) {
		this.scaffale = scaffale;
	}
	public String getRipiano() {
		return ripiano;
	}
	public void setRipiano(String ripiano) {
		this.ripiano = ripiano;
	}
	public String getPosizione() {
		return posizione;
	}
	public void setPosizione(String posizione) {
		this.posizione = posizione;
	}
	
	

}
