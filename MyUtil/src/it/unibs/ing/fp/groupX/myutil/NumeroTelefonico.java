package it.unibs.ing.fp.groupX.myutil;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Classe che rappresenta un numero telefonico
 * @author Gruppo X (Manuel Mazzardi, Paolo Pasquali, Davide Tosatto)
 *
 */
public class NumeroTelefonico {
	/** Simbolo che separa il prefisso dal numero **/
	private static final String SEPARATORE_PREFISSO = " ";
	/** Simbolo che precede il prefisso **/
	private static final String SIMBOLO_PREFISSO = "+";
	/** Lista contenente le cifre del numero **/
	private ArrayList<Byte> cifre;
	/** Lista contenente il prefisso **/
	private ArrayList<Byte> prefisso;
	
	/**
	 * Crea un numero dato prefisso e cifre del numero. Il prefisso può essere null, in tal caso sarà un numero senza prefisso
	 * @param prefisso Lista contenente le cifre del prefisso
	 * @param cifre Lista contenente le cifre del numero
	 */
	public NumeroTelefonico (Collection<Byte> prefisso, Collection<Byte> cifre)
	{
		this.cifre = new ArrayList<Byte>(cifre);
		if (prefisso != null)
			this.prefisso = new ArrayList<Byte>(prefisso);
		else
			this.prefisso = new ArrayList<Byte>();
	}
	
	/**
	 * Crea un numero telefonico partendo da una stringa.
	 * Ignora i caratteri non numerici. Si considerano prefisso le cifre che precedono il primo spazio, numero tutte le cifre seguente.
	 * (Gli spazi seguenti al primo sono ignorati)
	 * @param num Stringa descrittiva del numero
	 */
	public NumeroTelefonico(String num) 
	{
		num = num.trim(); //Rimuove eventuali blanks in testa e in coda alla stringa
		StringBuffer numBuf = new StringBuffer(num);
		
		ArrayList<Byte> prefisso = new ArrayList<>();
		ArrayList<Byte> cifre = new ArrayList<>();
		
		boolean afterPrefix = !num.contains(SEPARATORE_PREFISSO);
		
		for (int i = 0; i < numBuf.length(); i++)
		{
			String act = numBuf.substring(i, i+1);
			
			if (Character.isDigit(act.charAt(0)))
			{
				if (afterPrefix)
				{
					cifre.add(Byte.valueOf(act));
				}
				else
				{
					prefisso.add(Byte.valueOf(act));
				}
			}
			else if (act.equals(SEPARATORE_PREFISSO))
			{
				afterPrefix = true;
			}
		}
		
		this.cifre = cifre;
		this.prefisso = prefisso;
	}
	
	/**
	 * Ritorna un array contenente le cifre del prefisso
	 * @return array contenente le cifre del prefisso
	 */
	Byte[] getPrefisso ()
	{
		Byte[] ris = new Byte[prefisso.size()];
		return prefisso.toArray(ris);
	}
	
	/**
	 * Ritorna un array contenente le cifre del numero senza prefisso
	 * @return array contenente le cifre del numero senza prefisso
	 */
	Byte[] getCifre ()
	{
		Byte[] ris = new Byte[cifre.size()];
		return cifre.toArray(ris);
	}
	
	/**
	 * Ritorna un array contenente tutte le cifre del numero
	 * @return array contenente tutte le cifre del numero
	 */
	Byte[] getAll ()
	{
		Byte[] ris = new Byte[cifre.size() + prefisso.size()];
		ArrayList<Byte> sum = new ArrayList<Byte>(prefisso);
		sum.addAll(cifre);
		return sum.toArray(ris);
	}
	
	@Override
	public String toString() {
		StringBuffer ris = new StringBuffer();
		
		if(!(prefisso.size()==0))
			ris.append(SIMBOLO_PREFISSO);
		
		for (byte cifra: prefisso)
		{
			ris.append(cifra);
		}
		
		if(!(prefisso.size()==0))
			ris.append(SEPARATORE_PREFISSO);
		
		for (byte cifra: cifre)
		{
			ris.append(cifra);
		}
		
		return ris.toString();
	}
}
