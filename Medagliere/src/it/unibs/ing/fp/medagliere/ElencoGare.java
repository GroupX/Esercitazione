package it.unibs.ing.fp.medagliere;

import java.util.ArrayList;

/**
 * Classe per la gestione di un elenco di gare
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class ElencoGare
{
	private ArrayList<Gara> gare = new ArrayList<Gara>();
	
	/**
	 * Inserisce una gara se non già presente
	 * @param nome Gara da inserire
	 * @return true: gara inserita, false: gara già presente
	 */
	public boolean aggiungiGara (String nome)
	{
		if (!presente(nome))
		{
			gare.add(new Gara(nome));
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Inserisce una gara se non già presente
	 * @param nome Gara da inserire
	 * @return true: gara inserita, false: gara già presente
	 */
	public boolean aggiungiGara (Gara g)
	{
		if (!presente(g.getNome()))
		{
			gare.add(g);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Ritorna una gara dato il nome
	 * @param nome Nome della gara
	 * @return Gara trovata
	 */
	public Gara getGara (String nome)
	{
		Gara gi = new Gara(nome);
		for (Gara g: gare)
		{
			if (g.equals(gi))
				return g;
		}
		return null;
	}
	
	/**
	 * Verifica che una gara sia presente
	 * @param nome Gara da ricercare 
	 * @return true: la gara è presente, false: la gara non è presente
	 */
	public boolean presente (String nome)
	{
		Gara g = new Gara(nome);
		return gare.contains(g);
	}

	/**
	 * Ritorna il numero di gare presenti
	 * @return numero di gare presenti
	 */
	public int getNumeroGare ()
	{
		return gare.size();
	}
}
