package domein;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import domein.Veld;

public class Spelbord 
{
	private boolean isVoltooid;
	private int aantalVerplaatsingen;
	private int locatieManX=-1; //locatie van de rij
	private int locatieManY=-1; //locatie van de kolom
	private int volgnummer;
	Veld[][] spelbord; //[[Veld(x, y)][Veld(x, y][Veld(x, y)]]
	ArrayList<Kist> kisten = new ArrayList<Kist>();
	Veld[] veldenVanKisten;
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
		for (int i = 0; i<kisten.size();i++) 
		{
	    	veldenVanKisten[i] = kisten.get(i).getVeld();
	    }
	    List<Veld> veldenVanKistenLijst = Arrays.asList(veldenVanKisten);
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

	
	public Veld[] getKistenVeld()         //geef een lijst of array met alle objecten van de klasse kist in
	                                      //steek voor elk object de returnwaarde van de methode getVeld in de array'kisten'
	{
		
		for (int i = 0; i < kisten.size(); i++) 
		{
			this.veldenVanKisten[i] = kisten.get(i).getVeld();
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
                
                
                else if (spelbord[i][j].isDoel() && spelbord[i][j].isKist()) 
                {
                    output[i][j] = 'F'; //veld met een doel en een kist op is F (Finished)
                } 
                else if (spelbord[i][j].isDoel() && !spelbord[i][j].isMan()) 
                {
                    output[i][j] = 'G';//veld met doel(Goal)
                }
                 
                else if (!spelbord[i][j].isDoel() && !spelbord[i][j].isKist()  && !spelbord[i][j].isMan()) 
                {
                    output[i][j] = ' ';//Leeg veld(Nothing)
                } 
               
                else if (spelbord[i][j].isKist()) 
                {
                    output[i][j] = 'K';//veld met een kist (Kist)
                }    
                System.out.printf(" %s ",output[i][j]);
            }
            
            System.out.printf("%n");
            
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
    			spelbord[locatieManX][locatieManY].setIsMan(false);
    			spelbord[locatieManX][locatieManY-1].setIsMan(true);
    			if (spelbord[locatieManX][locatieManY-1].isKist()) 
    			{
    				for (int i = 0; i < kisten.size(); i++) 
    				{
    					if (spelbord[locatieManX][locatieManY-1] == kisten.get(i).getVeld()) 
    					{
    						kisten.get(i).setVeld(spelbord[locatieManX][locatieManY-2]);
    						spelbord[locatieManX][locatieManY-1].setIsKist(false);
    						spelbord[locatieManX][locatieManY-2].setIsKist(true);
    					}
    				}
    			}
    		} 
    		else if (richting == "rechts") 
    		{
    			getMan().setVeld(spelbord[locatieManX][locatieManY+1]);
    			spelbord[locatieManX][locatieManY].setIsMan(false);
    			spelbord[locatieManX][locatieManY+1].setIsMan(true);
    			if (spelbord[locatieManX][locatieManY+1].isKist()) 
    			{
    				for (int i = 0; i < kisten.size(); i++) 
    				{
    					if (spelbord[locatieManX][locatieManY+1] == kisten.get(i).getVeld()) 
    					{
    						kisten.get(i).setVeld(spelbord[locatieManX][locatieManY+2]);
    						spelbord[locatieManX][locatieManY+1].setIsKist(false);
    						spelbord[locatieManX][locatieManY+2].setIsKist(true);
    					}
    				}
    			}
    		}
    		else if (richting == "omhoog") 
    		{
    			getMan().setVeld(spelbord[locatieManX-1][locatieManY]);
    			spelbord[locatieManX][locatieManY].setIsMan(false);
    			spelbord[locatieManX-1][locatieManY].setIsMan(true);
    			if (spelbord[locatieManX-1][locatieManY].isKist()) 
    			{
    				for (int i = 0; i < kisten.size(); i++) 
    				{
    					if (spelbord[locatieManX-1][locatieManY] == kisten.get(i).getVeld()) 
    					{
    						kisten.get(i).setVeld(spelbord[locatieManX-2][locatieManY]);
    						spelbord[locatieManX-1][locatieManY].setIsKist(false);
    						spelbord[locatieManX-2][locatieManY].setIsKist(true);
    					}
    				}
    			}
    		}
    		else if (richting == "omlaag") 
    		{
    			getMan().setVeld(spelbord[locatieManX+1][locatieManY]);
    			spelbord[locatieManX][locatieManY].setIsMan(false);
    			spelbord[locatieManX+1][locatieManY].setIsMan(true);
    			if (spelbord[locatieManX+1][locatieManY].isKist()) 
    			{
    				for (int i = 0; i < kisten.size(); i++) 
    				{
    					if (spelbord[locatieManX+1][locatieManY] == kisten.get(i).getVeld()) 
    					{
    						kisten.get(i).setVeld(spelbord[locatieManX+2][locatieManY]);
    						spelbord[locatieManX+1][locatieManY].setIsKist(false);
    						spelbord[locatieManX+2][locatieManY].setIsKist(true);
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
				if(spelbord[i][j].isKist() && spelbord[i][j].isDoel()) 
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
    				|| (spelbord[locatieManX][locatieManY-1].isKist() && spelbord[locatieManX][locatieManY-2].isKist() ) 
    				|| (spelbord[locatieManX][locatieManY-1].isKist() && spelbord[locatieManX][locatieManY-2].isMuur()) 
    				|| (spelbord[locatieManX][locatieManY-1].isKist() && locatieManY == 1) ) )
    		{
    			verplaatsingOk = true;
    		}
    	
    	}
    	if (richting == "rechts") 
    	{
    		if ( !( spelbord[locatieManX][locatieManY+1].isMuur() || locatieManY == 9 
    				|| (spelbord[locatieManX][locatieManY+1].isKist() && spelbord[locatieManX][locatieManY+2].isKist() ) 
    				|| (spelbord[locatieManX][locatieManY+1].isKist() && spelbord[locatieManX][locatieManY+2].isMuur()) 
    				|| (spelbord[locatieManX][locatieManY+1].isKist() && locatieManY == 8) ) )
    		{
    			verplaatsingOk = true;
    		}
    	}
    	if (richting == "omhoog") 
    	{
    		if ( !( spelbord[locatieManX-1][locatieManY].isMuur() || locatieManX == 0 
    				|| (spelbord[locatieManX-1][locatieManY].isKist() && spelbord[locatieManX-2][locatieManY].isKist() ) 
    				|| (spelbord[locatieManX-1][locatieManY].isKist() && spelbord[locatieManX-2][locatieManY].isMuur()) 
    				|| (spelbord[locatieManX-1][locatieManY].isKist() && locatieManX == 1)) )
    		{
    			verplaatsingOk = true;
    		}
    	}
    	if (richting == "omlaag") 
    	{
    		if ( !( spelbord[locatieManX+1][locatieManY].isMuur() || locatieManX == 9 
    				|| (spelbord[locatieManX+1][locatieManY].isKist() && spelbord[locatieManX+2][locatieManY].isKist() ) 
    				|| (spelbord[locatieManX+1][locatieManY].isKist() && spelbord[locatieManX+2][locatieManY].isMuur()) 
    				|| (spelbord[locatieManX+1][locatieManY].isKist() && locatieManX == 8)) )
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
			Kist kist = new Kist(spelbord[x][y]);
			kisten.add(kist);
			spelbord[x][y].setIsKist(true);
		}
		else if (actie == 5) 
		{
			spelbord[x][y] = new Veld(x, y, false, false, false, false);
		}
	}
}