package it.unibs.ing.fp.medagliere;

public enum WinDegree
{
	GOLD (0), SILVER (1), BRONZE (2), NONE (-1);
	
	private int index;
	
	private WinDegree (int index)
	{
		this.index = index;
	}
	
	public int getIndex ()
	{
		return index;
	}
}
