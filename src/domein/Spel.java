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
		return false;	
	}
	
	
	public String getNaam()
	{
		return naam;
	}
	
	
	public int getAantalSpelborden()
	{
		return aantalSpelborden;
		
	}
	
	
	public int getAantalSpelbordenVoltooid()
	{
		return aantalSpelbordenVoltooid;
	}
}