package domein;

public class Man {

	private Veld veld;
	private Veld oorspronkelijkVeld;
	

	public void setVeld(Veld veld)  //Methode om het veld voor een man in te stellen, @param veld object van de klasse veld waarop de man moet staan
	{
		this.veld = veld;
	}
	
	
	public void setOorspronkelijkVeld(Veld veld) 
	{
		this.oorspronkelijkVeld = veld;
	}
	
	
	public Veld getOorspronkelijkVeld() 
	{
		return oorspronkelijkVeld;
	}
	
	
	public Veld getVeld()   //Methode om het veld waarop een man staat terug te geven, @return geeft het veld terug waarop een man staat
	{
		return veld;
	}

}