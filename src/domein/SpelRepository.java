package domein;

import java.util.ArrayList;

import java.util.List;

import persistentie.SpelMapper;

public class SpelRepository
{
	private final SpelMapper spelMapper;
	private static List<Spel> spellen = new ArrayList<>();
    
    
    public SpelRepository()
    {
        spelMapper = new SpelMapper();
    }
    
    
    public static Spel geefSpel(String naam)
    { 
        return null;
    }

    
    public static List<Spel> geefSpellenList()      //lijst van spellen uit databank halen
    {
        return spellen;
    }
    	
}