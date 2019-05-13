package graph;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph<T> implements IGraph<T> {
	private GraphTools<T> tools;
	private HashMap<T, Integer> elements;
	private LinkedList<Edge<T>> edges;
	private Hashtable<T, Node<T>> nodes;
	private int quantity;
	private boolean addressed;

	public Graph(boolean addressed) {
		quantity = 0;
		elements = new HashMap<>();
		edges = new LinkedList<>();
		nodes = new Hashtable<>();
		tools = new GraphTools<>();
		this.setAddressed(addressed);

	}

	@Override
	public void addVertex(T vertex) {
		if (!elements.containsKey(vertex) && !nodes.containsKey(vertex)) {
			elements.put(vertex, quantity);
			nodes.put(vertex, new Node<T>(vertex));
			quantity++;
		}
	}
	
	private void addnEdge(T vInitial, T vFinal, int weight) {
		
		Edge<T> a = new Edge<T>(vInitial, vFinal, weight);
		if (!edges.contains(a))
			edges.add(a);
		nodes.get(vInitial).addAdjacent(vFinal, weight);
		nodes.get(vFinal).addAdjacent(vInitial, weight);

	}

	@Override
	public void addEdge(T vInitial, T vFinal, int weiht) {
		if (isAddressed() == false) {
			addnEdge(vInitial, vFinal, weiht);
		} else {
			Edge<T> a = new Edge<T>(vInitial, vFinal, weiht);
			if (!edges.contains(a))
				edges.add(a);
			nodes.get(vInitial).addAdjacent(vFinal, weiht);
		}

	}

	public int searchEdgeIndice(int weight) {
		int pos = 0;
		for (int i = 0; i < edges.size(); i++) {
			if (weight == edges.get(i).getWeight())
				pos = i;
		}
		return pos;
	}

	@Override
	public void deleteEdge(Edge<T> e) {
		if (edges.contains(e))
			edges.remove(e);
	}

	@Override
	public int[][] getMatrizAdjacency(Graph<T> g) {
		int[][] adjacencys = new int[g.getElements().size()][g.getElements().size()];
		for (Iterator<T> iterator = elements.keySet().iterator(); iterator.hasNext();) {
			T type = (T) iterator.next();
			LinkedList<Adjacency<T>> nodesAdjacencys = nodes.get(type).getAdjacencys();
			if (!nodesAdjacencys.isEmpty()) {
				for (int j = 0; j < nodesAdjacencys.size(); j++) {
					int weight = nodesAdjacencys.get(j).getWeighing();
					adjacencys[elements.get(type)][elements
							.get(nodesAdjacencys.get(j).getAdjacent().getElement())] = weight;
				}
			}
		}
		return adjacencys;
	}

	public HashMap<T, Integer> getElements() {
		return elements;
	}

	public GraphTools<T> getTools() {
		return tools;
	}

	public void setElements(HashMap<T, Integer> elements) {
		this.elements = elements;
	}

	public Hashtable<T, Node<T>> getNodes() {
		return nodes;
	}

	public void setNodes(Hashtable<T, Node<T>> nodes) {
		this.nodes = nodes;
	}

	public LinkedList<Edge<T>> getEdges() {
		return edges;
	}

	public void setEdges(LinkedList<Edge<T>> edges) {
		this.edges = edges;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setTools(GraphTools<T> tools) {
		this.tools = tools;
	}

	public boolean isAddressed() {
		return addressed;
	}

	public void setAddressed(boolean dirigido) {
		this.addressed = dirigido;
	}

}