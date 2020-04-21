package gui;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Taal
{
	private Locale locale;
	private static ResourceBundle r;
	private String taal;
	
	public Taal()
	{
		setTaal(kiesTaal());
		
		if("NL".equals(taal))
		{
			this.locale = new Locale("NL");	
		}
		else
		{
			if("EN".equals(taal))
			{
				this.locale = new Locale("EN");
			}
			else
			{
				if ("FR".equals(taal))
				{
					this.locale = new Locale("FR");
				}
			}
		}
		r = ResourceBundle.getBundle("sokoban",locale);	
	}
	
	public String kiesTaal()
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
				    throw new IllegalArgumentException("Verkeerde input/ Wrong input/ Entr�e incorrecte");
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
		return taalString;
    }
	
	public static String getText(String text)
	{
		return r.getString(text);
	}
	
	public void setTaal(String gekozenTaal)
	{
		this.taal = gekozenTaal;
	}
	public String getTaal()
	{
		return taal;
	}
}