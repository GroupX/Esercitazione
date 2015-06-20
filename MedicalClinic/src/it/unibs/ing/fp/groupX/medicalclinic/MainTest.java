package it.unibs.ing.fp.groupX.medicalclinic;

import java.text.ParseException;

import it.unibs.ing.fp.groupX.medicalclinic.mytest.VisitTest;
import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathologies;
import it.unibs.ing.fp.groupX.medicalclinic.people.Person;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillAreas;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Diagnosis;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Prescription;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Report;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Visit;
import it.unibs.ing.fp.groupX.myutil.IOLib;

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
		
		Visit v = VisitTest.getTestVisit();
		
		v.use();
	}

}
