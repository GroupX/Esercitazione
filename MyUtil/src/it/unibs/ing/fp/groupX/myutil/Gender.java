package it.unibs.ing.fp.groupX.myutil;

import java.io.Serializable;

/**
 * Enum per la gestione del genere di una persona
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public enum Gender implements Readable, Serializable {
	/** Femmina */
	FEMALE ('F'),
	/** Maschio */
	MALE ('M');
	
	private static final String GENDER_INSERT_MESSAGE = "Inserire genere [M/F]: ";
	/** Carattere identificativo maschio/femmina */
	private char gen;

	public static Gender readFromConsole ()
	{
		Gender ris = Gender.MALE;
		
		ris.read();
		
		return ris;
	}
	
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

	@Override
	public void read() {

		String str;
		boolean ok = false;
		
		while (!ok)
		{
			str = IOLib.readLine(GENDER_INSERT_MESSAGE);
			str = str.toUpperCase();
			switch (str)
			{
				case "M":
					this.gen = 'M';
					ok = true;
					break;
				case "F":
					this.gen = 'F';
					ok = true;
					break;
			}
		}
		
		
	}
}
