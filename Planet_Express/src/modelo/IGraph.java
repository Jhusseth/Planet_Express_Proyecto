package modelo;

public interface IGraph<E,T> {
	
	public void insertEdge(E v1, E v2, int weight);
	public boolean existEdge(E v1, E v2);
	public int getWeightEdge(E v1, E v2);
	public void deleteEdge(E v1, E v2);
	public void releaseGraph();

}
