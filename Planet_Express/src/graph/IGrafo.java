package graph;

public interface IGrafo<T> {
	public void agregarVertice(T vertice);

	public void agregarD(T vInicial, T vFinal, int peso);

	public void eliminarArista(Arista<T> A);

	public int[][] darMatrizAdyacencia(Grafo<T> G);

}
