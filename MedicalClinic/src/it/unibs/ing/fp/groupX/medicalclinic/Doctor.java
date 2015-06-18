package it.unibs.ing.fp.groupX.medicalclinic;

import java.sql.Time;
import java.util.UUID;

public class Doctor extends StaffMember {
	/** Formato di stampa */
	private static final String PRINT_FORMAT = "%s\nNumero Albo: %s";
	
	/** Numero di albo */
	private String albo;
	/** Orari disponibili */
	private boolean[][] hours;
	
	/**
	 * Costruttore con matrice di boolean per gli orari disponibili
	 * @param hours
	 * 			Orari disponibili del dottore
	 */
	public Doctor (boolean[][] hours)
	{
		this.hours = hours.clone();
		this.albo = generateAlbo();
	}
	
	/**
	 * Ritorna il numero di Albo
	 * @return numero di Albo
	 */
	public String getAlbo()
	{
		return albo;
	}
	
	public void setAvailability (WeekDay startDay, WeekDay endDay, Time startTime, Time endTime)
	{
		
	}
	
	
	






	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		return String.format(PRINT_FORMAT, super.toString(), albo);
	}
	
	/**
	 * Genera il numero univoco dell'Albo attraverso l'uso della classe UUID di java
	 * @return Numero di Albo
	 */
	public static String generateAlbo ()
	{
		UUID id = UUID.randomUUID();
		return id.toString();
	}
}
