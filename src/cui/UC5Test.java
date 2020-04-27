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
				
				dc.maakNieuwSpel(spelnaam);
				blijvenHerhalenFlag = false;
				
				dc.selecteerSpel(spelnaam);
				
				uc6test.maakNieuwSpelbord(aantalSpelborden+1);
				aantalSpelborden++;
				
				int actie = toonActies();
				
				do {
					if (actie == 1) {
						uc6test.maakNieuwSpelbord(aantalSpelborden+1);
						aantalSpelborden++;
						
						actie = toonActies();
					}
					else if (actie == 2) {
						System.out.printf("%s %s%n%n", dc.geefGebruikersnaam(),stopAanmaken);
					}
				}while ( actie != 2);
			}
			catch (IllegalArgumentException e) {
				System.out.printf("%n%s%n", e.getMessage());
			}
		} while(blijvenHerhalenFlag);
		
		dc.selecteerSpel(spelnaam);
		
		System.out.printf("%s %s %d %s", dc.geefNaamSpel(),aangemaakt,aantalSpelborden, aantalSpelborden <= 1 ? spelbord: spelborden);
	}
	
	
	private int toonActies() 
	{	
		Scanner input = new Scanner(System.in);
		
		String nieuwSpelbord = Taal.getText("nieuwSpelbord"),
			   stoppen = Taal.getText("stoppen"),
			   keuze = Taal.getText("keuze"),
			   ongeldigeActie = Taal.getText("ongeldigActie"),
			   getalIngeven = Taal.getText("getalIngeven");
		do
		{
			try {
				System.out.printf("%n%n-----------------------------%n %s%n %s%n-----------------------------%n%s ",
						nieuwSpelbord,stoppen,keuze);
				int actie = input.nextInt();
				
				if(actie < 1 || actie > 2){
					throw new IllegalArgumentException(ongeldigeActie);
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