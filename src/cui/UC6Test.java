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
		
//		System.out.printf("%nGeef het volgnummer van het spelbord in: ");
//		int volgnummer = input.nextInt();
		
		System.out.println();

		dc.maakNieuwSpelbord(volgnummer); 
		
		dc.toonSpelbord();
		
		int keuze = toonMogelijkeActies();
		
		do {
			try{
				System.out.printf("%n%s", taalObj.getText("geefRij"));
				int x = input.nextInt();
				
				System.out.printf("%n%s",taalObj.getText("geefKolom"));
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
		input.close();
	}
	
	
	private int toonMogelijkeActies() 
	{
		Scanner input = new Scanner(System.in);

		do {
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
			catch(InputMismatchException e){
				System.out.printf("%s",taalObj.getText("getalIngeven"));
			}
		}while(true);
		
	}
	
	

}
