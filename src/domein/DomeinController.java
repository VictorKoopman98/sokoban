package domein;

import java.util.Arrays;
import java.util.List;

import domein.Kist;
import domein.Man;

public class DomeinController
{
	private final SpelerRepository spelerRepository;
	private final SpelRepository spelRepository;
	private Speler speler;
	List<Spel> list = SpelRepository.geefSpellenList();     // hier geplaatst want zetNaamOmInSpel en geefLijstSpellen gebruiken het
	
	
	public DomeinController()   //Constructor om een DomeinController aan te maken
	{
		this.spelRepository = new SpelRepository();
		spelerRepository = new SpelerRepository();
	}
	
	
	public String geefGebruikersnaam()    //Methode om de gebruikersnaam van een speler terug te gegven
	{
		return this.speler.getGebruikersnaam();
	}
	
	
	public void setSpeler(Speler speler)   //Methode om de speler in te stellen die het spel zal spelen
	{
		this.speler = speler;
	}
	
	
	public void meldAan(String gebruikersnaam, String wachtwoord)     //methode om een speler aan te melden
	{
        Speler gevondenSpeler = spelerRepository.geefSpeler(gebruikersnaam, wachtwoord);
        System.out.print(gevondenSpeler);

        if (gevondenSpeler != null) 
        {
            setSpeler(gevondenSpeler);

        } else 
        {
            throw new IllegalArgumentException("Verkeerde login!");
        }
	}
	
	
    public boolean isAdmin()     //Methode om te kijken of de speler een admin is
    {
        return this.speler.isAdminrechten();
    }

    
    public void registreer(String gebruikersnaam, String wachtwoord, boolean adminrechten, String naam, String voornaam)   //registreren van speler + aanmelden
    {
        Speler nieuweSpeler = new Speler(gebruikersnaam, wachtwoord, adminrechten, naam, voornaam);
        setSpeler(nieuweSpeler);
        spelerRepository.voegToe(nieuweSpeler);
    }
    
    
    public String[] geefLijstSpellen()    //array maken van namen van spellen
    {
    	
          String[] namen = new String[list.size()];      // array van namen van de spellen word aangemaakt in de groote van het aantal spellen
          
          for(int i = 0; i < list.size(); i++) 
          {
        	  namen [i] = list.get(i).getNaam();     //elke naam wordt opgevraagd
          }
          
          return namen;
    }
    
    
    public void selecteerSpel(String naam)
    {
        SpelRepository.geefSpel(naam);      // naam van het spel wordt geselecteerd
    }
     
    
    public int geefAantalSpelborden(String naam)
    {
    	Spel spel = zetNaamOmInSpel(naam);
        return spel.getAantalSpelborden();      //geeft terug hoeveel spelborden het spel heeft
    }
    
    
    public int geefAantalSpelbordenVoltooid(String naam)
    {
    	Spel spel = zetNaamOmInSpel(naam);
        return spel.getAantalSpelbordenVoltooid();       //geeft terug hoeveel voltooide spelborden het spel heeft
    }
    
    
    public Spel zetNaamOmInSpel(String naam) 
    {
    	List<String> lijstje = Arrays.asList(geefLijstSpellen());        //zet array van geefLijstSpellen om naar list
    	int index = lijstje.indexOf(naam);             //zoekt index van de opgeven naam
    	return list.get(index);           // naam omzetten naar een spel 
    }
    
    
    
    //---------------------------------------------------------------------
    
    public char[][] toonSpelbord() 
    {
        char[][] output = new char[10][10];
        Veld[][] velden = this.Spel.getSpelbord().getVelden();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (velden[i][j].isMuur(i, j)) 
                {
                    output[i][j] = "X";
                } else if (velden[i][j].isDoel() && velden[i][j] == Kist.getVeld()) 
                {
                    output[i][j] = "V";
                } else if (velden[i][j].isDoel() && !velden[i][j] == Man.getVeld())) 
                {
                    output[i][j] = ".";
                } else if (!velden[i][j].isDoel() && !velden[i][j].bevatKist() && !velden[i][j].bevatMan()) 
                {
                    output[i][j] = " ";
                } else if (velden[i][j].bevatMan() && !velden[i][j].isDoel()) 
                {
                    output[i][j] = "@";
                } else if (velden[i][j].bevatKist()) 
                {
                    output[i][j] = "*";
                } else if (velden[i][j].isDoel() && velden[i][j].bevatMan()) 
                {
                    output[i][j] = "#";
                }
            }
        }
        return output;

    }
    
   //--------------------------------------------------------------------------------------------  
}



