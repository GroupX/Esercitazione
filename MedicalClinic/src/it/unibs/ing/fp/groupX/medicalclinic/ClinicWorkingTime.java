package it.unibs.ing.fp.groupX.medicalclinic;

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
	
	
	
	
	
}
