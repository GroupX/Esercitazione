package it.unibs.ing.fp.groupX.medicalclinic;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import it.unibs.ing.fp.groupX.medicalclinic.aviability.AvailabilityPeriod;
import it.unibs.ing.fp.groupX.medicalclinic.pathologies.*;
import it.unibs.ing.fp.groupX.medicalclinic.people.ClinicFolder;
import it.unibs.ing.fp.groupX.medicalclinic.people.Doctor;
import it.unibs.ing.fp.groupX.medicalclinic.people.Patient;
import it.unibs.ing.fp.groupX.medicalclinic.people.Person;
import it.unibs.ing.fp.groupX.medicalclinic.people.SpecialistDoctor;
import it.unibs.ing.fp.groupX.medicalclinic.people.StaffMember;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillArea;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Diagnosis;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Prescription;
import it.unibs.ing.fp.groupX.medicalclinic.visit.PrescriptionEntry;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Report;
import it.unibs.ing.fp.groupX.medicalclinic.visit.SpecialisticVisit;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Visit;
import it.unibs.ing.fp.groupX.myutil.CodiceFiscale;
import it.unibs.ing.fp.groupX.myutil.Gender;
import it.unibs.ing.fp.groupX.myutil.NumeroTelefonico;
import it.unibs.ing.fp.groupX.myutil.Utilities;

public class PreloadMain {
	public static final int PATHOLOGIES_NUMBER = 3;
	public static final String[] DEFAULT_PATHOLOGIES = {"Tonsillite", "Tumore al cervello", "Lesione al ginocchio"};
	
	public static final int SKILL_AREAS_NUMBER = 3;
	public static final String[] DEFAULT_SKILL_AREAS = {"Neurochirurgia", "Dermatologia", "Allergologia"};
	
	public static final int REPORT_NUMBER = 5;
	public static final Report[] DEFAULT_REPORT = {
				new Report(new Diagnosis(new Pathology("Tonsillite")), new Prescription(new PrescriptionEntry("Antinfiammatorio")), new Date()),
				new Report(new Diagnosis(new Pathology("Tumore al cervello")), new Prescription(new PrescriptionEntry("Condolianze")), new Date()),
				new Report(new Diagnosis(new Pathology("Lesione al ginocchio")), new Prescription(new PrescriptionEntry("Gesso")), new Date()),
				new Report(new Diagnosis(new Pathology("Tumore al cervello"),new Pathology("Lesione al ginocchio")), new Prescription(new PrescriptionEntry("Condolianze")), new Date()),
				new Report(new Diagnosis((new Pathology("Tonsillite")),new Pathology("Lesione al ginocchio")), new Prescription(new PrescriptionEntry("Riposo")), new Date()),
				};
	
	public static final int STAFF_NUMBER = 4;
	public static final int PATIENT_NUMBER = 4;
	public static final int PERSON_NUMBER = STAFF_NUMBER + PATIENT_NUMBER;
	
	public static final Person[] DEFAULT_PEOPLE = {
				new Person("Mario", "Rossi", Utilities.stringToDateNoException("01/01/1980"), "Roma", Gender.MALE, new NumeroTelefonico("+39 333 3333333"), new CodiceFiscale("RSSMRA80A01H501U")),
				new Person("Giulia", "Bianchi", Utilities.stringToDateNoException("01/02/1985"), "Firenze", Gender.FEMALE, new NumeroTelefonico("+39 333 3333334"), new CodiceFiscale("BNCGLI85B41D612K")),
				new Person("Luca", "Neri", Utilities.stringToDateNoException("01/03/1975"), "Milano", Gender.MALE, new NumeroTelefonico("+39 333 3333335"), new CodiceFiscale("NRELCU75C01F205C")),
				new Person("Sara", "Gialli", Utilities.stringToDateNoException("01/04/1990"), "Torino", Gender.FEMALE, new NumeroTelefonico("+39 333 3333336"), new CodiceFiscale("GLLSRA90D41L219W")),
				new Person("Matteo", "Verdi", Utilities.stringToDateNoException("01/05/1999"), "Desenzano", Gender.MALE, new NumeroTelefonico("+39 333 3333337"), new CodiceFiscale("VRDMTT99E01D284N")),
				new Person("Martina", "Grigi", Utilities.stringToDateNoException("01/07/1992"), "Lecco", Gender.FEMALE, new NumeroTelefonico("+39 333 3333338"), new CodiceFiscale("GRGMTN92L41E507V")),
				new Person("Davide", "Tosatto", Utilities.stringToDateNoException("30/10/1995"), "Milano", Gender.MALE, new NumeroTelefonico("+39 3347048054"), new CodiceFiscale("TSTDVD95R30F205T")),
				new Person("Paolo", "Pasquali", Utilities.stringToDateNoException("01/06/1995"), "Mantova", Gender.MALE, new NumeroTelefonico("+39 3480485331"), new CodiceFiscale("PSQPLA95H01E897I")),
				};
	
	public static final StaffMember[] DEFAULT_STAFF = {
				new Doctor(DEFAULT_PEOPLE[0]),
				new Doctor(DEFAULT_PEOPLE[1]),
				new SpecialistDoctor(DEFAULT_PEOPLE[2], new SkillArea(DEFAULT_SKILL_AREAS[0])),
				new SpecialistDoctor(DEFAULT_PEOPLE[3], new SkillArea(DEFAULT_SKILL_AREAS[1]), new SkillArea(DEFAULT_SKILL_AREAS[2]))
				};
	
	public static final Patient[] DEFAULT_PATIENTS = {
				new Patient(DEFAULT_PEOPLE[4], new ClinicFolder(DEFAULT_REPORT[4])),
				new Patient(DEFAULT_PEOPLE[5], new ClinicFolder(DEFAULT_REPORT[0], DEFAULT_REPORT[2])),
				new Patient(DEFAULT_PEOPLE[6], new ClinicFolder()),
				new Patient(DEFAULT_PEOPLE[7], new ClinicFolder())
				};
	
	public static final int AVAILABILITY_PERIOD_NUMBER = STAFF_NUMBER;
	public static final AvailabilityPeriod[] DEFAULT_AVAILABILITY_PERIODS = {
				new AvailabilityPeriod(Utilities.stringToDateNoException("01/06/2015"), Utilities.stringToDateNoException("31/08/2015"), Utilities.stringToTimeInDateNoException("08:00"), Utilities.stringToTimeInDateNoException("18:00"), DEFAULT_STAFF[0]),
				new AvailabilityPeriod(Utilities.stringToDateNoException("01/09/2015"), Utilities.stringToDateNoException("31/05/2016"), Utilities.stringToTimeInDateNoException("08:00"), Utilities.stringToTimeInDateNoException("18:00"), DEFAULT_STAFF[1]),
				new AvailabilityPeriod(Utilities.stringToDateNoException("01/06/2015"), Utilities.stringToDateNoException("30/06/2015"), Utilities.stringToTimeInDateNoException("08:00"), Utilities.stringToTimeInDateNoException("12:00"), DEFAULT_STAFF[2]),
				new AvailabilityPeriod(Utilities.stringToDateNoException("01/08/2015"), Utilities.stringToDateNoException("31/08/2015"), Utilities.stringToTimeInDateNoException("14:00"), Utilities.stringToTimeInDateNoException("18:00"), DEFAULT_STAFF[3]),
				};
	
	public static final int VISIT_NUMBER = 6;
	public static final Visit[] DEFAULT_VISIT = {
				new Visit(DEFAULT_PATIENTS[0], "Controllo generico", new Date(), (Doctor)DEFAULT_STAFF[0]),
				new Visit(DEFAULT_PATIENTS[3], "Mal di gola", new Date(), (Doctor)DEFAULT_STAFF[1]),
				new Visit(DEFAULT_PATIENTS[2], "Mal di testa", new Date(), (Doctor)DEFAULT_STAFF[0]),
				new SpecialisticVisit(new Visit(DEFAULT_PATIENTS[0], "Sospetto tumore", new Date(), (SpecialistDoctor)DEFAULT_STAFF[2]), new SkillArea(DEFAULT_SKILL_AREAS[0]), new Visit(DEFAULT_PATIENTS[0], "Controllo generico", new Date(), (Doctor)DEFAULT_STAFF[0])),
				new SpecialisticVisit(DEFAULT_PATIENTS[1], "Irritazione pelle", new Date(), (SpecialistDoctor)DEFAULT_STAFF[3], new SkillArea(DEFAULT_SKILL_AREAS[1])),
				new SpecialisticVisit(DEFAULT_PATIENTS[3], "Allergia", new Date(), (SpecialistDoctor)DEFAULT_STAFF[3], new SkillArea(DEFAULT_SKILL_AREAS[2])),
				};
	
	
	
	public static void main(String[] args)
	{
		resetToDefaultPathologies();
		resetToDefaultClinic();
	}
	
	public static Clinic resetToDefaultClinic ()
	{
		Clinic c = new Clinic();
		
		for (String s : DEFAULT_SKILL_AREAS)
		{
			c.addSkillArea(new SkillArea(s));
		}
		
		for (StaffMember sm : DEFAULT_STAFF)
		{
			c.addStaffMember(sm);
		}
		
		for (Patient p : DEFAULT_PATIENTS)
		{
			c.addPatient(p);
		}
		
		for (AvailabilityPeriod ap : DEFAULT_AVAILABILITY_PERIODS)
		{
			c.addAvailability(ap);
		}
		
		for (Visit v : DEFAULT_VISIT)
		{
			c.addVisit(v);
		}
		
		//Salvo su file
		try {
			DataManager.saveClinic(c);;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
	}
	
	public static void resetToDefaultPathologies ()
	{
		//Elimino tutte le patologie attuali
		for (int i = 0; i < Pathologies.get().size(); i++)
		{
			Pathologies.get().remove(i);
		}
		
		//Imposto quelle di default
		for (int i = 0; i < PATHOLOGIES_NUMBER; i++)
		{
			Pathologies.get().add(new Pathology(DEFAULT_PATHOLOGIES[i]));
		}
		
		//Salvo su file
		try {
			DataManager.savePathologies();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
