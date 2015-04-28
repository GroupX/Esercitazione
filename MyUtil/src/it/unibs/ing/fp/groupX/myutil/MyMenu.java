package it.unibs.ing.fp.groupX.myutil;

import java.util.ArrayList;

/**
 * Classe generale di gestione men�
 * 
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class MyMenu
{
	/** Titolo del men� */
	private String titolo;
	/** Array dinamico delle voci del men� */
	private ArrayList<String> voices;
	
	/**
	 * Costruttore generico che inizializza l'elenco delle voci come vuoto
	 * @param titolo
	 * 			Titolo del men�
	 */
	public MyMenu (String titolo)
	{
		this.titolo = titolo;
		voices = new ArrayList<String>();
	}
	
	/**
	 * Costruttore che inizializza l'elenco delle voci da un array dinamico
	 * @param titolo
	 * 			Titolo del men�
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
	 * 			Titolo del men�
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
	 * Aggiunge una voce al men�
	 * @param voice Voce da aggiungere
	 */
	public void addVoice (String voice)
	{
		voices.add(voice);
	}
	
}
