package graph;

import java.util.LinkedList;

public class Nodo<T> {
	public final static int INFINITO = Integer.MAX_VALUE;
	public final static char BLACK = 'B';
	public final static char GRAY = 'G';
	public final static char WHITE = 'W';
	protected T element;
	protected char Color;
	protected Nodo<T> padre;
	protected int distancia;
	protected int cantidadDeAdyacencias;
	protected boolean visitado;
	protected LinkedList<Adyacencia<T>> adyacentes;

	public Nodo(T element) {
		padre = null;
		distancia = INFINITO;
		visitado = false;
		this.element = element;
		cantidadDeAdyacencias = -1;
		adyacentes = new LinkedList<>();
		Color = WHITE;
	}

	public void agregarAdyacente(T destino, int peso) {
		Nodo<T> dest = new Nodo<T>(destino);
		adyacentes.add(new Adyacencia<T>(dest, peso));
		cantidadDeAdyacencias++;

	}

	public int darPosicionAdyacente(T ady1) {
		boolean pare = false;
		int pos = 0;
		for (int i = 0; i < adyacentes.size() && !pare; i++) {
			if (adyacentes.get(i).getAdyacente() == ady1)
				pare = true;
			pos = i;
		}
		return pos;

	}

	public int darPesoAdyacente(int pos) {
		return adyacentes.get(pos).getPonderacion();

	}

	public T darAdyacenteEnPos(int pos) {
		return adyacentes.get(pos).getAdyacente().getElement();
	}

	public void eliminarAdyacencia(int pos) throws Exception {
		adyacentes.remove(pos);
		cantidadDeAdyacencias--;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public int getCantidadDeAdyacencias() {
		return cantidadDeAdyacencias;
	}

	public void setCantidadDeAdyacencias(int enlaceExistente) {
		this.cantidadDeAdyacencias = enlaceExistente;
	}

	public boolean isVisitado() {
		return visitado;
	}

	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}

	public Nodo<T> getPadre() {
		return padre;
	}

	public void setPadre(Nodo<T> padre) {
		this.padre = padre;
	}

	public LinkedList<Adyacencia<T>> getAdyacentes() {
		return adyacentes;
	}

	public void setAdyacentes(LinkedList<Adyacencia<T>> adyacentes) {
		this.adyacentes = adyacentes;
	}

	public char getColor() {
		return Color;
	}

	public void setColor(char color) {
		Color = color;
	}
}
