package cui;

import java.util.Scanner;
import java.util.InputMismatchException;
import domein.DomeinController;
import gui.Taal;

public class UC7Test 
{
	private DomeinController dc;
	private UC8Test uc8test;
	
	public UC7Test(DomeinController dc) 
	{
		this.dc = dc;
		uc8test = new UC8Test(dc);
	}
	
	public void wijzigSpel() 
	{ 	
		Scanner input = new Scanner(System.in);
		
		int gekozenSpel;
		String spelnaam;
		int volgnummer = 0;
		int gekozenVolgnummerSpelbord;
		
		String [] spelletjes = dc.geefLijstSpellen();
		
		do {
			for(int i = 0; i < spelletjes.length; i++)
			{
				System.out.printf("%n%s %d: %s%n", Taal.getText("spelletje"),i+1, spelletjes[i]);      //i+1 want getal ingeven is niet gelijk aan index
			}

			System.out.printf("%n%s",Taal.getText("keuze"));
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
							
							System.out.printf("%n%s %d:%n", Taal.getText("spelbord1"),volgnummersSpelborden[i]);      //i+1 want getal ingeven is niet gelijk aan index
							
						}

						System.out.printf("%n%s",Taal.getText("keuze"));
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
		
		System.out.printf("%s '%s' %s %d %s",Taal.getText("hetSpel") ,spelnaam, Taal.getText("spelGewijzigdEnBevat"),
				dc.geefAantalSpelborden(), dc.geefAantalSpelborden() ==1 ? Taal.getText("spelbord") : Taal.getText("spelborden"));
	}
	
	private int toonActies() 
	{
		do {
			Scanner input = new Scanner(System.in);
			try {
				
				System.out.printf("%n-----------------------------%n %s%n %s%n-----------------------------%n%s ",
						Taal.getText("wijzigSpelbord"),Taal.getText("spelVerlaten"),Taal.getText("keuze"));
				int keuze = input.nextInt();
				
				if(keuze < 1 || keuze > 2)
				{
					throw new IllegalArgumentException(Taal.getText("ongeldigActie"));
				}	
				
				System.out.println();
				return keuze;
			}
			catch(InputMismatchException e){
				System.out.println(Taal.getText("getalIngeven"));
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
