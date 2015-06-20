package it.unibs.ing.fp.groupX.medicalclinic.time;

import java.util.ArrayList;

public class StaffMemberAvailability {
	/** Messaggio errore inserimento con slot già presente */
	public static final String ADD_REDUNDACY_ERROR = "Slot già presente";
	/** Messaggio errore rimozione con slot non presente */
	public static final String REMOVE_NOT_FOUND_ERROR = "Slot non presente";
	
	/** Intestazione stampa */
	private static final String PRINT_HEADER = "%s";
	/** Separatore stampa tra gli slot */
	private static final String SLOT_SEPARATOR = "\n";
	
	/** Giorno */
	private WeekDay day;
	/** Orari disponibili */
	private ArrayList<AvailabilitySlot> slots = new ArrayList<AvailabilitySlot>();
	
	/**
	 * Costruttore
	 * @param day
	 * 			giorno
	 */
	public StaffMemberAvailability (WeekDay day)
	{
		this.day = day;
	}
	
	/**
	 * aggiunge uno slot
	 * @param s
	 * 			slot da aggiungere
	 * @throws IllegalArgumentException slot già presente
	 */
	public void addSlot (AvailabilitySlot s) throws IllegalArgumentException
	{
		if (slots.contains(s))
		{
			IllegalArgumentException e = new IllegalArgumentException(ADD_REDUNDACY_ERROR);
			throw e;
		}
		else
		{
			slots.add(s);
		}
	}
	
	/**
	 * Rimuove lo slot indicato
	 * @param index
	 * 				indice dello slot da rimuovere
	 * @throws IndexOutOfBoundsException indice non valido
	 */
	public void removeSlot (int index) throws IndexOutOfBoundsException
	{
		slots.remove(index);
	}
	
	/**
	 * Rimuove lo slot indicato
	 * @param s
	 * 			slot da rimuovere
	 * @throws IllegalArgumentException Slot non trovato
	 */
	public void removeSlot (AvailabilitySlot s) throws IllegalArgumentException
	{
		if (!slots.contains(s))
		{
			IllegalArgumentException e = new IllegalArgumentException(REMOVE_NOT_FOUND_ERROR);
			throw e;
		}
		else
		{
			slots.remove(s);
		}
	}
	
	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		
		s.append(String.format(PRINT_HEADER, day.getName()));
		
		for (AvailabilitySlot a : slots)
		{
			s.append(SLOT_SEPARATOR + a.toStringShort());
		}
		
		return s.toString();
	}
}
