package graph;

public class Arista<T> {
	protected T verticeInicial;
	protected T verticeFinal;
	protected int peso;

	public Arista(T inicio, T destino, int peso) {
		verticeInicial = inicio;
		verticeFinal = destino;
		this.peso = peso;
	}

	public T getVerticeInicial() {
		return verticeInicial;
	}

	public void setVerticeInicial(T verticeInicial) {
		this.verticeInicial = verticeInicial;
	}

	public T getVerticeFinal() {
		return verticeFinal;
	}

	public void setVerticeFinal(T verticeFinal) {
		this.verticeFinal = verticeFinal;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

}