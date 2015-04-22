package it.unibs.ing.fp.groupX.esercitazioni;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test della classe Tamagotchi attraverso lo strumento di test JUnit
 * 
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class TamagotchiTester
{

	/**
	 * Testa la morte del Tamagotchi all'azzeramento del grado di sazietà
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTamagotchiDeathCarezze () throws Exception
	{
		Tamagotchi tama = new Tamagotchi ("Carlo", 1, 1);

		tama.daiCarezza (2);

		assertEquals (Tamagotchi.MORTO, tama.controllaStato ()); // Con 2
																	// carezze
																	// muore
	}

	/**
	 * Testa la morte del Tamagotchi all'azzeramento del grado d'affetto
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTamagotchiDeathBiscotto () throws Exception
	{
		Tamagotchi tama = new Tamagotchi ("Carlo", 1, 1);

		tama.daiBiscotto (2);

		assertEquals (Tamagotchi.INFELICE, tama.controllaStato ()); // Non
																	// bastano
																	// 2
																	// biscotti
																	// per
																	// renderlo
																	// morto

		tama.daiBiscotto (8);

		assertEquals (Tamagotchi.MORTO, tama.controllaStato ()); // Con 10
																	// biscotti
																	// totale
																	// muore
																	// (da una
																	// sazietà
																	// di 1)
	}

	/**
	 * Testa la morte del Tamagotchi al raggiungimento del grado massimo della sazietà
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTamagotchiDeathMaxSazieta () throws Exception
	{
		Tamagotchi tama = new Tamagotchi ("Carlo", 99, 100);

		tama.daiBiscotto (10);

		assertEquals (Tamagotchi.MORTO, tama.controllaStato ());
	}

	/**
	 * Testa che il Tamagotchi una volta morto non risorga (se non ha il nome de IL_REDENTORE)
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTamagotchiNoRessurrection () throws Exception
	{
		Tamagotchi tama = new Tamagotchi ("Carlo", 0, 0);

		tama.daiBiscotto (10);

		assertEquals (Tamagotchi.MORTO, tama.controllaStato ());

		tama.daiCarezza (1);

		assertEquals (Tamagotchi.MORTO, tama.controllaStato ());
	}

	/**
	 * Testa che il Tamagotchi-Redentore da morto possa risorgere ed essere felice nuovamente
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTamagotchiRedentoreRessurrection () throws Exception
	{
		Tamagotchi tama = new Tamagotchi (Tamagotchi.IL_REDENTORE, 10, 10);

		tama.daiBiscotto (100);

		assertEquals (Tamagotchi.MORTO_E_RISORTO, tama.controllaStato ());

		tama.daiCarezza (100);
		tama.daiBiscotto (105);
		// IOLib.printLine(tama.getAffetto () + "   " + tama.getSazieta ());

		assertEquals (Tamagotchi.FELICE, tama.controllaStato ());
	}

	/**
	 * Testa che il Tamagotchi da INFELICE diventi FELICE
	 * 
	 * @throws Exception
	 */
	@Test
	public void testTamagotchiFelicità () throws Exception
	{
		Tamagotchi tama = new Tamagotchi ("Carlo", 35, 29);

		assertEquals (Tamagotchi.INFELICE, tama.controllaStato ());

		tama.daiCarezza (10);

		assertEquals (Tamagotchi.FELICE, tama.controllaStato ());
	}
}
