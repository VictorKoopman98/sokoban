package cui;

import java.util.Scanner;

import domein.DomeinController;

public class UC4Test 
{
	private DomeinController dc;
	
	
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
//		else if(actie == 2)   //indien spelbord willen resetten
//		{
//			dc.resetSpelbord();
//		}
		else if(actie == 3)   //spelbord verlaten
		{
			System.out.printf("%s heeft het spelbord verlaten", dc.geefGebruikersnaam());
		}
		
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
				if (keuze > 0 && keuze < 4) {
					blijvenHerhalen = false;
				}
				
			}
			catch(IllegalArgumentException e){
				System.err.println(e);
			}
		} while (blijvenHerhalen);
		
		return keuze;
		
	}
	
	
	public int kiesRichting()  //methode voor de opties van de verplaatsing van de man
	{
		boolean blijvenHerhalen = true;
		int keuze = -1;
		Scanner input = new Scanner(System.in);

		do {
			try {
				System.out.println("links (1)");
				
				System.out.println("rechts (2)");
				
				System.out.println("omhoog (3)");
				
				System.out.println("omlaag (4)");
				
				System.out.print("Geef uw nummer in: ");
				keuze = input.nextInt();
				if (keuze > 0 && keuze < 5) {
					blijvenHerhalen = false;
					
				}
				
			}
			catch(IllegalArgumentException e){
				System.err.println(e);
			}
		} while (blijvenHerhalen);
		
		return keuze;
	}
}
