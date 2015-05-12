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
private static final int MAGGIORE = 1;
private static final int MINORE = -1;
private static final int UGUALE = 0;

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
	 * Compara due nazioni per numero medaglie
	 * @param n1 Nazione 1
	 * @param n2 Nazione 2
	 * @return 	MAGGIORE se n1>n2
	 * 			MINORE se ni<n2
	 * 			UGUALE se n1==n2
	 */
	private int compareNazioni (Nazione n1, Nazione n2)
	{
		
		if (getMedaglieOro(n1.getNome()) > getMedaglieOro(n2.getNome()))
			return MAGGIORE;
		else if (getMedaglieOro(n1.getNome()) == getMedaglieOro(n2.getNome()) && getMedaglieArgento(n1.getNome()) > getMedaglieArgento(n2.getNome()))
			return MAGGIORE;
		else if (getMedaglieOro(n1.getNome()) == getMedaglieOro(n2.getNome()) && getMedaglieArgento(n1.getNome()) == getMedaglieArgento(n2.getNome()) && getMedaglieBronzo(n1.getNome()) > getMedaglieBronzo(n2.getNome()))
			return MAGGIORE;
		else if (getMedaglieOro(n1.getNome()) == getMedaglieOro(n2.getNome()) && getMedaglieArgento(n1.getNome()) == getMedaglieArgento(n2.getNome()) && getMedaglieBronzo(n1.getNome()) == getMedaglieBronzo(n2.getNome()))
			return UGUALE;
		
		return MINORE;
	}
	
	/**
	 * Ritrona la classifica delle nazioni per numero medaglie
	 * @return Classifica  (posizione 0: più medaglie)
	 */
	public ArrayList<Nazione> getClassifica ()
	{
		ArrayList<Nazione> classifica = new ArrayList<>();
		ArrayList<Nazione> toProcess = new ArrayList<>(nazioni);
		
		while (toProcess.size() > 0)
		{
			Nazione max = toProcess.get(0);
			
			for (Nazione n: toProcess)
			{
				if (compareNazioni(n, max)==MAGGIORE)
					max = n;
			}
			
			classifica.add(max);
			toProcess.remove(max);
		}
		
		return classifica;
		
	}
	
	/**
	 * Ritorna la descrizione di una nazione con le medaglie vinte
	 * @param n Nazione
	 * @return Stringa descrittiva
	 */
	private String getNazioneString (Nazione n)
	{
		return n.toString() + ":  " + String.format(FORMATO_NUMERO_MEDAGLIE, getMedaglieOro(n.getNome()), getMedaglieArgento(n.getNome()), getMedaglieBronzo(n.getNome())) + "\n";
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
			ris.append(getNazioneString(n));
		}
		return ris.toString();
	}
	
	/**
	 * Ritorna una stringa con le nazioni in oprdine di medaglie vinte
	 * @return Stringa descrittiva
	 */
	public String toStringOrdinato ()
	{
		ArrayList<Nazione> classifica = getClassifica();
		
		StringBuffer ris = new StringBuffer();
		for (Nazione n : classifica)
		{
			ris.append(getNazioneString(n));
		}
		return ris.toString();
	}
	
}
