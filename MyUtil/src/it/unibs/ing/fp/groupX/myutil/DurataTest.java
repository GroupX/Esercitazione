package it.unibs.ing.fp.groupX.myutil;

import static org.junit.Assert.*;

import org.junit.Test;

public class DurataTest
{
	@Test
	public void normalizationTest() throws Exception
	{
		Durata d = new Durata(120);
		
		assertEquals(0, d.getSecondi());
		assertEquals(2, d.getMinuti());
		assertEquals(0, d.getOre());
		
		d = new Durata(1, 120, 150);
		
		assertEquals(30, d.getSecondi());
		assertEquals(2, d.getMinuti());
		assertEquals(3, d.getOre());
	}
	
	@Test
	public void conversionTest() throws Exception
	{
		Durata d = new Durata(1, 2, 3);
		
		assertEquals(3723, d.toSecondi());
		assertEquals(62, d.toMinuti());
		assertEquals(1, d.toOre());
	}
	
	@Test
	public void toStringTest() throws Exception
	{
		Durata d = new Durata(1, 2, 3);
		
		assertEquals ("01_02_03", d.toString("ore_min_sec"));
		assertEquals ("01:02:03", d.toString());
	}
}
