package cui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import domein.DomeinController;

public class UC4Test 
{
	private DomeinController dc;
	
	
	public UC4Test (DomeinController dc) 
	{
		this.dc =dc;
	}
	
	
	public void voltooiSpelbord(String spelnaam)  //methode om het spelbord te voltooien
	{
		String richtingMan = "";
		
		dc.selecteerSpelbord(spelnaam);
		
		dc.toonSpelbord();  //spelbord tonen
		
		int actie = toonActiesSpelbord();
		do {
			
			
			if(actie == 2)   //indien spelbord willen resetten
			{
				dc.resetSpelbord(spelnaam, dc.geefVolgnummer());
			}
			else if(actie == 1)  //indien verplaatsing willen uitvoeren
			{
				do
				{
					int richting = kiesRichting();
					
					if(richting == 4)   //de opties voor de verplaatsing van de man worden terug omgezet naar strings ipv getallen
					{
						 richtingMan = "links";
					}else if(richting == 6)
					{
						 richtingMan = "rechts";
					}else if(richting == 8)
					{
						 richtingMan = "omhoog";
					}else if(richting == 2)
					{
						 richtingMan = "omlaag";
					}
					
					dc.verplaatsMan(richtingMan);
									
					System.out.printf("Momenteel %s %d %s.%n", dc.geefAantalVerplaatsingen() == 1? "is er" : "zijn er", dc.geefAantalVerplaatsingen(), dc.geefAantalVerplaatsingen() == 1 ? "verplaatsing" : "verplaatsingen");
					
					System.out.println();
					
					dc.toonSpelbord();
					
					actie = toonActiesSpelbord();  //verichte keuze in toonActiesSpelbord omztten naar "actie"

				}
				while(!dc.eindeSpelbordBereikt() && actie != 3 && actie != 2);   //blijf verplaatsen tot dat einde spelbord bereikt is
			}
			else if(actie == 3)   //spelbord verlaten
			{
				System.out.printf("%s heeft het spelbord verlaten", dc.geefGebruikersnaam());
			}
		}while(actie != 3);
		
		
	}
	
	
	private int toonActiesSpelbord()  //methode voor de acties van het spelbord weer te geven
	{
		Scanner input = new Scanner(System.in);

		boolean blijvenHerhalen = true; 
		int keuze = -1;
		do {
			try {
				System.out.println("Nieuwe verplaatsing (1)");
				
				System.out.println("Spel terugzetten naar begintoestand (2)");
				
				System.out.println("Spelbord verlaten (3)");
				
				System.out.print("Geef uw nummer in: ");
		
				keuze = input.nextInt();
				
				System.out.println();
				
				if (keuze > 0 && keuze < 4) 
				{
					blijvenHerhalen = false;
				}
				else if(keuze < 1 || keuze > 3 || keuze != (int)keuze)
				{
					throw new IllegalArgumentException("Ongeldige actie!");
				}	
			}
			catch(IllegalArgumentException e)
			{
				System.err.println(e);
			}
		} while (blijvenHerhalen);
		
		return keuze;
		
	}
	
	
	public int kiesRichting()  //methode voor de opties van de verplaatsing van de man
	{
		boolean blijvenHerhalenFlag = true;
		int keuze = -1;
		Scanner input = new Scanner(System.in);

		do {
			try {
				System.out.println("links (4)");
				
				System.out.println("rechts (6)");
				
				System.out.println("omhoog (8)");
				
				System.out.println("omlaag (2)");
				
				System.out.print("Geef uw nummer in: ");
				keuze = input.nextInt();
				
				System.out.println();
				
				List<Integer> richtingen = new ArrayList<Integer>();
				richtingen.add(4);
				richtingen.add(8);
				richtingen.add(6);
				richtingen.add(2);
				if (richtingen.contains(keuze)) 
				{
					blijvenHerhalenFlag = false;
				}
				else if(!richtingen.contains(keuze) || keuze != (int)keuze)
				{
					throw new IllegalArgumentException("Ongeldige richting!");
				}
			}
			catch(IllegalArgumentException e)
			{
				System.err.println(e);
			}
		} while (blijvenHerhalenFlag);
		
		return keuze;
	}
}
