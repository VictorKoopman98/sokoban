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
	private Spel spel;
	List<Spel> spellenLijst = SpelRepository.geefSpellenList();     // hier geplaatst want zetNaamOmInSpel en geefLijstSpellen gebruiken het
	
	
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
    	
          String[] namen = new String[spellenLijst.size()];      // array van namen van de spellen word aangemaakt in de groote van het aantal spellen
          
          for(int i = 0; i < spellenLijst.size(); i++) 
          {
        	  namen [i] = spellenLijst.get(i).getNaam();     //elke naam wordt opgevraagd
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
    	return spellenLijst.get(index);           // naam omzetten naar een spel 
    }
    

    
    
    //---------------------------------------------------------------------
    
    public char[][] toonSpelbord() 
    {
        char[][] output = new char[10][10];
        Veld[][] velden = this.spel.getSpelbord().getVakken();
        Kist[] kisten = this.spel.getSpelbord().getKisten();
        Veld[] veldenVanKisten;
        
        
        for (int i = 0; i<kisten.length;i++) {
        	veldenVanKisten[i] = kisten[i].getVeld();
        }
        List<Veld> veldenVanKistenLijst = Arrays.asList(veldenVanKisten);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (velden[i][j].getIsMuur()) 
                {
                    output[i][j] = 'W'; //veld met een muur op is W (wall)
                } 
                else if (velden[i][j].getIsDoel() && veldenVanKistenLijst.contains(velden[i][j])) 
                {
                    output[i][j] = 'F'; //veld met een doel en een kist op is F (finish)
                } 
                else if (velden[i][j].getIsDoel() && !(velden[i][j] == this.spel.getSpelbord().getMan().getVeld())) 
                {
                    output[i][j] = 'G';//veld met doel zonder man en zonder kist (Goal)
                } 
                else if (!velden[i][j].getIsDoel() && !veldenVanKistenLijst.contains(velden[i][j])  && !(velden[i][j] == this.spel.getSpelbord().getMan().getVeld())) 
                {
                    output[i][j] = 'N';//veld dat geen doel is, waar geen man of kist op staat (Nothing)
                } 
                else if (velden[i][j] == this.spel.getSpelbord().getMan().getVeld()) 
                {
                    output[i][j] = 'M';//veld dat een man bevat (Man)
                } 
                else if (veldenVanKistenLijst.contains(velden[i][j])) 
                {
                    output[i][j] = 'K';//veld met een kist (Kist)
                } 
                
            }
        }
        return output;

    }
    
    public void verplaatsMan(String richting) {
    	int locatieManX=-1; //locatie van de rij
    	int locatieManY=-1; //locatie van de kolom
    	Veld[][] velden = this.spel.getSpelbord().getVakken();
    	Kist[] kisten = this.spel.getSpelbord().getKisten();
    	Veld[] veldenVanKisten;
        
        
        for (int i = 0; i<kisten.length;i++) {
        	veldenVanKisten[i] = kisten[i].getVeld();
        }
        List<Veld> veldenVanKistenLijst = Arrays.asList(veldenVanKisten);
    	
    	
    	for (int i = 0; i < 10; i++) {
    		for (int j = 0; j < 10; j++) {
    			if (velden[i][j] == this.spel.getSpelbord().getMan().getVeld()) {
    				locatieManX = i;
    				locatieManY = j;
    			}
    		}
    	}
    	
    	if (verplaatsingOK(richting)) {
    		if (richting == "links") {
    			this.spel.getSpelbord().getMan().setVeld(velden[locatieManX][locatieManY-1]);
    			if (veldenVanKistenLijst.contains(velden[locatieManX][locatieManY-1])) 
    			{
    				for (int i = 0; i < kisten.length; i++) {
    					if (velden[locatieManX][locatieManY-1] == kisten[i].getVeld()) {
    						kisten[i].setVeld(velden[locatieManX][locatieManY-2]);
    					}
    				}
    			}
    		} 
    		else if (richting == "rechts") {
    			this.spel.getSpelbord().getMan().setVeld(velden[locatieManX][locatieManY+1]);
    			if (veldenVanKistenLijst.contains(velden[locatieManX][locatieManY+1])) 
    			{
    				for (int i = 0; i < kisten.length; i++) {
    					if (velden[locatieManX][locatieManY+1] == kisten[i].getVeld()) {
    						kisten[i].setVeld(velden[locatieManX][locatieManY+2]);
    					}
    				}
    			}
    		}
    		else if (richting == "omhoog") {
    			this.spel.getSpelbord().getMan().setVeld(velden[locatieManX-1][locatieManY]);
    			if (veldenVanKistenLijst.contains(velden[locatieManX-1][locatieManY])) 
    			{
    				for (int i = 0; i < kisten.length; i++) {
    					if (velden[locatieManX-1][locatieManY] == kisten[i].getVeld()) {
    						kisten[i].setVeld(velden[locatieManX-2][locatieManY]);
    					}
    				}
    			}
    		}
    		else if (richting == "omlaag") {
    			this.spel.getSpelbord().getMan().setVeld(velden[locatieManX+1][locatieManY]);
    			if (veldenVanKistenLijst.contains(velden[locatieManX+1][locatieManY])) 
    			{
    				for (int i = 0; i < kisten.length; i++) {
    					if (velden[locatieManX+1][locatieManY] == kisten[i].getVeld()) {
    						kisten[i].setVeld(velden[locatieManX+2][locatieManY]);
    					}
    				}
    			}
    		}
    	}
    	
    }
    
    
    // verplaatsingOK
    public boolean verplaatsingOK(String richting) {
    	return true;
    }
    
    //geefAantalVerplaatsingen
    
    //isEindeSpelbordBereikt()
    
   //--------------------------------------------------------------------------------------------  
}





