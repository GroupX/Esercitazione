package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.visit.PrescriptionEntry;

import org.junit.Test;

public class PrescriptionEntryTest {
	@Test
	public void creationTest() throws Exception {
		PrescriptionEntry pe = new PrescriptionEntry("Aspirina", "2 compresse al giorno", "2 settimane");
		
		assertEquals("Rimedio: Aspirina\tFrequenza: 2 compresse al giorno\tPeriodo: 2 settimane", pe.toString());
	}
}
