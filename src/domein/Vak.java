package domein;

<<<<<<< HEAD
import domein.Man;
import domein.Kist;


=======


//karakterlegende:
//	muur = w
//	man = m
//	kist = k
//	leeg veld = v
	
>>>>>>> branch 'master' of https://github.com/HoGentTIProjecten1/sokoban-g39.git

public class Vak {
	
	private int locatie;
<<<<<<< HEAD
	private boolean isMuur;
	private boolean isDoel;
	
=======
	private String karakter;
	private boolean isDoel;
>>>>>>> branch 'master' of https://github.com/HoGentTIProjecten1/sokoban-g39.git

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