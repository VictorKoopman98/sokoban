package cui;

import domein.DomeinController;
import java.util.Scanner;

public class UC6Test {
	
	DomeinController dc;

	public UC6Test(DomeinController dc) {
		// TODO Auto-generated constructor stub
		this.dc = dc;
	}
	
	private int toonMogelijkeActies() {
		Scanner input = new Scanner(System.in);
		// setDoel, setMuur, Man, Kist, veld leeg
		System.out.printf("%nDe mogelijke acties zijn:%n"
				+ "1: Maak een doel%n"
				+ "2: Maak een muur%n"
				+ "3: Zet een man%n"
				+ "4: Zet een kist%n"
				+ "5: Maak het veld leeg%n"
				+ "6: Stop wijzigen");
		int keuze;
		System.out.printf("Geef uw keuze: ");
		keuze = input.nextInt();
		return keuze;
	}
	
	public void maakNieuwSpelbord() {
		Scanner input = new Scanner(System.in);
		System.out.printf("%nGeef het volgnummer van het spelbord in: ");
		int volgnummer = input.nextInt();
//		System.out.printf("%n Legende:%n Muur = W %n"
//				+ "Man = M%n Veld met een doel = G%n"
//				+ "Leeg veld = N%n Veld met een kist = K%n"
//				+ "Kist die op een doel staat = F%n");
		
		dc.maakNieuwSpelbord(volgnummer);
		dc.toonSpelbord();
		int keuze = toonMogelijkeActies();
		do {
			
			System.out.printf("%nGeef de rij van de gewenste wijziging: ");
			int x = input.nextInt();
			System.out.printf("%nGeef de kolom van de gewenste wijziging");
			int y = input.nextInt();
			dc.wijzigSpelbord(x, y, keuze);	
			keuze = toonMogelijkeActies();
			dc.toonSpelbord();
		}while (keuze != 6);
		
		dc.voegSpelbordToe(dc.geefSpelbord(), dc.geefNaamSpel());	
	}
	
	

}
