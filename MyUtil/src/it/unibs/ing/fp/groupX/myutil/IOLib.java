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
	 * Legge da tastiera un numero intero stampado un messaggio
	 * 
	 * @param msg
	 * 			
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
	 * Legga da tastiera un numero double
	 * 
	 * @return Numero letto
	 */
	public static double readDouble ()
	{
		Scanner scnr = new Scanner (System.in);
		return scnr.nextDouble ();
	}

	/**
	 * Legge da tastiera una stringa (si ferma a \n)
	 * 
	 * @return Stringa letta
	 */
	public static String readLine ()
	{
		Scanner scnr = new Scanner (System.in);
		return scnr.nextLine ();
	}

}
