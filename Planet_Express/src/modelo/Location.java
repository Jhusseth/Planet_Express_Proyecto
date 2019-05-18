package modelo;

public class Location {
	
	private String id;	
	private Airport airport;
	
	public Location(String id, Airport a) {
		this.id = id;
		this.airport=a;
	}

	public Airport getAirport() {
		return airport;
	}

	public void setAirport(Airport air) {
		this.airport = air;
	}	

	public String getName() {
		return id;
	}

	public void setName(String id) {
		this.id = id;
	}
	
	
}
