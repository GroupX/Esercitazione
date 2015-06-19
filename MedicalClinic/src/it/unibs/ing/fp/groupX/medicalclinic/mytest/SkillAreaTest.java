package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillArea;

import org.junit.Test;

public class SkillAreaTest
{
	@Test
	public void skillAreaTest() throws Exception
	{
		SkillArea sa = new SkillArea("Cardiologia");
		
		assertEquals ("Cardiologia", sa.toString());
	}
}
