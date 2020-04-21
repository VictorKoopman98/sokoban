package cui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import domein.DomeinController;
import gui.Taal;

public class UC4Test 
{
	private DomeinController dc;
	
	public UC4Test (DomeinController dc) 
	{
		this.dc =dc;
	}
	
	public void voltooiSpelbord(String spelnaam)  //methode om het spelbord te voltooien
	{
		String links = Taal.getText("links"),
			   rechts = Taal.getText("rechts"),
			   omhoog = Taal.getText("omhoog"),
			   omlaag = Taal.getText("omlaag"),
			   momenteel = Taal.getText("momenteel"),
			   isEr = Taal.getText("isEr"),
			   zijnEr = Taal.getText("isEr"),
			   verplaatsing = Taal.getText("verplaatsing"),
			   verplaatsingen = Taal.getText("verplaatsingen"),
			   verlaten = Taal.getText("heeftSpelbordVerlaten");
		
		String richtingMan = "";
		
		dc.selecteerSpelbord(spelnaam);
		
		dc.toonSpelbord();  //spelbord tonen
		
		int actie = toonActiesSpelbord();
		
		do {
			
			
			if(actie == 2)   //indien spelbord willen resetten
			{
				dc.resetSpelbord(spelnaam, dc.geefVolgnummer());
				dc.toonSpelbord();
			}
			else if(actie == 1)  //indien verplaatsing willen uitvoeren
			{
				do
				{
					int richting = kiesRichting();
					
					if(richting == 4)   //de opties voor de verplaatsing van de man worden terug omgezet naar strings ipv getallen
					{
						 richtingMan = links;
					}else if(richting == 6)
					{
						 richtingMan = rechts;
					}else if(richting == 8)
					{
						 richtingMan = omhoog;
					}else if(richting == 2)
					{
						 richtingMan = omlaag;
					}
					dc.verplaatsMan(richtingMan);
									
					dc.toonSpelbord();
					
					System.out.printf("%n%s %s %d %s.%n",momenteel,dc.geefAantalVerplaatsingen() == 1? isEr : zijnEr, 
							dc.geefAantalVerplaatsingen(), dc.geefAantalVerplaatsingen() == 1 ? verplaatsing : verplaatsingen);
					
					System.out.println();
					
					if(!dc.eindeSpelbordBereikt())
					{
						actie = toonActiesSpelbord();  //verichte keuze in toonActiesSpelbord omztten naar "actie"
					}
				}
				while(!dc.eindeSpelbordBereikt() && actie != 3 && actie != 2);   //blijf verplaatsen tot dat einde spelbord bereikt is
			}
			else if(actie == 3)   //spelbord verlaten
			{
				System.out.printf("%s %s", dc.geefGebruikersnaam(),verlaten);
			}
		}while(!dc.eindeSpelbordBereikt() && actie != 3);
	}
	
	
	private int toonActiesSpelbord()  //methode voor de acties van het spelbord weer te geven
	{
		Scanner input = new Scanner(System.in);
		
		String nieuwVerpl = Taal.getText("nieuweVerplaatsing"),
			   spelTerugZetten = Taal.getText("spelTerugzetten"),
			   spelbordVerlaten = Taal.getText("spelbordVerlaten"),
			   geefNummer = Taal.getText("geefNummer"),
			   ongeldigeActie = Taal.getText("ongeldigActie");

		boolean blijvenHerhalen = true; 
		int keuze = -1;
		do {
			try {
				System.out.printf("%s%n",nieuwVerpl);
				
				System.out.printf("%s%n",spelTerugZetten);
				
				System.out.printf("%s%n",spelbordVerlaten);
				
				System.out.printf("%s",geefNummer);
		
				keuze = input.nextInt();
				
				System.out.println();
				
				if (keuze > 0 && keuze < 4) 
				{
					blijvenHerhalen = false;
				}
				else if(keuze < 1 || keuze > 3 || keuze != (int)keuze)
				{
					throw new IllegalArgumentException(ongeldigeActie);
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
		Scanner input = new Scanner(System.in);
		
		String links = Taal.getText("links4"),
			   rechts = Taal.getText("rechts6"),
			   omhoog = Taal.getText("omhoog8"),
			   omlaag = Taal.getText("omlaag2"),
			   geefNummer = Taal.getText("geefNummer"),
			   ongeldigeRichting = Taal.getText("ongeldigRichting");
		
		int keuze = -1;
		boolean blijvenHerhalenFlag = true;
		do {
			try {
				System.out.printf("%s%n",links);
				
				System.out.printf("%s%n",rechts);
				
				System.out.printf("%s%n",omhoog);
				
				System.out.printf("%s%n",omlaag);
				
				System.out.printf("%s",geefNummer);
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
					throw new IllegalArgumentException(ongeldigeRichting);
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
