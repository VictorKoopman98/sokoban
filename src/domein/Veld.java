package domein;

public class Veld 
{
	private boolean isMuur;
	private boolean isDoel;
	private int x;
	private int y;
	private boolean kist;
	private boolean man;
	
	public Veld(int x, int y) 
	{
		setIsDoel(false);
		setIsMuur(false);
	}
	
	
	public boolean getMan() 
	{
		return this.man;
	}
	
	
	public void setMan(boolean man) 
	{
		this.man = man;
	}
	
	
	public boolean getKist() 
	{
		return this.kist;
	}
	
	
	public void setKist(boolean kist) 
	{
		this.kist = kist;
	}

	
	public boolean getIsMuur() 
	{
		return isMuur;
	}
	
	
	public boolean getIsDoel() 
	{
		return isDoel;
	}
	
	
	public void setIsMuur(boolean isMuur) 
	{
		this.isMuur = isMuur;
	}
	
	
	public void setIsDoel(boolean isDoel) 
	{
		this.isDoel = isDoel;
	}
	
	
	public int getX() 
	{
		return x;
	}
	
	
	public void setX(int x) 
	{
		this.x = x;
	}
	
	
	public int getY() 
	{
		return y;
	}
	
	
	public void setY(int y) 
	{
		this.y = y;
	}
}
