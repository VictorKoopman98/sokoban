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
	
	
	public void voegSpelbordToe(Spelbord spelbord, String spelnaam) 
	{
		spelbordMapper.voegSpelbordToe(spelbord, spelnaam);
	}
	
	
	public  List<Spelbord> geefSpelbordenLijst(String spelnaam)
	{
		return spelbordMapper.geefSpelborden(spelnaam); 
	}
	
	public Spelbord geefSpelbordMetVolgnummer(int volgnummer, String spelnaam)
	{
		return spelbordMapper.geefSpelbordMetVolgnummer(volgnummer, spelnaam);
	}
	
	
	public void updateSpelbord(Spelbord spelbord, String spelnaam)
	{
		spelbordMapper.updateSpelbord(spelbord, spelnaam);
	}
	
//	public void verwijderSpelbord(int volgnummer, String naamSpel) 
//	{
//		this.spelborden.remove(this.spelbord);
//		spelbordMapper.verwijderSpelbord(volgnummer, naamSpel);
//	}
//	
//	
	
}