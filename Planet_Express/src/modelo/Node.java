package modelo;

public class Node<E> {
	
	private Vertex<E> vertex;
	private int weightEdge;
	private Node<E> next;
	
	public Node(Vertex<E> v, int p){
		this.setVertex(v);
		this.setWeightEdge(p);	
		setNext(null);
	}

	public Vertex<E> getVertex() {
		return vertex;
	}

	public void setVertex(Vertex<E> vertex) {
		this.vertex = vertex;
	}

	public int getWeightEdge() {
		return weightEdge;
	}

	public void setWeightEdge(int weightEdge) {
		this.weightEdge = weightEdge;
	}

	public Node<E> getNext() {
		return next;
	}

	public void setNext(Node<E> next) {
		this.next = next;
	}

}
