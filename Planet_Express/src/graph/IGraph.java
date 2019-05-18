package graph;

public interface IGraph<T> {
	public void addVertex(T vertex);

	public void addEdge(T vInitial, T vFinal, int weight);

	public boolean deleteEdge(Edge<T> e);
	
	public boolean  deleteVertex(T e);

	public int[][] getMatrizAdjacency(Graph<T> g);

}
