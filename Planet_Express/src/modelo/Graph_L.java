package modelo;

public class Graph_L<V,E> implements IGraph<V, E> {
	private Node<V> graph[];
	private int numVertex;
	
	@SuppressWarnings("unchecked")
	
	public Graph_L(int nroVertices){
		this.numVertex = nroVertices;
		graph = new Node[this.numVertex];
		
		for(int i = 0; i < graph.length; i++){
			graph[i] = null;
		}
	}
	
	@Override
	public boolean existEdge(V v1, V v2){
		Vertex<V> v = new Vertex<V>(v1);
		Node<V> actual = graph[v.getLocation()];
		
		while(actual != null){
			if(actual.getVertex() == v2) {
				return true;
			}
			actual = actual.getNext();
		}
		return false;
	}
	
	@Override
	public void insertEdge(V v1, V v2, int peso){
		if(!existEdge(v1, v2)){
			Vertex<V> v_2 = new Vertex<V>(v2);
			Node<V> nuevo = new Node<>(v_2, peso);
			
			Vertex<V> v = new Vertex<V>(v1);
			if(graph[v.getLocation()] == null){
				graph[v.getLocation()] = nuevo;
				insertEdge(v2, v1,peso);				
			}
			else{
				Node<V> actual = graph[v.getLocation()];
				
				while(actual.getNext() != null)
				{ 
					actual = actual.getNext();
				}
				actual.setNext(nuevo);
				insertEdge(v2,v1,peso);				
			}
		}		
	}
	@Override
	public void deleteEdge(V v1, V v2){
		Vertex<V> v = new Vertex<V>(v1);
		if(existEdge(v1, v2)){
			if(graph[v.getLocation()].getVertex() == v2){
				graph[v.getLocation()] = graph[0].getNext();
				deleteEdge(v2,v1);
				return;
			}
			Node<V> actual = graph[v.getLocation()].getNext();
			Node<V> anterior = graph[v.getLocation()];
			
			while(actual != null){
				if(actual.getVertex() == v2){
					anterior.setNext(actual.getNext());
					deleteEdge(v2,v1);
					return;
				}
				anterior = actual;
				actual = actual.getNext();
			}
		}		
	}
	
	public void showGraph(){
		for( int i = 0; i < graph.length; i++){
			Node<V> actual = graph[i];
			
			while(actual != null){
				System.out.printf("%d -> " , i);
				System.out.printf("%d(%d) \n" , actual.getNext(), actual.getWeightEdge());
				
				actual = actual.getNext();
			}
			System.out.println();
		}
	}
	
	public void releaseGraph(){
		for( int i = 0; i < graph.length; i++){
			graph[i] = null;
		}
	}
	
	public boolean hasAdjacent(V v){
		Vertex<V> v1 = new Vertex<V>(v);
		if(graph[v1.getLocation()] == null) 
			return false;
		return true;
	}
	
	public Node<V> getFirstAdy(V v){
		Vertex<V> v1 = new Vertex<V>(v);
		return graph[v1.getLocation()];
	}
	
	public Node<V> getNextAdy(Node<V> anteriorAd){
		return anteriorAd.getNext();
	}

	@Override
	public int getWeightEdge(V v1, V v2) {
		if(existEdge(v1, v2)){
			Vertex<V> v = new Vertex<V>(v1);
			return graph[v.getLocation()].getWeightEdge();
		}
		else{
			return 0;
		}
	}
}
