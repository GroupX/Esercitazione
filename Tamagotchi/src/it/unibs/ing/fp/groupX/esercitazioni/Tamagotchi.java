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

public class Tamagotchi
{
	double sazieta, affetto;
	public static final double MAX_SAZIETA = 100, MAX_AFFETTO = 100, MIN_SAZIETA = 0, MIN_AFFETTO = 0;
	private static final double DEFAULT_SAZIETA = 50, DEFAULT_AFFETTO = 50;
	private static final double CAREZZA_SAZIETA = 0.5, BISCOTTO_AFFETTO = 0.25;
	private static final double CAREZZA_AFFETTO = 1, BISCOTTO_SAZIETA = 0.10;
	public static final double AFFETTO_BASSO = 30, SAZIETA_BASSA = 30, SAZIETA_ALTA = 90;
	public static final int FELICE = 2, INFELICE = 1, MORTO = 0;
	
	public Tamagotchi ()
	{
		this ( DEFAULT_SAZIETA, DEFAULT_AFFETTO );
	}
	
	/**
	 * Costruttore che inizializza i due attributi
	 * @param sazieta valore d'inizializzazione per il grado di sazietà
	 * @param affetto valore d'inizializzazione per il grado d'affetto
	 */
	public Tamagotchi ( double sazieta, double affetto )
	{
		this.sazieta = sazieta;
		this.affetto = affetto;
	}
	
	/**
	 * Modifica opportunamente il grado di sazietà e quello d'affetto in base al numero di carezze date
	 * @param numCarezze numero di carezze da dare
	 */
	public void daiCarezza ( int numCarezze )
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

	public void daiBiscotto ( int numBiscotti )
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

	public int controllaStato ()
	{
		if ( sazieta == MAX_SAZIETA || sazieta == MIN_SAZIETA || affetto == MIN_AFFETTO )
			return MORTO;

		if ( sazieta < SAZIETA_BASSA || sazieta > SAZIETA_ALTA || affetto < AFFETTO_BASSO )
			return INFELICE;

		return FELICE;
	}

	public double getSazieta ()
	{
		return sazieta;
	}

	public double getAffetto ()
	{
		return affetto;
	}

}
