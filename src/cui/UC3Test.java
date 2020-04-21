package cui;

import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;
import java.util.List;
import cui.UC4Test;

import domein.DomeinController;
import gui.Taal;

public class UC3Test
{
	private DomeinController dc;
	private String[] spelletjes;   //array van de namen van de spellen
	private UC4Test uc4Test;
	
	public UC3Test (DomeinController dc) 
	{
		this.dc =dc;
		spelletjes = DomeinController.geefLijstSpellen();
		uc4Test = new UC4Test(dc);
	}
	
	
	public void kiesSpel()    //methode voor een spel te selecteren uit een lijst van spellen
	{
		Scanner input = new Scanner(System.in);
		
		String spelletje = Taal.getText("spelletje"),
			   keuze = Taal.getText("keuze"),
			   getalIngeven = Taal.getText("getalIngeven"),
			   heeft = Taal.getText("heeft"),
			   vanDe = Taal.getText("vanDe"),
			   spelbordVoltooid = Taal.getText("spelbordVoltooid"),
			   huidigSpelbordVoltooid = Taal.getText("huidigSpelVoltooid"),
			   spelVerlaten = Taal.getText("spelVerlaten");
		
		int gekozenSpel = 0;
        boolean blijvenHerhalenFlag = true;
		do {
			try {
				for(int i = 0; i < spelletjes.length; i++)
				{
					System.out.printf("%n%s %d: %s%n",spelletje,i+1, spelletjes[i]);      //i+1 want getal ingeven is niet gelijk aan index
				}
				System.out.printf("%n%s ",keuze);
				gekozenSpel = input.nextInt();    //gekozen spel wordt ingegeven aan de hand van een getal
				
				if(gekozenSpel > 0 && gekozenSpel <= spelletjes.length)
				{
					blijvenHerhalenFlag = false;
				}
			}
			catch(IllegalArgumentException e)
			{
				System.out.println(e);
			}	
			catch(InputMismatchException e) {
				System.out.printf("\n%s",getalIngeven);
				input.next();
			}
			
		}
		while(blijvenHerhalenFlag);   //indien nummer ingegeven niet overeenkomend met een nummer uit de lijst => do opnieuw
	
		
		String spelnaam = zetIndexOmInNaam(gekozenSpel-1);
		
		dc.selecteerSpel(spelnaam);
		
		int actie = toonActiesSpel();
		
		do 
		{
			if(actie == 1)    //als je actie 1 kiest van toonActiesSpel worden volgende methodes uitgevoerd
			{
				uc4Test.voltooiSpelbord(spelnaam);  //methode voltooiSpelbord van UC4 wordt uitgevoerd
				
				System.out.printf("%n%s %s %d %s %d %s.%n%n", dc.geefGebruikersnaam(), heeft,dc.geefAantalSpelbordenVoltooid(), vanDe,
						dc.geefAantalSpelborden(),spelbordVoltooid);
			}
			if (!dc.isSpelVoltooid()) {
				actie = toonActiesSpel();
			}
			else {
				System.out.printf("%s %s", dc.geefGebruikersnaam(),huidigSpelbordVoltooid);
			}
		}while(actie!=2 && !dc.isSpelVoltooid());
		if (actie == 2) 
		{
			System.out.printf("%n%s %s", dc.geefGebruikersnaam(),spelVerlaten);
		}
	}
	
	
	private int toonActiesSpel()    //acties die je kan doen in het spel worden weergegeven
	{
		Scanner input = new Scanner(System.in);
		String spelbordVoltooid = Taal.getText("spelbordVoltooidO"),
			   spelVerlaten = Taal.getText("spelVerlatenO"),
			   keuzeMaken = Taal.getText("keuze"),
			   ongeldigeActie = Taal.getText("ongeldigActie");
		
		int keuze = -1;
		boolean blijvenHerhalen = true;
		do 
		{
			try 
			{
				System.out.printf("%n-----------------------------%n %s%n %s%n-----------------------------%n%s ",spelbordVoltooid,spelVerlaten,keuzeMaken);
				keuze = input.nextInt();
				System.out.println();
				if (keuze < 0 || keuze > 3 || keuze != (int)keuze) {
					throw new IllegalArgumentException(ongeldigeActie);
				}
				if (keuze > 0 && keuze < 3) 
				{
					blijvenHerhalen = false;
				}	
			}
			catch(IllegalArgumentException e){
				System.err.println(e);
			}
		} while (blijvenHerhalen && !dc.isSpelVoltooid());
		return keuze;
	}
	
	
	private String zetIndexOmInNaam(int index) 
	{
		List<String> lijst = Arrays.asList(DomeinController.geefLijstSpellen());
		String naam = lijst.get(index);
		return naam;
	}
	
	
}