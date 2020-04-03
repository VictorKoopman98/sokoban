package domein;

import java.util.ArrayList;

import java.util.List;

import gui.Taal;
import persistentie.SpelMapper;

public class SpelRepository
{
	private static SpelMapper spelMapper;
	private static List<Spel> spellen = new ArrayList<>();
	private Taal taalObj;
    
    
    public SpelRepository()
    {
        spelMapper = new SpelMapper();
    }
    
    
    public Spel geefSpel(String naam)
    { 
        Spel spel = spelMapper.geefSpel(naam);
        if(spel != null) 
        {
            return spel;
        }
        return null;
    }
    
 
    private boolean bestaatSpel(String spelnaam) 
    {
    	return spelMapper.geefSpel(spelnaam) != null;
    }
    
    
    public void voegSpelToe(Spel spel)     //Methode om een speler toe te voegen in de databank, @param speler spelerobject dat aangemaakt moet worden in de databank
    {
		if (bestaatSpel(spel.getNaamSpel()))
		{
		    throw new IllegalArgumentException(taalObj.getText("spelBestaat"));
		}
		spelMapper.voegSpelToe(spel);
    }

    
    public static List<Spel> geefSpellenList()      //lijst van spellen uit databank halen
    {
    	spellen = SpelMapper.geefSpellen();
    	
        return spellen;
    }
    	
}