package it.unibs.ing.fp.groupX.medagliere;

/**
 * Classe che descrive una gara
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Gara
{
	/** Nome della gara */
	private String nome;
	
	/**
	 * Costruttore che inizializza il nome della gara
	 * @param nome Nome della gara
	 */
	public Gara (String nome)
	{
		this.nome = nome;
	}
	
	/**
	 * Metodo che restituisce una stringa descrittiva (nome della gara)
	 * @return Nome della gara inserita
	 */
	public String toString()
	{
		String strng = nome;
		
		return strng;
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
	 * Controlla se la stringa inserita è uguale (no case-sensitive) al nome della gara
	 * @param nome Stringa da confrontare con il nome della gara
	 * @return <b>true</b> se uguale (no case-sensitive), <b>false</b> altrimenti
	 */
	public boolean isNome (String nome)
	{
		if (this.nome.equalsIgnoreCase(nome))
			return true;
		return false;
	}
}
