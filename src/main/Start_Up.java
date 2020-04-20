package main;

import java.util.InputMismatchException;
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
		int taal = 0;
		Scanner input = new Scanner(System.in);
		do
		{
		    System.out.printf("1.Kies een taal (NL)%n2.Choose a language (EN)%n3.Choisissez une langue (FR): ");
		    try
		    {
		    	taal = input.nextInt();
				if (!((taal == 1 || taal == 2 ||  taal == 3 )))
				{
				    throw new IllegalArgumentException("Verkeerde input/ Wrong input/ Entrée incorrecte");
				}
		    } catch (IllegalArgumentException ie)
		    
		    {
			System.out.println(ie.getMessage());
		    }
		    catch(InputMismatchException e)
		    {
		    	System.out.println("Er moet een nummer gekozen worden !");
		    }
		} while (!(taal == 1 || taal == 3 || taal == 2));
		String taalString ="";
		switch(taal)
		{
		case 1 :
			taalString = "NL";
			break;
			
		case 2 : 
			taalString = "EN";
			break;
		case 3 :
			taalString = "FR";
			break;
			}
		
		taalObj = new Taal(taalString);
    }
	

}