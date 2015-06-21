package it.unibs.ing.fp.groupX.medicalclinic;

import java.io.Serializable;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;

import it.unibs.ing.fp.groupX.medicalclinic.people.*;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.*;
import it.unibs.ing.fp.groupX.medicalclinic.time.*;
import it.unibs.ing.fp.groupX.medicalclinic.visit.*;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;
import it.unibs.ing.fp.groupX.myutil.Useable;
import it.unibs.ing.fp.groupX.myutil.Utilities;

/**
 * Classe per la implementazione di clinica
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class Clinic implements Useable, Serializable
{
	private static final String INSERT_STAFF_MEMBER_MESSAGE = "Seleziona il dipendente:";
	private static final String INSERT_END_TIME_MESSAGE = "Inserisci orario fine disponibilità: ";
	private static final String INSERT_START_TIME_MESSAGE = "Inserisci orario inizio disponibilità: ";
	
	// Orari come da traccia
	/** Orario di apertura clinica */
	private static final String OPEN_TIME = "08:00:00";
	/** Orario di chiusura clinica */
	private static final String CLOSE_TIME = "18:00:00";
	
	/** Opzione menu principale per salvare */
	private static final String SAVE_MENU = "Salva";
	/** Titolo menu visite */
	private static final String VISIT_MENU = "Gestisci visite";
	/** Titolo menu orari */
	private static final String TIMETABLE_MENU = "Gestisci orari";
	/** Titolo menu personale */
	private static final String STAFF_MENU = "Gestisci personale";
	/** Titolo menu pazienti */
	private static final String PATIENT_MENU = "Gestisci pazienti";
	/** Titolo menu principale */
	private static final String MENU_TITLE = "Gestione della clinica:";
	
	/** Aree di competenza della clinica */
	private SkillAreas skAreas = new SkillAreas();
	/** Tabella orari della clinica */
	private ClinicWorkingTime timetable;
	/** Elenco delle visite tenute nella clinica */
	private ArrayList<Visit> visits = new ArrayList<Visit>();
	/** Elenco del personale della clinica */
	private ArrayList<StaffMember> staff = new ArrayList<StaffMember>();
	/** Elenco dei pazienti della clinica */
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	
	/**
	 * Costruttore
	 */
	public Clinic ()
	{
		try
		{
			timetable = new ClinicWorkingTime(Utilities.stringToTime(OPEN_TIME), Utilities.stringToTime(CLOSE_TIME));
		}
		catch (ParseException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
	
	@Override
	public void use() {
		final int PATIENT_VOICE = 1;
		final int STAFF_VOICE = 2;
		final int TIMETABLE_VOICE = 3;
		final int VISIT_VOICE = 4;
		final int SAVE = 5;
		
		MyMenu m = new MyMenu(MENU_TITLE, PATIENT_MENU, STAFF_MENU, TIMETABLE_MENU, VISIT_MENU, SAVE_MENU);
		int scelta;
		
		while ((scelta = m.getChoice())!=MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
				case PATIENT_VOICE:
					
					usePatients();
					
					break;
				
				case STAFF_VOICE:
					
					useStaff();
					
					break;
				
				case TIMETABLE_VOICE:
					
					useTimetable();
					
					break;
					
				case VISIT_VOICE:
					
					useVisit();
					
					break;
					
				case SAVE:
					
					//SERVE DATAMANAGER
					
					break;
			}
		}
	}
	
	/**
	 * Voce menu riguardante le visite
	 */
	private void useVisit ()
	{
		
	}
	
	/**
	 * Voce menu riguardante gli orari
	 */
	private void useTimetable ()
	{
		final int ADD_DAY_VOICE = 1;
		final int ADD_DAYS_VOICE = 2;
		final int ADD_PERIOD_VOICE = 3;
		final int ADD_DAY_STAFF_VOICE = 4;
		final int ADD_DAYS_STAFF_VOICE = 5;
		final int ADD_PERIOD_STAFF_VOICE = 6;
		final int REMOVE_DAY_VOICE = 7;
		final int REMOVE_DAYS_VOICE = 8;
		final int REMOVE_PERIOD_VOICE = 9;
		final int REMOVE_DAY_STAFF_VOICE = 10;
		final int REMOVE_DAYS_STAFF_VOICE = 11;
		final int REMOVE_PERIOD_STAFF_VOICE = 12;
		final int PRINT_DAY_VOICE = 13;
		final int PRINT_DAYS_VOICE = 14;
		final int PRINT_PERIOD_VOICE = 15;
		final int PRINT_ALL_VOICE = 16;
		
		MyMenu tMenu = new MyMenu(TIMETABLE_MENU, "Aggiungi disponibilità dipendente in un giorno",
												  "Aggiungi disponibilità dipendente in più giorni",
												  "Aggiungi disponibilità dipendente in serie di giorni",
												  "Aggiungi disponibilità personale in un giorno",
												  "Aggiugni disponibilità personale in più giorni",
												  "Rimuovi disponibilità dipendente in un giorno",
												  "Rimuovi disponibilità dipendente in più giorni",
												  "Rimuovi disponibilità dipendente in serie di giorni",
												  "Rimuovi disponibilità personale in un giorno",
												  "Rimuovi disponibilità personale in più giorni",
												  "Stampa disponibilità di un giorno",
												  "Stampa disponibilità di più giorni",
												  "Stampa disponibilità di serie di giorni",
												  "Stampa disponibilità settimana");
		
		int scelta;
		Time startTime, endTime;
		WeekDay day;
		ArrayList<WeekDay> days;
		StaffMember sm;
		
		while ((scelta = tMenu.getChoice())!=MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
				case ADD_DAY_VOICE:
					
					day = WeekDay.selectFromConsoleDay();
					
					IOLib.printLine(INSERT_START_TIME_MESSAGE);
					startTime = IOLib.readTime();
					
					IOLib.printLine(INSERT_END_TIME_MESSAGE);
					endTime = IOLib.readTime();
					
					IOLib.printLine(INSERT_STAFF_MEMBER_MESSAGE);
					sm = IOLib.getCollectionElement(staff);
					
					try
					{
						timetable.setAvailability(sm, day, startTime, endTime);
					}
					catch (IllegalArgumentException e)
					{
						e.printStackTrace();
					}
					
					break;
					
				case ADD_DAYS_VOICE:
					break;
					
				case ADD_PERIOD_VOICE:
					break;
					
				case ADD_DAY_STAFF_VOICE:
					break;
					
				case ADD_DAYS_STAFF_VOICE:
					break;
					
				case ADD_PERIOD_STAFF_VOICE:
					break;
					
				case REMOVE_DAY_VOICE:
					break;
					
				case REMOVE_DAYS_VOICE:
					break;
					
				case REMOVE_PERIOD_VOICE:
					break;
					
				case REMOVE_DAY_STAFF_VOICE:
					break;
					
				case REMOVE_DAYS_STAFF_VOICE:
					break;
					
				case REMOVE_PERIOD_STAFF_VOICE:
					break;
					
				case PRINT_DAY_VOICE:
					break;
					
				case PRINT_DAYS_VOICE:
					break;
					
				case PRINT_PERIOD_VOICE:
					break;
					
				case PRINT_ALL_VOICE:
					break;
			}
		}
	}
	
	/**
	 * Voce menu riguardante lo staff
	 */
	private void useStaff ()
	{
		final int ADD_GENERAL = 1;
		final int ADD_SPECIALISTIC = 2;
		final int CHANGE = 3;
		final int REMOVE = 4;
		
		MyMenu sMenu = new MyMenu(STAFF_MENU, "Aggiungi dottore generico", "Aggiungi dottore specialistico", "Modifica", "Rimuovi");
		int scelta;
		
		while ((scelta = sMenu.getChoice())!=MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
				case ADD_GENERAL:
					
					Doctor d = Doctor.readFromConsole();
					
					if (staff.contains(d))
					{
						IOLib.printLine("Il dottore risulta già inserito");
					}
					else
					{
						staff.add(d);
					}
					
					break;

				case ADD_SPECIALISTIC:
					
					SpecialistDoctor sd = SpecialistDoctor.readFromConsole();
					
					if (staff.contains(sd))
					{
						IOLib.printLine("Il dottore risulta già inserito");
					}
					else
					{
						staff.add(sd);
					}
					
					break;
					
				case CHANGE:
					// Non so se va, ma è la prima cosa che mi è venuta in mente
					ArrayList<SpecialistDoctor> specDot = new ArrayList<SpecialistDoctor>();
					
					for (StaffMember sm : staff)
					{
						if (sm.STAFF_TYPE.equalsIgnoreCase(SpecialistDoctor.STAFF_TYPE))
						{
							specDot.add((SpecialistDoctor) sm);
						}
					}
					
					IOLib.getCollectionElement(specDot).use();
					
					break;
				
				case REMOVE:
					
					staff.remove(IOLib.getCollectionElement(staff));
					
					break;
			}
		}
	}
	
	/**
	 * Voce menu riguardante i pazienti
	 */
	private void usePatients ()
	{
		final int ADD = 1;
		final int CHANGE = 2;
		final int REMOVE = 3;
		
		MyMenu pMenu = new MyMenu(PATIENT_MENU, "Aggiungi", "Modifica", "Rimuovi");
		int scelta;
		
		while ((scelta = pMenu.getChoice())!=MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
				case ADD:
					
					Patient p = Patient.readFromConsole();
					
					if (patients.contains(p))
					{
						IOLib.printLine("Il paziente risulta già inserito");
					}
					else
					{
						patients.add(p);
					}
					
					break;
				
				case CHANGE:
					
					IOLib.getCollectionElement(patients).use();
					
					break;
					
				case REMOVE:
					
					patients.remove(IOLib.getCollectionElement(patients));
					
					break;
			}
		}
	}
}
