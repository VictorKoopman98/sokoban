package Exceptions;

public class OngeldigWachtwoordException extends RuntimeException
{

	/**
     * Methode om een exception op het wachtwoord te construeren wanneer deze ongeldig is
     */
	public OngeldigWachtwoordException()
	{
				
	}

	/**
     * Methode om een exception op het wachtwoord te construeren wanneer deze ongeldig is
     *  message boodschap die weergeeft waar de fout zich bevindt en welke exception er optreedt
     */
	public OngeldigWachtwoordException(String message)
	{
		super(message);
		
	}
	
}
