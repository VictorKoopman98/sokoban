package domein;

import java.math.BigDecimal;
import java.time.LocalDate;

import Exceptions.OngeldigGebruikersnaamException;
import Exceptions.OngeldigWachtwoordException;

public class Speler
{
	private String gebruikersnaam;
    private String wachtwoord;
    private boolean adminrechten;
    private String naam;
    private String voornaam;

    
    public Speler(String gebruikersnaam, String wachtwoord, boolean adminrechten, String naam, String voornaam)   //methode om een speler object aan te maken (constructors)
    {
	this.setGebruikersnaam(gebruikersnaam);
	this.setWachtwoord(wachtwoord);
	this.adminrechten = adminrechten;
	this.naam = naam;
	this.voornaam = voornaam;
    }
    
    
    public Speler(String naam, String voornaam, String wachtwoord, String gebruikersnaam, boolean adminrechten) 
    {
        this(gebruikersnaam, wachtwoord, false, naam, voornaam);
    }
    

    public String getGebruikersnaam()    //Methode om de gebruikersnaam van een speler terug te geven
    {
	return this.gebruikersnaam;
    }

    
    public String getWachtwoord()     //Methode om het wachtwoord van een speler terug te geven
    {
	return this.wachtwoord;
    }

    
    public boolean isAdminrechten()    //Methode om te kijken of een speler adminrechten heeft
    {
	return this.adminrechten;
    }

   
    public String getNaam()    //Methode om de familienaam van een speler terug te krijgen
    {
	return this.naam;
    }

    
    public String getVoornaam()    //Methode om de voornaam van een speler terug te krijgen
    {
	return this.voornaam;
    }

   
    public void setGebruikersnaam(String gebruikersnaam)    //Methode om de gebruikersnaam van een speler in te stellen
    {
		if (gebruikersnaam == null || gebruikersnaam.length() == 0)
		{
		    throw new IllegalArgumentException("Gebruikersnaam is verplicht in te vullen.");   //exception gooien als beruikersnaam niet is ingevuld
		} else if (gebruikersnaam.length() < 8)
		{
		    throw new OngeldigGebruikersnaamException("Gebruikersnaam is minstens 8 tekens lang");    //exception gooien als gebruikersnaam te kort is
		}else 
		{
		this.gebruikersnaam = gebruikersnaam;
		}
    }

    
    public void setWachtwoord(String wachtwoord)   //Methode om het wachtwoord van de speler in te stellen
    {
		if (wachtwoord == null || wachtwoord.length() == 0)
		{
		    throw new OngeldigWachtwoordException("Wachtwoord is verplicht in te vullen.");   //exception gooien als wachtwoord neit ingevuld is
		} else if (isCorrectWachtwoord(wachtwoord) == false)
		{
		    throw new OngeldigWachtwoordException("Wachtwoord is minstens 8 tekens lang en heeft minstens 1 hoofdletter, 1 kleine letter en 1 cijfer");   //exception gooien als wachtwoord niet klopt => zie tekst
		} else 
		{
		this.wachtwoord = wachtwoord;
	    }
	}

    
    private boolean isCorrectWachtwoord(String wachtwoord)   //methode om te kijken of wachtwoord lang genoeg is + methode om te kijken of het een hoofdletter, kleine letter en cijfer heeft word hier ook in uitgevoerd
    {
    	if(wachtwoord.length() > 7)   //als wachtwoord groter is dan 7 voer volgende stappen uit else => false
    	{
    		if(checkWachtwoord(wachtwoord))    //als checkWachtwoord true oplevert => true
    		{
    			return true;
    		}
    		else
    		{
    			return false;
    		}
    	}
    	else 
    	{
    		return false;
    	}
    }
    
    
    private static boolean checkWachtwoord(String wachtwoord)     //methode om te kijken of het wachtwoord een kleine, grote letter heeft en een cijfer
    {
    	boolean heeftNummer = false; 
    	boolean heeftHoofdletter = false; 
    	boolean heeftKleineLetter = false; 
    	char c;
    	
    	for(int i = 0; i < wachtwoord.length(); i++)
    	{
    		c = wachtwoord.charAt(i);    //i wordt omgezet naar c wat elk karakter uit het wachtwoord voorstel en wordt overlopen
    		
    		if(Character.isDigit(c))    //indien c een cijfer is => true
    		{
    			heeftNummer = true;
    		}
    		else if(Character.isUpperCase(c))    //indien c een grote letter is => true
    		{
    			heeftHoofdletter = true;
    		}
    		else if(Character.isLowerCase(c))     //indien c een kleine letter is => true 
    		{
    			heeftKleineLetter = true;
    		}
    		if(heeftNummer && heeftHoofdletter && heeftKleineLetter)    //indien alle drie true => true
    		{
    			return true;
    		}
    	}
    	return false;
    }
}