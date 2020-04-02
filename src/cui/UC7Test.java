package cui;

import java.util.Scanner;
import java.util.InputMismatchException;
import domein.DomeinController;

public class UC7Test 
{
	DomeinController dc;
	private UC8Test uc8test;
	
	public UC7Test(DomeinController dc) 
	{
		this.dc = dc;
		uc8test = new UC8Test(dc);
	}
	
	
	public void wijzigSpel() 
	{ 	
		int gekozenSpel;
		String spelnaam;
		int volgnummer = 0;
		int gekozenVolgnummerSpelbord;
		Scanner input = new Scanner(System.in);
		
		String [] spelletjes = DomeinController.geefLijstSpellen();
		
		do {
			for(int i = 0; i < spelletjes.length; i++)
			{
				System.out.printf("%nSpelletje %d: %s%n", i+1, spelletjes[i]);      //i+1 want getal ingeven is niet gelijk aan index
			}

			System.out.printf("%nGeef uw keuze in: ");
			gekozenSpel = input.nextInt();    //gekozen spel wordt ingegeven aan de hand van een getal
			spelnaam = spelletjes[gekozenSpel - 1];
		}
		while(gekozenSpel <= 0 && gekozenSpel > spelletjes.length);   //indien nummer ingegeven niet overeenkomend met een nummer uit de lijst => do opnieuw
		
		dc.selecteerSpel(spelnaam);
		
		int[] volgnummersSpelborden = dc.geefVolgnummerSpelborden(spelnaam);
		
		int keuze = 0;
		
		do {
			try {
				do {
					try {

						for(int i = 0; i < volgnummersSpelborden.length; i++)
						{
							
							System.out.printf("%nSpelbord %d:%n", volgnummersSpelborden[i]);      //i+1 want getal ingeven is niet gelijk aan index
							
						}

						System.out.printf("%nGeef uw keuze in: ");
						gekozenVolgnummerSpelbord =input.nextInt();    //gekozen spelbord wordt ingegeven aan de hand van een getal
						System.out.println();
						volgnummer = volgnummersSpelborden[gekozenVolgnummerSpelbord - 1];
						
					}catch(IllegalArgumentException e) 
					{
						System.err.println(e);
					}
				}while(!checkVolgnummerOk(volgnummer, volgnummersSpelborden));
				
				uc8test.wijzigSpelbord(spelnaam, volgnummer);
				
				keuze = toonActies();
			}
			catch(IllegalArgumentException e)
			{
				System.err.println(e);
			}
			
		}while(keuze != 2);
		
		System.out.printf("Het spel: '%s' is gewijzigd en bevat nu %d %s", spelnaam, dc.geefAantalSpelborden(), dc.geefAantalSpelborden() ==1 ? "spelbord" : "spelborden");
	}
	
	private int toonActies() 
	{
		do {
			Scanner input = new Scanner(System.in);
			try {
				
				System.out.printf("%n-----------------------------%n 1. Wijzig een spelbord%n 2. Spel verlaten%n-----------------------------%nGeef je keuze in: ");
				int keuze = input.nextInt();
				
				if(keuze < 1 || keuze > 2)
				{
					throw new IllegalArgumentException("Ongeldige actie!");
				}	
				
				System.out.println();
				return keuze;
			}
			catch(InputMismatchException e){
				System.out.println("Er moet een nummer worden ingegeven!");
				input.next();
			}
		}while(true);
		
	}
	
	
	private boolean checkVolgnummerOk(int volgnummer, int[] volgnummersSpelborden) 
	{
        boolean volgnummerOk = false; 
        for (int element : volgnummersSpelborden) 
        { 
            if (element == volgnummer) 
            { 
                volgnummerOk = true; 
                break; 
            } 
        } 
        return volgnummerOk;
	}
	
	
	
}
