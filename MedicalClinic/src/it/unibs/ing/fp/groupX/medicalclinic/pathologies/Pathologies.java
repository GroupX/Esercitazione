package it.unibs.ing.fp.groupX.medicalclinic.pathologies;

import it.unibs.ing.fp.groupX.myutil.BasicIterable;
import it.unibs.ing.fp.groupX.myutil.BasicIterator;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;
import it.unibs.ing.fp.groupX.myutil.Useable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Classe singleton per la gestione dell'elenco delle patologie
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class Pathologies implements BasicIterable<Pathology>, Useable, Serializable{

	/** Intestazione di stampa */
	private static final String PRINT_HEADER = "Elenco patologie:";
	
	/** Messaggio errore: patologia non trovata nella lista */
	public static final String PATHOLOGY_NOT_FOUND = "Patologia non presente";
	/** Messaggio errore: patologia già presente nella lista */
	public static final String PATHOLOGY_ALREADY_INSERT = "Patologia già presente";
	
	/** Unica istanza dell'oggetto */
	private static Pathologies instance = null;
	
	/** Elenco patologie */
	private ArrayList<Pathology> list = new ArrayList<Pathology>();
	
	/**
	 * Costruttore privato
	 */
	private Pathologies ()
	{
	}
	
	/**
	 * Ritorna l'unica istanza di Pathologies
	 * @return Unica istanza di Pathologies
	 */
	public static Pathologies get()
	{
		if (instance == null)
			instance = new Pathologies();
		
		return instance;
	}
	
	/**
	 * Aggiunge una patologia
	 * @param p
	 * 			patologia da aggiungere
	 * @throws IllegalArgumentException
	 * 			patologia già presente nell'elenco
	 */
	public void add (Pathology p) throws IllegalArgumentException
	{
		if (list.contains(p))
		{
			IllegalArgumentException e = new IllegalArgumentException(PATHOLOGY_ALREADY_INSERT);
			throw e;
		}
		else
		{
			list.add(p);
		}
	}
	
	/**
	 * Aggiunge una patologia
	 * @param pathologyName
	 * 			nome della patologia da aggiungere
	 * @throws IllegalArgumentException
	 * 			patologia già presente nell'elenco
	 */
	public void add (String pathologyName) throws IllegalArgumentException
	{
		add (new Pathology(pathologyName));
	}
	
	/**
	 * rimuove una patologia
	 * @param index
	 * 			indice della patologia da rimuovere
	 * @throws IndexOutOfBoundsException
	 * 			indice passato non valido
	 */
	public void remove (int index) throws IndexOutOfBoundsException
	{
		list.remove(index);
	}
	
	/**
	 * rimuove una patologia
	 * @param p
	 * 			patologia da rimuovere
	 * @throws IllegalArgumentException
	 * 			patologia non presente
	 */
	public void remove (Pathology p) throws IllegalArgumentException
	{
		if (!list.contains(p))
		{
			IllegalArgumentException e = new IllegalArgumentException(PATHOLOGY_NOT_FOUND);
			throw e;
		}
		else
		{
			list.remove(p);
		}
	}
	
	/**
	 * rimuove una patologia
	 * @param pathologyName
	 * 			nome della patologia da rimuovere
	 * @throws IllegalArgumentException
	 * 			patologia non presente
	 */
	public void remove (String pathologyName) throws IllegalArgumentException
	{
		remove (new Pathology(pathologyName));
	}
	
	/**
	 * Verifica se uan patologia è già presente
	 * @param p
	 * 			patologia da controllare
	 * @return true: presente; false: altrimenti
	 */
	public boolean contains (Pathology p)
	{
		return list.contains(p);
	}
	
	/**
	 * Verifica se uan patologia è già presente
	 * @param pathologyName
	 * 			nome della patologia da controllare
	 * @return true: presente; false: altrimenti
	 */
	public boolean contains (String pathologyName)
	{
		return contains (new Pathology(pathologyName));
	}
	
	/**
	 * Ritorna la patologia indicata dall'indice
	 * @param index
	 * 				indice della patologia da ritornare
	 * @return patologia indicata
	 * @throws IndexOutOfBoundsException
	 * 				indice non valido
	 */
	public Pathology get (int index) throws IndexOutOfBoundsException
	{
		return list.get(index);
	}
	
	/**
	 * RItorna la patologia con il nome passato
	 * @param pathologyName
	 * 				Nome della patologia
	 * @return patologia indicata
	 * @throws IllegalArgumentException
	 * 				Patologia non presente
	 */
	public Pathology get (String pathologyName) throws IllegalArgumentException
	{
		for(Pathology p : list)
		{
			if (pathologyName.equalsIgnoreCase(p.getName()))
				return p;
		}
		
		IllegalArgumentException e = new IllegalArgumentException(PATHOLOGY_NOT_FOUND);
		throw e;
	}
	
	/**
	 * RItorna l'indice della patologia cercata
	 * @param pathologyName
	 * 				Nome della patologia
	 * @return indice della patologia
	 * @throws IllegalArgumentException
	 * 				Patologia non presente
	 */
	private int getIndex (String pathologyName) throws IllegalArgumentException
	{
		for (int i = 0; i < list.size(); i++)
		{
			if (pathologyName.equalsIgnoreCase(list.get(i).getName()))
				return i;
		}
		
		IllegalArgumentException e = new IllegalArgumentException(PATHOLOGY_NOT_FOUND);
		throw e;
	}
	
	/**
	 * ritorna un array contenente tutte le patologie nella lista
	 * @return array di patologie
	 */
	public Pathology[] getAll ()
	{
		Pathology[] p = new Pathology[list.size()];
		return list.toArray(p);
	}
	
	/**
	 * Modifica una patologia della lista
	 * @param oldPathologyName
	 * 				Nome attuale della patologia
	 * @param newPathologyName
	 * 				Nome nuovo della patologia
	 * @throws IllegalArgumentException
	 * 				Patologia non presente
	 */
	public void change (String oldPathologyName, String newPathologyName) throws IllegalArgumentException
	{
		if (contains(newPathologyName))
		{
			IllegalArgumentException e = new IllegalArgumentException(PATHOLOGY_ALREADY_INSERT);
			throw e;
		}
		else if (!contains(oldPathologyName))
		{
			IllegalArgumentException e = new IllegalArgumentException(PATHOLOGY_NOT_FOUND);
			throw e;
		}
		else
		{
			list.set(getIndex(oldPathologyName), new Pathology(newPathologyName));
		}
	}
	
	/**
	 * Ritorna il numero di patologie registrate
	 * @return Patologie registrate
	 */
	public int size()
	{
		return list.size();
	}
	
	/**
	 * Ritorna una stringa contenente la lista di tutte le patologie
	 * @return stringa della lista
	 */
	@Override
	public String toString ()
	{
		StringBuffer str = new StringBuffer();
		
		str.append(PRINT_HEADER);
		for(Pathology p : list)
			str.append("\n"+p.toString());
		
		return str.toString();
	}

	@Override
	public Iterator<Pathology> iterator() {
		return new BasicIterator<>(this);
	}

	@Override
	public void use() {
		
		final int INSERT_PATHOLOGY_CHOICE = 1;
		final int REMOVE_PATHOLOGY_CHOICE = 2;
		final int PRINT_PATHOLOGIES_CHOICE = 3;
		
		// TODO constants
		MyMenu menu = new MyMenu("Gestione patologie esistenti: ", "Inserisci patologia", "Rimuovi patologia", "Stampa patologie");
		
		int scelta;
		
		while ((scelta = menu.getChoice()) != MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
			case INSERT_PATHOLOGY_CHOICE:
				try
				{
					this.add(Pathology.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			case REMOVE_PATHOLOGY_CHOICE:
				try
				{
					this.remove(Pathology.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			case PRINT_PATHOLOGIES_CHOICE:
				IOLib.printLine(this.toString());
				break;
			}
		}
	}
}
