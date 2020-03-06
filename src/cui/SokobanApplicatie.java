package cui;

import java.util.Scanner;

import domein.DomeinController;
import gui.Taal;

public class SokobanApplicatie
{
	Scanner input = new Scanner(System.in);
	private DomeinController domeincontroller;
	private Taal taal;
	
	public SokobanApplicatie(DomeinController domeincontroller)
	{
		this.domeincontroller = domeincontroller;
	}
	
	public int toonHoofdpaneel()
	{
		System.out.printf("%n\t%8S%n-----------------------------%n 1. Speler aanmelden%n 2. Nieuwe speler registreren%n 3. Stop%n-----------------------------%nGeef je keuze in: ", "menu");
		
		
//		boolean validatie = false;
		int keuze = input.nextInt();
		
//		kiesTaal();
//		
//		
//		System.out.printf("%s%n", taal.getText("Welkom Hoofdpaneel"));
		return keuze;
	}

	private void kiesTaal()
	{
		// TODO Auto-generated method stub
		
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
}
