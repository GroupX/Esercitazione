package it.unibs.ing.fp.groupX.medagliere;

public class Risultato
{
	private final static int NUM_WINNERS = 3;
	
	
	private Nazione[] winners = new Nazione[NUM_WINNERS];
	private WinDegree indexs;
	
	public Risultato (Nazione gold, Nazione silver, Nazione bronze)
	{
		winners[WinDegree.GOLD.getIndex()] = gold;
		winners[WinDegree.SILVER.getIndex()] = silver;
		winners[WinDegree.BRONZE.getIndex()] = bronze;
	}
	
	public Nazione getGold ()
	{
		return winners[WinDegree.GOLD.getIndex()];
	}
	
	public Nazione getSilver ()
	{
		return winners[WinDegree.SILVER.getIndex()];
	}
	
	public Nazione getBronze ()
	{
		return winners[WinDegree.BRONZE.getIndex()];
	}
}