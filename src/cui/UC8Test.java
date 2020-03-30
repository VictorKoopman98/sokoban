package cui;

import domein.DomeinController;

import java.util.Scanner;

public class UC8Test
{
	private DomeinController dc;
	
	public UC8Test(DomeinController dc)
	{
		this.dc = dc;
	}
	
	
	public void wijzigSpelbord(String spelnaam)
	{
		Scanner input = new Scanner(System.in);
		
		int keuze = toonMogelijkeActies();
		
		do 
		{
			
			dc.toonSpelbord();
			
			System.out.printf("%nGeef de rij van de gewenste wijziging: ");
			int x = input.nextInt();
			
			System.out.printf("%nGeef de kolom van de gewenste wijziging: ");
			int y = input.nextInt();
			
			dc.wijzigSpelbord(x-1, y-1, keuze);
			
			dc.toonSpelbord();
			
			keuze = toonMogelijkeActies();
			
		}while (keuze != 6);
		
		dc.voegSpelbordToe(dc.geefSpelbord(), dc.geefNaamSpel());
		
		System.out.printf("Het spelbord is succesvol afgewerkt.");
	}
	
	
	private int toonMogelijkeActies() 
	{
		Scanner input = new Scanner(System.in);
        
		System.out.printf("%nDe mogelijke acties zijn:%n"
				+ "1: Maak een doel%n"
				+ "2: Maak een muur%n"
				+ "3: Zet een man%n"
				+ "4: Zet een kist%n"
				+ "5: Maak het veld leeg%n"
				+ "6: Stop wijzigen%n");
        
		
		System.out.printf("Geef uw keuze: ");
		int keuze = input.nextInt();
		return keuze;
	}
}
