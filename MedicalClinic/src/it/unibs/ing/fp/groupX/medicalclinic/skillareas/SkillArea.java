package it.unibs.ing.fp.groupX.medicalclinic.skillareas;

/**
 * Classe che definisce un'area di competenza
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class SkillArea
{
	/** Nome dell'area di competenza */
	private String name;
	
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
}
