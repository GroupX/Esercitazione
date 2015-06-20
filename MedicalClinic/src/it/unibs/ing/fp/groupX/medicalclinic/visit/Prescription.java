package it.unibs.ing.fp.groupX.medicalclinic.visit;

import it.unibs.ing.fp.groupX.myutil.BasicIterable;
import it.unibs.ing.fp.groupX.myutil.BasicIterator;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;
import it.unibs.ing.fp.groupX.myutil.Readable;
import it.unibs.ing.fp.groupX.myutil.Useable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe che definisce le prescrizioni
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class Prescription implements BasicIterable<PrescriptionEntry>, Useable, Readable{
	
	private static final String READ_MSG = "Usa il menu per popolare la prescrizione, poi seleziona esci: ";
	private static final String LIST_HEAD = "Prescrizione: ";
	private static final String NOT_PRESENT_REMEDY_MSG = "Rimedio non presente";
	private static final String ALREADY_PRESENT_REMEDY_MSG = "Rimedio già presente";
	/**Lista dei rimedi proposti*/
	private List<PrescriptionEntry> entries = new ArrayList<>();
	
	/**
	 * Metodo factory che crea una prescrizione leggendola dalla console
	 * @return La prescrizione letta
	 */
	public static Prescription readFromConsole ()
	{
		Prescription ris = new Prescription();
		
		ris.read();
		
		return ris;
	}
	
	/**
	 * Costruttore senza parametri
	 */
	public Prescription ()
	{
		
	}
	
	/**
	 * Costruttore con lista di rimedi
	 * @param pe Lista dei rimedi
	 */
	public Prescription (PrescriptionEntry ... pe)
	{
		for (PrescriptionEntry p : pe)
		{
			entries.add(p);
		}
	}
	
	public boolean contains (PrescriptionEntry pe)
	{
		return entries.contains(pe);
	}
	
	/**
	 * Aggiunge un rimedio alla lista
	 * @param pe Rimedio da aggiungere
	 */
	public void addEntry (PrescriptionEntry pe)
	{
		if (this.contains(pe))
			throw new IllegalArgumentException(ALREADY_PRESENT_REMEDY_MSG);
		
		entries.add(pe);
	}
	
	/**
	 * Aggiunge un rimedio alla lista
	 * @param pe Rimedio da aggiungere
	 */
	public void removeEntry (PrescriptionEntry pe)
	{
		if (!this.contains(pe))
			throw new IllegalArgumentException(NOT_PRESENT_REMEDY_MSG);
		
		entries.remove(pe);
	}
	
	/**
	 * Ritrona il numero di rimedi presenti
	 * @return numero di rimedi presenti
	 */
	public int size()
	{
		return entries.size();
	}
	
	/**
	 * Ritorna un elemento della prescrizione
	 * @param index Indice dell'elemento
	 * @return elemento richiesto
	 */
	public PrescriptionEntry get (int index)
	{
		if (index < 0 || index >= entries.size())
			throw new IndexOutOfBoundsException("Indice fuori dai limiti");
		
		return entries.get(index);
	}
	
	@Override
	public String toString ()
	{
		StringBuffer strBuff = new StringBuffer();
		
		strBuff.append(LIST_HEAD + "\n");
		
		for (PrescriptionEntry pe: this)
		{
			strBuff.append(pe.toString() + "\n");
		}
		
		strBuff.delete(strBuff.length() - 1, strBuff.length());
		return strBuff.toString();
	}

	@Override
	public Iterator<PrescriptionEntry> iterator() {
		return new BasicIterator<>(this);
	}

	@Override
	public void use() {
		
		final int INSERT_REMEDY_CHOICE = 1;
		final int REMOVE_REMEDY_CHOICE = 2;
		final int PRINT_PRESCRIPTION_CHOICE = 3;
		
		// TODO constants
		MyMenu menu = new MyMenu("Gestione prescrizione: ", "Inserisci rimedio", "Rimuovi rimedio", "Stampa prescrizione");
		
		int scelta;
		
		while ((scelta = menu.getChoice()) != MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
			case INSERT_REMEDY_CHOICE:
				try
				{
					this.addEntry(PrescriptionEntry.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			case REMOVE_REMEDY_CHOICE:
				try
				{
					this.removeEntry(PrescriptionEntry.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			case PRINT_PRESCRIPTION_CHOICE:
				IOLib.printLine(this.toString());
				break;
			}
		}
		
	}

	@Override
	public void read() {
		
		IOLib.printLine(READ_MSG);
		this.use();
	}
	
	
	
}
