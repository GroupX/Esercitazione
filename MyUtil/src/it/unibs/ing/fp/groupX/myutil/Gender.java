package it.unibs.ing.fp.groupX.myutil;

/**
 * Enum per la gestione del genere di una persona
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public enum Gender {
	/** Femmina */
	FEMALE ('F'),
	/** Maschio */
	MALE ('M');
	
	/** Carattere identificativo maschio/femmina */
	private char gen;
	
	/**
	 * Costruttore privato
	 * @param g
	 * 			carattere identificativo
	 */
	private Gender (char g)
	{
		this.gen = g;
	}
	
	/**
	 * Ritorna il carattere del genere
	 * @return carattere identificativo del genere
	 */
	public char toChar ()
	{
		return gen;
	}
}
