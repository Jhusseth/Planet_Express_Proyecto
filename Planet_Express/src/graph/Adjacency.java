package graph;

public class Adjacency<T> implements Comparable<Adjacency<T>> {
	
	protected Node<T> adjacent;
	protected int weighing;

	public Adjacency(Node<T> adj, int p) {
		adjacent = adj;
		weighing = p;
	}

	public Node<T> getAdjacent() {
		return adjacent;
	}

	public void setAdjacent(Node<T> adjacent) {
		this.adjacent = adjacent;
	}

	public int getWeighing() {
		return weighing;
	}

	public void setWeighing(int weighing) {
		this.weighing = weighing;
	}

	@Override
	public int compareTo(Adjacency<T> o) {
		double weight = o.getWeighing();
		return weighing < weight ? -1 : weighing > weight ? 1 : 0;
	}

}
