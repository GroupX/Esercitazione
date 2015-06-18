package it.unibs.ing.fp.groupX.medicalclinic;

/**
 * Enum per i giorni della settimana
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public enum Week {
	LUNEDI(0),
	MARTEDI(1),
	MERCOLEDI(2),
	GIOVEDI(3),
	VENERDI(4),
	SABATO(5),
	DOMENICA(6);
	
	/** Valore del giorno */
	private int value;
	
	/**
	 * Costruttore privato
	 * @param value
	 * 			valore del giorno
	 */
	private Week (int value)
	{
		this.value = value;
	}
	
	/**
	 * ritorna il valore del giorno
	 * @return valore del giorno
	 */
	public int getValue ()
	{
		return value;
	}
}
