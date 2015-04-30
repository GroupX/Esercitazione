package it.unibs.ing.fp.groupX.myutil;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

/**
 * Classe generale di gestione Input / Output
 * 
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class IOLib
{
	/** Separatore tra ore, minuti e secondi */
	private static final String DURATION_SEPARATOR = ":";
	
	/** Messaggio stampato per richiedere i secondi */
	private static final String MESSAGGIO_SECONDI = "Secondi: ";
	/** Messaggio stampato per richiedere i minuti */
	private static final String MESSAGGIO_MINUTI = "Minuti: ";
	/** Messaggio stampato per richiedere le ore */
	private static final String MESSAGGIO_ORE = "Ore: ";

	/** Numero inserito in lettura non valido */
	private static final String LETTURA_NUMERO_NON_VALIDO = "Numero inserito non valido. Riprovare:";
	
	/** Secondi in un'ora */
	private static final int SECONDI_PER_ORA = 3600;
	/** Secondi in un minuto */
	private static final int SECONDI_PER_MINUTO = 60;
	/** Minuti in un ora */
	private static final int MINUTI_PER_ORA = 60;

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
		String line = scnr.nextLine();
		//scnr.close();
		return line;
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
		Scanner scnr = new Scanner (System.in);
		String line = scnr.nextLine();
		//scnr.close();
		return line;
	}
	
	/**
	 * Legge una durata
	 * @param msg Messaggio da stampare prima di effettuare la lettura
	 * @return Durata letta
	 */
	public static Duration readDuration (String msg)
	{
		int ore, minuti, secondi;
		
		printLine(msg);
		
		ore = readInt(MESSAGGIO_ORE, 0);
		minuti = readInt(MESSAGGIO_MINUTI, 0, 59);
		secondi = readInt(MESSAGGIO_SECONDI, 0, 59);
		
		return Duration.of(ore * SECONDI_PER_ORA + minuti * SECONDI_PER_MINUTO + secondi, ChronoUnit.SECONDS);
	}
	
	/**
	 * Stampa una durata
	 * @param d Durata da stampare
	 */
	public static void printDuration (Duration d)
	{
		long hours = d.toHours();
		long minutes = d.toMinutes() - hours * MINUTI_PER_ORA;
		long seconds = d.getSeconds() - hours * SECONDI_PER_ORA - minutes * SECONDI_PER_MINUTO;
		printLine (hours + DURATION_SEPARATOR + minutes + DURATION_SEPARATOR + seconds);
	}
}
