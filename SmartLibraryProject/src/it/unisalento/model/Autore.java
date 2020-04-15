package it.unisalento.model;

public class Autore {
	private int cod_autore;
	private String nome;
	private String cognome;
	private String data;
	private String nazionalita;
	
	public Autore(int cod_autore, String nome, String cognome, String data, String nazionalita) {
		super();
		this.cod_autore = cod_autore;
		this.nome = nome;
		this.cognome = cognome;
		this.data = data;
		this.nazionalita = nazionalita;
	}

	public int getCod_autore() {
		return cod_autore;
	}

	public void setCod_autore(int cod_autore) {
		this.cod_autore = cod_autore;
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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}
	
	

}
