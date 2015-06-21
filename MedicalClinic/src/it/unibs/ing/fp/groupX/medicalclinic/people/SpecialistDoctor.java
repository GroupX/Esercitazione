package it.unibs.ing.fp.groupX.medicalclinic.people;

import it.unibs.ing.fp.groupX.medicalclinic.skillareas.SkillArea;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Visit;
import it.unibs.ing.fp.groupX.myutil.CodiceFiscale;
import it.unibs.ing.fp.groupX.myutil.Gender;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;
import it.unibs.ing.fp.groupX.myutil.NumeroTelefonico;
import it.unibs.ing.fp.groupX.myutil.Readable;
import it.unibs.ing.fp.groupX.myutil.Useable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe che implementa un medico specialistico
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class SpecialistDoctor extends Doctor implements Readable, Useable, Serializable {
	/** Tipologia di dipendente */
	public static final String STAFF_TYPE = "Specialist Doctor";
	
	/** Messaggio errore competenza non trovata */
	private static final String SKILL_NOT_FOUND_ERROR = "Competenza non trovata";
	/** Messaggio errore competenza già assegnata */
	private static final String SKILL_REDUNDACY_ERROR = "Competenza già inserita";
	
	/** Intestazione di stampa */
	private static final String PRINT_HEADER = "%s\nCompetenze:";
	/** Separatore tra una competenza e l'altra */
	private static final String PRINT_SKILL_SEPARATOR = "\n";
	
	/** Competenze del medico */
	private ArrayList<SkillArea> skills = new ArrayList<SkillArea>();
	
	/**
	 * Costruttore
	 * @param name
	 * 				nome
	 * @param surname
	 * 				cognome
	 * @param birth
	 * 				data di nascita
	 * @param birthPlace
	 * 				luogo di nascita
	 * @param gen
	 * 				genere
	 * @param num
	 * 				numero di telefono
	 * @param cod
	 * 				codice fiscale
	 */
	public SpecialistDoctor (String name, String surname, Date birth, String birthPlace, Gender gen, NumeroTelefonico num, CodiceFiscale cod)
	{
		super (name, surname, birth, birthPlace, gen, num, cod);
	}
	
	/**
	 * Costruttore
	 * @param p
	 * 				persona
	 */
	public SpecialistDoctor (Person p)
	{
		super(p);
	}
	
	/**
	 * Costruttore
	 * @param name
	 * 				nome
	 * @param surname
	 * 				cognome
	 * @param birth
	 * 				data di nascita
	 * @param birthPlace
	 * 				luogo di nascita
	 * @param gen
	 * 				genere
	 * @param num
	 * 				numero di telefono
	 * @param cod
	 * 				codice fiscale
	 * @param skills
	 * 				competenze del medico
	 */
	public SpecialistDoctor (String name, String surname, Date birth, String birthPlace, Gender gen, NumeroTelefonico num, CodiceFiscale cod, SkillArea ... skills)
	{
		this (name, surname, birth, birthPlace, gen, num, cod);
		
		for (SkillArea sa : skills)
		{
			this.skills.add(sa);
		}
	}
	
	/**
	 * Costruttore
	 * @param p
	 * 				persona
	 * @param skills
	 * 				competenze del medico
	 */
	public SpecialistDoctor (Person p, SkillArea ... skills)
	{
		this(p);
		
		for (SkillArea sa : skills)
		{
			this.skills.add(sa);
		}
	}
	
	/**
	 * Costruttore privato per read
	 */
	protected SpecialistDoctor ()
	{
		
	}
	
	/**
	 * Aggiunge una competenza al medico
	 * @param sa
	 * 			competenza
	 * @throws IllegalArgumentException competenza già inserita
	 */
	public void addSkill (SkillArea sa) throws IllegalArgumentException
	{
		if (skills.contains(sa))
		{
			throw new IllegalArgumentException(SKILL_REDUNDACY_ERROR);
		}
		else
		{
			skills.add(sa);
		}
	}
	
	/**
	 * Rimuove la competenza indicata
	 * @param sa
	 * 			competenza da rimuovere
	 * @throws IllegalArgumentException competenza non trovata
	 */
	public void removeSkill (SkillArea sa) throws IllegalArgumentException
	{
		if (!skills.contains(sa))
		{
			throw new IllegalArgumentException(SKILL_NOT_FOUND_ERROR);
		}
		else
		{
			skills.remove(sa);
		}
	}
	
	/**
	 * Rimuove la competenza indicata dall'indice
	 * @param index
	 * 				indice della competenza da rimuovere
	 * @throws IndexOutOfBoundsException indice non valido
	 */
	public void removeSkill (int index) throws IndexOutOfBoundsException
	{
		skills.remove(index);
	}
	
	/**
	 * Controlla se il medico ha la competenza indicata
	 * @param sa
	 * 			competenza da controllare
	 * @return true: è capace; false: altrimenti
	 */
	public boolean isAble (SkillArea sa)
	{
		return skills.contains(sa);
	}
	
	/**
	 * @return the skills
	 */
	public ArrayList<SkillArea> getSkills ()
	{
		return skills;
	}
	
	/**
	 * @return the skills in un array
	 */
	public SkillArea[] getSkillsArray ()
	{
		SkillArea[] ris = new SkillArea[skills.size()];
		return skills.toArray(ris);
	}
	
	/**
	 * Override toDo()
	 * @return true: può eseguire la visita; false: altrimenti
	 */
	@Override
	public boolean canDo(Visit v) {
		return isAble(v.getSkillArea());
	}
	
	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		
		s.append(String.format(PRINT_HEADER, super.toString()));
		
		for (SkillArea sa : skills)
		{
			s.append(PRINT_SKILL_SEPARATOR + sa.toString());
		}
		
		return s.toString();
	}
	
	/**
	 * Metodo factory per la lettura da console
	 * @return
	 */
	public static SpecialistDoctor readFromConsole ()
	{
		SpecialistDoctor ris = new SpecialistDoctor();
		
		ris.read();
		
		return ris;
	}
	
	/**
	 * Override di read()
	 */
	@Override
	public void read() {
		super.read();
		
		int numSkill = IOLib.readInt("Quante aree di competenza possiede? ", 1);
		
		for (int i = 0; i < numSkill; i++)
		{
			skills.add(SkillArea.readFromConsole());
		}
	}
	
	/**
	 * Metodo use()
	 */
	@Override
	public void use()
	{

		final int INSERT_SKILL_CHOICE = 1;
		final int REMOVE_SKILL_CHOICE = 2;
		
		// TODO constants
		MyMenu menu = new MyMenu("Gestione medico specialistico: ", "Inserisci area di competenza", "Rimuovi area di competenza");
		
		int scelta;
		
		while ((scelta = menu.getChoice()) != MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
			case INSERT_SKILL_CHOICE:
				try
				{
					this.addSkill(SkillArea.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			case REMOVE_SKILL_CHOICE:
				try
				{
					this.removeSkill(SkillArea.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			}
		}
	}
}
