package it.unibs.ing.fp.groupX.medicalclinic.visit;

import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.Readable;

/**
 * Descrive la prescrizione di un singolo rimedio.
 * (Si usano stringhe per permettere ogni tipo di prescrizione, supponendo che i dottori non facciano errori nelle prescrizioni)
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class PrescriptionEntry implements Readable{

	private static final String INSERT_PERIOD_MSG = "Inserisci il periodo di assunzione/trattamento [può essere vuoto]: ";
	private static final String INSERT_FREQUENCY_MSG = "Inserisci la frequenza di assunzione/trattamento [può essere vuoto]: ";
	private static final String INSERT_REMEDY_MSG = "Inserisci il rimedio proposto: ";
	/**Stringa di formato per toString*/
	private String TO_STRING_FORMAT = "Rimedio: %s\tFrequenza: %s\tPeriodo: %s";
	/**Stringa di formato per toString, variante senza periodo*/
	private String TO_STRING_FORMAT_NO_PERIOD = "Rimedio: %s\tFrequenza: %s";
	/**Stringa di formato per toString, variante con solo rimedio*/
	private String TO_STRING_FORMAT_REMEDY_ONLY = "Rimedio: %s";
	
	/** Rimedio */
	private String remedy;
	/** Frequenza di assunzione */
	private String frequency;
	/** Periodo di sottoposizione */
	private String period;
	
	/**
	 * Legge la prescrizione di un singolo rimedio dalla console
	 * @return
	 */
	public static PrescriptionEntry readFromConsole ()
	{
		PrescriptionEntry ris = new PrescriptionEntry();
		
		ris.read();
		
		return ris;
	}
	
	/**
	 * Costruttore vuoto per read
	 */
	private PrescriptionEntry ()
	{
		
	}
	
	/**
	 * Costruttore
	 * @param remedy Rimedio prescritto
	 * @param frequency Frequenza di assunzione / trattamento
	 * @param period Periodo di sottoposizione al rimedio
	 */
	public PrescriptionEntry (String remedy, String frequency, String period)
	{
		this.remedy = remedy;
		this.frequency = frequency;
		this.period = period;
	}
	
	/**
	 * Costruttore con il solo rimedio (ad esempio per operazioni o rimedi che non hanno durata/frequanza)
	 * @param remedy Il rimedio prescritto
	 */
	public PrescriptionEntry (String remedy)
	{
		this(remedy, null, null);
	}

	/**
	 * @return the remedy
	 */
	public String getRemedy() {
		return remedy;
	}

	/**
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}

	/**
	 * @return the period
	 */
	public String getPeriod() {
		return period;
	}
	
	@Override
	public boolean equals (Object o)
	{
		PrescriptionEntry p = (PrescriptionEntry)o;
		return p.getRemedy().equals(this.getRemedy());
	}
	
	@Override
	public String toString()
	{
		if (frequency == null && period == null)
		{
			return String.format(TO_STRING_FORMAT_REMEDY_ONLY, remedy);
		}
		else if (frequency == null)
		{
			return String.format(TO_STRING_FORMAT_NO_PERIOD, remedy, frequency);
		}
		else
		{
			return String.format(TO_STRING_FORMAT, remedy, frequency, period);
		}
	}

	@Override
	public void read() {

		remedy = IOLib.readLine(INSERT_REMEDY_MSG);
		frequency = IOLib.readLine(INSERT_FREQUENCY_MSG);
		period = IOLib.readLine(INSERT_PERIOD_MSG);
		
	}
}
