package cui;

import java.util.Scanner;
import java.util.InputMismatchException;
import domein.DomeinController;
import gui.Taal;

public class SokobanApplicatie
{
	private DomeinController domeincontroller;
	private Taal taalObj;

	
	public SokobanApplicatie(DomeinController domeincontroller)
	{
		this.domeincontroller = domeincontroller;
	}
	
	
	public int toonHoofdpaneel1()    //menu spler kan inloggen, registreren of stoppen
	{
		Scanner input = new Scanner(System.in);
		do {
			try {
				
				System.out.printf("%n\t%8S%n-----------------------------%n%s%n%s%n%s%n-----------------------------%n%s", "menu1",taalObj.getText("meldAan"),taalObj.getText("registreerSpeler"),taalObj.getText("stop"),taalObj.getText("keuze"));
				int keuze = input.nextInt();
				
				if(keuze > 3 || keuze < 1)
				{
					throw new IllegalArgumentException(taalObj.getText("keuzeNietBeschikbaar"));
				}
				return keuze;
			}
			catch(InputMismatchException e){
				System.out.printf(taalObj.getText("getalIngeven"));
				input.next();
			}
		}while(true);
	}
	
	
	public int toonHoofdpaneel2() 
	{
		Scanner input = new Scanner(System.in);
		do {
			try {
					int keuze = 0;
					if (domeincontroller.getSpeler().isAdminrechten()) 
					{
						System.out.printf("%n%n\t%8S%n-----------------------------%n%s%n%s%n%s%n%s%n-----------------------------%n%s", "menu2",taalObj.getText("speelSpel"),taalObj.getText("nieuwSpel"),taalObj.getText("wijzigSpel"),taalObj.getText("afmeldenSpel"));
						keuze = input.nextInt();
						
						if(keuze > 4 || keuze < 1)
						{
							throw new IllegalArgumentException(taalObj.getText("keuzeNietBeschikbaar"));
						}
					}
					else 
					{
						System.out.printf("%n\t%8S%n-----------------------------%n%s%n%s%n-----------------------------%n%s", "menu2",taalObj.getText("speelSpel"),taalObj.getText("afmeldenSpel"),taalObj.getText("keuze"));
						keuze = input.nextInt();
						
						
						if(keuze > 2 || keuze < 1)
						{
							throw new IllegalArgumentException(taalObj.getText("keuzeNietBeschikbaar"));
						}
						if (keuze == 2) {
							keuze = 4;
						}
					}
					return keuze;
				}
				catch(InputMismatchException e) {
					System.out.printf(taalObj.getText("getalIngeven"));
					input.next();
			}

		}while(true);
	}

	
	public void run()    //verschillende use cases in volgorde laten runnen
	{
		kiesTaal();
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
						new UC1Test(domeincontroller,taalObj).meldAan();
						break;
					case 2:
						new UC2Test(domeincontroller,taalObj).registreer();
						break;
					}
					
					if(keuze1 == 1 || keuze1 == 2)  //indien aangemeld of geregistreerd toon de spellen en opties om spellen en spelborden te voltooien
					{
						do {
							keuze2 = toonHoofdpaneel2();
							switch(keuze2) 
							{
							case 1:
								new UC3Test(domeincontroller,taalObj).kiesSpel();
								break;
							case 2:
								new UC5Test(domeincontroller,taalObj).maakNieuwSpel();
								break;
							case 3:
								new UC7Test(domeincontroller,taalObj).wijzigSpel();
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
						System.out.println(e);
					}
				
				
			} while(blijvenHerhalenFlag);
			
	}	

	public void kiesTaal()
    {
		String taal = "";
		Scanner input = new Scanner(System.in);
		do
		{
		    System.out.print("Kies een taal (NL)/ Choose a language (EN)/ Choisissez une langue (FR): ");
		    try
		    {
		    	taal = input.nextLine();
				if (!(("NL".equals(taal)) || ("EN".equals(taal)) || ("FR".equals(taal))))
				{
				    throw new IllegalArgumentException("Verkeerde input/ Wrong input/ Entrée incorrecte");
				}
		    } catch (IllegalArgumentException ie)
		    {
			System.out.println(ie.getMessage());
		    }
		} while (!(taal.equals("NL") || taal.equals("FR") || taal.equals("EN")));
		
		taalObj = new Taal(taal);
    }
}
