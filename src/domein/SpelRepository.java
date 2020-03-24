package domein;

import java.util.ArrayList;

import java.util.List;

import persistentie.SpelMapper;

public class SpelRepository
{
	private static SpelMapper spelMapper;
	private static List<Spel> spellen = new ArrayList<>();
    
    
    public SpelRepository()
    {
        spelMapper = new SpelMapper();
    }
    
    
    public static Spel geefSpel(String naam)
    { 
        Spel spel = spelMapper.geefSpel(naam);
        if(spel != null) {
            return spel;
        }
        return null;
    }
    

    
    private boolean bestaatSpel(String spelnaam) {
    	return spelMapper.geefSpel(spelnaam) != null;
    }
    
    public void voegSpelToe(Spel spel)     //Methode om een speler toe te voegen in de databank, @param speler spelerobject dat aangemaakt moet worden in de databank
    {
	if (bestaatSpel(spel.getNaamSpel()))
	{
	    throw new IllegalArgumentException("Spel bestaat al!");
	}
	spelMapper.voegSpelToe(spel);
    }

    
    public static List<Spel> geefSpellenList()      //lijst van spellen uit databank halen
    {
    	spellen = spelMapper.geefSpellen();
    	
        return spellen;
    }
    	
}