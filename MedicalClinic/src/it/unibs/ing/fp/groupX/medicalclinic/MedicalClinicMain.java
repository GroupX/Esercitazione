package it.unibs.ing.fp.groupX.medicalclinic;

import java.io.FileNotFoundException;
import java.io.IOException;

import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathologies;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;

public class MedicalClinicMain
{
	/** Messaggio di avvenuto salvataggio */
	private static final String SAVE_SUCCESS_MESSAGGE = "Dati salvati con successo.";
	/** Titolo menu */
	private static final String TITLE_MENU = "Menu principale";
	/** Descrizione della voce delle patologie */
	private static final String PATHOLOGIES_VOICE = "Gestisci le patologie";
	/** Valore della voce delle patologie */
	private static final int PATHOLOGIES_VOICE_VALUE = 1;
	/** Descrizione della voce della clinica */
	private static final String CLINIC_VOICE = "Gestisci la clinica";
	/** Valore della voce della clinica */
	private static final int CLINIC_VOICE_VALUE = 2;
	/** Descrizione della voce per salvare tutto */
	private static final String SAVE_ALL_VOICE = "Salva tutto";
	/** Valore della voce per salvare tutto */
	private static final int SAVE_ALL_VOICE_VALUE = 3;
	
	public static void main(String[] args)
	{
		Clinic c;
		
		//Precaricamento dei dati su file
		try {
			DataManager.loadPathologies();
			c = DataManager.loadClinic();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			c = new Clinic();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			c = new Clinic();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			c = new Clinic();
		}
		
		//Inizio programma
		MyMenu menu = new  MyMenu(TITLE_MENU, true, PATHOLOGIES_VOICE, CLINIC_VOICE, SAVE_ALL_VOICE);
		
		int scelta;
		
		while ( (scelta = menu.getChoice()) != MyMenu.EXIT_VALUE )
		{
			switch(scelta)
			{
				case PATHOLOGIES_VOICE_VALUE:
					
					Pathologies.get().use();
					
					break;
				
				case CLINIC_VOICE_VALUE:
					
					c.use();
					
					break;
				
				case SAVE_ALL_VOICE_VALUE:
					
					try {
						DataManager.savePathologies();
						DataManager.saveClinic(c);
						
						IOLib.printLine(SAVE_SUCCESS_MESSAGGE);
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
								
					break;
			}
		}
	
		//Salvo tutto prima di uscire
		try {
			DataManager.savePathologies();
			DataManager.saveClinic(c);
			
			IOLib.printLine(SAVE_SUCCESS_MESSAGGE);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
