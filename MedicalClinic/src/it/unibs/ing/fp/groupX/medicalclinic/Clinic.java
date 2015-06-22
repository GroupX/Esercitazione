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
	private static final String NO_PERIOD = "Nessun periodo trovato";
	private static final String NO_VISIT_MSG = "Nessuna visita trovata";
	private static final String NO_COMPATIBLE_DATES = "Non esistono orari compatibili successivi. Provare orari precedenti";
	private static final String TIME_INCOMPATIBLE_WITH_CLINIC_TIME = "Orario non rispetta gli orari della clinica";
	private static final String READ_SKILL_AREA_NOT_FOUND_ERROR = "Area di competenza inserita non presente nell'elenco";
	private static final String AVAILABILITY_PERIOD_ADD_REDUNDANCY_ERROR = "Periodo di disponibilità già presente";
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
	
	public void addSkillArea (SkillArea sa) throws IllegalArgumentException
	{
		if (skAreas.contains(sa))
		{
			throw new IllegalArgumentException("Area di competenza già inserita");
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
			throw new IllegalArgumentException("Area di competenza non inserita");
		}
		else
		{
			skAreas.remove(sa);
		}
	}
	
	public void addVisit (Visit v) throws IllegalArgumentException
	{
		if (visits.contains(v))
		{
			throw new IllegalArgumentException("Visita già inserita");
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
			throw new IllegalArgumentException("Visita non inserita");
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
			throw new IllegalArgumentException("Dipendente già inserito");
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
			throw new IllegalArgumentException("Dipendente non inserito");
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
			throw new IllegalArgumentException("Paziente già inserito");
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
			throw new IllegalArgumentException("Paziente non inserito");
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
			throw new IllegalArgumentException("Periodo di disponibilità già inserito");
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
			throw new IllegalArgumentException("Periodo di disponibilità non inserito");
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
			// E' per forza già corretta
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
				if (p.getEndDay().compareTo(onlyDate)>=0)
				{
					if (p.getEndTime().compareTo(onlyTime)>=0)
					{
						return true;
					}
				}
			}
			
			return false;
			
		} catch (ParseException e) {
			// E' già corretta per forza
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
		Date next = d;
		boolean ok = false;
		
		do 
		{
			next = Utilities.getNextDate30Min(next);
			List<Doctor> dLst = getAvailableDoctor(next);
			if (dLst.size() != 0)
				ok = true;
			
			if (!areThereSubsequentDates(next))
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
		
		MyMenu vMenu = new MyMenu(VISIT_MENU, "Aggiungi visita generica", "Aggiungi visita specialistica", "Modifica visita", "Rimuovi visita", "Stampa visita");
		
		int scelta;
		
		while ( (scelta=vMenu.getChoice()) != MyMenu.EXIT_VALUE )
		{
			switch (scelta)
			{
				case ADD_GENERAL_VOICE:
					
					boolean ok = false;
					Patient p = null;
					do
					{
						try
						{
							IOLib.printLine("Seleziona il paziente per la visita: ");
							p = getPatient();
							ok = true;
						}
						catch (IllegalArgumentException e)
						{
							IOLib.printLine(e.getMessage());
						}
					}while (!ok);
					
					boolean dateOk = false;
					
					List <Doctor> dList = null;
					Date date = null;
					
					while (!dateOk)
					{
						IOLib.printLine("Inserisci la data e l'ora desiderata: [gg/MM/aaaa oo:mm]");
						date = IOLib.readDateTime();
						
						dList = getAvailableDoctor(date);
						
						if (dList.size() == 0)
						{
							IOLib.printLine("Impossibile all'orario specificato");
							
							try
							{
								Date d = suggestNextDate(date);
								IOLib.printLine(String.format("Prossima data disponibile: %s", Utilities.dateTimeToString(d)));
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
					
					Doctor doc = IOLib.getCollectionElement(dList);
					
//					IOLib.printLine("Seleziona il dottore per la visita:");
//					Doctor d = getDoctor();
					
					String motivation = IOLib.readLine("Inserisci la motivazione della visita: ");
					
//					boolean dateOk = false;
//
//					
//					while (!dateOk)
//					{
//						IOLib.printLine("Inserisci la data e l'ora desiderata: [gg/MM/aaaa oo:mm:ss]");
//						date = IOLib.readDateTime();
//						
//						try {
//							Date onlyTime = Utilities.stringToTimeInDate(Utilities.timeInDateToString(date));
//							Date onlyDate = Utilities.stringToDate(Utilities.dateToString(date));
//							
//							List<AvailabilityPeriod> periods = searchPeriod(d);
//							
//							int i;
//							 //Se arriva alla fine della List è perche non ne ha trovata una compatibile
//							//Nessun periodo di disponibilità del dottore contiene la data
//							for (i = 0; i < periods.size() && !periods.get(i).compatibleWith(onlyDate, onlyTime); i++);
//							
//							if (i != periods.size())
//							{
//								//Controllo che l'ora richiesta permetta lo svolgimento dell'intera durata di una visita prima della chiusura della clinica
//								//(controllo sull'orario di apertura implicito nel controllo di compatibilità con le disponibilità)
//								if ( Math.abs(onlyTime.getTime() - Utilities.stringToTimeInDate(CLOSE_TIME).getTime()) >= Visit.DURATION_MINUTES )
//								{
//									List<Visit> visitsDoctor = searchVisit(d);
//									boolean stop = false;
//									
//									//Se arriva alla fine della List è perchè nessuna visita in programma per il dottore va in conflitto con la data richiesta
//									for (i = 0; i < visitsDoctor.size() && !stop; i++)
//									{
//										if (visitsDoctor.get(i).getDate().compareTo(date) != 0)
//										{
//											stop = true;
//										}
//										else if ( Math.abs(visitsDoctor.get(i).getDate().getTime() - date.getTime())/(Utilities.MILLISECONDS_TO_SECONDS*Utilities.SECOND_TO_MINUTE) < Visit.DURATION_MINUTES )
//										{
//											//Math.abs(visitsDoctor.get(i).getDate().getTime() - date.getTime())/(Utilities.MILLISECONDS_TO_SECONDS*Utilities.SECOND_TO_MINUTE)
//											//Distanza in minuti tra una data e l'altra
//											// < Visit.DURATION_MINUTES
//											//Se la distanza è minore della durata della visita si sovrappongono
//											stop = true;
//										}
//									}
//									
//									if (i == visitsDoctor.size())
//									{
//										//CERCA DATA DISPONIBILE
//										/**
//										 * dateOk = IOLib.twoWayQuestion("La data e l'ora inseriti non sono disponibili, la disponibilità più vicina è "+Utilities.timeInDateToString(date)+". La si vuole confermare?");
//										 */
//									}
//									else
//									{
//										dateOk = true;
//									}
//								}
//								else
//								{
//									//ORA NON COMPATIBILE --> CERCA DATA DISPONIBILE
//								}
//							}
//							else
//							{
//								//CERCA DATA DISPONIBILE
//							}
//						} catch (ParseException e) {
//							e.printStackTrace();
//						}
//					}
					
					visits.add(new Visit(p, motivation, date, doc));

					break;
					
				case ADD_SPECIALISTIC_VOICE:
					
					
					
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
						
						boolean sure = IOLib.twoWayQuestion("Sicuro di voler rimuovere? ");
						
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
		
		MyMenu vMenu = new MyMenu("Ricerca visite", false, "Cerca per dottore", "Cerca per paziente", "Cerca per data", "Scegli tra tutte");
		
		Visit ris = null;
		
		int scelta;
		List<Visit> vList;

		scelta = vMenu.getChoice();

		switch (scelta)
		{
			case SEARCH_DOCTOR_VOICE:
				
				Doctor d = getDoctor();
				
				vList = searchVisit(d);
				
				ris = IOLib.getCollectionElement(vList);
					
				break;
				
			case SEARCH_PATIENT_VOICE:
				
				Patient p = getPatient();
				
				vList = searchVisit(p);
				
				ris = IOLib.getCollectionElement(vList);
				
				break;
				
			case SEARCH_DATE_VOICE:
				
				Date dt = IOLib.readDateTime();
				
				vList = searchVisit(dt);
				
				ris = IOLib.getCollectionElement(vList);
				
				break;	
				
			case SEARCH_ALL_VOICE:
				
				ris = IOLib.getCollectionElement(visits);
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
	 * Ritorna un periodo di disponibilità leggendo la data e l'ora
	 * @return periodo di disponibilità
	 */
	public AvailabilityPeriod getPeriodFromDate () throws IllegalArgumentException
	{
		IOLib.printLine("Inserisci la data [dd/MM/aaaa]");
		Date d = IOLib.readDate();
		IOLib.printLine("Inserisci l'ora [hh:mm:ss]");
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
	public AvailabilityPeriod getPeriodFromStaffMember () throws IllegalArgumentException
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
	 * Ritorna un periodo cercandolo
	 * @return Il periodo richiesto
	 */
	public AvailabilityPeriod getPeriod () 
	{
		final int SEARCH_STAFF_VOICE = 1;
		final int SEARCH_DATE_VOICE = 2;
		final int SEARCH_ALL_VOICE = 3;
		
		MyMenu vMenu = new MyMenu("Ricerca periodi", false, "Cerca per membro", "Cerca per data", "Cerca tra tutte");
		
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
				
				ris = IOLib.getCollectionElement(availability);
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
		
		MyMenu vMenu = new MyMenu("Ricerca staff", false, "Cerca per nome e cognome", "Cerca tra tutti");
		
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
			
			ris = IOLib.getCollectionElement(l);
			
			break;
			
		case SEARCH_ALL_VOICE:
			
			ris = IOLib.getCollectionElement(staff);
			
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
		
		MyMenu vMenu = new MyMenu("Ricerca dottori", false, "Cerca per nome e cognome", "Cerca tra tutti");
		
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
			
			ris = IOLib.getCollectionElement(l);
			
			break;
			
		case SEARCH_ALL_VOICE:
			
			ris = IOLib.getCollectionElement(getDoctorsFromStaff());
			
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
		
		MyMenu vMenu = new MyMenu("Ricerca dottori specialistici", false, "Cerca per nome e cognome", "Cerca per area di competenza", "Cerca tra tutti");
		
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
			
			ris = IOLib.getCollectionElement(l);
			
			break;
		case SEARCH_SKILL_AREA_VOICE:
			
			SkillArea sa = SkillArea.readFromConsole();
			
			if (!skAreas.contains(sa))
				throw new IllegalArgumentException(READ_SKILL_AREA_NOT_FOUND_ERROR);
			
			break;
		case SEARCH_ALL_VOICE:
			
			ris = IOLib.getCollectionElement(getSpecialistDoctorsFromStaff());
			
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
		
		MyMenu vMenu = new MyMenu("Ricerca pazienti", false, "Cerca per nome e cognome", "Cerca tra tutti");
		
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
			
			ris = IOLib.getCollectionElement(l);
			
			break;
			
		case SEARCH_ALL_VOICE:
			
			ris = IOLib.getCollectionElement(patients);
			
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
					
					IOLib.printLine("Inserisci data inizio:[gg/mm/aaaa] ");
					Date startDay = IOLib.readDate();
					
					IOLib.printLine("Inserisci data fine:[gg/mm/aaaa] ");
					Date endDay = IOLib.readDate();
					
					Date startTime;
					Date endTime;
					do
					{
						IOLib.printLine("Inserisci orario inizio:[hh:mm:ss] ");
						startTime = IOLib.readTimeInDate();
						
						if (startTime.before(Utilities.stringToTimeInDateNoException(OPEN_TIME)) && startTime.after(Utilities.stringToTimeInDateNoException(CLOSE_TIME)))
							IOLib.printLine(TIME_INCOMPATIBLE_WITH_CLINIC_TIME);
					}while (startTime.before(Utilities.stringToTimeInDateNoException(OPEN_TIME)) && startTime.after(Utilities.stringToTimeInDateNoException(CLOSE_TIME)));
						
					do
					{
						IOLib.printLine("Inserisci orario fine:[hh:mm:ss] ");
						endTime = IOLib.readTimeInDate();
						
						if (endTime.before(Utilities.stringToTimeInDateNoException(OPEN_TIME)) && endTime.after(Utilities.stringToTimeInDateNoException(CLOSE_TIME)))
							IOLib.printLine(TIME_INCOMPATIBLE_WITH_CLINIC_TIME);
					}while (endTime.before(Utilities.stringToTimeInDateNoException(OPEN_TIME)) && endTime.after(Utilities.stringToTimeInDateNoException(CLOSE_TIME)));
					
					weekday = IOLib.twoWayQuestion("Giorni della settimana specifici?");
					
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
					
//					final int VIA_PERIOD = 1;
//					final int VIA_STAFF_MEMBER = 2;
//					
//					MyMenu rMenu = new MyMenu("Come cercare il periodo di disponibilità:", false, "Inserisci periodo", "Inserisci dipendente coinvolto");
//					
//					s = rMenu.getChoice();
//					
//					switch (s)
//					{
//						case VIA_PERIOD:
//							
//							
//							try
//							{
//								availability.remove(getPeriodFromDate());
//							}
//							catch (IllegalArgumentException e)
//							{
//								IOLib.printLine(e.getMessage());
//							}
//							
//							break;
//							
//						case VIA_STAFF_MEMBER:
//							
//							
//							try
//							{
//								availability.remove(getPeriodFromStaffMember());
//							}
//							catch (IllegalArgumentException e)
//							{
//								IOLib.printLine(e.getMessage());
//							}
//							
//							break;
//					}
					
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
