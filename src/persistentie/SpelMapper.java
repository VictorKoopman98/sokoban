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
	
	
	public SpelMapper(Taal taalObj)
	{
		this.taalObj = taalObj;
	}
	
	
	
	SpelbordMapper sbm = new SpelbordMapper(taalObj);

	

	
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
			    spel = new Spel(spelnaam,taalObj);
			}
		    }
		} catch (SQLException ex)
		{
		    throw new RuntimeException(ex);
		}
	
		return spel;
    }

   
    public static List<Spel> geefSpellen() // Methode om een lijst van spellen uit de databank te halen
    {
		List<Spel> spel = new ArrayList<>();
	
		try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
				PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g39.Spel"))
		{
		    
		    try (ResultSet rs = query.executeQuery())
		    {
				while (rs.next())
				{
		                    
				    String naam = rs.getString("naamSpel");
		            //List<Spelbord> spelborden = sbm.geefSpelborden(spelId);
				    spel.add(new Spel(naam,taalObj));
				}
		    }
		} 
		catch (SQLException ex)
		{
		    throw new RuntimeException(ex);
		}
	
		return spel;

    }

//    /**
//     * Methode om een bepaald spelbord te verwijderen uit de databank
//     * @param spelbordId unieke identiteit van het spelbord dat aantoont welk spelbord verwijderd zal worden
//     */
//    public void verwijderSpelbord(int spelbordId) {
//        sbm.verwijderSpelbord(spelbordId);
//    }
//
//    /**
//     * Methode om een spelbord uit de databank te halen 
//     * @param spelId unieke identiteit van het spel waartoe het spelbord behoort
//     * @param spelbordId unieke identiteit van het spelbord dat uit de databank gehaald zal worden
//     * @return geeft een spelbord terug
//     */
//    public Spelbord geefSpelbord(int spelId, int spelbordId) {
//        return sbm.geefSpelbord(spelId, spelbordId);
//    }


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
//        List<Spelbord> spelborden = spel.getSpelborden();
//        for (Spelbord spelborden1 : spelborden) {
//            sbm.bewaarSpelbord(spelborden1,spel.getSpelId());
//        }
    }
//
//    /**
//     * Methode om het spelbord up te daten wanneer er een wijziging aan toegebracht is
//     * @param spel object van de klasse Spel dat zal upgedate worden
//     */
////    public void updateSpelbord(Spel spel) {
////    sbm.updateSpelbord(spel.getSpelId(),spel.getSpelbord());
////    }
//    
//    /**
//     * Methode om de spelborden die bij een bepaald spel horen terug te geven 
//     * @param spelId unieke identiteit van het spel waarvan de spelborden moeten teruggegeven worden
//     * @return geeft een lijst van spelborden terug 
//     */
//    public List<Spelbord> geefSpelborden(int spelId){
//        return sbm.geefSpelborden(spelId);
//    }
//	
}