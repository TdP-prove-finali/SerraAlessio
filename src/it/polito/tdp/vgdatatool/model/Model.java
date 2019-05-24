package it.polito.tdp.vgdatatool.model;

import java.util.List;

import it.polito.tdp.vgdatatool.db.VideogameDAO;

public class Model {
	
	public List<Genre> getAllGenres(){
		VideogameDAO dao = new VideogameDAO();
		return dao.getAllGenres();
	}

}
