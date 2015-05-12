package it.unibs.ing.fp.groupX.medagliereTest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medagliere.Medagliere;

import org.junit.Test;

public class MedagliereTest
{
	@Test
	public void testNumMedaglie() throws Exception
	{
		Medagliere m = new Medagliere();
		
		m.addNazione("Italia");
		m.addNazione("Jamaica");
		m.addNazione("Erebor");
		m.addNazione("Azz");
		m.addNazione("Gondor");
		
		m.addGara("Sgnek");
		m.addGara("Vuk");
		m.addGara("Pincostrìca");
		
		m.addRisultato("Sgnek", "Italia", "Jamaica", "Erebor");
		m.addRisultato("Pincostrìca", "Italia", "Jamaica", "Erebor");
		m.addRisultato("Vuk", "Azz", "Jamaica", "Erebor");
		
		assertEquals(2, m.getMedaglieOro("Italia"));
		assertEquals(3, m.getMedaglieArgento("Jamaica"));
		assertEquals(3, m.getMedaglieBronzo("Erebor"));
	}
	
	@Test
	public void testToString() throws Exception
	{
		Medagliere m = new Medagliere();
		
		m.addNazione("Italia");
		m.addNazione("Jamaica");
		m.addNazione("Erebor");
		m.addNazione("Azz");
		m.addNazione("Gondor");
		
		m.addGara("Sgnek");
		m.addGara("Vuk");
		m.addGara("Pincostrìca");
		
		m.addRisultato("Sgnek", "Italia", "Jamaica", "Erebor");
		m.addRisultato("Pincostrìca", "Italia", "Jamaica", "Erebor");
		m.addRisultato("Vuk", "Azz", "Jamaica", "Erebor");
		
		assertEquals ("Italia:  Oro: 2; Argento: 0; Bronzo: 0\n"
					+ "Jamaica:  Oro: 0; Argento: 3; Bronzo: 0\n"
					+ "Erebor:  Oro: 0; Argento: 0; Bronzo: 3\n"
					+ "Azz:  Oro: 1; Argento: 0; Bronzo: 0\n"
					+ "Gondor:  Oro: 0; Argento: 0; Bronzo: 0\n", m.toString());
	}
}
