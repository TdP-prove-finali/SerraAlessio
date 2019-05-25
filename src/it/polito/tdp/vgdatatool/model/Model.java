package it.polito.tdp.vgdatatool.model;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import it.polito.tdp.vgdatatool.db.VideogameDAO;

public class Model {
	
	public List<Genre> getAllGenres(){
		VideogameDAO dao = new VideogameDAO();
		return dao.getAllGenres();
	}
	
	public List<Zone> getBestZone(Genre g,int year, double preferences){
		
		VideogameDAO dao = new VideogameDAO();
		List<Zone> result = new ArrayList<>();
		
		//Get all videogames of that genre and following that year
		List<Videogame> videogames = dao.getVideogames(g, year);
		
		//Set the weight about ratings and sales
		double weightR = preferences;
		double weightS = 1-preferences;
		
		//Create different zones
		Zone na = new Zone("North America",0.0,0.0);
		Zone eu = new Zone("Europe",0.0,0.0);
		Zone jp = new Zone("Japan",0.0,0.0);
		Zone row = new Zone("Rest Of World",0.0,0.0);
		
		//Get datas for index
		for ( Videogame v : videogames) {
			//NA
			na.setAvgSales(v.getNA_sales());
			na.setAvgRatings(v.getCriticR()/10 + v.getUserR());
			//EU
			eu.setAvgSales(v.getEU_sales());
			eu.setAvgRatings(v.getCriticR()/10 + v.getUserR());
			//JP
			jp.setAvgSales(v.getJP_sales());
			jp.setAvgRatings(v.getCriticR()/10 + v.getUserR());
			//ROW
			row.setAvgSales(v.getOTHER_sales());
			row.setAvgRatings(v.getCriticR()/10 + v.getUserR());	
		}
		
		//Calculating index
		double NAindex = ((na.getAvgSales()/videogames.size())*weightS) + ((na.getAvgRatings()/(videogames.size()*2))*weightR);
		na.setIndex(NAindex);
		double EUindex = ((eu.getAvgSales()/videogames.size())*weightS) + ((eu.getAvgRatings()/(videogames.size()*2))*weightR);
		eu.setIndex(EUindex);
		double JPindex = ((jp.getAvgSales()/videogames.size())*weightS) + ((jp.getAvgRatings()/(videogames.size()*2))*weightR);
		jp.setIndex(JPindex);
		double ROWindex = ((row.getAvgSales()/videogames.size())*weightS) + ((row.getAvgRatings()/(videogames.size()*2))*weightR);
		row.setIndex(ROWindex);
		
		result.add(na);
		result.add(eu);
		result.add(jp);
		result.add(row);
		
		//Order for the index
		for (int i=0;i<result.size()-1;i++) {
			if (result.get(i).getIndex()<result.get(i+1).getIndex()) {
				Zone zone = result.get(i);
				result.set(i, result.get(i+1));
				result.set(i+1, zone);
			}
		}
		
		return result;
	}

}
