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
			na.sumSales(v.getNA_sales());
			na.sumRatings(v.getCriticR()/10 + v.getUserR());
			//EU
			eu.sumSales(v.getEU_sales());
			eu.sumRatings(v.getCriticR()/10 + v.getUserR());
			//JP
			jp.sumSales(v.getJP_sales());
			jp.sumRatings(v.getCriticR()/10 + v.getUserR());
			//ROW
			row.sumSales(v.getOTHER_sales());
			row.sumRatings(v.getCriticR()/10 + v.getUserR());	
		}
		
		//Calculating index
		na.setAvgSales(na.getAvgSales()/videogames.size());
		na.setAvgRatings(na.getAvgRatings()/(videogames.size()*2));
		double NAindex = na.getAvgSales()*weightS + na.getAvgRatings()*weightR;
		na.setIndex(NAindex);
		
		eu.setAvgSales(eu.getAvgSales()/videogames.size());
		eu.setAvgRatings(eu.getAvgRatings()/(videogames.size()*2));
		double EUindex = eu.getAvgSales()*weightS + eu.getAvgRatings()*weightR;
		eu.setIndex(EUindex);
		
		jp.setAvgSales(jp.getAvgSales()/videogames.size());
		jp.setAvgRatings(jp.getAvgRatings()/(videogames.size()*2));
		double JPindex = jp.getAvgSales()*weightS + jp.getAvgRatings()*weightR;
		jp.setIndex(JPindex);
		
		row.setAvgSales(row.getAvgSales()/videogames.size());
		row.setAvgRatings(row.getAvgRatings()/(videogames.size()*2));
		double ROWindex = row.getAvgSales()*weightS + row.getAvgRatings()*weightR;
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
