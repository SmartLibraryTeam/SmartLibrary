package modelli;

public class IscrizioneDisciplina 
{
	public String NomeDisciplina;
	public String Livello;
	public String Giorno;
	public String Ora;
	public String Modalit‡Pagamento;
	public int idDisc;
	public int idLez;
	
	
	public void setnomeDisciplina(String nome)
	{
		
		this.NomeDisciplina = nome;
	}
	public String getnomeDisciplina() 
	{
		return NomeDisciplina;
	}
	public void setLivello(String livello)
	{
		
		this.Livello = livello;
	}
	public String getLivello() 
	{
		return Livello;
	}
	
	public void setGiorno(String giorno)
	{
		
		this.Giorno = giorno;
	}
	public String getGiorno()
	{
		return Giorno;
	}
	
	public void setOra(String ora)
	{
		
		this.Ora = ora;
	}
	public String getOra()
	{
		return Ora;
	}
	
	public void setIdDisc(int id)
	{
		
		this.idDisc = id;
	}
	public int getIdDisc()
	{
		return idDisc;
	}
	
	public void setIdLez(int id1)
	{
		
		this.idLez = id1;
	}
	public int getIdLez()
	{
		return idLez;
	}
	
	public void setModalit‡Pagamento(String modalit‡)
	{
		
		this.Modalit‡Pagamento = modalit‡;
	}
	public String getModalit‡Pagamento()
	{
		return Modalit‡Pagamento;
	}
	

}
