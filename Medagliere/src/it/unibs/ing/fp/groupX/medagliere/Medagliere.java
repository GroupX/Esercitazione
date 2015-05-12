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
	 * Aggiunge una nazione (aggiunge solo se non � gi� presente)
	 * @param n Nazione da inserire
	 * @return true: nazione inserita false: nazione gi� presente
	 */
	public boolean addNazione (Nazione n)
	{
		if (!nazioni.contains(n))
		{
			nazioni.add(n);
			return true;
		}
		else
		{
			return false;
		}
	}
}
