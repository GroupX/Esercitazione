package it.unibs.ing.fp.groupX.myutil;

/**
 * Interface di utilità per costruire rapidamente una classe iterabile
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 * @param <E> Tipo di oggetto contenuto
 */
public interface BasicIterable<E> extends Iterable<E> {
	
	/**
	 * Ritorna la dimensione
	 * @return Dimensione
	 */
	public int size();
	/**
	 * Ritorna un oggetto
	 * @param index Indice dell'oggetto
	 * @return Oggetto richiesto
	 */
	public E get (int index);
	
}
