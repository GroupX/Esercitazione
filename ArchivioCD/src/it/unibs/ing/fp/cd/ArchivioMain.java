
package it.unibs.ing.fp.cd;

import java.util.Vector;

import it.unibs.ing.fp.groupX.myutil.*;

public class ArchivioMain
{
	private final static String TITOLO = "Benvenuto nell'archivio CD!\n\nSeleziona cosa vuoi fare: ";
	private final static String [] VOCI = {"Inserisci un nuovo CD", "Visualizza un CD casuale", "Rimuovi un CD", "Visualizza la tua collezione di CD", "Seleziona un brano casuale", "Seleziona un numero di brani casuali", "Cerca un CD per titolo", "Cerca un CD per autore", "Cerca un CD per titolo di un brano"};
	
	private final static String ARCHIVIO_CD_TITOLO = "Archivio CD";
	
	private final static int INSERISCI_CD_VALUE = 1;
	private final static int VISUALIZZA_CD_CASUALE_VALUE = 2;
	private final static int RIMUOVI_CD_VALUE = 3;
	private final static int VISUALIZZA_COLLEZIONE_VALUE = 4;
	private final static int SELEZIONA_BRANO_CASUALE_VALUE = 5;
	private final static int SELEZIONA_ALCUNI_BRANI_CASUALI_VALUE = 6;
	private final static int CERCA_CD_TITOLO_VALUE = 7;
	private final static int CERCA_CD_AUTORE_VALUE = 8;
	private final static int CERCA_CD_TITOLO_BRANO_VALUE = 9;
	
	private final static String TITOLO_CD = "Inserisci il titolo del CD che vuoi inserire";
	private final static String AUTORE_CD = "Inserisci l'autore del CD che vuoi inserire";
	private final static String NUMERO_BRANI_CD = "Inserisci il numero di brani del CD";
	private final static String TITOLO_BRANO = "Inserisci il titolo del brano";
	private final static String DURATA_BRANO = "Inserisci la durata del brano";
	private static final String CERCA_CD_AUTORE = "Inserisci l'autore da cercare nella collezione";
	private static final String CERCA_CD_TITOLO_BRANO = "Inserisci il titolo del brano da cercare nei CDs";
	
	private final static String CD_DA_VISUALIZZARE = "Quale CD vuoi visualizzare?";
	private final static String CD_DA_RIMUOVERE = "Quale CD vuoi rimuovere?";
	private final static String CONGRATULAZIONI = "Perfetto! CD rimosso senza errori";
	private final static String BRANI_A_CASO = "Quanti brani vuoi scegliere casualmente?";
	
	private static final String CD_GIA_ESISTENTE = "CD già esistente";
	
	private final static String ERRORE_1 = "Non c'è nessun CD da visualizzare!";
	private final static String ERRORE_2 = "Non c'è nessun CD da rimuovere!";
	private static final String ERRORE_3 = "Nessun CD trovato di questo autore!";
	private static final String ERRORE_4 = "Nessun CD trovato cercando il brano indicato!";
	
	public static void main (String[] args)
	{
		MyMenu menu = new MyMenu (TITOLO, VOCI);
		ArchivioCd archivio = new ArchivioCd (ARCHIVIO_CD_TITOLO);
		
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
				
				Cd disk = new Cd(CDtitle, CDauthor);
				
				boolean ris = archivio.aggiungiCd(disk);
				
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
						
						disk.aggiungiBrano(titoloBrano, d);
					}
				}
				else
				{
					IOLib.printLine(CD_GIA_ESISTENTE);
				}
				
				
				
				break;
				
			case VISUALIZZA_CD_CASUALE_VALUE:
				
				Cd cdCasuale;
				cdCasuale = archivio.getCDRandomly ();
				
				IOLib.printLine (cdCasuale.toString ());
				
				break;
				
			case RIMUOVI_CD_VALUE:
				
				String cdRimosso;
				cdRimosso = IOLib.readLine(CD_DA_RIMUOVERE);
				
				boolean risultato;
				risultato = archivio.eliminaCd(cdRimosso);
				
				if (risultato == true)
				{
					IOLib.printLine(CONGRATULAZIONI);
				} else IOLib.printLine(ERRORE_2);
									
				break;
				
			case VISUALIZZA_COLLEZIONE_VALUE:
				
				archivio.print();
				
				break;
				
			case SELEZIONA_BRANO_CASUALE_VALUE:
				
				Brano branoCasuale = archivio.getCDRandomly ().branoCasuale ();
				
				IOLib.printLine (branoCasuale.toString ());
				
				break;
			
			case SELEZIONA_ALCUNI_BRANI_CASUALI_VALUE:
				
				int braniCasuali;
				braniCasuali = IOLib.readInt(BRANI_A_CASO);
				
				Brano [] braniScelti;
				braniScelti = archivio.getSomeBrano(braniCasuali); 
				
				for (Brano b: braniScelti)
				{
					IOLib.printLine(b.toString());
				}
				
				break;
			
			case CERCA_CD_TITOLO_VALUE:
				
				String cdScelto;
				cdScelto = IOLib.readLine(CD_DA_VISUALIZZARE);
				
				boolean risultatoStampa;
				risultatoStampa = archivio.print(cdScelto);
				
				if (risultatoStampa == false)
				{
					IOLib.printLine(ERRORE_1);
				}
				
				break;
			
			case CERCA_CD_AUTORE_VALUE:
				
				String autore;
				autore = IOLib.readLine(CERCA_CD_AUTORE);
				
				Vector<Integer> indiciCdAutore;
				indiciCdAutore = archivio.searchAuthorCD (autore);
				
				if (indiciCdAutore.isEmpty ())
				{
					IOLib.printLine (ERRORE_3);
				}
				else
				{
					for (int i = 0; i < indiciCdAutore.size (); i++)
					{
						archivio.print (indiciCdAutore.get (i));
					}
				}
				
				break;
				
			case CERCA_CD_TITOLO_BRANO_VALUE:
				
				String titoloBrano;
				titoloBrano = IOLib.readLine(CERCA_CD_TITOLO_BRANO);
				
				Vector<Integer> indiciCdBrano;
				indiciCdBrano = archivio.searchBranoCD (titoloBrano);
				
				if (indiciCdBrano.isEmpty ())
				{
					IOLib.printLine (ERRORE_4);
				}
				else
				{
					for (int i = 0; i < indiciCdBrano.size (); i++)
					{
						archivio.print (indiciCdBrano.get (i));
					}
				}
				
				break;
				
			}
		} while (scelta != MyMenu.EXIT_VALUE);
		
	}

}