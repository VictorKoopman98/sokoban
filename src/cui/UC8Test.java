package cui;

import domein.DomeinController;
import gui.Taal;

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
					System.out.printf("%s",Taal.getText("geefRij"));
					x = input.nextInt();
					
					System.out.printf("%n%s ",Taal.getText("geefKolom"));
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
				System.out.printf("%s",Taal.getText("getalIngeven"));
				input.next();
			}
		}while (blijvenHerhalenFlag);
		
		dc.updateSpelbord(dc.geefVolgnummer(),dc.geefVelden(), dc.geefNaamSpel());
		System.out.printf("%s",Taal.getText("spelbordBijgewerkt"));
	}
	
	
	private int toonMogelijkeActies() 
	{
		do {
			Scanner input = new Scanner(System.in);

			try {		        
				System.out.printf("%n%s%n"
						+ "%s%n"
						+ "%s%n"
						+ "%s%n"
						+ "%s%n"
						+ "%s%n"
						+ "%s%n",Taal.getText("mogelijkeActie"),Taal.getText("maakDoel"),Taal.getText("maakMuur"),Taal.getText("zetMan")
						,Taal.getText("zetKist"),Taal.getText("maakVeldLeeg"),Taal.getText("stopWijziging"));
		        
				
				System.out.printf("%s",Taal.getText("keuze"));
				int keuze = input.nextInt();
				
				if(keuze < 1 || keuze > 6)
				{
					throw new IllegalArgumentException(Taal.getText("ongeldigActie"));
				}	
				return keuze;
			}
			catch(InputMismatchException e) {
				System.out.printf("%s",Taal.getText("getalIngeven"));
				input.next();
			}
		}while(true);
		
	}
}
