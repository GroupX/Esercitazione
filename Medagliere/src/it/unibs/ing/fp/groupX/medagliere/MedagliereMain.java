package it.unibs.ing.fp.groupX.medagliere;

import it.unibs.ing.fp.groupX.myutil.MyMenu;

public class MedagliereMain
{
	private static final int VISUALIZZA_TUTTO_INDEX = 4;
	private static final int INSERISCI_RISULTATO_INDEX = 3;
	private static final int INSERISCI_GARA_INDEX = 2;
	private static final int INSERISCI_NAZIONE_INDEX = 1;
	
	private static final String VISUALIZZA_TUTTO = "Visualizza tutto";
	private static final String INSERISCI_RISULTATO = "Inserisci risultato";
	private static final String INSERISCI_GARA = "Inserisci gara";
	private static final String INSERISCI_NAZIONE = "Inserisci nazione";
	
	private static final String MENU_TITOLO = "Menu";

	public static void main(String[] args)
	{
		MyMenu m = new MyMenu(MENU_TITOLO, INSERISCI_NAZIONE, INSERISCI_GARA, INSERISCI_RISULTATO, VISUALIZZA_TUTTO);
		
		int scelta;
		
		do
		{
			scelta = m.getChoice();
			
			switch (scelta)
			{
				case INSERISCI_NAZIONE_INDEX:
					
					break;
				
				case INSERISCI_GARA_INDEX:
					
					break;
					
				case INSERISCI_RISULTATO_INDEX:
					
					break;
					
				case VISUALIZZA_TUTTO_INDEX:
					
					break;					
			}
		}while (scelta != MyMenu.EXIT_VALUE);
	}
	
}
