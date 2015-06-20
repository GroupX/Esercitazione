package it.unibs.ing.fp.groupX.medicalclinic;

import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathologies;
import it.unibs.ing.fp.groupX.medicalclinic.people.Person;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillAreas;

public class MainTest {

	public static void main(String[] args) {
		
		/*Person p = Person.readFromConsole(); 

		System.out.println(p.toString());*/
		
//		Pathologies.get().use();
		
		SkillAreas sa = new SkillAreas();
		
		sa.use();
	}

}
