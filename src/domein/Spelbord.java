package domein;

import java.util.List;
import java.util.ResourceBundle;
import java.util.ArrayList;

import domein.Veld;
import gui.Taal;

public class Spelbord 
{
	private boolean isVoltooid;
	private int aantalVerplaatsingen;
	private int locatieManX=-1; //locatie van de rij
	private int locatieManY=-1; //locatie van de kolom
	private int volgnummer;
	
	Veld[][] spelbord; //[[Veld(x, y)][Veld(x, y][Veld(x, y)]]
	ArrayList<Kist> kisten = new ArrayList<Kist>();
	Man man;
	

	public Spelbord(int volgnummer, Veld[][] velden) 
	{
		this.volgnummer = volgnummer;
		this.isVoltooid = false;
		this.aantalVerplaatsingen = 0;

		this.spelbord = velden;

		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				
				
				if (spelbord[i][j].isMan()) 
				{
					man = new Man(velden[i][j]);
					velden[i][j].setIsMan(true);
				}
				else if (spelbord[i][j].isKist()) 
				{
					Kist kist = new Kist(spelbord[i][j]);
					kisten.add(kist);
				}
			}
		}
		
	}
	
	
	public int getVolgnummer()  
	{
		return this.volgnummer;
	}
	
	
	public void setVolgnummer(int nummer) 
	{
		this.volgnummer = nummer;
	}
	

	public List<Veld> maakVeldenVanKistenLijst() 
	{
		List<Veld> veldenVanKistenLijst = new ArrayList<Veld>();
		if (kisten.size() != 0) {
			for (int i = 0; i<kisten.size();i++) 
			{
		    	veldenVanKistenLijst.add(kisten.get(i).getVeld()); 
		    }
		}
	    return veldenVanKistenLijst;
	}
	
	
	private void bepaalLocatieMan() 
	{
		locatieManX = getMan().getVeld().getX();
		locatieManY = getMan().getVeld().getY();
	}
	
	
	public List<Kist> getKisten() 
	{
		return kisten;
	}

	
	
	public Man getMan() 
	{
		return man;	
	}
	

	public Veld[][] getSpelbord() 
	{
		return spelbord;
	} 
	
	
	public int getAantalVerplaatsingen() 
	{
		return this.aantalVerplaatsingen;
	}
	

	public void setAantalVerplaatsingen(int aantalVerplaatsingen) 
	{
		this.aantalVerplaatsingen = aantalVerplaatsingen;
	}

	
	public boolean isVoltooid()
	{
		return this.isVoltooid;
	}
	

	public void setIsVoltooid(boolean isVoltooid) 
	{
		this.isVoltooid = isVoltooid;
	} 

	
	public char[][] geefVelden() 
    {
        char[][] output = new char[10][10];
        
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                if (spelbord[i][j].isMuur()) 
                {
                    output[i][j] = 'X'; //veld met een muur op is W (wall)
                } 
                else if (man != null && spelbord[i][j] == man.getVeld()) 
                {
                    output[i][j] = 'M';//veld dat een man bevat (Man)
                } 
                else if (spelbord[i][j].isDoel() && maakVeldenVanKistenLijst().contains(spelbord[i][j])) 
                {
                    output[i][j] = 'O'; //veld met een doel en een kist op is F (Finished)
                } 
                else if (spelbord[i][j].isDoel()) 
                {
                    output[i][j] = '?';//veld met doel(Goal)
                }
                else if (!spelbord[i][j].isDoel() && !maakVeldenVanKistenLijst().contains(spelbord[i][j])) 
                {
                    output[i][j] = '.';//Leeg veld(Nothing)
                } 
                else if (maakVeldenVanKistenLijst().contains(spelbord[i][j])) 
                {
                    output[i][j] = 'K';//veld met een kist (Kist)
                }    
            }            
        }
        return output;
    }
	
	
	public void verplaatsMan(String richting) 
	{
		bepaalLocatieMan();
		
    	if (isVerplaatsingOK(richting)) 
    	{
    		aantalVerplaatsingen += 1;
    		int verplaatsingX = 0;
    		int verplaatsingY = 0;
    		if (richting.equals("links")) 
    		{
    			verplaatsingY = -1;
    		} 
    		else if (richting.equals("rechts")) 
    		{
    			verplaatsingY = +1;
    		}
    		else if (richting.equals("omhoog")) 
    		{
    			verplaatsingX = -1;
    		}
    		else if (richting.equals("omlaag")) 
    		{
    			verplaatsingX = +1;
    		}
    		getMan().setVeld(spelbord[locatieManX+verplaatsingX][locatieManY+verplaatsingY]);
			if (maakVeldenVanKistenLijst().contains(spelbord[locatieManX+verplaatsingX][locatieManY+verplaatsingY])) 
			{
				for (int i = 0; i < kisten.size(); i++) 
				{
					if (spelbord[locatieManX+verplaatsingX][locatieManY+verplaatsingY] == kisten.get(i).getVeld()) 
					{
						kisten.get(i).setVeld(spelbord[locatieManX+verplaatsingX*2][locatieManY+verplaatsingY*2]);
						break;
					}
				}
			}
    	}	
    	isEindeSpelbordBereikt();
    }
		
	private void isEindeSpelbordBereikt() 
	{
		int aantalDoelen = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++ ) {
				if(spelbord[i][j].isDoel()) 
				{
					aantalDoelen += 1;
				}
			}
		}
		int aantalKistenOpDoel = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(maakVeldenVanKistenLijst().contains(spelbord[i][j]) && spelbord[i][j].isDoel()) 
				{
					aantalKistenOpDoel += 1;
				}
			}
		}
		if (aantalKistenOpDoel == aantalDoelen) {
			this.isVoltooid = true;
		}
	}
	
	public boolean isVerplaatsingOK(String richting) 
	{
		
		bepaalLocatieMan();
		boolean verplaatsingOk = false;
		int verplaatsingX = 0;
		int verplaatsingY = 0;
		int grens = 0;
	
    	if (richting.equals("links")) 
    	{
    		verplaatsingY = -1;
    		grens = 0;
    	}
    	
    	if (richting.equals("rechts")) 
    	{
    		verplaatsingY = 1;
    		grens = 9;
    	}
    	if (richting.equals("omhoog")) 
    	{
    		verplaatsingX = -1;
    		grens = 0;
    	}
    	if (richting.equals("omlaag")) 
    	{
    		verplaatsingX = 1;
    		grens = 9;
    	}
    	
    	if (richting.equals("omhoog") || richting.equals("omlaag")) {
	    	if ( !( spelbord[locatieManX + verplaatsingX][locatieManY + verplaatsingY].isMuur() || locatieManX == grens 
					|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX + verplaatsingX][locatieManY + verplaatsingY]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX + verplaatsingX*2][locatieManY + verplaatsingY*2]) ) 
					|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX + verplaatsingX][locatieManY + verplaatsingY]) && spelbord[locatieManX + verplaatsingX*2][locatieManY + verplaatsingY*2].isMuur()) 
					|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX + verplaatsingX][locatieManY + verplaatsingY]) && locatieManX == grens-verplaatsingX) ) )
			{
				verplaatsingOk = true;
			}
    	}
    	if (richting.equals("links") || richting.equals("rechts")) {
	    	if ( !( spelbord[locatieManX + verplaatsingX][locatieManY + verplaatsingY].isMuur() || locatieManY == grens 
					|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX + verplaatsingX][locatieManY + verplaatsingY]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX + verplaatsingX*2][locatieManY + verplaatsingY*2]) ) 
					|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX + verplaatsingX][locatieManY + verplaatsingY]) && spelbord[locatieManX + verplaatsingX*2][locatieManY + verplaatsingY*2].isMuur()) 
					|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX + verplaatsingX][locatieManY + verplaatsingY]) && locatieManY == grens-verplaatsingY) ) )
			{
				verplaatsingOk = true;
			}
    	}
    	if (!verplaatsingOk)
    		throw new IllegalArgumentException(Taal.getText("ongeldigeRichting"));
    	return verplaatsingOk;
    }
	
	
	public void wijzigSpelbord(int x, int y, int actie) 
	{
		if(actie < 1 || actie > 6)
		{
			throw new IllegalArgumentException(Taal.getText("ongeldigActie"));
		}
		if(x < 0 || x > 9)
		{
			throw new IllegalArgumentException(Taal.getText("rijBuitenGrens"));
		}
		if(y < 0 || y > 9)
		{
			throw new IllegalArgumentException(Taal.getText("kolomBuitenGrens"));
		}
		else if(actie == 1) 
		{
			spelbord[x][y].setIsDoel(true);
		}
		else if (actie == 2) 
		{
			spelbord[x][y].setIsMuur(true);
		}
		else if (actie == 3) 
		{	
			if (this.man != null) 
			{
				throw new IllegalArgumentException(Taal.getText("spelbordMetEenMan"));
			}
			this.man = new Man(spelbord[x][y]);
            spelbord[x][y].setIsMan(true);
		}
		else if (actie == 4) 
		{
			Kist kist = new Kist(spelbord[x][y]);
			kisten.add(kist);
			spelbord[x][y].setIsKist(true);
		}
		else if (actie == 5) 
		{
			if (maakVeldenVanKistenLijst().contains(spelbord[x][y])) {
				for(int i = 0; i< kisten.size(); i++) {
					if(spelbord[x][y] == kisten.get(i).getVeld()) {
						kisten.remove(kisten.get(i));
					}
				}
			}
			if (man.getVeld() ==  spelbord[x][y]) {
				man = null;
			}
			spelbord[x][y] = new Veld(x, y, false, false, false, false);
		}
		else if ( actie == 6) 
		{
			int aantalDoelen = 0;
			for (int i = 0; i<10;i++) {
				for (int j = 0; j<10;j++) {
					if(spelbord[i][j].isDoel()) 
					{
						aantalDoelen++;
					}
				}
			}
			if(kisten.size() != aantalDoelen) 
			{
				throw new IllegalArgumentException(Taal.getText("aantalKisten"));
			}
		}
	}
}