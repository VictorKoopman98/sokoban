package cui;

import domein.DomeinController;
import java.util.Scanner;

public class UC5Test {
	
	private UC6Test uc6test;
	private DomeinController dc;

	public UC5Test(DomeinController dc) 
	{
		this.dc = dc;
	}
	
	public void maakNieuwSpel() 
	{
        String spelnaam = "";
		Scanner input = new Scanner(System.in);
		boolean blijvenHerhalenFlag = true;
		
		do {
			try {
				System.out.printf("%nGeef de spelnaam van het nieuwe spel: ");
				spelnaam = input.next();
				
				dc.maakNieuwSpel(spelnaam);
				System.out.printf("%nNieuw spelbord aanmaken (1) %n%nstoppen(2)%n%nGeef uw keuze in: ");
				int actie = input.nextInt();
				
				if(actie == 1)
				{
					uc6test.maakNieuwSpelbord();
				}
				else if(actie == 2)
				{
					System.out.printf("%s is gestopt", dc.geefGebruikersnaam());
				}
				blijvenHerhalenFlag = false;
			}
			catch (IllegalArgumentException e) {
				System.err.println(e);
			}
			
		} while(blijvenHerhalenFlag);
		
		dc.selecteerSpel(spelnaam);
		
		System.out.printf("%s is aangemaakt met 0 spelborden.", dc.geefNaamSpel());
		
		
	}

}