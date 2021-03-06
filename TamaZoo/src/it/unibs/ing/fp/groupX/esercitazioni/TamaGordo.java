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
		setGradoSazietā (Math.max(0, getGradoSazietā() - (AMPLIFICAZIONE_CAREZZE*numCarezze/FATTORE_CAREZZE)));
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
		return getGradoSazietā() == 0; 
	}
	
	public boolean sonoTriste ()
	{
		return  getGradoSazietā() < SOGLIA_SAZIETA_BASSA ; 
	}
}
