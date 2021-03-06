package it.unibs.ing.fp.groupX.esercitazioni;

public class TamaTriste extends Tamagotchi

{

	public TamaTriste(String nome, int sazieta, String nomeTipo)
	{
		super(nome,0,sazieta,nomeTipo);
	}
	
	public void riceviCarezze(int numCarezze)
	{
		setGradoSazietā (Math.max(0, getGradoSazietā() - numCarezze/FATTORE_CAREZZE));
	}
	
	public void riceviBiscotti(int numBiscotti)
	{
		for (int i = 1; i <= numBiscotti; i++)
		{
			setGradoSazietā (Math.min(getGradoSazietā()*INCREMENTO_BISCOTTO,MAX_SAZIETA));
		}
		
	}
	
	public boolean sonoMorto ()
	{
		return getGradoSazietā() == 0 || getGradoSazietā() == MAX_SAZIETA; 
	}
	
	public boolean sonoTriste ()
	{
		return true; 
	}
}
