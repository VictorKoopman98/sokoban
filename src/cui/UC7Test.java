package cui;

import java.util.Scanner;
import java.util.InputMismatchException;
import domein.DomeinController;
import gui.Taal;

public class UC7Test 
{
	DomeinController dc;
	private UC8Test uc8test;
	private Taal taalObj;
	
	public UC7Test(DomeinController dc, Taal taalObj) 
	{
		this.taalObj = taalObj;
		this.dc = dc;
		uc8test = new UC8Test(dc,taalObj);
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
				System.out.printf("%n%s %d: %s%n", taalObj.getText("spelletje"),i+1, spelletjes[i]);      //i+1 want getal ingeven is niet gelijk aan index
			}

			System.out.printf("%n%s",taalObj.getText("keuze"));
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
							
							System.out.printf("%n%s %d:%n", taalObj.getText("spelbord1"),volgnummersSpelborden[i]);      //i+1 want getal ingeven is niet gelijk aan index
							
						}

						System.out.printf("%n%s",taalObj.getText("keuze"));
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
		
		System.out.printf("%s '%s' %s %d %s",taalObj.getText("hetSpel") ,spelnaam, taalObj.getText("spelGewijzigdEnBevat"),dc.geefAantalSpelborden(), dc.geefAantalSpelborden() ==1 ? taalObj.getText("spelbord") : taalObj.getText("spelborden"));
	}
	
	private int toonActies() 
	{
		do {
			Scanner input = new Scanner(System.in);
			try {
				
				System.out.printf("%n-----------------------------%n %s%n %s%n-----------------------------%n%s ",taalObj.getText("wijzigSpelbord"),taalObj.getText("spelVerlaten"),taalObj.getText("keuze"));
				int keuze = input.nextInt();
				
				if(keuze < 1 || keuze > 2)
				{
					throw new IllegalArgumentException(taalObj.getText("ongeldigActie"));
				}	
				
				System.out.println();
				return keuze;
			}
			catch(InputMismatchException e){
				System.out.println(taalObj.getText("getalIngeven"));
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
