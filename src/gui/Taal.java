package gui;

import java.util.Locale;
import java.util.ResourceBundle;

public class Taal
{
	private Locale locale;
	public static ResourceBundle resourceBundle;
	private String taal;
	
	public Taal(String taal)
	{
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
		resourceBundle = ResourceBundle.getBundle("sokoban",locale);
		
		this.setTaal(taal);
	}
	public String getText(String text)
	{
		return resourceBundle.getString(text);
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