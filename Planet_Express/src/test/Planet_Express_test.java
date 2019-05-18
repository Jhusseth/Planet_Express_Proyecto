package test;
import static org.junit.Assert.*;
import org.junit.Test;

import graph.Graph;
import modelo.Airport;
import modelo.Location;
import modelo.Planet_Express;

public class Planet_Express_test {
	
	private Graph<Location> graph;
	private Planet_Express planet;
	
	public void stage(){
		graph = new Graph<>(false);
		planet = new Planet_Express();
	}
	
	@Test
	public void sceneOne(){
		stage();
		Airport ae = new Airport("Cali");
		Location l1 = new Location("001", ae);
		
		Airport ae2 = new Airport("Paris");
		Location l2 = new Location("002", ae2);
		
		Airport ae3 = new Airport("China");
		Location l3 = new Location("003", ae3);
		
		Airport ae4 = new Airport("Francia");
		Location l4 = new Location("004", ae4);
		
		Airport ae5 = new Airport("Reino_Unido");
		Location l5 = new Location("005", ae5);
		
		graph.addVertex(l1);
		graph.addVertex(l2);
		graph.addVertex(l3);
		graph.addVertex(l4);
		graph.addVertex(l5);
		
		graph.deleteVertex(l1);
		
		assertEquals(4,graph.getQuantity());
		
	}
	
	@Test
	public void sceneTwo(){
		stage();
	}
	
	@Test
	public void scenethree(){
		stage();
	}
	@Test
	public void sceneFour(){
		stage();
	}
	@Test
	public void sceneFive(){
		stage();
	}
	@Test
	public void sceneSix(){
		stage();
	}
	@Test
	public void sceneSeven(){
		stage();
	}

}
