package it.unibs.ing.fp.groupX.myutil;

import java.io.Serializable;

/**
 * Classe che implementa un codice fiscale
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class CodiceFiscale implements Readable, Serializable {
	private static final String CODE_READ_MESSAGE = "Inserire codice fiscale: ";
	private static final String NOT_VALID_MESSAGE = "Codice non valido. Reinserire";
	/** Stringa di errore in inserimento */
	private static final String ERRORE_INSERIMENTO = "Il codice passato non è valido!";
	/** Espressione regolare per il controllo di validità - presa da Internet*/
	private static final String REGEX = "^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$";
	
	/** Codice fiscale */
	private String cod;
	
	/**
	 * Legge un codice fiscale da console
	 * Metodo factory
	 * @return Un codice fiscale letto da console
	 */
	public static CodiceFiscale readFromConsole()
	{
		CodiceFiscale ris = new CodiceFiscale();
		ris.read();
		return ris;
	}
	
	/**
	 * Costruttore senza parametri
	 * 
	 * ATTENZIONE: Da usare con read!!!
	 */
	private CodiceFiscale ()
	{
		
	}
	
	/**
	 * Costruttore che inizializza da un codice fiscale formato String
	 * @param cod
	 * 			Codice fiscale da inserire
	 * @throws IllegalArgumentException
	 * 			Codice non valido
	 */
	public CodiceFiscale (String cod) throws IllegalArgumentException
	{
		if (CodiceFiscale.isValid(cod))
			this.cod = new String(cod);
		else
		{
			IllegalArgumentException e = new IllegalArgumentException(ERRORE_INSERIMENTO);
			throw e;
		}
	}
	
	/**
	 * Costruttore copia
	 * @param c
	 * 			Codice fiscale da copiare
	 */
	public CodiceFiscale (CodiceFiscale c)
	{
		this(c.toString());
	}
	
	/**
	 * Ritorna il codice
	 * @return codice
	 */
	public String getCod()
	{
		return cod;
	}
	
	/**
	 * Override di toString
	 * @return Codice fiscale
	 */
	@Override
	public String toString() 
	{
		return getCod();
	}
	
	/**
	 * Override di equals
	 * @return true: si equivalgono; false: altrimenti
	 */
	@Override
	public boolean equals(Object obj) {
		CodiceFiscale c = (CodiceFiscale)obj;
		return cod.equalsIgnoreCase(c.getCod());
	}
	
	/**
	 * Metodo per controllare la validità di un codice fiscale formato String
	 * @param cod
	 * 			Codice fiscale da controllare
	 * @return true: valido; false: invalido
	 */
	public static boolean isValid (String cod)
	{
		return cod.matches(REGEX);
	}

	@Override
	public void read() {
		
		String line;
		
		while(!CodiceFiscale.isValid(line = IOLib.readLine(CODE_READ_MESSAGE)))
		{
			System.out.println(NOT_VALID_MESSAGE);
		}
		
		this.cod = line;
		
	}
}
