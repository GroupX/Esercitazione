package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;

import java.util.Date;

import it.unibs.ing.fp.groupX.medicalclinic.ClinicFolder;
import it.unibs.ing.fp.groupX.medicalclinic.Patient;
import it.unibs.ing.fp.groupX.medicalclinic.Person;
import it.unibs.ing.fp.groupX.medicalclinic.Visit;
import it.unibs.ing.fp.groupX.myutil.Gender;
import it.unibs.ing.fp.groupX.myutil.Utilities;

import org.junit.Test;

public class VisitTest {
	
	private Visit getTestVisit ()
	{
		Date birth = Utilities.stringToDate("30/10/1995");
		Patient p = new Patient(PersonTest.getTestPerson1(), new ClinicFolder());
	}
	
	@Test
	public void visitCreationTest() throws Exception {
		
	}
}
