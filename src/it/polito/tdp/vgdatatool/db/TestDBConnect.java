package it.polito.tdp.vgdatatool.db;

import java.util.List;
import it.polito.tdp.vgdatatool.model.Genre;

public class TestDBConnect {

	//Test Connection
	public static void main(String[] args) {

		VideogameDAO dao = new VideogameDAO();
		List<Genre> list = dao.getAllGenres();
		
		if (list.size()>0) System.out.println("Test PASSED");
		else System.out.println("Test FAILED");
	}

}
