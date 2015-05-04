package it.unibs.ing.fp.groupX.esercitazioni;

import java.util.Vector;

public class ArchivioCD
{
	/** Titolo dell'archivio dei CD */
	private String title;
	/** Collezione dei CD in archivio */
	private Vector<CD> collection;
	
	/**
	 * Costruttore con titolo come parametro
	 * @param title
	 * 			Titolo dell'archivio
	 */
	public ArchivioCD (String title)
	{
		this.title = title;
		collection = new Vector<CD>();
	}
	
	/**
	 * Costruttore con titolo e CDs come parametri
	 * @param title
	 * 			Titolo dell'archivio
	 * @param disk
	 * 			Sequenza di CD da mettere nella collezione
	 */
	public ArchivioCD (String title, CD ... disk)
	{
		this(title);
		for (CD d : disk)
		{
			collection.add (d);
		}
	}
	
	/**
	 * Inserisci un CD (controlla che il titolo sia univoco)
	 * @param disk
	 * 			Disco da inserire
	 */
	public boolean addCD (CD disk)
	{
		if ( !collection.contains (disk) )
		{
			collection.add(disk);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Rimuove l'ultimo CD inserito
	 */
	public void removeLastCD ()
	{
		collection.remove (collection.size ()-1);
	}
	
	/**
	 * Rimuove il CD di indice <i>index</i>
	 * @param index
	 * 			Indice del CD da rimuovere
	 */
	public void removeCD (int index)
	{
		collection.remove (index);
	}
	
	public void searchTitleCD (String title)
	{
		
	}
}
