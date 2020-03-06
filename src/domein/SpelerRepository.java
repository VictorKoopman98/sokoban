package domein;


import java.util.ArrayList;
import java.util.List;


import persistentie.SpelerMapper;

public class SpelerRepository
{
	
	private final SpelerMapper mapper;
	private final List<Speler> spelers = new ArrayList();
	 
	public SpelerRepository()
	{
		mapper = new SpelerMapper();
	}
	
	/**
     * Methode om de huidige speler terug te geven
     * gebruikersnaam gebruikersnaam van persoon die zich wil aanmelden
     * wachtwoord wachtwoord van de persoon die zich wil aanmelden
     * geeft een speler object terug indien speler gevonden wordt dat voldoet aan de voorwaarden (parameters)
     */
    public Speler geefSpeler(String gebruikersnaam, String wachtwoord)
    {
    	Speler speler = mapper.geefSpeler(gebruikersnaam);

    	if (speler != null)
    	{
    	    if (speler.getWachtwoord().equals(wachtwoord))
    	    {
    		return speler;
    	    }
    	}
    	return null;
    }
    
    /**
     * Methode om na te kijken of de speler niet al reeds bestaat in de databank
     *  gebruikersnaam gebruikersnaam waarvan we willen weten of de speler al bestaat
     *  geeft een boolean terug om aan te duiden of de speler al dan niet bestaat
     */
    private boolean bestaatSpeler(String gebruikersnaam)
    {
	return mapper.geefSpeler(gebruikersnaam) != null;
    }

    /**
     * Methode om een speler toe te voegen in de databank
     * @param speler spelerobject dat aangemaakt moet worden in de databank
     */
    public void voegToe(Speler speler)
    {
	if (bestaatSpeler(speler.getGebruikersnaam()))
	{
	    throw new IllegalArgumentException("Speler bestaat al!");
	}

	mapper.voegToe(speler);
    }
}

