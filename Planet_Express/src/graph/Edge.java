package graph;

public class Edge<T> {
	protected T initialVertex;
	protected T finalVertex;
	protected int weight;

	public Edge(T initial, T destine, int weight) {
		initialVertex = initial;
		finalVertex = destine;
		this.weight = weight;
	}

	public T getInitialvertex() {
		return initialVertex;
	}

	public void setInitialvertex(T initialVertex) {
		this.initialVertex = initialVertex;
	}

	public T getFinalVertex() {
		return finalVertex;
	}

	public void setFinalVertex(T finalVertex) {
		this.finalVertex = finalVertex;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}