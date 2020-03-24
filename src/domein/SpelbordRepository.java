package domein;

import java.util.ArrayList;
import java.util.List;

import domein.Spelbord;

public class SpelbordRepository {
	
	private static List<Spelbord> spelborden = new ArrayList<>();
	

	public SpelbordRepository() {
		// TODO Auto-generated constructor stub
	}
	
	public static Spelbord getSpelbord() {
		Spelbord spelbord = new Spelbord();
		return spelbord;
	}
	
	public List<Spelbord> geefSpelbordenLijst(){
		
		return spelborden;
	}

}
