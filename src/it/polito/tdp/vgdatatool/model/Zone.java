package it.polito.tdp.vgdatatool.model;

public class Zone implements Comparable<Zone>{
	
	private String name;
	private double avgSales;
	private double avgRatings;
	private double index;
	
	public Zone(String name, double avgSales, double avgRatings) {
		this.name = name;
		this.avgSales = avgSales;
		this.avgRatings = avgRatings;
	}

	//Getters and Setters
	public String getName() {
		return name;
	}
	
	public void setAvgSales(double avgSales) {
		this.avgSales =this.avgSales+avgSales;
	}

	public void setAvgRatings(double avgRatings) {
		this.avgRatings =this.avgRatings+avgRatings;
	}

	public double getAvgSales() {
		return avgSales;
	}

	public double getAvgRatings() {
		return avgRatings;
	}
	
	public double getIndex() {
		return index;
	}

	public void setIndex(double index) {
		this.index = index;
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
		Zone other = (Zone) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	public String toString() {
		return name + " - Avg Sales: "+(float)avgSales+" Avg Ratings: "+(float)avgRatings+" INDEX: "+(float)index;
	}

	@Override
	public int compareTo(Zone o) {
		return (int) (this.index-o.getIndex());
	}
}
