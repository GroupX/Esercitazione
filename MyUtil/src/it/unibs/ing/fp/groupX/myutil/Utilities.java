package it.unibs.ing.fp.groupX.myutil;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe di utilità
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Utilities {
	/** Millisecondi in un secondo */
	private static final int MILLISECONDS_TO_SECONDS = 100;
	/** Minuti in un'ora */
	private static final int MINUTE_TO_HOUR = 60;
	/** Formato della data*/
	private static String DATE_FORMAT = "dd/MM/yyyy";
	/** Formato dell'ora */
	private static final String TIME_FORMAT = "hh:mm:ss";
	
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
}
