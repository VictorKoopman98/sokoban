package domein;

public class SpelerRepository
{
	
	
	
	
	/**
     * Methode om de huidige speler terug te geven
     * @param gebruikersnaam gebruikersnaam van persoon die zich wil aanmelden
     * @param wachtwoord wachtwoord van de persoon die zich wil aanmelden
     * @return geeft een speler object terug indien één gevonden wordt dat voldoet aan de voorwaarden (parameters)
     */
    public Speler geefSpeler(String gebruikersnaam, String wachtwoord)
    {
	Speler s = 

	if (s != null)
	{
	    if (s.getWachtwoord().equals(wachtwoord))
	    {
		return s;
	    }
	}
	return null;
    }
}
