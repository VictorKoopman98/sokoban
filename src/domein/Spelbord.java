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
	private int volgnummer;
	Veld[][] spelbord; //[[Veld(x, y)][Veld(x, y][Veld(x, y)]]
	Kist[] kisten;
	Veld[] veldenVanKisten;
	Man man;
	

	public Spelbord(int volgnummer, Veld[][] velden) 
	{
		this.volgnummer = volgnummer;
		this.isVoltooid = false;
		this.aantalVerplaatsingen = 0;

		this.spelbord = velden;
		int aantalKisten = 0;

		for (int i = 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				
				
				if (velden[i][j].isMan()) 
				{
					man = new Man(velden[i][j]);
				}
				else if (velden[i][j].isKist()) 
				{		
					Kist kist = new Kist(velden[i][j]);
					kisten[aantalKisten] = kist;
					aantalKisten++;
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
		for (int i = 0; i<kisten.length;i++) 
		{
	    	veldenVanKisten[i] = kisten[i].getVeld();
	    }
	    List<Veld> veldenVanKistenLijst = Arrays.asList(veldenVanKisten);
	    return veldenVanKistenLijst;
	}
	
	
	private void bepaalLocatieMan() 
	{
		locatieManX = getMan().getVeld().getX();
		locatieManY = getMan().getVeld().getY();
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
	

	public void setAantalVerplaatsingen(int aantalVerplaatsingen) 
	{
		this.aantalVerplaatsingen = aantalVerplaatsingen;
	}

	
	public boolean getIsVoltooid()
	{
		return this.isVoltooid;
	}
	

	public void setIsVoltooid(boolean isVoltooid) 
	{
		this.isVoltooid = isVoltooid;
	}

	
	public void toonSpelbord() 
    {
        char[][] output = new char[10][10];
        
        for (int i = 0; i < 10; i++) 
        {
            for (int j = 0; j < 10; j++) 
            {
                if (spelbord[i][j].isMuur()) 
                {
                    output[i][j] = 'W'; //veld met een muur op is W (wall)
                } 
                
                else if (spelbord[i][j].isMan()) 
                {
                    output[i][j] = 'M';//veld dat een man bevat (Man)

                } 
                else if (spelbord[i][j].isDoel() && !spelbord[i][j].isMan()) 
                {
                    output[i][j] = 'G';//veld met doel(Goal)
                }
                
                else if (spelbord[i][j].isDoel() && spelbord[i][j].isKist()) 
                {
                    output[i][j] = 'F'; //veld met een doel en een kist op is F (Finished)
                } 
                 
                else if (!spelbord[i][j].isDoel() && !spelbord[i][j].isKist()  && !spelbord[i][j].isMan()) 
                {
                    output[i][j] = 'N';//Leeg veld(Nothing)
                } 
               
                else if (spelbord[i][j].isKist()) 
                {
                    output[i][j] = 'K';//veld met een kist (Kist)
                }       
            }
        }
        for(int i = 0; i<output.length;i++) {
        	System.out.println(Arrays.toString(output[i]));
        }
        
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
    		if ( !( spelbord[locatieManX][locatieManY-1].isMuur() || locatieManY == 0 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY-1]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY-2]) ) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY-1]) && spelbord[locatieManX][locatieManY-2].isMuur()) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY-1]) && locatieManY == 1) ) )
    		{
    			verplaatsingOk = true;
    		}
    	
    	}
    	if (richting == "rechts") 
    	{
    		if ( !( spelbord[locatieManX][locatieManY+1].isMuur() || locatieManY == 9 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY+1]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY+2]) ) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY+1]) && spelbord[locatieManX][locatieManY+2].isMuur()) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX][locatieManY+1]) && locatieManY == 8) ) )
    		{
    			verplaatsingOk = true;
    		}
    	}
    	if (richting == "omhoog") 
    	{
    		if ( !( spelbord[locatieManX-1][locatieManY].isMuur() || locatieManX == 0 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX-1][locatieManY]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX-2][locatieManY]) ) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX-1][locatieManY]) && spelbord[locatieManX-2][locatieManY].isMuur()) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX-1][locatieManY]) && locatieManX == 1)) )
    		{
    			verplaatsingOk = true;
    		}
    	}
    	if (richting == "omlaag") 
    	{
    		if ( !( spelbord[locatieManX+1][locatieManY].isMuur() || locatieManX == 9 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX+1][locatieManY]) && maakVeldenVanKistenLijst().contains(spelbord[locatieManX+2][locatieManY]) ) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX+1][locatieManY]) && spelbord[locatieManX+2][locatieManY].isMuur()) 
    				|| (maakVeldenVanKistenLijst().contains(spelbord[locatieManX+1][locatieManY]) && locatieManX == 8)) )
    		{
    			verplaatsingOk = true;
    		}
    	}
    	
    	return verplaatsingOk;
    }
	
	
	public void wijzigSpelbord(int x, int y, int actie) 
	{
//	TO DO: controle of er niet meer dan 1 man aanwezig is
//		controle of er evenveel kisten als doelen zijn
//		LEGENDE
//		"1: Maak een doel%n"
//				+ "2: Maak een muur%n"
//				+ "3: Zet een man%n"
//				+ "4: Zet een kist%n"
//				+ "5: Maak het veld leeg%n"
//				+ "6: Stop wijzigen"
		if (actie == 1) 
		{
			spelbord[x][y].setIsDoel(true);
		}
		else if (actie == 2) 
		{
			spelbord[x][y].setIsMuur(true);
		}
		else if (actie == 3) 
		{
			this.man = new Man(spelbord[x][y]);
			spelbord[x][y].setIsMan(true);
		}
		else if (actie == 4) 
		{
			kisten[kisten.length] = new Kist(spelbord[x][y]);
			spelbord[x][y].setIsKist(true);
		}
		else if (actie == 5) 
		{
			spelbord[x][y] = new Veld(x, y, false, false, false, false);
		}
	}
	

	
	

}