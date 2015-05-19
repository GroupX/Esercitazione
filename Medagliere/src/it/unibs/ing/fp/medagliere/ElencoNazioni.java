package it.unibs.ing.fp.medagliere;

import java.util.ArrayList;

public class ElencoNazioni
{
	private ArrayList <Nazione> nazioni = new ArrayList<Nazione>();
	
	/**
	 * Aggiunge una nazione (aggiunge solo se non è già presente)
	 * @param nome Nazione da inserire
	 * @return true: nazione inserita false: nazione già presente
	 */
	public boolean aggiungiNazione (String nome)
	{
		
		if (!presente(nome))
		{
			nazioni.add(new Nazione (nome));
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Aggiunge una nazione (aggiunge solo se non è già presente)
	 * @param n Nazione da inserire
	 * @return true: nazione inserita false: nazione già presente
	 */
	public boolean aggiungiNazione (Nazione n)
	{
		
		if (!presente(n.getNome()))
		{
			nazioni.add(n);
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Verifica che una nazione sia presente
	 * @param nome Nazione da ricercare
	 * @return true: nazione presente false: nazione non presente
	 */
	public boolean presente (String nome)
	{
		Nazione n = new Nazione(nome);
		return nazioni.contains(n);
	}
	
	/**
	 * Ritorna una nazione dato il nome 
	 * @param nome Nome della nazione
	 * @return Nazione crecata, se presenrte, altrimenti null
	 */
	public Nazione getNazione (String nome)
	{
		for (Nazione n : nazioni)
		{
			if (n.equals(new Nazione(nome)))
					return n;
		}
		
		return null;
	}
	
	public int getNumeroNazioni ()
	{
		return nazioni.size();
	}
}
