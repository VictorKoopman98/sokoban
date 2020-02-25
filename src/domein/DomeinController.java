package domein;

public class DomeinController
{
	private final SpelerRepository spelerRepository;
	private Speler speler;
	
	
	/* Constructor om een DomeinController aan te maken */
	
	public DomeinController() {
		spelerRepository = new SpelerRepository();

	}
	
	/* Methode om de gebruikersnaam van een speler terug te gegven
	 * 
	 * return geeft de gebruikersnaam van een speler terug
	 * */
	
	public String geefGebruikersnaam() {

		return this.speler.getGebruikersnaam();
	}
	
	/* Methode om de speler in te stellen die het spel zal spelen*/

	public void setSpeler(Speler speler)
	{
		this.speler = speler;
	}
	
	public void meldAan(String gebruikersnaam, String wachtwoord) {
        Speler gevondenSpeler = spelerRepository.geefSpeler(gebruikersnaam, wachtwoord);

        if (gevondenSpeler != null) {
            setSpeler(gevondenSpeler);

        } else {
            throw new IllegalArgumentException("Verkeerde login!");
        }
	}
	

}
