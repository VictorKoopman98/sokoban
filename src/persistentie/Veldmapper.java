package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import domein.Veld;

public class Veldmapper
{
	private static final String INSERT_VELDEN = "INSERT INTO ID222177_g39.Veld (naamSpel, volgnummer, x, y, isDoel, isMuur, isMan, isKist) VALUES(?,?,?,?,?,?,?,?)";
	 // Methode om de velden die bij een spelbord horen uit de databank te kunnen halen
     //volgnummer unieke identiteit van het spelbord waartoe de velden behoren
//	public static void main(String[] args) {
//		Veld[][] velden = geefVelden(1, "DEMO");
//		
//	}
	
	
     
	public static Veld[][] geefVelden(int volgnummer, String spelnaam) 
	{
        Veld[][] velden = new Veld[10][10];
        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
        		PreparedStatement query = conn.prepareStatement("SELECT * FROM ID222177_g39.Veld WHERE (naamSpel = ? AND volgnummer = ?)"))
        {
            
            query.setString(1, spelnaam);
            query.setInt(2, volgnummer);
            try (ResultSet rs = query.executeQuery()) {
                while (rs.next()) {
                    

            
            		int x = rs.getInt("x");
                    int y = rs.getInt("y");
                    boolean isDoel = rs.getBoolean("isMuur");
                    boolean isMuur = rs.getBoolean("isDoel");
                    boolean isMan = rs.getBoolean("isMan");
                    boolean isKist = rs.getBoolean("isKist");
                    velden[x][y] = new Veld(x, y, isMuur, isDoel, isMan, isKist);
            	
            
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return velden;
    }
	
	

//    void deleteVelden(int volgnummer) {
//        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
//            PreparedStatement query = conn.prepareStatement("DELETE FROM veld WHERE Spelbord_spelBordId = ?");
//            query.setInt(1, volgnummer);
//            query.executeUpdate();
//        } catch (SQLException ex) {
//            throw new RuntimeException(ex);
//        }
//    }

    
    
    
    
    /**
     * Methode om de velden van een bepaald spelbord dat bij een bepaald spel hoort up te daten nadat
     * er een wijziging is aangebracht
     * @param velden de velden die moeten upgedate worden
     * @param spelId unieke identiteit van het spel waartoe deze velden behoren
     * @param spelbordId unieke identiteit van het spelbord waartoe deze velden behoren
     */
//    public void updateVelden(Veld[][] velden, int spelId, int spelbordId) {
//        String[][] str = new String[10][10];
//
//        for (int i = 0; i < velden.length; i++) {
//            for (int j = 0; j < velden[i].length; j++) {
//                if (velden[i][j].isMuur) {
//                    str[i][j] = "Muur";
//                } else if (velden[i][j].isDoel() == true) {
//                    str[i][j] = "DoelVeld";
//                } else if (velden[i][j] == null) {
//                    str[i][j] = "Muur";
//                } else if (velden[i][j].getKist() != null) {
//                    str[i][j] = "Kist";
//                } else if (velden[i][j].getMan() != null) {
//
//                    str[i][j] = "Man";
//                } else {
//                    str[i][j] = "LeegVeld";
//                }
//            }
//        }
//        try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL)) {
//            PreparedStatement query = conn.prepareStatement("UPDATE veld SET soortVeld = ? WHERE Spelbord_Spel_spelId = ? AND Spelbord_spelBordId = ? AND x = ? AND y = ?");
//
//            for (int i = 0; i < str.length; i++) {
//                for (int j = 0; j < str[i].length; j++) {
//                    query.setInt(2, spelId);
//                    query.setInt(3, spelbordId);
//                    query.setInt(4, i);
//                    query.setInt(5, j);
//                    query.setString(1, str[i][j]);
//                    query.executeUpdate();
//                }
//            }
//        } catch (SQLException ex) 
//        {
//            throw new RuntimeException(ex);
//        }
//    }
	
	
	
	 public void updateVelden(char[][] velden, int volgnummer, String spelnaam) 
	    {
	            try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
	            		PreparedStatement query = conn.prepareStatement("UPDATE ID222177_g39.Veld SET isDoel = ?, isMuur = ?, isMan = ?, isKist = ? WHERE (naamSpel = ? AND volgnummer = ? AND x = ? AND y = ?)")) {
	            
	                   
	            for (int i = 0; i < velden.length; i++) {
	                for (int j = 0; j < velden[i].length; j++) {
	                	boolean isDoel = false;
	                	boolean isMuur = false;
	                	boolean isMan = false;
	                	boolean isKist = false;
	                    if (velden[i][j] == 'M') {
	                        isMuur = true;
	                    } else if (velden[i][j] == 'D') {
	                        isDoel = true;
	                    } else if (velden[i][j] == 'X') {
	                        isMan = true;
	                    } else if (velden[i][j] == 'K') {
	                        isKist = true;
	                    }  
	                    
	                    query.setBoolean(1, isDoel);
	                    query.setBoolean(2, isMuur);
	                    query.setBoolean(3, isMan);
	                    query.setBoolean(4, isKist);
	                    query.setString(5, spelnaam);
	                    query.setInt(6, volgnummer);
	                    query.setInt(7, i);
	                    query.setInt(8, j);
	                    query.executeUpdate(); 
	                }
	            }
	            
	        } catch (SQLException ex) {
	            throw new RuntimeException(ex);
	        }
	    }

    //Methode om velden in de databank toe te voegen die horen bij een spelbord
    //velden object van de klasse Veld
    //spelnaam unieke identiteit van het spel waarbij de velden wordentoegevoegd
    //volgnummer unieke identiteit van het spelbord waarbij de veldenworden toegevoegd
    
    public void voegVeldenToe(char[][] velden, int volgnummer, String spelnaam) 
    {
            try (Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
            		PreparedStatement query = conn.prepareStatement(INSERT_VELDEN)) {
            
                   
            for (int i = 0; i < velden.length; i++) {
                for (int j = 0; j < velden[i].length; j++) {
                	boolean isDoel = false;
                	boolean isMuur = false;
                	boolean isMan = false;
                	boolean isKist = false;
                    if (velden[i][j] == 'M') {
                        isMuur = true;
                    } else if (velden[i][j] == 'D') {
                        isDoel = true;
                    } else if (velden[i][j] == 'X') {
                        isMan = true;
                    } else if (velden[i][j] == 'K') {
                        isKist = true;
                    }  
                    query.setString(1, spelnaam);
                    query.setInt(2, volgnummer);
                    query.setInt(3, i);
                    query.setInt(4, j);
                    query.setBoolean(5, isDoel);
                    query.setBoolean(6, isMuur);
                    query.setBoolean(7, isMan);
                    query.setBoolean(8, isKist);
                    query.executeUpdate(); 
                }
            }
            
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}