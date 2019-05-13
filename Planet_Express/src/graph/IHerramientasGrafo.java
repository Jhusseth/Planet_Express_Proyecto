package graph;

public interface IHerramientasGrafo<T> {

	public void Dijkstra(Grafo<T> G, Nodo<T> ref);

	public int[][] DijkstraVariasReferencias(Grafo<T> G, T[] referencia, int tamanio);

	public void recorridoAmplitud(Grafo<T> G, Nodo<T> ref);

	public void recorridoProfundidad(Grafo<T> G);

	public int[][] DijkstraMatriz(Grafo<T> G, T[] ref);

	public int[][] FloydWarshall(Grafo<T> G);
}
