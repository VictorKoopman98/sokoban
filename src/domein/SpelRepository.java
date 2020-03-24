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

    
    public static List<Spel> geefSpellenList()      //lijst van spellen uit databank halen
    {
    	spellen = spelMapper.geefSpellen();
    	
        return spellen;
    }
    	
}