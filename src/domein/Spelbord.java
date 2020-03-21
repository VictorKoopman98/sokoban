package domein;

import domein.Vak;
import java.util.ArrayList;

public class Spelbord {
	
	private boolean isVoltooid;
	private int aantalVerplaatsingen;
<<<<<<< HEAD
	private int locatieMan=50;
	ArrayList<Vak> vakken = new ArrayList<Vak>();
	
=======
	private int locatieMan=-1;
	
	
	

>>>>>>> branch 'master' of https://github.com/HoGentTIProjecten1/sokoban-g39.git

	public Spelbord() {
		// TODO Auto-generated constructor stub	
		
	}
	
<<<<<<< HEAD
	private int geefLocatieMan() {
		for (int i = 0; i < vakken.size(); i++) {
			//controleer voor ieder vak of er een associatie is tussen man en vak
			//if (associatie tussen man en vak)
			//locatieMan = vakken[i].getlocatie
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

	
=======
	//Array maken van alle objecten van de klasse Vak
	Vak spelbord[] = new Vak[100];
>>>>>>> branch 'master' of https://github.com/HoGentTIProjecten1/sokoban-g39.git
	
	private boolean isVerplaatsingOk(String richting) {
		

		boolean verplaatsingOk = false;		
	
		if (richting == "links") {
			
			if (!(locatieMan%10 == 0 || spelbord[locatieMan-1].getKarakter() == "w" || (spelbord[locatieMan-1].getKarakter() == "k" && spelbord[locatieMan-1].getKarakter() == "k"))) {
				verplaatsingOk = true;
			}
	
		}
		else if (richting == "rechts") {
			
			if (!(locatieMan%10 == 9 || spelbord[locatieMan+1].getKarakter() == "w" || (spelbord[locatieMan+1].getKarakter() == "k" && spelbord[locatieMan+1].getKarakter() == "k"))) {
				verplaatsingOk = true;
			}
		}
		else if (richting == "omhoog") {
			
			if (!(locatieMan/10 == 0 || spelbord[locatieMan-10].getKarakter() == "w" || (spelbord[locatieMan-10].getKarakter() == "k" && spelbord[locatieMan-10].getKarakter() == "k"))) {
				verplaatsingOk = true;
			}
		}
		else if (richting == "omlaag") {
			
			if (!(locatieMan/10 == 9 || spelbord[locatieMan+10].getKarakter() == "w" || (spelbord[locatieMan+10].getKarakter() == "k" && spelbord[locatieMan+10].getKarakter() == "k"))) {
				verplaatsingOk = true;
			}
		}
	
		return verplaatsingOk;
	}

	public boolean kanKistVerplaatstWorden(String richting) {
		return true;
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
<<<<<<< HEAD
					spelbord[locatieMan+2].setKarakter("k");
				}
				spelbord[locatieMan].setKarakter("v");
				spelbord[locatieMan+1].setKarakter("m");
			}
			else if (richting == "omlaag") {
				if (spelbord[locatieMan+10].getKarakter() == "k") {
=======
					spelbord[locatieMan+20].setKarakter("k");
				}
				spelbord[locatieMan].setKarakter("v");
				spelbord[locatieMan+1].setKarakter("m");
			}
			else if (richting == "omlaag") {
				if (spelbord[locatieMan+10].getKarakter() == "k" && isVerplaatsingOk(richting)) {
>>>>>>> branch 'master' of https://github.com/HoGentTIProjecten1/sokoban-g39.git
					spelbord[locatieMan+20].setKarakter("k");
				}

				spelbord[locatieMan].setKarakter("v");
				spelbord[locatieMan+10].setKarakter("m");
			}
			
			aantalVerplaatsingen += 1;
			

		}
<<<<<<< HEAD
		// else throw new exception
=======
		
>>>>>>> branch 'master' of https://github.com/HoGentTIProjecten1/sokoban-g39.git
	}	
	
	public Vak[] getSpelbord() {
		return spelbord;
	} 
	
	public int getAantalVerplaatsingen() {
		return aantalVerplaatsingen;
	}

}