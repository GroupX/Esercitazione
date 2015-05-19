package it.unibs.ing.fp.medagliere;

import static org.junit.Assert.*;

import org.junit.Test;

public class GaraTest {
	private static final String NOME = "salto in lungo";
	private static final int NUMMEDAGLIE = 3;
	
	@Test
	public void testGaraNonEseguita() throws Exception {
		final Gara gara = new Gara(NOME);
		assertFalse(gara.giaPremiata());
	}
	
	@Test
	public void testGaraEseguita() throws Exception {
		final Gara gara = new Gara(NOME);
		gara.setEseguita();
		assertTrue(gara.giaPremiata());
	}
	
	@Test
	public void testGaraNazionePremiata() throws Exception {
		final Gara gara = new Gara(NOME);
		final Nazione[] nazioniPremiate = {new Nazione("Italia"),new Nazione("Spagna"),new Nazione("Giappone")};
		gara.setEseguita();
		for(int i=0; i<NUMMEDAGLIE; i++){
			gara.aggiungiPremiata(nazioniPremiate[i], i);
		}
		assertEquals(nazioniPremiate[0],gara.getPremiate()[0]);
	}
	
}
