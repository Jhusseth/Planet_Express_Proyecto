package modelo;

public class Graph_M<V,E> implements IGraph<V, E> {
	private final int NUM_VERTEX;
	private int graph[][];
	
	public Graph_M(int numVertex){
		
		this.NUM_VERTEX = numVertex;
		graph = new int[NUM_VERTEX][NUM_VERTEX];
		
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				graph[i][j] = 0;
			}
		}
	}
	
	@Override
	public void insertEdge(V v1, V v2, int weightEdge) throws ArrayIndexOutOfBoundsException , IllegalArgumentException{
		Vertex<V> v_1 = new Vertex<V>(v1);
		Vertex<V> v_2 = new Vertex<V>(v2);
		if(weightEdge == 0){
			throw new IllegalArgumentException();
		}
		 this.graph[v_1.getLocation()][v_2.getLocation()] = weightEdge;		
		 this.graph[v_2.getLocation()][v_1.getLocation()] = weightEdge;
	}
	
	@Override
	public boolean existEdge(V v1, V v2) throws ArrayIndexOutOfBoundsException{
		Vertex<V> v_1 = new Vertex<V>(v1);
		Vertex<V> v_2 = new Vertex<V>(v2);
		
		return (graph[v_1.getLocation()][v_2.getLocation()] != 0);
	}
	
	@Override
	public int getWeightEdge(V v1, V v2)throws ArrayIndexOutOfBoundsException{
		Vertex<V> v_1 = new Vertex<V>(v1);
		Vertex<V> v_2 = new Vertex<V>(v2);
		
		return graph[v_1.getLocation()][v_2.getLocation()];
	}
	
	@Override
	public void deleteEdge(V v1, V v2) throws ArrayIndexOutOfBoundsException, IllegalArgumentException{
		Vertex<V> v_1 = new Vertex<V>(v1);
		Vertex<V> v_2 = new Vertex<V>(v2);
		
		if(graph[v_1.getLocation()][v_2.getLocation()] == 0){
			throw new IllegalArgumentException("La arista No existe");
		}
		
		int peso = graph[v_1.getLocation()][v_2.getLocation()];
		graph[v_1.getLocation()][v_2.getLocation()] = 0;
		graph[v_2.getLocation()][v_1.getLocation()] = 0;
		
	}
	
	@Override
	public void releaseGraph(){
		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph[i].length; j++) {
				graph[i][j] = 0;
			}
		}
	}
	
	public void showGraph(){
		System.out.printf("  %d" , 0);
		for (int i = 1; i < graph.length; i++) {
			System.out.printf(" %d" , i);
		}
		System.out.println();
		
		for(int i = 0; i < graph.length; i++){
			System.out.printf("%d ",i);
			for(int j = 0; j < graph[i].length; j++){
				System.out.printf("%d " , graph[i][j]);
			}
			System.out.println();
		}
	}
	

	public boolean hasAdjacent(V v) throws ArrayIndexOutOfBoundsException{
		int vActual = 0;
		boolean existeLista = false;
		
		Vertex<V> v_1 = new Vertex<V>(v);
		
		while(vActual < this.NUM_VERTEX && !existeLista){
			if(graph[v_1.getLocation()][vActual] != 0){
				existeLista = true;
			}
			else{
				vActual = vActual + 1;
			}
		}
		
		return existeLista;
	}
	

	public int getFirstAdy(V v) throws ArrayIndexOutOfBoundsException, UnsupportedOperationException{
		int adyacente = -1;
		int vActual = 0;
		boolean existeLista = false;
		Vertex<V> v_1 = new Vertex<V>(v);
		
		while(vActual < this.NUM_VERTEX && !existeLista){
			if(graph[v_1.getLocation()][vActual] == 0){
				vActual = vActual + 1;
			}
			else{
				adyacente = vActual;
				existeLista = true;
			}
		}
		
		if(!existeLista) throw new UnsupportedOperationException("No existe Lista");
		
		return adyacente;		
	}
	
	public int nextAdj(V v, V before) throws ArrayIndexOutOfBoundsException, UnsupportedOperationException{
		Vertex<V> v_1 = new Vertex<V>(v);
		Vertex<V> v_2 = new Vertex<V>(before);
		
		int adyacente = 0;
		int vActual = v_2.getLocation() + 1;
		boolean existeLista = false;
		
		while(vActual < this.NUM_VERTEX && !existeLista){
			if(graph[v_1.getLocation()][vActual] == 0){
				vActual = vActual + 1;
			}
			else{
				adyacente = vActual;
				existeLista = true;
			}
		}
		
		if(!existeLista)adyacente = -1;
		return adyacente;
	}	
}
