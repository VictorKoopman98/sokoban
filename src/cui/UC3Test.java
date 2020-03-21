package cui;

import java.util.Scanner;

import domein.DomeinController;

public class UC3Test
{
	DomeinController dc;
	Scanner input = new Scanner(System.in);
	String[] spelletjes = dc.geefLijstSpellen();   //array van de namen van de spellen
	
	public UC3Test (DomeinController dc) 
	{
		this.dc =dc;
	}
	
	
	public void kiesSpel()    //methode voor een spel te selecteren uit een lijst van spellen
	{
		int gekozenSpel;
		
		do {
			
			for(int i = 0; i < spelletjes.length; i++)
			{
				
				System.out.printf("Spelletjes: %d: %s%n", i+1, spelletjes[i]);      //i+1 want getal ingeven is niet gelijk aan index
			}
			
			System.out.printf("Geef uw keuze in: %n");
			gekozenSpel =input.nextInt()-1;    //gekozen spel wordt ingegeven aan de hand van een getal
			
		}
		while(gekozenSpel <= 0 && gekozenSpel > spelletjes.length);   //indien nummer ingegeven niet overeenkomend met een nummer uit de lijst => do opnieuw
		
		int actie = toonActiesSpel();
		
		if(actie == 1)    //als je actie 1 kiest van toonActiesSpel worden volgende methodes uitgevoerd
		{
			dc.geefAantalSpelborden(spelletjes[gekozenSpel-1]);
			dc.geefAantalSpelbordenVoltooid(spelletjes[gekozenSpel-1]);
		}
	}
	
	public int toonActiesSpel()    //acties die je kan doen in het spel wordne weergegeven
	{
		
        System.out.printf("Voltooi volgend spelbord (1)");
		
		System.out.printf("Spel verlaten (2)");
		
		System.out.printf("Geef uw keuze in: %n");
		return input.nextInt();	
		
	}
	
	
}