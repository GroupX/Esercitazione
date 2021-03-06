package it.unibs.ing.fp.groupX.myutil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Time;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Collection;
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
	private static final String ONLY_ROUNDED_TIME_MSG = "Validi solo orari arrotondati di 30 min";
	private static final String INSERT_INDEX_MSG = "Inserisci l'indice: ";
	private static final String LINE_SEPARATOR = "___________________________________________";
	private static final String NOT_VALID_DATE_MESSAGE = "Data non valida. Reinserire";
	private static final String NOT_VALID_TIME_MESSAGE = "Ora non valida. Reinserire";
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
	 * Legge da tastiera un numero intero stampado un messaggio e controllando se � maggiore o uguale di un valore
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
	 * Legge da tastiera un numero intero stampado un messaggio e controllando se � in un range di valori, estremi inclusi
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
	 * Legge da tastiera un numero double stampado un messaggio e controllando se � maggiore o uguale di un valore
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
	 * Legge da tastiera un numero double stampado un messaggio e controllando se � in un range di valori, estremi inclusi
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
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(ris);
				int min = calendar.get(Calendar.MINUTE);
				int sec = calendar.get(Calendar.SECOND);
				
				if (sec == 0 && min % 30 == 0)
					ok = true;
				else
					IOLib.printLine(ONLY_ROUNDED_TIME_MSG);
			}
			catch (ParseException e)
			{
				System.out.println(NOT_VALID_DATE_MESSAGE);
			}
		}
		
		return ris;
	}
	
	/**
	 * Legge una data con solo l'orario
	 * @return Data letta
	 */
	public static Date readTimeInDate ()
	{
		boolean ok = false;
		Date ris = null;
		
		while (!ok)
		{
			String str = readLine();
				
			try
			{
				ris = Utilities.stringToTimeInDate(str);
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(ris);
				int min = calendar.get(Calendar.MINUTE);
				int sec = calendar.get(Calendar.SECOND);
				
				if (sec == 0 && min % 30 == 0)
					ok = true;
				else
					IOLib.printLine(ONLY_ROUNDED_TIME_MSG);
			}
			catch (ParseException e)
			{
				System.out.println(NOT_VALID_DATE_MESSAGE);
			}
		}
		
		return ris;
	}
	
	/**
	 * Legge un orario
	 * @return Ora letta
	 */
	public static Date readTime ()
	{
		boolean ok = false;
		Date ris = null;
		
		while (!ok)
		{
			String str = readLine();
				
			try
			{
				ris = Utilities.stringToTimeInDate(str);
				
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(ris);
				int min = calendar.get(Calendar.MINUTE);
				int sec = calendar.get(Calendar.SECOND);
				
				if (sec == 0 && min % 30 == 0)
					ok = true;
				else
					IOLib.printLine(ONLY_ROUNDED_TIME_MSG);
			}
			catch (ParseException e)
			{
				System.out.println(NOT_VALID_TIME_MESSAGE);
			}
		}
		
		return ris;
	}
	
	/**
	 * Pone una domanda a due vie all'utente
	 * @param question
	 * 				Domanda da fare (verr� aggiunto il formato delle risposte)
	 * @return true: risposta positiva; false: risposta negativa
	 */
	public static boolean twoWayQuestion (String question)
	{
		String response;
		do
		{
			response = IOLib.readLine (question+" "+TWO_WAY_QUESTION_RESPONSE_FORMAT);
			
			if (!response.equals (TWO_WAY_QUESTION_YES) && !response.equals(TWO_WAY_QUESTION_NO))
			{
				IOLib.printLine (TWO_WAY_QUESTION_RESPONSE_ERROR);
			}
		}while (!response.equals (TWO_WAY_QUESTION_YES) && !response.equals(TWO_WAY_QUESTION_NO));
		
		if (response.equals (TWO_WAY_QUESTION_YES))
			return true;
		return false;
	}
	
	/**
	 * Ritorna la dimensione di un iterable
	 * @param collection Collezione
	 * @return Dimensione
	 */
	public static <E> int getIterableSize (Iterable<E> collection)
	{
		int i = 1;
		for(E obj : collection)
		{
			i++;
		}
		return i - 1;
	}
	
	/**
	 * Stampa a video una collection
	 * @param collection Collection da stampare
	 */
	public static <E> void printIterable (Iterable<E> collection)
	{
		int i = 1;
		for(E obj : collection)
		{
			IOLib.printLine(Integer.toString(i) + ".\n" + obj.toString() + "\n" + LINE_SEPARATOR + "\n");
			i++;
		}
	}
	
	/**
	 * Richiede un elemento di una collection all'utente e poi ritorna l'elemento scelto
	 * @param collection Collection in cui scegliere
	 * @return Elemento scelto
	 */
	public static <E> E getIterableElement (Iterable<E> collection)
	{
		int size = getIterableSize(collection);
		
		if (size == 1)
			return collection.iterator().next();
		
		printIterable (collection);
		
		int choice;
		
		do
		{
			choice = IOLib.readInt(INSERT_INDEX_MSG);
		}
		while (choice <= 0 || choice > size);
		
		int i = 1;
		
		for(E obj : collection)
		{
			if (i == choice)
				return obj;
			i++;
		}
		
		return null;
	}
	
	/**
	 * Legge un oggetto (il primo) dal file passato
	 * @param f file da dove leggere
	 * @return l'oggetto letto
	 * @throws FileNotFoundException file non trovato
	 * @throws IOException errore di input/output
	 * @throws ClassNotFoundException errore nella lettura dell'oggetto
	 */
	public static <E> E readObjectFromFile (File f) throws FileNotFoundException, IOException, ClassNotFoundException
	{
		E obj;
		
		ObjectInputStream sorgente = new ObjectInputStream(
				new BufferedInputStream(
				new FileInputStream(f)));
		
		obj = (E)sorgente.readObject();
		
		sorgente.close();
		
		return obj;
	}
	
	/**
	 * Scrive un oggetto generico sul file passato
	 * @param f
	 * 			file dove scrivere
	 * @param obj
	 * 			oggetto da scrivere
	 * @throws FileNotFoundException file non trovato
	 * @throws IOException errore di input/output
	 */
	public static <E> void writeObjectOnFile (File f, E obj) throws FileNotFoundException, IOException
	{
		ObjectOutputStream archivio = new ObjectOutputStream(
				new BufferedOutputStream(
				new FileOutputStream(f)));

		archivio.writeObject(obj);
				
		archivio.close();
	}
}
