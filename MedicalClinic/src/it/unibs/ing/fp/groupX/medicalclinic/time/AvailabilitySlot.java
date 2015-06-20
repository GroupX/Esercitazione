package it.unibs.ing.fp.groupX.medicalclinic.time;

import it.unibs.ing.fp.groupX.medicalclinic.people.Doctor;
import it.unibs.ing.fp.groupX.medicalclinic.people.Person;
import it.unibs.ing.fp.groupX.medicalclinic.people.StaffMember;
import it.unibs.ing.fp.groupX.myutil.CodiceFiscale;
import it.unibs.ing.fp.groupX.myutil.Utilities;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Slot temporale per gli orari di visita della clinica
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class AvailabilitySlot {
	/** Messaggio errore inserimento */
	private static final String ADD_ERROR = "Membro del personale già inserito.";
	/** Messaggio errore rimozione */
	private static final String REMOVE_ERROR = "Membro del personale non presente nell'elenco.";
	/** Messaggio errore get con codice fiscale */
	private static final String GET_BY_CF_ERROR = "Nessun membro del personale trovato con il codice fiscale indicato";
	
	/** Formato stampa ridotta */
	private static final String PRINT_FORMAT_SHORT = "%s - %s";
	/** Intestazione di stampa */
	private static final String PRINT_HEADER = "%s - %s: ";
	/** Separatore tra un membro e l'altro */
	private static final String STAFF_SEPARATOR = "\n";
	
	/** Inizio slot */
	private Time start;
	/** Fine slot */
	private Time end;
	/** Elenco personale disponibile */
	private ArrayList<StaffMember> staff = new ArrayList<StaffMember>();
	
	/**
	 * Costruttore che inizializza gli orari
	 * @param start
	 * 			Orario inizio
	 * @param end
	 * 			Orario fine
	 */
	public AvailabilitySlot (Time start, Time end)
	{
		this.start = start;
		this.end = end;
	}
	
	/**
	 * Costruttore che inizializza gli orari e inserisce dei dottori
	 * @param start
	 * 			Orario inizio
	 * @param end
	 * 			Orario fine
	 * @param staff
	 * 			Elenco personale da inserire
	 */
	public AvailabilitySlot (Time start, Time end, StaffMember ... staff)
	{
		this(start, end);
		
		for (StaffMember s : staff)
		{
			this.staff.add(s);
		}
	}
	
	/**
	 * @return the start
	 */
	public Time getStart() 
	{
		return start;
	}

	/**
	 * @return the end
	 */
	public Time getEnd() 
	{
		return end;
	}
	
	/**
	 * Ritorna il membro di indice index
	 * @param index
	 * 			indice del membro
	 * @return membro di indice index
	 */
	public StaffMember get (int index)
	{
		return staff.get(index);
	}
	
	/**
	 * Ritorna il membro con codice fiscale coincidente a quello indicato
	 * @param cod
	 * 			codice fiscale del membro desiderato
	 * @return membro
	 * @throws IllegalArgumentException Nessun risultato della ricerca
	 */
	public StaffMember get (CodiceFiscale cod) throws IllegalArgumentException
	{
		for (StaffMember s : staff)
		{
			if (s.getCod().equals(cod))
				return s;
		}
		
		IllegalArgumentException e = new IllegalArgumentException(GET_BY_CF_ERROR);
		throw e;
	}
	
	/**
	 * Ritorna l'elenco del personale
	 * @return elenco personale 
	 */
	public ArrayList<StaffMember> getAll ()
	{
		return staff;
	}
	
	/**
	 * Ritorna l'elenco del personale in un array
	 * @return elenco personale
	 */
	public StaffMember[] getAllToArray ()
	{
		StaffMember[] s = new StaffMember[staff.size()];
		return staff.toArray(s);
	}
	
	/**
	 * Controlla la presenza di un dottore
	 * @param d
	 * 			dottore
	 * @return true: presente; false: altrimenti
	 */
	public boolean cointains (Doctor d)
	{
		return contains((StaffMember)d);
	}
	
	/**
	 * Controlla la presenza di un componente del personale
	 * @param s
	 * 			componente del personale
	 * @return true: presente; false: altrimenti
	 */
	public boolean cointains (StaffMember s)
	{
		return contains((Person)s);
	}
	
	/**
	 * Controlla la presenza di una persona
	 * @param p
	 * 			persona
	 * @return true: presente; false: altrimenti
	 */
	public boolean contains (Person p)
	{
		return staff.contains(p);
	}
	
	/**
	 * Controlla se lo slot inizia nell'orario indicato
	 * @param t
	 * 			orario da controllare
	 * @return true: coincidono; false: altrimenti
	 */
	public boolean begins (Time t)
	{
		return t.equals(start);
	}
	
	/**
	 * Controlla se lo slot finisca nell'orario indicato
	 * @param t
	 * 			orario da controllare
	 * @return true: coincidono; false: altrimenti
	 */
	public boolean ends (Time t)
	{
		return t.equals(end);
	}
	
	/**
	 * Aggiunge un membro del personale
	 * @param s
	 * 			membro del personale
	 * @throws IllegalArgumentException Membro già presente
	 */
	public void addStaffMember (StaffMember s) throws IllegalArgumentException
	{
		if (contains(s))
		{
			IllegalArgumentException e = new IllegalArgumentException(ADD_ERROR);
			throw e;
		}
		else
		{
			staff.add(s);
		}
	}
	
	/**
	 * Rimuove un membro del personale
	 * @param s
	 * 			membro del personale
	 * @throws IllegalArgumentException Membro non presente
	 */
	public void removeStaffMember (StaffMember s) throws IllegalArgumentException
	{
		if (!contains(s))
		{
			IllegalArgumentException e = new IllegalArgumentException(REMOVE_ERROR);
			throw e;
		}
		else
		{
			staff.remove(s);
		}
	}
	
	/**
	 * Rimuove il membro del personale indicato da index
	 * @param index
	 * 				indice del membro da rimuovere
	 * @throws IndexOutOfBoundsException indice errato
	 */
	public void removeStaffMember (int index) throws IndexOutOfBoundsException
	{
		staff.remove(index);
	}
	
	/**
	 * Ritorna una stringa descrittiva ridotta
	 * @return stringa descrittiva ridotta
	 */
	public String toStringShort ()
	{
		return String.format(PRINT_FORMAT_SHORT, Utilities.timeToString(start), Utilities.timeToString(end));
	}
	
	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		
		s.append(String.format(PRINT_HEADER, Utilities.timeToString(start), Utilities.timeToString(end)));
		
		for (StaffMember sm : staff)
		{
			s.append(sm.toStringShort());
		}
		
		return s.toString();
	}
}
