package it.unibs.ing.fp.groupX.myutil;

import java.util.Random;

/**
 * Classe per l'estrazione casuale
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class EstrattoreCasuale
{
	/**
	 * Estrazione di un numero intero casuale
	 * @return numero intero casuale
	 */
	public static int estraiInt ()
	{
		return new Random().nextInt();
	}
	
	/**
	 * Estrazione di un numero intero casuale
	 * @param upperBound
	 * 			Soglia superiore dell'estrazione
	 * @return numero intero casuale
	 */
	public static int estraiInt (int upperBound)
	{
		return new Random().nextInt(upperBound);
	}
	
	/**
	 * Estrazione di un numero intero casuale
	 * @param lowerBound
	 * 			Soglia inferiore dell'estrazione
	 * @param upperBound
	 * 			Soglia superiore dell'estrazione
	 * @return numero intero casuale
	 */
	public static int estraiInt (int lowerBound, int upperBound)
	{
		return estraiInt(upperBound-lowerBound) + lowerBound;
	}
	
	/**
	 * Estrazione di un numero reale casuale
	 * @return numero reale casuale
	 */
	public static double estraiDouble ()
	{
		return new Random().nextDouble();
	}
	
	/**
	 * Estrazione di un numero reale casuale
	 * @param upperBound
	 * 			Soglia superiore dell'estrazione
	 * @return numero reale casuale
	 */
	public static double estraiDouble (double upperBound)
	{
		return estraiDouble()%upperBound;
	}
	
	/**
	 * Estrazione di un numero reale casuale
	 * @param lowerBound
	 * 			Soglia inferiore dell'estrazione
	 * @param upperBound
	 * 			Soglia superiore dell'estrazione
	 * @return numero reale casuale
	 */
	public static double estraiDouble (double lowerBound, double upperBound)
	{
		return estraiDouble(upperBound-lowerBound) + lowerBound;
	}
	
	/**
	 * Estrazione di un numero intero lungo casuale
	 * @return numero intero lungo casuale
	 */
	public static long estraiLong ()
	{
		return new Random().nextLong();
	}
	
	/**
	 * Estrazione di un numero intero lungo casuale
	 * @param upperBound
	 * 			Soglia superiore dell'estrazione
	 * @return numero intero lungo casuale
	 */
	public static long estraiLong (long upperBound)
	{
		return estraiLong()%upperBound;
	}
	
	/**
	 * Estrazione di un numero intero lungo casuale
	 * @param lowerBound
	 * 			Soglia inferiore dell'estrazione
	 * @param upperBound
	 * 			Soglia superiore dell'estrazione
	 * @return numero intero lungo casuale
	 */
	public static long estraiLong (long lowerBound, long upperBound)
	{
		return estraiLong(upperBound-lowerBound) + lowerBound;
	}
	
}
