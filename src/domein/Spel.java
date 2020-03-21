package domein;

import domein.Spelbord;

public class Spel {
	
	private String naam;
	private int aantalSpelborden = 0;
	private int aantalSpelbordenVoltooid = 0;
	Spelbord spelbord = new Spelbord();

	
	public Spel() 
	{
		// TODO Auto-generated constructor stub
	}

	
	public boolean isSpelbordVoltooid() 
	{
		if(spelbord.getIsVoltooid() == true)
		{
			return true;
		}
		return false;
	}
	
	
	public int geefAantalVerplaatsingen()
	{
		return spelbord.getAantalVerplaatsingen();
	}
	
	
	public String getNaam()
	{
		return naam;
	}
	
	
	public int getAantalSpelborden()
	{
		return aantalSpelborden;
		
	}
	
	public Spelbord geefSpelbord() {
		return spelbord;
	}
	
	
	public int getAantalSpelbordenVoltooid()
	{
		return aantalSpelbordenVoltooid;
	}
}