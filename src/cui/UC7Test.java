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
		
		String spelletje = Taal.getText("spelletje"),
			   keuzeMaken = Taal.getText("keuze"),
			   spelbord1 = Taal.getText("spelbord1"),
			   hetSpel = Taal.getText("hetSpel"),
			   spelGewijzigdEnBevat = Taal.getText("spelGewijzigdEnBevat"),
			   spelbord = Taal.getText("spelbord"),
			   spelborden = Taal.getText("spelborden"),
			   getalIngeven = Taal.getText("getalIngeven"),
			   keuzeNietBeschikbaar = Taal.getText("keuzeNietBeschikbaar");
		
		int gekozenSpel;
		String spelnaam = null;
		int volgnummer = 0;
		int gekozenVolgnummerSpelbord;
		
		String [] spelletjes = dc.geefLijstSpellen();
		
		boolean flag = true;
		do {
			try {
				for(int i = 0; i < spelletjes.length; i++)
				{
					System.out.printf("%n%s %d: %s%n", spelletje,i+1, spelletjes[i]);      //i+1 want getal ingeven is niet gelijk aan index
				}

				System.out.printf("%n%s",keuzeMaken);
				gekozenSpel = input.nextInt();    //gekozen spel wordt ingegeven aan de hand van een getal
				if(gekozenSpel <= 0 && gekozenSpel > spelletjes.length) {
					throw new IllegalArgumentException(keuzeNietBeschikbaar);
				}
				spelnaam = spelletjes[gekozenSpel - 1];
				flag = false;
			}catch(InputMismatchException e) {
				System.out.printf("%n%s%n", getalIngeven);
				input.next();
			}catch(IllegalArgumentException e) {
				System.out.printf("%n%s%n", e.getMessage());
			}catch(ArrayIndexOutOfBoundsException e) {
				System.out.printf("%n%s%n", keuzeNietBeschikbaar);
			}
		}
		while(flag);   //indien nummer ingegeven niet overeenkomend met een nummer uit de lijst => do opnieuw
		
		dc.selecteerSpel(spelnaam);
		
		int[] volgnummersSpelborden = dc.geefVolgnummerSpelborden(spelnaam);
		
		int keuze = 0;
		boolean blijvenHerhalenFlag = true;
		do {
			do {
				try {

					for(int i = 0; i < volgnummersSpelborden.length; i++)
					{
						System.out.printf("%n%s %d:%n", spelbord1,volgnummersSpelborden[i]);      //i+1 want getal ingeven is niet gelijk aan index
					}
					System.out.printf("%n%s",keuzeMaken);
					
					gekozenVolgnummerSpelbord = input.nextInt();    //gekozen spelbord wordt ingegeven aan de hand van een getal
					
					if(gekozenVolgnummerSpelbord < 1 || gekozenVolgnummerSpelbord > volgnummersSpelborden.length)
						throw new IllegalArgumentException(keuzeNietBeschikbaar);
					
					volgnummer = volgnummersSpelborden[gekozenVolgnummerSpelbord - 1];
					
					blijvenHerhalenFlag = false;
				}catch(IllegalArgumentException e) {
					System.out.printf("%n%s%n", e.getMessage());
				}catch(InputMismatchException e) {
					System.out.printf("%n%s%n", getalIngeven);
					input.next();
				}
			}while(blijvenHerhalenFlag);
			
			uc8test.wijzigSpelbord(spelnaam, volgnummer);
			
			keuze = toonActies();
		}while(keuze != 2);
		
		System.out.printf("%n%s '%s' %s %d %s%n",hetSpel,spelnaam, spelGewijzigdEnBevat,
				dc.geefAantalSpelborden(), dc.geefAantalSpelborden() ==1 ? spelbord : spelborden);
	}
	
	private int toonActies() 
	{
		Scanner input = new Scanner(System.in);
		
		String wijzigSpelbord = Taal.getText("wijzigSpelbord"),
		       spelVerlaten = Taal.getText("spelVerlaten"),
		       keuzeMaken = Taal.getText("keuze"),
		       ongeldigeActie = Taal.getText("ongeldigActie"),
		       getalIngeven = Taal.getText("getalIngeven"),
		       spelVerlatenNr = Taal.getText("spelVerlatenO");
		
		boolean flag2 = true;
		int keuze = 0;
		do {
			try {
				System.out.printf("%n-----------------------------%n %s%n %s%n-----------------------------%n%s ",wijzigSpelbord,spelVerlatenNr,keuzeMaken);
				keuze = input.nextInt();
				
				if(keuze < 1 || keuze > 2){
					throw new IllegalArgumentException(ongeldigeActie);
				}	
				flag2 = false;
			}
			catch(InputMismatchException e){
				System.out.printf("%n%s%n", getalIngeven);
				input.next();
			}catch(IllegalArgumentException e) {
				System.out.printf("%n%s%n", e.getMessage());
			}
		}while(flag2);
		return keuze;
	}
	
}
