package cui;

import domein.DomeinController;

public class UC7Test {

	DomeinController dc;
	
	public UC7Test(DomeinController dc) 
	{
		this.dc = dc;
	}
	
	public void wijzigSpel() {
		dc.geefLijstSpellen();
	}
}
