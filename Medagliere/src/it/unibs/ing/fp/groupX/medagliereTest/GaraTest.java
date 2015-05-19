package it.unibs.ing.fp.groupX.medagliereTest;

import static org.junit.Assert.*;

import org.junit.Test;

import it.unibs.ing.fp.medagliere.Gara;
import it.unibs.ing.fp.medagliere.Nazione;
import it.unibs.ing.fp.medagliere.Risultato;

public class GaraTest
{
	private static final String GARA_1_NOME = "Lancio del giavellotto";
	private static final String GARA_2_NOME = "Lancio del peso";
	private static final String NAZIONE_1 = "Italia";
	private static final String NAZIONE_2 = "Francia";
	private static final String NAZIONE_3 = "Germania";
	
	@org.junit.Test
	public void creationTest() throws Exception
	{
		Gara g = new Gara (GARA_1_NOME);
		
		assertEquals(GARA_1_NOME, g.getNome());
	}
	
	@Test
	public void risTest () throws Exception
	{
		Gara g = new Gara (GARA_1_NOME);
		
		g.setRisultato (new Risultato(new Nazione(NAZIONE_1),new Nazione(NAZIONE_3),new Nazione(NAZIONE_2)));
		
		assertEquals(String.format ("Oro: %s; Argento: %s; Bronzo: %s", NAZIONE_1, NAZIONE_3, NAZIONE_2), g.getRis ().toString ());
	}
	
	@Test
	public void equalsTest () throws Exception
	{
		Gara g1 = new Gara (GARA_1_NOME);
		Gara g2 = new Gara (GARA_1_NOME);
		Gara g3 = new Gara (GARA_2_NOME);
		
		assertEquals(true, g1.equals (g2));
		assertEquals(false, g1.equals (g3));
	}
	
	@Test
	public void toStringTest () throws Exception
	{
		Gara g = new Gara (GARA_1_NOME);
		
		g.setRisultato (new Risultato(new Nazione(NAZIONE_1),new Nazione(NAZIONE_3),new Nazione(NAZIONE_2)));
		
		assertEquals (String.format ("%s: Oro: %s; Argento: %s; Bronzo: %s", GARA_1_NOME, NAZIONE_1, NAZIONE_3, NAZIONE_2),g.toString());
	}
}
