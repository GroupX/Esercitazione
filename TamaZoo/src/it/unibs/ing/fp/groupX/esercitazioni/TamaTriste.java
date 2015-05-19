package it.unibs.fp.tamazoo;

public class TamaTriste extends Tamagotchi

{

	public TamaTriste(String nome, int sazieta, String nomeTipo)
	{
		super(nome,0,sazieta,nomeTipo);
	}
	
	public void riceviCarezze(int numCarezze)
	{
		setGradoSazietà (Math.max(0, getGradoSazietà() - numCarezze/FATTORE_CAREZZE));
	}
	
	public void riceviBiscotti(int numBiscotti)
	{
		for (int i = 1; i <= numBiscotti; i++)
		{
			setGradoSazietà (Math.min(getGradoSazietà()*INCREMENTO_BISCOTTO,MAX_SAZIETA));
		}
		
	}
	
	public boolean sonoMorto ()
	{
		return getGradoSazietà() == 0 || getGradoSazietà() == MAX_SAZIETA; 
	}
	
	public boolean sonoTriste ()
	{
		return true; 
	}
}
