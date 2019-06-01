package it.polito.tdp.vgdatatool.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import it.polito.tdp.vgdatatool.model.*;


public class VideogameDAO {

	public List<Genre> getAllGenres() {

		final String sql = "SELECT DISTINCT Genre AS gen, PriceForUnit AS price FROM genreprice";
        List<Genre> result = new ArrayList<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Genre g = new Genre(rs.getString("gen"), rs.getDouble("price"),0.0);
				result.add(g);
			}

			conn.close();
			return result;

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db",e);
		}
	}
	
	public List<Videogame> getVideogames(Genre genre,int year){
		
		final String sql = "SELECT * FROM DATA WHERE Genre=? AND Year_Release>?";
        List<Videogame> result = new ArrayList<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			//Set data
			st.setString(1,genre.getName());
			st.setObject(2, year);
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				
				String name = rs.getString("Name");
				String platform = rs.getString("Platform");
			    int yearRelease = rs.getInt("Year_Release");
			    String genres = rs.getString("Genre");
			    String publisher= rs.getString("Publisher");
			    double nA_sales = rs.getDouble("NA_Sales");
			    double eU_sales = rs.getDouble("EU_Sales");
			    double jP_sales = rs.getDouble("JP_Sales");
			    double oTHER_sales = rs.getDouble("OTHER_Sales");
			    double gLOBAL_sales = rs.getDouble("GLOBAL_Sales");
			    int criticR = rs.getInt("CRITIC_Ratings");
			    double userR = rs.getDouble("USER_Ratings");
				
				Videogame v = new Videogame(name, platform, yearRelease, genres, publisher, nA_sales, eU_sales, jP_sales, 
						                     oTHER_sales, gLOBAL_sales, criticR, userR);
				result.add(v);
			}

			conn.close();
			return result;

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db",e);
		}
	}
	
	public List<Genre> getGenresRecursion(int year, String zone){
		
		 String string = "";
		
		//Choice of comboBox
		if (zone.compareTo( "North America" )==0) string= "SELECT DISTINCT d.Genre AS genere, AVG(NA_Sales) AS sales, g.PriceForUnit AS price FROM DATA d, genreprice g WHERE Year_Release>=? AND d.Genre=g.Genre GROUP BY d.Genre";
		if (zone.compareTo( "Europe" )==0 ) string="SELECT DISTINCT d.Genre AS genere, AVG(EU_Sales) AS sales, g.PriceForUnit AS price FROM DATA d, genreprice g WHERE Year_Release>=? AND d.Genre=g.Genre GROUP BY d.Genre";
		if (zone.compareTo( "Japan" )==0 ) string="SELECT DISTINCT d.Genre AS genere, AVG(JP_Sales) AS sales, g.PriceForUnit AS price FROM DATA d, genreprice g WHERE Year_Release>=? AND d.Genre=g.Genre GROUP BY d.Genre";
		if (zone.compareTo( "Rest of World" )==0) string="SELECT DISTINCT d.Genre AS genere, AVG(OTHER_Sales) AS sales, g.PriceForUnit AS price FROM DATA d, genreprice g WHERE Year_Release>=? AND d.Genre=g.Genre GROUP BY d.Genre";
		if (zone.compareTo( "All" )==0) string="SELECT DISTINCT d.Genre AS genere, AVG(GLOBAL_Sales) AS sales, g.PriceForUnit AS price FROM DATA d, genreprice g WHERE Year_Release>=? AND d.Genre=g.Genre GROUP BY d.Genre";
		
		//Final String for query
		final String sql = string;
		
        List<Genre> result = new ArrayList<>();
		
		try {
			Connection conn = DBConnect.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			
			//Set parameter
			st.setInt(1, year);
			
			
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Genre g = new Genre(rs.getString("genere"), rs.getDouble("price"), rs.getDouble("sales"));
				
				if (g.getAvgSales()>0) result.add(g);
			}

			conn.close();
			return result;

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db",e);
		}
	}
	
}
