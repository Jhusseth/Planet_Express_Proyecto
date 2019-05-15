package modelo;

public class Airport {
	
	private int clientId;
	private String name;
	private boolean registered;
	private int accumulated;
	private Airport predecessor;
	private boolean label;

	public Airport(String name){
		this.clientId=-1;
		this.registered = false;
		this.accumulated = 0;
		this.predecessor = null;
		this.name = name;
		this.label = false;
		
	}

	public void setRegistered(boolean b) {
		this.registered = b;
		
	}

	public void setClient(int permanent) {
		this.clientId = permanent;
		
	}

	public void setLabel(boolean b) {
		this.label = b;
		
	}

	public boolean isRegistered() {
		
		return registered;
	}

	public boolean isLabel() {
		return label;
	}

	public void setPredeccesor(Airport flight) {
		this.predecessor =  flight;
		
	}

	public void setAccumulated(int subAccumulated) {
		this.accumulated = subAccumulated;
		
	}

	public int getClient() {
		return clientId;
	}

	public Airport getPredeccesor() {
		return predecessor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getAccumulated(){
		return accumulated;
	}
	
	
}
