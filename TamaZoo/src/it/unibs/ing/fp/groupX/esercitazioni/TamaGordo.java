package it.unibs.ing.fp.groupX.esercitazioni;

public class TamaGordo extends Tamagotchi

{
	private final static int AMPLIFICAZIONE_CAREZZE = 2;

	public TamaGordo(String nome, int sazieta, String nomeTipo)
	{
		super(nome,MAX_AFFETTO,sazieta,nomeTipo);
	}
	
	public void riceviCarezze(int numCarezze)
	{
		setGradoSaziet� (Math.max(0, getGradoSaziet�() - (AMPLIFICAZIONE_CAREZZE*numCarezze/FATTORE_CAREZZE)));
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
		return getGradoSaziet�() == 0; 
	}
	
	public boolean sonoTriste ()
	{
		return  getGradoSaziet�() < SOGLIA_SAZIETA_BASSA ; 
	}
}
