package cui;

import java.util.Scanner;

import domein.DomeinController;

public class UC4Test 
{
	DomeinController dc;
	Scanner input = new Scanner(System.in);
	
	
	public UC4Test (DomeinController dc) 
	{
		this.dc =dc;
	}
	
	
	public void voltooiSpelbord()  //methode om het spelbord te voltooien
	{
		String richtingMan = "";
		
		dc.toonSpelbord();  //spelbord tonen
		
		int actie = toonActiesSpelbord();  //verichte keuze in toonActiesSpelbord omztten naar "actie"
		
		if(actie == 1)  //indien verplaatsing willen uitvoeren
		{
			do
			{
				int richting = kiesRichting();
				
				if(richting == 1)   //de opties voor de verplaatsing van de man worden terug omgezet naar strings ipv getallen
				{
					 richtingMan = "links";
				}else if(richting == 2)
				{
					 richtingMan = "rechts";
				}else if(richting == 3)
				{
					 richtingMan = "omhoog";
				}else if(richting == 4)
				{
					 richtingMan = "omlaag";
				}
				
				
				dc.verplaatsMan(richtingMan);
				
				dc.geefAantalVerplaatsingen();
				
				dc.toonSpelbord();
			}
			while(dc.eindeSpelbordBereikt() == false);   //blijf verplaatsen tot dat einde spelbord bereikt is
		}
		else if(actie ==2)   //indien spelbord willen resetten
		{
			dc.resetSpelbord();
		}
		else if(actie == 3)   //spelbord verlaten
		{
			System.out.printf("%s heeft het spelbord verlaten", dc.geefGebruikersnaam());
		}
	}
	
	
	public int toonActiesSpelbord()  //methode voor de acties van het spelbord weer te geven
	{
		System.out.println("Nieuwe verplaatsing (1)");
		
		System.out.println("Spel terugzetten naar begintoestand (2)");
		
		System.out.println("Spelbord verlaten (3)");
		
		System.out.print("Geef uw nummer in: ");
		return input.nextInt();
	}
	
	
	public int kiesRichting()  //methode voor de opties van de verplaatsing van de man
	{
		System.out.println("links (1)");
		
		System.out.println("rechts (2)");
		
		System.out.println("omhoog (3)");
		
		System.out.println("omlaag (4)");
		
		System.out.print("Geef uw nummer in: ");
		return input.nextInt();
	}
}
