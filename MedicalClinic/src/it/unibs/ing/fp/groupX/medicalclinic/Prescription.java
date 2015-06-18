package it.unibs.ing.fp.groupX.medicalclinic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe che definisce le prescrizioni
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Prescription implements Iterable<PrescriptionEntry>{
	
	/**Lista dei rimedi proposti*/
	private List<PrescriptionEntry> entries = new ArrayList<>();
	
	/**
	 * Costruttore senza parametri
	 */
	public Prescription ()
	{
		
	}
	
	/**
	 * Costruttore con lista di rimedi
	 * @param pe Lista dei rimedi
	 */
	public Prescription (PrescriptionEntry ... pe)
	{
		for (PrescriptionEntry p : pe)
		{
			entries.add(p);
		}
	}
	
	/**
	 * Aggiunge un rimedio alla lista
	 * @param pe Rimedio da aggiungere
	 */
	public void addEntry (PrescriptionEntry pe)
	{
		entries.add(pe);
	}
	
	/**
	 * Ritrona il numero di rimedi presenti
	 * @return numero di rimedi presenti
	 */
	public int size()
	{
		return entries.size();
	}
	
	/**
	 * Ritorna un elemento della prescrizione
	 * @param index Indice dell'elemento
	 * @return elemento richiesto
	 */
	public PrescriptionEntry get (int index)
	{
		if (index < 0 || index >= entries.size())
			throw new IndexOutOfBoundsException("Indice fuori dai limiti");
		
		return entries.get(index);
	}
	
	@Override
	public String toString ()
	{
		StringBuffer strBuff = new StringBuffer();
		
		for (PrescriptionEntry pe: this)
		{
			strBuff.append(pe.toString() + "\n");
		}
		
		strBuff.delete(strBuff.length() - 1, strBuff.length());
		return strBuff.toString();
	}

	@Override
	public Iterator<PrescriptionEntry> iterator() {
		return new PrescriptionIterator(this);
	}
	
	
	
}
