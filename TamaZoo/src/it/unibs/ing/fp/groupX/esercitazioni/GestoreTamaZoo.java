package it.unibs.ing.fp.groupX.esercitazioni;

import it.unibs.ing.fp.groupX.myutil.EstrattoreCasuale;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;


public class GestoreTamaZoo 
{

	private final static String MSG_BENVENUTO = "BENVENUTO NELLA GESTIONE DEI TAMAGOTCHI";
	private final static String MSG_SALUTI = "TORNA PRESTO NEL MONDO DEI TAMAGOTCHI";
	private final static String MSG_ESTINTI = "PURTROPPO NON CI SONO TAMAGOTCHI SOPRAVVISSUTI - IL PROGRAMMA TERMINA";

	private final static String MSG_NO_OP = "Operazione non riconosciuta.";
	
	private final static String RICHIESTA_NUMERO = "QUANTI TAMAGOTCHI VUOI CREARE?";
	private final static String PREMESSA_INSERIMENTO = "INSERIMENTO DEL NOME DEL TAMAGOCTHI NUMERO ";
	
	private final static String RICHIESTA_NOME = "Inserisci il nome del tuo Tamagotchi:";
	
	
	private final static String MSG_BISCOTTI = "Verranno somministrati %d biscotti a ciascun Tamagotchi%n%n";
	private final static String MSG_CAREZZE = "Verranno somministrate %d carezze a ciascun Tamagotchi%n%n";
	
	private final static int NUMERO_SPECIE = 3;
	private final static int MODELLO_BASE = 1;
	private final static int TAMATRISTE = 2;
	private final static int TAMAGORDO = 3;
	
	private final static String NOME_BASE="modello base";
	private final static String NOME_TRISTE="lagnoso";
	private final static String NOME_GORDO="ingordo";
	
	
	private final static String [] MAIN_MENU_ITEMS = {"Dai biscotti","Dai carezze"};
	private final static String MAIN_QUESTION = "Scegli l'operazione da eseguire";
	
	private final static int MIN_BISCOTTI = 1;
	private final static int MAX_BISCOTTI = 8;
	
	private final static int MIN_CAREZZE = 1;
	private final static int MAX_CAREZZE = 10;
	
	
	private static TamaZoo mioZoo = new TamaZoo();
	
	private static void benvenuto()
    {
	 System.out.println(MSG_BENVENUTO);
	 System.out.println();
	}
	
	private static void saluti()
    {
	 System.out.println(MSG_SALUTI);
	 System.out.println();
	}
	
	public static void main(String[] args) 
	{
		benvenuto();
		int numeroTamagotchi = IOLib.readInt(RICHIESTA_NUMERO, 0);
		
		for (int i =1; i<=numeroTamagotchi; i++)
		{
			System.out.println(PREMESSA_INSERIMENTO + i);
			Tamagotchi nuovo = creaTamagotchi();
			mioZoo.inserisci(nuovo);
		}
		
		MyMenu principale = new MyMenu(MAIN_QUESTION, MAIN_MENU_ITEMS);
		
        boolean fine = false;
		
		do 
		{
		 int voceSelezionata = principale.getChoice();
			
	     switch ( voceSelezionata ) 
	      {
			   case 1:
				   int numBiscotti = EstrattoreCasuale.estraiInt(MIN_BISCOTTI, MAX_BISCOTTI);
				   System.out.printf(MSG_BISCOTTI,numBiscotti);
				   mioZoo.daiBiscotti(numBiscotti);
				 break;
			   case 2:
				   int numCarezze = EstrattoreCasuale.estraiInt(MIN_CAREZZE, MAX_CAREZZE);
				   System.out.printf(MSG_CAREZZE,numCarezze);
				   mioZoo.daiCarezze(numCarezze);
				 break;
			    case 0:
				   fine = true;
				   saluti();
				 break;
			    default:
				   System.out.println(MSG_NO_OP);
				 break;
			}//switch
		 
	     
	     if (! mioZoo.ciSonoVivi())
	     {
	    	 fine = true;
	    	 System.out.println(MSG_ESTINTI);
	     }
	     
		} while ( !fine );
		 
		

	}

	public static Tamagotchi creaTamagotchi()
	{
		String nome = IOLib.readLine(RICHIESTA_NOME);
		int specie = EstrattoreCasuale.estraiInt(1, NUMERO_SPECIE);
		Tamagotchi nuovo=null;
		int affetto,sazieta;
		
		switch (specie)
		{
		 case MODELLO_BASE:
			 affetto = EstrattoreCasuale.estraiInt(0,Tamagotchi.MAX_AFFETTO);
			 sazieta = EstrattoreCasuale.estraiInt(0,Tamagotchi.MAX_SAZIETA);
			 nuovo = new Tamagotchi(nome,affetto,sazieta,NOME_BASE);
		 break;
		 case TAMATRISTE:
			 sazieta = EstrattoreCasuale.estraiInt(0,Tamagotchi.MAX_SAZIETA);
			 nuovo = new TamaTriste(nome,sazieta,NOME_TRISTE);
		break;
		 case TAMAGORDO:
	    	 sazieta = EstrattoreCasuale.estraiInt(0,Tamagotchi.MAX_SAZIETA);
	    	 nuovo = new TamaGordo(nome,sazieta,NOME_GORDO);
	    	 break;	 
		}
		return nuovo;
	}
	
}
