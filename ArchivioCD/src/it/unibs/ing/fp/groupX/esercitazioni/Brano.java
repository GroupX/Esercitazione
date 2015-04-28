package it.unibs.ing.fp.groupX.esercitazioni;

public class Brano
{
	/** Titolo del brano */
	private String title;
	/** Durata del brano*/
	private String lenght;
	
	/**
	 * Costruttore che inizializza il titolo e la durata del brano
	 * @param title Titolo del brano
	 * @param lenght Durata del brano
	 */
	public Brano (String title, String lenght) 
	{
		this.title = title;
		this.lenght = lenght;
	}
	
	/**
	 * Metodo che restituisce una stringa descrittiva (titolo del brano e sua durata)
	 * @return Descrizione basilare del brano
	 */
	public String toString ()
	{
		String strn = " Titolo: " + title + "\n Durata: " + lenght + "\n";
		
		return strn;
	}
}
