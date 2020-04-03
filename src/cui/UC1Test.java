package cui;

import java.util.Scanner;

import domein.DomeinController;
import gui.Taal;

public class UC1Test
{
	private final  DomeinController dc;
	private Taal taalObj;
	
	public UC1Test (DomeinController dc, Taal taalObj) 
	{
		this.taalObj = taalObj;
		this.dc =dc;
	}
	
	
	public void meldAan()
	{
		String gebruikersnaam = "";
		String wachtwoord = "";
		boolean blijvenHerhalenFlag;
		Scanner input = new Scanner(System.in);
		blijvenHerhalenFlag = true;     //		blijft herhalen zolang flag = true maar indien wachtwoord en gebruikersnaam juist zijn => flag wordt false,
                                        //		anders skipt het die stap en gaat direct naar exceptions.
        do
        {
            try
            {
                System.out.printf("\n%s ", taalObj.getText("geefGebruikersnaam"));
                gebruikersnaam = input.next();

                System.out.printf("\n%s ",taalObj.getText("geefWachtwoord"));
                wachtwoord = input.next();
                
               dc.meldAan(gebruikersnaam, wachtwoord);
               blijvenHerhalenFlag = false;
               
               System.out.printf("%n%s%s", dc.geefGebruikersnaam(),taalObj.getText("aangemeld"));
            } 
            catch (IllegalArgumentException e)
            {
                System.out.println(e);
                
            } 
        } while (blijvenHerhalenFlag);	
	}
	 
}