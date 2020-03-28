package domein;

public class Veld 
{
	private boolean isMuur;
	private boolean isDoel;
	private int x;
	private int y;
	private boolean isKist;
	private boolean isMan;
	
	public Veld(int x, int y, boolean doel, boolean muur, boolean man, boolean kist) 
	{
		setX(x);
		setY(y);
		setIsDoel(doel);
		setIsMuur(muur);
		setIsMan(man);
		setIsKist(kist);
	}
	
	
	public boolean isMan() 
	{
		return isMan;
	}
	
	
	public void setIsMan(boolean man) 
	{
		this.isMan = man;
	}
	
	
	public boolean isKist() 
	{
		return isKist;
	}
	
	
	public void setIsKist(boolean kist) 
	{
		this.isKist = kist;
	}

	
	public boolean isMuur() 
	{
		return isMuur;
	}
	
	
	public boolean isDoel() 
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
