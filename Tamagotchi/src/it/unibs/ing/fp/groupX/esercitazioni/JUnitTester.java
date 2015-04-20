package it.unibs.ing.fp.groupX.esercitazioni;

import static org.junit.Assert.*;

import org.junit.Test;

public class JUnitTester
{
	@Test
	public void testTamagotchiDeathCarezze() throws Exception
	{
		Tamagotchi tama = new Tamagotchi("Carlo", 1, 1);

		tama.daiCarezza(2);

		assertEquals(Tamagotchi.MORTO, tama.controllaStato()); // Con 2 carezze
																// muore
	}

	@Test
	public void testTamagotchiDeathBiscotto() throws Exception
	{
		Tamagotchi tama = new Tamagotchi("Carlo", 1, 1);

		tama.daiBiscotto(2);

		assertEquals(Tamagotchi.INFELICE, tama.controllaStato()); // Non bastano
																	// 2
																	// biscotti
																	// per
																	// renderlo
																	// morto

		tama.daiBiscotto(8);

		assertEquals(Tamagotchi.MORTO, tama.controllaStato()); // Con 10
																// biscotti
																// totale muore
																// (da una
																// sazietà di 1)

		tama.daiCarezza(2);

		assertEquals(Tamagotchi.MORTO, tama.controllaStato()); // Non resuscita
																// con le
																// carezze
	}

	@Test
	public void testTamagotchiFelicità() throws Exception
	{
		Tamagotchi tama = new Tamagotchi("Carlo", 35, 29);

		assertEquals(Tamagotchi.INFELICE, tama.controllaStato());

		tama.daiCarezza(10);

		assertEquals(Tamagotchi.FELICE, tama.controllaStato());
	}
}
