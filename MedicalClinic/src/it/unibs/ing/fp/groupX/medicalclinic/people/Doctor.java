package it.unibs.ing.fp.groupX.medicalclinic.people;

import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillArea;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillAreas;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Visit;
import it.unibs.ing.fp.groupX.myutil.CodiceFiscale;
import it.unibs.ing.fp.groupX.myutil.Gender;
import it.unibs.ing.fp.groupX.myutil.NumeroTelefonico;
import it.unibs.ing.fp.groupX.myutil.Readable;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * Classe che implementa un medico
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class Doctor extends StaffMember implements Readable, Serializable {
	/** Tipologia di dipendente */
	public static final String STAFF_TYPE = "Doctor";
	
	/** Formato di stampa */
	private static final String PRINT_FORMAT = "%s\nNumero Albo: %s";
	/** Formato stampa ridotta */
	private static final String PRINT_FORMAT_SHORT = "Dr. %s %s  N°Albo: %s";
	
	/** Numero di albo */
	private String albo;
	
	/**
	 * Costruttore privato per read
	 */
	protected Doctor ()
	{
		
	}
	
	/**
	 * Metodo factory che crea un medico leggendolo da console 
	 * @return
	 */
	public static Doctor readFromConsole () 
	{
		Doctor ris = new Doctor();
		
		ris.read();
		
		return ris;
	}
	
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
	public Doctor (String name, String surname, Date birth, String birthPlace, Gender gen, NumeroTelefonico num, CodiceFiscale cod)
	{
		super(name, surname, birth, birthPlace, gen, num, cod);
		this.albo = generateAlbo();
	}
	
	/**
	 * Costruttore che si basa su un oggetto person
	 * @param person Persona
	 * @param hours Orari disponibili del dottore
	 */
	public Doctor (Person person)
	{
		super(person);
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
	 * Controlla se il dottore può eseguire una certa visita
	 * @param v
	 * 			visita da controllare
	 * @return true: può; false: altrimenti
	 */
	public boolean canDo (Visit v)
	{
		return v.getSkillArea().equals(new SkillArea(SkillAreas.GENERAL_SKILL_AREA_NAME));
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
	 * Override di toStringShort
	 * @return stringa descrittiva abbreviata dell'oggetto
	 */
	@Override
	public String toStringShort() {
		return String.format(PRINT_FORMAT_SHORT, getName(), getSurname(), albo);
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
	
	@Override
	public void read() {
		super.read();
		
		this.albo = generateAlbo();
	}
}
