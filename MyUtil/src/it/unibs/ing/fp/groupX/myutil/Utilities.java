package it.unibs.ing.fp.groupX.myutil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe di utilità
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Utilities {
	
	/** Formato della data*/
	private static String DATE_FORMAT = "dd/MM/yyyy";
	
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
}
