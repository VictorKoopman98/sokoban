package domein;

public class Veld 
{
	private boolean isMuur;
	private boolean isDoel;
	private int x;
	private int y;

	
	public boolean getIsMuur() 
	{
		return isMuur;
	}
	
	public boolean getIsDoel() 
	{
		return isDoel;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
}
