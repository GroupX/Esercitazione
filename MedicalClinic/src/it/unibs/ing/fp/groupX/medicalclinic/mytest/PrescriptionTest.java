package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Prescription;
import it.unibs.ing.fp.groupX.medicalclinic.visit.PrescriptionEntry;

import org.junit.Test;

public class PrescriptionTest {
	@Test
	public void creationTest() throws Exception {
		Prescription p = new Prescription(new PrescriptionEntry("Trapianto cuore"), new PrescriptionEntry("Cardio Aspirina", "3 volte al giorno", "3 mesi"));
	
		assertEquals("Rimedio: Trapianto cuore\nRimedio: Cardio Aspirina\tFrequenza: 3 volte al giorno\tPeriodo: 3 mesi", p.toString());
	}
}
