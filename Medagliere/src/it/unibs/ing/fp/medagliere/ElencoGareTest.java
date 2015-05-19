package it.unibs.ing.fp.medagliere;

import static org.junit.Assert.*;

import org.junit.Test;

public class ElencoGareTest {
	@Test
	public void testAggiuntaGara() throws Exception {
		final ElencoGare gare = new ElencoGare();
		gare.aggiungiGara(new Gara("Lancio del peso"));
		gare.aggiungiGara(new Gara("100MT piani"));
		assertEquals(2, gare.getNumeroGare());
	}
	
	@Test
	public void testRicercaGaraPresente() throws Exception {
		final ElencoGare gare = new ElencoGare();
		gare.aggiungiGara(new Gara("Lancio del peso"));
		gare.aggiungiGara(new Gara("100MT piani"));
		assertTrue(gare.presente("Lancio del peso"));
	}
	
	@Test
	public void testRicercaGaraNonPresente() throws Exception {
		final ElencoGare gare = new ElencoGare();
		gare.aggiungiGara(new Gara("Lancio del peso"));
		gare.aggiungiGara(new Gara("100MT piani"));
		assertFalse(gare.presente("Lancio del martello"));
	}
}
