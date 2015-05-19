package it.unibs.ing.fp.medagliere;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NazioneTest {
	
	@Test
	public void testNazioneMeglioDi() throws Exception {
		final Nazione nazione = new Nazione("Italia");
		final Nazione altraNazione = new Nazione("Spagna");
		nazione.aggiungiMedaglia(0);//ORO
		nazione.aggiungiMedaglia(1);//ARGENTO
		altraNazione.aggiungiMedaglia(0);//ORO
		altraNazione.aggiungiMedaglia(2);//BRONZO
		assertTrue(nazione.meglioDi(altraNazione));
	}
	
}
