package it.unibs.ing.fp.groupX.medicalclinic.visit;

import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.Readable;
import it.unibs.ing.fp.groupX.myutil.Utilities;

import java.util.Date;

/**
 * Classe che definisce un referto
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Report implements Readable{

	private static final String INSERT_DATE_MSG = "Inserisci data e l'ora del referto [gg/mm/aaaa hh:mm:ss]: ";

	private static String TO_STRING_FORMAT = "Data:%s\n\n%s\n\n%s";
	
	/** Diagnosi */
	private Diagnosis diagnosis;
	/** Prescrizione */
	private Prescription prescription;
	/** Data del referto */
	private Date date;
	
	/**
	 * Metodo factory per creare un referto leggendolo dalla console
	 * @return Il report letto
	 */
	public static Report readFromConsole ()
	{
		Report r = new Report();
		
		r.read();
		
		return r;
	}
	
	/**
	 * Costruttore vuoto per read
	 */
	private Report ()
	{
		
	}
	
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
		return String.format(TO_STRING_FORMAT, Utilities.dateTimeToString(date), diagnosis.toString(), prescription.toString());
	}

	@Override
	public void read() {

		IOLib.printLine(INSERT_DATE_MSG);
		this.date = IOLib.readDateTime();
		
		this.diagnosis = Diagnosis.readFromConsole();
		this.prescription = Prescription.readFromConsole();
		
	}
}
