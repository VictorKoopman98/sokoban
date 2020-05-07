package cui;

import domein.DomeinController;
import gui.Taal;

import java.util.Scanner;
import java.util.InputMismatchException;

public class UC5Test 
{
	private DomeinController dc;
	private UC6Test uc6test;
	
	public UC5Test(DomeinController dc) 
	{
		this.dc = dc;
		this.uc6test = new UC6Test(dc);
	}
	
	public void maakNieuwSpel() 
	{
		Scanner input = new Scanner(System.in);
		
        String spelnaam = "";
        
        String geefSpelnaam = Taal.getText("geefSpelnaamNieuweSpel"),
        	   stopAanmaken = Taal.getText("stopMetSpelbordenAanmaken"),
        	   aangemaakt = Taal.getText("isAangemaakt"),
        	   spelbord = Taal.getText("spelbord"),
        	   spelborden = Taal.getText("spelborden");
        
		boolean blijvenHerhalenFlag = true;
		int aantalSpelborden = 0;
		do {
			try {
				System.out.printf("%n%s",geefSpelnaam);
				spelnaam = input.nextLine();
				
				dc.maakNieuwSpel(spelnaam, dc.geefGebruikersnaam());
								
				uc6test.maakNieuwSpelbord(dc.geefHuidigSpel().geefAantalSpelborden()+1);				
				
				int actie = toonActies(true);
				boolean blijvenHerhalenFlag2 = true;
				
				do {
					if (actie == 1) {
						uc6test.maakNieuwSpelbord(dc.geefHuidigSpel().geefAantalSpelborden()+1);
						
						actie = toonActies(true);
					}
					else if (actie == 2) {
						try {
							dc.voegSpelToe(dc.geefNaamSpel());
							System.out.printf("%n%s %s%n", dc.geefGebruikersnaam(),stopAanmaken);
							System.out.printf("%n%s %s %d %s%n", dc.geefNaamSpel(),aangemaakt,aantalSpelborden, aantalSpelborden <= 1 ? spelbord: spelborden);
							blijvenHerhalenFlag = false;
							blijvenHerhalenFlag2 = false;
						}
						catch(IllegalArgumentException e)
						{
							System.out.printf("%n%s%n", e.getMessage());
							actie = toonActies(false);
							if (actie == 2)
							{
								blijvenHerhalenFlag = false;
								blijvenHerhalenFlag2 = false;
							}
						}
					}
				}while (blijvenHerhalenFlag2);
			}
			catch (IllegalArgumentException e) {
				System.out.printf("%n%s%n", e.getMessage());
			}
		} while(blijvenHerhalenFlag);
				
	}
	
	
	private int toonActies(boolean stoppenBool) 
	{	
		Scanner input = new Scanner(System.in);
		
		String nieuwSpelbord = Taal.getText("nieuwSpelbord"),
			   stoppen = Taal.getText("stoppen"),
			   stoppen2 = Taal.getText("stoppenEnVerwijderen"),
			   keuze = Taal.getText("keuze"),
			   keuzeOutOfBounds = Taal.getText("keuzeNietBeschikbaar"),
			   getalIngeven = Taal.getText("getalIngeven");
		do
		{
			try {
				System.out.printf("%n-----------------------------%n %s%n %s%n-----------------------------%n%s ",
						nieuwSpelbord, stoppenBool ? stoppen : stoppen2 ,keuze);
				int actie = input.nextInt();
				
				if(actie < 1 || actie > 2){
					throw new IllegalArgumentException(keuzeOutOfBounds);
				}	
				return actie;
			}
			catch(InputMismatchException e) {
				System.out.printf("%s",getalIngeven);
				input.next();
			}
		}while(true);
	}
	
}