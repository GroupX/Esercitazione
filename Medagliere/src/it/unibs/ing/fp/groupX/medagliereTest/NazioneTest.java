package it.unibs.ing.fp.groupX.medagliereTest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.medagliere.Nazione;

public class NazioneTest
{
	private final static String NATION_1_NAME = "San Marino";
	private final static String NATION_2_NAME = "Italia";
	private final static String NATION_1_WRONG_NAME = "san marino";
	
	@org.junit.Test
	public void	creationTest () throws Exception
	{
		Nazione n = new Nazione (NATION_1_WRONG_NAME);
		
		assertEquals(NATION_1_NAME, n.getNome ());
	}
	
	@org.junit.Test
	public void equalsTest () throws Exception
	{
		Nazione n1 = new Nazione(NATION_1_NAME);
		Nazione n2 = new Nazione(NATION_1_NAME);
		Nazione n3 = new Nazione(NATION_2_NAME);
		
		assertEquals(true, n1.equals (n2));
		assertEquals(false, n1.equals (n3));
	}
	
	@org.junit.Test
	public void toStringTest () throws Exception
	{
		Nazione n = new Nazione (NATION_1_NAME);
		
		assertEquals(NATION_1_NAME, n.toString ());
	}
}
