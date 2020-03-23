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
		return spelbord.getIsVoltooid();
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
	

	public void verplaatsMan(String richting) {
		spelbord.verplaatsMan(richting);
	}
	
	
	public Veld[][] geefSpelbord() {
		return spelbord.getSpelbord();
	}
	
	
	public char[][] toonSpelbord(){
		return spelbord.toonSpelbord();
	}
	
	
	public Kist[] geefKisten() {
		return spelbord.getKisten();
	}
	
	
	public Man geefMan() 
	{
		return spelbord.getMan();
	}
	
	
	public int getAantalSpelbordenVoltooid()
	{
		return aantalSpelbordenVoltooid;
	}
}