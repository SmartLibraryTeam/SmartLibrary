package it.unisalento.model;

public class Biblioteca {
	private int cod_biblioteca;
	private String nome;
	private String aula;
	
	public Biblioteca(int cod_biblioteca, String nome, String aula) {
		super();
		this.cod_biblioteca = cod_biblioteca;
		this.nome = nome;
		this.aula = aula;
	}

	public int getCod_biblioteca() {
		return cod_biblioteca;
	}

	public void setCod_biblioteca(int cod_biblioteca) {
		this.cod_biblioteca = cod_biblioteca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}
	
	
}
