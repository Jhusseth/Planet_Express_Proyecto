package graph;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class Grafo<T> implements IGrafo<T> {
	private HerramientasGrafo<T> otros;
	private HashMap<T, Integer> elementos;
	private LinkedList<Arista<T>> aristas;
	private Hashtable<T, Nodo<T>> nodos;
	private int cantidad;
	private boolean dirigido;

	public Grafo(boolean dirigido) {
		cantidad = 0;
		elementos = new HashMap<>();
		aristas = new LinkedList<>();
		nodos = new Hashtable<>();
		otros = new HerramientasGrafo<>();
		this.setDirigido(dirigido);

	}

	@Override
	/**
	 * Método encargado de agregar un nodo.
	 */
	public void agregarVertice(T vertice) {
		// TODO Auto-generated method stub
		if (!elementos.containsKey(vertice) && !nodos.containsKey(vertice)) {
			elementos.put(vertice, cantidad);
			nodos.put(vertice, new Nodo<T>(vertice));
			cantidad++;
		}
	}

	/**
	 * Método encargado de agregar nodos adyacentes (G es no dirigido).
	 */
	private void agregarND(T vInicial, T vFinal, int peso) {
		// TODO Auto-generated method stub
		Arista<T> a = new Arista<T>(vInicial, vFinal, peso);
		if (!aristas.contains(a))
			aristas.add(a);
		nodos.get(vInicial).agregarAdyacente(vFinal, peso);
		nodos.get(vFinal).agregarAdyacente(vInicial, peso);

	}

	@Override
	public void agregarD(T vInicial, T vFinal, int peso) {
		if (isDirigido() == false) {
			agregarND(vInicial, vFinal, peso);
		} else {
			Arista<T> a = new Arista<T>(vInicial, vFinal, peso);
			if (!aristas.contains(a))
				aristas.add(a);
			nodos.get(vInicial).agregarAdyacente(vFinal, peso);
		}

	}

	public int buscarIndiceArista(int peso) {
		// TODO Auto-generated method stub
		int pos = 0;
		for (int i = 0; i < aristas.size(); i++) {
			if (peso == aristas.get(i).getPeso())
				pos = i;
		}
		return pos;
	}

	@Override
	public void eliminarArista(Arista<T> A) {
		// TODO Auto-generated method stub
		if (aristas.contains(A))
			aristas.remove(A);
	}

	@Override
	public int[][] darMatrizAdyacencia(Grafo<T> G) {
		int[][] adyacencias = new int[G.getElementos().size()][G.getElementos().size()];
		for (Iterator<T> iterator = elementos.keySet().iterator(); iterator.hasNext();) {
			T type = (T) iterator.next();
			LinkedList<Adyacencia<T>> nodosAdyacentes = nodos.get(type).getAdyacentes();
			if (!nodosAdyacentes.isEmpty()) {
				for (int j = 0; j < nodosAdyacentes.size(); j++) {
					int peso = nodosAdyacentes.get(j).getPonderacion();
					adyacencias[elementos.get(type)][elementos
							.get(nodosAdyacentes.get(j).getAdyacente().getElement())] = peso;
				}
			}
		}
		return adyacencias;
	}

	public HashMap<T, Integer> getElementos() {
		return elementos;
	}

	public HerramientasGrafo<T> getOtros() {
		return otros;
	}

	public void setElementos(HashMap<T, Integer> elementos) {
		this.elementos = elementos;
	}

	public Hashtable<T, Nodo<T>> getNodos() {
		return nodos;
	}

	public void setNodos(Hashtable<T, Nodo<T>> nodos) {
		this.nodos = nodos;
	}

	public LinkedList<Arista<T>> getAristas() {
		return aristas;
	}

	public void setAristas(LinkedList<Arista<T>> aristas) {
		this.aristas = aristas;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public void setOtros(HerramientasGrafo<T> otros) {
		this.otros = otros;
	}

	public boolean isDirigido() {
		return dirigido;
	}

	public void setDirigido(boolean dirigido) {
		this.dirigido = dirigido;
	}

}