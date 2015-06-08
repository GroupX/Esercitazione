package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.Person;
import it.unibs.ing.fp.groupX.myutil.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class PersonTest {
	
	private static final String TO_STRING_RESULT = "Paolo Pasquali\nNato il 01/06/1995 a Mantova\nCodice Fiscale: PSQPLA95H01E897I\nNumero di telefono: +39 3480485331";
	
	@Test
	public void toStringTest() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat ("dd/MM/yyyy");
		Person p = new Person("Paolo", "Pasquali", sdf.parse("01/06/1995"), "Mantova", Gender.MALE, new NumeroTelefonico("+39 3480485331"), new CodiceFiscale("PSQPLA95H01E897I"));
		
		assertEquals (TO_STRING_RESULT,p.toString());
	}
	
}
