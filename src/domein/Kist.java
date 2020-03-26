package domein;

public class Kist 
{
	private Veld veld;
	
	public Kist(Veld veld) 
	{
		setVeld(veld);
	}
	
	
	public void setVeld(Veld veld)   //Methode om het veld voor een kist in te stellen, @param veld object van de klasse veld waarop de kist moet staan
	{
		this.veld = veld;
	}
	
	
	public Veld getVeld()  //Methode om het veld waarop een kist staat terug te geven, @return geeft het veld terug waarop een kist staat
	{
		return veld;
	}

}