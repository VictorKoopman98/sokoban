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
		
		int actie = toonActiesSpelbord();  //verichte keuze in toonActiesSpelbord omztten naar "actie"
		
		if(actie == 1)  //indien verplaatsing willen uitvoeren
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
				System.out.println();
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
				if (richtingen.contains(keuze)) {
					blijvenHerhalenFlag = false;
				}
				
			}
			catch(IllegalArgumentException e){
				System.err.println(e);
			}
		} while (blijvenHerhalenFlag);
		
		return keuze;
	}
}
