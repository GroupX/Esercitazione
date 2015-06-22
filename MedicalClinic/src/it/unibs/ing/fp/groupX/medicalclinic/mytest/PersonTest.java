package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.PreloadMain;
import it.unibs.ing.fp.groupX.medicalclinic.people.Person;
import java.text.ParseException;

import org.junit.Test;

public class PersonTest {
	
	private static final String TO_STRING_RESULT = "Paolo Pasquali\nNato il 01/06/1995 a Mantova\nCodice Fiscale: PSQPLA95H01E897I\nNumero di telefono: +39 3480485331";
	private static final String TO_STRING_SHORT_RESULT = "Paolo  Pasquali  CF: PSQPLA95H01E897I";
	
	public static Person getTestPerson1 () throws IllegalArgumentException, ParseException
	{
		return PreloadMain.DEFAULT_PEOPLE[7];
	}
	
	public static Person getTestPerson2 () throws IllegalArgumentException, ParseException
	{
		return PreloadMain.DEFAULT_PEOPLE[6];
	}
	
	@Test
	public void toStringTest() throws Exception {
		
		Person p = getTestPerson1();
		
		assertEquals (TO_STRING_RESULT,p.toString());
	}
	
	@Test
	public void toStringShortTest() throws Exception {
		Person p = getTestPerson1();
		
		assertEquals (TO_STRING_SHORT_RESULT, p.toStringShort());
	}
	
	@Test
	public void equalsTest() throws Exception {
		Person p1 = getTestPerson1();
		Person p2 = getTestPerson1();
		Person p3 = getTestPerson2();
		
		assertTrue (p1.equals(p2));
		assertFalse (p1.equals(p3));
	}
	
}
