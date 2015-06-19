package it.unibs.ing.fp.groupX.medicalclinic.visit;

import it.unibs.ing.fp.groupX.medicalclinic.people.Doctor;
import it.unibs.ing.fp.groupX.medicalclinic.people.Patient;
import it.unibs.ing.fp.groupX.myutil.Utilities;

import java.util.Date;

/**
 * Classe che rappresenta una visita generica
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Visit
{
	/** Stringa per segnalare la mancanza di referto */
	private static final String STRINGA_REFERTO_NON_ANCORA_INSERITO = "Non ancora impostato";
	/** Stringa per segnalare la non selezion del dottore */
	private static final String STRINGA_DOTTORE_NON_SELEZIONATO = "Non Selezionato";
	/**Messaggio dell'eccezione*/
	private static final String DIAGOSIS_NOT_SET_MESSAGE = "Impossibile richiedere una diagnosi se non � ancora stata effettuata";
	/** Formato per toString **/
	private static final String TO_STRING_FORMAT = "Paziente: %s\nMotivo: %s\nData: %s\nStato: %s\nDottore: %s\nReferto:\n%s";
	/** Paziente da visitare **/
	private Patient patient;
	/** Motivo della visita **/
	private String motivation;
	/** Data di prenotazione **/
	private Date date;
	/** Stato della visita **/
	private VisitState state;
	/** Dottore che effettua la visita **/
	private Doctor doctor;
	/** Referto **/
	private Report report;
	/**
	 * Costruttore
	 * 
	 * @param patient Paziente da visitare
	 * @param motivation Motivazione della visita
	 * @param date Data di prenotazione
	 * @param state Stato della visita
	 * @param doctor Dottore che effettua la visita
	 */
	public Visit (Patient patient, String motivation, Date date, VisitState state, Doctor doctor)
	{
		this.patient = patient;
		this.motivation = motivation;
		this.date = date;
		this.state = state;
		this.doctor = doctor;
	}
	
	/**
	 * Costruttore senza stato (default a prenotata)
	 * 
	 * @param patient Paziente da visitare
	 * @param motivation Motivazione della visita
	 * @param date Data di prenotazione
	 * @param doctor Dottore che effettua la visita
	 */
	public Visit (Patient patient, String motivation, Date date, Doctor doctor)
	{
		this(patient, motivation, date, VisitState.PRENOTATA, doctor);
	}
	
	/**
	 * Ritorna lo stato della visita
	 * @return Stato della visita
	 */
	public VisitState getState() 
	{
		return state;
	}

	/**
	 * Ritorna il paziente da visitare
	 * @return Paziente da visitare
	 */
	public Patient getPatient() 
	{
		return patient;
	}

	/**
	 * Ritorna la motivazione
	 * @return Motivazione della visita
	 */
	public String getMotivation() 
	{
		return motivation;
	}

	/**
	 * Ritorna la data di prenotazione
	 * @return Data di prenotazione
	 */
	public Date getDate() 
	{
		return date;
	}

	/**
	 * Ritorna il dottore 
	 * @return Dottore che effettuer� la visita
	 */
	public Doctor getDoctor() 
	{
		return doctor;
	}
	
	/**
	 * Pone la visita in stato di completato
	 */
	public void completeVisit ()
	{
		state = VisitState.CONCLUSA;
	}
	
	/**
	 * Imposta il referto e pone la visita in stato di refertata
	 * @param diagnosis Diagnosi
	 * @param prescription Prescrizione
	 */
	public void setReport (Diagnosis diagnosis, Prescription prescription)
	{
		this.setReport(new Report(diagnosis, prescription, date));
	}
	
	/**
	 * Imposta il referto e pone la visita in stato di refertata
	 * @param diagnosis Diagnosi
	 * @param prescription Prescrizione
	 * @param date Data del referto
	 */
	public void setReport (Diagnosis diagnosis, Prescription prescription, Date date)
	{
		this.setReport(new Report(diagnosis, prescription, date));
	}
	
	/**
	 * Imposta il referto e pone la visita in stato di refertata
	 * @param report Referto
	 */
	public void setReport (Report report)
	{
		this.report = report;
		state = VisitState.REFERTATA;
	}
	
	/**
	 * Ritorna la diagnosi
	 * @return Il referto
	 * @throws IllegalStateException Lanciata quando non � ancora stata inserita una diagnosi
	 */
	public Report getReport() throws IllegalStateException
	{
		if (report == null)
			throw new IllegalStateException(DIAGOSIS_NOT_SET_MESSAGE);
		else
			return report;
	}
	
	/**
	 * Override di toString
	 */
	@Override
	public String toString ()
	{	
		String strDoctor;
		String strReport;
		
		if (doctor != null)
			strDoctor = doctor.toStringShort();
		else
			strDoctor = STRINGA_DOTTORE_NON_SELEZIONATO;
		
		if (report != null)
			strReport = report.toString();
		else
			strReport = STRINGA_REFERTO_NON_ANCORA_INSERITO;
		
		return String.format(TO_STRING_FORMAT, patient.toStringShort(), motivation, Utilities.dateToString(date), state.toString(), strDoctor, strReport);		   
	}
}