package it.unibs.ing.fp.medagliere;

/**
 * Classe che implementa i risultati delle gare
 * 
 * @author pasqualipaolo
 *
 */
public class Risultato
{
	private final static int NUM_WINNERS = 3;
	private final static String TO_STRING_FORMAT = "Oro: %s; Argento: %s; Bronzo: %s";
	
	private Nazione[] winners = new Nazione[NUM_WINNERS];
	
	/**
	 * Inizializza il risultato della gara
	 * @param gold
	 * 			Nazione arrivata prima
	 * @param silver
	 * 			Nazione arrivata seconda
	 * @param bronze
	 * 			Nazione arrivata terza
	 */
	public Risultato (Nazione gold, Nazione silver, Nazione bronze)
	{
		winners[WinDegree.GOLD.getIndex()] = gold;
		winners[WinDegree.SILVER.getIndex()] = silver;
		winners[WinDegree.BRONZE.getIndex()] = bronze;
	}
	
	/**
	 * Costruttore default
	 */
	public Risultato ()
	{
		
	}
	
	/**
	 * Ritorna la nazione che ha vinto l'oro (primo posto)
	 * @return Nazione con oro
	 */
	public Nazione getGold ()
	{
		return winners[WinDegree.GOLD.getIndex()];
	}
	
	/**
	 * Ritorna la nazione che ha vinto l'argento (secondo posto)
	 * @return Nazione con argento
	 */
	public Nazione getSilver ()
	{
		return winners[WinDegree.SILVER.getIndex()];
	}
	
	/**
	 * Ritorna la nazione che ha vinto il bronzo (terzo posto)
	 * @return Nazione con bronzo
	 */
	public Nazione getBronze ()
	{
		return winners[WinDegree.BRONZE.getIndex()];
	}
	
	/**
	 * Aggiunge un risultato
	 * @param n
	 * 			Nazione vincente
	 * @param medal
	 * 			Medaglia vinta
	 */
	public void setResult (Nazione n, int medal)
	{
		if(medal >= 0 && medal < NUM_WINNERS)
			winners[medal] = n;
	}
	
	/**
	 * Controlla se la nazione passata ha vinto qualcosa
	 * @param n
	 * 			Nazione da testare
	 * @return WinDegree.GOLD se prima, WinDegree.SILVER se seconda, WinDegree.BRONZE se terza, WinDegree.NONE se non ha vinto nulla
	 */
	public WinDegree hasWon (Nazione n)
	{
		if (n.equals (winners[WinDegree.GOLD.getIndex ()]))
			return WinDegree.GOLD;
		
		if (n.equals (winners[WinDegree.SILVER.getIndex ()]))
			return WinDegree.SILVER;
		
		if (n.equals (winners[WinDegree.BRONZE.getIndex ()]))
			return WinDegree.BRONZE;
		
		return WinDegree.NONE;
	}
	
	/**
	 * Ritorna una stringa descrittiva del risultato
	 * @return stringa descrittiva del risultato
	 */
	@Override
	public String toString ()
	{
		return String.format (TO_STRING_FORMAT, winners[WinDegree.GOLD.getIndex()].getNome (), winners[WinDegree.SILVER.getIndex()].getNome (), winners[WinDegree.BRONZE.getIndex()].getNome ());
	}
}