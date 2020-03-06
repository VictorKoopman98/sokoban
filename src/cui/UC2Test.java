package cui;

import java.util.Scanner;

import domein.DomeinController;

public class UC2Test 
{
	DomeinController dc;
	
	public UC2Test (DomeinController dc) 
	{
		this.dc =dc;
	}
	
	public  void registreer()
	{
		Scanner input = new Scanner(System.in);
		String gebruikersnaam = "";
		String wachtwoord = "";
		String naam = "";
		String voornaam = "";
//		String stoppen = "";
//		SokobanApplicatie sb;
		boolean blijvenHerhalenFlag;
		
		blijvenHerhalenFlag = true;
       
            do
            {
                try
                {
                    System.out.print("\nGebruikersnaam: ");
                    gebruikersnaam = input.next();

                    System.out.print("\nWachtwoord: ");
                    wachtwoord = input.next();
                    
                    System.out.print("\nNaam: ");
                    naam = input.next();
                    
                    System.out.print("\nVoornaam: ");
                    voornaam = input.next();
                    
                    dc.registreer(gebruikersnaam, wachtwoord, false
                    		, naam, voornaam);
                    

                    blijvenHerhalenFlag = false;
                } 
                
                catch (IllegalArgumentException e)
                {
                    System.err.println(e);
                    
                    //e.printStackTrace();
                } 
                
            } while (blijvenHerhalenFlag);	
	}
}
