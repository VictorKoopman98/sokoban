package domein;


import java.util.ArrayList;
import java.util.List;

import domein.Spelbord;
import persistentie.SpelMapper;
import persistentie.SpelbordMapper;

public class SpelbordRepository 
{
	private static List<Spelbord> spelborden = new ArrayList<>();
	private static SpelbordMapper spelbordMapper;
	private Spelbord spelbord;
	
	
	public SpelbordRepository() 
	{
		spelbordMapper = new SpelbordMapper();
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