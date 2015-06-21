package it.unibs.ing.fp.groupX.medicalclinic.visit;

import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathologies;
import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathology;
import it.unibs.ing.fp.groupX.myutil.BasicIterable;
import it.unibs.ing.fp.groupX.myutil.BasicIterator;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;
import it.unibs.ing.fp.groupX.myutil.Readable;
import it.unibs.ing.fp.groupX.myutil.Useable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe che implementa una diagnosi
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class Diagnosis implements BasicIterable<Pathology>, Useable, Readable, Serializable {
	
	private static final String READ_MESSAGE = "Popola la diagnosi usando il menu, poi scegli esci: ";
	private static final String LIST_HEAD = "Elenco patologie riscontrate: ";
	private static final String NOT_PRESENT_PATHOLOGY_MSG = "Patologia non presente";
	private static final String ALREADY_INSERTED_MSG = "Patologia già inserita";
	/** Patologie sofferte */
	private List<Pathology> pList = new ArrayList<Pathology>();
	
	/**
	 * Metodo factory che crea una diagnosi leggendola da console
	 * @return Diagnosi letta
	 */
	public static Diagnosis readFromConsole ()
	{
		Diagnosis ris = new Diagnosis();
		
		ris.read();
		
		return ris;
	}
	
	/**
	 * Costruttore senza parametri
	 */
	public Diagnosis ()
	{
		
	}
	
	/**
	 * Costruttore con insieme di patologie
	 * @param pathologies Elenco patologie
	 * @throws IllegalArgumentException Una patologia è inesistente
	 */
	public Diagnosis (String ... pathologies) throws IllegalArgumentException
	{
		for (String pName :pathologies)
		{
			this.addPathology(pName);
		}
	}
	
	/**
	 * Costruttore con insieme di patologie
	 * @param pathologies Elenco di patologie
	 */
	public Diagnosis (Pathology ... pathologies)
	{
		for (Pathology p :pathologies)
		{
			this.addPathology(p);
		}
	}
	
	/**
	 * Dice se una patologia è contenuta 
	 * @param p Patologia da cercare
	 * @return true: presente false: non presente
	 */
	public boolean contains (Pathology p)
	{
		return pList.contains(p);
	}
	
	/**
	 * Aggiunge una patologia
	 * @param p Patologia da aggiungere
	 */
	public void addPathology (Pathology p)
	{
		if (this.contains(p))
			throw new IllegalArgumentException(ALREADY_INSERTED_MSG);
		
		this.pList.add(p);
	}
	
	/**
	 * Aggiunge una patologia
	 * @param pathologyName Nome della patologia
	 * @throws IllegalArgumentException Patologia inesistente
	 */
	public void addPathology (String pathologyName) throws IllegalArgumentException
	{
		this.pList.add(Pathologies.get().get(pathologyName));
	}
	
	/**
	 * Rimuove una patologia
	 * @param p Patologia da rimuovere
	 */
	public void removePathology (Pathology p)
	{
		if (!this.contains(p))
			throw new IllegalArgumentException(NOT_PRESENT_PATHOLOGY_MSG);
		
		this.pList.remove(p);
	}
	
	/**
	 * Ritorna la patologia richiesta
	 * @param index Indice
	 * @return Patologia richiesta
	 */
	public Pathology get(int index) {
		return pList.get(index);
	}

	/**
	 * Ritorna il numero di patologie inserite
	 * @return Numero di patologie
	 */
	public int size()
	{
		return pList.size();
	}
	
	/**
	 * Controlla se la diagnosi è sulla patologia passata
	 * @param p
	 * 			patologia da controllare
	 * @return true: patologia corretta; false: altrimenti
	 */
	public boolean hasPathology (Pathology p)
	{
		return this.pList.contains(p);
	}

	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		
		buf.append(LIST_HEAD + "\n");
		
		for (Pathology p : this)
		{
			buf.append(p.toString() + "\n");
		}
		
		buf.delete(buf.length() - 1, buf.length());
		
		return buf.toString();
	}

	@Override
	public Iterator<Pathology> iterator() {
		return new BasicIterator<>(this);
	}

	@Override
	public void use() {
		
		final int INSERT_PATHOLOGY_CHOICE = 1;
		final int REMOVE_PATHOLOGY_CHOICE = 2;
		final int PRINT_DIAGNOSIS_CHOICE = 3;
		
		// TODO constants
		MyMenu menu = new MyMenu("Gestione diagnosi: ", "Inserisci patologia", "Rimuovi patologia", "Stampa diagnosi");
		
		int scelta;
		
		while ((scelta = menu.getChoice()) != MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
			case INSERT_PATHOLOGY_CHOICE:
				try
				{
					this.addPathology(Pathology.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			case REMOVE_PATHOLOGY_CHOICE:
				try
				{
					this.removePathology(Pathology.readFromConsole());
				}
				catch (IllegalArgumentException e)
				{
					IOLib.printLine(e.getMessage());
				}
				break;
			case PRINT_DIAGNOSIS_CHOICE:
				IOLib.printLine(this.toString());
				break;
			}
		}
		
	}

	@Override
	public void read() {

		IOLib.printLine(READ_MESSAGE);
		
		this.use();
		
	}
}
