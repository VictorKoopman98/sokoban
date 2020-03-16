package domein;

public class DomeinController
{
	private final SpelerRepository spelerRepository;
	private Speler speler;
	
	
	/* Constructor om een DomeinController aan te maken */
	
	public DomeinController() 
	{
		spelerRepository = new SpelerRepository();
	}
	
	/* Methode om de gebruikersnaam van een speler terug te gegven
	 * 
	 * return geeft de gebruikersnaam van een speler terug
	 * */
	
	public String geefGebruikersnaam() 
	{
		return this.speler.getGebruikersnaam();
	}
	
	/* Methode om de speler in te stellen die het spel zal spelen*/

	public void setSpeler(Speler speler)
	{
		this.speler = speler;
	}
	
	public void meldAan(String gebruikersnaam, String wachtwoord) 
	{
        Speler gevondenSpeler = spelerRepository.geefSpeler(gebruikersnaam, wachtwoord);
        System.out.print(gevondenSpeler);

        if (gevondenSpeler != null) {
            setSpeler(gevondenSpeler);

        } else {
            throw new IllegalArgumentException("Verkeerde login!");
        }
	}
	/**
     * Methode om te kijken of de speler een admin is
     *
     * @return geeft terug of de speler wel/geen admin is
     */
    public boolean isAdmin() 
    {
        return this.speler.isAdminrechten();
    }

    public void registreer(String gebruikersnaam, String wachtwoord, boolean adminrechten, String naam, String voornaam) 
    {
        Speler nieuweSpeler = new Speler(gebruikersnaam, wachtwoord, adminrechten, naam, voornaam);
        setSpeler(nieuweSpeler);
        spelerRepository.voegToe(nieuweSpeler);
    }
}
