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

                    System.out.print("\nWachtwoord: \n");
                    wachtwoord = input.next();
                    
                   dc.meldAan(gebruikersnaam, wachtwoord);

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
