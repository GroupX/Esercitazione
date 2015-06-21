package it.unibs.ing.fp.groupX.medicalclinic;

import java.io.Serializable;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.unibs.ing.fp.groupX.medicalclinic.aviability.*;
import it.unibs.ing.fp.groupX.medicalclinic.people.*;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.*;
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
	private static final String WEEKDAY_ALREADY_INSERT_ERROR = "Giorno già inserito";
	private static final String DATE_NOT_FOUND = "Data non trovata";
	private static final String PATIENT_NOT_FOUND = "Paziente non trovato";
	private static final String MEMBER_NOT_FOUND = "Membro non trovato";
	private static final String INSERT_SURNAME = "Inserisci cognome: ";
	private static final String INSERT_NAME = "Inserisci nome: ";
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
	/** Elenco delle visite tenute nella clinica */
	private ArrayList<Visit> visits = new ArrayList<Visit>();
	/** Elenco del personale della clinica */
	private ArrayList<StaffMember> staff = new ArrayList<StaffMember>();
	/** Elenco dei pazienti della clinica */
	private ArrayList<Patient> patients = new ArrayList<Patient>();
	/** Lista di orari di disponibilità */
	List<AvailabilityPeriod> availability = new ArrayList<>();
	
	/**
	 * Costruttore
	 */
	public Clinic ()
	{
		
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
	 * Cerca un periodo di disponibilità
	 * @param d Giorno 
	 * @param time Ora
	 * @return Lista dei periodi trovati
	 */
	public List<AvailabilityPeriod> searchPeriod (Date d, Date time)
	{
		ArrayList <AvailabilityPeriod> ris = new ArrayList<>();
		
		for (AvailabilityPeriod p : availability)
		{
			if (p.compatibleWith(d, time))
				ris.add(p);
		}
		
		return ris;
	}
	
	/**
	 * Cerca un periodo di disponibilità
	 * @param sm
	 * 			dipendente coinvolto
	 * @return Lista dei periodi trovati
	 */
	public List<AvailabilityPeriod> searchPeriod (StaffMember sm)
	{
		ArrayList <AvailabilityPeriod> ris = new ArrayList<>();
		
		for (AvailabilityPeriod p : availability)
		{
			if (p.getSm().equals(sm))
				ris.add(p);
		}
		
		return ris;
	}
	
	/**
	 * Cerca un dipendente con nome e cognome indicati
	 * @param name
	 * 			nome
	 * @param surname
	 * 			cognome
	 * @return elenco di dipendenti compatibili
	 */
	public List<StaffMember> searchStaffMember (String name, String surname)
	{
		ArrayList<StaffMember> ris = new ArrayList<>();
		
		for (StaffMember sm : staff)
		{
			if(sm.getName().equalsIgnoreCase(name) && sm.getSurname().equalsIgnoreCase(surname))
				ris.add(sm);
		}
		
		return ris;
	}
	
	/**
	 * Cerca un paziente con nome e cognome indicati
	 * @param name
	 * 			nome
	 * @param surname
	 * 			cognome
	 * @return elenco di pazienti compatibili
	 */
	public List<Patient> searchPatient (String name, String surname)
	{
		ArrayList<Patient> ris = new ArrayList<>();
		
		for (Patient p : patients)
		{
			if(p.getName().equalsIgnoreCase(name) && p.getSurname().equalsIgnoreCase(surname))
				ris.add(p);
		}
		
		return ris;
	}
	
	/**
	 * Ritorna un periodo di disponibilità leggendo la data e l'ora
	 * @return periodo di disponibilità
	 */
	public AvailabilityPeriod getPeriodFromDate ()
	{
		Date d = IOLib.readDate();
		Date time = IOLib.readTime();
		List<AvailabilityPeriod> l = searchPeriod(d, time);
		
		if (l.size() == 0)
			throw new IllegalArgumentException(DATE_NOT_FOUND);
		else if (l.size() == 1)
			return l.get(0);
		
		return IOLib.getCollectionElement(l);
	}
	
	/**
	 * Ritorna un periodo di disponibilità da un dipendente
	 * @return periodo di disponibilità
	 */
	public AvailabilityPeriod getPeriodFromStaffMember ()
	{
		StaffMember sm = getStaffMember();
		List<AvailabilityPeriod> l = searchPeriod(sm);
		
		if (l.size() == 0)
			throw new IllegalArgumentException(DATE_NOT_FOUND);
		else if (l.size() == 1)
			return l.get(0);
		
		return IOLib.getCollectionElement(l);
	}
	
	/**
	 * Ritorna uno staff member leggendo nome e cognome
	 * @return StaffMember scelto dall'utente
	 */
	public StaffMember getStaffMember () throws IllegalArgumentException
	{
		String name = IOLib.readLine(INSERT_NAME);
		String surname = IOLib.readLine(INSERT_SURNAME);
		List<StaffMember> l = searchStaffMember(name, surname);
		
		if (l.size() == 0)
			throw new IllegalArgumentException(MEMBER_NOT_FOUND);
		else if (l.size() == 1)
			return l.get(0);
		
		return IOLib.getCollectionElement(l);
	}
	
	/**
	 * Ritorna un paziente leggendo nome e cognome
	 * @return paziente scelto dall'utente
	 */
	public Patient getPatient () throws IllegalArgumentException
	{
		String name = IOLib.readLine(INSERT_NAME);
		String surname = IOLib.readLine(INSERT_SURNAME);
		List<Patient> l = searchPatient(name, surname);
		
		if (l.size() == 0)
			throw new IllegalArgumentException(PATIENT_NOT_FOUND);
		else if (l.size() == 1)
			return l.get(0);
		
		return IOLib.getCollectionElement(l);
	}
	
	/**
	 * Ritorna un elenco di giorni scelti dall'utente via console
	 * @return elenco di giorni
	 */
	public List <WeekDay> readWeekDays ()
	{
		ArrayList<WeekDay> wd = new ArrayList<>();
		
		boolean another = true;
		
		while (another)
		{
			WeekDay d = WeekDay.readFromConsole();
			
			if (!wd.contains(d))
				wd.add(d);
			else
				IOLib.printLine(WEEKDAY_ALREADY_INSERT_ERROR);
			
			another = IOLib.twoWayQuestion("Aggiungere un altro giorno?");
		}
		
		return wd;
	}
	
	/**
	 * Voce menu riguardante gli orari
	 */
	private void useTimetable ()
	{
		final int ADD_PERIOD = 1;
		final int REMOVE_PERIOD = 2;
		final int PRINT_PERIODS = 3;
		
		MyMenu tMenu = new MyMenu(TIMETABLE_MENU, "Aggiungi disponibilità",
												  "Rimuovi disponibilità",
												  "Stampa disponibilità");
		
		int scelta;
		
		while ((scelta = tMenu.getChoice())!=MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
				case ADD_PERIOD:
					
					boolean ok = false;
					StaffMember member = null;
					
					while (!ok)
					{
						try
						{
							member = getStaffMember();
							ok = true;
						}
						catch (IllegalArgumentException e)
						{
							IOLib.printLine(e.getMessage());
						}
					}
					
					boolean weekday = false;
					
					IOLib.printLine("Inserisci data inizio:[gg/mm/aaaa] ");
					Date startDay = IOLib.readDate();
					
					IOLib.printLine("Inserisci data fine:[gg/mm/aaaa] ");
					Date endDay = IOLib.readDate();
					
					IOLib.printLine("Inserisci orario inizio:[hh:mm:ss] ");
					Date startTime = IOLib.readTimeInDate();
					
					IOLib.printLine("Inserisci orario fine:[hh:mm:ss] ");
					Date endTime = IOLib.readTimeInDate();
					
					weekday = IOLib.twoWayQuestion("Giorni della settimana specifici?");
					if (weekday)
					{
						availability.add(new AvailabilityPeriod(startDay, endDay, startTime, endTime, member, readWeekDays()));
					}
					else
					{
						availability.add(new AvailabilityPeriod(startDay, endDay, startTime, endTime, member));
					}
					
					break;
					
				case REMOVE_PERIOD:
					
					final int VIA_PERIOD = 1;
					final int VIA_STAFF_MEMBER = 2;
					
					MyMenu rMenu = new MyMenu("Come cercare il periodo di disponibilità:", "Inserisci periodo", "Inserisci dipendente coinvolto");
					
					int s;
					
					while ((s = rMenu.getChoice())!=MyMenu.EXIT_VALUE)
					{
						switch (s)
						{
							case VIA_PERIOD:
								
								availability.remove(getPeriodFromDate());
								
								break;
								
							case VIA_STAFF_MEMBER:
								
								availability.remove(getPeriodFromStaffMember());
								
								break;
						}
					}
					
					break;
					
				case PRINT_PERIODS:
					
					for (AvailabilityPeriod p : availability)
					{
						IOLib.printLine(p.toString()+"\n\n");
					}
					
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
		
		MyMenu sMenu = new MyMenu(STAFF_MENU, "Aggiungi dottore generico", "Aggiungi dottore specialistico", "Modifica dottore specialistico", "Rimuovi");
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
				
					ArrayList<SpecialistDoctor> specDot = new ArrayList<SpecialistDoctor>();
					
					for (StaffMember sm : staff)
					{
						if (sm instanceof SpecialistDoctor)
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
