package it.polito.tdp.vgdatatool.model;

public class Genre {
	
	private String name;
	private double price;
	private double avgSales;
	
	//Constructor
	public Genre(String name, double price,double avgSales) {

		this.name = name;
		this.price = price;
		this.avgSales = avgSales;
	}

	//Getters
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}	
	public double getAvgSales() {
		return avgSales;
	}
	public String toString() {
		return name;
	}
	
}
