package cui;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import domein.DomeinController;
import gui.Taal;

public class UC4Test 
{
	private DomeinController dc;
	private Taal taalObj;
	
	public UC4Test (DomeinController dc,Taal taalObj) 
	{
		this.taalObj = taalObj;
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
				dc.toonSpelbord();
			}
			else if(actie == 1)  //indien verplaatsing willen uitvoeren
			{
				do
				{
					int richting = kiesRichting();
					
					if(richting == 4)   //de opties voor de verplaatsing van de man worden terug omgezet naar strings ipv getallen
					{
						 richtingMan = taalObj.getText("links");
					}else if(richting == 6)
					{
						 richtingMan = taalObj.getText("rechts");
					}else if(richting == 8)
					{
						 richtingMan = taalObj.getText("omhoog");
					}else if(richting == 2)
					{
						 richtingMan = taalObj.getText("omlaag");
					}
					
					dc.verplaatsMan(richtingMan);
									
					dc.toonSpelbord();
					
					System.out.printf("%n%s %s %d %s.%n", taalObj.getText("momenteel"),dc.geefAantalVerplaatsingen() == 1? taalObj.getText("isEr") : taalObj.getText("zijnEr"), dc.geefAantalVerplaatsingen(), dc.geefAantalVerplaatsingen() == 1 ? taalObj.getText("verplaatsing") : taalObj.getText("verplaatsingen"));
					
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
				System.out.printf("%s %s", dc.geefGebruikersnaam(),taalObj.getText("heeftSpelbordVerlaten"));
			}
		}while(!dc.eindeSpelbordBereikt() && actie != 3);
	}
	
	
	private int toonActiesSpelbord()  //methode voor de acties van het spelbord weer te geven
	{
		Scanner input = new Scanner(System.in);

		boolean blijvenHerhalen = true; 
		int keuze = -1;
		do {
			try {
				System.out.printf("%s",taalObj.getText("nieuweVerplaatsing"));
				
				System.out.printf("%s",taalObj.getText("spelTerugzetten"));
				
				System.out.printf("%s",taalObj.getText("spelbordVerlaten"));
				
				System.out.printf("%s",taalObj.getText("geefNummer"));
		
				keuze = input.nextInt();
				
				System.out.println();
				
				if (keuze > 0 && keuze < 4) 
				{
					blijvenHerhalen = false;
				}
				else if(keuze < 1 || keuze > 3 || keuze != (int)keuze)
				{
					throw new IllegalArgumentException(taalObj.getText("ongeldigActie"));
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
				System.out.printf("%s",taalObj.getText("links4"));
				
				System.out.printf("%s",taalObj.getText("rechts6"));
				
				System.out.printf("%s",taalObj.getText("omhoog8"));
				
				System.out.printf("%s",taalObj.getText("omlaag2"));
				
				System.out.printf("%s",taalObj.getText("geefNummer"));
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
					throw new IllegalArgumentException(taalObj.getText("ongeldigRichting"));
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
