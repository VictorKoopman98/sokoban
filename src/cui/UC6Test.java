package cui;

import domein.DomeinController;
import gui.Taal;

import java.util.Scanner;
import java.util.InputMismatchException;

public class UC6Test 
{
	private DomeinController dc;

	public UC6Test(DomeinController dc) 
	{	
		this.dc = dc;
	}
	
	public void maakNieuwSpelbord(int volgnummer) 
	{
		Scanner input = new Scanner(System.in);
		
		String geefRij = Taal.getText("geefRij"),
			   geefKolom = Taal.getText("geefKolom");
		boolean blijvenHerhalenFlag = true;
		
		System.out.println();

		dc.maakNieuwSpelbord(volgnummer); 
		
		dc.toonSpelbord();
		
		int keuze = toonMogelijkeActies();
		
		do {
			try{
				System.out.printf("%n%s",geefRij);
				int x = input.nextInt();
				
				System.out.printf("%n%s",geefKolom);
				int y = input.nextInt();
				System.out.println();
				
				dc.wijzigSpelbord(x-1, y-1, keuze);	
				
				dc.toonSpelbord();
			
				if (keuze == 6)
				{
					dc.voegSpelbordToe(dc.geefVelden(),dc.geefVolgnummer(),  dc.geefNaamSpel());
					blijvenHerhalenFlag = false;
				}
				
				keuze = toonMogelijkeActies();
			}
			catch(IllegalArgumentException e){
				System.out.printf("%n%s%n", e.getMessage());
			}catch(InputMismatchException e) {
				System.out.printf("%n%s%n", e.getMessage());
			}
			catch(NullPointerException e)
			{
				System.out.printf("%n%s%n", Taal.getText("manVerplicht"));
				
			}
			
		}while (blijvenHerhalenFlag);
		
	}
	
	private int toonMogelijkeActies() 
	{
		Scanner input = new Scanner(System.in);
		
		String mogelijkeActie = Taal.getText("mogelijkeActie"),
				maakDoel = Taal.getText("maakDoel"),
				maakMuur = Taal.getText("maakMuur"),
				zetMan = Taal.getText("zetMan"),
				zetKist = Taal.getText("zetKist"),
				maakVeldLeeg = Taal.getText("maakVeldLeeg"),
				stopWijzigen = Taal.getText("stopWijziging"),
				keuzeMaken = Taal.getText("keuze"),
						keuzeOutOfBounds = Taal.getText("keuzeNietBeschikbaar"),
				getalINgeven = Taal.getText("getalIngeven");
		do {
			try {
				System.out.printf("%n%s%n"
						+ "%s%n"
						+ "%s%n"
						+ "%s%n"
						+ "%s%n"
						+ "%s%n"
						+ "%s%n",mogelijkeActie,maakDoel,maakMuur,zetMan,zetKist,maakVeldLeeg,stopWijzigen);

				System.out.printf("%s",keuzeMaken);
				int keuze = input.nextInt();
				
				if(keuze < 1 || keuze > 6)
				{
					throw new IllegalArgumentException(keuzeOutOfBounds);
				}	
				return keuze;
			}
			catch(InputMismatchException e){
				System.out.printf("%n%s%n",getalINgeven);
				input.next();
			}catch(IllegalArgumentException e) {
				System.out.printf("%n%s%n", e.getMessage());
			}
		}while(true);
		
	}

}
