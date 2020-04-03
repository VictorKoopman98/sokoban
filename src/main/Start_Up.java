package main;

import java.util.Scanner;

import cui.SokobanApplicatie;

import domein.DomeinController;
import gui.Taal;

public class Start_Up 
{
	
	static Taal taalObj;
	public static void main(String[] args) 
	{
		
		kiesTaal();
		DomeinController dc = new DomeinController(taalObj);
		SokobanApplicatie sa = new SokobanApplicatie(dc,taalObj);
		
		sa.run();    //run methode van sokobanapplicatie wordt uitgevoerd
		
	
	}
	
	public static void kiesTaal()
    {
		String taal = "";
		Scanner input = new Scanner(System.in);
		do
		{
		    System.out.print("Kies een taal (NL) / Choose a language (EN) / Choisissez une langue (FR): ");
		    try
		    {
		    	taal = input.nextLine();
				if (!(("NL".equals(taal)) || ("EN".equals(taal)) || ("FR".equals(taal))))
				{
				    throw new IllegalArgumentException("Verkeerde input/ Wrong input/ Entrée incorrecte");
				}
		    } catch (IllegalArgumentException ie)
		    {
			System.out.println(ie.getMessage());
		    }
		} while (!(taal.equals("NL") || taal.equals("FR") || taal.equals("EN")));
		
		taalObj = new Taal(taal);
    }
	

}