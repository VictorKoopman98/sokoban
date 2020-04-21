package cui;

import java.util.Scanner;
import java.util.InputMismatchException;
import domein.DomeinController;
import gui.Taal;

public class SokobanApplicatie
{
	private DomeinController domeincontroller;
	
	public SokobanApplicatie(DomeinController domeincontroller)
	{
		this.domeincontroller = domeincontroller;
	}
	
	public int toonHoofdpaneel1()    //menu speler kan inloggen, registreren of stoppen
	{	
		Scanner input = new Scanner(System.in);
//		Talen initialiseren
		String aanmelden = Taal.getText("meldAan"),
		       registreer = Taal.getText("registreerSpeler"),
		       stop = Taal.getText("stop"),
		       keuze = Taal.getText("keuze"),
		       keuzeOutOfBounds = Taal.getText("keuzeNietBeschikbaar"),
		       keuzeMismatch = Taal.getText("getalIngeven");      
		do {
			try {
				System.out.printf("%n\t%8S%n-----------------------------%n%s%n%s%n%s%n-----------------------------%n%s", 
						"menu1",aanmelden,registreer,stop,keuze);
				
				int keuze1 = input.nextInt();
				if(keuze1 > 3 || keuze1 < 1)
				{
					throw new IllegalArgumentException(keuzeOutOfBounds);
				}
				return keuze1;
			}
			catch(InputMismatchException e){
				System.out.printf(keuzeMismatch);
				input.next();
			}
		}while(true);
	}
	
	public int toonHoofdpaneel2() 
	{
		Scanner input = new Scanner(System.in);
		
	    String spelen = Taal.getText("speelSpel"),
		       nieuwSpel = Taal.getText("nieuwSpel"),
		       wijzigSpel = Taal.getText("wijzigSpel"),
		       afmelden = Taal.getText("afmeldenSpel"),
		       keuze = Taal.getText("keuze"),
		       keuzeOutOfBounds = Taal.getText("keuzeNietBeschikbaar"),
		       spelAfmelden = Taal.getText("afmeldenSpelO"),
		       keuzeMismatch = Taal.getText("getalIngeven");
		do {
			try {
					int keuze1 = 0;
					if (domeincontroller.getSpeler().isAdminrechten()) 
					{
						System.out.printf("%n%n\t%8S%n-----------------------------%n%s%n%s%n%s%n%s%n-----------------------------%n%s", 
								"menu2", spelen, nieuwSpel, wijzigSpel, afmelden,keuze);
						
						keuze1 = input.nextInt();
						if(keuze1 > 4 || keuze1 < 1)
						{
							throw new IllegalArgumentException(keuzeOutOfBounds);
						}
					}
					else 
					{
						System.out.printf("%n\t%8S%n-----------------------------%n%s%n%s%n-----------------------------%n%s", "menu2",spelen,spelAfmelden,keuze);
						
						keuze1 = input.nextInt();
						if(keuze1 > 2 || keuze1 < 1)
						{
							throw new IllegalArgumentException(keuzeOutOfBounds);
						}if (keuze1 == 2) 
						{
							keuze1 = 4;
						}
					}
					return keuze1;
				}
				catch(InputMismatchException e) {
					System.out.printf(keuzeMismatch);
					input.next();
			}
		}while(true);
	}

	public void run()    //verschillende use cases in volgorde laten runnen
	{
		boolean blijvenHerhalenFlag = true;
		int keuze1;
		int keuze2;
			do 
			{
				try {
					keuze1 = toonHoofdpaneel1();
					switch(keuze1) 
					{
					case 1: 
						new UC1Test(domeincontroller).meldAan();
						break;
					case 2:
						new UC2Test(domeincontroller).registreer();
						break;
					}
					if(keuze1 == 1 || keuze1 == 2)  //indien aangemeld of geregistreerd toon de spellen en opties om spellen en spelborden te voltooien
					{
						do {
							keuze2 = toonHoofdpaneel2();
							switch(keuze2) 
							{
							case 1:
								new UC3Test(domeincontroller).kiesSpel();
								break;
							case 2:
								new UC5Test(domeincontroller).maakNieuwSpel();
								break;
							case 3:
								new UC7Test(domeincontroller).wijzigSpel();
								break;
							}
						}while(keuze2 != 4);
					}
					if(keuze1 == 3){
						blijvenHerhalenFlag = false;
					}
					}catch(IllegalArgumentException e){
						System.out.println(e);
					}	
			} while(blijvenHerhalenFlag);	
	}	
}
