package domein;

import domein.Vak;

public class Spelbord {
	
	private boolean isVoltooid;
	private int aantalVerplaatsingen;


	public Spelbord() {
		// TODO Auto-generated constructor stub	
		
	}
	
	
	//array maken van alle objecten van de klasse Vak
	Vak spelbord[] = new Vak[100];
	
	public void verplaatsMan(String richting) {
		
		int locatieMan = -1;
		
		//alle vakken van het spelbord worden overlopen om de locatie van de man te bepalen
		for (int i=0;i<100;i++) {
			if (spelbord[i].getKarakter() == "m") {
				locatieMan = spelbord[i].getLocatie();
				
			}
		}
		spelbord[locatieMan].setKarakter("v");
		//het vakje waar het mannetje stond wordt terug naar een veld omgezet en het veld waarnaar verplaatst wordt, wordt omgezet naar man
		if (richting == "links") {

			spelbord[locatieMan-1].setKarakter("m");
		}
		else if (richting == "omhoog") {
			spelbord[locatieMan-10].setKarakter("m");
		}
		else if (richting == "rechts") {
			spelbord[locatieMan+1].setKarakter("m");
		}
		else if (richting == "omlaag") {
			spelbord[locatieMan+10].setKarakter("m");
		}
		
		aantalVerplaatsingen += 1;
		
	}
	
	
	
	
	
	public Vak[] getSpelbord() {
		return spelbord;
	} 
	
	public int getAantalVerplaatsingen() {
		return aantalVerplaatsingen;
	}

}








