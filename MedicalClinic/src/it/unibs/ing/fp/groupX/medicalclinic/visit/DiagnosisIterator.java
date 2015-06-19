package it.unibs.ing.fp.groupX.medicalclinic.visit;

import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathology;

import java.util.Iterator;

public class DiagnosisIterator implements Iterator<Pathology> {

	int actIndex = 0;
	Diagnosis d;
	
	public DiagnosisIterator(Diagnosis d) {
		this.d = d;
	}
	
	@Override
	public boolean hasNext() {
		if (actIndex < d.size())
			return true;
		else
			return false;
	}

	@Override
	public Pathology next() {
		if (hasNext())
			return d.getPathology(actIndex);
		else
			return null;
	}


}
