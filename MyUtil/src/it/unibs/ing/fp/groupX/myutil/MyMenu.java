package it.unibs.ing.fp.groupX.myutil;

import java.util.ArrayList;

/**
 * Classe generale di gestione menù
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
	
}
