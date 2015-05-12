package it.unibs.ing.fp.groupX.medagliere;

public class Nazione
{
	String nome;
	
	/**
	 * Costruttore con il nome
	 * @param nome Nome della nazione
	 */
	public Nazione (String nome)
	{
		this.nome = nome;
	}
	
	/**
	 * Ritorna il nome della gare
	 * @return
	 */
	public String getNome ()
	{
		return nome;
	}
}
