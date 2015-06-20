package it.unibs.ing.fp.groupX.medicalclinic.pathologies;

import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.Readable;


/**
 * Classe patologia
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Pathology implements Readable {
	private static final String INSERT_PATHOLOGY_MSG = "Inserisci nome della patologia: ";
	/** Nome */
	private String name;
	
	/**
	 * Metodo factory che legge una patologia da console
	 * @return Patologia letta
	 */
	public static Pathology readFromConsole ()
	{
		Pathology p = new Pathology();
		
		p.read();
		
		return p;
	}
	
	/**
	 * Costruttore senza parametri per read
	 */
	private Pathology ()
	{
		
	}
	
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
	
	@Override
	public String toString ()
	{
		return name;
	}

	@Override
	public void read() {
		name = IOLib.readLine(INSERT_PATHOLOGY_MSG);
	}
}
