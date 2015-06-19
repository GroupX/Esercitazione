package it.unibs.ing.fp.groupX.medicalclinic.people;

import it.unibs.ing.fp.groupX.medicalclinic.WeekDay;
import it.unibs.ing.fp.groupX.myutil.CodiceFiscale;
import it.unibs.ing.fp.groupX.myutil.Gender;
import it.unibs.ing.fp.groupX.myutil.NumeroTelefonico;

import java.sql.Time;
import java.util.Date;
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
	 * @param name
	 * 			nome
	 * @param surname
	 * 			cognome
	 * @param birth
	 * 			data di nascita
	 * @param birthPlace
	 * 			luogo di nascita
	 * @param gen
	 * 			genere
	 * @param num
	 * 			numero telefonico
	 * @param cod
	 * 			codice fiscale
	 * @param hours
	 * 			Orari disponibili del dottore
	 */
	public Doctor (String name, String surname, Date birth, String birthPlace, Gender gen, NumeroTelefonico num, CodiceFiscale cod, boolean[][] hours)
	{
		super(name, surname, birth, birthPlace, gen, num, cod);
		this.hours = hours.clone();
		this.albo = generateAlbo();
	}
	
	/**
	 * Costruttore che si basa su un oggetto person
	 * @param person Persona
	 * @param hours Orari disponibili del dottore
	 */
	public Doctor (Person person, boolean[][] hours)
	{
		super(person);
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
	
	/**
	 * Imposta la disponibilità del dottore
	 * @param startDay
	 * 			giorno di partenza
	 * @param endDay
	 * 			giorno di fine
	 * @param startLapse
	 * 			periodo di inizio
	 * @param endLapse
	 * 			periodo di fine
	 * @param state
	 * 			stato da impostare
	 */
	public void setAvailability (WeekDay startDay, WeekDay endDay, int startLapse, int endLapse, boolean state)
	{
		for (int i = startDay.getValue(); i <= endDay.getValue(); i++)
		{
			for (int j = startLapse; j <= endLapse; j++)
			{
				hours[j][i] = state;
			}
		}
	}
	
	/**
	 * Imposta la disponibilità del dottore
	 * @param day
	 * 			giorno da impostare
	 * @param startLapse
	 * 			periodo di inizio
	 * @param endLapse
	 * 			periodo di fine
	 * @param state
	 * 			stato da impostare
	 */
	public void setAvailability (WeekDay day, int startLapse, int endLapse, boolean state)
	{
		for (int i = startLapse; i <= endLapse; i++)
		{
			hours[i][day.getValue()] = state;
		}
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
