package it.unibs.ing.fp.groupX.medicalclinic.people;

import it.unibs.ing.fp.groupX.medicalclinic.ClinicFolder;
import it.unibs.ing.fp.groupX.myutil.*;
import it.unibs.ing.fp.groupX.myutil.Readable;

import java.util.Date;

/**
 * Classe che implementa un paziente
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Patient extends Person implements Useable, Readable
{
	/** Cartella clinica */
	private ClinicFolder fol;
	
	/**
	 * Metodo factory che crea un paziente leggendolo da console 
	 * @return
	 */
	public static Patient readFromConsole ()
	{
		Patient ris = new Patient();
		
		ris.read();
		
		return ris;
	}
	
	/**
	 * Costruttore vuoto per read
	 */
	protected Patient()
	{
		
	}
	
	/**
	 * Costruttore che inizializza gli attributi
	 * @param name
	 * 			Nome
	 * @param surname
	 * 			Cognome
	 * @param birth
	 * 			Data di nascita
	 * @param birthPlace
	 * 			Luogo di nascita
	 * @param gen
	 * 			Genere
	 * @param num
	 * 			Numero di telefono
	 * @param cod
	 * 			Codice fiscale
	 * @param fol
	 * 			Cartella clinica
	 */
	public Patient (String name, String surname, Date birth, String birthPlace, Gender gen, NumeroTelefonico num, CodiceFiscale cod, ClinicFolder fol)
	{
		super(name, surname, birth, birthPlace, gen, num, cod);
		
		this.fol = new ClinicFolder(fol);
	}
	
	/**
	 * Costruttore che inizializza da una Person
	 * @param p
	 * 			Persona 
	 * @param fol
	 * 			Cartella clinica
	 */
	public Patient (Person p, ClinicFolder fol)
	{
		this(p.getName(), p.getSurname(), p.getBirth(), p.getBirthPlace(), p.getGen(), p.getNum(), p.getCod(), fol);
	}
	
	/**
	 * Ritorna la cartella clinica
	 * @return cartella clinica
	 */
	public ClinicFolder getFol ()
	{
		return fol;
	}
	
	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		return super.toString() + "\n" + fol.toString();
	}
	
	@Override
	public void read ()
	{
		super.read();
		
		fol = ClinicFolder.readFromConsole();
	}
	
	@Override
	public void use ()
	{
		final int MODIFY_FOLDER_CHOICE = 1;
		
		// TODO constants
		MyMenu menu = new MyMenu("Gestione paziente: ", "Modifica cartella clinica");
		
		int scelta;
		
		while ((scelta = menu.getChoice()) != MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
			case MODIFY_FOLDER_CHOICE:
				fol.use();
				break;
			}
		}
	}
}
