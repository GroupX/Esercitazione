package it.unibs.ing.fp.groupX.esercitazioni;

import it.unibs.ing.fp.groupX.myutil.Durata;

/**
 * Classe che descrive un brano
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 */
public class Brano
{
	/** Titolo del brano */
	private String title;
	/** Durata del brano*/
	private Durata lenght;
	
	/**
	 * Costruttore che inizializza il titolo e la durata del brano
	 * @param title Titolo del brano
	 * @param lenght Durata del brano
	 */
	public Brano (String title, Durata lenght) 
	{
		this.title = title;
		this.lenght = lenght;
	}
	
	/**
	 * Metodo che restituisce una stringa descrittiva (titolo del brano e sua durata)
	 * @return Descrizione basilare del brano
	 */
	@Override
	public String toString ()
	{
		String strn = " Titolo: " + title + "\n Durata: " + lenght.toString() + "\n";
		
		return strn;
	}
	
	/**
	 * Ritorna il titolo del brano
	 * @return Titolo del brano
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Ritorna la lunghezza del brano
	 * @return Lunghezza del brano
	 */
	public Durata getLenght()
	{
		return lenght;
	}
	
	/**
	 * Controlla se la stringa passata è uguale (no case-sensitive) al titolo del brano
	 * @param title 
	 * 			Stringa da confrontare con il titolo
	 * @return <b>true</b> se uguale (no case-sensitive), <b>false</b> altrimenti
	 */
	public boolean isTitle (String title)
	{
		if (this.title.equalsIgnoreCase (title))
			return true;
		return false;
	}
}
