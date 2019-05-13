package graph;

public interface IGraphTools<T> {

	public void Dijkstra(Graph<T> g, Node<T> ref);

	public int[][] DijkstraSeveralReferences(Graph<T> g, T[] reference, int tam);

	public void BFS(Graph<T> g, Node<T> ref);

	public void DFS(Graph<T> g);

	public int[][] DijkstraMatriz(Graph<T> g, T[] ref);

	public int[][] FloydWarshall(Graph<T> g);
}
