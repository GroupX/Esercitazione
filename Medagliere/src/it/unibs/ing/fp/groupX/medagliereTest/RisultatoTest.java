package it.unibs.ing.fp.groupX.medagliereTest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medagliere.Nazione;
import it.unibs.ing.fp.groupX.medagliere.Risultato;

import org.junit.Test;

public class RisultatoTest
{
	@Test
	public void creationTest() throws Exception
	{
		Risultato ris = new Risultato (new Nazione("Italia"), new Nazione("Vaticano"), new Nazione("San Marino"));
		
		assertEquals ("Italia", ris.getGold().toString());
		assertEquals ("Vaticano", ris.getSilver().toString());
		assertEquals ("San Marino", ris.getBronze().toString());
	}
	
	@Test
	public void toStringTest() throws Exception
	{
		Risultato ris = new Risultato (new Nazione("Italia"), new Nazione("Vaticano"), new Nazione("San Marino"));
		
		assertEquals ("Oro: Italia; Argento: Vaticano; Bronzo: San Marino", ris.toString());
	}
}
