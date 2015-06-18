package it.unibs.ing.fp.groupX.medicalclinic;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe che definisce le prescrizioni
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Prescription {
	
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
	 * Ritorna la lista dei rimedi
	 * @return Lista
	 */
	public List<PrescriptionEntry> getList ()
	{
		return entries;
	}
	
	@Override
	public String toString ()
	{
		StringBuffer strBuff = new StringBuffer();
		
		for (PrescriptionEntry pe: entries)
		{
			strBuff.append(pe.toString() + "\n");
		}
		
		strBuff.delete(strBuff.length() - 1, strBuff.length());
		return strBuff.toString();
	}
	
}
