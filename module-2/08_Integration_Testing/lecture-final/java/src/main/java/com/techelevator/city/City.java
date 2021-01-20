package com.techelevator.city;

public class City {
	private Long id;
	private String name;
	private String countryCode;
	private String district;
	private int population;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getPopulation() {
		return population;
	}

	public void setPopulation(int population) {
		this.population = population;
	}
	
	
	// this is a BONUS 
	// please ignore this if you're confused 
	
	@Override
	public boolean equals(Object o) {
		if(o == null) {
			return false;
		}
		
		if(!o.getClass().equals(this.getClass())){
			return false;
		}
		
		City other = (City)o;
		
		return this.getId() == other.getId() &&
			this.getCountryCode().equals(other.getCountryCode()) &&
			this.getDistrict().equals(other.getDistrict()) &&
            this.getName().equals(other.getName()) &&
            this.getPopulation() == other.getPopulation();
	}
}
