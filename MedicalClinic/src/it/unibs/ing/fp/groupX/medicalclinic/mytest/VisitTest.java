package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;

import it.unibs.ing.fp.groupX.medicalclinic.ClinicFolder;
import it.unibs.ing.fp.groupX.medicalclinic.people.Doctor;
import it.unibs.ing.fp.groupX.medicalclinic.people.Patient;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Diagnosis;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Prescription;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Report;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Visit;
import it.unibs.ing.fp.groupX.medicalclinic.visit.VisitState;
import it.unibs.ing.fp.groupX.myutil.Utilities;

import org.junit.Test;

public class VisitTest {
	
	public static Visit getTestVisit () throws ParseException
	{
		Patient p = new Patient(PersonTest.getTestPerson1(), new ClinicFolder());
		Doctor d = new Doctor(PersonTest.getTestPerson2());
		
		return new Visit(p, "Febbre", Utilities.stringToDate("22/07/2015"), d);
	}
	
	public static Visit getUnprenotableTestVisit () throws IllegalArgumentException, ParseException
	{
		Patient p = new Patient(PersonTest.getTestPerson1(), new ClinicFolder());
		Doctor d = new Doctor(PersonTest.getTestPerson2());
		
		return new Visit(p, "Febbre", Utilities.stringToDate("22/07/2015"), VisitState.NON_PRENOTABILE, d);
	}
	
	@Test
	public void visitCreationTest() throws Exception {
		Visit v = getTestVisit();
		
		assertEquals("Paziente: Paolo  Pasquali  CF: PSQPLA95H01E897I\nMotivo: Febbre\nData: 22/07/2015\nStato: prenotata\nDottore: Davide  Tosatto  CF: TSTDVD95R30F205T\nReferto:\nNon ancora impostato", v.toString());
	}
	
	@Test
	public void visitStatesTest() throws Exception {
		Visit v = getTestVisit();
		
		assertEquals(v.getState(), VisitState.PRENOTATA);
		
		try
		{
			v.setReport(new Report(new Diagnosis(), new Prescription(), new Date()));
			assertEquals (true, false);
		}
		catch (IllegalStateException e)
		{
			
		}
		
		v.completeVisit();
		
		assertEquals(v.getState(), VisitState.CONCLUSA);
		
		v.setReport(new Report(new Diagnosis(), new Prescription(), new Date()));
		
		assertEquals(v.getState(), VisitState.REFERTATA);
		
		try
		{
			v.completeVisit();
			assertEquals (true, false);
		}
		catch (IllegalStateException e)
		{
			
		}
		
		v = getUnprenotableTestVisit();
		
		try
		{
			v.completeVisit();
			assertEquals (true, false);
		}
		catch (IllegalStateException e)
		{
			
		}
	}
}
