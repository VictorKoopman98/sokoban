package gui;

import java.util.Locale;
import java.util.ResourceBundle;

public class Taal
{
	private Locale locale;
	private static ResourceBundle r;
	private String taal;
	
	public Taal(String taal)
	{
		this.setTaal(taal);
		
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