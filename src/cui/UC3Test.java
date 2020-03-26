package cui;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import cui.UC4Test;

import domein.DomeinController;

public class UC3Test
{
	private DomeinController dc;
	private String[] spelletjes = dc.geefLijstSpellen();   //array van de namen van de spellen
	private UC4Test uc4Test;

	
	
	public UC3Test (DomeinController dc) 
	{
		this.dc =dc;
	}
	
	
	public void kiesSpel()    //methode voor een spel te selecteren uit een lijst van spellen
	{
		int gekozenSpel;
		Scanner input = new Scanner(System.in);

		
		do {
			
			for(int i = 0; i < spelletjes.length; i++)
			{
				
				System.out.printf("%nSpelletjes: %d: %s%n", i+1, spelletjes[i]);      //i+1 want getal ingeven is niet gelijk aan index
			}

			
			System.out.printf("%nGeef uw keuze in: ");
			gekozenSpel =input.nextInt();    //gekozen spel wordt ingegeven aan de hand van een getal
			
		}
		while(gekozenSpel <= 0 && gekozenSpel > spelletjes.length);   //indien nummer ingegeven niet overeenkomend met een nummer uit de lijst => do opnieuw
		
		String spelnaam = zetIndexOmInNaam(gekozenSpel-1);
		
		dc.selecteerSpel(spelnaam);
		
		int actie = toonActiesSpel();
		
		if(actie == 1)    //als je actie 1 kiest van toonActiesSpel worden volgende methodes uitgevoerd
		{
			uc4Test.voltooiSpelbord();  //methode voltooiSpelbord van UC4 wordt uitgevoerd
			
			dc.geefAantalSpelborden();
			
			dc.geefAantalSpelbordenVoltooid();
		}
		else if (actie == 2) {
			System.out.printf("%n%s heeft het spel verlaten.%n", dc.geefGebruikersnaam());
		}
	}
	
	
	private int toonActiesSpel()    //acties die je kan doen in het spel worden weergegeven
	{
		boolean blijvenHerhalen = true;
		int keuze = -1;
		Scanner input = new Scanner(System.in);

		do {
			try {
				System.out.printf("%nVoltooi volgend spelbord (1)");
				
				System.out.printf("%nSpel verlaten (2)");
				
				System.out.printf("%n%nGeef uw keuze in: ");
				keuze = input.nextInt();
				if (keuze > 0 && keuze < 3) {
					blijvenHerhalen = false;
				}
				
			}
			catch(IllegalArgumentException e){
				System.err.println(e);
			}
		} while (blijvenHerhalen && !dc.isSpelVoltooid());
		
		return keuze;
	}
	
	private String zetIndexOmInNaam(int index) {
		List<String> lijst = Arrays.asList(dc.geefLijstSpellen());
		String naam = lijst.get(index);
		return naam;
	}
	
	
}