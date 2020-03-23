package domein;

public class Kist 
{
	
	private Veld veld;
	private Veld oorspronkelijkVeld;

	
	public void setVeld(Veld veld)   //Methode om het veld voor een kist in te stellen, @param veld object van de klasse veld waarop de kist moet staan
	{
		this.veld = veld;
	}
	
	
	public Veld getVeld()  //Methode om het veld waarop een kist staat terug te geven, @return geeft het veld terug waarop een kist staat
	{
		return veld;
	}
	public void setOorspronkelijkVeld(Veld veld) {
		this.oorspronkelijkVeld = veld;
	}
	
	public Veld getOorspronkelijkVeld() {
		return oorspronkelijkVeld;
	}

}