package it.unibs.ing.fp.groupX.medicalclinic;

/**
 * Enum per i giorni della settimana
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public enum WeekDay {
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
}
