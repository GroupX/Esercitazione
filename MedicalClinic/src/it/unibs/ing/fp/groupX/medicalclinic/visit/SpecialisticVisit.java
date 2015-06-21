package it.unibs.ing.fp.groupX.medicalclinic.visit;

import it.unibs.ing.fp.groupX.medicalclinic.people.Doctor;
import it.unibs.ing.fp.groupX.medicalclinic.people.Patient;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillArea;

import java.util.Date;

public class SpecialisticVisit extends Visit
{
	SkillArea skArea;
	
	public SpecialisticVisit (Patient patient, String motivation, Date date, VisitState state, Doctor doctor, SkillArea skArea)
	{
		super(patient, motivation, date, state, doctor);
		
		
	}
}
