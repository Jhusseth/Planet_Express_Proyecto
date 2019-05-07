package modelo;

public class Edge<E> implements Comparable<Edge<E>> {
	
	private Vertex<E> ini;
	private Vertex<E> end;
	private int weight;
	private int locate;
	

	public Edge(Vertex<E> ini, Vertex<E> end, int weight) {
		
		this.ini = ini;
		this.end = end;
		this.weight = weight;
		this.locate = 0;
	}
	
	public Edge(Vertex<E> ini, Vertex<E> end){
		this.ini = ini;
		this.end = end;
		this.weight = 0;
		this.locate = 0;
	}


	public Vertex<E> getIni() {
		return ini;
	}


	public void setIni(Vertex<E> ini) {
		this.ini = ini;
	}


	public Vertex<E> getEnd() {
		return end;
	}


	public void setEnd(Vertex<E> end) {
		this.end = end;
	}


	public int getWeight() {
		return weight;
	}


	public void setWeight(int weight) {
		this.weight = weight;
	}


	public int getLocate() {
		return locate;
	}


	public void setLocate(int locate) {
		this.locate = locate;
	}


	@Override
	public int compareTo(Edge<E> e) {
		return weight-e.getWeight();
	}

}
