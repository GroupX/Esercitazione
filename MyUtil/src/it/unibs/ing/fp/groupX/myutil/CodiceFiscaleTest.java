package it.unibs.ing.fp.groupX.myutil;

import static org.junit.Assert.*;

import org.junit.Test;

public class CodiceFiscaleTest {
	
	private static final String CODICE_TEST = "PSQPLA95H01E897I";
	private static final String WRONG_REGEX_COD = "PS7P2A9A5Q1E8G7F";
	
	@Test
	public void creation() throws Exception {
		CodiceFiscale c = new CodiceFiscale(CODICE_TEST);
		CodiceFiscale c2 = new CodiceFiscale(c);
		
		assertEquals(CODICE_TEST, c.toString());
		assertEquals(CODICE_TEST, c2.toString());
	}
	
	@Test
	public void correctValidation() throws Exception {
		assertTrue (CodiceFiscale.isValid(CODICE_TEST));
		assertFalse (CodiceFiscale.isValid(WRONG_REGEX_COD));
	}
	
}
