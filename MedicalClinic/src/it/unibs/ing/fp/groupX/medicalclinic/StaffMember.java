package it.unibs.ing.fp.groupX.medicalclinic;

import it.unibs.ing.fp.groupX.myutil.CodiceFiscale;
import it.unibs.ing.fp.groupX.myutil.Gender;
import it.unibs.ing.fp.groupX.myutil.NumeroTelefonico;

import java.util.Date;

/**
 * Classe per implementazioni future (esempio aggiunta di altri tipi di dipendenti)
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class StaffMember extends Person
{
	/**
	 * Costruttore che inizializza gli attributi
	 * @param name
	 * 			nome
	 * @param surname
	 * 			cognome
	 * @param birth
	 * 			data di nascita
	 * @param birthPlace
	 * 			luogo di nascita
	 * @param gen
	 * 			genere
	 * @param num
	 * 			numero telefonico
	 * @param cod
	 * 			codice fiscale
	 */
	public StaffMember (String name, String surname, Date birth, String birthPlace, Gender gen, NumeroTelefonico num, CodiceFiscale cod)
	{
		super(name, surname, birth, birthPlace, gen, num, cod);
	}
}
