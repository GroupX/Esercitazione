package it.unibs.ing.fp.cd;

import it.unibs.ing.fp.groupX.myutil.IOLib;

import java.util.Random;
import java.util.Vector;

/**
 * Classe che si occupa di gestire un archivio CD
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class ArchivioCd
{
	/** Titolo dell'archivio dei CD */
	private String title;
	/** Collezione dei CD in archivio */
	private Vector<Cd> collection;
	
	/** Valore di ritorno se non è stato trovato nessun risultato nella ricerca */
	public static final int SEARCH_NO_RESULT = -1;
	
	public static final String DEFAULT_TITLE = "";
	
	/**
	 * Costruttore senza parametri
	 */
	public ArchivioCd ()
	{
		this(DEFAULT_TITLE);
	}
	
	/**
	 * Costruttore con titolo come parametro
	 * @param title
	 * 			Titolo dell'archivio
	 */
	public ArchivioCd (String title)
	{
		this.title = title;
		collection = new Vector<Cd>();
	}
	
	/**
	 * Costruttore con titolo e CDs come parametri
	 * @param title
	 * 			Titolo dell'archivio
	 * @param disk
	 * 			Sequenza di CD da mettere nella collezione
	 */
	public ArchivioCd (String title, Cd ... disk)
	{
		this(title);
		for (Cd d : disk)
		{
			collection.add (d);
		}
	}
	
	/**
	 * Inserisci un CD (controlla che il titolo sia univoco)
	 * @param disk
	 * 			Disco da inserire
	 */
	public boolean aggiungiCd (Cd disk)
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
		eliminaCd(collection.size ()-1);
	}
	
	/**
	 * Rimuove il CD di indice <i>index</i>, se corretto
	 * @param index
	 * 			Indice del CD da rimuovere
	 * @return true: rimozione andata a buon fine; false: indice non corretto
	 */
	public boolean eliminaCd (int index)
	{
		if ( index < 0 && index >= collection.size () )
			return false;
		
		collection.remove (index);
		return true;
	}
	
	/**
	 * Rimuove un CD dall'archivio in base al titolo
	 * @param title
	 * 			Titolo del CD da rimuovere
	 * @return true: rimozione andata a buon fine; false: titolo non trovato
	 */
	public boolean eliminaCd (String title)
	{
		int index = searchTitleCD(title);
		
		if ( index == SEARCH_NO_RESULT )
			return false;
		
		eliminaCd (index);
		return true;
	}
	
	/**
	 * Ritorna il CD di indice <i>index</i>
	 * @param index
	 * 			Indice del CD da ritornare
	 * @return CD di indice <i>index</i>, <b>null</b> altrimenti
	 */
	public Cd getCD (int index)
	{
		if ( index >= 0 && index < collection.size () )
			return collection.get (index);
		return null;
	}
	
	/**
	 * Ritorna un CD estratto a caso
	 * @return CD estratto a caso
	 */
	public Cd getCDRandomly ()
	{
		Random rnd = new Random();
		
		return collection.get(rnd.nextInt (collection.size()));
	}
	
	/**
	 * Seleziona a caso un numero <i>num</i> di brani dall'archivio
	 * @param num
	 * 			Numero di brani da selezionare
	 * @return Array di brani selezionati a caso
	 */
	public Brano[] getSomeBrano (int num)
	{
		Brano[] tracks = new Brano[num];
		
		for (int i = 0; i < num; i++)
		{
			tracks[i] = getCDRandomly().branoCasuale ();
		}
		
		return tracks;
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
			if ( collection.get (i).haTitolo (title))
				return i;
		}
		return SEARCH_NO_RESULT;
	}
	
	/**
	 * Controlla se esiuste un CD
	 * 
	 * @param title Titolo del CD da cercare
	 * @return true se il cd c'è, false altrimenti
	 */
	public boolean contiene (String title)
	{
		int ris = searchTitleCD(title);
		
		if (ris == SEARCH_NO_RESULT)
			return false;
		else
			return true;
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
	 * Ricerca il titolo di brano/i nell'archivio
	 * @param title
	 * 			Titolo del brano/i da cercare
	 * @return Vettore degli indici dei CD contenenti il brano cercato
	 */
	public Vector<Integer> searchBranoCD (String title)
	{
		Vector<Integer> ris = new Vector<Integer>();
		
		for(int i = 0; i < collection.size (); i++)
		{
			if (!collection.get (i).searchBrano (title).isEmpty ())
				ris.add(i);
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
			str += collection.get (i).toString ()+"\n";
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
	 * Stampa a console il CD indicato con <i>index</i>, se corretto
	 * @param index
	 * 			indice del CD da stampare
	 * @return true: stampa andata a buon fine; false: indice non corretto
	 */
	public boolean print (int index)
	{
		if ( index < 0 && index >= collection.size())
			return false;
		
		IOLib.printLine (collection.get (index).toString ());
		return true;
	}
	
	/**
	 * Stampa un CD dall'archivio in base al titolo
	 * @param title
	 * 			Titolo del CD da stampare
	 * @return true: stampa andata a buon fine; false: titolo non trovato
	 */
	public boolean print (String title)
	{
		int index = searchTitleCD(title);
		
		if ( index == SEARCH_NO_RESULT )
			return false;

		print(index);
		return true;
	}
	
	/**
	 * Ritorna il numero di Cd nella collezione
	 * @return Numero di Cd contenuti
	 */
	public int getNumeroCd ()
	{
		return collection.size();
	}
}
