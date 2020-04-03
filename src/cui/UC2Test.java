package cui;

import java.util.Scanner;

import domein.DomeinController;
import gui.Taal;

public class UC2Test 
{
	private DomeinController dc;
	private Taal taalObj;
	public UC2Test (DomeinController dc, Taal taalObj) 
	{
		this.taalObj = taalObj;
		this.dc =dc;
	}
	
	
	public  void registreer()
	{
		Scanner input = new Scanner(System.in);
		String gebruikersnaam = "";
		String wachtwoord = "";
		String naam = "";
		String voornaam = "";
		boolean blijvenHerhalenFlag;
		
		blijvenHerhalenFlag = true;         //		blijft herhalen zolang flag = true maar indien wachtwoord en gebruikersnaam juist zijn => flag wordt false,
                                            //		anders skipt het die stap en gaat direct naar exceptions.
            do
            {
                try
                {
                    System.out.printf("\n%s",taalObj.getText("geefGebruikersnaam"));
                    gebruikersnaam = input.next();

                    System.out.printf("\n%s",taalObj.getText("geefWachtwoord"));
                    wachtwoord = input.next();
                    
                    System.out.printf("\n%s",taalObj.getText("naam"));
                    naam = input.next();
                    
                    System.out.printf("\n%s",taalObj.getText("voornaam"));
                    voornaam = input.next();
                    
                    dc.registreer(gebruikersnaam, wachtwoord, false, naam, voornaam);
                    blijvenHerhalenFlag = false;
                    
                    System.out.printf("%n%s %s", dc.geefGebruikersnaam(),taalObj.getText("geregistreerdEnAangemeld"));
                } 
                catch (IllegalArgumentException e)
                {
                    System.err.println(e);
                } 
                
            } while (blijvenHerhalenFlag);
	}
	
}