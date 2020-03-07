package Exceptions;

public class OngeldigGebruikersnaamException extends RuntimeException
{
	/**
     * Methode om een exception op de gebruikersnaam te construeren wanneer deze ongeldig is 
     */
    public OngeldigGebruikersnaamException()
    {
    	
    }

    /**
     * Methode om een exception op de gebruikersnaam te construeren wanneer deze ongeldig is 
     * message boodschap die weergeeft waar de fout zich bevindt en welke exception er optreedt
     */
	public OngeldigGebruikersnaamException(String message)
	{
		super(message);
		
	}
    
   
    
   
}
