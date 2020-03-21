package domein;

import domein.Veld;

public class Spelbord {
	
	private boolean isVoltooid;
	private int aantalVerplaatsingen;
	private int locatieMan;
	Veld[][] bord = new Veld[10][10];
	Veld[] kisten;
	Man man;
	

	public Spelbord() 
	{
		
	}
	
//	//Array maken van alle objecten van de klasse Vak
//	Veld spelbord[] = new Veld[100];
//	
//	private boolean isVerplaatsingOk(String richting) {
//		
//
//		boolean verplaatsingOk = false;		
//	
//		if (richting == "links") {
//			
//			if (!(locatieMan%10 == 0 || spelbord[locatieMan-1].getKarakter() == "w" || (spelbord[locatieMan-1].getKarakter() == "k" && spelbord[locatieMan-1].getKarakter() == "k"))) {
//				verplaatsingOk = true;
//			}
//	
//		}
//		else if (richting == "rechts") {
//			
//			if (!(locatieMan%10 == 9 || spelbord[locatieMan+1].getKarakter() == "w" || (spelbord[locatieMan+1].getKarakter() == "k" && spelbord[locatieMan+1].getKarakter() == "k"))) {
//				verplaatsingOk = true;
//			}
//		}
//		else if (richting == "omhoog") {
//			
//			if (!(locatieMan/10 == 0 || spelbord[locatieMan-10].getKarakter() == "w" || (spelbord[locatieMan-10].getKarakter() == "k" && spelbord[locatieMan-10].getKarakter() == "k"))) {
//				verplaatsingOk = true;
//			}
//		}
//		else if (richting == "omlaag") {
//			
//			if (!(locatieMan/10 == 9 || spelbord[locatieMan+10].getKarakter() == "w" || (spelbord[locatieMan+10].getKarakter() == "k" && spelbord[locatieMan+10].getKarakter() == "k"))) {
//				verplaatsingOk = true;
//			}
//		}
//	
//		return verplaatsingOk;
//	}
//
//	public boolean kanKistVerplaatstWorden(String richting) {
//		return true;
//	}
//
//	
//	public void verplaatsMan(String richting) {
//		
//		if (isVerplaatsingOk(richting)) {
//						
//			
//			if (richting == "links") {
//				if (spelbord[locatieMan-1].getKarakter() == "k") {
//					spelbord[locatieMan-2].setKarakter("k");
//				}
//				spelbord[locatieMan].setKarakter("v");
//				spelbord[locatieMan-1].setKarakter("m");
//					
//			}
//			else if (richting == "omhoog") {
//				if (spelbord[locatieMan-10].getKarakter() == "k") {
//					spelbord[locatieMan-20].setKarakter("k");
//				}
//
//				spelbord[locatieMan].setKarakter("v");
//				spelbord[locatieMan-10].setKarakter("m");
//				
//			}
//			else if (richting == "rechts") {
//				if (spelbord[locatieMan+1].getKarakter() == "k") {
//					spelbord[locatieMan+20].setKarakter("k");
//				}
//				spelbord[locatieMan].setKarakter("v");
//				spelbord[locatieMan+1].setKarakter("m");
//			}
//			else if (richting == "omlaag") {
//				if (spelbord[locatieMan+10].getKarakter() == "k" && isVerplaatsingOk(richting)) {
//					spelbord[locatieMan+20].setKarakter("k");
//				}
//
//				spelbord[locatieMan].setKarakter("v");
//				spelbord[locatieMan+10].setKarakter("m");
//			}
//			
//			aantalVerplaatsingen += 1;
//			
//
//		}
//		
//	}
	public Veld[] getKistenVeld() {
		//geef een lijst of array met alle objecten van de klasse kist in
		//steek voor elk object de returnwaarde van de methode getVeld in de array'kisten'
		return kisten;
	}
	
	public Man getMan() {
		return man;
	}
	
	public Veld[][] getVakken() 
	{
		return bord;
	} 
	
	public int getAantalVerplaatsingen() {
		return aantalVerplaatsingen;
	}

}