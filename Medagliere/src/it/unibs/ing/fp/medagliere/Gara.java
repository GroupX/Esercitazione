package it.unibs.ing.fp.medagliere;

/**
 * Classe che descrive una gara
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Gara
{
	/** Numero di nazioni vincenti */
	private static final int NUM_WINNERS = 3;

	/** Formato della stringa generata dal metodo <i>toString()</i> */
	private final static String TO_STRING_FORMAT = "%s: %s";
	
	/** Nome della gara */
	private String nome;
	
	/** Risultato della gara */
	private Risultato ris;
	
	/** Se eseguita o meno */
	private boolean eseguita;
	
	/**
	 * Costruttore che inizializza il nome della gara
	 * @param nome Nome della gara
	 * @param ris Risultato della gara
	 */
	public Gara (String nome)
	{
		this.nome = nome;
		this.ris = null;
		this.eseguita = false;
	}
	
	/**
	 * Metodo che restituisce una stringa descrittiva (nome della gara e risultato, se non presente il risultato è nullo)
	 * @return Descrizione basilare della gara
	 * 
	 */
	public String toString()
	{
		return String.format (TO_STRING_FORMAT, nome, ris);
	}
	
	/**
	 * Ritorna il nome della gara
	 * @return Nome della gara
	 */
	public String getNome()
	{
		return nome;
	}
	
	/**
	 * Ritorna il risultato della gara
	 * @return Risultato della gara
	 */
	public Risultato getRis()
	{
		return ris;
	}
	
	/**
	 * Ritorna <i>eseguita</i>
	 * @return valore di <i>eseguita</i>
	 */
	public boolean giaPremiata()
	{
		return eseguita;
	}
	
	/**
	 * setta a <b>true</b> l'attributo <i>eseguita</i>
	 */
	public void setEseguita ()
	{
		eseguita = true;
	}
	
	/**
	 * Verifica l'uguaglianza tra due gare (case insensitive)
	 * @param n Altra gara
	 * @return true: stessa gara, false: gara diversa
	 */
	@Override
	public boolean equals (Object o)
	{
		Gara g = (Gara)o;
		if(g.getNome().equalsIgnoreCase(this.getNome()))
			return true;
		else
			return false;
	}
	
	/**
	 * Ritorna le nazioni vincenti della gara
	 * @return Array contenenti le nazioni vincenti della gara
	 */
	public Nazione[] getPremiate ()
	{
		Nazione[] n = new Nazione[NUM_WINNERS];
		
		n[WinDegree.GOLD.getIndex()] = ris.getGold();
		n[WinDegree.SILVER.getIndex()] = ris.getSilver();
		n[WinDegree.BRONZE.getIndex()] = ris.getBronze();
		
		return n;
	}
	
	/**
	 * Aggiunge un risultato alla gara
	 * @param n
	 * 			Nazione vincente
	 * @param medal
	 * 			Medaglia vinta
	 */
	public void aggiungiPremiata (Nazione n, int medal)
	{
		if (ris == null)
			ris = new Risultato();
		
		ris.setResult(n, medal);
	}
	
	/**
	 * Aggiunge un risultato alla gara
	 * @param result 
	 * 			Risultato della gara
	 * @return true: risultato aggiunto, false: risultato già presente
	 */
	public boolean setRisultato (Risultato result)
	{
		if(ris == null)
		{
			this.ris = result;
			setEseguita();
			return true;
		}
		else
		{
			return false;
		}
	}
}