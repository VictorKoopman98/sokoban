package cui;

import domein.DomeinController;
import java.util.Scanner;

public class UC5Test {
	
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
				System.out.print("%nGeef de spelnaam van het nieuwe spel: ");
				spelnaam = input.next();
				
				dc.maakNieuwSpel(spelnaam);
				blijvenHerhalenFlag = false;
			}
			catch (IllegalArgumentException e) {
				System.err.println(e);
			}
			
		} while(blijvenHerhalenFlag);
		
		System.out.printf("%s is aangemaakt met 0 spelborden.", dc.geefNaamSpel());
		
		
	}

}