package it.unibs.ing.fp.groupX.medagliere;

/**
 * Rappresenta una nazione
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
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
	
	/**
	 * Verifica l'uguaglianza tra due nazioni (case insensitive)
	 * @param n Altra nazione
	 * @return true: stessa nazione false: nazione diversa
	 */
	@Override
	public boolean equals (Object o)
	{
		Nazione n = (Nazione)o;
		if (n.getNome().equalsIgnoreCase(this.getNome()))
			return true;
		else
			return false;
	}
}
