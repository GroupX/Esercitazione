package it.unibs.ing.fp.groupX.myutil;

public class StringManager
{
	private final static int FIRST_LETTER_NAME = 0;
	
	/**
	 * Ritorna la stringa passata con tutte le iniziali delle parole contenute in maiuscolo
	 * @param str
	 * 			Stringa da trasformare
	 * @param wordSeparator
	 * 			Separatore tra una parola e l'altra
	 * @return Stringa modificata
	 */
	public static String initialToUpper (String str, String wordSeparator)
	{
		String[] disjointedName = str.split (wordSeparator);
		StringBuffer finalStr = new StringBuffer();
		
		for (String piece : disjointedName)
		{
			finalStr.append (Character.toUpperCase (piece.charAt (FIRST_LETTER_NAME)) + piece.substring (FIRST_LETTER_NAME+1) + wordSeparator);
		}
		
		finalStr.delete ( finalStr.length () - wordSeparator.length (), finalStr.length() );
		
		return finalStr.toString ();
	}
}
