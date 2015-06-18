package it.unibs.ing.fp.groupX.medicalclinic;

import it.unibs.ing.fp.groupX.myutil.Utilities;

import java.util.Date;

/**
 * Classe che definisce un referto
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Report {

	private static String TO_STRING_FORMAT = "Data:%s\n\nDiagnosi:\n%s\n\nPrescrizione:\n%s";
	
	/** Diagnosi */
	private Diagnosis diagnosis;
	/** Prescrizione */
	private Prescription prescription;
	/** Data del referto */
	private Date date;
	
	/**
	 * Costruttore
	 * @param diagnosis Diagnosi
	 * @param prescription Prescrizione
	 * @param date Data in cui è stato realizzato il referto
	 */
	public Report (Diagnosis diagnosis, Prescription prescription, Date date)
	{
		this.diagnosis = diagnosis;
		this.prescription = prescription;
		this.date = date;
	}
	
	/**
	 * @return the diagnosis
	 */
	public Diagnosis getDiagnosis() {
		return diagnosis;
	}

	/**
	 * @return the prescription
	 */
	public Prescription getPrescription() {
		return prescription;
	}
	
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * Controlla se il referto è stato creato nella data passata
	 * @param d
	 * 			Data da controllare
	 * @return true: la data coincide; false: altrimenti
	 */
	public boolean inDate (Date d)
	{
		if (this.date.equals(d))
			return true;
		else
			return false;
	}
	
	@Override
	public String toString ()
	{
		return String.format(TO_STRING_FORMAT, Utilities.dateToString(date), diagnosis.toString(), prescription.toString());
	}
}
