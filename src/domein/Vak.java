package domein;

import domein.Man;
import domein.Kist;



public class Vak {
	
	private int locatie;
	private boolean isMuur;
	private boolean isDoel;
	

	public Vak() {
		// TODO Auto-generated constructor stub
		
	}
	
	public boolean getIsDoel() {
		return isDoel;
	}
	
	public void setIsDoel(boolean doel) {
		this.isDoel = doel;
	}
	
	public boolean getIsMuur() {
		return isMuur;
	}
	
	public void setIsMuur(boolean muur) {
		this.isMuur = muur;
	}
	
	public void setLocatie(int locatie) {
		this.locatie = locatie;
	}
	
	public int getLocatie() {
		return locatie;
	}
	
	

}
