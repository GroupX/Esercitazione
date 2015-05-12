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
private static final String FORMATO_NUMERO_MEDAGLIE = "Oro: %d; Argento: %d; Bronzo: %d";

	/**
	 * Costruttore senza parametri
	 */
	public Medagliere ()
	{
		
	}
	
	/**
	 * Aggiunge una nazione (aggiunge solo se non è già presente)
	 * @param nome Nazione da inserire
	 * @return true: nazione inserita false: nazione già presente
	 */
	public boolean addNazione (String nome)
	{
		
		if (!hasNazione(nome))
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
	 * Verifica che una nazione sia presente
	 * @param nome Nazione da ricercare
	 * @return true: nazione presente false: nazione non presente
	 */
	public boolean hasNazione (String nome)
	{
		Nazione n = new Nazione(nome);
		return nazioni.contains(n);
	}
	
	/**
	 * Verifica che una gara sia presente
	 * @param nome Gara da ricercare 
	 * @return true: la gara è presente false: la gara non è presente
	 */
	public boolean hasGara (String nome)
	{
		Gara g = new Gara(nome);
		return gare.contains(g);
	}
	
	/**
	 * Inserisce una gara se non già presente
	 * @param nome Gara da inserire
	 * @return true: gara inserita false: gara già presente
	 */
	public boolean addGara (String nome)
	{
		if (!hasGara(nome))
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
	 * Aggiunge un risultato
	 * @param nomeGara Gara a cui aggiungere il risultato
	 * @param nomeNazioneOro Nazione che ha preso l'oro
	 * @param nomeNazioneArgento Nazione che ha preso l'argento
	 * @param nomeNazioneBronzo Nazione che ha preso il bronzo
	 * @return true: risultato aggiunto false: risultato non aggiunto
	 */
	public boolean addRisultato (String nomeGara, String nomeNazioneOro, String nomeNazioneArgento, String nomeNazioneBronzo)
	{	
		if (!hasGara(nomeGara))
			return false;
		
		if (!hasNazione(nomeNazioneOro))
			return false;
		
		if (!hasNazione(nomeNazioneArgento))
			return false;
		
		if (!hasNazione(nomeNazioneBronzo))
			return false;
		
		return getGara(nomeGara).setRisultato(new Risultato(new Nazione(nomeNazioneOro), new Nazione(nomeNazioneArgento), new Nazione(nomeNazioneBronzo)));
	}
	
	/**
	 * Medaglie d'oro vinte dalla nazione
	 * @param nomeNazione nome della nazione
	 * @return numero medaglie vinte
	 */
	public int getMedaglieOro (String nomeNazione)
	{
		Nazione n = new Nazione(nomeNazione);
		
		if (!hasNazione(nomeNazione))
			return 0;
		
		int ris = 0;
		
		for(Gara g: gare)
		{
			if (g.getRis()!=null && g.getRis().getGold().equals(n))
			{
				ris++;
			}
		}
		
		return ris;
	}
	
	/**
	 * Medaglie d'argento vinte dalla nazione
	 * @param nomeNazione nome della nazione
	 * @return numero medaglie vinte
	 */
	public int getMedaglieArgento (String nomeNazione)
	{
		Nazione n = new Nazione(nomeNazione);
		
		if (!hasNazione(nomeNazione))
			return 0;
		
		int ris = 0;
		
		for(Gara g: gare)
		{
			if (g.getRis()!=null && g.getRis().getSilver().equals(n))
			{
				ris++;
			}
		}
		
		return ris;
	}
	
	/**
	 * Medaglie di bronzo vinte dalla nazione
	 * @param nomeNazione nome della nazione
	 * @return numero medaglie vinte
	 */
	public int getMedaglieBronzo (String nomeNazione)
	{
		Nazione n = new Nazione(nomeNazione);
		
		if (!hasNazione(nomeNazione))
			return 0;
		
		int ris = 0;
		
		for(Gara g: gare)
		{
			if (g.getRis()!=null && g.getRis().getBronze().equals(n))
			{
				ris++;
			}
		}
		
		return ris;
	}
	
	/**
	 * Ritorna la rappresentazione della classe in stringa
	 * @return Stringa rappresentante l'oggetto
	 */
	@Override
	public String toString ()
	{
		StringBuffer ris = new StringBuffer();
		for (Nazione n : nazioni)
		{
			ris.append(n.toString() + ":  " + String.format(FORMATO_NUMERO_MEDAGLIE, getMedaglieOro(n.getNome()), getMedaglieArgento(n.getNome()), getMedaglieBronzo(n.getNome())) + "\n");
		}
		return ris.toString();
	}
	
}
