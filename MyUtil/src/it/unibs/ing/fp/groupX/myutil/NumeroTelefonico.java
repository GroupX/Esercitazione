package it.unibs.ing.fp.groupX.myutil;

import java.util.ArrayList;

public class NumeroTelefonico {
	private static final String SEPARATORE_PREFISSO = " ";
	private static final String SIMBOLO_PREFISSO = "+";
	private byte[] cifre;
	private byte[] prefisso;
	
	public NumeroTelefonico (byte[] prefisso, byte[] cifre)
	{
		this.cifre = cifre.clone();
		this.prefisso = prefisso.clone();
	}
	
	public NumeroTelefonico(String num) 
	{
		StringBuffer numBuf = new StringBuffer(num);
		
		ArrayList<Byte> prefisso = new ArrayList<>();
		ArrayList<Byte> cifre = new ArrayList<>();
		
		boolean afterPrefix = num.contains(SEPARATORE_PREFISSO);
		
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
		
		this.cifre = (byte[])cifre.toArray();
	}
	
	@Override
	public String toString() {
		StringBuffer ris = new StringBuffer();
		
		if(!(prefisso.length==0))
			ris.append(SIMBOLO_PREFISSO);
		
		for (byte cifra: prefisso)
		{
			ris.append(cifra);
		}
		
		ris.append(SEPARATORE_PREFISSO);
		
		for (byte cifra: cifre)
		{
			ris.append(cifra);
		}
		
		return ris.toString();
	}
}
