/*
 * Autori: Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 * 
 * Classe per l'interfacciamento tra utente e tamagotchi
 * 
 * 
 */

package it.unibs.ing.fp.groupX.esercitazioni;

import it.unibs.ing.fp.groupX.libraries.IOLib;

public class TamagotchiMain
{
	private static final String SALUTO = "CIAU! Sono il tuo nuovo Tamagotchi! Divertiamoci insieme!";
	private static final String CREAZIONE_SAZIETA = "Inserisci il grado di sazieta' iniziale: ";
	private static final String CREAZIONE_AFFETTO = "Inserisci il grado di affetto iniziale";
	
	public static void main ( String[] args )
	{
		Tamagotchi tama;
		saluta();
		
		tama = creaTamagotchi();
		
		
	}
	
	private static void saluta ()
	{
		IOLib.printLine ( SALUTO );
	}
	
	private static Tamagotchi creaTamagotchi ()
	{
		double gradoSazieta, gradoAffetto;
		
		IOLib.printLine ( CREAZIONE_SAZIETA );
		gradoSazieta = IOLib.readDouble ();
		
		IOLib.printLine ( CREAZIONE_AFFETTO );
		gradoAffetto = IOLib.readDouble ();
		
		return new Tamagotchi(gradoSazieta, gradoAffetto);
	}
}
