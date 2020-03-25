package domein;

import java.util.ArrayList;
import java.util.List;

import domein.Spelbord;
import persistentie.SpelbordMapper;

public class SpelbordRepository {
	
	private static List<Spelbord> spelborden = new ArrayList<>();
	private static SpelbordMapper spelbordMapper;
	

	public SpelbordRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public static Spelbord geefSpelbord(String spelnaam) {
		Spelbord spelbord = spelbordMapper.geefSpelbord(spelnaam);
		if (spelbord != null) {
			return spelbord;
		}
		return null;
	}
	
	public void voegSpelbordToe(Spelbord spelbord, String spelnaam) {
		spelbordMapper.voegSpelbordToe(spelbord, spelnaam);
	}
	
	public List<Spelbord> geefSpelbordenLijst(){
		
		return spelborden;
	}

}