package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class GraphTools<T> implements IGraphTools<T> {
	private int[] distances;
	private int V;

	@Override
	public void Dijkstra(Graph<T> tools, Node<T> ref) {
		distances = new int[tools.getElements().size()];
		for (int i = 0; i < distances.length; i++) {
			distances[i] = Integer.MAX_VALUE;
		}
		distances[tools.getElements().get(ref.getElement())] = 0;
		PriorityQueue<Adjacency<T>> queue = new PriorityQueue<>();
		tools.getNodes().get(ref.getElement()).setDistance(0);
		queue.add(new Adjacency<T>(ref, tools.getNodes().get(ref.getElement()).getDistance()));
		while (!queue.isEmpty()) {
			Adjacency<T> adj = queue.poll();
			Node<T> u = tools.getNodes().get(adj.getAdjacent().getElement());
			u.setVisited(true);
			int distanceMin = adj.getWeighing();
			for (int i = 0; i < u.getAdjacencys().size(); i++) {
				Adjacency<T> adj2 = u.getAdjacencys().get(i);
				Node<T> v = tools.getNodes().get(adj2.getAdjacent().getElement());
				if (v.isVisited() == false && distanceMin + adj2.getWeighing() < v.getDistance()) {
					v.setDistance(distanceMin + adj2.getWeighing());
					v.setFather(u);
					distances[tools.getElements().get(v.getElement())] = v.getDistance();
					queue.add(new Adjacency<T>(v, v.getDistance()));
				}
			}
		}
	}

	@Override
	public int[][] DijkstraSeveralReferences(Graph<T> g, T[] reference, int tam) {
		PriorityQueue<Adjacency<T>> queue = new PriorityQueue<>();
		int[][] matrix = new int[tam][tam];
		for (int x = 0; x < reference.length; x++) {
			int[] distances = new int[tam];
			boolean[] visited = new boolean[tam];
			Node<T> ref = g.getNodes().get(reference[x]);
			distances[g.getElements().get(ref.getElement())] = 0;
			int min = distances[g.getElements().get(ref.getElement())];
			visited[g.getElements().get(ref.getElement())] = true;
			queue.add(new Adjacency<T>(ref, min));
			while (!queue.isEmpty()) {
				Adjacency<T> adj = queue.poll();
				Node<T> u = g.getNodes().get(adj.getAdjacent().getElement());
				int distanceMin = adj.getWeighing();
				for (int i = 0; i < u.getAdjacencys().size(); i++) {
					Adjacency<T> adj2 = u.getAdjacencys().get(i);
					Node<T> v = g.getNodes().get(adj2.getAdjacent().getElement());
					if (distances[g.getElements().get(v.getElement())] == 0)
						distances[g.getElements().get(v.getElement())] = Integer.MAX_VALUE;
					if (visited[g.getElements().get(v.getElement())] == false
							&& distanceMin + adj2.getWeighing() < distances[g.getElements().get(v.getElement())]) {
						distances[g.getElements().get(v.getElement())] = (distanceMin + adj2.getWeighing());
						v.setFather(u);
						int nuevo = distances[g.getElements().get(v.getElement())];
						matrix[g.getElements().get(ref.getElement())][g.getElements().get(v.getElement())] = nuevo;
						matrix[g.getElements().get(v.getElement())][g.getElements().get(ref.getElement())] = nuevo;
						queue.add(new Adjacency<T>(v, nuevo));
					}
				}
			}
		}
		return matrix;
	}

	@Override
	public int[][] DijkstraMatriz(Graph<T> g, T[] ref) {
		int[][] Matrix = g.getMatrizAdjacency(g);
		V = Matrix.length;
		return Dijkstra(Matrix, ref, V, g);
	}

	private int[][] Dijkstra(int graph[][], T[] src, int v1, Graph<T> G) {
		V = v1;
		int[][] M = new int[V][V];
		for (int x = 0; x < src.length; x++) {
			int dist[] = new int[V];
			Boolean sptSet[] = new Boolean[V]; 
			for (int i = 0; i < V; i++) {
				dist[i] = Integer.MAX_VALUE;
				sptSet[i] = false;
			}
			dist[G.getElements().get(src[x])] = 0;
			for (int count = 0; count < V - 1; count++) {
				int u = MinorDistance(dist, sptSet, V);
				sptSet[u] = true; 
				for (int v = 0; v < V; v++)
					if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
							&& dist[u] + graph[u][v] < dist[v]) {
						dist[v] = dist[u] + graph[u][v];
						M[u][v] = dist[v];
						M[v][u] = dist[v];
					}
			}
		}
		return M;
	}

	private int MinorDistance(int dist[], Boolean sptSet[], int v1) {
		V = v1;
		int min = Integer.MAX_VALUE, min_index = -1;
		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}
		return min_index;
	}

	@Override
	public int[][] FloydWarshall(Graph<T> g) {
		int INFINITE = Integer.MAX_VALUE;
		int[][] distances = new int[g.getQuantity()][g.getQuantity()];
		int i, j, k;
		for (i = 0; i < g.getQuantity(); i++) {
			for (j = 0; j < g.getQuantity(); j++) {
				distances[i][j] = g.getMatrizAdjacency(g)[i][j];
				if ((i != j) && g.getMatrizAdjacency(g)[i][j] == 0)
					distances[i][j] = INFINITE;
			}
		}
		for (k = 0; k < g.getQuantity(); k++) {
			for (i = 0; i < g.getQuantity(); i++) {
				for (j = 0; j < g.getQuantity(); j++) {
					if (distances[i][k] != INFINITE && distances[k][j] != INFINITE
							&& distances[i][k] + distances[k][j] < distances[i][j])
						distances[i][j] = distances[i][k] + distances[k][j];
				}

			}
		}

		return distances;
	}

	@Override
	public void BFS(Graph<T> G, Node<T> ref) {
		
		G.getNodes().get(ref.getElement()).setColor(Node.GRAY);
		G.getNodes().get(ref.getElement()).setDistance(0);
		Queue<Node<T>> Q = new LinkedList<Node<T>>();
		Q.add(ref);
		while (!Q.isEmpty()) {
			Node<T> u = G.getNodes().get(Q.poll().getElement());
			for (int i = 0; i < u.getAdjacencys().size(); i++) {
				Adjacency<T> h = u.getAdjacencys().get(i);
				Node<T> v = G.getNodes().get(h.getAdjacent().getElement());
				if (v.getColor() == Node.WHITE) {
					v.setColor(Node.GRAY);
					v.setDistance(u.getDistance() + 1);
					v.setFather(u);
					Q.add(v);
				}
				u.setColor(Node.BLACK);
			}
		}
	}

	@Override
	public void DFS(Graph<T> g) {
		for (Iterator<T> iterator = g.getNodes().keySet().iterator(); iterator.hasNext();) {
			T type = (T) iterator.next();
			Node<T> u = g.getNodes().get(type);
			if (u.getColor() == Node.WHITE) {
				DFSVisit(g, u);
			}
		}

	}

	private void DFSVisit(Graph<T> g, Node<T> u) {
		int time = 0;
		time = time + 1;
		g.getNodes().get(u.getElement()).setDistance(time);
		g.getNodes().get(u.getElement()).setColor(Node.GRAY);
		for (int i = 0; i < u.getAdjacencys().size(); i++) {
			Adjacency<T> h = u.getAdjacencys().get(i);
			Node<T> v = g.getNodes().get(h.getAdjacent().getElement());
			if (v.getColor() == Node.WHITE) {
				v.setFather(u);
				DFSVisit(g, v);
			}
		}
		u.setColor(Node.BLACK);
		time = time + 1;
		u.setDistance(time);
	}

	public int[] getDistances() {
		return distances;
	}

	public void setDistances(int[] distances) {
		this.distances = distances;
	}

}
