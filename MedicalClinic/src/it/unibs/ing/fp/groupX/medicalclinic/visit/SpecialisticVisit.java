package it.unibs.ing.fp.groupX.medicalclinic.visit;

import it.unibs.ing.fp.groupX.medicalclinic.people.Patient;
import it.unibs.ing.fp.groupX.medicalclinic.people.SpecialistDoctor;
import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillArea;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class SpecialisticVisit extends Visit implements Serializable
{
	private static final String TO_STRING_MSG = "Area di competenza: %s\nVisita precedente:\n%s\nIl referto era ok? %s";
	private static final String PREV_REPORT_OK = "Il referto precedente era ok?";
	private static final String PREV_VISIT_NOT_SET_MSG = "Impossibile settare. Visita precedente non impostata.";
	private static final String VISIT_NOT_REFERTED_MSG = "Impossibile salvare informazioni sulla visita precedente senza che sia stato impostato il referto.";
	/** Area di competenza richiesta */
	private SkillArea skArea;
	/** Visita generica precedente */
	private Visit prevVisit;
	/** True se il referto della visita precedente era ok, false altrimenti */
	private boolean prevVisitReportOk = false;
	
	/**
	 * Costruttore 
	 * @param v Visita
	 * @param skArea Area di competenza
	 * @param prevVisit Visita precedente
	 */
	public SpecialisticVisit (Visit v, SkillArea skArea, Visit prevVisit)
	{
		super(v);
		
		this.skArea = skArea;
		this.prevVisit = prevVisit;
	}
	
	/**
	 * Costruttore
	 * @param patient Paziente
	 * @param motivation Motivo della visita
	 * @param date Data della visita
	 * @param state Stato della visita
	 * @param doctor Dottore specialistico interessato
	 * @param skArea Area di competenza richiesta per la visita
	 * @param prevVisit Visita precedente (può essere null)
	 */
	public SpecialisticVisit (Patient patient, String motivation, Date date, VisitState state, SpecialistDoctor doctor, SkillArea skArea, Visit prevVisit)
	{
		super(patient, motivation, date, state, doctor);
		
		this.skArea = skArea;
		this.prevVisit = prevVisit;
	}
	
	/**
	 * Costruttore
	 * @param patient Paziente
	 * @param motivation Motivo della visita
	 * @param date Data della visita
	 * @param doctor Dottore specialistico interessato
	 * @param skArea Area di competenza richiesta per la visita
	 */
	public SpecialisticVisit (Patient patient, String motivation, Date date, SpecialistDoctor doctor, SkillArea skArea)
	{
		this(patient, motivation, date, VisitState.PRENOTATA, doctor, skArea, null);
	}


	/**
	 * Imposta lo stato della visita precedente
	 * @param correct true se il referto era esatto, false altrimenti
	 */
	public void setPreviousVisitStatus (boolean correct)
	{
		if (this.getState() != VisitState.REFERTATA)
			throw new IllegalStateException(VISIT_NOT_REFERTED_MSG);
		
		if (prevVisit == null)
			throw new IllegalStateException(PREV_VISIT_NOT_SET_MSG);
		
		this.prevVisitReportOk = correct;
	}
	
	@Override
	public String toString ()
	{
		StringBuffer buf = new StringBuffer(super.toString());
		
		buf.append(String.format(TO_STRING_MSG, skArea.getName(), prevVisit == null?"Non impostata":prevVisit.toString(), prevVisitReportOk?"Si":"No"));
		
		return buf.toString();
	}
	
	@Override
	public void use()
	{
		final int COMPLETE_VISIT_CHOICE = 1;
		final int SET_REPORT_CHOICE = 2;
		final int SET_PREV_VISIT_STATE_CHOICE = 3;
		final int PRINT_VISIT_CHOICE = 4;
		// TODO use constants
		
		MyMenu menu = new MyMenu("Gestione Visita Specialistica", "Completa visita", "Imposta referto", "Imposta stato visita precedente", "Stampa visita");
		int scelta;
		
		while ((scelta = menu.getChoice())!=MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
				case COMPLETE_VISIT_CHOICE:
					
					try
					{
						this.completeVisit();
					}
					catch (IllegalStateException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
				
				case SET_REPORT_CHOICE:
					
					try
					{
						this.setReport(Report.readFromConsole());
					}
					catch (IllegalStateException | IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
					
				case SET_PREV_VISIT_STATE_CHOICE:
					
					try
					{
						this.setPreviousVisitStatus(IOLib.twoWayQuestion(PREV_REPORT_OK));
					}
					catch (IllegalStateException | IllegalArgumentException e)
					{
						IOLib.printLine(e.getMessage());
					}
					
					break;
					
				case PRINT_VISIT_CHOICE:
					
					IOLib.printLine(this.toString());
					
					break;
			}
		}
	}
}
