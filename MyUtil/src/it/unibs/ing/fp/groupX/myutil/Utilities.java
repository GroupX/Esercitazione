package it.unibs.ing.fp.groupX.myutil;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Classe di utilità
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Utilities {
	private static final String ELEMENT_NOT_FOUND_ERROR = "Elemento non presente nella collection";
	/** Millisecondi in un secondo */
	public static final int MILLISECONDS_TO_SECONDS = 1000;
	/** Minuti in un'ora */
	public static final int MINUTE_TO_HOUR = 60;
	/** Secondi in un minuto */
	public static final int SECOND_TO_MINUTE = 60;
	/** Formato della data*/
	private static String DATE_FORMAT = "dd/MM/yyyy";
	/** Formato dell'ora */
	private static final String TIME_FORMAT = "HH:mm";
	/** Formato della data con l'ora */
	private static final String DATE_TIME_FORMAT = DATE_FORMAT + " " + TIME_FORMAT;
	
	
	/**
	 * Trasforma una data in stringa
	 * @param d Data da trasformare
	 * @return Stringa che rappresenta la data
	 */
	public static String dateToString (Date d)
	{
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(d);
	}
	
	/**
	 * Trasforma una stringa in data
	 * @param s Stringa da trasformare
	 * @return Data corrispondente alla stringa
	 * @throws ParseException lanciata se la stringa non rispetta il formato
	 */
	public static Date stringToDate (String s) throws ParseException
	{
		if (s.equals("")) //Ritorna la data attuale nel caso il campo sia omesso
			return new Date();
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.parse(s);
	}
	
	/**
	 * Trasforma un orario in stringa
	 * @param t
	 * 			Orario da trasformare
	 * @return Stringa che rappresenta l'orario
	 */
	public static String timeToString (Time t)
	{
		DateFormat df = new SimpleDateFormat(TIME_FORMAT);
		return df.format(t);
	}
	
	/**
	 * Trasforma una stringa in un orario
	 * @param s
	 * 			stringa da trasformare
	 * @return Ora corrispondente alla stringa
	 * @throws ParseException lanciata se la stringa non rispetta il formato
	 */
	public static Time stringToTime (String s) throws ParseException
	{
		DateFormat df = new SimpleDateFormat(TIME_FORMAT);
		Date d = df.parse(s);
		return new Time(d.getTime());
	}
	
	/**
	 * Trasforma una data con orario in una stringa
	 * @param d
	 * 			data e ora da trasformare
	 * @return Stringa che rappresenta la data e l'ora
	 */
	public static String dateTimeToString (Date d)
	{
		DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
		return df.format(d);
	}
	
	/**
	 * Trasforma una data contenente solo orario in stringa
	 * @param d Data
	 * @return Stringa rappresentativa
	 */
	public static String timeInDateToString (Date d)
	{
		DateFormat df = new SimpleDateFormat(TIME_FORMAT);
		return df.format(d);
	}
	
	/**
	 * Trasforma una stringa in una data contenente solo l'orario
	 * @param s Stringa contenente l'orario
	 * @return Data letta
	 * @throws ParseException Impossibile convertire la stringa in data
	 */
	public static Date stringToTimeInDate (String s) throws ParseException
	{
		if (s.equals("")) //Ritorna la data attuale nel caso il campo sia omesso
			return new Date();
		DateFormat df = new SimpleDateFormat(TIME_FORMAT);
		return df.parse(s);
	}
	
	/**
	 * Trasforma una stringa in data con ora
	 * @param s Stringa da trasformare
	 * @return Data con ora corrispondente alla stringa
	 * @throws ParseException lanciata se la stringa non rispetta il formato
	 */
	public static Date stringToDateTime (String s) throws ParseException
	{
		DateFormat df = new SimpleDateFormat(DATE_TIME_FORMAT);
		return df.parse(s);
	}
	
	/**
	 * Trasforma una stringa in data (ritorna la data attuale se il campo non è corretto). Uso consigliato solo se si è sicuri che la stringa rispetta il formato (esempio con costanti)
	 * @param s
	 * 			stringa da trasformare
	 * @return data rappresentante la stringa (o data attuale se stringa non corretta)
	 */
	public static Date stringToTimeInDateNoException (String s)
	{
		DateFormat df = new SimpleDateFormat(TIME_FORMAT);
		try {
			return df.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}
	}
	
	/**
	 * Trasforma una stringa in data (ritorna la data attuale se il campo non è corretto). Uso consigliato solo se si è sicuri che la stringa rispetta il formato (esempio con costanti)
	 * @param s Stringa da trasformare
	 * @return Data corrispondente alla stringa
	 */
	public static Date stringToDateNoException (String s)
	{
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		try {
			return df.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
			return new Date();
		}
	}
	
	/**
	 * Restituisce il lasso di tempo tra un orario e un altro
	 * @param t1
	 * 			Orario 1
	 * @param t2
	 * 			Orario 2
	 * @return Lasso di tempo
	 */
	public static Durata timeDifference (Time t1, Time t2)
	{
		long t1Minutes = timeInMinutes(t1);
		long t2Minutes = timeInMinutes(t2);
		
		Durata ris = new Durata (t2Minutes - t1Minutes, Durata.NULL_TIME);
		
		return ris;
	}
	
	/**
	 * Ritorna l'orario in minuti
	 * @param t
	 * 			orario da trasformare
	 * @return orario espresso in minuti
	 */
	public static long timeInMinutes (Time t)
	{
		return (long)t.getMinutes() + (long)t.getHours()*MINUTE_TO_HOUR;
	}
	
	/**
	 * Ritorna un orario partendo da un'altro orario e un lasso di tempo da sommare
	 * @param start
	 *			orario di partenza
	 * @param lapse
	 * 			lasso di tempo
	 * @return orario sommato
	 */
	public static Time nextSlot (Time start, Durata lapse)
	{
		long time = lapse.toSecondi()*MILLISECONDS_TO_SECONDS + start.getTime();
		
		return new Time(time);
	}
	
	/**
	 * controlla se un orario è contenuto nel range
	 * @param start
	 * 			inizio intervallo
	 * @param end
	 * 			fine intervallo
	 * @param t
	 * 			orario da controllare
	 * @return true: è contenuto strettamente nel range o coincide con l'inizio; false: altrimenti
	 */
	public static boolean timeInRange (Time start, Time end, Time t)
	{
		return ( t.before(end) && (t.after(start) || t.equals(start)) );
	}
	
	/**
	 * Fonde due ArrayList evitando ripetizioni
	 * @param a1
	 * 			primo ArrayList
	 * @param a2
	 * 			secondo ArrayList
	 * @return fusione dei due ArrayList
	 */
	public static <E> ArrayList<E> arrayListMerge (ArrayList<E> a1, ArrayList<E> a2)
	{
		ArrayList<E> ris = new ArrayList<E>();
		
		for (E e : a1)
		{
			ris.add(e);
		}
		
		for (E e : a2)
		{
			if (!ris.contains(e))
				ris.add(e);
		}
		
		return ris;
	}
	
	/**
	 * Ritorna l'indice dell'elemento cercato nella collection
	 * @param element
	 * 				cosa cercare
	 * @param collection
	 * 				dove cercare
	 * @return indice elemento cercato
	 * @throws IllegalArgumentException elemento non presente nella collection
	 */
	public static <E> int getCollectionElementIndex	(E element, Collection<E> collection) throws IllegalArgumentException
	{
		int i = 0;
		for (E obj : collection)
		{
			if (obj.equals(element))
				return i;
			else
				i++;
		}
		
		throw new IllegalArgumentException(ELEMENT_NOT_FOUND_ERROR);
	}
	
	/**
	 * Ritorna la prossima data avanzando di 30 min
	 * @param d Data
	 * @return data avanzata di 30 min
	 */
	public static Date getNextDate30Min (Date d)
	{
		long t= d.getTime();
		return new Date(t + (30 * MILLISECONDS_TO_SECONDS * SECOND_TO_MINUTE));
	}
	
	/**
	 * Calcola la percentuale
	 * @param max Il valore massimo
	 * @param amount Il valore attuale
	 * @return Percentuale
	 */
	public static double getPercentage (double max, double amount)
	{
		return (amount*100.0)/max;
	}
}
