package domein;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Speler
{
	private String gebruikersnaam;
    private String wachtwoord;
    private boolean adminrechten;
    private String naam;
    private String voornaam;

    //Constructors

    /**
     *Constructor om een speler object aan te maken met of zonder adminrechten
     *ebruikersnaam gebruikersnaam die de speler kiest
     * wachtwoord wachtwoord die de speler kiest
     *adminrechten kijken of de speler wel/geen adminrechten krijgt
     *naam familienaam van de speler 
     * voornaam voornaam van de speler
     */
    public Speler(String gebruikersnaam, String wachtwoord, boolean adminrechten, String naam, String voornaam)
    {
	this.setGebruikersnaam(gebruikersnaam);
	this.setWachtwoord(wachtwoord);
	this.adminrechten = adminrechten;
	this.naam = naam;
	this.voornaam = voornaam;
    }
    
    public Speler(String naam, String voornaam, String wachtwoord, String gebruikersnaam, boolean adminrechten) {
        this(gebruikersnaam, wachtwoord, false, naam, voornaam);
    }
    
//Getters

    /**
     * Methode om de gebruikersnaam van een speler terug te geven
     * @return geeft de gebruikersnaam van de speler terug
     */
    public String getGebruikersnaam()
    {
	return this.gebruikersnaam;
    }

    /**
     * Methode om het wachtwoord van een speler terug te geven
     * @return geeft het wachtwoord van een speler terug
     */
    public String getWachtwoord()
    {
	return this.wachtwoord;
    }

    /**
     * Methode om te kijken of een speler adminrechten heeft
     * @return geeft terug of de speler wel/geen adminrechten heeft
     */
    public boolean isAdminrechten()
    {
	return this.adminrechten;
    }

    /**
     * Methode om de familienaam van een speler terug te krijgen
     * @return geeft de familienaam van de speler terug
     */
    public String getNaam()
    {
	return this.naam;
    }

    /**
     * Methode om de voornaam van een speler terug te krijgen
     * @return geeft de voornaam van de speler terug
     */
    public String getVoornaam()
    {
	return this.voornaam;
    }

    //setters

    /**
     * Methode om de gebruikersnaam van een speler in te stellen
     *gebruikersnaam gebruikersnaam die de speler kiest
     */
        public void setGebruikersnaam(String gebruikersnaam)
    {
	if (gebruikersnaam == null || gebruikersnaam.length() == 0)
	{
	    throw new IllegalArgumentException("Gebruikersnaam is verplicht in te vullen."); // Alles veranderen
	} else if (gebruikersnaam.length() < 8)
	{
	    throw new IllegalArgumentException("Gebruikersnaam is minstens 8 tekens lang");
	}else 
	{
	this.gebruikersnaam = gebruikersnaam;
	}
    }

    /**
     * Methode om het wachtwoord van de speler in te stellen
     *  wachtwoord wachtwoord die de speler kiest 
     */
    public void setWachtwoord(String wachtwoord)
    {
	if (wachtwoord == null || wachtwoord.length() == 0)
	{
	    throw new IllegalArgumentException("Wachtwoord is verplicht in te vullen.");
	} else if (isCorrectWachtwoord(wachtwoord) == false)
	{
	    throw new IllegalArgumentException("Wachtwoord is minstens 8 tekens lang");
	} else 
	{
	this.wachtwoord = wachtwoord;
    }
	}

    /**
     * wachtwoord ingegeven wachtwoord dat moet gecontroleerd worden op geldigheid
     * @returnµ geeft boolean terug of het wachtwoord geldig is voor de gewenste parameters.
     */
    private boolean isCorrectWachtwoord(String wachtwoord)
    {

	boolean isMinstens8TekensLang = wachtwoord.length() >= 8;
	//boolean bevatKleineLetter = !wachtwoord.equals(wachtwoord.toLowerCase());
	//boolean bevatGroteLetter = !wachtwoord.equals(wachtwoord.toUpperCase());
	//boolean bevatCijfer = wachtwoord.matches(".*[0-9].*");

	return (isMinstens8TekensLang);// && bevatKleineLetter && bevatGroteLetter && bevatCijfer);
    }
    
}