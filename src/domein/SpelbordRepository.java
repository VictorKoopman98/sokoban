package domein;

import java.util.ArrayList;
import java.util.List;

import domein.Spelbord;
import persistentie.SpelbordMapper;

public class SpelbordRepository {
	
	private static List<Spelbord> spelborden = new ArrayList<>();
	private static SpelbordMapper spelbordmapper;
	

	public SpelbordRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public static Spelbord geefSpelbord() {
		Spelbord spelbord = spelbordMapper.geefSpelbord();
		if (spelbord != null) {
			return spelbord;
		}
		return null;
	}
	
	public List<Spelbord> geefSpelbordenLijst(){
		
		return spelborden;
	}

}