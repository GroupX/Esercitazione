package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import it.unibs.ing.fp.groupX.medicalclinic.PreloadMain;
import it.unibs.ing.fp.groupX.medicalclinic.people.Patient;

import org.junit.Test;

public class PatientTest {
	private static final String TO_STRING_RESULT = "Matteo Verdi\nNato il 01/05/1999 a Desenzano\nCodice Fiscale: VRDMTT99E01D284N\nNumero di telefono: +39 3333333337\nElenco referti:\n"+PreloadMain.DEFAULT_REPORT[4].toString();
	
	@Test
	public void toStringTest() throws Exception {
		
		Patient p = PreloadMain.DEFAULT_PATIENTS[0];
		
		assertEquals (TO_STRING_RESULT,p.toString());
	}
	
	@Test
	public void equalsTest() throws Exception {
		Patient p1 = PreloadMain.DEFAULT_PATIENTS[3];
		Patient p2 = PreloadMain.DEFAULT_PATIENTS[3];
		Patient p3 = PreloadMain.DEFAULT_PATIENTS[2];
		
		assertTrue (p1.equals(p2));
		assertFalse (p1.equals(p3));
	}
	
}
