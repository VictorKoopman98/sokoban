package cui;

import domein.DomeinController;
import java.util.Scanner;

public class UC6Test {
	
	DomeinController dc;

	public UC6Test(DomeinController dc) {
		// TODO Auto-generated constructor stub
		this.dc = dc;
	}
	
	public void maakNieuwSpelbord() {
		Scanner input = new Scanner(System.in);
		int aantalVelden = 0;
		System.out.printf("%n Legende:%n Muur = W %n"
				+ "Man = M%n Veld met een doel = G%n"
				+ "Leeg veld = N%n Veld met een kist = K%n"
				+ "Kist die op een doel staat = F");
		
		do {
			try {
				System.out.printf("%n geef het symbool voor het %d e vak: ", aantalVelden+1);
			}
			catch (IllegalArgumentException e) {
				System.err.println(e);
			}
			
			
			aantalVelden ++;
		}while(aantalVelden<100);
	}
	
	

}
