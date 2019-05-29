package test;
import static org.junit.Assert.*;
import org.junit.Test;

import com.sun.javafx.geom.Edge;

import graph.Graph;
import graph.Node;
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
		
		graph.addClient(1);
		graph.addClient(2);
		graph.addClient(3);
		graph.addClient(4);
		graph.addClient(5);
		
		boolean delete_l1 = graph.deleteClients(1);
		
		assertEquals(true, delete_l1);
		assertEquals(4,graph.QVertex());
		
		boolean delete_l6 = graph.deleteClients(6);
		
		assertEquals(4,graph.QVertex());
		assertEquals(false, delete_l6);
		
	}
	
	@Test
	public void sceneTwo(){
		stage();
		
		graph.addClient(1);
		graph.addClient(2);
		graph.addClient(3);
		graph.addClient(4);
		graph.addClient(5);
		
		graph.addFlight(1, 3, 10);
		graph.addFlight(2, 3, 11);
		graph.addFlight(4, 2, 12);
		graph.addFlight(5, 4, 13);
		
		
		boolean delete_l1l3 = graph.deleteFlight(graph.getGraph().getEdges().get(graph.getGraph().searchEdgeIndice(10)));
		assertEquals(true, delete_l1l3);
		
		assertEquals(3,graph.QEdges());
		
		boolean delete_l5l2 = graph.deleteFlight(new graph.Edge<Integer>(2, 5, 14));
		assertEquals(false, delete_l5l2);
		assertEquals(3,graph.QEdges());
	}
	
	@Test
	public void scenethree(){
		stage();
		
		graph.addClient(1);
		graph.addClient(2);
		graph.addClient(3);
		
		assertTrue(!graph.getGraph().getNodes().contains(3));
		assertNull(graph.getGraph().getNodes().get(4));
		
	}
	@Test
	public void sceneFour(){
		stage();
		String  msj = "";
		
		graph.addClient(1);
		graph.addClient(2);
		graph.addClient(3);
		graph.addClient(4);
		graph.addClient(5);
		
		graph.addFlight(1, 3, 10);
		graph.addFlight(2, 3, 11);
		graph.addFlight(4, 2, 12);
		graph.addFlight(5, 4, 13);
		
		int[][] m = graph.getGraph().getTools().FloydWarshall(graph.getGraph());
		
		for(int i =0;i<m.length;i++){
			for(int j =0;j<m[0].length;j++){
				msj += m[i][j] + " ";
			}
			msj += "\n";
		}
		
        assertEquals(msj, graph.tours("FLOYD", null)); 		
		
	}
	@Test
	public void sceneFive(){
		stage();
		
		graph.addClient(1);
		graph.addClient(2);
		graph.addClient(3);
		graph.addClient(4);
		graph.addClient(5);
		graph.addClient(6);
		
		graph.addFlight(6, 2, 10);
		graph.addFlight(1, 5, 11);
		graph.addFlight(4, 2, 12);
		
		assertEquals(3,graph.QEdges());
		
		graph.addFlight(3, 5, 13);
		
		assertEquals(4,graph.QEdges());
		
		
	}
	@Test
	public void sceneSix(){
		stage();
		
		graph.addClient(1);
		graph.addClient(2);
		graph.addClient(3);
		graph.addClient(4);
		graph.addClient(5);
		
		assertEquals(5,graph.QVertex());
		
	}
}
