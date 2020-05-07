package domein;

import java.util.ArrayList;

import java.util.List;

import gui.Taal;
import persistentie.SpelMapper;

public class SpelRepository
{
	private SpelMapper spelMapper;
	private List<String> spellen = new ArrayList<>();    
    
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
    
    
    public void voegSpelToe(String naamSpel, String gebruikersnaam)     //Methode om een speler toe te voegen in de databank, @param speler spelerobject dat aangemaakt moet worden in de databank
    {
		if (bestaatSpel(naamSpel))
		{
		    throw new IllegalArgumentException(Taal.getText("spelBestaat"));
		}
		spelMapper.voegSpelToe(naamSpel, gebruikersnaam);
    }

    
    public List<String> geefSpellenList()      //lijst van spellen uit databank halen
    {
    	spellen = SpelMapper.geefSpellen();
    	
        return spellen;
    }
    
    public void verwijderSpel(String naamSpel)
    {
    	spelMapper.verwijderSpel(naamSpel);
    }
    	
}