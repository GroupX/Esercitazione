package it.unibs.ing.fp.groupX.medicalclinic.visit;

import java.util.Iterator;

public class PrescriptionIterator implements Iterator<PrescriptionEntry>{
	
	int actIndex = 0;
	Prescription p;
	
	public PrescriptionIterator(Prescription p) {
		this.p = p;
	}
	
	@Override
	public boolean hasNext() {
		if (actIndex < p.size())
			return true;
		else
			return false;
	}

	@Override
	public PrescriptionEntry next() {
		if (hasNext())
			return p.get(actIndex);
		else
			return null;
	}

}
