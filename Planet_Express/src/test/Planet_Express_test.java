package test;
import static org.junit.Assert.*;
import org.junit.Test;

import com.sun.javafx.geom.Edge;

import graph.Graph;
import modelo.Airport;
import modelo.Location;
import modelo.Planet_Express;

public class Planet_Express_test {
	private Planet_Express graph;
	
	public void stage(){
		graph = new Planet_Express();
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
		
		graph.addClient(l1);
		graph.addClient(l2);
		graph.addClient(l3);
		graph.addClient(l4);
		graph.addClient(l5);
		
		boolean delete_l1 = graph.deleteClients(l1);
		
		assertEquals(true, delete_l1);
		assertEquals(4,graph.QVertex());
		
		boolean delete_l6 = graph.deleteClients(l6);
		
		assertEquals(4,graph.QVertex());
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
		
		graph.addClient(l1);
		graph.addClient(l2);
		graph.addClient(l3);
		graph.addClient(l4);
		graph.addClient(l5);
		
		graph.addFlight(l1, l3, 10);
		graph.addFlight(l2, l3, 11);
		graph.addFlight(l4, l2, 12);
		graph.addFlight(l5, l4, 13);
		
		
		boolean delete_l1l3 = graph.deleteFlight(graph.getGraph().getEdges().get(graph.getGraph().searchEdgeIndice(10)));
		assertEquals(true, delete_l1l3);
		
		assertEquals(3,graph.QEdges());
		
		boolean delete_l5l2 = graph.deleteFlight(new graph.Edge<Location>(l2, l5, 14));
		assertEquals(false, delete_l5l2);
		assertEquals(3,graph.QEdges());
	}
	
	@Test
	public void scenethree(){
		stage();
		
		Airport ae = new Airport("Cali");
		Location l1 = new Location("001", ae);
		
		Airport ae2 = new Airport("Paris");
		Location l2 = new Location("002", ae2);
		
		Airport ae3 = new Airport("China");
		Location l3 = new Location("003", ae3);
		
		Airport ae4 = new Airport("Argentina");
		Location l4 = new Location("006", ae4);
		
		graph.addClient(l1);
		graph.addClient(l2);
		graph.addClient(l3);
		
		assertTrue(!graph.getGraph().getNodes().contains(l3));
		assertNull(graph.getGraph().getNodes().get(l4));
		
	}
	@Test
	public void sceneFour(){
		stage();
	}
	@Test
	public void sceneFive(){
		stage();
		
		Airport ae = new Airport("Chile");
		Location l1 = new Location("001", ae);
		
		Airport ae2 = new Airport("Francia");
		Location l2 = new Location("002", ae2);
		
		Airport ae3 = new Airport("Congo");
		Location l3 = new Location("003", ae3);
		
		Airport ae4 = new Airport("Dinamarca");
		Location l4 = new Location("004", ae4);
		
		Airport ae5 = new Airport("Inglaterra");
		Location l5 = new Location("005", ae5);
		
		Airport ae6 = new Airport("China");
		Location l6 = new Location("006", ae6);
		
		Airport ae7 = new Airport("Peru");
		Location l7 = new Location("007", ae7);
		
		graph.addClient(l1);
		graph.addClient(l2);
		graph.addClient(l3);
		graph.addClient(l4);
		graph.addClient(l5);
		graph.addClient(l6);
		
		graph.addFlight(l6, l2, 10);
		graph.addFlight(l1, l5, 11);
		graph.addFlight(l4, l2, 12);
		
		assertEquals(3,graph.QEdges());
		
		graph.addFlight(l3, l5, 13);
		
		assertEquals(4,graph.QEdges());
		
		
	}
	@Test
	public void sceneSix(){
		stage();
		
		Airport ae = new Airport("Argentina");
		Location l1 = new Location("001", ae);
		
		Airport ae2 = new Airport("Venecia");
		Location l2 = new Location("002", ae2);
		
		Airport ae3 = new Airport("China");
		Location l3 = new Location("003", ae3);
		
		Airport ae4 = new Airport("Mexico");
		Location l4 = new Location("004", ae4);
		
		Airport ae5 = new Airport("Canada");
		Location l5 = new Location("005", ae5);
		
		Airport ae6 = new Airport("Egipto");
		Location l6 = new Location("006", ae6);
		
		graph.addClient(l1);
		graph.addClient(l2);
		graph.addClient(l3);
		graph.addClient(l4);
		graph.addClient(l5);
		
		assertEquals(5,graph.QVertex());
		
	}
}
