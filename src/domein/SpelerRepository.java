package domein;

import java.util.ArrayList;

import java.util.List;

import persistentie.SpelerMapper;

public class SpelerRepository
{
	private final SpelerMapper spelerMapper;
	 
	
	public SpelerRepository()
	{
		spelerMapper = new SpelerMapper();
	}
	
	
    public Speler geefSpeler(String gebruikersnaam, String wachtwoord)   //Methode om de huidige speler terug te geven, geeft een speler object terug indien speler gevonden wordt dat voldoet aan de voorwaarden (parameters)
    {
    	Speler speler = spelerMapper.geefSpeler(gebruikersnaam);    //speler wordt opgevraagd adhv gebruikersnaam

    	if (speler != null)    //als speler niet null is en wachtwoord = wachtwoord van in databank return speler
    	{
    	    if (speler.getWachtwoord().equals(wachtwoord))
    	    {
    		return speler;
    	    }
    	}
    	return null;
    }
    
    
    private boolean bestaatSpeler(String gebruikersnaam)    //Methode om na te kijken of de speler niet al reeds bestaat in de databank, geeft een boolean terug om aan te duiden of de speler al dan niet bestaat
    {
    	return spelerMapper.geefSpeler(gebruikersnaam) != null;
    }

    
    
    public void voegToe(Speler speler)     //Methode om een speler toe te voegen in de databank, @param speler spelerobject dat aangemaakt moet worden in de databank
    {
	if (bestaatSpeler(speler.getGebruikersnaam()))
	{
	    throw new IllegalArgumentException("Speler bestaat al!");
	}
	spelerMapper.voegToe(speler);
    }
    
    
}