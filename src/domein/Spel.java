package domein;

import domein.Spelbord;
import domein.SpelbordRepository;
import gui.Taal;

import java.util.List;
import java.util.ArrayList;

public class Spel 
{
	private String naamSpel;
	Spelbord huidigSpelbord;
	SpelbordRepository spelbordRepository;
	List<Spelbord> spelbordenLijst = new ArrayList<Spelbord>();
	private Taal taalObj;
	

	public Spel(String naamSpel,Taal taalObj) 
	{
		this.taalObj = taalObj;
		this.setNaamSpel(naamSpel);
		spelbordRepository = new SpelbordRepository(taalObj);
		spelbordenLijst = geefSpelbordenLijst();
	}	
	
	
	public Spelbord getSpelbord() 
	{
		return this.huidigSpelbord;
	}
	
	public List<Spelbord> geefSpelbordenLijst(){
		return spelbordRepository.geefSpelbordenLijst(naamSpel);
	}
	
	public void selecteerSpelbord(String spelnaam) {
		for (int i = 0; i<spelbordenLijst.size(); i++) { 
			if (!spelbordenLijst.get(i).isVoltooid()) {
				huidigSpelbord = spelbordenLijst.get(i);
				break;
			}
		}
	}
	
	
	public int geefAantalSpelborden() 
	{
		return spelbordRepository.geefSpelbordenLijst(naamSpel).size();
	}
	
	
	public int geefAantalSpelbordenVoltooid() 
	{
		int aantalVoltooid = 0;
		for (int i = 0; i< spelbordenLijst.size(); i++) 
		{
			if (spelbordenLijst.get(i).isVoltooid()) 
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
		for (int i = 0; i< spelbordenLijst.size(); i++) 
		{
			if (spelbordenLijst.get(i).isVoltooid()) 
			{
				aantalVoltooid += 1;
			}
		}
		if (spelbordenLijst.size() == aantalVoltooid) 
		{
			voltooid = true;
		}
		return voltooid;
	}

	
	public boolean isSpelbordVoltooid() 
	{
		return huidigSpelbord.isVoltooid();
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
		    throw new IllegalArgumentException(taalObj.getText("spelNaamVerplicht"));   //exception gooien als spelnaam niet is ingevuld
		} else if (bevatSpatie(naam) == true)
		{
		    throw new IllegalArgumentException(taalObj.getText("spelnaamGeenSpatie"));    //exception gooien als spelnaam spaties bevat
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
	

	public void resetSpelbord(String spelnaam, int volgnummer) 
	{
		huidigSpelbord = spelbordRepository.geefSpelbordMetVolgnummer(volgnummer, spelnaam);
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
			for (int j = 0; j < 10; j++) {
				velden[i][j] = new Veld(i,j, false, false, false, false);
			}
		}
		this.huidigSpelbord = new Spelbord(volgnummer, velden,taalObj);
	}
	
	
	public void wijzigSpelbord(int x, int y, int actie) 
	{
		this.huidigSpelbord.wijzigSpelbord(x, y, actie);
	}
	
	public void setHuidigSpelbord(Spelbord spelbord)
	{
		huidigSpelbord = spelbord;
	}
}