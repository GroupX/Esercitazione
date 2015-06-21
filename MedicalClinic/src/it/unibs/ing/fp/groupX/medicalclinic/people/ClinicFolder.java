package it.unibs.ing.fp.groupX.medicalclinic.people;

import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathology;
import it.unibs.ing.fp.groupX.medicalclinic.visit.Report;
import it.unibs.ing.fp.groupX.myutil.BasicIterable;
import it.unibs.ing.fp.groupX.myutil.BasicIterator;
import it.unibs.ing.fp.groupX.myutil.IOLib;
import it.unibs.ing.fp.groupX.myutil.MyMenu;
import it.unibs.ing.fp.groupX.myutil.Readable;
import it.unibs.ing.fp.groupX.myutil.Useable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

/**
 * Classe che implementa una cartella clinica
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
@SuppressWarnings("serial")
public class ClinicFolder implements BasicIterable<Report>, Useable, Readable, Serializable
{
	private static final String READ_MSG = "Usa il menù per popolare la cartella, poi seleziona esci: ";

	/** Intestazione di stampa */
	private static final String PRINT_HEADER = "Elenco referti:";
	
	/** Elenco diagnosi */
	private ArrayList<Report> reports;
	
	/**
	 * Metodo factory che crea una cartella clinica leggedola dalla console
	 * @return La cartella letta
	 */
	public static ClinicFolder readFromConsole ()
	{
		ClinicFolder ris = new ClinicFolder();
		
		ris.read();
		
		return ris;
	}
	
	/**
	 * Costruttore default
	 */
	public ClinicFolder ()
	{
		reports = new ArrayList<Report>();
	}
	
	/**
	 * Costruttore copia
	 * @param fol
	 * 			Cartella clinica da copiare
	 */
	public ClinicFolder (ClinicFolder fol)
	{
		this();
		for (Report r : fol.toArray())
		{
			reports.add(r);
		}
	}
	
	/**
	 * Aggiunge un referto all'elenco
	 * @param pathologyName
	 * 				Nome patologia da aggiungere
	 * @return true: patologia aggiunta; false: altrimenti
	 */
	public boolean add (Report r)
	{
		try
		{
			reports.add(r);
			return true;
		}
		catch (IllegalArgumentException e)
		{
			return false;
		}
	}
	
	/**
	 * Ritorna il referto
	 * @param index
	 * 				indice del referto
	 * @return report indicato
	 * @throws IndexOutOfBoundsException
	 * 				indice non valido
	 */
	public Report get (int index) throws IndexOutOfBoundsException
	{
		return reports.get(index);
	}
	
	/**
	 * Ritorna tutti i referti con la patologia passata
	 * @param p
	 * 			patologia da cercare
	 * @return ArrayList di Report contenenti la patologia
	 */
	public ArrayList<Report> get (Pathology p)
	{
		ArrayList<Report> ris = new ArrayList<Report>();
		
		for (Report r: reports)
		{
			if (r.getDiagnosis().hasPathology(p))
				ris.add(r);
		}
		
		return ris;
	}
	
	/**
	 * Ritorna tutti i referti effettuati in data passata
	 * @param d
	 * 			data da cercare
	 * @return ArrayList di Report in data d
	 */
	public ArrayList<Report> get (Date d)
	{
		ArrayList<Report> ris = new ArrayList<Report>();
		
		for (Report r: reports)
		{
			if (r.inDate(d))
				ris.add(r);
		}
		
		return ris;
	}
	
	/**
	 * Ritorna un array di tutti i referti nella cartella clinica
	 * @return array di referti
	 */
	public Report[] toArray ()
	{
		Report[] r = new Report[reports.size()];
		return reports.toArray(r);
	}
	
	/**
	 * Override di toString
	 * @return stringa descrittiva dell'oggetto
	 */
	@Override
	public String toString() {
		StringBuffer str = new StringBuffer();
		
		str.append(PRINT_HEADER);
		for (Report r : reports)
		{
			str.append("\n"+r.toString());
		}
		
		return str.toString();
	}

	@Override
	public Iterator<Report> iterator() {
		return new BasicIterator<>(this);
	}

	@Override
	public int size() {
		return reports.size();
	}

	@Override
	public void use() {
		final int INSERT_REPORT_CHOICE = 1;
		final int PRINT_FOLDER_CHOICE = 2;
		
		// TODO constants
		MyMenu menu = new MyMenu("Gestione cartella clinica: ", "Inserisci referto", "Stampa cartella clinica");
		
		int scelta;
		
		while ((scelta = menu.getChoice()) != MyMenu.EXIT_VALUE)
		{
			switch (scelta)
			{
			case INSERT_REPORT_CHOICE:
				this.add(Report.readFromConsole());
				break;
			case PRINT_FOLDER_CHOICE:
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
