package domein;

import domein.Vak;
import java.util.ArrayList;

public class Spelbord {
	
	private boolean isVoltooid;
	private int aantalVerplaatsingen;
	private int locatieMan=-1;
	ArrayList<Vak> vakken = new ArrayList<Vak>();
	

	public Spelbord() {
		// TODO Auto-generated constructor stub	
		
	}
	
	private int geefLocatieMan() {
		for (int i = 0; i < 100; i++) {
			if (vakken[i])
		}
	}
	

	
	private boolean isVerplaatsingOk(String richting) {
		

		boolean verplaatsingOk = false;	
	
		if (richting == "links") {
			
			if (!(locatieMan%10 == 0 || spelbord[locatieMan-1].getKarakter() == "w" || (spelbord[locatieMan-1].getKarakter() == "k" && spelbord[locatieMan-2].getKarakter() == "k") || (spelbord[locatieMan-1].getKarakter() == "k" && spelbord[locatieMan-2].getKarakter() == "w"))) {
				verplaatsingOk = true;
			}
	
		}
		else if (richting == "rechts") {
			
			if (!(locatieMan%10 == 9 || spelbord[locatieMan+1].getKarakter() == "w" || (spelbord[locatieMan+1].getKarakter() == "k" && spelbord[locatieMan+2].getKarakter() == "k") || (spelbord[locatieMan+1].getKarakter() == "k" && spelbord[locatieMan+2].getKarakter() == "w"))) {
				verplaatsingOk = true;
			}
		}
		else if (richting == "omhoog") {
			
			if (!(locatieMan/10 == 0 || spelbord[locatieMan-10].getKarakter() == "w" || (spelbord[locatieMan-10].getKarakter() == "k" && spelbord[locatieMan-20].getKarakter() == "k") || (spelbord[locatieMan-10].getKarakter() == "k" && spelbord[locatieMan-20].getKarakter() == "w"))) {
				verplaatsingOk = true;
			}
		}
		else if (richting == "omlaag") {
			
			if (!(locatieMan/10 == 9 || spelbord[locatieMan+10].getKarakter() == "w" || (spelbord[locatieMan+10].getKarakter() == "k" && spelbord[locatieMan+20].getKarakter() == "k") || (spelbord[locatieMan+10].getKarakter() == "k" && spelbord[locatieMan+20].getKarakter() == "w"))) {
				verplaatsingOk = true;
			}
		}
	
		return verplaatsingOk;
	}

	
	
	public void verplaatsMan(String richting) {
		
		if (isVerplaatsingOk(richting)) {
						
			
			if (richting == "links") {
				if (spelbord[locatieMan-1].getKarakter() == "k") {
					spelbord[locatieMan-2].setKarakter("k");
				}
				spelbord[locatieMan].setKarakter("v");
				spelbord[locatieMan-1].setKarakter("m");
					
			}
			else if (richting == "omhoog") {
				if (spelbord[locatieMan-10].getKarakter() == "k") {
					spelbord[locatieMan-20].setKarakter("k");
				}

				spelbord[locatieMan].setKarakter("v");
				spelbord[locatieMan-10].setKarakter("m");
				
			}
			else if (richting == "rechts") {
				if (spelbord[locatieMan+1].getKarakter() == "k") {
					spelbord[locatieMan+2].setKarakter("k");
				}
				spelbord[locatieMan].setKarakter("v");
				spelbord[locatieMan+1].setKarakter("m");
			}
			else if (richting == "omlaag") {
				if (spelbord[locatieMan+10].getKarakter() == "k") {
					spelbord[locatieMan+20].setKarakter("k");
				}

				spelbord[locatieMan].setKarakter("v");
				spelbord[locatieMan+10].setKarakter("m");
			}
			
			aantalVerplaatsingen += 1;
			

		}
		// else throw new exception
	}	
	
	public Vak[] getSpelbord() {
		return spelbord;
	} 
	
	public int getAantalVerplaatsingen() {
		return aantalVerplaatsingen;
	}

}








