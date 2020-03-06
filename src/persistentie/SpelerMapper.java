package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domein.Speler;

public class SpelerMapper
{
	private static final String INSERT_SPELER = "INSERT INTO ID222177_g39.Speler (naam, voornaam, wachtwoord, beheerder, gebruikersnaam)"
            + "VALUES (?, ?, ?, ?, ?)";

	public Speler geefSpeler(String gebruikersnaam)
	{
		
		return null;
	}

	public void voegToe(Speler speler)
	{
		 try (
	                Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
	                PreparedStatement query = conn.prepareStatement(INSERT_SPELER)) {
	            query.setString(1, speler.getNaam());
	            query.setString(2, speler.getVoornaam());
	            query.setString(3, speler.getWachtwoord());
	            query.setBoolean(4, speler.isAdminrechten());
	            query.setString(5, speler.getGebruikersnaam());
	            query.executeUpdate();

	        } catch (SQLException ex) {
	            throw new RuntimeException(ex);
	        }
	}
	
	public List<Speler> geefSpelers() {
        List<Speler> spelers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_dobbel.speler");
                ResultSet rs = query.executeQuery()) {

            while (rs.next()) {
                String naam = rs.getString("naam");
                String voornaam = rs.getString("voornaam");
                String wachtwoord = rs.getString("wachtwoord");
                String gebruikersnaam = rs.getNString("gebruikersnaam");
                boolean beheerder = rs.getBoolean("beheerder");
                
                spelers.add(new Speler(gebruikersnaam, wachtwoord, beheerder,  naam, voornaam));
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

        return spelers;
    }
	
	

}