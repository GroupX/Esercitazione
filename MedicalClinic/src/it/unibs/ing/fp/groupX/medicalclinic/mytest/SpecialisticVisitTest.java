package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;

import java.util.Date;

import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillArea;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Diagnosis;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Prescription;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Report;
import it.unibs.ing.fp.groupX.medicalclinic.visit.SpecialisticVisit;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Visit;
import it.unibs.ing.fp.groupX.myutil.Utilities;

import org.junit.Test;

public class SpecialisticVisitTest {
	@Test
	public void specialisticVisitTest() throws Exception {
		Visit v = VisitTest.getTestVisit();
		
		SpecialisticVisit sv = new SpecialisticVisit(v, new SkillArea("Cardiologia"), null);
		
		sv.completeVisit();
		
		sv.setReport(new Report(new Diagnosis(), new Prescription(), Utilities.stringToDateTime("23/12/2016 08:00:00")));
		
		try
		{
			sv.setPreviousVisitStatus(true);
			assertEquals (true, false);
		}
		catch (IllegalStateException e)
		{
			
		}
	}
}
