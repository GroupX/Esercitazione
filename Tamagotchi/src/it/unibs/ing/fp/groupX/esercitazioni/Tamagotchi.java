package it.unibs.ing.fp.groupX.esercitazioni;

/**
 * Gestisce un Tamagotchi
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Tamagotchi
{
	private String nome;
	private double sazieta, affetto;
	private double effettoCarezza, effettoBiscotto;
	
	/** Massimo valore della sazietà */
	public static final double MAX_SAZIETA = 100;
	/** Massimo valore dell'affetto */
	public static final double MAX_AFFETTO = 100;
	
	/** Minimo valore della sazietà */
	public static final double MIN_SAZIETA = 0;
	/** Minimo valore dell'affetto */
	public static final double MIN_AFFETTO = 0;
	
	/** Soglia di tristezza per poco affetto */
	public static final double AFFETTO_BASSO = 30;
	/** Soglia di tristezza per poca sazietà */
	public static final double SAZIETA_BASSA = 30;
	
	/** Soglia di tristezza per troppo sazietà */
	public static final double SAZIETA_ALTA = 90;
	
	/** Stato del Tamagotchi felice */
	public static final int FELICE = 2;
	/** Stato del Tamagotchi infelice */
	public static final int INFELICE = 1;
	/** Stato del Tamagotchi morto */
	public static final int MORTO = 0;
	/** Stato del Tamagotchi dopo la resurrezione */
	public static final int MORTO_E_RISORTO = 3;
	
	/** Nome del redentore (per ammettere altri credo religiosi) */
	public static final String IL_REDENTORE = "Gesù";
	
	private static final String DEFAULT_NOME = "Tamagotchi";
	private static final double DEFAULT_SAZIETA = 50, DEFAULT_AFFETTO = 50;
	private static final double CAREZZA_SAZIETA = 0.5, BISCOTTO_AFFETTO = 0.25;
	private static final double CAREZZA_AFFETTO = 1, BISCOTTO_SAZIETA = 0.30;
	private static final double DIMINUZIONE_EFFETTO = 0.01, AUMENTO_EFFETTO = 0.10, MINIMO_EFFETTO = 0.01;
	
	/**
	 * Costruttore che inizializza gli attributi utilizzando i valori di default
	 */
	public Tamagotchi ()
	{
		this (DEFAULT_NOME);
	}
	
	/**
	 * Costruttore che inizializza gli attributi sazieta e affetto con valori di default
	 * @param nome Nome del Tamagotchi
	 */
	public Tamagotchi (String nome)
	{
		this (nome, DEFAULT_SAZIETA, DEFAULT_AFFETTO);
	}
	
	/**
	 * Costruttore che inizializza gli attributi
	 * @param nome Nome del Tamagotchi
	 * @param sazieta valore d'inizializzazione per il grado di sazietà
	 * @param affetto valore d'inizializzazione per il grado d'affetto
	 */
	public Tamagotchi (String nome, double sazieta, double affetto)
	{
		this.nome = nome;
		this.sazieta = sazieta;
		this.affetto = affetto;
		this.effettoCarezza = CAREZZA_AFFETTO;
		this.effettoBiscotto = BISCOTTO_SAZIETA;
	}
	
	/**
	 * Modifica opportunamente il grado di sazietà e quello d'affetto in base al numero di carezze date
	 * @param numCarezze numero di carezze da dare
	 */
	public void daiCarezza (int numCarezze)
	{
		if (controllaStato() != MORTO || nome.equals(IL_REDENTORE))
		{
			/* EVOLUZIONE:  l'effetto delle carezze diminuisce con l'aumentare di carezze date, ma aumenta l'effetto dei biscotti.
			 * 				Se l'effetto delle carezze è al minimo, l'effetto dei biscotti è al massimo. */
			if ((effettoCarezza - effettoCarezza * DIMINUZIONE_EFFETTO * numCarezze) > MINIMO_EFFETTO)
			{
				effettoCarezza -= effettoCarezza * DIMINUZIONE_EFFETTO * numCarezze;
				
				if ((effettoBiscotto + effettoBiscotto * AUMENTO_EFFETTO * numCarezze) < BISCOTTO_SAZIETA)
					effettoBiscotto += effettoBiscotto * AUMENTO_EFFETTO * numCarezze;
				else
					effettoBiscotto = BISCOTTO_SAZIETA;
			}
			else
			{
				effettoCarezza = MINIMO_EFFETTO;
				effettoBiscotto = BISCOTTO_SAZIETA;
			}
			
			if ((affetto + numCarezze * effettoCarezza) <= MAX_AFFETTO)
				affetto += numCarezze * effettoCarezza;
			else
				affetto = MAX_AFFETTO;
			
			if ((sazieta - numCarezze * CAREZZA_SAZIETA) >= MIN_SAZIETA)
				sazieta -= numCarezze * CAREZZA_SAZIETA;
			else
				sazieta = MIN_SAZIETA;
		}
	}

	/**
	 * Modifica opportunamente il grado di sazietà e quello d'affetto in base al numero di biscotti dati
	 * @param numBiscotti numero di biscotti da dare
	 */
	public void daiBiscotto (int numBiscotti)
	{
		if (controllaStato() != MORTO || nome.equals(IL_REDENTORE))
		{
			/* EVOLUZIONE:  l'effetto dei biscotti diminuisce con l'aumentare di biscotti dati, ma aumenta l'effetto delle carezze.
			 * 				Se l'effetto dei biscotti è al minimo, l'effetto delle carezze è al massimo. */
			if ((effettoBiscotto - effettoBiscotto * DIMINUZIONE_EFFETTO * numBiscotti) >= MINIMO_EFFETTO)
			{
				effettoBiscotto -= effettoBiscotto * DIMINUZIONE_EFFETTO * numBiscotti;
				
				if ((effettoCarezza + effettoCarezza * AUMENTO_EFFETTO * numBiscotti) < CAREZZA_AFFETTO)
					effettoCarezza += effettoCarezza * AUMENTO_EFFETTO * numBiscotti;
				else
					effettoCarezza = CAREZZA_AFFETTO;
			}
			else
			{
				effettoBiscotto = MINIMO_EFFETTO;
				effettoCarezza = CAREZZA_AFFETTO;
			}

			if ((sazieta + numBiscotti * effettoBiscotto) <= MAX_SAZIETA)
				sazieta += numBiscotti * effettoBiscotto;
			else
				sazieta = MAX_SAZIETA;
			
			if ((affetto - numBiscotti * BISCOTTO_AFFETTO) >= MIN_AFFETTO)
				affetto -= numBiscotti * BISCOTTO_AFFETTO;
			else
				affetto = MIN_AFFETTO;
		}
	}
	
	/**
	 * Guarda in che stato si trova il Tamagotchi
	 * @return stato: FELICE, INFELICE, MORTO
	 */
	public int controllaStato ()
	{
		if (sazieta == MAX_SAZIETA || sazieta == MIN_SAZIETA || affetto == MIN_AFFETTO)
		{
			if (nome.equals(IL_REDENTORE))
				return MORTO_E_RISORTO;
			else
				return MORTO;
		}

		if (sazieta < SAZIETA_BASSA || sazieta > SAZIETA_ALTA || affetto < AFFETTO_BASSO)
			return INFELICE;

		return FELICE;
	}
	
	/**
	 * Ritorna il grado di sazietà del Tamagotchi
	 * @return Grado di sazietà
	 */
	public double getSazieta ()
	{
		return sazieta;
	}
	
	/**
	 * Ritorna il grado d'affetto del Tamagotchi
	 * @return Grado d'affetto
	 */
	public double getAffetto ()
	{
		return affetto;
	}
	
	/**
	 * Ritorna il nome del tamagotchi
	 * @return nome
	 */
	public String getNome ()
	{
		return nome;
	}
	
	/**
	 * Ritorna l'effetto che ha ogni carezza sul grado di affetto del Tamagotchi
	 * @return effetto di ogni carezza
	 */
	public double getEffettoCarezza ()
	{
		return effettoCarezza;
	}
	
	/**
	 * Ritorna l'effetto che ha ogni biscotto sul grado di sazietà del Tamagotchi
	 * @return effetto di ogni biscotto
	 */
	public double getEffettoBiscotto ()
	{
		return effettoBiscotto;
	}

}
