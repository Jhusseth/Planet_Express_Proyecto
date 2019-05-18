package test;
import static org.junit.Assert.*;
import org.junit.Test;

import com.sun.javafx.geom.Edge;

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
		
		Airport ae6 = new Airport("Argentina");
		Location l6 = new Location("006", ae6);
		
		graph.addVertex(l1);
		graph.addVertex(l2);
		graph.addVertex(l3);
		graph.addVertex(l4);
		graph.addVertex(l5);
		
		boolean delete_l1 = graph.deleteVertex(l1);
		
		assertEquals(true, delete_l1);
		assertEquals(4,graph.getQuantity());
		
		boolean delete_l6 = graph.deleteVertex(l6);
		
		assertEquals(4,graph.getQuantity());
		assertEquals(false, delete_l6);
		
	}
	
	@Test
	public void sceneTwo(){
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
		
		Airport ae6 = new Airport("Argentina");
		Location l6 = new Location("006", ae6);
		
		graph.addVertex(l1);
		graph.addVertex(l2);
		graph.addVertex(l3);
		graph.addVertex(l4);
		graph.addVertex(l5);
		
		graph.addEdge(l1, l3, 10);
		graph.addEdge(l2, l3, 11);
		graph.addEdge(l4, l2, 12);
		graph.addEdge(l5, l4, 13);
		
		
		boolean delete_l1l3 = graph.deleteEdge(graph.getEdges().get(graph.searchEdgeIndice(10)));
		assertEquals(true, delete_l1l3);
		
		assertEquals(3,graph.getEdges().size());
		
		boolean delete_l5l2 = graph.deleteEdge(new graph.Edge<Location>(l2, l5, 14));
		assertEquals(false, delete_l5l2);
		assertEquals(3,graph.getEdges().size());
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
