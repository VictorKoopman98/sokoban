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
	
	public int toonHoofdpaneel()
	{
		System.out.printf("%n\t%8S%n-----------------------------%n 1. Speler aanmelden%n 2. Nieuwe speler registreren%n 3. Stop%n-----------------------------%nGeef je keuze in: ", "menu");
		
		
//		boolean validatie = false;
		int keuze = input.nextInt();
		

		
//		
//		
	//System.out.printf("%s%n", taalObj.getText("Welkom Hoofdpaneel"));
		return keuze;
	}

	

	public void run() 
	{
	int keuze;
		do 
		{
			keuze = toonHoofdpaneel();
			
			switch(keuze) 
			{
			case 1: 
				new UC1Test(domeincontroller).meldAan();
				break;
			case 2:
				new UC2Test(domeincontroller).registreer();
				break;
			}
		}while(keuze != 3);
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
