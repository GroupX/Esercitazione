package it.unibs.ing.fp.groupX.myutil;

import java.util.Scanner;

/**
 * Classe generale di gestione Input / Output
 * 
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class IOLib
{
	/** Numero inserito in lettura non valido */
	private static final String LETTURA_NUMERO_NON_VALIDO = "Numero inserito non valido. Riprovare:";

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
		scnr.close();
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
		scnr.close();
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
		
		scnr.close();
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
		}while (num < upperBound || num > upperBound);
		
		scnr.close();
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
		scnr.close();
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
		scnr.close();
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
		
		scnr.close();
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
		
		scnr.close();
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
		scnr.close();
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
		scnr.close();
		return line;
	}
	
}
