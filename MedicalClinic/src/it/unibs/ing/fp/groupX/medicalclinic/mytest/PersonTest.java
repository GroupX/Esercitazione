package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.people.Person;
import it.unibs.ing.fp.groupX.myutil.*;

import java.text.ParseException;

import org.junit.Test;

public class PersonTest {
	
	private static final String TO_STRING_RESULT = "Paolo Pasquali\nNato il 01/06/1995 a Mantova\nCodice Fiscale: PSQPLA95H01E897I\nNumero di telefono: +39 3480485331";
	
	public static Person getTestPerson1 () throws IllegalArgumentException, ParseException
	{
		return new Person("Paolo", "Pasquali", Utilities.stringToDate("01/06/1995"), "Mantova", Gender.MALE, new NumeroTelefonico("+39 3480485331"), new CodiceFiscale("PSQPLA95H01E897I"));
	}
	
	public static Person getTestPerson2 () throws IllegalArgumentException, ParseException
	{
		return new Person("Davide", "Tosatto", Utilities.stringToDate("30/10/1995"), "Milano", Gender.MALE, new NumeroTelefonico("+39 3347048054"), new CodiceFiscale("TSTDVD95R30F205T"));
	}
	
	@Test
	public void toStringTest() throws Exception {
		
		Person p = getTestPerson1();
		
		assertEquals (TO_STRING_RESULT,p.toString());
	}
	
}
