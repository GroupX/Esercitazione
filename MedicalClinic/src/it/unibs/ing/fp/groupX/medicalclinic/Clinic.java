package it.unibs.ing.fp.groupX.medicalclinic;

import java.io.Serializable;
import java.sql.Time;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
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
	private static final String ALREADY_INSERTED_PATIENT = "Il paziente risulta gi� inserito";
	private static final String ALL_SEARCH_SKILL_AREA = "Cerca tra tutte";
	private static final String SEARCH_BY_NAME = "Cerca per nome";
	private static final String SKILL_AREA_RESEARCH_MENU = "Ricerca area di competenza";
	private static final String MODIFY_PATIENT = "Modifica";
	private static final String ALREADY_INSERTED_DOCTOR = "Il dottore risulta gi� inserito";
	private static final String MODIFY_SPECIALIST_DOCTOR = "Modifica dottore specialistico";
	private static final String ADD_SPECIALISTIC_DOCTOR = "Aggiungi dottore specialistico";
	private static final String ADD_GENERIC_DOCTOR = "Aggiungi dottore generico";
	private static final String SPECIFIC_WEEK_DAYS = "Giorni della settimana specifici?";
	private static final String INSERT_END_TIME = "Inserisci orario fine:[hh:mm:ss] ";
	private static final String INSERT_BEGIN_TIME = "Inserisci orario inizio:[hh:mm] ";
	private static final String INSERT_END_DATE = "Inserisci data fine:[gg/mm/aaaa] ";
	private static final String INSERT_BEGIN_DATE = "Inserisci data inizio:[gg/mm/aaaa] ";
	private static final String PRINT_AVAILABILITY = "Stampa disponibilit�";
	private static final String REMOVE_AVAILABILITY = "Rimuovi disponibilit�";
	private static final String ADD_AVAILABILITY = "Aggiungi disponibilit�";
	private static final String ADD_ANOTHER_DAY = "Aggiungere un altro giorno?";
	private static final String PATIENT_RESEARCH_MENU = "Ricerca pazienti";
	private static final String SKILL_AREA_RESEARCH = "Cerca per area di competenza";
	private static final String SPECIALISTIC_DOCTOR_RESEARCH_MENU = "Ricerca dottori specialistici";
	private static final String DOCTOR_RESEARCH_MENU = "Ricerca dottori";
	private static final String NAME_AND_SURNAME_RESEARCH = "Cerca per nome e cognome";
	private static final String STAFF_RESEARCH = "Ricerca staff";
	private static final String ALL_RESEARCH = "Cerca tra tutti";
	private static final String MEMBER_RESEARCH = "Cerca per membro";
	private static final String PERIOD_RESEARCH = "Ricerca periodi";
	private static final String INSERT_TIME = "Inserisci l'ora [hh:mm:ss]";
	private static final String INSERT_DATE = "Inserisci la data [dd/MM/aaaa]";
	private static final String ALL_DATE_RESEARCH = "Scegli tra tutte";
	private static final String DATE_RESEARCH = "Cerca per data";
	private static final String PATIENT_RESEARCH = "Cerca per paziente";
	private static final String DOCTOR_RESEARCH = "Cerca per dottore";
	private static final String VISIT_RESEARCH = "Ricerca visite";
	private static final String SURE_TO_REMOVE = "Sicuro di voler rimuovere? ";
	private static final String INSERT_MOTIVATION = "Inserisci la motivazione della visita: ";
	private static final String NEXT_DATE = "Prossima data disponibile: %s";
	private static final String IMPOSSIBLE_AT_SPECIFIED_TIME = "Impossibile all'orario specificato";
	private static final String INSERT_DATE_TIME = "Inserisci la data e l'ora desiderata: [gg/MM/aaaa oo:mm]";
	private static final String SELECT_PATIENT = "Seleziona il paziente per la visita: ";
	private static final String PRINT_VISIT = "Stampa visita";
	private static final String REMOVE_VISIT = "Rimuovi visita";
	private static final String MODIFY_VISIT = "Modifica visita";
	private static final String ADD_SPECIALISTIC_VISIT = "Aggiungi visita specialistica";
	private static final String ADD_GENERIC_VISIT = "Aggiungi visita generica";
	private static final String SKILL_AREA_ALREADY_INSERTED = "L'area di competenza risulta gi� inserita";
	private static final String PRINT_PATIENT = "Stampa";
	private static final String REMOVE_PATIENT = "Rimuovi";
	private static final String ADD_PATIENT = "Aggiungi";
	private static final String PERIOD_NOT_INSERTED = "Periodo di disponibilit� non inserito";
	private static final String PERIOD_ALREADY_INSERTED = "Periodo di disponibilit� gi� inserito";
	private static final String PATIENT_NOT_INSERTED = "Paziente non inserito";
	private static final String PATIENT_ALREADY_INSERTED = "Paziente gi� inserito";
	private static final String MEMBER_NOT_INSERTED = "Dipendente non inserito";
	private static final String MEMBER_ALREADY_INSERTED = "Dipendente gi� inserito";
	private static final String VISIT_NOT_PRESENT = "Visita non inserita";
	private static final String ALREADY_INSERTED_VISIT = "Visita gi� inserita";
	private static final String ALREADY_INSERTED_SKILL_AREA = "Area di competenza gi� inserita";
	private static final String NO_SKILL_AREA = "Area di competenza non esistente";
	private static final String NO_PERIOD = "Nessun periodo trovato";
	private static final String NO_VISIT_MSG = "Nessuna visita trovata";
	private static final String NO_COMPATIBLE_DATES = "Non esistono orari compatibili successivi. Provare orari precedenti";
	private static final String TIME_INCOMPATIBLE_WITH_CLINIC_TIME = "Orario non rispetta gli orari della clinica";
	private static final String READ_SKILL_AREA_NOT_FOUND_ERROR = "Area di competenza inserita non presente nell'elenco";
	private static final String AVAILABILITY_PERIOD_ADD_REDUNDANCY_ERROR = "Periodo di disponibilit� gi� presente";
	private static final String WEEKDAY_ALREADY_INSERT_ERROR = "Giorno gi� inserito";
	private static final String DATE_NOT_FOUND = "Data non trovata";
	private static final String PATIENT_NOT_FOUND = "Paziente non trovato";
	private static final String MEMBER_NOT_FOUND = "Membro non trovato";
	private static final String INSERT_SURNAME = "Inserisci cognome: ";
	private static final String INSERT_NAME = "Inserisci nome: ";
	private static final String INSERT_STAFF_MEMBER_MESSAGE = "Seleziona il dipendente:";
	private static final String INSERT_END_TIME_MESSAGE = "Inserisci orario fine disponibilit�: ";
	private static final String INSERT_START_TIME_MESSAGE = "Inserisci orario inizio disponibilit�: ";
	
	// Orari come da traccia
	/** Orario di apertura clinica */
	private static final String OPEN_TIME = "08:00:00";
	/** Orario di chiusura clinica */
	private static final String CLOSE_TIME = "18:00:00";
	
	/** Opzione menu principale per salvare */
	private static final String SAVE_MENU = "Salva";
	/** Titolo menu aree di competenza */
	private static final String SKILL_AREAS_MENU = "Gestisci aree di competenza";
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
	/** Lista di orari di disponibilit� */
	List<AvailabilityPeriod> availability = new ArrayList<>();
	
	/**
	 * Costruttore
	 */
	public Clinic ()
	{
		
	}
	
	public void addSkillArea (SkillArea sa) throws IllegalArgumentException
	{
		if (skAreas.contains(sa))
		{
			throw new IllegalArgumentException(ALREADY_INSERTED_SKILL_AREA);
		}
		else
		{
			skAreas.add(sa);
		}
	}
	
	public void removeSkillArea (SkillArea sa) throws IllegalArgumentException
	{
		if (!skAreas.contains(sa))
		{
			throw new IllegalArgumentException(NO_SKILL_AREA);
		}
		else
		{
			skAreas.remove(sa);
		}
	}
	
	public boolean hasSkillArea (SkillArea sa)
	{
		return skAreas.contains(sa);
	}
	
	public void addVisit (Visit v) throws IllegalArgumentException
	{
		if (visits.contains(v))
		{
			throw new IllegalArgumentException(ALREADY_INSERTED_VISIT);
		}
		else
		{
			visits.add(v);
		}
	}
	
	public void removeVisit (Visit v) throws IllegalArgumentException
	{
		if (!visits.contains(v))
		{
			throw new IllegalArgumentException(VISIT_NOT_PRESENT);
		}
		else
		{
			visits.remove(v);
		}
	}
	
	public void addStaffMember (StaffMember sm) throws IllegalArgumentException
	{
		if (staff.contains(sm))
		{
			throw new IllegalArgumentException(MEMBER_ALREADY_INSERTED);
		}
		else
		{
			staff.add(sm);
		}
	}
	
	public void removeStaffMember (StaffMember sm) throws IllegalArgumentException
	{
		if (!staff.contains(sm))
		{
			throw new IllegalArgumentException(MEMBER_NOT_INSERTED);
		}
		else
		{
			staff.remove(sm);
		}
	}
	
	public void addPatient (Patient p) throws IllegalArgumentException
	{
		if (patients.contains(p))
		{
			throw new IllegalArgumentException(PATIENT_ALREADY_INSERTED);
		}
		else
		{
			patients.add(p);
		}
	}
	
	public void removePatient (Patient p) throws IllegalArgumentException
	{
		if (!patients.contains(p))
		{
			throw new IllegalArgumentException(PATIENT_NOT_INSERTED);
		}
		else
		{
			patients.remove(p);
		}
	}
	
	public void addAvailability (AvailabilityPeriod ap) throws IllegalArgumentException
	{
		if (availability.contains(ap))
		{
			throw new IllegalArgumentException(PERIOD_ALREADY_INSERTED);
		}
		else
		{
			availability.add(ap);
		}
	}
	
	public void removeAvailability (AvailabilityPeriod ap) throws IllegalArgumentException
	{
		if (!availability.contains(ap))
		{
			throw new IllegalArgumentException(PERIOD_NOT_INSERTED);
		}
		else
		{
			availability.remove(ap);
		}
	}
	
	@Override
	public void use() {
		final int PATIENT_VOICE = 1;
		final int STAFF_VOICE = 2;
		final int TIMETABLE_VOICE = 3;
		final int VISIT_VOICE = 4;
		final int SKILL_AREAS_VOICE = 5;
		final int SAVE = 6;
		
		MyMenu m = new MyMenu(MENU_TITLE, PATIENT_MENU, STAFF_MENU, TIMETABLE_MENU, VISIT_MENU, SKILL_AREAS_MENU, SAVE_MENU);
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
				
				case SKILL_AREAS_VOICE:
					
					useSkillAreas();
					
					break;
					
				case SAVE:
					
					//SERVE DATAMANAGER
					
					break;
			}
		}
	}
	
	private void useSkillAreas ()
	{
		final int ADD = 1;
		final int REMOVE = 2;
		final int PRINT = 3;
		
		MyMenu sMenu = new MyMenu(PATIENT_MENU, ADD_PATIENT, REMOVE_PATIENT, PRINT_PATIENT);
		int scelta;
		
		while ((scelta = sMenu.getChoice())!=MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
				case ADD:
					
					SkillArea sa = SkillArea.readFromConsole();
					
					if (skAreas.contains(sa))
					{
						IOLib.printLine(SKILL_AREA_ALREADY_INSERTED);
					}
					else
					{
						skAreas.add(sa);
					}
					
					break;
					
				case REMOVE:
					
					try
					{
						skAreas.remove(getSkillArea());
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
					
				case PRINT:
					
					try
					{
						IOLib.printLine(getSkillArea().toString());
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
			}
		}
	}
	
	/**
	 * Ritorna una lista di dottori che possono visitare in una certa data
	 * @param d data (con ora)
	 * @return Lista di dottori
	 */
	public List<Doctor> getAvailableDoctor (Date d)
	{
		ArrayList<Doctor> ris = new ArrayList<>();
		
		try {
			Date onlyTime = Utilities.stringToTimeInDate(Utilities.timeInDateToString(d));
			Date onlyDate = Utilities.stringToDate(Utilities.dateToString(d));
			
			for (AvailabilityPeriod p: availability)
			{
				if (p.compatibleWith(onlyDate, onlyTime))
				{
					if (p.getSm() instanceof Doctor)
					{
						Doctor doc = (Doctor) p.getSm();
						
						boolean add = true;
						List<Visit> visitsDoctor = searchVisit(doc);
						
						for (Visit v : visitsDoctor)
						{
							if (v.overlaps(d))
									add = false;
						}
						
						if (!ris.contains(doc) && add)
							ris.add(doc);
					}
				}
			}
			
			
		} catch (ParseException e) {
			// E' per forza gi� corretta
			e.printStackTrace();
		}
		
		return ris;
		
	}
	
	/**
	 * Ritorna una lista di dottori specialisti che possono visitare in una certa data
	 * @param d data (con ora)
	 * @param sk Area di competenza richiesta
	 * @return Lista di dottori
	 */
	public List<SpecialistDoctor> getAvailableSpecialistDoctor (Date d, SkillArea sk)
	{
		ArrayList<SpecialistDoctor> ris = new ArrayList<>();
		
		try {
			Date onlyTime = Utilities.stringToTimeInDate(Utilities.timeInDateToString(d));
			Date onlyDate = Utilities.stringToDate(Utilities.dateToString(d));
			
			for (AvailabilityPeriod p: availability)
			{
				if (p.compatibleWith(onlyDate, onlyTime))
				{
					if (p.getSm() instanceof SpecialistDoctor)
					{
						SpecialistDoctor doc = (SpecialistDoctor) p.getSm();
						
						boolean add = true;
						
						if (doc.isAble(sk))
						{
						
							List<Visit> visitsDoctor = searchVisit(doc);
							
							for (Visit v : visitsDoctor)
							{
								if (v.overlaps(d))
										add = false;
							}
						}
						else
						{
							add = false;
						}
						
						if (!ris.contains(doc) && add)
							ris.add(doc);
					}
				}
			}
			
			
		} catch (ParseException e) {
			// E' per forza gi� corretta
			e.printStackTrace();
		}
		
		return ris;
		
	}
	
	/**
	 * Ritorna vero se esistono periodi seguenti compatibili, false altrimenti
	 * @param d Data
	 * @return true: esistono altri periodi compatibili, false: non esistono
	 */
	public boolean areThereSubsequentDates (Date d)
	{
		
		try {
			Date onlyTime = Utilities.stringToTimeInDate(Utilities.timeInDateToString(d));
			Date onlyDate = Utilities.stringToDate(Utilities.dateToString(d));
			
			for (AvailabilityPeriod p : availability)
			{
				if (p.getEndDay().compareTo(onlyDate)>0)
				{
					return true;
				}
				else if (p.getEndDay().compareTo(onlyDate)==0 && p.getEndTime().compareTo(onlyTime)>=0)
				{
					return true;
				}
			
			return false;
			}
		} catch (ParseException e) {
			// E' gi� corretta per forza
			e.printStackTrace();
		}
		
		return false;

	}
	
	/**
	 * Ritorna la prossima data suggerita
	 * @param d Data desiderata
	 * @return Data suggerita
	 */
	public Date suggestNextDate (Date d)
	{
		
		boolean ok = false;
		
		if (d.compareTo(getMinDate())<0)
			d = getMinDate();
		
		Date next = d;
		
		do 
		{
			next = Utilities.getNextDate30Min(next);
			List<Doctor> dLst = getAvailableDoctor(next);
			if (dLst.size() != 0)
				ok = true;
			
			if (!areThereSubsequentDates(next) && !ok)
				throw new IllegalArgumentException(NO_COMPATIBLE_DATES);
			
		}while (!ok);
		
		return next;
	}
	
	/**
	 * Restituisce la data minima da cui iniziare a cercare per la data suggerita
	 * @return Data minima
	 */
	public Date getMinDate ()
	{
		Date min = null;
		
		for (AvailabilityPeriod p : availability)
		{
			if (min == null)
				min = p.getStartDay();
			else if (p.getStartDay().compareTo(min)<0)
				min = p.getStartDay();
		}
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(min);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	
	/**
	 * Ritorna la prossima data suggerita
	 * @param d Data desiderata
	 * @param sk Area di competenza richiesta
	 * @return Data suggerita
	 */
	public Date suggestNextDate (Date d, SkillArea sk)
	{
		
		boolean ok = false;
		
		if (d.compareTo(getMinDate())<0)
			d = getMinDate();
		
		Date next = d;
		
		do 
		{
			next = Utilities.getNextDate30Min(next);
			List<SpecialistDoctor> dLst = getAvailableSpecialistDoctor(next, sk);
			if (dLst.size() != 0)
				ok = true;
			
			if (!areThereSubsequentDates(next) && !ok)
				throw new IllegalArgumentException(NO_COMPATIBLE_DATES);
			
		}while (!ok);
		
		return next;
	}
	
	/**
	 * Voce menu riguardante le visite
	 */
	private void useVisit ()
	{
		final int ADD_GENERAL_VOICE = 1;
		final int ADD_SPECIALISTIC_VOICE = 2;
		final int CHANGE_VOICE = 3;
		final int REMOVE_VOICE = 4;
		final int PRINT_VOICE = 5;
		
		MyMenu vMenu = new MyMenu(VISIT_MENU, ADD_GENERIC_VISIT, ADD_SPECIALISTIC_VISIT, MODIFY_VISIT, REMOVE_VISIT, PRINT_VISIT);
		
		int scelta;
		
		boolean ok;
		Patient p;
		boolean dateOk;
		Date date;
		String motivation;
		
		while ( (scelta=vMenu.getChoice()) != MyMenu.EXIT_VALUE )
		{
			switch (scelta)
			{
				case ADD_GENERAL_VOICE:
					
					ok = false;
					p = null;
					do
					{
						try
						{
							IOLib.printLine(SELECT_PATIENT);
							p = getPatient();
							ok = true;
						}
						catch (IllegalArgumentException e)
						{
							IOLib.printLine(e.getMessage());
						}
					}while (!ok);
					
					dateOk = false;
					
					List <Doctor> dList = null;
					date = null;
					
					while (!dateOk)
					{
						IOLib.printLine(INSERT_DATE_TIME);
						date = IOLib.readDateTime();
						
						dList = getAvailableDoctor(date);
						
						if (dList.size() == 0)
						{
							IOLib.printLine(IMPOSSIBLE_AT_SPECIFIED_TIME);
							
							try
							{
								Date d = suggestNextDate(date);
								IOLib.printLine(String.format(NEXT_DATE, Utilities.dateTimeToString(d)));
							}
							catch (IllegalArgumentException e)
							{
								IOLib.printLine(e.getMessage());
							}
						}
						else
						{
							dateOk = true;
						}
					}
					
					Doctor doc = IOLib.getIterableElement(dList);
					
					motivation = IOLib.readLine(INSERT_MOTIVATION);
					
					visits.add(new Visit(p, motivation, date, doc));

					break;
					
				case ADD_SPECIALISTIC_VOICE:
					
					ok = false;
					p = null;
					do
					{
						try
						{
							IOLib.printLine(SELECT_PATIENT);
							p = getPatient();
							ok = true;
						}
						catch (IllegalArgumentException e)
						{
							IOLib.printLine(e.getMessage());
						}
					}while (!ok);
					
					dateOk = false;
					
					List <SpecialistDoctor> sdList = null;
					date = null;
					
					SkillArea sa = getSkillArea();
					
					while (!dateOk)
					{
						IOLib.printLine(INSERT_DATE_TIME);
						date = IOLib.readDateTime();
						
						sdList = getAvailableSpecialistDoctor(date, sa);
						
						if (sdList.size() == 0)
						{
							IOLib.printLine(IMPOSSIBLE_AT_SPECIFIED_TIME);
							
							try
							{
								Date d = suggestNextDate(date, sa);
								IOLib.printLine(String.format(NEXT_DATE, Utilities.dateTimeToString(d)));
							}
							catch (IllegalArgumentException e)
							{
								IOLib.printLine(e.getMessage());
							}
						}
						else
						{
							dateOk = true;
						}
					}
					
					SpecialistDoctor sdoc = IOLib.getIterableElement(sdList);
					
					motivation = IOLib.readLine(INSERT_MOTIVATION);
					
					visits.add(new SpecialisticVisit(p, motivation, date, sdoc, sa));
					
					break;
					
				case CHANGE_VOICE:
					
					try
					{
						Visit v = getVisit();
						
						v.use();
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
					
				case REMOVE_VOICE:
					
					try
					{
						Visit v = getVisit();
						
						boolean sure = IOLib.twoWayQuestion(SURE_TO_REMOVE);
						
						if (sure)
							visits.remove(v);
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
					
				case PRINT_VOICE:
											
					try
					{
						Visit v = getVisit();
						
						IOLib.printLine(v.toString());
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;

			}
		}
	}
	
	public Visit getVisit ()
	{
		final int SEARCH_DOCTOR_VOICE = 1;
		final int SEARCH_PATIENT_VOICE = 2;
		final int SEARCH_DATE_VOICE = 3;
		final int SEARCH_ALL_VOICE = 4;
		
		MyMenu vMenu = new MyMenu(VISIT_RESEARCH, false, DOCTOR_RESEARCH, PATIENT_RESEARCH, DATE_RESEARCH, ALL_DATE_RESEARCH);
		
		Visit ris = null;
		
		int scelta;
		List<Visit> vList;

		scelta = vMenu.getChoice();

		switch (scelta)
		{
			case SEARCH_DOCTOR_VOICE:
				
				Doctor d = getDoctor();
				
				vList = searchVisit(d);
				
				ris = IOLib.getIterableElement(vList);
					
				break;
				
			case SEARCH_PATIENT_VOICE:
				
				Patient p = getPatient();
				
				vList = searchVisit(p);
				
				ris = IOLib.getIterableElement(vList);
				
				break;
				
			case SEARCH_DATE_VOICE:
				
				Date dt = IOLib.readDateTime();
				
				vList = searchVisit(dt);
				
				ris = IOLib.getIterableElement(vList);
				
				break;	
				
			case SEARCH_ALL_VOICE:
				
				ris = IOLib.getIterableElement(visits);
		}
		
		if (ris == null)
			throw new IllegalArgumentException(NO_VISIT_MSG);
		
		return ris;
	}
	
	/**
	 * Cerca una visita
	 * @param d
	 * 			dottore coinvolto
	 * @return Lista delle visite trovati
	 */
	public List<Visit> searchVisit (Doctor d)
	{
		ArrayList <Visit> ris = new ArrayList<>();
		
		for (Visit v : visits)
		{
			if (v.getDoctor().equals(d))
				ris.add(v);
		}
		
		return ris;
	}
	
	/**
	 * Cerca una visita
	 * @param p
	 * 			paziente coinvolto
	 * @return Lista delle visite trovati
	 */
	public List<Visit> searchVisit (Patient p)
	{
		ArrayList <Visit> ris = new ArrayList<>();
		
		for (Visit v : visits)
		{
			if (v.getPatient().equals(p))
				ris.add(v);
		}
		
		return ris;
	}
	
	/**
	 * Cerca una visita
	 * @param d
	 * 			data e ora visita
	 * @return Lista delle visite trovati
	 */
	public List<Visit> searchVisit (Date d)
	{
		ArrayList <Visit> ris = new ArrayList<>();
		
		for (Visit v : visits)
		{
			if (v.getDate().compareTo(d) == 0)
				ris.add(v);
		}
		
		return ris;
	}
	
	/**
	 * Cerca un periodo di disponibilit�
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
	 * Cerca un periodo di disponibilit�
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
	 * Cerca un dottore con nome e cognome indicati
	 * @param name
	 * 			nome
	 * @param surname
	 * 			cognome
	 * @return elenco di dottori compatibili
	 */
	public List<Doctor> searchDoctor (String name, String surname)
	{
		ArrayList<Doctor> ris = new ArrayList<>();
		
		for (StaffMember sm : staff)
		{
			if(sm.getName().equalsIgnoreCase(name) && sm.getSurname().equalsIgnoreCase(surname) && sm instanceof Doctor)
				ris.add((Doctor) sm);
		}
		
		return ris;
	}
	
	/**
	 * Cerca un dottore specialistico con nome e cognome indicati
	 * @param name
	 * 			nome
	 * @param surname
	 * 			cognome
	 * @return elenco di dottori specialistici compatibili
	 */
	public List<SpecialistDoctor> searchSpecialistDoctor (String name, String surname)
	{
		ArrayList<SpecialistDoctor> ris = new ArrayList<>();
		
		for (SpecialistDoctor sd : getSpecialistDoctorsFromStaff())
		{
			
			if(sd.getName().equalsIgnoreCase(name) && sd.getSurname().equalsIgnoreCase(surname))
			{
				ris.add(sd);
			}
				
		}
		
		return ris;
	}
	
	/**
	 * Ricerca dottore specialistico per area di competenza
	 * @param sa Area
	 * @return dottore
	 */
	public List<SpecialistDoctor> searchSpecialistDoctor (SkillArea sa)
	{
		ArrayList<SpecialistDoctor> ris = new ArrayList<>();
		
		for (SpecialistDoctor sd : getSpecialistDoctorsFromStaff())
		{
			
			if(sd.isAble(sa))
			{
				ris.add(sd);
			}
				
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
	 * Ritorna un periodo di disponibilit� leggendo la data e l'ora
	 * @return periodo di disponibilit�
	 */
	public AvailabilityPeriod getPeriodFromDate () throws IllegalArgumentException
	{
		IOLib.printLine(INSERT_DATE);
		Date d = IOLib.readDate();
		IOLib.printLine(INSERT_TIME);
		Date time = IOLib.readTime();
		List<AvailabilityPeriod> l = searchPeriod(d, time);
		
		if (l.size() == 0)
			throw new IllegalArgumentException(DATE_NOT_FOUND);
		else if (l.size() == 1)
			return l.get(0);
		
		return IOLib.getIterableElement(l);
	}
	
	/**
	 * Ritorna un periodo di disponibilit� da un dipendente
	 * @return periodo di disponibilit�
	 */
	public AvailabilityPeriod getPeriodFromStaffMember () throws IllegalArgumentException
	{
		StaffMember sm = getStaffMember();
		List<AvailabilityPeriod> l = searchPeriod(sm);
		
		if (l.size() == 0)
			throw new IllegalArgumentException(DATE_NOT_FOUND);
		else if (l.size() == 1)
			return l.get(0);
		
		return IOLib.getIterableElement(l);
	}
	
	/**
	 * Ritorna un periodo cercandolo
	 * @return Il periodo richiesto
	 */
	public AvailabilityPeriod getPeriod () 
	{
		final int SEARCH_STAFF_VOICE = 1;
		final int SEARCH_DATE_VOICE = 2;
		final int SEARCH_ALL_VOICE = 3;
		
		MyMenu vMenu = new MyMenu(PERIOD_RESEARCH, false, MEMBER_RESEARCH, DATE_RESEARCH, ALL_RESEARCH);
		
		AvailabilityPeriod ris = null;
		
		int scelta;

		scelta = vMenu.getChoice();

		switch (scelta)
		{
			case SEARCH_STAFF_VOICE:
				
				ris = getPeriodFromStaffMember();
					
				break;
				
			case SEARCH_DATE_VOICE:
				
				ris = getPeriodFromDate();
				
				break;	
				
			case SEARCH_ALL_VOICE:
				
				ris = IOLib.getIterableElement(availability);
		}
		
		if (ris == null)
			throw new IllegalArgumentException(NO_PERIOD);
		
		return ris;
	}
	
	/**
	 * Ritorna uno staff member leggendo nome e cognome
	 * @return StaffMember scelto dall'utente
	 */
	public StaffMember getStaffMember () throws IllegalArgumentException
	{
		final int SEARCH_NAME_VOICE = 1;
		final int SEARCH_ALL_VOICE = 2;
		
		MyMenu vMenu = new MyMenu(STAFF_RESEARCH, false, NAME_AND_SURNAME_RESEARCH, ALL_RESEARCH);
		
		StaffMember ris = null;
		
		int scelta;

		scelta = vMenu.getChoice();

		switch (scelta)
		{
		case SEARCH_NAME_VOICE:
			
			String name = IOLib.readLine(INSERT_NAME);
			String surname = IOLib.readLine(INSERT_SURNAME);
			List<StaffMember> l = searchStaffMember(name, surname);
			
			if (l.size() == 0)
				throw new IllegalArgumentException(MEMBER_NOT_FOUND);
			else if (l.size() == 1)
				return l.get(0);
			
			ris = IOLib.getIterableElement(l);
			
			break;
			
		case SEARCH_ALL_VOICE:
			
			ris = IOLib.getIterableElement(staff);
			
			break;
			
		}
		
		return ris;
	}
	
	/**
	 * Ritorna solo i dottori
	 * @return dottori
	 */
	public List<Doctor> getDoctorsFromStaff ()
	{
		ArrayList<Doctor> ris = new ArrayList<>();
		
		for (StaffMember m : staff)
		{
			if (m instanceof Doctor)
				ris.add((Doctor)m);
		}
		
		return ris;
	}
	
	/**
	 * Ritorna un dottore leggendo nome e cognome
	 * @return Doctor scelto dall'utente
	 */
	public Doctor getDoctor () throws IllegalArgumentException
	{
		final int SEARCH_NAME_VOICE = 1;
		final int SEARCH_ALL_VOICE = 2;
		
		MyMenu vMenu = new MyMenu(DOCTOR_RESEARCH_MENU, false, NAME_AND_SURNAME_RESEARCH, ALL_RESEARCH);
		
		Doctor ris = null;
		
		int scelta;

		scelta = vMenu.getChoice();

		switch (scelta)
		{
		case SEARCH_NAME_VOICE:
			
			String name = IOLib.readLine(INSERT_NAME);
			String surname = IOLib.readLine(INSERT_SURNAME);
			List<Doctor> l = searchDoctor(name, surname);
			
			if (l.size() == 0)
				throw new IllegalArgumentException(MEMBER_NOT_FOUND);
			else if (l.size() == 1)
				return l.get(0);
			
			ris = IOLib.getIterableElement(l);
			
			break;
			
		case SEARCH_ALL_VOICE:
			
			ris = IOLib.getIterableElement(getDoctorsFromStaff());
			
			break;
			
		}
		
		return ris;
		
		
	}
	
	/**
	 * Ritorna solo i dottori specialistici
	 * @return dottori specialistici
	 */
	public List<SpecialistDoctor> getSpecialistDoctorsFromStaff ()
	{
		ArrayList<SpecialistDoctor> ris = new ArrayList<>();
		
		for (StaffMember m : staff)
		{
			if (m instanceof SpecialistDoctor)
				ris.add((SpecialistDoctor)m);
		}
		
		return ris;
	}
	
	/**
	 * Ritorna un dottore leggendo nome e cognome
	 * @return Doctor scelto dall'utente
	 */
	public SpecialistDoctor getSpecialistDoctor () throws IllegalArgumentException
	{
		final int SEARCH_NAME_VOICE = 1;
		final int SEARCH_SKILL_AREA_VOICE = 2;
		final int SEARCH_ALL_VOICE = 3;
		
		MyMenu vMenu = new MyMenu(SPECIALISTIC_DOCTOR_RESEARCH_MENU, false, NAME_AND_SURNAME_RESEARCH, SKILL_AREA_RESEARCH, ALL_RESEARCH);
		
		SpecialistDoctor ris = null;
		
		int scelta;

		scelta = vMenu.getChoice();

		switch (scelta)
		{
		case SEARCH_NAME_VOICE:
			
			String name = IOLib.readLine(INSERT_NAME);
			String surname = IOLib.readLine(INSERT_SURNAME);
			List<SpecialistDoctor> l = searchSpecialistDoctor(name, surname);
			
			if (l.size() == 0)
				throw new IllegalArgumentException(MEMBER_NOT_FOUND);
			else if (l.size() == 1)
				return l.get(0);
			
			ris = IOLib.getIterableElement(l);
			
			break;
		case SEARCH_SKILL_AREA_VOICE:
			
			SkillArea sa = SkillArea.readFromConsole();
			
			if (!skAreas.contains(sa))
				throw new IllegalArgumentException(READ_SKILL_AREA_NOT_FOUND_ERROR);
			
			break;
		case SEARCH_ALL_VOICE:
			
			ris = IOLib.getIterableElement(getSpecialistDoctorsFromStaff());
			
			break;
			
		}
		
		return ris;
	}
	
	/**
	 * Ritorna un paziente leggendo nome e cognome
	 * @return paziente scelto dall'utente
	 */
	public Patient getPatient () throws IllegalArgumentException
	{
		final int SEARCH_NAME_VOICE = 1;
		final int SEARCH_ALL_VOICE = 2;
		
		MyMenu vMenu = new MyMenu(PATIENT_RESEARCH_MENU, false, NAME_AND_SURNAME_RESEARCH, ALL_RESEARCH);
		
		Patient ris = null;
		
		int scelta;

		scelta = vMenu.getChoice();

		switch (scelta)
		{
		case SEARCH_NAME_VOICE:
			
			String name = IOLib.readLine(INSERT_NAME);
			String surname = IOLib.readLine(INSERT_SURNAME);
			List<Patient> l = searchPatient(name, surname);
			
			if (l.size() == 0)
				throw new IllegalArgumentException(PATIENT_NOT_FOUND);
			else if (l.size() == 1)
				return l.get(0);
			
			ris = IOLib.getIterableElement(l);
			
			break;
			
		case SEARCH_ALL_VOICE:
			
			ris = IOLib.getIterableElement(patients);
			
			break;
			
		}
		
		return ris;
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
			
			another = IOLib.twoWayQuestion(ADD_ANOTHER_DAY);
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
		
		MyMenu tMenu = new MyMenu(TIMETABLE_MENU, ADD_AVAILABILITY,
												  REMOVE_AVAILABILITY,
												  PRINT_AVAILABILITY);
		
		int scelta, s;
		
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
					
					IOLib.printLine(INSERT_BEGIN_DATE);
					Date startDay = IOLib.readDate();
					
					IOLib.printLine(INSERT_END_DATE);
					Date endDay = IOLib.readDate();
					
					Date startTime;
					Date endTime;
					do
					{
						IOLib.printLine(INSERT_BEGIN_TIME);
						startTime = IOLib.readTimeInDate();
						
						if (startTime.before(Utilities.stringToTimeInDateNoException(OPEN_TIME)) && startTime.after(Utilities.stringToTimeInDateNoException(CLOSE_TIME)))
							IOLib.printLine(TIME_INCOMPATIBLE_WITH_CLINIC_TIME);
					}while (startTime.before(Utilities.stringToTimeInDateNoException(OPEN_TIME)) && startTime.after(Utilities.stringToTimeInDateNoException(CLOSE_TIME)));
						
					do
					{
						IOLib.printLine(INSERT_END_TIME);
						endTime = IOLib.readTimeInDate();
						
						if (endTime.before(Utilities.stringToTimeInDateNoException(OPEN_TIME)) && endTime.after(Utilities.stringToTimeInDateNoException(CLOSE_TIME)))
							IOLib.printLine(TIME_INCOMPATIBLE_WITH_CLINIC_TIME);
					}while (endTime.before(Utilities.stringToTimeInDateNoException(OPEN_TIME)) && endTime.after(Utilities.stringToTimeInDateNoException(CLOSE_TIME)));
					
					weekday = IOLib.twoWayQuestion(SPECIFIC_WEEK_DAYS);
					
					AvailabilityPeriod ap;
					
					if (weekday)
					{
						ap = new AvailabilityPeriod(startDay, endDay, startTime, endTime, member, readWeekDays());
					}
					else
					{
						ap = new AvailabilityPeriod(startDay, endDay, startTime, endTime, member);
					}
					
					if (availability.contains(ap))
					{
						IOLib.printLine(AVAILABILITY_PERIOD_ADD_REDUNDANCY_ERROR);
					}
					else
					{
						availability.add(ap);
					}
					
					break;
					
				case REMOVE_PERIOD:
					
					try
					{
						AvailabilityPeriod p = getPeriod();
						
						availability.remove(p);
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.toString());
					}
					
					break;
					
				case PRINT_PERIODS:
					
							
					try
					{
						AvailabilityPeriod p = getPeriod();
						
						IOLib.printLine(p.toString());
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.toString());
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
		final int PRINT = 5;
		
		MyMenu sMenu = new MyMenu(STAFF_MENU, ADD_GENERIC_DOCTOR, ADD_SPECIALISTIC_DOCTOR, MODIFY_SPECIALIST_DOCTOR, REMOVE_PATIENT, PRINT_PATIENT);
		int scelta;
		
		while ((scelta = sMenu.getChoice())!=MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
				case ADD_GENERAL:
					
					Doctor d = Doctor.readFromConsole();
					
					if (staff.contains(d))
					{
						IOLib.printLine(ALREADY_INSERTED_DOCTOR);
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
						IOLib.printLine(ALREADY_INSERTED_DOCTOR);
					}
					else
					{
						staff.add(sd);
					}
					
					break;
					
				case CHANGE:
					
					try
					{
						getSpecialistDoctor().use();
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
				
				case REMOVE:
					
					try
					{
						staff.remove(getStaffMember());
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
					
				case PRINT:
					
					try
					{
						IOLib.printLine(getStaffMember().toString());
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
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
		final int PRINT = 4;
		
		MyMenu pMenu = new MyMenu(PATIENT_MENU, ADD_PATIENT, MODIFY_PATIENT, REMOVE_PATIENT, PRINT_PATIENT);
		int scelta;
		
		while ((scelta = pMenu.getChoice())!=MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
				case ADD:
					
					Patient p = Patient.readFromConsole();
					
					if (patients.contains(p))
					{
						IOLib.printLine(ALREADY_INSERTED_PATIENT);
					}
					else
					{
						patients.add(p);
					}
					
					break;
				
				case CHANGE:
					
					try
					{
					
						getPatient().use();
					
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
					
				case REMOVE:
					
					try
					{
						patients.remove(getPatient());
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
					
				case PRINT:
					
					try
					{
						IOLib.printLine(getPatient().toString());
					}
					catch (IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
			}
		}
	}
	
	/**
	 * Ritorna una skill area presente nella clinica
	 * @return
	 */
	public SkillArea getSkillArea()
	{
		final int SEARCH_NAME_VOICE = 1;
		final int SEARCH_ALL_VOICE = 2;
		
		MyMenu vMenu = new MyMenu(SKILL_AREA_RESEARCH_MENU, false, SEARCH_BY_NAME, ALL_SEARCH_SKILL_AREA);
		
		int scelta;

		SkillArea sk = null;
		
		scelta = vMenu.getChoice();

		switch (scelta)
		{
		case SEARCH_NAME_VOICE:
			
			boolean ok = false;
			
			do
			{
				sk = SkillArea.readFromConsole();
				
				if (skAreas.contains(sk))
					ok = true;
				else
					IOLib.printLine(NO_SKILL_AREA);
			}while (!ok);
			
			break;
			
		case SEARCH_ALL_VOICE:
			
			sk = IOLib.getIterableElement(skAreas);
			
			break;
			
		}

		
		return sk;
	}
}
