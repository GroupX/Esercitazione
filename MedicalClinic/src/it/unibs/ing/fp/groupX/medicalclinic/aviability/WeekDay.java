package it.unibs.ing.fp.groupX.medicalclinic.aviability;

import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;
import it.unibs.ing.fp.groupX.myutil.Readable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("serial")
public class WeekDay implements Serializable, Readable{
	
	private static final String SELECT_DAY = "Selezione giorno della settimana:\n";

	private final String[] nameList = {"Domenica", "Lunedì", "Martedì", "Mercoledì", "Giovedì", "Venerdì", "Sabato"};
	
	/** Numero di giorni della settimana */
	public static final int NUM_DAYS = 7;
	
	/** Valore del giorno */
	private int value;
	/** Nome del giorno */
	private String name;
	
	/**
	 * Metodo factory per leggere un giorno della settimana da console
	 * @return Giorno letto
	 */
	public static WeekDay readFromConsole ()
	{
		WeekDay wDay = new WeekDay();
		
		wDay.read();
		
		return wDay;
	}
	
	/**
	 * Costruttore private per read
	 */
	private WeekDay ()
	{
		
	}
	
	/**
	 * Ritorna il giorno della settimana passando una data
	 * @param date Data
	 * @return Giorno della settimana
	 */
	public static WeekDay getWeekDay (Date date)
	{
		Calendar c = Calendar.getInstance();
		c.setTime(date);

		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		return new WeekDay (dayOfWeek - 1);
	}
	
	/**
	 * Costruttore privato
	 * @param value
	 * 			valore del giorno
	 */
	public WeekDay (int value)
	{
		this.value = value;
		this.name = nameList[value];
	}
	
	/**
	 * ritorna il valore del giorno
	 * @return valore del giorno
	 */
	public int getValue ()
	{
		return value;
	}
	
	/**
	 * ritorna il nome del giorno
	 * @return nome del giorno
	 */
	public String getName ()
	{
		return name;
	}

	@Override
	public void read() {

		IOLib.printLine(SELECT_DAY);
		
		int i = 1;
		
		for (String str : nameList)
		{
			IOLib.printLine(i + ". " + str);
			
			i++;
		}
		
		int num;
		
		do
		{
			num = IOLib.readInt("Inserisci scelta: ");
		} while (num <= 0 || num > nameList.length);
		
		this.value = num - 1;
		this.name = nameList[num - 1];
		
	}
	
	@Override
	public String toString ()
	{
		return getName();
	}
	
	@Override
	public boolean equals (Object obj)
	{
		WeekDay wDay = (WeekDay)obj;
		
		if (wDay.value == this.value)
			return true;
		
		return false;
	}
	
	
}
