package domein;

import domein.Spelbord;
import domein.SpelbordRepository;
import java.util.List;

import Exceptions.OngeldigGebruikersnaamException;
import Exceptions.OngeldigeSpelnaamException;

public class Spel 
{
	private String naamSpel;
	Spelbord huidigSpelbord;
	SpelbordRepository spelbordRepository;
	List<Spelbord> spelborden;
	

	public Spel(String naamSpel) 
	{
		this.setNaamSpel(naamSpel);
		spelbordRepository = new SpelbordRepository();
		spelborden = spelbordRepository.geefSpelbordenLijst(naamSpel);
		huidigSpelbord = selecteerSpelbord();
	}	
	
	
	public Spelbord getSpelbord() 
	{
		return this.huidigSpelbord;
	}
	
	public Spelbord selecteerSpelbord() {
		for (int i = 0; i<spelborden.size(); i++) {
			if (!spelborden.get(i).getIsVoltooid()) {
				return spelborden.get(i);
			}
		}
		return null;
	}
	
	
	public int geefAantalSpelborden() 
	{
		return spelbordRepository.geefSpelbordenLijst(naamSpel).size();
	}
	
	
	public int geefAantalSpelbordenVoltooid() 
	{
		int aantalVoltooid = 0;
		for (int i = 0; i< spelbordRepository.geefSpelbordenLijst(naamSpel).size(); i++) 
		{
			if (spelbordRepository.geefSpelbord(naamSpel).getIsVoltooid()) 
			{
				aantalVoltooid += 1;
			}
		}
		return aantalVoltooid;
	}
	
	
	public boolean isSpelVoltooid() 
	{
		int aantalVoltooid = 0;
		boolean voltooid = false;
		for (int i = 0; i< spelbordRepository.geefSpelbordenLijst(naamSpel).size(); i++) 
		{
			if (spelbordRepository.geefSpelbord(naamSpel).getIsVoltooid()) 
			{
				aantalVoltooid += 1;
			}
		}
		if (spelbordRepository.geefSpelbordenLijst(naamSpel).size() == aantalVoltooid) 
		{
			voltooid = true;
		}
		return voltooid;
	}

	
	public boolean isSpelbordVoltooid() 
	{
		return huidigSpelbord.getIsVoltooid();
	}
	
	
	public int geefAantalVerplaatsingen()
	{
		return huidigSpelbord.getAantalVerplaatsingen();
	}
	
	
	public String getNaamSpel()
	{
		return this.naamSpel;
	}
	
	
	public void setNaamSpel(String naam) 
	{
		if (naam == null || naam.length() == 0)
		{ 
		    throw new OngeldigeSpelnaamException("Spelnaam is verplicht in te vullen.");   //exception gooien als spelnaam niet is ingevuld
		} else if (bevatSpatie(naam) == true)
		{
		    throw new OngeldigeSpelnaamException("Spelnaam mag geen spaties bevatten.");    //exception gooien als spelnaam spaties bevat
		}
		else 
		{
		this.naamSpel = naam;
		}
	}
	
	
	private boolean bevatSpatie(String spelnaam)
	{
		boolean heeftSpatie = false; 
		char c;
		
		for(int i = 0; i < spelnaam.length(); i++)
		{
			c = spelnaam.charAt(i); 
			
			if(Character.isSpaceChar(c))
			{
				heeftSpatie = true;
			}
			
		}
		return heeftSpatie;
	}
	

	public void verplaatsMan(String richting) 
	{
		huidigSpelbord.verplaatsMan(richting);
	}
	
	
	public Veld[][] geefSpelbord() 
	{
		return huidigSpelbord.getSpelbord();
	}
	

	public void resetSpelbord(String spelnaam) 
	{
		huidigSpelbord = SpelbordRepository.geefSpelbord(spelnaam);
	}
	
	
	
	
	public void toonSpelbord()
	{
		huidigSpelbord.toonSpelbord();
	}
	
	
	public List<Kist> geefKisten() 
	{
		return huidigSpelbord.getKisten();
	}
	
	
	public int geefVolgnummer() 
	{
		return huidigSpelbord.getVolgnummer();
	}
	
	
	public Man geefMan() 
	{
		return huidigSpelbord.getMan();
	}
	
	
	public void maakNieuwSpelbord(int volgnummer) 
	{
		Veld[][] velden = new Veld[10][10];
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j<10; j++) {
				velden[i][j] = new Veld(i,j, false, false, false, false);
			}
		}
		this.huidigSpelbord = new Spelbord(volgnummer, velden);
	}
	
	
	public void wijzigSpelbord(int x, int y, int actie) 
	{
		this.huidigSpelbord.wijzigSpelbord(x, y, actie);
	}
}