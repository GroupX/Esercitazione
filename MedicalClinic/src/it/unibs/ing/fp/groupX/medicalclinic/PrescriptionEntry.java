package it.unibs.ing.fp.groupX.medicalclinic;

/**
 * Descrive la prescrizione di un singolo rimedio.
 * (Si usano stringhe per permettere ogni tipo di prescrizione, supponendo che i dottori non facciano errori nelle prescrizioni)
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class PrescriptionEntry {

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
}
