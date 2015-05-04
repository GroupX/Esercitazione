package it.unibs.ing.fp.groupX.esercitazioni;

import it.unibs.ing.fp.groupX.myutil.Durata;

import java.util.Random;
import java.util.Vector;

/**
 * Classe per la gestione di un CD
 * 
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class CD
{
	/** Titolo del CD */
	private String title;
	/** Autore del CD */
	private String author;
	/** Elenco tracce del CD */
	private Vector<Brano> tracks = new Vector<Brano>();
	
	/**
	 * Inizializza titolo e autore del CD con i valori passati
	 * @param title 
	 * 			Titolo del CD
	 * @param author
	 * 			Autore del CD
	 */
	public CD (String title, String author)
	{
		this.title = title;
		this.author = author;
	}
	
	/**
	 * Aggiunge un brano all'elenco
	 * @param track
	 * 			Brano da aggiungere
	 */
	public void addBrano (Brano track)
	{
		tracks.add (track);
	}
	/**
	 * Aggiunge un brano all'elenco
	 * @param title
	 * 			Titolo del brano da aggiungere
	 * @param lenght
	 * 			Durata del brano da aggiungere
	 */
	public void addBrano (String title, Durata lenght)
	{
		tracks.add(new Brano(title, lenght));
	}
	
	/**
	 * Ritorna un brano estratto a caso dall'elenco
	 * @return Brano estratto a caso
	 */
	public Brano getBranoRandomly ()
	{
		Random rnd = new Random();
		return tracks.get (rnd.nextInt (tracks.size ()));
	}
	
	/**
	 * Ritorna il brano di indice <i>index</i> dall'elenco
	 * @param index 
	 * 			Indice del brano da ritornare
	 * @return Brano di indice <i>index</i> se presente, <b>null</b> altrimenti
	 */
	public Brano getBrano (int index)
	{
		if (index < tracks.size ())
			return tracks.get (index);
		
		return null;
	}
	
	/**
	 * Ritorna il titolo del CD
	 * @return Titolo del CD
	 */
	public String getTitle ()
	{
		return title;
	}
	
	/**
	 * Ritorna l'autore del CD
	 * @return Autore del CD
	 */
	public String getAuthor ()
	{
		return author;
	}
	
	/**
	 * Controlla se la stringa passata è uguale (no case-sensitive) al titolo del CD
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
	
	/**
	 * Controlla se la stringa passata è uguale (no case-sensitive) all'autore del CD
	 * @param title 
	 * 			Stringa da confrontare con l'autore
	 * @return <b>true</b> se uguale (no case-sensitive), <b>false</b> altrimenti
	 */
	public boolean isAuthor (String author)
	{
		if (this.author.equalsIgnoreCase (author))
			return true;
		return false;
	}
	
	@Override
	/**
	 * Ritorna una stringa descrittiva del CD
	 * @return Descrizione del CD (titolo, autore, descrizione dei vari brani)
	 */
	public String toString () 
	{
		String str;
		
		str= "Titolo: "+title;
		str+="\nAutore: "+author+"\n";
		
		for(int i = 0; i < tracks.size ();i++)
		{
			str+=tracks.get (i).toString ();
			str+="\n";
		}
		
		return str;
	}
	
	/**
	 * Ritorna una descrizione veloce del CD
	 * @return Descrizione del CD (titolo, autore, numero brani)
	 */
	public String descrizioneVeloce ()
	{
		String str;
		
		str= "Titolo: "+title;
		str+="\nAutore: "+author;
		str+="\nNumero brani: "+tracks.size ();
		
		return str;
	}
}
