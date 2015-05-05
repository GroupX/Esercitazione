
package it.unibs.ing.fp.groupX.esercitazioni;

import it.unibs.ing.fp.groupX.myutil.*;

public class ArchivioMain
{
	private static final String CD_GIA_ESISTENTE = "CD già esistente";
	private final static String TITOLO = "Benvenuto nell'archivio CD!\n\nSeleziona cosa vuoi fare: ";
	private final static String [] VOCI = {"Inserisci un nuovo CD", "Visualizza un CD", "Rimuovi un CD", "Visualizza la tua collezione di CD", "Seleziona un brano casuale"};
	
	private final static String ARCHIVIO_CD_TITOLO = "Archivio CD";
	
	private final static int INSERISCI_CD_VALUE = 1;
	private final static int VISUALIZZA_CD_VALUE = 2;
	private final static int RIMUOVI_CD_VALUE = 3;
	private final static int VISUALIZZA_COLLEZIONE_VALUE = 4;
	private final static int SELEZIONA_BRANO_CASUALE_VALUE = 5;
	
	private final static String TITOLO_CD = "Inserisci il titolo del CD che vuoi inserire";
	private final static String AUTORE_CD = "Inserisci l'autore del CD che vuoi inserire";
	private final static String NUMERO_BRANI_CD = "Inserisci il numero di brani del CD";
	private final static String TITOLO_BRANO = "Inserisci il titolo del brano";
	private final static String DURATA_BRANO = "Inserisci la durata del brano";
	
	private final static String CD_DA_VISUALIZZARE = "Quale CD vuoi visualizzare?";
	private final static String CD_DA_RIMUOVERE = "Quale CD vuoi rimuovere?";
	private final static String CONGRATULAZIONI = "Perfetto! CD rimosso senza errori";
	private final static String BRANI_A_CASO = "Quanti brani vuoi scegliere casualmente?";
	
	private final static String ERRORE_1 = "Non c'è nessun CD da visualizzare!";
	private final static String ERRORE_2 = "Non c'è nessun CD da rimuovere!";
	
	public static void main (String[] args)
	{
		MyMenu menu = new MyMenu (TITOLO, VOCI);
		ArchivioCD archivio = new ArchivioCD (ARCHIVIO_CD_TITOLO);
		
		int scelta;
		
		do
		{
			scelta = menu.getChoice();
		
			switch (scelta)
			{
			case INSERISCI_CD_VALUE:
				
				String CDtitle;
				CDtitle = IOLib.readLine(TITOLO_CD);
				
				String CDauthor;
				CDauthor = IOLib.readLine(AUTORE_CD);
				
				CD disk = new CD(CDtitle, CDauthor);
				
				boolean ris = archivio.addCD(disk);
				
				if(ris)
				{
					int n;
					n = IOLib.readInt(NUMERO_BRANI_CD);
					
					for (int i = 0; i < n; i++)
					{
						String titoloBrano;
						titoloBrano = IOLib.readLine(TITOLO_BRANO);
						
						Durata d;
						d = IOLib.readDuration(DURATA_BRANO);
						
						disk.addBrano(titoloBrano, d);
					}
				}
				else
				{
					IOLib.printLine(CD_GIA_ESISTENTE);
				}
				
				
				
				break;
				
			case VISUALIZZA_CD_VALUE:
				
				String cdScelto;
				cdScelto = IOLib.readLine(CD_DA_VISUALIZZARE);
				
				boolean risultatoStampa;
				risultatoStampa = archivio.print(cdScelto);
				
				if (risultatoStampa == false)
				{
					IOLib.printLine(ERRORE_1);
				}
				
				break;
				
			case RIMUOVI_CD_VALUE:
				
				String cdRimosso;
				cdRimosso = IOLib.readLine(CD_DA_RIMUOVERE);
				
				boolean risultato;
				risultato = archivio.removeCD(cdRimosso);
				
				if (risultato == true)
				{
					IOLib.printLine(CONGRATULAZIONI);
				} else IOLib.printLine(ERRORE_2);
									
				break;
				
			case VISUALIZZA_COLLEZIONE_VALUE:
				
				archivio.print();
				
				break;
				
			case SELEZIONA_BRANO_CASUALE_VALUE:
				
				int braniCasuali;
				braniCasuali = IOLib.readInt(BRANI_A_CASO);
				
				Brano [] braniScelti;
				braniScelti = archivio.getSomeBrano(braniCasuali); 
				
				for (Brano b: braniScelti)
				{
					IOLib.printLine(b.toString());
				}
				
				break;
			}
		} while (scelta != MyMenu.EXIT_VALUE);
		
	}

}