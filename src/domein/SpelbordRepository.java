package domein;


import java.util.List;

import domein.Spelbord;
import gui.Taal;
import persistentie.SpelbordMapper;

public class SpelbordRepository 
{
	private static SpelbordMapper spelbordMapper;
	private Spelbord spelbord;
	private Taal taalObj;
	
	
	public SpelbordRepository(Taal taalObj) 
	{
		this.taalObj = taalObj;
		spelbordMapper = new SpelbordMapper(taalObj);
	}
	
	
	public static Spelbord geefSpelbord(String spelnaam) 
	{
		Spelbord spelbord = spelbordMapper.geefSpelbord(spelnaam);
		if (spelbord != null) 
		{ 
			return spelbord;
		}
		return null;
	}
	
	public int geefVolgnummer() {
		return spelbord.getVolgnummer();
	}
	
	
	public void voegSpelbordToe(char[][] velden, int volgnummer, String spelnaam) 
	{
		spelbordMapper.voegSpelbordToe(volgnummer, velden, spelnaam);
	}
	
	
	public  List<Spelbord> geefSpelbordenLijst(String spelnaam)
	{
		return spelbordMapper.geefSpelborden(spelnaam); 
	}
	
	public Spelbord geefSpelbordMetVolgnummer(int volgnummer, String spelnaam)
	{
		return spelbordMapper.geefSpelbordMetVolgnummer(volgnummer, spelnaam);
	}
	
	
	public void updateSpelbord(int volgnummer, char[][] velden, String spelnaam)
	{
		spelbordMapper.updateSpelbord(volgnummer, velden, spelnaam);
	}
	
//	public void verwijderSpelbord(int volgnummer, String naamSpel) 
//	{
//		this.spelborden.remove(this.spelbord);
//		spelbordMapper.verwijderSpelbord(volgnummer, naamSpel);
//	}
//	
//	
	
}