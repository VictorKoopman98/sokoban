package cui;

import java.util.Scanner;

import domein.DomeinController;

public class UC1Test
{
	private final  DomeinController dc;
	
	
	public UC1Test (DomeinController dc) 
	{
		this.dc =dc;
	}
	
	
	public void meldAan()
	{
		Scanner input = new Scanner(System.in);
		String gebruikersnaam = "";
		String wachtwoord = "";
		boolean blijvenHerhalenFlag;
		
		blijvenHerhalenFlag = true;     //		blijft herhalen zolang flag = true maar indien wachtwoord en gebruikersnaam juist zijn => flag wordt false,
                                        //		anders skipt het die stap en gaat direct naar exceptions.
            do
            {
                try
                {
                    System.out.print("\nGebruikersnaam: ");
                    gebruikersnaam = input.next();

                    System.out.print("\nWachtwoord: ");
                    wachtwoord = input.next();
                    
                   dc.meldAan(gebruikersnaam, wachtwoord);
                   System.out.printf("%n%s is aangemeld", dc.geefGebruikersnaam());

                    blijvenHerhalenFlag = false;
                } 
                
                catch (IllegalArgumentException e)
                {
                    System.err.println(e);
                    
                } 
                
            } while (blijvenHerhalenFlag);	
	}
	 
}