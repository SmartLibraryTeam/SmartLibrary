package it.unisalento.model;

public class Responsabile {
	
	//attributi classe
	private int cod_utente;
	private String nome;
	private String cognome;
	private String mail;
	private String codice_fiscale;
	private int id_biblioteca;
	
	//Costruttore Responsabile
	public Responsabile(int cod_utente, String nome, String cognome, String mail, String codice_fiscale,
			int id_biblioteca) {
		super();
		this.cod_utente = cod_utente;
		this.nome = nome;
		this.cognome = cognome;
		this.mail = mail;
		this.codice_fiscale = codice_fiscale;
		this.id_biblioteca = id_biblioteca;
	}
	
	//Getter-Setter
	public int getCod_utente() {
		return cod_utente;
	}
	public void setCod_utente(int cod_utente) {
		this.cod_utente = cod_utente;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCodice_fiscale() {
		return codice_fiscale;
	}
	public void setCodice_fiscale(String codice_fiscale) {
		this.codice_fiscale = codice_fiscale;
	}
	public int getId_biblioteca() {
		return id_biblioteca;
	}
	public void setId_biblioteca(int id_biblioteca) {
		this.id_biblioteca = id_biblioteca;
	}
	
	//ulteriori metodi da implementare
	

}
