package it.unibs.ing.fp.groupX.medagliereTest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medagliere.Gara;
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
		
		assertEquals ("Italia:  Oro: 2; Argento: 0; Bronzo: 0\n"
				+ "Azz:  Oro: 1; Argento: 0; Bronzo: 0\n"
				+ "Jamaica:  Oro: 0; Argento: 3; Bronzo: 0\n"
				+ "Erebor:  Oro: 0; Argento: 0; Bronzo: 3\n"
				+ "Gondor:  Oro: 0; Argento: 0; Bronzo: 0\n", m.toStringOrdinato());
	}
	
	@Test
	public void getGaraTest() throws Exception
	{
		Medagliere m = new Medagliere();
		
		m.addNazione("Francia");
		m.addNazione("Germania");
		m.addNazione("Porto Rico");
		m.addNazione("Pinco Pallino");
		
		m.addGara("Valanga");
		m.addGara("Sinapsi");
		m.addGara("Sterminio");
		m.addGara("Zombie");
		
		m.addRisultato("Valanga", "Porto Rico", "Francia", "Germania");
		m.addRisultato("Sinapsi", "Germania", "Porto Rico", "Pinco Pallino");
		m.addRisultato("Sterminio", "Pinco Pallino", "Germania", "Francia");
		m.addRisultato("Zombie", "Francia", "Pinco Pallino", "Porto Rico");
		
		assertEquals ("Valanga", m.getGara("Valanga").getNome());
		assertEquals ("Sterminio", m.getGara("Sterminio").getNome());
		assertEquals ("Zombie", m.getGara("Zombie").getNome());
		assertEquals ("Sinapsi", m.getGara("Sinapsi").getNome());
	}
}
