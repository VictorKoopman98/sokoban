package cui;

import domein.DomeinController;
import java.util.Scanner;

public class UC6Test 
{
	
	DomeinController dc;

	public UC6Test(DomeinController dc) 
	{
		this.dc = dc;
	}

	
	public void maakNieuwSpelbord(int volgnummer) 
	{
		Scanner input = new Scanner(System.in);
		
//		System.out.printf("%nGeef het volgnummer van het spelbord in: ");
//		int volgnummer = input.nextInt();
		
		System.out.println();

		dc.maakNieuwSpelbord(volgnummer); 
		
		dc.toonSpelbord();
		
		int keuze = toonMogelijkeActies();
		
		do {
			try{
				System.out.printf("%nGeef de rij van de gewenste wijziging: ");
				int x = input.nextInt();
				
				System.out.printf("%nGeef de kolom van de gewenste wijziging: ");
				int y = input.nextInt();
				System.out.println();
				try {
					dc.wijzigSpelbord(x-1, y-1, keuze);	
				}
				catch(IllegalArgumentException e){
					System.err.println(e);
				}
				
				dc.toonSpelbord();
				
				keuze = toonMogelijkeActies();
			}
			catch(IllegalArgumentException e)
			{
				System.err.println(e);
			}
		}while (keuze != 6);
		
		dc.voegSpelbordToe(dc.geefSpelbord(), dc.geefNaamSpel());	
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
