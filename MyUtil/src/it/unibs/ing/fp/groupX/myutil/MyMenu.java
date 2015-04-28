package it.unibs.ing.fp.groupX.myutil;

import java.util.ArrayList;
import it.unibs.ing.fp.groupX.myutil.IOLib;

/**
 * Classe generale di gestione menù
 * Gli indici delle voci partono da 1 in quanto la voce di uscita è sempre con indice 0
 * 
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class MyMenu
{
	/** Titolo del menù */
	private String titolo;
	/** Array dinamico delle voci del menù */
	private ArrayList<String> voices;
	
	/** Voce per l'uscita */
	private final static String EXIT_VOICE = "0 - Esci";
	/** Valore della voce di uscita */
	public final static int EXIT_VALUE = 0;
	/** Messaggio di scelta della voce */
	private final static String CHOICE_MESSAGE = "Scegli una voce del menu':";
	/** Messaggio di errore per la scelta di voce */
	private final static String ERROR_SELECTION_VOICE = "Voce selezionata inesistente.";
	
	/**
	 * Costruttore generico che inizializza l'elenco delle voci come vuoto
	 * @param titolo
	 * 			Titolo del menù
	 */
	public MyMenu (String titolo)
	{
		this.titolo = titolo;
		voices = new ArrayList<String>();
	}
	
	/**
	 * Costruttore che inizializza l'elenco delle voci da un array dinamico
	 * @param titolo
	 * 			Titolo del menù
	 * @param voices 
	 * 			Elenco delle voci
	 */
	public MyMenu (String titolo, ArrayList<String> voices)
	{
		this.titolo = titolo;
		this.voices = voices;
	}
	
	/**
	 * Costruttore che inizializza l'elenco delle voci da una serie di voci
	 * @param titolo
	 * 			Titolo del menù
	 * @param voice 
	 * 			Elenco delle voci
	 */
	public MyMenu (String titolo, String ... voice)
	{
		this(titolo);
		for(String s : voice)
		{
			addVoice(s);
		}
	}
	
	/**
	 * Aggiunge una voce al menù
	 * @param voice Voce da aggiungere
	 */
	public void addVoice (String voice)
	{
		voices.add(voice);
	}
	
	/**
	 * Stampa a video titolo e voci del menù
	 */
	private void print ()
	{
		IOLib.printLine (titolo);
		for (int i = 0; i < voices.size (); i++)
		{
			IOLib.printLine ((i+1) + " - " + voices.get (i));
		}
		IOLib.printLine (EXIT_VOICE);
	}
	
	/**
	 * Stampa il menù e gestisce la scelta della voce
	 * @return scelta dell'utente della voce
	 */
	public int getChoice ()
	{
		int choice;
		do
		{
			print();
			choice = IOLib.readInt (CHOICE_MESSAGE);
			
			if ( choice < EXIT_VALUE || choice > voices.size() ) 
			{
				IOLib.printLine(ERROR_SELECTION_VOICE);
			}
			
		}while ( choice < EXIT_VALUE || choice > voices.size() );
		
		return choice;
	}
	
}
