package it.unibs.ing.fp.groupX.medicalclinic;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import it.unibs.ing.fp.groupX.medicalclinic.aviability.AvailabilityPeriod;
import it.unibs.ing.fp.groupX.medicalclinic.aviability.WeekDay;
import it.unibs.ing.fp.groupX.medicalclinic.mytest.PersonTest;
import it.unibs.ing.fp.groupX.medicalclinic.mytest.VisitTest;
import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathologies;
import it.unibs.ing.fp.groupX.medicalclinic.people.Patient;
import it.unibs.ing.fp.groupX.medicalclinic.people.Person;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillAreas;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Diagnosis;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Prescription;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Report;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Visit;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.Utilities;

public class MainTest {

	public static void main(String[] args) throws ParseException {
		
		/*Person p = Person.readFromConsole(); 

		System.out.println(p.toString());*/
		
//		Pathologies.get().use();
		
//		SkillAreas sa = new SkillAreas();
//		
//		sa.use();
		
//		Diagnosis d = Diagnosis.readFromConsole();
//		
//		System.out.println(d.toString());
		
//		Prescription p = Prescription.readFromConsole();
//		
//		IOLib.printLine(p.toString());
		
//		Report r = Report.readFromConsole();
//		
//		IOLib.printLine(r.toString());
		
//		Visit v = VisitTest.getTestVisit();
//		
//		v.use();
		
//		ClinicFolder cf = ClinicFolder.readFromConsole();
//		
//		IOLib.printLine(cf.toString());
		
//		Patient p = Patient.readFromConsole();
//		
//		IOLib.printLine(p.toString());
		
//		ArrayList <Person> p = new ArrayList<>();
//		
//		p.add(PersonTest.getTestPerson1());
//		p.add(PersonTest.getTestPerson2());
//		
//		Person pers = IOLib.getCollectionElement(p);
//		
//		IOLib.printLine(pers.toString());
		
//		IOLib.printLine(WeekDay.getWeekDay(new Date()).getName());
		
//		AvailabilityPeriod p = new AvailabilityPeriod(Utilities.stringToDate("22/10/2014"), Utilities.stringToDate("25/10/2014"), Utilities.stringToTime("08:00:00"), Utilities.stringToTime("18:00:00"), null);
//		System.out.println(p.compatibleWith(Utilities.stringToDate("25/10/2014"), Utilities.stringToTime("08:00:00")));
		
		PreloadMain.resetToDefaultPathologies();
		
		Clinic c = PreloadMain.resetToDefaultClinic();
		
		c.use();
		
//		IOLib.readDateTime();
//		IOLib.readTimeInDate();
	}

}
