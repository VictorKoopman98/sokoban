package Exceptions;

public class OngeldigWachtwoordException extends RuntimeException
{
	
	public OngeldigWachtwoordException(String message)    //Methode om een exception op het wachtwoord te construeren wanneer deze ongeldig is
	                                                      //message boodschap die weergeeft waar de fout zich bevindt en welke exception er optreedt
	{
		super(message);
		
	}
	
	public OngeldigWachtwoordException()
	{
		
	}
	
}