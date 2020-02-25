package cui;

import java.util.Scanner;

import domein.DomeinController;
import gui.Taal;

public class SokobanApplicatie
{
	Scanner input = new Scanner(System.in);
	private DomeinController domeincontroller;
	private Taal taal;
	
	public SokobanApplicatie(DomeinController domeincontroller)
	{
		this.domeincontroller = domeincontroller;
	}
	
	public void toonHoofdpaneel()
	{
		boolean validatie = false;
		int keuze = 0;
		kiesTaal();
		
		
		System.out.printf("%s%n", taal.getText("Welkom Hoofdpaneel"));
		
	}

	private void kiesTaal()
	{
		// TODO Auto-generated method stub
		
	}
	
	
	
}
