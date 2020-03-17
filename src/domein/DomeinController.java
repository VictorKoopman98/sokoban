package domein;

import java.util.List;

public class DomeinController
{
	private final SpelerRepository spelerRepository;
	private final SpelRepository spelRepository;
	private Speler speler;
	private Spel spel;
	
	
	/* Constructor om een DomeinController aan te maken */
	
	public DomeinController() 
	{
		spelerRepository = new SpelerRepository();
		spelRepository = new SpelRepository();
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
    /**
     * Methode om het spelbord te tonen en af te printen
     *
     * @return geeft het spelbord terug dat afgeprint wordt
     */
    public String[][] toonSpelbord() {
        String output[][] = new String[10][10];
        Veld[][] velden = this.spel.getSpelbord().getVelden();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (this.spel.getSpelbord().isMuur(i, j)) {
                    output[i][j] = "X";
                } else if (velden[i][j].isDoel() && velden[i][j].bevatKist()) {
                    output[i][j] = "V";
                } else if (velden[i][j].isDoel() && !velden[i][j].bevatMan()) {
                    output[i][j] = ".";
                } else if (!velden[i][j].isDoel() && !velden[i][j].bevatKist() && !velden[i][j].bevatMan()) {
                    output[i][j] = " ";
                } else if (velden[i][j].bevatMan() && !velden[i][j].isDoel()) {
                    output[i][j] = "@";
                } else if (velden[i][j].bevatKist()) {
                    output[i][j] = "*";
                } else if (velden[i][j].isDoel() && velden[i][j].bevatMan()) {
                    output[i][j] = "#";
                }
            }
        }
        return output;

    }


    public void registreer(String gebruikersnaam, String wachtwoord, boolean adminrechten, String naam, String voornaam) 
    {
        Speler nieuweSpeler = new Speler(gebruikersnaam, wachtwoord, adminrechten, naam, voornaam);
        setSpeler(nieuweSpeler);
        spelerRepository.voegToe(nieuweSpeler);
    }
    
    private void setSpel(Spel spel)
    {
    	this.spel = spel;
    }
    
    /**
     * Methode om de naam van het spel te tonen
     *
     * @return geeft de naam van het spel terug
     */
    public String toonSpelNaam() {
        return this.spel.getNaam();
    }
    
    
    /**
     * Methode om een spel te kiezen met een bepaald spelnummer
     *
     * @param spelId spelnummer van het spel dat gekozen wordt
     */
    public void kiesSpel(int spelId) {
        setSpel(spelRepository.getSpel(spelId));
    }

    
    /**
     * Methode om de namen van de spellen terug te geven
     *
     * @return geeft de namen van de spellen terug
     */
    public String[] geefSpelNamen() {
        List<Spel> spellen = spelRepository.getSpellen();
        int n = spellen.size();
        String[] namen = new String[n];

        for (int i = 0; i < n; i++) {
            namen[i] = String.format("%d. %s", i + 1, spellen.get(i).getNaam());
        }

        return namen;
    }
    
    /**
     * Methode om de man te verplaatsen in een bepaalde richting
     *
     * @param richting geeft de richting waarnaar de man zich moet verplaatsen
     */
    public void verplaatsMan(String richting) {
        this.spel.verplaatsMan(richting);

    }
    
    /**
     * Methode om het aantal verplaatsingen terug te geven van het mannetje
     *
     * @return geeft het aantal verplaatsingen van het mannetje terug
     */
    public int geefAantalVerplaatsingen() {
        return spel.geefAantalVerplaatsingen();
    }
    
    /**
     * Methode om het aantal spellen terug te geven
     *
     * @return geeft het aantal spellen terug
     */
    public int geefAantalSpellen() {
        return spelRepository.geefAantalSpellen();
    }
    
    
    /**
     * Methode om een spelbord te kiezen met bepaald spelbordnummer
     *
     * @param volgnummer spelbordnummer van het spelbord dat gekozen wordt
     */
    public void kiesSpelbord(int volgnummer) {
        this.spel.kiesSpelbord(volgnummer);

    }
    
    /**
     * Methode om een spelbord te verwijderen
     */
    public void verwijderSpelbord() {
        this.spel.verwijderSpelbord();
        spelRepository.verwijderSpelbord(this.spel.getSpelbord().getSpelbordId());
    }

    /**
     * Methode om het aantal spelborden terug te geven
     *
     * @return geeft het aantal spelborden terug
     */
    public int geefAantalSpelborden() {
        return this.spel.getAantalSpelborden();
    }

    /**
     * Methode om het spelbord te resetten indien je het niet kan oplossen
     */
    public void resetSpelbord() {
        Spelbord nieuwSpelbord = spelRepository.geefSpelbord(this.spel.getSpelId(), this.spel.getSpelbord().getSpelbordId());
        this.spel.resetSpelbord(nieuwSpelbord);
    }

    /**
     * Methode om na te gaan of het spelbord is voltooid
     *
     * @return geeft aan of het spelbord wel/niet voltooid is
     */
    public boolean isSpelbordVoltooid() {
        return this.spel.controleerVoltooid();
    }

    /**
     * Methode om het aantal voltooide spelborden weer te geven
     *
     * @return geeft het aantal voltooide spelborden terug
     */
    public int geefAantalVoltooideSpelborden() {
        return this.spel.getAantalSpelbordenVoltooid();
    }

    /**
     * Methode om het spelbord op te slaan in een databank
     */
    public void bewaarSpel() {
        spelRepository.bewaarSpel(this.spel);
    }

    /**
     * Methode om het spelbord up te daten nadat een wijziging is toegebracht
     */
    public void updateSpelbord() {
        spelRepository.updateSpelbord(this.spel);
    }

    /**
     * Methode om het totaal aantal spelborden dat bestaat terug te geven
     *
     * @return geeft het totaal aantal spelborden terug
     */
    public int geefTotaalAantalSpelborden() {
        return spelRepository.geefTotaalAantalSpelborden();
    }

    /**
     * Methode om alle spelborden te resetten bij een bepaald spel
     */
    public void resetAlleSpelborden() {
        this.spel.resetAlleSpelborden(spelRepository.geefSpelborden(this.spel.getSpelId()));

    }
    
    

}
