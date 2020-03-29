package domein;

import java.util.Arrays;
import java.util.List;


public class DomeinController
{
	private final SpelerRepository spelerRepository;
	private final SpelRepository spelRepository;
	private Speler speler;
	private Spel spel;
	private final SpelbordRepository spelbordRepository; 
	
	
	public DomeinController()   //Constructor om een DomeinController aan te maken
	{
		this.spelRepository = new SpelRepository();
		spelerRepository = new SpelerRepository(); 
		spelbordRepository = new SpelbordRepository();		
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
    
    
    public static String[] geefLijstSpellen()    //array maken van namen van spellen
    {
    	
          String[] namen = new String[SpelRepository.geefSpellenList().size()];      // array van namen van de spellen word aangemaakt in de groote van het aantal spellen
          
          for(int i = 0; i < SpelRepository.geefSpellenList().size(); i++) 
          {
        	  namen [i] = SpelRepository.geefSpellenList().get(i).getNaamSpel();     //elke naam wordt opgevraagd
          }
          
          return namen;
    }
    
    
    public void selecteerSpel(String naam)
    {
        this.spel = spelRepository.geefSpel(naam);      // naam van het spel wordt geselecteerd
    }
     
    
    public int geefAantalSpelborden()
    {
    	return this.spel.geefAantalSpelborden();      //geeft terug hoeveel spelborden het spel heeft
    }
    
    
    public int geefAantalSpelbordenVoltooid()
    {
    	return this.spel.geefAantalSpelbordenVoltooid();       //geeft terug hoeveel voltooide spelborden het spel heeft
    }
    
    
    public Spel zetNaamOmInSpel(String naam) 
    {
    	List<String> lijstje = Arrays.asList(geefLijstSpellen());        //zet array van geefLijstSpellen om naar list
    	int index = lijstje.indexOf(naam);             //zoekt index van de opgeven naam
    	return spelRepository.geefSpellenList().get(index);           // naam omzetten naar een spel 
    }
      
    
    public void toonSpelbord() 
    {
    	this.spel.toonSpelbord();
    }
    
    public void selecteerSpelbord() {
    	this.spel.selecteerSpelbord();
    }
    
   
    public void verplaatsMan(String richting) 
    {
    	this.spel.verplaatsMan(richting);
    }
    

    public void resetSpelbord(String spelnaam) 
    {
    	this.spel.resetSpelbord(spelnaam);
    }
    

    public int geefAantalVerplaatsingen()   //methode om het aantal verplaatsingen terug te geven
    {
    	return this.spel.geefAantalVerplaatsingen();
    }
    
    
    public boolean eindeSpelbordBereikt()  //methode om te kijken of het einde van het spelbord bereikt is
    {
    	if(spel.isSpelbordVoltooid() == true)
    	{
    		return true;
    	}
    	return false;
    }
    
    
    public void maakNieuwSpel(String naamSpel) 
    {
    	Spel nieuwSpel = new Spel(naamSpel);
    	spelRepository.voegSpelToe(nieuwSpel);
    }    
    
    
    public String geefNaamSpel() 
    {
    	return this.spel.getNaamSpel();
    }
    
    
    public void setSpel(Spel spel) 
    { 
    	this.spel = spel;
    }
    
    
    public boolean isSpelVoltooid() 
    {
    	return this.spel.isSpelVoltooid();
    }
    
    
    public void maakNieuwSpelbord(int volgnummer) 
    {
    	this.spel.maakNieuwSpelbord(volgnummer);	
    }
    
 /*   public String[] geefLijstSpelborden()    //array maken van namen van spellen
 //   {
 //   	
 //         String[] overzichtSpelborden = new String[spelbordRepository.geefSpelbordenLijst().size()];      // array van namen van de spellen word aangemaakt in de groote van het aantal spellen
 //         
 //         for(int i = 0; i < spelbordRepository.geefSpelbordenLijst().size(); i++) 
 //         {
 //       	  overzichtSpelborden [i] = spelbordRepository.geefSpelbordenLijst()    //elke naam wordt opgevraagd
          }
          
          return overzichtSpelborden;
    }
    
 */   
    
    public void wijzigSpelbord(int x, int y, int actie) 
    {
    	this.spel.wijzigSpelbord(x, y, actie);
    }
    
    
    public void voegSpelbordToe(Spelbord spelbord, String spelnaam) 
    {
    	this.spelbordRepository.voegSpelbordToe(spelbord, spelnaam);
    }
    
    
    public int geefVolgnummer() 
    {
    	return this.spel.geefVolgnummer();
    }
    
    
    public Spelbord geefSpelbord() 
    {
    	return this.spel.getSpelbord();
    }
    
    
    public void verwijderSpelbord(int volgnummer, String naamSpel) 
    {
		this.spelbordRepository.verwijderSpelbord(volgnummer, naamSpel);
	}
    
    
    public int[] geefVolgnummerSpelborden(String spelnaam)    //array maken van namen van spellen
    {
    	
          int [] namen = new int[spelbordRepository.geefSpelbordenLijst(spelnaam).size()];      // array van namen van de spellen word aangemaakt in de groote van het aantal spellen
          
          for(int i = 0; i < spelbordRepository.geefSpelbordenLijst(spelnaam).size(); i++) 
          {
        	  namen [i] = spelbordRepository.geefSpelbordenLijst(spelnaam).get(i).getVolgnummer();     //elke naam wordt opgevraagd
          }
          
          return namen;
    }
    

}