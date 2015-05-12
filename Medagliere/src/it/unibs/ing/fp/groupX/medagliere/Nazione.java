package it.unibs.ing.fp.groupX.medagliere;

/**
 * Rappresenta una nazione
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Nazione
{
	private final static String SEPARATOR_NAME = " ";
	private final static int FIRST_LETTER_NAME = 0;
	
	private String nome;
	
	/**
	 * Costruttore con il nome
	 * @param nome Nome della nazione
	 */
	public Nazione (String nome)
	{
		String[] disjointedName = nome.split (SEPARATOR_NAME);
		StringBuffer finalName = new StringBuffer();
		
		for (String piece : disjointedName)
		{
			finalName.append (Character.toUpperCase (piece.charAt (FIRST_LETTER_NAME)) + piece.substring (FIRST_LETTER_NAME+1) + SEPARATOR_NAME);
		}
		
		finalName.deleteCharAt (finalName.length ()-1);
		
		this.nome = finalName.toString ();
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
	
	/**
	 * Ritorna la rappresentazione testuale della classe
	 * 
	 * @return testo rappresentante la classe
	 */
	@Override
	public String toString ()
	{
		return getNome();
	}
}
