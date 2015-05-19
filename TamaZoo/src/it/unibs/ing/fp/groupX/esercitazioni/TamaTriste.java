package it.unibs.fp.tamazoo;

public class TamaTriste extends Tamagotchi

{

	public TamaTriste(String nome, int sazieta, String nomeTipo)
	{
		super(nome,0,sazieta,nomeTipo);
	}
	
	public void riceviCarezze(int numCarezze)
	{
		setGradoSaziet� (Math.max(0, getGradoSaziet�() - numCarezze/FATTORE_CAREZZE));
	}
	
	public void riceviBiscotti(int numBiscotti)
	{
		for (int i = 1; i <= numBiscotti; i++)
		{
			setGradoSaziet� (Math.min(getGradoSaziet�()*INCREMENTO_BISCOTTO,MAX_SAZIETA));
		}
		
	}
	
	public boolean sonoMorto ()
	{
		return getGradoSaziet�() == 0 || getGradoSaziet�() == MAX_SAZIETA; 
	}
	
	public boolean sonoTriste ()
	{
		return true; 
	}
}
