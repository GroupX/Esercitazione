package it.unibs.ing.fp.groupX.medicalclinic;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe che implementa una diagnosi
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Diagnosis {
	/** Formato di stampa */
	private static final String PRINT_FORMAT = "%s in data %s";
	/** Formato di stampa della data */
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	/** Patologia sofferta */
	private Pathology p;
	/** Data diagnosi */
	private Date d;
	
	/**
	 * Costruttore con nome patologia e data
	 * @param pathologyName
	 * 			Nome patologia
	 * @param d
	 * 			Data
	 */
	public Diagnosis (String pathologyName, Date d) throws IllegalArgumentException
	{
		this.p = Pathologies.get(pathologyName);
		this.d = d;
	}
	
	/**
	 * @return the pathology
	 */
	public Pathology getPathology() {
		return p;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return d;
	}
	
	/**
	 * Controlla se la diagnosi è sulla patologia passata
	 * @param p
	 * 			patologia da controllare
	 * @return true: patologia corretta; false: altrimenti
	 */
	public boolean hasPathology (Pathology p)
	{
		return this.p.equals(p);
	}
	
	/**
	 * Controlla se la diagnosi è stata effettuata nella data passata
	 * @param d
	 * 			Data da controllare
	 * @return true: la data coincide; false: altrimenti
	 */
	public boolean inDate (Date d)
	{
		if (this.d.equals(d))
			return true;
		else
			return false;
	}
	
	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return String.format(PRINT_FORMAT, p.getName(), sdf.format(d));
	}
	
	/**
	 * Override di equals
	 * @return true: le diagnosi coincidono; false: altrimenti
	 */
	@Override
	public boolean equals(Object obj) {
		Diagnosis dia = (Diagnosis)obj;
		
		if (dia.inDate(d) && dia.hasPathology(p))
			return true;
		else
			return false;
	}
}
