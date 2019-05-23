package it.polito.tdp.vgdatatool.model;

public class Videogame {
	
	//VGData
	private String name;
	private String platform;
	private int yearRelease;
	private String genre;
	private String publisher;
	
	//SalesData
	private double NA_sales;
	private double EU_sales;
	private double JP_sales;
	private double OTHER_sales;
	private double GLOBAL_sales;
	
	//RatingsData
	private int criticR;
	private double userR;
	
	//Constructor
	public Videogame(String name, String platform, int yearRelease, String genre, String publisher, double nA_sales,
			double eU_sales, double jP_sales, double oTHER_sales, double gLOBAL_sales, int criticR, double userR) {

		this.name = name;
		this.platform = platform;
		this.yearRelease = yearRelease;
		this.genre = genre;
		this.publisher = publisher;
		NA_sales = nA_sales;
		EU_sales = eU_sales;
		JP_sales = jP_sales;
		OTHER_sales = oTHER_sales;
		GLOBAL_sales = gLOBAL_sales;
		this.criticR = criticR;
		this.userR = userR;
	}

	//Getters
	public String getName() {
		return name;
	}
	public String getPlatform() {
		return platform;
	}
	public int getYearRelease() {
		return yearRelease;
	}
	public String getGenre() {
		return genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public double getNA_sales() {
		return NA_sales;
	}
	public double getEU_sales() {
		return EU_sales;
	}
	public double getJP_sales() {
		return JP_sales;
	}
	public double getOTHER_sales() {
		return OTHER_sales;
	}
	public double getGLOBAL_sales() {
		return GLOBAL_sales;
	}
	public int getCriticR() {
		return criticR;
	}
	public double getUserR() {
		return userR;
	}
	
	//Hashcode based on name and platform
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((platform == null) ? 0 : platform.hashCode());
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
		Videogame other = (Videogame) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (platform == null) {
			if (other.platform != null)
				return false;
		} else if (!platform.equals(other.platform))
			return false;
		return true;
	}
	
	public String toString() {
		return name+" ("+platform+") - "+genre+" - Global Sales: "+GLOBAL_sales;
	}

}
