package it.unibs.ing.fp.groupX.myutil;

/**
 * Classe che implementa un codice fiscale
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class CodiceFiscale {
	/** Stringa di errore in inserimento */
	private static final String ERRORE_INSERIMENTO = "Il codice passato non è valido!";
	/** Espressione regolare per il controllo di validità - presa da Internet*/
	private static final String REGEX = "^[a-zA-Z]{6}[0-9]{2}[abcdehlmprstABCDEHLMPRST]{1}[0-9]{2}([a-zA-Z]{1}[0-9]{3})[a-zA-Z]{1}$";
	
	/** Codice fiscale */
	private String cod;
	
	
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
	 * Override di toString
	 * @return Codice fiscale
	 */
	@Override
	public String toString() 
	{
		return cod;
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
}
