package it.unibs.ing.fp.groupX.medicalclinic;

import it.unibs.ing.fp.groupX.medicalclinic.people.Person;

public class MainTest {

	public static void main(String[] args) {
		
		Person p = Person.readFromConsole(); 

		System.out.println(p.toString());
	}

}
