package structures;

public interface IGraph<V,E> {
	
	public void insertEdge(V v1, V v2, int weight);
	public boolean existEdge(V v1, V v2);
	public int getWeightEdge(V v1, V v2);
	public void deleteEdge(V v1, V v2);
	public void releaseGraph();

}
