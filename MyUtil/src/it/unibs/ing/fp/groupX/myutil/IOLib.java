package it.unibs.ing.fp.groupX.myutil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

import javax.xml.crypto.Data;

/**
 * Classe generale di gestione Input / Output
 * 
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class IOLib
{	
	private static final String NOT_VALID_DATE_MESSAGE = "Data non valida. Reinserire";
	/** Messaggio stampato per richiedere i secondi */
	private static final String MESSAGGIO_SECONDI = "Secondi: ";
	/** Messaggio stampato per richiedere i minuti */
	private static final String MESSAGGIO_MINUTI = "Minuti: ";
	/** Messaggio stampato per richiedere le ore */
	private static final String MESSAGGIO_ORE = "Ore: ";

	/** Numero inserito in lettura non valido */
	private static final String LETTURA_NUMERO_NON_VALIDO = "Numero inserito non valido. Riprovare:";
	
	/** Risposta positiva nelle domande a due vie */
	public final static String TWO_WAY_QUESTION_YES = "Si";
	/** Risposta negativa nelle domande a due vie */
	public final static String TWO_WAY_QUESTION_NO = "No";
	/** Formato per risposta da accodare alle domande a due vie */
	private final static String TWO_WAY_QUESTION_RESPONSE_FORMAT = "["+TWO_WAY_QUESTION_YES+" ; "+TWO_WAY_QUESTION_NO+"]";
	/** Messaggio di errore per risposta non valida nelle domande a due vie */
	private final static String TWO_WAY_QUESTION_RESPONSE_ERROR = "Risposta data non e' valida";
	
	/**
	 * Costruttore privato
	 */
	private IOLib ()
	{
		
	}
	
	/**
	 * Stampa su console una riga di testo
	 * 
	 * @param msg
	 *            Stringa di testo da stampare
	 */
	public static void printLine (String msg)
	{
		System.out.println (msg);
	}

	/**
	 * Legge da tastiera un numero intero
	 * 
	 * @return Numero letto
	 */
	@Deprecated
	public static int readInt ()
	{
		Scanner scnr = new Scanner (System.in);
		int num = scnr.nextInt ();
		//scnr.close();
		return num;
	}
	
	/**
	 * Legge da tastiera un numero intero stampado un messaggio
	 * 
	 * @param msg
	 * 			Messaggio da stampare prima di leggere il numero
	 * 
	 * @return Numero letto
	 */
	public static int readInt (String msg)
	{
		printLine(msg);
		Scanner scnr = new Scanner (System.in);
		int num = scnr.nextInt ();
		//scnr.close();
		return num;
	}
	
	/**
	 * Legge da tastiera un numero intero stampado un messaggio e controllando se è maggiore o uguale di un valore
	 * 
	 * @param msg
	 * 			Messaggio da stampare prima di leggere il numero
	 * @param lowerBound
	 * 			Valore di soglia inferiore (accettato dalla lettura)
	 * 
	 * @return Numero letto
	 */
	public static int readInt (String msg, int lowerBound)
	{
		Scanner scnr = new Scanner (System.in);
		int num;
		do
		{
			printLine(msg);
			num = scnr.nextInt ();
			if (num < lowerBound)
			{
				printLine(LETTURA_NUMERO_NON_VALIDO);
			}
		}while (num < lowerBound);
		
		//scnr.close();
		return num;
	}
	
	/**
	 * Legge da tastiera un numero intero stampado un messaggio e controllando se è in un range di valori, estremi inclusi
	 * 
	 * @param msg
	 * 			Messaggio da stampare prima di leggere il numero
	 * @param lowerBound
	 * 			Valore di soglia inferiore (accettato dalla lettura)
	 * @param upperBound
	 * 			Valore di soglia superiore (accettato dalla lettura)
	 * 
	 * @return Numero letto
	 */
	public static int readInt (String msg, int lowerBound, int upperBound)
	{
		Scanner scnr = new Scanner (System.in);
		int num;
		do
		{
			printLine(msg);
			num = scnr.nextInt ();
			if (num < lowerBound || num > upperBound)
			{
				printLine(LETTURA_NUMERO_NON_VALIDO);
			}
		}while (num < lowerBound || num > upperBound);
		
		//scnr.close();
		return num;
	}
	
	/**
	 * Legge da tastiera un numero double
	 * 
	 * @return Numero letto
	 */
	@Deprecated
	public static double readDouble ()
	{
		Scanner scnr = new Scanner (System.in);
		double num = scnr.nextDouble ();
		//scnr.close();
		return num;
	}
	
	/**
	 * Legge da tastiera un numero double stampado un messaggio
	 * 
	 * @param msg
	 * 			Messaggio da stampare prima di leggere il numero
	 * 
	 * @return Numero letto
	 */
	public static double readDouble (String msg)
	{
		printLine(msg);
		Scanner scnr = new Scanner (System.in);
		double num = scnr.nextDouble ();
		//scnr.close();
		return num;
	}
	
	/**
	 * Legge da tastiera un numero double stampado un messaggio e controllando se è maggiore o uguale di un valore
	 * 
	 * @param msg
	 * 			Messaggio da stampare prima di leggere il numero
	 * @param lowerBound
	 * 			Valore di soglia inferiore (accettato dalla lettura)
	 * 
	 * @return Numero letto
	 */
	public static double readDouble (String msg, double lowerBound)
	{
		Scanner scnr = new Scanner (System.in);
		double num;
		do
		{
			printLine(msg);
			num = scnr.nextDouble ();
			if (num < lowerBound)
			{
				printLine(LETTURA_NUMERO_NON_VALIDO);
			}
		}while (num < lowerBound);
		
		//scnr.close();
		return num;
	}
	
	/**
	 * Legge da tastiera un numero double stampado un messaggio e controllando se è in un range di valori, estremi inclusi
	 * 
	 * @param msg
	 * 			Messaggio da stampare prima di leggere il numero
	 * @param lowerBound
	 * 			Valore di soglia inferiore (accettato dalla lettura)
	 * @param upperBound
	 * 			Valore di soglia superiore (accettato dalla lettura)
	 * 
	 * @return Numero letto
	 */
	public static double readDouble (String msg, double lowerBound, double upperBound)
	{
		Scanner scnr = new Scanner (System.in);
		double num;
		do
		{
			printLine(msg);
			num = scnr.nextDouble ();
			if (num < lowerBound || num > upperBound)
			{
				printLine(LETTURA_NUMERO_NON_VALIDO);
			}
		}while (num < upperBound || num > upperBound);
		
		//scnr.close();
		return num;
	}

	/**
	 * Legge da tastiera una stringa (si ferma a \n)
	 * 
	 * @return Stringa letta
	 */
	public static String readLine ()
	{
		Scanner scnr = new Scanner (System.in);
		return scnr.nextLine();
	}
	
	/**
	 * Legge da tastiera una stringa (si ferma a \n) stampando a video un messaggio
	 * 
	 * @param msg
	 * 			Messaggio da stampare a video prima della lettura
	 * 
	 * @return Stringa letta
	 */
	public static String readLine (String msg)
	{
		printLine(msg);
		return readLine();
	}
	
	/**
	 * Legge da tastiera una stringa di massima dimensione <i>length</i>
	 * @param length
	 * 			Massima dimensione della stringa letta
	 * @return Stringa letta
	 */
	public static String readLine (int length)
	{
		String line = readLine();
		if (line.length () < length)
			return line;
		return line.substring (0, length);
	}
	
	/**
	 * Legge da tastiera una stringa di massima dimensione <i>length</i> stampando a video un messaggio
	 * @param msg
	 * 			Messaggio da stampare a video prima della lettura
	 * @param length
	 * 			Massima dimensione della stringa letta
	 * @return Stringa letta
	 */
	public static String readLine (String msg, int length)
	{
		printLine(msg);
		return readLine(length);
	}
	
	/**
	 * Legge da tastiera una stringa e la ritorna solo se non contiene i caratteri indicati
	 * @param notPermitted
	 * 			Caratteri non permessi
	 * @return Stringa letta se non contiene i caratteri indicati, <b>null</b> altrimenti
	 */
	public static String readLine (char ... notPermitted)
	{
		String line = readLine();
		CharSequence s = new String(notPermitted);;
		
		if ( line.contains (s) )
			return null;
		return line;
	}
	
	/**
	 * Legge da tastiera una stringa e la ritorna solo se non contiene i caratteri indicati, stampando a video un messaggio prima della lettura
	 * @param msg
	 * 			Messaggio da stampare a video prima della lettura
	 * @param notPermitted
	 * 			Caratteri non permessi
	 * @return Stringa letta se corretta, <b>null</b> altrimenti
	 */
	public static String readLine (String msg, char ... notPermitted)
	{
		printLine (msg);
		return readLine(notPermitted);
	}
	
	/**
	 * Legge da tastiera una stringa lunga al massimo <i>length</i> e la ritorna solo se non contiene i caratteri indicati
	 * @param length
	 * 			Dimensione massima della stringa letta
	 * @param notPermitted
	 * 			Caratteri non ammessi
	 * @return Stringa letta se corretta, <b>null</b> altrimenti
	 */
	public static String readLine (int length, char ... notPermitted)
	{
		String line = readLine(length);
		CharSequence s = new String(notPermitted);;
		
		if ( line.contains (s) )
			return null;
		return line;
	}
	
	/**
	 * Legge da tastiera una stringa lunga al massimo <i>length</i> e la ritorna solo se non contiene i caratteri indicati,
	 * stampando a video un messaggio prima della lettura
	 * @param msg
	 * 			Messaggio da stampare a video prima della lettura
	 * @param length
	 * 			Dimensione massima della stringa letta
	 * @param notPermitted
	 * 			Caratteri non permessi
	 * @return Stringa letta se corretta, <b>null</b> altrimenti
	 */
	public static String readLine (String msg, int length, char ... notPermitted)
	{
		printLine(msg);
		return readLine(length, notPermitted);
	}
	
	/**
	 * Legge una durata
	 * @param msg Messaggio da stampare prima di effettuare la lettura
	 * @return Durata letta
	 */
	public static Durata readDuration (String msg)
	{
		int ore, minuti, secondi;
		
		printLine(msg);
		
		ore = readInt(MESSAGGIO_ORE, 0);
		minuti = readInt(MESSAGGIO_MINUTI, 0, 59);
		secondi = readInt(MESSAGGIO_SECONDI, 0, 59);
		
		return new Durata(ore, minuti, secondi);
	}
	
	/**
	 * Stampa una durata
	 * @param d Durata da stampare
	 */
	public static void printDuration (Durata d)
	{
		printLine (d.toString());
	}
	
	/**
	 * Legge una data
	 * @return Data letta
	 */
	public static Date readDate ()
	{
		boolean ok = false;
		Date ris = null;
		
		while (!ok)
		{
			String str = readLine();
				
			try
			{
				ris = Utilities.stringToDate(str);
				ok = true;
			}
			catch (ParseException e)
			{
				System.out.println(NOT_VALID_DATE_MESSAGE);
			}
		}
		
		return ris;
	}

	/**
	 * Legge una data con l'ora
	 * @return Data letta
	 */
	public static Date readDateTime ()
	{
		boolean ok = false;
		Date ris = null;
		
		while (!ok)
		{
			String str = readLine();
				
			try
			{
				ris = Utilities.stringToDateTime(str);
				ok = true;
			}
			catch (ParseException e)
			{
				System.out.println(NOT_VALID_DATE_MESSAGE);
			}
		}
		
		return ris;
	}

	
	/**
	 * Pone una domanda a due vie all'utente
	 * @param question
	 * 				Domanda da fare (verrà aggiunto il formato delle risposte)
	 * @return true: risposta positiva; false: risposta negativa
	 */
	public static boolean twoWayQuestion (String question)
	{
		String response;
		do
		{
			response = IOLib.readLine (question+" "+TWO_WAY_QUESTION_RESPONSE_FORMAT);
			
			if (!response.equals (TWO_WAY_QUESTION_YES) || !response.equals(TWO_WAY_QUESTION_NO))
			{
				IOLib.printLine (TWO_WAY_QUESTION_RESPONSE_ERROR);
			}
		}while (!response.equals (TWO_WAY_QUESTION_YES) || !response.equals(TWO_WAY_QUESTION_NO));
		
		if (response.equals (TWO_WAY_QUESTION_YES))
			return true;
		return false;
	}
}
