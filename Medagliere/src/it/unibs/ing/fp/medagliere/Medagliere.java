package it.unibs.ing.fp.medagliere;

import java.util.ArrayList;

/**
 * Classe che si occupa di gestire gare, nazioni e risultati
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Medagliere
{
private ElencoNazioni nazioni = new ElencoNazioni();
private ElencoGare gare = new ElencoGare();

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
		
		return nazioni.aggiungiNazione(nome);
	}
	
	/**
	 * Verifica che una nazione sia presente
	 * @param nome Nazione da ricercare
	 * @return true: nazione presente false: nazione non presente
	 */
	public boolean hasNazione (String nome)
	{
		return nazioni.presente(nome);
	}
	
	/**
	 * Verifica che una gara sia presente
	 * @param nome Gara da ricercare 
	 * @return true: la gara è presente false: la gara non è presente
	 */
	public boolean hasGara (String nome)
	{
		return gare.presente(nome);
	}
	
	/**
	 * Inserisce una gara se non già presente
	 * @param nome Gara da inserire
	 * @return true: gara inserita false: gara già presente
	 */
	public boolean addGara (String nome)
	{
		return gare.aggiungiGara(nome);
	}
	
	/**
	 * Ritorna una gara dato il nome
	 * @param nome Nome della gara
	 * @return Gara trovata
	 */
	public Gara getGara (String nome)
	{
		return gare.getGara(nome);
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
		
		nazioni.getNazione(nomeNazioneOro).aggiungiMedaglia(WinDegree.GOLD.getIndex());
		nazioni.getNazione(nomeNazioneArgento).aggiungiMedaglia(WinDegree.SILVER.getIndex());
		nazioni.getNazione(nomeNazioneBronzo).aggiungiMedaglia(WinDegree.BRONZE.getIndex());
		
		return getGara(nomeGara).setRisultato(new Risultato(new Nazione(nomeNazioneOro), new Nazione(nomeNazioneArgento), new Nazione(nomeNazioneBronzo)));
	
	}
	
	/**
	 * Medaglie d'oro vinte dalla nazione
	 * @param nomeNazione nome della nazione
	 * @return numero medaglie vinte
	 */
	public int getMedaglieOro (String nomeNazione)
	{
		return nazioni.getNazione(nomeNazione).getMedaglie(WinDegree.GOLD.getIndex());
	}
	
	/**
	 * Medaglie d'argento vinte dalla nazione
	 * @param nomeNazione nome della nazione
	 * @return numero medaglie vinte
	 */
	public int getMedaglieArgento (String nomeNazione)
	{
		return nazioni.getNazione(nomeNazione).getMedaglie(WinDegree.SILVER.getIndex());
	}
	
	/**
	 * Medaglie di bronzo vinte dalla nazione
	 * @param nomeNazione nome della nazione
	 * @return numero medaglie vinte
	 */
	public int getMedaglieBronzo (String nomeNazione)
	{
		return nazioni.getNazione(nomeNazione).getMedaglie(WinDegree.BRONZE.getIndex());
	}
	
	/**
	 * Ritorna la rappresentazione della classe in stringa
	 * @return Stringa rappresentante l'oggetto
	 */
	@Override
	public String toString ()
	{
		ArrayList<Nazione> naz = nazioni.getArrayList();
		StringBuffer ris = new StringBuffer();
		for (Nazione n : naz)
		{
			ris.append(n.toString() + "\n");
		}
		return ris.toString();
	}
	
	/**
	 * Ritorna una stringa con le nazioni in oprdine di medaglie vinte
	 * @return Stringa descrittiva
	 */
	public String toStringOrdinato ()
	{
		ArrayList<Nazione> classifica = nazioni.getClassifica();
		
		StringBuffer ris = new StringBuffer();
		for (Nazione n : classifica)
		{
			ris.append(n.toString() + "\n");
		}
		return ris.toString();
	}
	
}
