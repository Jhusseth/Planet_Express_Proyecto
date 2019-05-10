package modelo;

import structures.Graph_L;
import structures.Graph_M;

public class Planet_Express {
	
	public static Graph_L<Location, Route> graphL;
	public static Graph_M<Location, Route> graphM;
	
	public static void main(String[] args){
		
		Location l1 = new Location("Brazil", 006);
		Location l2 = new Location("China", 005);
		Location l3 = new Location("Colombia", 004);
		Location l4 = new Location("Bolivia", 003);
		Location l5 = new Location("Chile", 002);
		
//		Route r1 = new Route(l1, l2, 120, 3);
//		Route r2 = new Route(l3, l4, 170, 5);
//		Route r3 = new Route(l1, l5, 190, 6);
		
		graphM = new Graph_M<>(5);
		
		graphM.insertEdge(l1, l2, 120);
		graphM.insertEdge(l4, l4, 170);
		graphM.insertEdge(l2, l5, 180);
		
		graphM.showGraph();
		
	}
	
}
