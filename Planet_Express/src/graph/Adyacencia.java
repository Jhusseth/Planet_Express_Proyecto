package graph;

public class Adyacencia<T> implements Comparable<Adyacencia<T>> {
	protected Nodo<T> adyacente;
	protected int ponderacion;

	public Adyacencia(Nodo<T> ady, int p) {
		adyacente = ady;
		ponderacion = p;
	}

	public Nodo<T> getAdyacente() {
		return adyacente;
	}

	public void setAdyacente(Nodo<T> adyacente) {
		this.adyacente = adyacente;
	}

	public int getPonderacion() {
		return ponderacion;
	}

	public void setPonderacion(int ponderacion) {
		this.ponderacion = ponderacion;
	}

	@Override
	public int compareTo(Adyacencia<T> o) {
		// TODO Auto-generated method stub
		double peso = o.getPonderacion();
		return ponderacion < peso ? -1 : ponderacion > peso ? 1 : 0;
	}

}
