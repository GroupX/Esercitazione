package it.unibs.ing.fp.groupX.medicalclinic;

import java.sql.Time;
import java.util.ArrayList;

/**
 * Classe per la gestione degli orari della clinica
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class ClinicWorkingTime
{
	/** Ampiezza in minuti degli slot */
	public static final int SLOT_MINUTES = 30;
	
	/** Orario inizio lavoro */
	private Time startWork;
	/** Orario fine lavoro */
	private Time endWork;
	/** Numero di slot per giorno */
	private int numSlot;
	
	
	
	
	public ClinicWorkingTime ()
	{
		
	}
	
	
	
}
