package domein;

import java.util.Arrays;
import java.util.List;

import gui.Taal;


public class DomeinController
{
	private final SpelerRepository spelerRepository;
	private final SpelRepository spelRepository;
	private Speler speler;
	private Spel spel;
	private final SpelbordRepository spelbordRepository;
	
	
	/**
	 * 
	 *  Constructor om een DomeinController aan te maken
	 */
	public DomeinController()   //Constructor om een DomeinController aan te maken
	{
		this.spelRepository = new SpelRepository();
		spelerRepository = new SpelerRepository(); 
		spelbordRepository = new SpelbordRepository();		
	}
	
	/**
	 * Methode om de gebruikersnaam van een speler terug te gegven
	 * 
	 * @return geeft de gebruikersnaam van een speler terug
	 */
	public String geefGebruikersnaam()    //Methode om de gebruikersnaam van een speler terug te gegven
	{
		return this.speler.getGebruikersnaam();
	}
	
	/**
	 * Methode om de speler in stellen die het spel zal spelen
	 * 
	 * @param speler object van de klasse Speler die het spel zal spelen
	 */
	public void setSpeler(Speler speler)   //Methode om de speler in te stellen die het spel zal spelen
	{
		this.speler = speler;
	}
	
	/**
	 * Methode om de speler teerug te geven
	 * 
	 * @return geef speler terug
	 */
	public Speler getSpeler()
	{
		return speler;
	}
	
	/**
     * Methode om te kunnen aanmelden
     *
     * @param gebruikersnaam gebruikersnaam van de persson die zich wil
     * aanmelden
     * @param wachtwoord wachtwoord van de persoon die zich wil aanmelden
     */
	public void meldAan(String gebruikersnaam, String wachtwoord)     //methode om een speler aan te melden
	{
        Speler gevondenSpeler = spelerRepository.geefSpeler(gebruikersnaam, wachtwoord);

        if (gevondenSpeler != null) 
        {
            setSpeler(gevondenSpeler);
        } else 
        {
            throw new IllegalArgumentException(Taal.getText("fouteLoginMelding"));
        }
	}
	
	/**
     * Methode om te kijken of de speler een admin is
     *
     * @return geeft terug of de speler wel/geen admin is
     */
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
    	String[] namen = new String[spelRepository.geefSpellenList().size()];
    	for (int i = 0; i < namen.length; i++)
    	{
    		namen[i] = spelRepository.geefSpellenList().get(i);
    	}
    	return namen;
    }
    
    
    public void selecteerSpel(String naam)
    {
        this.spel = spelRepository.geefSpel(naam);      // naam van het spel wordt geselecteerd
        spel.selecteerSpel();
    }
     
    
    public int geefAantalSpelborden()
    {
    	return this.spel.geefAantalSpelborden();      //geeft terug hoeveel spelborden het spel heeft
    }
    
    
    public int geefAantalSpelbordenVoltooid()
    {
    	return this.spel.geefAantalSpelbordenVoltooid();       //geeft terug hoeveel voltooide spelborden het spel heeft
    }      
    
    public char[][] geefVelden() 
    {
    	return this.spel.geefVelden();
    }
    
    public void selecteerSpelbord(String spelnaam) {
    	this.spel.selecteerSpelbord(spelnaam);
    }
    
   
    public void verplaatsMan(String richting) 
    {
    	this.spel.verplaatsMan(richting);
    }
    

    public void resetSpelbord(String spelnaam, int volgnummer) 
    {
    	int index = spel.geefSpelbordenLijst().indexOf(spel.getSpelbord());
		Spelbord huidigSpelbord = spelbordRepository.geefSpelbordMetVolgnummer(volgnummer, spelnaam);
		spel.geefSpelbordenLijst().set(index, huidigSpelbord);
		spel.setHuidigSpelbord(huidigSpelbord);
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
    	this.spel = nieuwSpel;
    } 
    
    public Spel geefHuidigSpel()
    {
    	return this.spel;
    }
    
   public void voegSpelToe(String spelnaam)
   {
	   if (this.geefAantalSpelborden() == 0)
		   throw new IllegalArgumentException(Taal.getText("minstens1Spelbord"));
	   spelRepository.voegSpelToe(this.spel);
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
    
    public void wijzigSpelbord(int x, int y, int actie) 
    {
    	this.spel.wijzigSpelbord(x, y, actie);
    }
    
    
    public void voegSpelbordToe(char[][] velden, int volgnummer, String spelnaam) 
    {
    	controleerSpelbord(velden, volgnummer, spelnaam);
    	this.spel.geefSpelbordenLijst().add(this.geefSpelbord());
    	this.spelbordRepository.voegSpelbordToe(velden, volgnummer,spelnaam);
    }
    
    private void controleerSpelbord(char[][] velden, int volgnummer, String spelnaam)
    {
    	int aantalKisten = 0;
    	int aantalDoelen = 0;
    	int aantalMannen = 0;
    	for (int i = 0; i < 10; i++)
    	{
    		for (int j = 0; j < 10; j++)
    		{
    			if (velden[i][j] == 'K')
    				aantalKisten++;
    			if (velden[i][j] == 'D')
    				aantalDoelen++;
    			if (velden[i][j] == 'X')
    				aantalMannen++;
    		}
    	}
    	if (aantalMannen == 0)
    		throw new IllegalArgumentException(Taal.getText("manVerplicht"));
    	else if (aantalMannen > 1)
    		throw new IllegalArgumentException(Taal.getText("max1Man"));
    	if (aantalKisten != aantalDoelen)
    		throw new IllegalArgumentException(Taal.getText("aantalKisten"));
    	else if (aantalKisten < 1 || aantalDoelen < 1)
    		throw new IllegalArgumentException(Taal.getText("minstens1KistEnDoel"));
    }
    
    
    public int geefVolgnummer() 
    {
    	return this.spel.geefVolgnummer();
    }
    
    
    public Spelbord geefSpelbord() 
    {
    	return this.spel.getSpelbord();
    }
    
    public int[] geefVolgnummerSpelborden(String spelnaam)    //array maken van namen van spellen
    {
    	
          int[] namen = new int[spelbordRepository.geefSpelbordenLijst(spelnaam).size()];      // array van namen van de spellen word aangemaakt in de groote van het aantal spellen
          
          for(int i = 0; i < spelbordRepository.geefSpelbordenLijst(spelnaam).size(); i++) 
          {
        	  namen [i] = spelbordRepository.geefSpelbordenLijst(spelnaam).get(i).getVolgnummer();     //elke naam wordt opgevraagd
          }
          
          return namen;
    }
    
    
    public void selecteerSpelbordMetVolgnummer(int volgnummer, String spelnaam)
    {
    	
    	Spelbord spelbord = spelbordRepository.geefSpelbordMetVolgnummer(volgnummer, spelnaam);
    	spel.setHuidigSpelbord(spelbord);
    	
    }
    
    public void updateSpelbord(int volgnummer, char[][] velden, String spelnaam)
    {
    	controleerSpelbord(velden, volgnummer, spelnaam);
    	spelbordRepository.updateSpelbord(volgnummer, velden, spelnaam);
    }
    
//    public char[][] geefVelden()
//    {
//    	char[][] velden = new char[10][10];
//    	
//    	Spelbord spelbord = geefSpelbord();
//    	
//    	for(int i = 0; i < 10; i++)
//    	{
//    		for(int j = 0; j < 10; j++)
//    		{
//    			char karakter = 'O';
//    			if (spelbord.getSpelbord()[i][j].isMuur()) 
//    			{
//                    karakter = 'M';
//                }
//    			else if (spelbord.getSpelbord()[i][j].isDoel() && spelbord.maakVeldenVanKistenLijst().contains(spelbord.getSpelbord()[i][j]))
//    			{
//    				karakter = 'F';
//    			}
//    			else if (spelbord.getMan() != null && spelbord.getMan().getVeld() == spelbord.getSpelbord()[i][j]) 
//    			{
//                    karakter = 'X';
//                }
//    			else if (spelbord.getSpelbord()[i][j].isDoel()) 
//    			{
//                    karakter = 'D';
//                } 
//    			
//                else if (spelbord.maakVeldenVanKistenLijst().contains(spelbord.getSpelbord()[i][j])) 
//                {
//                    karakter = 'K';
//                }  
//    			velden[i][j] = karakter;
//    		}
//    	}
//    	return velden;
//    }

}