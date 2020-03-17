package domein;

import java.util.ArrayList;
import java.util.List;

import domein.Vak;

public class Spelbord {
	
	private boolean isVoltooid;
	private int spelbordId;
	private int volgnummer; // 
	private int aantalVerplaatsingen = 0;
	private Vak[] vakken;
	private Veld[][] velden;
	private Man man;
 	private List<Kist> kisten = new ArrayList<>();


	public Spelbord(int spelbordId, int volgnummer, Veld[][] velden) 
	{
		this.spelbordId = spelbordId;
		this.volgnummer = volgnummer;
		this.velden = velden;
		
		
		
	}
	
	/**
     * Methode om de velden van het spelbord terug te geven
     *
     * @return geeft de velden van een spelbord terug
     */
    public Veld[][] getVelden()
    {
	return this.velden;
    }

	//array maken van alle objecten van de klasse Vak
	Vak spelbord[] = new Vak[100];
	
	/**
     * Methode om na te gaan of een veld een muur is of niet
     *  x(rij) x-coordinaat van het veld
     * y(kolom) y-coordinaat van het veld
     * @return geef terug of het veld wel/geen muur is
     */
	public boolean isMuur(int x, int y)
	{
		return velden[x][y] ==null;
	}

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
		return this.vakken;
	} 
	
	
	/**
	 * Methode om de unieke identiteit van het spelbord terug te geven
	 * @return geeft het spelbordId van het spelbord terug
	 */
	public int getSpelbordId()
	{
		return spelbordId;
	}
	
	
	/**
	 * Methode om het aantal verplaatsingen terug te geven
	 * @return geeft het aantal verplaatsingen terug
	 */
	public int getAantalVerplaatsingen()
	{
		return aantalVerplaatsingen;
	}
	
	/**
     * Methode om het volgnummer van het spelbord terug te geven
     *
     * @return geeft het volgnummer van het spelbord terug
     */
    public int getVolgnummer()
    {
	return volgnummer;
    }
	
	/*
	 * Methode om te controleren of het spelbord voltooid is
	 * return : geeft aan of het spelbord wel/niet voltooid is
	 */
	
	public boolean controleerVoltooid()
	{
		for(Kist k: this.kisten)
		{
			if(k.getVeld() == null || !k.getVeld().isDoel())
			{
				return false;
			}
			
		}
		return true;
	}
	
	public void setVolgnummer(int volgnummer)
	{
		this.volgnummer = volgnummer;
	}
	
	
}







