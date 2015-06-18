package it.unibs.ing.fp.groupX.medicalclinic;

/**
 * Classe che definisce un referto
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Report {

	private static String TO_STRING_FORMAT = "Diagnosi:\n%s\n\nPrescrizione:\n%s";
	
	/** Diagnosi */
	private Diagnosis diagnosis;
	/** Prescrizione */
	private Prescription prescription;
	
	public Report (Diagnosis diagnosis, Prescription prescription)
	{
		this.diagnosis = diagnosis;
		this.prescription = prescription;
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
	
	@Override
	public String toString ()
	{
		return String.format(TO_STRING_FORMAT, diagnosis.toString(), prescription.toString());
	}
}
