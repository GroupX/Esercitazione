/*
 * Autori: Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 * 
 * Classe per la gestione dell'"esserino" Tamagotchi
 * 
 * possiede due attriuti: 
 * 		il valore di sazietà
 * 		quanto affetto prova per il creatore
 * 
 * vengono create delle costanti:
 * 		MAX_SAZIETA --> valore massimo per la sazietà del tamagotchi (se assunto provoca morte)
 * 		MAX_AFFETTO --> valore massimo per l'affetto del tamagotchi
 * 		MIN_SAZIETA --> valore minimo per la sazietà del tamagotchi (se assunto provoca morte)
 * 		MIN_AFFETTO --> valore minimo per l'affetto del tamagotchi (se assunto provoca morte)
 * 		DEFAULT_SAZIETA --> valore iniziale della sazietà se non indicato
 * 		DEFAULT_AFFETTO --> valore iniziale dell'affetto se non indicato
 * 		CAREZZA_SAZIETA --> rapporto di quanta sazietà togliere con una carezza
 * 		BISCOTTO_AFFETTO --> rapporto di quanto affetto togliere con un biscotto
 * 		CAREZZA_AFFETTO --> coefficiente d'aumento dell'affetto in base a quante carezze ricevute
 * 		BISCOTTO_SAZIETA --> coefficiente d'aumento della sazietà in base a quanti biscotti ricevuti
 * 		AFFETTO_BASSO --> soglia per l'infelicità del tamagotchi
 * 		SAZIETA_BASSA --> soglia per l'essere affamato del tamagotchi
 * 		SAZIETA_ALTO --> soglia per l'essere più che pieno del tamagotchi
 * 		FELICE --> stato di felicità del tamagotchi
 * 		INFELICE --> stato di infelicità del tamagotchi
 * 		MORTO --> il tamagotchi è morto...
 * 
 * Due costruttori: uno permette di indicare i valori, l'altro imposta quelli di default
 * 
 * Metodi:
 * 		daiCarezza
 * 			non ritorna valori; riceve un parametro in ingresso (il numero di carezze), sistema quindi di conseguenza i due 
 * 			parametri del tamagotchi effettuando gli opportuni controlli
 * 
 * 		daiBiscotto
 * 			non ritorna valori; riceve un parametro in ingresso (il numero di biscotti), sistema quindi di conseguenza i due
 * 			parametri del tamagotchi effettuando gli opportuni controlli
 * 
 * 		controllaStato
 * 			ritorna lo stato ( FELICE, INFELICE, MORTO ) del tamagotchi; non riceve parametri in ingresso
 * 		
 * 		getSazieta
 * 			ritorna il valore di sazietà del tamagotchi; non riceve parametri in ingresso
 * 
 * 		getAffetto
 * 			ritorna il valore dell'affetto del tamagotchi; non riceve parametri in ingresso
 * 
 */

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
	private static final double CAREZZA_AFFETTO = 1, BISCOTTO_SAZIETA = 0.10;
	
	
	
	/**
	 * Costruttore che inizializza gli attributi utilizzando i valori di default
	 */
	public Tamagotchi ()
	{
		this ( DEFAULT_NOME );
	}
	
	/**
	 * Costruttore che inizializza gli attributi sazieta e affetto con valori di default
	 * @param nome Nome del Tamagotchi
	 */
	public Tamagotchi (String nome)
	{
		this (nome, DEFAULT_SAZIETA, DEFAULT_AFFETTO );
	}
	
	/**
	 * Costruttore che inizializza gli attributi
	 * @param nome Nome del Tamagotchi
	 * @param sazieta valore d'inizializzazione per il grado di sazietà
	 * @param affetto valore d'inizializzazione per il grado d'affetto
	 */
	public Tamagotchi ( String nome, double sazieta, double affetto )
	{
		this.nome = nome;
		this.sazieta = sazieta;
		this.affetto = affetto;
	}
	
	/**
	 * Modifica opportunamente il grado di sazietà e quello d'affetto in base al numero di carezze date
	 * @param numCarezze numero di carezze da dare
	 */
	public void daiCarezza ( int numCarezze )
	{
		if (controllaStato() != MORTO && !nome.equals(IL_REDENTORE))
		{
			if ( ( affetto + numCarezze * CAREZZA_AFFETTO ) <= MAX_AFFETTO )
				affetto += numCarezze * CAREZZA_AFFETTO;
			else
				affetto = MAX_AFFETTO;
	
			if ( ( sazieta - numCarezze * CAREZZA_SAZIETA ) >= MIN_SAZIETA )
				sazieta -= numCarezze * CAREZZA_SAZIETA;
			else
				sazieta = MIN_SAZIETA;
		}
	}

	/**
	 * Modifica opportunamente il grado di sazietà e quello d'affetto in base al numero di biscotti dati
	 * @param numBiscotti numero di biscotti da dare
	 */
	public void daiBiscotto ( int numBiscotti )
	{
		if (controllaStato() != MORTO && !nome.equals(IL_REDENTORE))
		{
			if ( ( sazieta + numBiscotti * BISCOTTO_SAZIETA ) <= MAX_SAZIETA )
				sazieta += numBiscotti * BISCOTTO_SAZIETA;
			else
				sazieta = MAX_SAZIETA;
	
			if ( ( affetto - numBiscotti * BISCOTTO_AFFETTO ) >= MIN_AFFETTO )
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

		if ( sazieta < SAZIETA_BASSA || sazieta > SAZIETA_ALTA || affetto < AFFETTO_BASSO )
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

}
