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
	private static final String CREAZIONE_NOME = "Inserisci il nome del Tamagotchi";

	public static void main(String[] args)
	{
		Tamagotchi tama;
		saluta();

		tama = creaTamagotchi();

	}

	private static void saluta()
	{
		IOLib.printLine(SALUTO);
	}

	private static Tamagotchi creaTamagotchi()
	{
		double gradoSazieta, gradoAffetto;
		String nome;

		IOLib.printLine(CREAZIONE_NOME);
		nome = IOLib.readLine();

		IOLib.printLine(CREAZIONE_SAZIETA);
		gradoSazieta = IOLib.readDouble();

		IOLib.printLine(CREAZIONE_AFFETTO);
		gradoAffetto = IOLib.readDouble();

		return new Tamagotchi(nome, gradoSazieta, gradoAffetto);
	}
}
