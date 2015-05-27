package it.unibs.ing.fp.groupX.myutil;

import static org.junit.Assert.*;

import org.junit.Test;

public class NumeroTelefonicoTest
{
	@Test
	public void testCostruttori() throws Exception
	{
		NumeroTelefonico t = new NumeroTelefonico("+39 0377 82 34 567");
		
		assertEquals("+39 03778234567", t.toString());
	}
}
