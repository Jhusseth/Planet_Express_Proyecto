package modelo;
import java.io.File;
import java.io.IOException;

import graph.Graph;

public class Planet_Express {
	
	private int[][] mWeight;
	private Graph<Airport> gr;
	
	private String[] vertex ;
	private String[] cordeX ;

	private String[] cordeY ;
	
	private int QFlights;
	private int QAirports;
	
	
	public Planet_Express() {
		gr = new Graph<>(false);
		QAirports = 0;
		QAirports = 0;
	}

	public void addClient(Airport f){
		gr.addVertex(f);
		QAirports++;
	}
	
	public void addFlight(Airport i , Airport f, int w){
		gr.addEdge(i, f, w);
		QFlights++;
	}
	
	public void save (int[][] matrizA,int[][] matrizI, String[] nombres, int [] cordX, int[] cordY){
		
	}
	
	public int[][] upload(File archivo) throws IOException{
		
		return null;
	}
	
	
	public int QVertex(){
		
		return QAirports;
	}
	
	public int QEdges(){
		return QFlights;
	}
}
