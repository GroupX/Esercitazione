package it.unibs.ing.fp.groupX.medicalclinic;

/**
 * Classe patologia
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Pathology {
	/** Nome */
	private String name;
	
	/**
	 * Costruttore con nome
	 * @param name
	 * 			Nome patologia
	 */
	public Pathology (String name)
	{
		this.name = name;
	}
	
	/**
	 * Ritorna il nome della patologia
	 * @return Nome della patologia
	 */
	public String getName ()
	{
		return name;
	}
	
	/**
	 * Override di equals
	 * @return true: sono uguali; false: altrimenti
	 */
	@Override
	public boolean equals(Object obj) {
		Pathology p = (Pathology)obj;
		
		if (name.equalsIgnoreCase(p.getName()))
			return true;
		else
			return false;
	}
}
