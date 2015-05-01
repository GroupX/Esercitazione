package it.unibs.ing.fp.groupX.esercitazioni;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

import it.unibs.ing.fp.groupX.myutil.*;

public class ArchivioMain
{
	private final static String VOCE1 = "Voce1";
	private final static int INDICE_VOCE1 = 1;
	public static void main (String[] args)
	{
		// TODO Auto-generated method stub
		//MyMenu mn = new MyMenu("Titolo", "Voce1", "Voce2", "Voce3");
		
		//mn.getChoice ();
		
		Durata d = IOLib.readDuration("Porco dio:");
		IOLib.printDuration(d);
		
	}

}
