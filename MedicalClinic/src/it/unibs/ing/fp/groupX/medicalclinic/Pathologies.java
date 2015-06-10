package it.unibs.ing.fp.groupX.medicalclinic;

import java.util.ArrayList;

/**
 * Classe statica per la gestione dell'elenco delle patologie
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Pathologies {
	/** Intestazione di stampa */
	private static final String PRINT_HEADER = "Elenco patologie:";
	
	/** Messaggio errore: patologia non trovata nella lista */
	public static final String PATHOLOGY_NOT_FOUND = "Patologia non presente";
	/** Messaggio errore: patologia già presente nella lista */
	public static final String PATHOLOGY_ALREADY_INSERT = "Patologia già presente";
	
	/** Elenco patologie */
	private static ArrayList<Pathology> list = new ArrayList<Pathology>();
	
	/**
	 * Costruttore privato
	 */
	private Pathologies ()
	{
	}
	
	/**
	 * Aggiunge una patologia
	 * @param p
	 * 			patologia da aggiungere
	 * @throws IllegalArgumentException
	 * 			patologia già presente nell'elenco
	 */
	public static void add (Pathology p) throws IllegalArgumentException
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
	public static void add (String pathologyName) throws IllegalArgumentException
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
	public static void remove (int index) throws IndexOutOfBoundsException
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
	public static void remove (Pathology p) throws IllegalArgumentException
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
	public static void remove (String pathologyName) throws IllegalArgumentException
	{
		remove (new Pathology(pathologyName));
	}
	
	/**
	 * Verifica se uan patologia è già presente
	 * @param p
	 * 			patologia da controllare
	 * @return true: presente; false: altrimenti
	 */
	public static boolean contains (Pathology p)
	{
		return list.contains(p);
	}
	
	/**
	 * Verifica se uan patologia è già presente
	 * @param pathologyName
	 * 			nome della patologia da controllare
	 * @return true: presente; false: altrimenti
	 */
	public static boolean contains (String pathologyName)
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
	public static Pathology get (int index) throws IndexOutOfBoundsException
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
	public static Pathology get (String pathologyName) throws IllegalArgumentException
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
	 * ritorna un array contenente tutte le patologie nella lista
	 * @return array di patologie
	 */
	public static Pathology[] getAll ()
	{
		Pathology[] p = new Pathology[list.size()];
		return list.toArray(p);
	}
	
	/**
	 * Ritorna una stringa contenente la lista di tutte le patologie
	 * @return stringa della lista
	 */
	public static String listToString ()
	{
		StringBuffer str = new StringBuffer();
		
		str.append(PRINT_HEADER);
		for(Pathology p : list)
			str.append("\n"+p.getName());
		
		return str.toString();
	}
}
