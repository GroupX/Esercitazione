package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;

import java.text.ParseException;

import it.unibs.ing.fp.groupX.medicalclinic.ClinicFolder;
import it.unibs.ing.fp.groupX.medicalclinic.Doctor;
import it.unibs.ing.fp.groupX.medicalclinic.Patient;
import it.unibs.ing.fp.groupX.medicalclinic.Visit;
import it.unibs.ing.fp.groupX.myutil.Utilities;

import org.junit.Test;

public class VisitTest {
	
	private Visit getTestVisit () throws ParseException
	{
		Patient p = new Patient(PersonTest.getTestPerson1(), new ClinicFolder());
		Doctor d = new Doctor(PersonTest.getTestPerson2(), new boolean[1][1]);
		
		return new Visit(p, "Febbre", Utilities.stringToDate("22/07/2015"), d);
	}
	
	@Test
	public void visitCreationTest() throws Exception {
		Visit v = getTestVisit();
		
		assertEquals("Paziente: Paolo  Pasquali  CF: PSQPLA95H01E897I\nMotivo: Febbre\nData: 22/07/2015\nStato: prenotata\nDottore: Davide  Tosatto  CF: TSTDVD95R30F205T", v.toString());
	}
}
