package Exceptions;

public class OngeldigGebruikersnaamException extends RuntimeException
{
    public OngeldigGebruikersnaamException()    //Methode om een exception op de gebruikersnaam te construeren wanneer deze ongeldig is
    {
    	
    }

    
	public OngeldigGebruikersnaamException(String message)    //Methode om een exception op de gebruikersnaam te construeren wanneer deze ongeldig is
	                                                          //message boodschap die weergeeft waar de fout zich bevindt en welke exception er optreedt
	{
		super(message);
		
	}
}
     
