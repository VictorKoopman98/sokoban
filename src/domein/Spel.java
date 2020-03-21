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

	
<<<<<<< HEAD
	public boolean isSpelbordVoltooid() {
		if (Spelbord.isVoltooid)
=======
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
>>>>>>> branch 'master' of https://github.com/HoGentTIProjecten1/sokoban-g39.git
		
	}
	
	
	public int getAantalSpelbordenVoltooid()
	{
		return aantalSpelbordenVoltooid;
	}
}