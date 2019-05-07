package modelo;

public class Graph_L<E,T> implements IGraph<E, T> {
	private Node<E> graph[];
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
	public boolean existEdge(E v1, E v2){
		Node<E> actual = graph[0];
		while(actual != null){
			if(actual.getVertex() == v2) {
				return true;
			}
			actual = actual.getNext();
		}
		return false;
	}
	
	@Override
	public void insertEdge(E v1, E v2, int peso){
		if(!existEdge(v1, v2)){
			Vertex<E> v = new Vertex<E>(v2);
			Node<E> nuevo = new Node<>(v, peso);
			
			if(graph[0] == null){
				graph[0] = nuevo;
				insertEdge(v2, v1,peso);				
			}
			else{
				Node<E> actual = graph[0];
				
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
	public void deleteEdge(E v1, E v2){
		if(existEdge(v1, v2)){
			if(graph[0].getVertex() == v2){
				graph[0] = graph[0].getNext();
				deleteEdge(v2,v1);
				return;
			}
			Node<E> actual = graph[0].getNext();
			Node<E> anterior = graph[0];
			
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
			Node<E> actual = graph[i];
			
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
	
	public boolean hasAdjacent(E v){
		if(graph[0] == null) 
			return false;
		return true;
	}
	
	public Node<E> getFirstAdy(E v){
		return graph[0];
	}
	
	public Node<E> getNextAdy(Node<E> anteriorAd){
		return anteriorAd.getNext();
	}

	@Override
	public int getWeightEdge(E v1, E v2) {
		if(existEdge(v1, v2)){
			Vertex<E> v = new Vertex<E>(v1);
			return graph[v.getLocation()].getWeightEdge();
		}
		else{
			return 0;
		}
	}
}
