package cui;

import java.util.Scanner;

import domein.DomeinController;

public class UC7Test {
	
	private UC8Test uc8test;
	DomeinController dc;
	
	public UC7Test(DomeinController dc) 
	{
		this.dc = dc;
	}
	
	public void wijzigSpel() 
	{
		
		int gekozenSpel;
		String spelnaam;
		int volgnummer = 0;
		int gekozenVolgnummerSpelbord;
		Scanner input = new Scanner(System.in);
		
		String [] spelletjes =  dc.geefLijstSpellen();
		
		
		do {
			
			for(int i = 0; i < spelletjes.length; i++)
			{
				
				System.out.printf("%nSpelletjes: %d: %s%n", i+1, spelletjes[i]);      //i+1 want getal ingeven is niet gelijk aan index
				
			}

			
			System.out.printf("%nGeef uw keuze in: ");
			gekozenSpel = input.nextInt();    //gekozen spel wordt ingegeven aan de hand van een getal
			spelnaam = spelletjes[gekozenSpel - 1];
		}
		while(gekozenSpel <= 0 && gekozenSpel > spelletjes.length);   //indien nummer ingegeven niet overeenkomend met een nummer uit de lijst => do opnieuw
		
		
		int[] volgnummersSpelborden = dc.geefVolgnummerSpelborden(spelnaam);
		

	
		try {

			for(int i = 0; i < volgnummersSpelborden.length; i++)
			{
				
				System.out.printf("%nSpelborden: %d: %d%n", volgnummersSpelborden[i]);      //i+1 want getal ingeven is niet gelijk aan index
				
			}

			System.out.printf("%nGeef uw keuze in: ");
			gekozenVolgnummerSpelbord =input.nextInt();    //gekozen spelbord wordt ingegeven aan de hand van een getal
			volgnummer = volgnummersSpelborden[gekozenVolgnummerSpelbord - 1];
			
		}catch(IllegalArgumentException e) {
			System.err.println(e);
		}
	
		
		
	}
	
	public void verwijderSpel()
	{
		
	}
}
