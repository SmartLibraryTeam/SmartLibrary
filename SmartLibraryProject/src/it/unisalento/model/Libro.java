package it.unisalento.model;

public class Libro {
	
	//Attributi classe Libro
	private String isbn;
	private String titolo;
	private String genere;
	private int anno_pubblicazione;
	private String descrizione;
	
	//Costruttore Libro
	public Libro(String isbn, String titolo, String genere, int anno_pubblicazione, String descrizione) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.genere = genere;
		this.anno_pubblicazione = anno_pubblicazione;
		this.descrizione = descrizione;
	}
	
	//Getter - Setter classe libro
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
	}
	public int getAnno_pubblicazione() {
		return anno_pubblicazione;
	}
	public void setAnno_pubblicazione(int anno_pubblicazione) {
		this.anno_pubblicazione = anno_pubblicazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	//Ulteriori metodi da implementare
	
	
	
	

}
