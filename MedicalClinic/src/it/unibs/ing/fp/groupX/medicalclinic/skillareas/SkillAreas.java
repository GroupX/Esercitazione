package it.unibs.ing.fp.groupX.medicalclinic.skillareas;

import it.unibs.ing.fp.groupX.myutil.BasicIterable;
import it.unibs.ing.fp.groupX.myutil.BasicIterator;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;
import it.unibs.ing.fp.groupX.myutil.Useable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Insieme delle aree di competenza esistenti.
 * Non singleton perchè ogni clinica può avere le sue aree di competenza
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class SkillAreas implements BasicIterable<SkillArea>, Useable, Serializable
{
	private static final String LIST_HEAD = "Elenco aree di competenza: ";
	/** Messaggio di errore nel caso in cui si cercasse di eliminare un'area non presente */
	private static final String NOT_PRESENT_SKILL_AREA_MESSAGE = "Area di competenza non presente";
	/** Messaggio di errore in caso di reinserimento della stessa area di competenza */
	private static final String ALREADY_INSERTED_MESSAGE = "Area di competenza già inserita";
	/** Lista delle aree di competenza */
	private List <SkillArea> skillAreas = new ArrayList<SkillArea>();
	/** Nome dell'area generale */
	public static final String GENERAL_SKILL_AREA_NAME = "Generale";	
	
	/**
	 * Costruttore
	 */
	public SkillAreas ()
	{
		skillAreas.add(new SkillArea(GENERAL_SKILL_AREA_NAME));
	}
	
	/**
	 * Aggiunge un'area di competenza
	 * @param sa Area da aggiungere
	 */
	public void add (SkillArea sa)
	{
		if (contains(sa))
			throw new IllegalArgumentException(ALREADY_INSERTED_MESSAGE);
		
		skillAreas.add(sa);
	}
	
	/**
	 * Aggiunge un'area di competenza
	 * @param sa Area da aggiungere
	 */
	public void add (String sa)
	{
		add(new SkillArea(sa));
	}
	
	/**
	 * Dice se una certa area di competenza è presente
	 * @param sa Area di competenza presente
	 * @return true: area presente, false: area non presente
	 */
	public boolean contains (SkillArea sa)
	{
		return skillAreas.contains(sa);
	}

	/**
	 * Dice se una certa area di competenza è presente
	 * @param sa Area di competenza presente
	 * @return true: area presente, false: area non presente
	 */
	public boolean contains (String sa)
	{
		return contains(new SkillArea(sa));
	}
	
	/**
	 * Rimuove un'area di competenza
	 * @param sa Area di competenza da rimuovere
	 */
	public void remove (SkillArea sa) throws IllegalArgumentException
	{
		if (!contains(sa))
			throw new IllegalArgumentException(NOT_PRESENT_SKILL_AREA_MESSAGE);
		
		skillAreas.remove(sa);
	}
	
	/**
	 * Rimuove un'area di competenza
	 * @param sa Area di competenza da rimuovere
	 */
	public void remove (String sa) throws IllegalArgumentException
	{
		remove(new SkillArea(sa));
	}
	
	@Override
	public Iterator<SkillArea> iterator()
	{
		return new BasicIterator<>(this);
	}

	@Override
	public int size()
	{
		return skillAreas.size();
	}

	@Override
	public SkillArea get(int index)
	{
		return skillAreas.get(index);
	}
	
	@Override
	public String toString ()
	{
		StringBuffer buf = new StringBuffer();
		buf.append(LIST_HEAD);
		for (SkillArea sa: skillAreas)
		{
			buf.append("\n" + sa.toString());
		}
		
		return buf.toString();
	}

	@Override
	public void use() {
		
		final int INSERT_SKILL_AREA_CHOICE = 1;
		final int REMOVE_SKILL_AREA_CHOICE = 2;
		final int PRINT_SKILL_AREA_CHOICE = 3;
		
		// TODO constants
		MyMenu menu = new MyMenu("Gestione aree di competenza esistenti: ", "Inserisci area di competenza", "Rimuovi area di competenza", "Stampa aree di competenza");
		
		int scelta;
		
		while ((scelta = menu.getChoice()) != MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
			case INSERT_SKILL_AREA_CHOICE:
				try
				{
					this.add(SkillArea.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			case REMOVE_SKILL_AREA_CHOICE:
				try
				{
					this.remove(SkillArea.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			case PRINT_SKILL_AREA_CHOICE:
				IOLib.printLine(this.toString());
				break;
			}
		}
	}
}
