package cui;

import domein.DomeinController;
import gui.Taal;

import java.util.Scanner;
import java.util.InputMismatchException;

public class UC5Test 
{
	
	private DomeinController dc;
	private UC6Test uc6test;
	private Taal taalObj;

	public UC5Test(DomeinController dc, Taal taalObj) 
	{
		this.taalObj = taalObj;
		this.dc = dc;
		this.uc6test = new UC6Test(dc,taalObj);
	}
	
	
	public void maakNieuwSpel() 
	{
        String spelnaam = "";
		boolean blijvenHerhalenFlag = true;
		int aantalSpelborden = 0;
		
		do 
		{
			Scanner input = new Scanner(System.in);
			try 
			{
				System.out.printf("%n%s",taalObj.getText("geefSpelnaamNieuweSpel"));
				spelnaam = input.nextLine();
				
				dc.maakNieuwSpel(spelnaam);
				blijvenHerhalenFlag = false;
				
				dc.selecteerSpel(spelnaam);
				
				uc6test.maakNieuwSpelbord(aantalSpelborden+1);
				aantalSpelborden++;
				
				int actie = toonActies();
				
				do {
					if (actie == 1) 
					{
						uc6test.maakNieuwSpelbord(aantalSpelborden+1);
						aantalSpelborden++;
						
						actie = toonActies();
					}
					else if (actie == 2) 
					{
						System.out.printf("%s %s%n%n", dc.geefGebruikersnaam(),taalObj.getText("stopMetSpelbordenAanmaken"));
					}
				}while ( actie != 2);

			}
			catch (IllegalArgumentException e) 
			{
				System.err.println(e);
			}
		} while(blijvenHerhalenFlag);
		
		dc.selecteerSpel(spelnaam);
		
		System.out.printf("%s %s %d %s", dc.geefNaamSpel(), taalObj.getText("isAangemaakt"),aantalSpelborden, aantalSpelborden <= 1 ? taalObj.getText("spelbord"): taalObj.getText("spelborden"));
	}
	
	
	private int toonActies() 
	{	
		do
		{
			Scanner input = new Scanner(System.in);
			try {

				System.out.printf("%n%n-----------------------------%n %s%n %s%n-----------------------------%n%s ",taalObj.getText("nieuwSpelbord"),taalObj.getText("stoppen"),taalObj.getText("keuze"));
				int actie = input.nextInt();
				
				if(actie < 1 || actie > 2)
				{
					throw new IllegalArgumentException(taalObj.getText("ongeldigActie"));
				}	
				return actie;
			}
			catch(InputMismatchException e) {
				System.out.printf("%s",taalObj.getText("getalIngeven"));
				input.next();
			}
		}while(true);
	}
	
}