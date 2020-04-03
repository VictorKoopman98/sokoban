package cui;

import domein.DomeinController;
import gui.Taal;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UC8Test
{
	private DomeinController dc;
	private Taal taalObj;
	
	public UC8Test(DomeinController dc, Taal taalObj)
	{
		this.taalObj = taalObj;
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
					System.out.printf("%s",taalObj.getText("geefRij"));
					x = input.nextInt();
					
					System.out.printf("%n%s ",taalObj.getText("geefKolom"));
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
				System.out.printf("%s",taalObj.getText("getalIngeven"));
				input.next();
			}
		}while (blijvenHerhalenFlag);
		
		dc.updateSpelbord(dc.geefSpelbord(), dc.geefNaamSpel());
		System.out.printf("%s",taalObj.getText("spelbordBijgewerkt"));
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
						+ "%s%n",taalObj.getText("mogelijkeActie"),taalObj.getText("maakDoek"),taalObj.getText("maakMuur"),taalObj.getText("zetMan"),taalObj.getText("zetKist"),taalObj.getText("maakVeldLeeg"),taalObj.getText("stopWijziging"));
		        
				
				System.out.printf("%s",taalObj.getText("keuze"));
				int keuze = input.nextInt();
				
				if(keuze < 1 || keuze > 6)
				{
					throw new IllegalArgumentException(taalObj.getText("ongeldigActie"));
				}	
				return keuze;
			}
			catch(InputMismatchException e) {
				System.out.printf("%s",taalObj.getText("getalIngeven"));
				input.next();
			}
		}while(true);
		
	}
}
