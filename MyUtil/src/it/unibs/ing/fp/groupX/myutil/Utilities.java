package it.unibs.ing.fp.groupX.myutil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utilities {
	
	private static String DATE_FORMAT = "dd/MM/yyyy";
	
	public static String dateToString (Date d)
	{
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.format(d);
	}
	
	public static Date stringToDate (String s) throws ParseException
	{
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		return df.parse(s);
	}
}
