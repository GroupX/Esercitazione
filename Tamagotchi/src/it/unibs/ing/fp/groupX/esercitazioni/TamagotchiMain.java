/*
 * Autori: Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 * 
 * Classe per l'interfacciamento tra utente e tamagotchi
 * 
 * 
 */

package it.unibs.ing.fp.groupX.esercitazioni;

import it.unibs.ing.fp.groupX.libraries.IOLib;

/**
 * Classe principale del programma
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class TamagotchiMain
{
	private static final String SALUTO = "CIAO! Sono il tuo nuovo Tamagotchi!";
	private static final String CREAZIONE_SAZIETA = "Inserisci il grado di sazietà iniziale: ";
	private static final String CREAZIONE_AFFETTO = "Inserisci il grado di affetto iniziale: ";
	private static final String CREAZIONE_NOME = "Inserisci il nome del Tamagotchi: ";
	
	private static final int SCELTA_CAREZZE = 1;
	private static final int SCELTA_BISCOTTI = 2;
	private static final int SCELTA_ESCI = 3;

	/** 
	 * Metodo principale del programma
	 * @param args Argomenti da linea di comando
	 */
	public static void main(String[] args)
	{
		Tamagotchi tama;
		saluta();

		tama = creaTamagotchi();

		int scelta;
		
		do
		{	
			IOLib.printLine("Scegli cosa fare:");
			
			IOLib.printLine("1 - Dai carezze");
			IOLib.printLine("2 - Dai biscotti");
			IOLib.printLine("3 - Esci dal programma");
			IOLib.printLine("Scelta: ");
			
			//Attende che ci sia la scelta corretta
			scelta = IOLib.readInt();
			while (scelta < 1 || scelta > 3)
			{
				IOLib.printLine("Scelta errata. Deve essere compresa tra 1 e 3! Ritenta: ");
				scelta = IOLib.readInt();
			}
			
			switch(scelta)
			{
				case SCELTA_CAREZZE:
					IOLib.printLine("Quante carezze vuoi dare?"); 
					//Controlla che non vengano date carezze in numero negativo
					int numCarezze = IOLib.readInt();
					while (numCarezze < 0)
					{
						IOLib.printLine("Il numero di carezze deve essere positivo. Ritenta: ");
						numCarezze = IOLib.readInt();
					}
					tama.daiCarezza(numCarezze);
					break;
				case SCELTA_BISCOTTI:
					IOLib.printLine("Quanti biscotti vuoi dare?"); 
					//Controlla che non vengano dati biscotti in numero negativo
					int numBiscotti = IOLib.readInt();
					while (numBiscotti < 0)
					{
						IOLib.printLine("Il numero di biscotti deve essere positivo. Ritenta: ");
						numBiscotti = IOLib.readInt();
					}
					tama.daiBiscotto(numBiscotti);
					break;
			}
			
			
			switch (tama.controllaStato())
			{
				case Tamagotchi.FELICE:
					IOLib.printLine(tama.getNome() + " è felice :D");
					break;
				case Tamagotchi.INFELICE:
					IOLib.printLine(tama.getNome() + " è infelice D:");
					break;
				case Tamagotchi.MORTO:
					IOLib.printLine(tama.getNome() + " è morto DX");
					break;
				case Tamagotchi.MORTO_E_RISORTO:
					IOLib.printLine(tama.getNome() + " è morto DX\n.\n.\n.");
					IOLib.printLine(tama.getNome() + " è risorto dai morti, come riportato dalle Sacre Scritture! Lodatelo ed esultate.");
					break;
			}
			
			//IOLib.printLine("Affetto: " + tama.getAffetto() + "   Sazietà: " + tama.getSazieta());
		} while ((tama.controllaStato() != Tamagotchi.MORTO || tama.getNome().equals("Gesù")) && scelta!=SCELTA_ESCI);
		
		IOLib.printLine("Ciaoo");
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
