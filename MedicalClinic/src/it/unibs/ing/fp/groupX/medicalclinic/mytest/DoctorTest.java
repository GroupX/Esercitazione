package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.PreloadMain;
import it.unibs.ing.fp.groupX.medicalclinic.people.Doctor;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Visit;

import org.junit.Test;

public class DoctorTest {
	
	private static final String TO_STRING_RESULT = "Mario Rossi\nNato il 01/01/1980 a Roma\nCodice Fiscale: RSSMRA80A01H501U\nNumero di telefono: +39 3333333333\nNumero Albo: %s";
	private static final String TO_STRING_SHORT_RESULT = "Dr. Mario Rossi  N°Albo: %s";
	

	@Test
	public void toStringTest() throws Exception {
		
		Doctor d = (Doctor)PreloadMain.DEFAULT_STAFF[0];
		
		assertEquals (String.format(TO_STRING_RESULT,d.getAlbo()),d.toString());
	}
	
	@Test
	public void toStringShortTest() throws Exception {
		
		Doctor d = (Doctor)PreloadMain.DEFAULT_STAFF[0];
		
		assertEquals (String.format(TO_STRING_SHORT_RESULT,d.getAlbo()), d.toStringShort());
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		Doctor d1 = (Doctor)PreloadMain.DEFAULT_STAFF[0];
		Doctor d2 = (Doctor)PreloadMain.DEFAULT_STAFF[0];
		Doctor d3 = (Doctor)PreloadMain.DEFAULT_STAFF[1];
		
		assertTrue (d1.equals(d2));
		assertFalse (d1.equals(d3));
	}
	
	@Test
	public void canDoTest() throws Exception {
		
		Doctor d = (Doctor)PreloadMain.DEFAULT_STAFF[0];
		Visit v1 = PreloadMain.DEFAULT_VISIT[0];
		Visit v2 = PreloadMain.DEFAULT_VISIT[3];
		
		assertTrue (d.canDo(v1));
		assertFalse (d.canDo(v2));
		
	}
	
}
