package it.unibs.ing.fp.groupX.medicalclinic.mytest;

import static org.junit.Assert.*;
import it.unibs.ing.fp.groupX.medicalclinic.PreloadMain;
import it.unibs.ing.fp.groupX.medicalclinic.people.SpecialistDoctor;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillArea;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Visit;

import org.junit.Test;

public class SpecialistDoctorTest {
	
	private static final String TO_STRING_RESULT = "Luca Neri\nNato il 01/03/1975 a Milano\nCodice Fiscale: NRELCU75C01F205C\nNumero di telefono: +39 3333333335\nNumero Albo: %s\nCompetenze:\nGenerale\nNeurochirurgia";

	@Test
	public void toStringTest() throws Exception {
		
		SpecialistDoctor d = (SpecialistDoctor)PreloadMain.DEFAULT_STAFF[2];
		
		assertEquals (String.format(TO_STRING_RESULT,d.getAlbo()),d.toString());
	}
	
	@Test
	public void equalsTest() throws Exception {
		
		SpecialistDoctor d1 = (SpecialistDoctor)PreloadMain.DEFAULT_STAFF[2];
		SpecialistDoctor d2 = (SpecialistDoctor)PreloadMain.DEFAULT_STAFF[2];
		SpecialistDoctor d3 = (SpecialistDoctor)PreloadMain.DEFAULT_STAFF[3];
		
		assertTrue (d1.equals(d2));
		assertFalse (d1.equals(d3));
	}
	
	@Test
	public void canDoTest() throws Exception {
		
		SpecialistDoctor d = (SpecialistDoctor)PreloadMain.DEFAULT_STAFF[2];
		Visit v1 = PreloadMain.DEFAULT_VISIT[0];
		Visit v2 = PreloadMain.DEFAULT_VISIT[3];
		Visit v3 = PreloadMain.DEFAULT_VISIT[4];
		
		assertTrue (d.canDo(v1));
		assertTrue (d.canDo(v2));
		assertFalse (d.canDo(v3));
		
	}
	
	@Test
	public void isAbleTest() throws Exception {
		
		SpecialistDoctor d = (SpecialistDoctor)PreloadMain.DEFAULT_STAFF[2];
		SkillArea sa1 = new SkillArea(PreloadMain.DEFAULT_SKILL_AREAS[0]);
		SkillArea sa2 = new SkillArea(PreloadMain.DEFAULT_SKILL_AREAS[1]);
		
		assertTrue (d.isAble(sa1));
		assertFalse (d.isAble(sa2));
		
	}
	
	@Test
	public void addSkillTest() throws Exception {
		
		SpecialistDoctor d = (SpecialistDoctor)PreloadMain.DEFAULT_STAFF[2];
		SkillArea sa1 = new SkillArea(PreloadMain.DEFAULT_SKILL_AREAS[0]);
		SkillArea sa2 = new SkillArea(PreloadMain.DEFAULT_SKILL_AREAS[2]);
		
		try
		{
			d.addSkill(sa1);
			assertTrue(false); //Non deve aggiungerla in quanto il dottore possiede già questa competenza
		}
		catch (IllegalArgumentException e)
		{
			//Tutto ok
		}
		
		try
		{
			d.addSkill(sa2);
			//Tutto ok
		}
		catch (IllegalArgumentException e)
		{
			assertTrue(false); //Deve aggiungerla in quanto il dottore non possiede questa competenza
		}
		
	}
	
	@Test
	public void removeSkillTest() throws Exception {

		SpecialistDoctor d = (SpecialistDoctor)PreloadMain.DEFAULT_STAFF[2];
		SkillArea sa1 = new SkillArea(PreloadMain.DEFAULT_SKILL_AREAS[0]);
		SkillArea sa2 = new SkillArea(PreloadMain.DEFAULT_SKILL_AREAS[2]);
		
		try
		{
			d.removeSkill(sa2);
			assertTrue(false); //Non deve rimuoverla in quanto il dottore non possiede questa competenza
		}
		catch (IllegalArgumentException e)
		{
			//Tutto ok
		}
		
		try
		{
			d.removeSkill(sa1);
			//Tutto ok
		}
		catch (IllegalArgumentException e)
		{
			assertTrue(false); //Deve rimuoverla in quanto il dottore possiede questa competenza
		}
		
	}
	
}
