package main;

import java.util.InputMismatchException;
import java.util.Scanner;

import cui.SokobanApplicatie;

import domein.DomeinController;
import gui.Taal;

public class Start_Up 
{
	public static void main(String[] args) 
	{
		Taal taal = new Taal();
		DomeinController dc = new DomeinController();
		SokobanApplicatie sa = new SokobanApplicatie(dc);
		
		sa.run();    //run methode van sokobanapplicatie wordt uitgevoerd
		
	
	}
	

}