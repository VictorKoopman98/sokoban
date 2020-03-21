package domein;

import domein.Veld;

public class Spelbord {
	
	private boolean isVoltooid;
	private int aantalVerplaatsingen;
	private int locatieMan;
	Veld[][] bord = new Veld[10][10];
	Veld[] kisten;
	Man man;
	

	public Spelbord() 
	{
		
	}
	

	public Veld[] getKistenVeld()         //geef een lijst of array met alle objecten van de klasse kist in
	                                      //steek voor elk object de returnwaarde van de methode getVeld in de array'kisten'
	{
		return kisten;
	}
	
	public Man getMan() 
	{
		return man;
	}
	
	
	public Veld[][] getSpelbord() 
	{
		return bord;
	} 
	
	
	public int getAantalVerplaatsingen() 
	{
		return this.aantalVerplaatsingen;
	}
	
	public boolean getIsVoltooid()
	{
		return this.isVoltooid;
	}

}