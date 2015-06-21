package it.unibs.ing.fp.groupX.medicalclinic;

import java.io.FileNotFoundException;
import java.io.IOException;

import it.unibs.ing.fp.groupX.medicalclinic.pathologies.*;

public class PreloadMain {
	
	private static final int STAFF_NUMBER = 4;
	private static final int PATIENT_NUMBER = 4;
	private static final int VISIT_NUMBER = 6;
	private static final int PATHOLOGIES_NUMBER = 3;
	
	public static void main(String[] args) {
		Pathology[] p = new Pathology[PATHOLOGIES_NUMBER];
		
		p[0] = new Pathology("Tonsillite");
		p[1] = new Pathology("Tumore al cervello");
		p[2] = new Pathology("Lesione al ginocchio");
		
		for (Pathology pat : p)
		{
			Pathologies.get().add(pat);
		}
		
		try {
			DataManager.savePathologies();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
