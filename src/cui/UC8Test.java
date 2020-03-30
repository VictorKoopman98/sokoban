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
	
	
	public void wijzigSpelbord(String spelnaam, int volgnummer)
	{
		Scanner input = new Scanner(System.in);
		
		int keuze = 0;
		
		dc.selecteerSpel(spelnaam);
		
		dc.selecteerSpelbordMetVolgnummer(volgnummer, spelnaam);
		
		dc.toonSpelbord();
		
		keuze = toonMogelijkeActies();
		
		do {
			try 
			{
				System.out.printf("%nGeef de rij van de gewenste wijziging: ");
				int x = input.nextInt();
				
				System.out.printf("%nGeef de kolom van de gewenste wijziging: ");
				int y = input.nextInt();
				
				dc.wijzigSpelbord(x-1, y-1, keuze);
				
				dc.toonSpelbord();
				
				keuze = toonMogelijkeActies();		
			}
			catch(IllegalArgumentException e)
			{
				System.err.println(e);
			}
			
		}while (keuze != 6);
		
		dc.updateSpelbord(dc.geefSpelbord(), dc.geefNaamSpel());
		
		System.out.printf("Het spelbord is succesvol bijgewerkt.");
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
