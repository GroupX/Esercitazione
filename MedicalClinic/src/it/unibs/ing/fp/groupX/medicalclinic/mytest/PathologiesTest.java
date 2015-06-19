package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathologies;
import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathology;

import org.junit.Test;

public class PathologiesTest {
	
	@Test
	public void pathologiesTest() throws Exception {
		Pathologies pts = Pathologies.get();
		
		pts.add(new Pathology("Ulcera"));
		try
		{
			pts.add(new Pathology("ulcera"));
			assertEquals (true, false); //Errore se l'aggiunta ha successo
		}
		catch (IllegalArgumentException e)
		{
			//OK!
		}
		pts.add(new Pathology("Tumore"));
		pts.add(new Pathology("Dissenteria"));
		
		assertEquals ("Elenco patologie:\nUlcera\nTumore\nDissenteria", Pathologies.get().toString()); //Controllo anche che effettivamente ci sia una sola istanza
	
		pts.remove(0);
		
		assertEquals ("Elenco patologie:\nTumore\nDissenteria", Pathologies.get().toString());
	
		try
		{
			pts.remove(10);
			assertEquals (true, false);
		}
		catch (IndexOutOfBoundsException e)
		{
			
		}
	}
	
}
