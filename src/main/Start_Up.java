package main;

import cui.SokobanApplicatie;

import domein.DomeinController;

public class Start_Up 
{

	public static void main(String[] args) 
	{
		DomeinController dc = new DomeinController();
		SokobanApplicatie sa = new SokobanApplicatie(dc);
		sa.run();    //run methode van sokobanapplicatie wordt uitgevoerd
	}

}
