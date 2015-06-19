package it.unibs.ing.fp.groupX.medicalclinic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe che implementa una diagnosi
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Diagnosis implements Iterable<Pathology> {
	
	/** Patologia sofferta */
	private List<Pathology> pList = new ArrayList<Pathology>();
	
	/**
	 * Costruttore senza parametri
	 */
	public Diagnosis ()
	{
		
	}
	
	/**
	 * Costruttore con insieme di patologie
	 * @param pathologies Elenco patologie
	 * @throws IllegalArgumentException Una patologia è inesistente
	 */
	public Diagnosis (String ... pathologies) throws IllegalArgumentException
	{
		for (String pName :pathologies)
		{
			this.addPathology(pName);
		}
	}
	
	/**
	 * Costruttore con insieme di patologie
	 * @param pathologies Elenco di patologie
	 */
	public Diagnosis (Pathology ... pathologies)
	{
		for (Pathology p :pathologies)
		{
			this.addPathology(p);
		}
	}
	
	/**
	 * Aggiunge una patologia
	 * @param p Patologia da aggiungere
	 */
	public void addPathology (Pathology p)
	{
		this.pList.add(p);
	}
	
	/**
	 * Aggiunge una patologia
	 * @param pathologyName Nome della patologia
	 * @throws IllegalArgumentException Patologia inesistente
	 */
	public void addPathology (String pathologyName) throws IllegalArgumentException
	{
		this.pList.add(Pathologies.get().get(pathologyName));
	}
	
	/**
	 * Ritorna la patologia richiesta
	 * @param index Indice
	 * @return Patologia richiesta
	 */
	public Pathology getPathology(int index) {
		return pList.get(index);
	}

	/**
	 * Ritorna il numero di patologie inserite
	 * @return Numero di patologie
	 */
	public int size()
	{
		return pList.size();
	}
	
	/**
	 * Controlla se la diagnosi è sulla patologia passata
	 * @param p
	 * 			patologia da controllare
	 * @return true: patologia corretta; false: altrimenti
	 */
	public boolean hasPathology (Pathology p)
	{
		return this.pList.contains(p);
	}

	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		for (Pathology p : this)
		{
			buf.append(p.toString() + "\n");
		}
		
		buf.delete(buf.length() - 1, buf.length());
		
		return buf.toString();
	}

	@Override
	public Iterator<Pathology> iterator() {
		return new DiagnosisIterator(this);
	}
}
