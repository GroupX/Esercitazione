package it.unibs.ing.fp.groupX.medagliere;

import java.util.ArrayList;

/**
 * Classe che si occupa di gestire gare, nazioni e risultati
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Medagliere
{
private ArrayList <Nazione> nazioni = new ArrayList<Nazione>();
private ArrayList<Gara> gare = new ArrayList<Gara>();

	/**
	 * Costruttore senza parametri
	 */
	public Medagliere ()
	{
		
	}
	
	/**
	 * Aggiunge una nazione (aggiunge solo se non è già presente)
	 * @param n Nazione da inserire
	 * @return true: nazione inserita false: nazione già presente
	 */
	public boolean addNazione (Nazione n)
	{
		if (!hasNazione(n))
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
	 * @param n Nazione da ricercare
	 * @return true: nazione presente false: nazione non presente
	 */
	public boolean hasNazione (Nazione n)
	{
		return nazioni.contains(n);
	}
	
	
}
