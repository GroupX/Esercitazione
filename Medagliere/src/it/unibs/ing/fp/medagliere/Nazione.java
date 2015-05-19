package it.unibs.ing.fp.medagliere;

import it.unibs.ing.fp.groupX.myutil.StringManager;

/**
 * Rappresenta una nazione
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Nazione
{
	private final static String SEPARATOR_NAME = " ";
	private final static int FIRST_LETTER_NAME = 0;
	private final static int NUM_MEDAGLIE = 3;
	
	private static final int MAGGIORE = 1;
	private static final int MINORE = -1;
	private static final int UGUALE = 0;
	
	private String nome;
	private int[] contatoreMedaglie = new int[NUM_MEDAGLIE];
	
	/**
	 * Costruttore con il nome
	 * @param nome Nome della nazione
	 */
	public Nazione (String nome)
	{
		this.nome = StringManager.initialToUpper(nome, SEPARATOR_NAME);
	}
	
	/**
	 * Ritorna il nome della gare
	 * @return
	 */
	public String getNome ()
	{
		return nome;
	}
	
	/**
	 * Ritorna il contatore delle medaglie
	 * @return Contatore delle medaglie
	 */
	public int[] getContatoreMedaglie ()
	{
		return contatoreMedaglie;
	}
	
	/**
	 * Ritorna il numero di medaglie di un tipo
	 * @param type
	 * 			Tipo di medaglia [GOLD, SILVER, BRONZE]
	 * @return Numero di medaglie di un tipo
	 */
	public int getMedaglie (int type)
	{
		return contatoreMedaglie[type];
	}
	
	/**
	 * Aggiunge una medaglia
	 * @param type
	 * 			Tipo di medaglia [GOLD, SILVER, BRONZE]
	 */
	public void aggiungiMedaglia (int type)
	{
		contatoreMedaglie[type]++;
	}
	
	/**
	 * Confronta le nazioni in base alle medaglie
	 * @param n
	 * 			Nazione da confrontare
	 * @return true: se la nazione è meglio di quella passata, false altrimenti
	 */
	public boolean meglioDi (Nazione n)
	{
		if (getMedaglie(WinDegree.GOLD.getIndex()) > n.getMedaglie(WinDegree.GOLD.getIndex()))
			return true;
		else if (getMedaglie(WinDegree.GOLD.getIndex()) == n.getMedaglie(WinDegree.GOLD.getIndex()) && getMedaglie(WinDegree.SILVER.getIndex()) > n.getMedaglie(WinDegree.SILVER.getIndex()))
			return true;
		else if (getMedaglie(WinDegree.GOLD.getIndex()) == n.getMedaglie(WinDegree.GOLD.getIndex()) && getMedaglie(WinDegree.SILVER.getIndex()) == n.getMedaglie(WinDegree.SILVER.getIndex()) && getMedaglie(WinDegree.BRONZE.getIndex()) > n.getMedaglie(WinDegree.BRONZE.getIndex()))
			return true;
		else if (getMedaglie(WinDegree.GOLD.getIndex()) == n.getMedaglie(WinDegree.GOLD.getIndex()) && getMedaglie(WinDegree.SILVER.getIndex()) == n.getMedaglie(WinDegree.SILVER.getIndex()) && getMedaglie(WinDegree.BRONZE.getIndex()) == n.getMedaglie(WinDegree.BRONZE.getIndex()))
			return false;
		
		return false;
	}
	
	/**
	 * Compara una nazione passata in base al numero di medaglie
	 * @param n
	 * 			Nazione da comparare
	 * @return <i>MAGGIORE</i> se le medaglie hanno più valore, <i>UGUALE</i> se le medaglie hanno lo stesso valore, <i>MINORE</i> se le medaglie hanno menno valore
	 */
	public int compare (Nazione n)
	{
		if (getMedaglie(WinDegree.GOLD.getIndex()) > n.getMedaglie(WinDegree.GOLD.getIndex()))
			return MAGGIORE;
		else if (getMedaglie(WinDegree.GOLD.getIndex()) == n.getMedaglie(WinDegree.GOLD.getIndex()) && getMedaglie(WinDegree.SILVER.getIndex()) > n.getMedaglie(WinDegree.SILVER.getIndex()))
			return MAGGIORE;
		else if (getMedaglie(WinDegree.GOLD.getIndex()) == n.getMedaglie(WinDegree.GOLD.getIndex()) && getMedaglie(WinDegree.SILVER.getIndex()) == n.getMedaglie(WinDegree.SILVER.getIndex()) && getMedaglie(WinDegree.BRONZE.getIndex()) > n.getMedaglie(WinDegree.BRONZE.getIndex()))
			return MAGGIORE;
		else if (getMedaglie(WinDegree.GOLD.getIndex()) == n.getMedaglie(WinDegree.GOLD.getIndex()) && getMedaglie(WinDegree.SILVER.getIndex()) == n.getMedaglie(WinDegree.SILVER.getIndex()) && getMedaglie(WinDegree.BRONZE.getIndex()) == n.getMedaglie(WinDegree.BRONZE.getIndex()))
			return UGUALE;
		
		return MINORE;
	}
	
	/**
	 * Verifica l'uguaglianza tra due nazioni (case insensitive)
	 * @param n Altra nazione
	 * @return true: stessa nazione false: nazione diversa
	 */
	@Override
	public boolean equals (Object o)
	{
		Nazione n = (Nazione)o;
		if (n.getNome().equalsIgnoreCase(this.getNome()))
			return true;
		else
			return false;
	}
	
	/**
	 * Ritorna la rappresentazione testuale della classe
	 * 
	 * @return testo rappresentante la classe
	 */
	@Override
	public String toString ()
	{
		return getNome();
	}
}
