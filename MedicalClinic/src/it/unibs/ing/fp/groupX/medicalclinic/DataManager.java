package it.unibs.ing.fp.groupX.medicalclinic;

import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathologies;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DataManager
{
	private static final String PATHOLOGIES_FILE_NAME = "pathologies.dat";
	private static final String CLINIC_FILE_NAME = "clinic.dat";
	
	public static void savePathologies () throws FileNotFoundException, IOException
	{
		File f = new File(PATHOLOGIES_FILE_NAME);

		ObjectOutputStream archivio = new ObjectOutputStream(
		new BufferedOutputStream(
		new FileOutputStream(f)));

		archivio.writeObject(Pathologies.get());
		
		archivio.close();
	}
	
	public static void loadPathologies () throws FileNotFoundException, IOException, ClassNotFoundException
	{
		File f = new File(PATHOLOGIES_FILE_NAME);
		
		ObjectInputStream sorgente = new ObjectInputStream(
				new BufferedInputStream(
				new FileInputStream(f)));
		
		Pathologies.setPathologies((Pathologies)sorgente.readObject());
		
		sorgente.close();
	}
	
	public static void saveClinic (Clinic c) throws FileNotFoundException, IOException
	{
		File f = new File(CLINIC_FILE_NAME);

		ObjectOutputStream archivio = new ObjectOutputStream(
		new BufferedOutputStream(
		new FileOutputStream(f)));

		archivio.writeObject(c);
		
		archivio.close();
	}
	
	public static Clinic loadClinic () throws FileNotFoundException, IOException, ClassNotFoundException
	{
		Clinic ris = null;
		File f = new File(CLINIC_FILE_NAME);
		
		ObjectInputStream sorgente = new ObjectInputStream(
				new BufferedInputStream(
				new FileInputStream(f)));
		
		ris = (Clinic)sorgente.readObject();
		
		sorgente.close();
		
		return ris;
	}
}
