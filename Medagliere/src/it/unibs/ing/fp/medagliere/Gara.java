package it.unibs.ing.fp.medagliere;

/**
 * Classe che descrive una gara
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Gara
{
	/** Formato della stringa generata dal metodo <i>toString()</i> */
	private final static String TO_STRING_FORMAT = "%s: %s";
	
	/** Nome della gara */
	private String nome;
	
	/** Risultato della gara */
	private Risultato ris;
	/**
	 * Costruttore che inizializza il nome della gara
	 * @param nome Nome della gara
	 * @param ris Risultato della gara
	 */
	public Gara (String nome)
	{
		this.nome = nome;
		this.ris = null;
	}
	
	/**
	 * Metodo che restituisce una stringa descrittiva (nome della gara e risultato, se non presente il risultato è nullo)
	 * @return Descrizione basilare della gara
	 * 
	 */
	public String toString()
	{
		return String.format (TO_STRING_FORMAT, nome, ris);
	}
	
	/**
	 * Ritorna il nome della gara
	 * @return Nome della gara
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * Ritorna il risultato della gara
	 * @return Risultato della gara
	 */
	public Risultato getRis()
	{
		return ris;
	}
	
	/**
	 * Verifica l'uguaglianza tra due gare (case insensitive)
	 * @param n Altra gara
	 * @return true: stessa gara false: gara diversa
	 */
	@Override
	public boolean equals (Object o)
	{
		Gara g = (Gara)o;
		if(g.getNome().equalsIgnoreCase(this.getNome()))
			return true;
		else
			return false;
	}
	
	public boolean setRisultato (Risultato result)
	{
		if(ris == null)
		{
			this.ris = result;
			return true;
		}
		else
		{
			return false;
		}
	}
}