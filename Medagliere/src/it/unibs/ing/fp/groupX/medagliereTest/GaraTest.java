package it.unibs.ing.fp.groupX.medagliereTest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medagliere.Gara;

public class GaraTest
{
	private static final String GARA_1_NOME = "Lancio del giavellotto";
	
	@org.junit.Test
	public void creationTest() throws Exception
	{
		Gara g = new Gara (GARA_1_NOME);
		
		assertEquals(GARA_1_NOME, g.getNome());
	}
	
}
