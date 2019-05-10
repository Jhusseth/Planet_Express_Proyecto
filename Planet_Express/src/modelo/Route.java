package modelo;

public class Route {
	
	private Location start_location;
	private Location final_location;
	private int travel;
	
	
	public Route(Location start_location, Location final_location, int travel, long time) {
		
		this.start_location = start_location;
		this.final_location = final_location;
		this.travel = travel;
		this.time = time;
	}
	
	public Location getStart_location() {
		return start_location;
	}
	public void setStart_location(Location start_location) {
		this.start_location = start_location;
	}
	public Location getFinal_location() {
		return final_location;
	}
	public void setFinal_location(Location final_location) {
		this.final_location = final_location;
	}
	public int getTravel() {
		return travel;
	}
	public void setTravel(int travel) {
		this.travel = travel;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	private long time;
	
}
