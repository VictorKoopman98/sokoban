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
		
		System.out.printf("%n\t%8S%n-----------------------------%n 1. Speler aanmelden%n 2. Nieuwe speler registreren%n 3. Spel afsluiten%n-----------------------------%nGeef je keuze in: ", "menu1");
		int keuze = input.nextInt();
		
		if(keuze > 3 || keuze < 1 || keuze != (int)keuze)
		{
			throw new IllegalArgumentException("Keuze niet beschikbaar!");
		}
		
		return keuze;
	}
	
	
	public int toonHoofdpaneel2() 
	{
		
		int keuze = 0;
		if (domeincontroller.getSpeler().isAdminrechten()) 
		{
			System.out.printf("%n%n\t%8S%n-----------------------------%n 1. Speel spel%n 2. Maak nieuw spel%n 3. Wijzig een spel%n 4. Afmelden%n-----------------------------%nGeef je keuze in: ", "menu2");
			keuze = input.nextInt();
			
			if(keuze > 4 || keuze < 1 || keuze != (int)keuze)
			{
				throw new IllegalArgumentException("Keuze niet beschikbaar!");
			}
		}
		else 
		{
			System.out.printf("%n%n\t%8S%n-----------------------------%n1. Speel spel%n2. Afmelden%n-----------------------------%nGeef je keuze in: ", "menu2");
			keuze = input.nextInt();
			
			
			if(keuze > 2 || keuze < 1 || keuze != (int)keuze)
			{
				throw new IllegalArgumentException("Keuze niet beschikbaar!");
			}
			if (keuze == 2) 
			{
				keuze = 4;
			}
		}
		
		return keuze;
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
					if(keuze1 == 3)
					{
						blijvenHerhalenFlag = false;
					}
					}
					catch(IllegalArgumentException e)
					{
						System.err.println(e);
					}
				
				
			} while(blijvenHerhalenFlag);
			
	}	
	
	
	
	
	
	
	
	
	public void kiesTaal()
    {
	String taal = "";
	do
	{
	    System.out.print("Kies een taal (NL)/ choose a language (EN)/ Choisissez une langue(FR): ");
	    try
	    {
		taal = input.nextLine();
		if (!(("NL".equals(taal)) || ("EN".equals(taal)) || ("FR".equals(taal))))
		{
		    throw new IllegalArgumentException("Verkeerde input/ Wrong input/ Entree incorrecte");
		}
	    } catch (IllegalArgumentException ie)
	    {
		System.out.println(ie.getMessage());
	    }
	} while (!(taal.equals("NL") || taal.equals("FR") || taal.equals("EN")));
	taalObj = new Taal(taal);
    }
    
}
