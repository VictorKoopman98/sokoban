package domein;

import java.util.Arrays;
import java.util.List;

import domein.Veld;

public class Spelbord 
{
	private boolean isVoltooid;
	private int aantalVerplaatsingen;
	private int locatieManX=-1; //locatie van de rij
	private int locatieManY=-1; //locatie van de kolom
	Veld[][] spelbord = new Veld[10][10];
	Kist[] kisten;
	Veld[] veldenVanKisten;
	Man man;
	

	public Spelbord() 
	{
		
	}
	

	private List<Veld> maakVeldenVanKistenLijst() 
	{
		for (int i = 0; i<kisten.length;i++) 
		{
	    	veldenVanKisten[i] = kisten[i].getVeld();
	    }
	    List<Veld> veldenVanKistenLijst = Arrays.asList(veldenVanKisten);
	    return veldenVanKistenLijst;
	}
	
	
	private void bepaalLocatieMan() 
	{
		for (int i = 0; i < 10; i++) 
		{
    		for (int j = 0; j < 10; j++) 
    		{
    			if (spelbord[i][j] == getMan().getVeld()) 
    			{
    				locatieManX = i;
    				locatieManY = j;
    			}
    		}
    	}
	}
	
	
	public Kist[] getKisten() 
	{
		return kisten;
	}

	
	public Veld[] getKistenVeld()         //geef een lijst of array met alle objecten van de klasse kist in
	                                      //steek voor elk object de returnwaarde van de methode getVeld in de array'kisten'
	{
		
		for (int i = 0; i < kisten.length; i++) 
		{
			this.veldenVanKisten[i] = kisten[i].getVeld();
		}
		return veldenVanKisten;
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
	
	
	public boolean getIsVoltooid()
	{
		return this.isVoltooid;
	}
	
	
	public char[][] toonSpelbord() 
    {
        char[][] output = new char[10][10];
        

        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                if (spelbord[i][j].getIsMuur()) 
                {
                    output[i][j] = 'W'; //veld met een muur op is W (wall)
                } 
                else if (spelbord[i][j].getIsDoel() && maakVeldenVanKistenLijst().contains(spelbord[i][j])) 
                {
                    output[i][j] = 'F'; //veld met een doel en een kist op is F (finish)
                } 
                else if (spelbord[i][j].getIsDoel() && !(spelbord[i][j] == getMan().getVeld())) 
                {
                    output[i][j] = 'G';//veld met doel zonder man en zonder kist (Goal)
                } 
                else if (!spelbord[i][j].getIsDoel() && !maakVeldenVanKistenLijst().contains(spelbord[i][j])  && !(spelbord[i][j] == getMan().getVeld())) 
                {
                    output[i][j] = 'N';//veld dat geen doel is, waar geen man of kist op staat (Nothing)
                } 
                else if (spelbord[i][j] == getMan().getVeld()) 
                {
                    output[i][j] = 'M';//veld dat een man bevat (Man)
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
    		
    		if (richting == "links") 
    		{
    			getMan().setVeld(spelbord[locatieManX][locatieManY-1]);
    			if (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY-1])) 
    			{
    				for (int i = 0; i < kisten.length; i++) 
    				{
    					if (spelbord[locatieManX][locatieManY-1] == kisten[i].getVeld()) 
    					{
    						kisten[i].setVeld(spelbord[locatieManX][locatieManY-2]);
    					}
    				}
    			}
    		} 
    		else if (richting == "rechts") 
    		{
    			getMan().setVeld(spelbord[locatieManX][locatieManY+1]);
    			if (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY+1])) 
    			{
    				for (int i = 0; i < kisten.length; i++) 
    				{
    					if (spelbord[locatieManX][locatieManY+1] == kisten[i].getVeld()) 
    					{
    						kisten[i].setVeld(spelbord[locatieManX][locatieManY+2]);
    					}
    				}
    			}
    		}
    		else if (richting == "omhoog") 
    		{
    			getMan().setVeld(spelbord[locatieManX-1][locatieManY]);
    			if (maakVeldenVanKistenLijst().contains(spelbord[locatieManX-1][locatieManY])) 
    			{
    				for (int i = 0; i < kisten.length; i++) 
    				{
    					if (spelbord[locatieManX-1][locatieManY] == kisten[i].getVeld()) 
    					{
    						kisten[i].setVeld(spelbord[locatieManX-2][locatieManY]);
    					}
    				}
    			}
    		}
    		else if (richting == "omlaag") 
    		{
    			getMan().setVeld(spelbord[locatieManX+1][locatieManY]);
    			if (maakVeldenVanKistenLijst().contains(spelbord[locatieManX+1][locatieManY])) 
    			{
    				for (int i = 0; i < kisten.length; i++) 
    				{
    					if (spelbord[locatieManX+1][locatieManY] == kisten[i].getVeld()) 
    					{
    						kisten[i].setVeld(spelbord[locatieManX+2][locatieManY]);
    					}
    				}
    			}
    		}
    	}
    	
    	checkIsSpelbordVoltooid();
    }
	
		
	private void checkIsSpelbordVoltooid() 
	{
		int aantalDoelen = 0;
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++ ) 
			{
				if(spelbord[i][j].getIsDoel()) 
				{
					aantalDoelen += 1;
				}
			}
		}
		
		int aantalKistenOpDoel = 0;
		for (int i = 0; i < 10; i++) 
		{
			for (int j = 0; j < 10; j++) 
			{
				if(maakVeldenVanKistenLijst().contains(spelbord[i][j]) && spelbord[i][j].getIsDoel()) 
				{
					aantalKistenOpDoel += 1;
				}
			}
		}
		
		if (aantalKistenOpDoel == aantalDoelen) 
		{
			isVoltooid = true;
		}
	}
	
	
	public boolean isVerplaatsingOK(String richting) 
	{
		bepaalLocatieMan();
		boolean verplaatsingOk = false;
	
    	if (richting == "links") 
    	{
    		if ( !( spelbord[locatieManX][locatieManY-1].getIsMuur() || locatieManY == 0 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY-1]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY-2]) ) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY-1]) && spelbord[locatieManX][locatieManY-2].getIsMuur()) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY-1]) && locatieManY == 1) ) )
    		{
    			verplaatsingOk = true;
    		}
    	
    	}
    	if (richting == "rechts") 
    	{
    		if ( !( spelbord[locatieManX][locatieManY+1].getIsMuur() || locatieManY == 9 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY+1]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY+2]) ) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY+1]) && spelbord[locatieManX][locatieManY+2].getIsMuur()) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY+1]) && locatieManY == 8) ) )
    		{
    			verplaatsingOk = true;
    		}
    	}
    	if (richting == "omhoog") 
    	{
    		if ( !( spelbord[locatieManX-1][locatieManY].getIsMuur() || locatieManX == 0 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX-1][locatieManY]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX-2][locatieManY]) ) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX-1][locatieManY]) && spelbord[locatieManX-2][locatieManY].getIsMuur()) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX-1][locatieManY]) && locatieManX == 1)) )
    		{
    			verplaatsingOk = true;
    		}
    	}
    	if (richting == "omlaag") 
    	{
    		if ( !( spelbord[locatieManX+1][locatieManY].getIsMuur() || locatieManX == 9 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX+1][locatieManY]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX+2][locatieManY]) ) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX+1][locatieManY]) && spelbord[locatieManX+2][locatieManY].getIsMuur()) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX+1][locatieManY]) && locatieManX == 8)) )
    		{
    			verplaatsingOk = true;
    		}
    	}
    	
    	return verplaatsingOk;
    }
	
	
	public void resetSpelbord() 
	{
		aantalVerplaatsingen = 0;
		getMan().setVeld(getMan().getOorspronkelijkVeld());
		for (int i = 0; i<kisten.length; i++) {
			kisten[i].setVeld(kisten[i].getOorspronkelijkVeld());
		}
	}
	

}