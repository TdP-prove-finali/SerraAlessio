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
				Genre g = new Genre(rs.getString("gen"), rs.getDouble("price"));
				result.add(g);
			}

			conn.close();
			return result;

		} catch (SQLException e) {
			throw new RuntimeException("Errore Db",e);
		}
	}
	
}
