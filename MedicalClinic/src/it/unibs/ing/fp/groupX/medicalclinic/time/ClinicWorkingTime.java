package it.unibs.ing.fp.groupX.medicalclinic.time;

import it.unibs.ing.fp.groupX.medicalclinic.people.StaffMember;
import it.unibs.ing.fp.groupX.myutil.Durata;
import it.unibs.ing.fp.groupX.myutil.Utilities;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Classe per la gestione degli orari della clinica
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class ClinicWorkingTime
{
	/** Messaggio errore intervallo orario non valido */
	public static final String INVALID_RANGE_TIME_ERROR = "Intervallo orario non valido";
	/** Messaggio errore dipendente non trovato */
	public static final String MEMBER_NOT_FOUND_ERROR = "Dipendente non trovato.";
	
	/** Formato stampa abbreviata */
	private static final String PRINT_FORMAT_SHORT = "Aperto tutti i giorni dalle %s alle %s.";
	/** Intestazione di stampa */
	private static final String PRINT_HEADER = "Aperto tutti i giorni dalle %s alle %s con le seguenti disponibilità:";
	/** Separatore di stampa tra un giorno e l'altro */
	private static final String PRINT_DAY_SEPARATOR = "\n%s:";
	/** Separatore di stampa tra uno slot e l'altro */
	private static final String PRINT_SLOT_SEPARATOR = "\n";
	
	/** Ampiezza in minuti degli slot */
	public static final int SLOT_MINUTES = 30;
	/** Tollerabilità per un eventale slot ridotto nel caso in cui gli orari non siano perfettamente divisibili */
	private static final double SLOT_TOLERABILITY = 0.70;
	
	/** Orario inizio lavoro */
	private Time startWork;
	/** Orario fine lavoro */
	private Time endWork;
	/** Numero di slot per giorno */
	private int numSlot;
	/** Disponibilità */
	private AvailabilitySlot[][] slots;
	
	/**
	 * Costruttore
	 * @param start
	 * 			orario inizio lavoro
	 * @param end
	 * 			orario fine lavoro
	 */
	public ClinicWorkingTime (Time start, Time end)
	{
		startWork = start;
		endWork = end;
		
		int minutes = (int)Utilities.timeDifference(startWork, endWork).toMinuti();
		
		numSlot = minutes / SLOT_MINUTES;
		
		if (minutes % SLOT_MINUTES != 0 && (minutes - SLOT_MINUTES*numSlot) >= SLOT_MINUTES*SLOT_TOLERABILITY )
		{
			numSlot++;
		}
		
		slots = new AvailabilitySlot[numSlot][WeekDay.NUM_DAYS];
	}

	/**
	 * @return the startWork
	 */
	public Time getStartWork() {
		return startWork;
	}

	/**
	 * @return the endWork
	 */
	public Time getEndWork() {
		return endWork;
	}

	/**
	 * @return the numSlot
	 */
	public int getNumSlot() {
		return numSlot;
	}
	
	/**
	 * @return the availability table
	 */
	public AvailabilitySlot[][] getAvailabilityTable ()
	{
		return slots;
	}
	
	/**
	 * Restituisce un elenco di slot
	 * @param s
	 * @return
	 * @throws IllegalArgumentException
	 */
	public ArrayList<AvailabilitySlot> getStaffMemberAvailability (StaffMember s) throws IllegalArgumentException
	{
		ArrayList<AvailabilitySlot> ris = new ArrayList<AvailabilitySlot>();
		for (WeekDay d : WeekDay.values())
		{
			for (int i = 0; i < numSlot; i++)
			{
				if (slots[i][d.getValue()].cointains(s))
				{
					ris.add(slots[i][d.getValue()]);
				}
			}
		}
		
		if (ris.isEmpty())
		{
			IllegalArgumentException e = new IllegalArgumentException(MEMBER_NOT_FOUND_ERROR);
			throw e;
		}
		
		return ris;
	}
	
	
	/**
	 * Ritorna l'elenco di slot compresi nell'intervallo
	 * @param start
	 * 			inizio intervallo
	 * @param end
	 * 			fine intervallo
	 * @return elenco di slot compresi nell'intervallo
	 */
	private ArrayList<Integer> calculateSlot (Time start, Time end)
	{
		ArrayList<Integer> ris = new ArrayList<Integer>();
		
		int i;
		Durata slotDuration = new Durata(SLOT_MINUTES,Durata.NULL_TIME);
		Time t1 = startWork;
		Time t2 = Utilities.nextSlot(t1, slotDuration);
		Time t = start;
		
		for (i = 0; i < numSlot && !t.after(end); i++)
		{
			if (Utilities.timeInRange(t1, t2, t))
			{
				ris.add(i);
				
				t = t2;
				t1 = t2;
				t2 = Utilities.nextSlot(t1, slotDuration);
				if (t2.after(endWork))
					t2 = endWork;
			}
		}
		
		return ris;
	}
	
	/**
	 * Imposta la disponibilità per un dipendente in un giorno per un lasso di tempo
	 * @param member
	 * 				dipendente
	 * @param day
	 * 				girono
	 * @param startTime
	 * 				inizio intervallo
	 * @param endTime
	 * 				fine intervallo
	 * @throws IllegalArgumentException dipendente già inserito o lasso di tempo non valido
	 */
	public void setAvailability (StaffMember member, WeekDay day, Time startTime, Time endTime) throws IllegalArgumentException
	{
		if (startTime.before(startWork) || endTime.after(endWork))
		{
			IllegalArgumentException e = new IllegalArgumentException(INVALID_RANGE_TIME_ERROR);
			throw e;
		}
		
		ArrayList<Integer> slotToSet = calculateSlot(startTime, endTime);
		
		for (Integer i : slotToSet)
		{
			slots[i.intValue()][day.getValue()].addStaffMember(member);
		}
	}
	
	/**
	 * Imposta la disponibilità per un insieme di dipendenti in un giorno per un lasso di tempo
	 * @param staff
	 * 			dipendenti
	 * @param day
	 * 			giorno
	 * @param startTime
	 * 			inizio intervallo
	 * @param endTime
	 * 			fine intervallo
	 * @throws IllegalArgumentException dipendente già inserito o lasso di tempo non valido
	 */
	public void setAvailability (ArrayList<StaffMember> staff, WeekDay day, Time startTime, Time endTime) throws IllegalArgumentException
	{
		for (StaffMember s : staff)
		{
			setAvailability(s, day, startTime, endTime);
		}
	}
	
	/**
	 * Imposta la disponibilità per un dipendente in un lasso di giorni per un lasso di tempo
	 * @param member
	 * 				dipendente
	 * @param startDay
	 * 				inizio intervallo giorni
	 * @param endDay
	 * 				fine intervallo giorni
	 * @param startTime
	 * 				inizio intervallo orario
	 * @param endTime
	 * 				fine intervallo orario
	 * @throws IllegalArgumentException dipendente già inserito o lasso di tempo non valido
	 */
	public void setAvailability (StaffMember member, WeekDay startDay, WeekDay endDay, Time startTime, Time endTime) throws IllegalArgumentException
	{
		for (WeekDay d : WeekDay.values())
		{
			if ( (d.after(startDay) || d.equals(startDay)) && (d.before(endDay) || d.equals(endDay)) )
			{
				setAvailability(member, d, startTime, endTime);
			}
		}
	}
	
	/**
	 * Imposta la disponibilità per un insieme di dipendenti in un giorno per un lasso di tempo
	 * @param staff
	 * 				dipendenti
	 * @param startDay
	 * 				inizio intervallo giorni
	 * @param endDay
	 * 				fine intervallo giorni
	 * @param startTime
	 * 				inizio intervallo orario
	 * @param endTime
	 * 				fine intervallo orario
	 * @throws IllegalArgumentException dipendente già inserito o lasso di tempo non valido
	 */
	public void setAvailability (ArrayList<StaffMember> staff, WeekDay startDay, WeekDay endDay, Time startTime, Time endTime) throws IllegalArgumentException
	{
		for (StaffMember s : staff)
		{
			setAvailability(s, startDay, endDay, startTime, endTime);
		}
	}
	
	
	/**
	 * Rimuove la disponibilità per un dipendente in un giorno per un lasso di tempo
	 * @param member
	 * 				dipendente
	 * @param day
	 * 				girono
	 * @param startTime
	 * 				inizio intervallo
	 * @param endTime
	 * 				fine intervallo
	 * @throws IllegalArgumentException dipendente non trovato o lasso di tempo non valido
	 */
	public void removeAvailability (StaffMember member, WeekDay day, Time startTime, Time endTime) throws IllegalArgumentException
	{
		if (startTime.before(startWork) || endTime.after(endWork))
		{
			IllegalArgumentException e = new IllegalArgumentException(INVALID_RANGE_TIME_ERROR);
			throw e;
		}
		
		ArrayList<Integer> slotToSet = calculateSlot(startTime, endTime);
		
		for (Integer i : slotToSet)
		{
			slots[i.intValue()][day.getValue()].removeStaffMember(member);
		}
	}
	
	/**
	 * Rimuove la disponibilità per un insieme di dipendenti in un giorno per un lasso di tempo
	 * @param staff
	 * 			dipendenti
	 * @param day
	 * 			giorno
	 * @param startTime
	 * 			inizio intervallo
	 * @param endTime
	 * 			fine intervallo
	 * @throws IllegalArgumentException dipendente non trovato o lasso di tempo non valido
	 */
	public void removeAvailability (ArrayList<StaffMember> staff, WeekDay day, Time startTime, Time endTime) throws IllegalArgumentException
	{
		for (StaffMember s : staff)
		{
			removeAvailability(s, day, startTime, endTime);
		}
	}
	
	/**
	 * Rimuove la disponibilità per un dipendente in un lasso di giorni per un lasso di tempo
	 * @param member
	 * 				dipendente
	 * @param startDay
	 * 				inizio intervallo giorni
	 * @param endDay
	 * 				fine intervallo giorni
	 * @param startTime
	 * 				inizio intervallo orario
	 * @param endTime
	 * 				fine intervallo orario
	 * @throws IllegalArgumentException dipendente non trovato o lasso di tempo non valido
	 */
	public void removeAvailability (StaffMember member, WeekDay startDay, WeekDay endDay, Time startTime, Time endTime) throws IllegalArgumentException
	{
		for (WeekDay d : WeekDay.values())
		{
			if ( (d.after(startDay) || d.equals(startDay)) && (d.before(endDay) || d.equals(endDay)) )
			{
				removeAvailability(member, d, startTime, endTime);
			}
		}
	}
	
	/**
	 * Rimuove la disponibilità per un insieme di dipendenti in un giorno per un lasso di tempo
	 * @param staff
	 * 				dipendenti
	 * @param startDay
	 * 				inizio intervallo giorni
	 * @param endDay
	 * 				fine intervallo giorni
	 * @param startTime
	 * 				inizio intervallo orario
	 * @param endTime
	 * 				fine intervallo orario
	 * @throws IllegalArgumentException dipendente non trovato o lasso di tempo non valido
	 */
	public void removeAvailability (ArrayList<StaffMember> staff, WeekDay startDay, WeekDay endDay, Time startTime, Time endTime) throws IllegalArgumentException
	{
		for (StaffMember s : staff)
		{
			removeAvailability(s, startDay, endDay, startTime, endTime);
		}
	}
	
	
	/**
	 * Ritorna una stringa descrittiva abbreviata
	 * @return stringa descrittiva abbreviata
	 */
	public String toStringShort ()
	{
		return String.format(PRINT_FORMAT_SHORT, Utilities.timeToString(startWork), Utilities.timeToString(endWork));
	}
	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		
		s.append(String.format(PRINT_HEADER, Utilities.timeToString(startWork), Utilities.timeToString(endWork)));
		
		for (WeekDay d : WeekDay.values())
		{
			s.append(String.format(PRINT_DAY_SEPARATOR, d.getName()));
			
			for (int i = 0; i < numSlot; i++)
			{
				s.append(PRINT_SLOT_SEPARATOR + slots[i][d.getValue()].toString());
			}
		}
		
		return s.toString();
	}
}
