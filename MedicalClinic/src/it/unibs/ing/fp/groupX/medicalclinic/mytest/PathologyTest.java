package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathology;

import org.junit.Test;

public class PathologyTest {
	@Test
	public void pathologyTest() throws Exception {
		Pathology p1 = new Pathology("Ulcera");
		Pathology p2 = new Pathology("Ebola");
		Pathology p3 = new Pathology("ulcera");
		
		assertEquals("Ulcera", p1.toString());
		assertEquals(false, p1.equals(p2));
		assertEquals(true, p1.equals(p3));
	}
}
