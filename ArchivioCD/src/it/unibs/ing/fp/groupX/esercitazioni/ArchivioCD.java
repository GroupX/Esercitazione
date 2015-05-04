package it.unibs.ing.fp.groupX.esercitazioni;

import it.unibs.ing.fp.groupX.myutil.IOLib;

import java.util.Random;
import java.util.Vector;

public class ArchivioCD
{
	/** Titolo dell'archivio dei CD */
	private String title;
	/** Collezione dei CD in archivio */
	private Vector<CD> collection;
	
	/** Valore di ritorno se non è stato trovato nessun risultato nella ricerca */
	public static final int SEARCH_NO_RESULT = -1;
	
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
	 * Rimuove il CD di indice <i>index</i>, se corretto
	 * @param index
	 * 			Indice del CD da rimuovere
	 */
	public void removeCD (int index)
	{
		if ( index >= 0 && index < collection.size () )
			collection.remove (index);
	}
	
	/**
	 * Ritorna il CD di indice <i>index</i>
	 * @param index
	 * 			Indice del CD da ritornare
	 * @return CD di indice <i>index</i>, <b>null</b> altrimenti
	 */
	public CD getCD (int index)
	{
		if ( index >= 0 && index < collection.size () )
			return collection.get (index);
		return null;
	}
	
	/**
	 * Ritorna un CD estratto a caso
	 * @return CD estratto a caso
	 */
	public CD getCDRandomly ()
	{
		Random rnd = new Random();
		
		return collection.get(rnd.nextInt (collection.size()));
	}
	
	/**
	 * Cerca un CD nella collezione dal titolo, se trovato lo ritorna
	 * @param title
	 * 			Titolo del CD da cercare
	 * @return Indice del CD da cercare se presente, <b>SEARCH_NO_RESULT</b> altrimenti
	 */
	public int searchTitleCD (String title)
	{
		for(int i = 0; i < collection.size (); i++)
		{
			if ( collection.get (i).isTitle (title))
				return i;
		}
		return SEARCH_NO_RESULT;
	}
	
	/**
	 * Cerca un insieme di CD nella collezione in base all'autore
	 * @param author
	 * 			Autore dei CD da cercare
	 * @return Vettore di indici dei CD con autore <i>author</i>, se non ne è presente alcuno ritorna un vettore vuoto
	 */
	public Vector<Integer> searchAuthorCD (String author)
	{
		Vector<Integer> ris = new Vector<Integer>();
		
		for(int i = 0; i < collection.size (); i++)
		{
			if ( collection.get (i).isAuthor (author))
				ris.add (i);
		}
		
		return ris;
	}
	
	/**
	 * Crea una stringa descrittiva dell'oggetto
	 * @return Stringa descrittiva
	 */
	@Override
	public String toString ()
	{
		String str;
		
		str = "Titolo archivio: "+title+"\n";
		
		for(int i = 0; i < collection.size (); i++)
		{
			str += collection.get (i).toString ();
		}
		
		return str;
	}
	
	/**
	 * Stampa a console l'archivio
	 */
	public void print ()
	{
		IOLib.printLine (toString());
	}
	
	/**
	 * Stampa a console il CD indicato con <i>index</i>
	 * @param index
	 * 			indice del CD da stampare
	 */
	public void print (int index)
	{
		if ( index >= 0 && index < collection.size())
		{
			IOLib.printLine (collection.get (index).toString ());
		}
	}
}
