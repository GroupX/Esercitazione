package it.unibs.ing.fp.groupX.myutil;

/**
 * Interfaccia che specifica che una classe è in grado di essere inizializzata leggendo dallo standard input, eventualmente stampando messaggi di richiesta sullo standard output
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 */
public interface Readable {
	
	/**
	 * Inizializza una classe leggendo dallo standard input, eventualmente mandando messaggi di richiesta sullo standard output
	 * 
	 * ATTENZIONE: Reinizializza l'oggetto
	 */
	public void read ();
}
