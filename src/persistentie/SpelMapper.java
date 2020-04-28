package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domein.Spel;
import gui.Taal;

public class SpelMapper
{
	private static Taal taalObj;
	private static final String INSERT_SPEL = "INSERT INTO ID222177_g39.Spel (naamSpel)"
            + "VALUES (?)";
	SpelbordMapper sbm = new SpelbordMapper();

    //Methode om een spel met een bepaald spelnaam uit de databank te halen
    //spelnaam unieke identiteit van het spel dat uit de databank wordt gehaald
     
    public Spel geefSpel(String spelnaam)
    { 
		Spel spel = null;
	
		try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL); 
				PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g39.Spel WHERE naamSpel = ?"))
		{
		    query.setString(1, spelnaam);
		    try (ResultSet rs = query.executeQuery())
		    {
			if (rs.next())
			{
			    //String naam = rs.getString("spelnaam");
	                    //List<Spelbord> spelborden = sbm.geefSpelborden(spelId);
			    spel = new Spel(spelnaam);
			}
		    }
		} catch (SQLException ex)
		{
		    throw new RuntimeException(ex);
		}
	
		return spel;
    }

   
    public static List<String> geefSpellen() // Methode om een lijst van spellen uit de databank te halen
    {
		List<String> spelnamen = new ArrayList<>();
	
		try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
				PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g39.Spel"))
		{
		    
		    try (ResultSet rs = query.executeQuery())
		    {
				while (rs.next())
				{
		                    
				    String naam = rs.getString("naamSpel");
		            //List<Spelbord> spelborden = sbm.geefSpelborden(spelId);
				    spelnamen.add(naam);
				}
		    }
		} 
		catch (SQLException ex)
		{
		    throw new RuntimeException(ex);
		}
	
		return spelnamen;

    }


    public void voegSpelToe(Spel spel)   //Methode om het spel op te slaan in de databank
    {
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
        		PreparedStatement query = conn.prepareStatement(INSERT_SPEL))
        {            
            query.setString(1, spel.getNaamSpel());
            query.executeUpdate();
        } catch (SQLException ex)
        {
            throw new RuntimeException(ex);
        }
    }

}