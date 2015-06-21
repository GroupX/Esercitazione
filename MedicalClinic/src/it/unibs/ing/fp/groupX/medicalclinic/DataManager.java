package it.unibs.ing.fp.groupX.medicalclinic;

import it.unibs.ing.fp.groupX.medicalclinic.pathologies.Pathologies;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DataManager
{
	private static final String PATHOLOGIES_FILE_NAME = "pathologies.dat";
	
	public static void savePathologies () throws FileNotFoundException, IOException
	{
		File f = new File(PATHOLOGIES_FILE_NAME);

		ObjectOutputStream archivio = new ObjectOutputStream(
		new BufferedOutputStream(
		new FileOutputStream(f)));

		archivio.writeObject(Pathologies.get());
	}
}
