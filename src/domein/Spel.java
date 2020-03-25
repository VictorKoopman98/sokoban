package domein;

import domein.Spelbord;
import domein.SpelbordRepository;
import java.util.List;

import Exceptions.OngeldigGebruikersnaamException;
import Exceptions.OngeldigeSpelnaamException;

public class Spel {
	
	private String naamSpel;
	Spelbord spelbord;
	SpelbordRepository spelbordRepository;
	

	
	public Spel(String naamSpel) 
	{
		// TODO Auto-generated constructor stub
		this.setNaamSpel(naamSpel);
		
	}	
	
	
	public int geefAantalSpelborden() {
		return spelbordRepository.geefSpelbordenLijst().size();
	}
	
	
	public int geefAantalSpelbordenVoltooid() {
		int aantalVoltooid = 0;
		for (int i = 0; i< spelbordRepository.geefSpelbordenLijst().size(); i++) {
			if (spelbordRepository.geefSpelbord(naamSpel).getIsVoltooid()) {
				aantalVoltooid += 1;
			}
		}
		return aantalVoltooid;
	}
	
	public boolean isSpelVoltooid() {
		int aantalVoltooid = 0;
		boolean voltooid = false;
		for (int i = 0; i< spelbordRepository.geefSpelbordenLijst().size(); i++) {
			if (spelbordRepository.geefSpelbord(naamSpel).getIsVoltooid()) {
				aantalVoltooid += 1;
			}
		}
		if (spelbordRepository.geefSpelbordenLijst().size() == aantalVoltooid) {
			voltooid = true;
		}
		return voltooid;
	}

	
	public boolean isSpelbordVoltooid() 
	{
		return spelbord.getIsVoltooid();
	}
	
	
	public int geefAantalVerplaatsingen()
	{
		return spelbord.getAantalVerplaatsingen();
	}
	
	
	public String getNaamSpel()
	{
		return this.naamSpel;
	}
	
	private void setNaamSpel(String naam) {
		if (naam == null || naam.length() == 0)
		{ 
		    throw new OngeldigeSpelnaamException("Spelnaam is verplicht in te vullen.");   //exception gooien als spelnaam niet is ingevuld
		} else if (naam.contains(" "))
		{
		    throw new OngeldigeSpelnaamException("Spelnaam mag geen spaties bevatten.");    //exception gooien als spelnaam spaties bevat
		}
		else 
		{
		this.naamSpel = naam;
		}
	}
	

	public void verplaatsMan(String richting) 
	{
		spelbord.verplaatsMan(richting);
	}
	
	
	public Veld[][] geefSpelbord() 
	{
		return spelbord.getSpelbord();
	}
	

	public void resetSpelbord(String spelnaam) 
	{
		this.spelbord = SpelbordRepository.geefSpelbord(spelnaam);
	}
	
	
	public char[][] toonSpelbord()
	{
		return spelbord.toonSpelbord();
	}
	
	
	public Kist[] geefKisten() {
		return spelbord.getKisten();
	}
	
	public int geefVolgnummer() {
		return spelbord.getVolgnummer();
	}
	
	
	public Man geefMan() 
	{
		return spelbord.getMan();
	}
	
	public void maakNieuwSpelbord(int volgnummer) {
		this.spelbord = new Spelbord(volgnummer);
	}
	
	public void wijzigSpelbord(int x, int y, int actie) {
		this.spelbord.wijzigSpelbord(x, y, actie);
	}
}