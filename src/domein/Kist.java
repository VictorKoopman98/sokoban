package domein;

public class Kist {
	
	private char karakter;
	private Veld veld;

	/**
     * Methode om het veld voor een kist in te stellen
     * @param veld object van de klasse veld waarop de kist moet staan
     */
	public void setVeld(Veld veld)
	{
		this.veld = veld;
	}
	/**
     * Methode om het veld waarop een kist staat terug te geven
     * @return geeft het veld terug waarop een kist staat
     */
	public Veld getVeld()
	{
		return veld;
	}
	
	/*
	 * Methode om karakter van de kist in te stellen
	 */
	
	public void setKarakter(char karakter)
	{
		this.karakter = karakter;
	}
	
	
	/*
	 * Methode om de karakter waarp een kist staat terug te geven
	 * geeft karakter terug van de kist
	 */ 
	public char getKarakter()
	{
		return karakter;
	}

}