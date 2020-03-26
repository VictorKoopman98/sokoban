package cui;

import java.util.Scanner;

import domein.DomeinController;

import gui.Taal;

public class SokobanApplicatie
{
	Scanner input = new Scanner(System.in);
	private DomeinController domeincontroller;
	private Taal taalObj;
	
	
	public SokobanApplicatie(DomeinController domeincontroller)
	{
		this.domeincontroller = domeincontroller;
	}
	
	
	public int toonHoofdpaneel1()    //menu spler kan inloggen, registreren of stoppen
	{
		System.out.printf("%n\t%8S%n-----------------------------%n 1. Speler aanmelden%n 2. Nieuwe speler registreren%n 3. Stop%n-----------------------------%nGeef je keuze in: ", "menu1");
		int keuze = input.nextInt();
		
		return keuze;
	}
	
	public int toonHoofdpaneel2() {
		System.out.printf("%n%n\t%8S%n-----------------------------%n 1. Spel spelen%n 2. Maak een nieuw spel aan%n 3. Stoppen%n-----------------------------%nGeef je keuze in: ", "menu2");
		int keuze = input.nextInt();
		return keuze;
	}

	
	public void run()    //verschillende use cases in volgorde laten runnen
	{
		
	int keuze1;
	int keuze2;
		do 
		{
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
					switch(keuze2) {
					case 1:
						
						new UC6Test(domeincontroller).maakNieuwSpelbord();
						break;
					case 2:
						new UC5Test(domeincontroller).maakNieuwSpel();
						break;
					}
				}while(keuze2 != 3);
				
			}
			
		} while(keuze1 != 3);
		
	}	
	
	
	
	
	
	
	
	
	public void kiesTaal()
    {
	String taal = "";
	do
	{
	    System.out.print("Kies een taal (nl)/ choose a language (en)/ Choisissez une langue(fr): ");
	    try
	    {
		taal = input.nextLine();
		if (!(("nl".equals(taal)) || ("en".equals(taal)) || ("fr".equals(taal))))
		{
		    throw new IllegalArgumentException("Verkeerde input/ Wrong input/ Entree incorrecte");
		}
	    } catch (IllegalArgumentException ie)
	    {
		System.out.println(ie.getMessage());
	    }
	} while (!(taal.equals("nl") || taal.equals("fr") || taal.equals("en")));
	taalObj = new Taal(taal);
    }
    
}
