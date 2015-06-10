package it.unibs.ing.fp.groupX.medicalclinic;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe che implementa una cartella clinica
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class ClinicFolder
{
	/** Intestazione di stampa */
	private static final String PRINT_HEADER = "Elenco diagnosi:";
	
	/** Elenco diagnosi */
	private ArrayList<Diagnosis> diag;
	
	/**
	 * Costruttore default
	 */
	public ClinicFolder ()
	{
		diag = new ArrayList<Diagnosis>();
	}
	
	/**
	 * Costruttore copia
	 * @param fol
	 * 			Cartella clinica da copiare
	 */
	public ClinicFolder (ClinicFolder fol)
	{
		this();
		for (Diagnosis d : fol.toArray())
		{
			diag.add(d);
		}
	}
	
	/**
	 * Aggiunge una patologia all'elenco
	 * @param pathologyName
	 * 				Nome patologia da aggiungere
	 * @return true: patologia aggiunta; false: altrimenti
	 */
	public boolean add (String pathologyName, Date d)
	{
		try
		{
			diag.add(new Diagnosis(pathologyName, d));
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}
	
	/**
	 * Ritorna la diagnosi indicata dall'indice
	 * @param index
	 * 				indice della diagnosi
	 * @return diagnosi indicata
	 * @throws IndexOutOfBoundsException
	 * 				indice non valido
	 */
	public Diagnosis get (int index) throws IndexOutOfBoundsException
	{
		return diag.get(index);
	}
	
	/**
	 * Ritorna tutte le diagnosi con la patologia passata
	 * @param p
	 * 			patologia da cercare
	 * @return ArrayList di Diagnosis contenenti la patologia
	 */
	public ArrayList<Diagnosis> get (Pathology p)
	{
		ArrayList<Diagnosis> ris = new ArrayList<Diagnosis>();
		
		for (Diagnosis d: diag)
		{
			if (d.hasPathology(p))
				ris.add(d);
		}
		
		return ris;
	}
	
	/**
	 * Ritorna tutte le diagnosi effettuate in data passata
	 * @param d
	 * 			data da cercare
	 * @return ArrayList di Diagnosis in data d
	 */
	public ArrayList<Diagnosis> get (Date d)
	{
		ArrayList<Diagnosis> ris = new ArrayList<Diagnosis>();
		
		for (Diagnosis dia: diag)
		{
			if (dia.inDate(d))
				ris.add(dia);
		}
		
		return ris;
	}
	
	/**
	 * Ritorna un array di tutte le diagnosi nella cartella clinica
	 * @return array di diagnosi
	 */
	public Diagnosis[] toArray ()
	{
		Diagnosis[] d = new Diagnosis[diag.size()];
		return diag.toArray(d);
	}
	
	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append(PRINT_HEADER);
		for (Diagnosis d : diag)
		{
			str.append("\n"+d.toString());
		}
		
		return str.toString();
	}
}
