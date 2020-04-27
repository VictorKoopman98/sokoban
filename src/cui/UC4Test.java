package cui;

import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
			   zijnEr = Taal.getText("zijnEr"),
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
										
					if(!dc.eindeSpelbordBereikt())
					{
						actie = toonActiesSpelbord();  //verichte keuze in toonActiesSpelbord omztten naar "actie"
					}
				}
				while(!dc.eindeSpelbordBereikt() && actie != 3 && actie != 2);   //blijf verplaatsen tot dat einde spelbord bereikt is
			}
			else if(actie == 3)   //spelbord verlaten
			{
				System.out.printf("%n%s %s%n", dc.geefGebruikersnaam(),verlaten);
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
			   ongeldigeActie = Taal.getText("ongeldigActie"),
			   getalIngeven = Taal.getText("getalIngeven");

		boolean blijvenHerhalen = true; 
		int keuze = -1;
		do {
			try {
				System.out.printf("%n%s%n",nieuwVerpl);
				
				System.out.printf("%s%n",spelTerugZetten);
				
				System.out.printf("%s%n",spelbordVerlaten);
				
				System.out.printf("%s ",geefNummer);
		
				keuze = input.nextInt();
								
				if(keuze < 1 || keuze > 3)
				{
					throw new IllegalArgumentException(ongeldigeActie);
				}
				blijvenHerhalen = false;
			}catch(InputMismatchException e) {
				System.out.printf("%n%s%n", getalIngeven);
				input.next();
			}
			catch(IllegalArgumentException e){
				System.out.printf("%n%s%n", e.getMessage());
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
			   ongeldigeRichting = Taal.getText("ongeldigeRichting"),
			   getalIngeven = Taal.getText("getalIngeven");
		
		int keuze = -1;
		boolean blijvenHerhalenFlag = true;
		do {
			try {
				System.out.printf("%n%s%n",links);
				
				System.out.printf("%s%n",rechts);
				
				System.out.printf("%s%n",omhoog);
				
				System.out.printf("%s%n",omlaag);
				
				System.out.printf("%s ",geefNummer);
				keuze = input.nextInt();
								
				List<Integer> richtingen = new ArrayList<Integer>();
				richtingen.add(4);
				richtingen.add(8);
				richtingen.add(6);
				richtingen.add(2);
				
				if(!richtingen.contains(keuze))
				{
					throw new IllegalArgumentException(ongeldigeRichting);
				}
				blijvenHerhalenFlag = false;
			}catch(InputMismatchException e) {
				System.out.printf("%n%s%n", getalIngeven);
				input.next();
			}
			catch(IllegalArgumentException e)
			{
				System.out.printf("%n%s%n", e.getMessage());
			}
		} while (blijvenHerhalenFlag);
		return keuze;
	}
}
