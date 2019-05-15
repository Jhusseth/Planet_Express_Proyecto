package modelo;

public class Location {
	
	private int id;
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Airport air;
	
	public Location(String name, int id, Airport a) {
		
		this.id = id;
		this.air=a;
	}

	public Airport getAir() {
		return air;
	}

	public void setAir(Airport air) {
		this.air = air;
	}	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
