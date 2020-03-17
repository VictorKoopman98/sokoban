package domein;

import java.util.List;

import domein.Spelbord;

public class Spel {
	
	private String naam;
	private int spelId;
	private int aantalSpelborden;
	private int aantalSpelbordenVoltooid;
	private List<Spelbord> spelborden;
	private Spelbord spelbord;
	

	
	/** 
	 * Constructor om een spel aan te maken
	 * @param naam de naam van het spel
	 * @param aantalSpelborden
	 * @param aantalSpelbordenVoltooid
	 */
	
	
	public Spel(int spelId, String naam, List<Spelbord> spelborden) {
		this.naam = naam;
		this.spelId = spelId;
		this.aantalSpelborden = aantalSpelborden;
		this.aantalSpelbordenVoltooid = aantalSpelbordenVoltooid;
	}

	
	public String getNaam()
	{
		return naam;
	}
	
	public int getSpelId()
	{
		return spelId;
	}
	
	public int getAantalSpelborden()
	{
		return aantalSpelborden;
	}
	
	
	/**
	 * Methode om het aantal voltooide spelborden terug te geven
	 * @return geeft het aantal voltooide spelborden terug
	 */
	public int getAantalSpelbordenVoltooid()
	{
		int aantal = 0;
		
		for(Spelbord k : this.spelborden)
		{
			if(k.controleerVoltooid())
			{
				aantal++;
			}
		}
		return aantal;
	}
	
	/**
	 * Methode om een spelbord van het spel terug te geven
	 * 
	 * return : geeft een spelbord van het spel terug
	 */
	
	public Spelbord getSpelbord()
	{
		return spelbord;
	}
	
	/**
	 * Methode om een lijst van spelborden van het spel terug te geven
	 * @return geeft een lijst van spelborden van het spel terug
	 */
	public List<Spelbord> getSpelborden()
	{
		return spelborden;
	}
	
	
	/**
	 * Methode om het huidig spelbord te zetten dat je kan spelen
	 * @param spelbord object van de klasse Spelbord
	 */
	public void setSpelbord(Spelbord spelbord)
	{
		this.spelbord = spelbord;
	}
	
	
	/**
	 * Methode om het mannetje te verplaatsen in gegeven richting
	 * 
	 * richting : richting waarin het mannetje moet bewegen
	 */
	
	public void verplaatsMan(String richting)
	{
		this.spelbord.verplaatsMan(richting);
	}
	
	/**
	 * Methode om het aantal verplaatsingen terug te geven
	 * 
	 * return : geeft het aantal verplaatsingen van het mannetje terug
	 */
	
	public int geefAantalVerplaatsingen()
	{
		return spelbord.getAantalVerplaatsingen();
	}
	
	public void voegSpelbordToe(Spelbord spelbord)
	{
		this.spelborden.add(spelbord);
	}
	/**
     * Methode om een spelbord te kiezen met bepaald spelbordnummer
     *
     * @param volgnummer bepaalt welk spelbord gekozen wordt
     */
    public void kiesSpelbord(int volgnummer)
    {
	for (Spelbord spelborden1 : spelborden)
	{
	    if (spelborden1.getVolgnummer() == volgnummer)
	    {
		this.spelbord = spelborden1;
	    }
	}
  }     
	
	
	/**
	 * Methode om ee spelbord te verwijderen uit de databank
	 * 
	 */
	
	public void verwijderSpelbord()
	{
		this.spelborden.remove(this.spelbord);
	}
	
	/**
	 * 
	 * Methode om het spelbord te resetten
	 * nieuwSpelbord spelbord dat het gewijzigde spelbord zal overschrijven naar zijn originele staat
	 */
	
	public void resetSpelbord(Spelbord nieuwSpelbord)
	{
		this.spelbord = nieuwSpelbord;
	}
	
	/**
	 * Methode om alle spelborden te resetten
	 * nieuweSpelborden de lijst met spelborden zal gereset worden
	 * 
	 */
	
	public void resetAlleSpelborden(List<Spelbord> nieuweSpelborden)
	{
		this.spelborden = nieuweSpelborden;
	}
	
	
	/**
	 * Methode om te controleren opdat het huidig spelbord voltooid is 
	 * return geeft waarde true terug als het spelbord voltooid is anders false;
	 * 
	 * 
	 * 
	 */
	
	
	public boolean controleerVoltooid()
	{
		return this.spelbord.controleerVoltooid();
	}
	
	/**
	 * Methode om velden aan te maken in het huidige spelbord
	 */
	
	
	
	
}
