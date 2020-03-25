package domein;

public class Veld 
{
	private boolean isMuur;
	private boolean isDoel;
	private int x;
	private int y;
	
	public Veld(int x, int y) {
		setIsDoel(false);
		setIsMuur(false);
	}

	
	public boolean getIsMuur() 
	{
		return isMuur;
	}
	
	public boolean getIsDoel() 
	{
		return isDoel;
	}
	
	public void setIsMuur(boolean isMuur) {
		this.isMuur = isMuur;
	}
	
	public void setIsDoel(boolean isDoel) {
		this.isDoel = isDoel;
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
