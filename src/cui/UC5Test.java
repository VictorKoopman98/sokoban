package cui;

import domein.DomeinController;
import java.util.Scanner;

public class UC5Test {
	
	private UC6Test uc6test;
	private DomeinController dc;

	public UC5Test(DomeinController dc) {
		// TODO Auto-generated constructor stub
		this.dc = dc;
	}
	
	public void maakNieuwSpel() {
		String spelnaam = "";
		Scanner input = new Scanner(System.in);
		boolean blijvenHerhalenFlag = true;
		
		do {
			try {
				System.out.printf("%nGeef de spelnaam van het nieuwe spel: ");
				spelnaam = input.next();
				
				dc.maakNieuwSpel(spelnaam);
				blijvenHerhalenFlag = false;
				System.out.print("Nieuw spelbord aanmaken (1) of stoppen(2)?");
				int actie = input.nextInt();
				do {
					uc6test.maakNieuwSpelbord();
					System.out.print("Nieuw spel aanmaken (1) of stoppen(2)?");
					actie = input.nextInt();
				}while(actie != 2);
			}
			catch (IllegalArgumentException e) {
				System.err.println(e);
			}
			
		} while(blijvenHerhalenFlag);
		dc.selecteerSpel(spelnaam);
		
		System.out.printf("%s is aangemaakt met 0 spelborden.", dc.geefNaamSpel());
		
		
	}

}