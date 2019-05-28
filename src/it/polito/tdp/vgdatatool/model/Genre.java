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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Genre other = (Genre) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
