package cui;

import domein.DomeinController;
import java.util.InputMismatchException;
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
		boolean blijvenHerhalenFlag = true;
		int keuze = 0;
		
		dc.selecteerSpel(spelnaam);
		
		dc.selecteerSpelbordMetVolgnummer(volgnummer, spelnaam);
		
		dc.toonSpelbord();
		
	
		
		do {
			try 
			{
				keuze = toonMogelijkeActies();	
				int x = 1;
				int y = 1;
				if (keuze != 6) {
					System.out.printf("%nGeef de rij van de gewenste wijziging: ");
					x = input.nextInt();
					
					System.out.printf("%nGeef de kolom van de gewenste wijziging: ");
					y = input.nextInt();
				}
				
				dc.wijzigSpelbord(x-1, y-1, keuze);
				if (keuze == 6) {
					blijvenHerhalenFlag = false;
				}
				else {
					dc.toonSpelbord();
				}
				
				
				
			}
			catch(IllegalArgumentException e)
			{
				System.err.println(e);
			}
			catch(InputMismatchException e) {
				System.out.println("Er moet een nummer worden ingegeven!");
				input.next();
			}
		}while (blijvenHerhalenFlag);
		
		dc.updateSpelbord(dc.geefSpelbord(), dc.geefNaamSpel());
		System.out.printf("Het spelbord is succesvol bijgewerkt.");
	}
	
	
	private int toonMogelijkeActies() 
	{
		do {
			Scanner input = new Scanner(System.in);

			try {		        
				System.out.printf("%nDe mogelijke acties zijn:%n"
						+ "1: Maak een doel%n"
						+ "2: Maak een muur%n"
						+ "3: Zet een man%n"
						+ "4: Zet een kist%n"
						+ "5: Maak het veld leeg%n"
						+ "6: Stop wijzigen%n");
		        
				
				System.out.printf("Geef uw keuze: ");
				int keuze = input.nextInt();
				
				if(keuze < 1 || keuze > 6)
				{
					throw new IllegalArgumentException("Ongeldige actie!");
				}	
				return keuze;
			}
			catch(InputMismatchException e) {
				System.out.println("Er moet een nummer worden ingegeven!");
				input.next();
			}
		}while(true);
		
	}
}
