package cui;

import domein.DomeinController;
import java.util.Scanner;

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
        String spelnaam = "";
		Scanner input = new Scanner(System.in);
		boolean blijvenHerhalenFlag = true;
		int aantalSpelborden = 0;
		
		do 
		{
			try 
			{
				System.out.printf("%nGeef de spelnaam van het nieuwe spel: ");
				spelnaam = input.next();
				
				dc.maakNieuwSpel(spelnaam);
				blijvenHerhalenFlag = false;
				
				dc.selecteerSpel(spelnaam);
				
				uc6test.maakNieuwSpelbord(aantalSpelborden+1);
				aantalSpelborden++;
				
				int actie = toonActies();
				
				do {
					if (actie == 1) 
					{
						uc6test.maakNieuwSpelbord(aantalSpelborden+1);
						aantalSpelborden++;
						
						actie = toonActies();
					}
					else if (actie == 2) 
					{
						System.out.printf("%s is gestopt met spelborden aanmaken.%n%n", dc.geefGebruikersnaam());
					}
				}while ( actie != 2);
			}
			catch (IllegalArgumentException e) 
			{
				System.err.println(e);
			}
			
		} while(blijvenHerhalenFlag);
		
		dc.selecteerSpel(spelnaam);
		
		System.out.printf("%s is aangemaakt met %d %s", dc.geefNaamSpel(), aantalSpelborden, aantalSpelborden <= 1 ? "spelbord" : "spelborden");
			
	}
	
	
	private int toonActies() 
	{
		Scanner input = new Scanner(System.in);

		System.out.printf("%n%n-----------------------------%n 1. Nieuw spelbord aanmaken%n 2. Stoppen%n-----------------------------%nGeef je keuze in: ");
		int actie = input.nextInt();
		return actie;
	}

}