package it.unibs.ing.fp.groupX.medicalclinic.visit;

/**
 * Enum per lo stato della visita
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public enum VisitState {
	PRENOTATA("prenotata"),
	CONCLUSA("conclusa"),
	REFERTATA("refertata"),
	NON_PRENOTABILE("non prenotabile");
	
	/** Stato della visita */
	private String state;
	
	/**
	 * Costruttore privato
	 * @param s
	 * 			stato della visita
	 */
	private VisitState (String s)
	{
		this.state = s;
	}
	
	/**
	 * Override di toString
	 * @return stato della visita
	 */
	@Override
	public String toString ()
	{
		return state;
	}
}
