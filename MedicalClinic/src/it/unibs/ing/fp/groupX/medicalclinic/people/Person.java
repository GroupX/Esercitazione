package it.unibs.ing.fp.groupX.medicalclinic.people;

import it.unibs.ing.fp.groupX.myutil.*;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe che implementa una persona
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Person
{
	/** Formato stampa */
	private static final String PRINT_FORMAT = "%s %s\nNato il %s a %s\nCodice Fiscale: %s\nNumero di telefono: %s";
	/** Formato stampa breve */
	private static final String PRINT_FORMAT_SHORT = "%s  %s  CF: %s";
	/** Formato stampa data */
	private static final String DATE_FORMAT = "dd/MM/yyyy";
	
	/** Nome */
	private String name;
	/** Cognome */
	private String surname;
	/** Data di nascita */
	private Date birth;
	/** Luogo di nascita */
	private String birthPlace;
	/** Genere */
	private Gender gen;
	/** Numero telefonico */
	private NumeroTelefonico num;
	/** Codice fiscale */
	private CodiceFiscale cod;
	
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
	public Person (String name, String surname, Date birth, String birthPlace, Gender gen, NumeroTelefonico num, CodiceFiscale cod)
	{
		this.name = new String(name);
		this.surname = new String(surname);
		this.birth = (Date)birth.clone();
		this.birthPlace = new String(birthPlace);
		this.gen = gen;
		this.num = new NumeroTelefonico (num.toString());
		this.cod = new CodiceFiscale (cod);
	}
	
	/**
	 * Costruttore copia
	 * @param p Persona da copiare
	 */
	public Person(Person p) {
		this(p.name, p.surname, p.birth, p.birthPlace, p.gen, p.num, p.cod);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @return the birth
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @return the birthPlace
	 */
	public String getBirthPlace() {
		return birthPlace;
	}

	/**
	 * @return the gen
	 */
	public Gender getGen() {
		return gen;
	}

	/**
	 * @return the num
	 */
	public NumeroTelefonico getNum() {
		return num;
	}

	/**
	 * @return the cod
	 */
	public CodiceFiscale getCod() {
		return cod;
	}

	/**
	 * Stampa una persona in formato breve (nome cognome e codice fiscale)
	 * @return Stringa che rappresena la persona in formato breve
	 */
	public String toStringShort ()
	{
		return String.format(PRINT_FORMAT_SHORT, name, surname, cod.toString());
	}
	
	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
		return String.format(PRINT_FORMAT, name, surname, sdf.format(birth), birthPlace, cod.toString(), num.toString());
	}
	
	/**
	 * Override di equals
	 * @return true: hanno lo stesso codice fiscale; false: altrimenti
	 */
	@Override
	public boolean equals(Object obj) {
		Person p = (Person)obj;
		return cod.equals(p.getCod());
	}
}
