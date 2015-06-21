package it.unibs.ing.fp.groupX.medicalclinic.time;

import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Enum per i giorni della settimana
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public enum WeekDay implements Serializable {
	LUNEDI(0, "Luned�"),
	MARTEDI(1, "Marted�"),
	MERCOLEDI(2, "Mercoled�"),
	GIOVEDI(3, "Gioved�"),
	VENERDI(4, "Venerd�"),
	SABATO(5, "Sabato"),
	DOMENICA(6, "Domenica");
	
	/** Numero di giorni della settimana */
	public static final int NUM_DAYS = 7;
	
	/** Valore del giorno */
	private int value;
	/** Nome del giorno */
	private String name;
	
	/**
	 * Costruttore privato
	 * @param value
	 * 			valore del giorno
	 */
	private WeekDay (int value, String name)
	{
		this.value = value;
		this.name = name;
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
	
	/**
	 * Controlla (in base al valore) se il giorno chiamante viene prima di quello passato
	 * @param d
	 * 			giorno da controllare
	 * @return true: valore del giorno chiamante � minore di quello passato; false: altrimenti
	 */
	public boolean before (WeekDay d)
	{
		return ( value < d.getValue() );
	}
	
	/**
	 * Controlla (in base al valore) se il giorno chiamante viene dopo di quello passato
	 * @param d
	 * 			giorno da controllare
	 * @return true: valore del giorno chiamante � maggiore di quello passato; false: altrimenti
	 */
	public boolean after (WeekDay d)
	{
		return ( value > d.getValue() );
	}
	
	/**
	 * Seleziona una serie di giorni chiedendo la scelta a console
	 * @return elenco di giorni scelti
	 */
	public static ArrayList<WeekDay> selectFromConsoleSomeDay ()
	{
		ArrayList<WeekDay> ris = new ArrayList<WeekDay>();
		
		MyMenu m = new MyMenu("Giorni:");
		for (WeekDay d : WeekDay.values())
		{
			m.addVoice(d.getName());
		}
		
		int scelta;
		
		m.print();
		
		do
		{
			scelta = IOLib.readInt("Seleziona un giorno", MyMenu.EXIT_VALUE, NUM_DAYS);
			
			if (!ris.contains(WeekDay.values()[scelta-1]))
				ris.add(WeekDay.values()[scelta-1]);
			
		}while (scelta != MyMenu.EXIT_VALUE);
		
		return ris;
	}
	
	/**
	 * Seleziona un intervallo di giorni chiedendo la scelta a console
	 * @return elenco dei giorni nell'intervallo
	 */
	public static ArrayList<WeekDay> selectFromConsoleLapseDay	()
	{
		ArrayList<WeekDay> ris = new ArrayList<WeekDay>();
		
		MyMenu m = new MyMenu("Giorni:");
		for (WeekDay d : WeekDay.values())
		{
			m.addVoice(d.getName());
		}
		
		int first, last;
		
		m.print();
		
		first = IOLib.readInt("Seleziona il primo giorno", MyMenu.EXIT_VALUE, NUM_DAYS);
		last = IOLib.readInt("Seleziona l'ultimo giorno", MyMenu.EXIT_VALUE, NUM_DAYS);
		
		for (int i = first-1; i < last; i++)
		{
			ris.add(WeekDay.values()[i]);
		}
		
		return ris;
	}
	
	/**
	 * Seleziona un giorno chiedendo la scelta a console
	 * @return un giorno
	 */
	public static WeekDay selectFromConsoleDay ()
	{
		MyMenu m = new MyMenu("Giorni:");
		for (WeekDay d : WeekDay.values())
		{
			m.addVoice(d.getName());
		}
		
		int scelta;
		while ( (scelta=m.getChoice()) == MyMenu.EXIT_VALUE );
		
		return WeekDay.values()[scelta-1];
	}
}
