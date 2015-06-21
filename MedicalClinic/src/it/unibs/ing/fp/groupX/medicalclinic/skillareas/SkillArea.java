package it.unibs.ing.fp.groupX.medicalclinic.skillareas;

import java.io.Serializable;

import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.Readable;

/**
 * Classe che definisce un'area di competenza
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class SkillArea implements Readable, Serializable
{
	/** Nome dell'area di competenza */
	private String name;
	
	/**
	 * Legge un'area di competenza da console
	 * @return Area di competenza letta
	 */
	public static SkillArea readFromConsole ()
	{
		SkillArea ris = new SkillArea();
		
		ris.read();
		
		return ris;
	}
	
	/**
	 * Costruttore senza parametri per read
	 */
	private SkillArea()
	{
		
	}
	
	/**
	 * Costruttore
	 * @param name Nome dell'area di competenza
	 */
	public SkillArea (String name)
	{
		this.name = name;
	}
	
	/**
	 * Ritorna il nome
	 * @return Nome dell'area di competenza
	 */
	public String getName ()
	{
		return name;
	}
	
	@Override
	public String toString()
	{
		return name;
	}
	
	@Override
	public boolean equals (Object obj)
	{
		SkillArea sa = (SkillArea)obj;
		
		return this.getName().equalsIgnoreCase(sa.getName());
	}

	@Override
	public void read() {
		name = IOLib.readLine("Inserisci nome dell'area di competenza: ");
	}
}
