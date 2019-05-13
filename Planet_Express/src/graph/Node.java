package graph;

import java.util.LinkedList;

public class Node<T> {
	public final static int INFINITE = Integer.MAX_VALUE;
	public final static char BLACK = 'B';
	public final static char GRAY = 'G';
	public final static char WHITE = 'W';
	protected T element;
	protected char Color;
	protected Node<T> father;
	protected int distance;
	protected int cantAdjacencys;
	protected boolean visited;
	protected LinkedList<Adjacency<T>> adjacent;

	public Node(T element) {
		father = null;
		distance = INFINITE;
		visited = false;
		this.element = element;
		cantAdjacencys = -1;
		adjacent = new LinkedList<>();
		Color = WHITE;
	}

	public void addAdjacent(T destination, int weight) {
		Node<T> dest = new Node<T>(destination);
		adjacent.add(new Adjacency<T>(dest, weight));
		cantAdjacencys++;

	}

	public int getpositonAdjacent(T adj) {
		boolean partner = false;
		int pos = 0;
		for (int i = 0; i < adjacent.size() && !partner; i++) {
			if (adjacent.get(i).getAdjacent() == adj)
				partner = true;
			pos = i;
		}
		return pos;

	}

	public int getWeighingAdjacent(int pos) {
		return adjacent.get(pos).getWeighing();

	}

	public T getAdjacentInPos(int pos) {
		return adjacent.get(pos).getAdjacent().getElement();
	}

	public void deleteAdjacency(int pos) throws Exception {
		adjacent.remove(pos);
		cantAdjacencys--;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getCantAdjacency() {
		return cantAdjacencys;
	}

	public void setCantAdjacency(int existingLink) {
		this.cantAdjacencys = existingLink;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Node<T> getFather() {
		return father;
	}

	public void setFather(Node<T> father) {
		this.father = father;
	}

	public LinkedList<Adjacency<T>> getAdjacencys() {
		return adjacent;
	}

	public void setAdjacencys(LinkedList<Adjacency<T>> adjacencys) {
		this.adjacent = adjacencys;
	}

	public char getColor() {
		return Color;
	}

	public void setColor(char color) {
		Color = color;
	}
}
