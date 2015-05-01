package it.unibs.ing.fp.groupX.myutil;

public class Durata
{
	/** Formato delle unità temporali */
	private static final String TIME_FORMAT = "%02d";
	
	/** Segnaposto dei secondi */
	public static final String SEC_PLACEHOLDER = "sec";
	/** Segnaposto dei minuti */
	public static final String MIN_PLACEHOLDER = "min";
	/** Segnaposto delle ore */
	public static final String ORE_PLACEHOLDER = "ore";
	
	/** Formato predefinito per il metodo toString */
	private static final String DEFAULT_FORMAT = "oreh minm secs";
	/** Formato predefinito per il metodo toString, solo minuti e secondi */
	private static final String DEFAULT_FORMAT_MIN_SEC = "minm secs";
	/** Formato predefinito per il metodo toString, solo secondi */
	private static final String DEFAULT_FORMAT_SEC = "secs";
	
	
	/** Secondi in un'ora */
	private static final int SECONDI_PER_ORA = 3600;
	/** Secondi in un minuto */
	private static final int SECONDI_PER_MINUTO = 60;
	/** Minuti in un ora */
	private static final int MINUTI_PER_ORA = 60;
	
	/** Durata - secondi */
	private long secondi;
	/** Durata - minuti */
	private long minuti;
	/** Durata - ore */
	private long ore;
	
	/** Durata nulla */
	public  static final long NULL_TIME = 0;
	
	/**
	 * Crea una durata nulla
	 */
	public Durata ()
	{
		this(NULL_TIME, NULL_TIME, NULL_TIME);
	}
	
	/**
	 * Normalizza la durata, ossia fa in modo che ci siano max 59 min e 59 secondi
	 */
	private void normalize ()
	{
		minuti += secondi / SECONDI_PER_MINUTO;
		secondi %= SECONDI_PER_MINUTO;
		
		ore += minuti / MINUTI_PER_ORA;
		minuti %= MINUTI_PER_ORA;
	}
	
	/**
	 * Crea una durata dei secondi specificati
	 * @param secondi Secondi di durata
	 */
	public Durata (long secondi)
	{
		this.secondi = secondi;
		this.minuti = NULL_TIME;
		this.ore = NULL_TIME;
		normalize();
	}
	
	/**
	 * Crea una durata specificando minuti e secondi
	 * @param minuti Minuti di durata
	 * @param secondi Secondi di durata
	 */
	public Durata (long minuti, long secondi)
	{
		this(secondi);
		this.minuti += minuti;
		this.ore = NULL_TIME;
		normalize();
	}
	
	/**
	 * Crea una durata specificando ore, minuti e secondi
	 * @param ore Ore di durata
	 * @param minuti Minuti di durata
	 * @param secondi Secondi di durata
	 */
	public Durata (long ore, long minuti, long secondi)
	{
		this(minuti, secondi);
		this.ore += ore;
		normalize();
	}
	
	/**
	 * Ritorna i secondi di durata
	 * @return Secondi
	 */
	public long getSecondi ()
	{
		return secondi;
	}
	
	/**
	 * Ritorna i minuti di durata
	 * @return Minuti
	 */
	public long getMinuti ()
	{
		return minuti;
	}
	
	/**
	 * Ritorna le ore di durata
	 * @return Ore
	 */
	public long getOre ()
	{
		return ore;
	}
	
	/**
	 * Converte la durata in secondi
	 * @return Secondi totali
	 */
	public long toSecondi()
	{
		return secondi + minuti*SECONDI_PER_MINUTO + ore*SECONDI_PER_ORA;
	}
	
	/**
	 * Converte la durata in minuti
	 * @return Minuti totali
	 */
	public long toMinuti()
	{
		return minuti + ore*MINUTI_PER_ORA;
	}
	
	/**
	 * Converte la durata in ore
	 * @return Ore totali
	 */
	public long toOre()
	{
		return ore;
	}
	
	/**
	 * Ritorna una stringa contenente la durata nel formato specificato
	 * @param format Formato. Segnaposti: sec[secondi] min[minuti] ore[ore]
	 * @return Stringa che descrive la durata
	 */
	public String toString (String format)
	{
		String s, m, o;
		
		s = String.format(TIME_FORMAT, secondi);
		m = String.format(TIME_FORMAT, minuti);
		o = String.format(TIME_FORMAT, ore);
		
		String ris = new String(format);
		
		ris = ris.replaceAll(ORE_PLACEHOLDER, o);
		ris = ris.replaceAll(MIN_PLACEHOLDER, m);
		ris = ris.replaceAll(SEC_PLACEHOLDER, s);
		
		return ris;
	}
	
	@Override
	/**
	 * Ritorna una stringa contenente la durata
	 * @return Stringa che descrive la durata
	 */
	public String toString ()
	{
		if (ore > 0)
			return toString(DEFAULT_FORMAT);
		else if (ore <= 0 && minuti > 0)
			return toString(DEFAULT_FORMAT_MIN_SEC);
		else
			return toString(DEFAULT_FORMAT_SEC);
	}
}
