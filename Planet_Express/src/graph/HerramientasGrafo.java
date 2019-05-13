package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class HerramientasGrafo<T> implements IHerramientasGrafo<T> {
	private int[] Distancias;
	private int V;

	@Override
	public void Dijkstra(Grafo<T> G, Nodo<T> ref) {
		// TODO Auto-generated method stub
		Distancias = new int[G.getElementos().size()];
		for (int i = 0; i < Distancias.length; i++) {
			Distancias[i] = Integer.MAX_VALUE;
		}
		Distancias[G.getElementos().get(ref.getElement())] = 0;
		PriorityQueue<Adyacencia<T>> Cola = new PriorityQueue<>();
		G.getNodos().get(ref.getElement()).setDistancia(0);
		Cola.add(new Adyacencia<T>(ref, G.getNodos().get(ref.getElement()).getDistancia()));
		while (!Cola.isEmpty()) {
			Adyacencia<T> ady = Cola.poll();
			Nodo<T> u = G.getNodos().get(ady.getAdyacente().getElement());
			u.setVisitado(true);
			int distMinima = ady.getPonderacion();
			for (int i = 0; i < u.getAdyacentes().size(); i++) {
				Adyacencia<T> ady2 = u.getAdyacentes().get(i);
				Nodo<T> v = G.getNodos().get(ady2.getAdyacente().getElement());
				if (v.isVisitado() == false && distMinima + ady2.getPonderacion() < v.getDistancia()) {
					v.setDistancia(distMinima + ady2.getPonderacion());
					v.setPadre(u);
					Distancias[G.getElementos().get(v.getElement())] = v.getDistancia();
					Cola.add(new Adyacencia<T>(v, v.getDistancia()));
				}
			}
		}
	}

	@Override
	public int[][] DijkstraVariasReferencias(Grafo<T> G, T[] referencia, int tamanio) {
		// TODO Auto-generated method stub
		PriorityQueue<Adyacencia<T>> Cola = new PriorityQueue<>();
		int[][] matrix = new int[tamanio][tamanio];
		for (int x = 0; x < referencia.length; x++) {
			int[] distancias = new int[tamanio];
			boolean[] visitado = new boolean[tamanio];
			Nodo<T> ref = G.getNodos().get(referencia[x]);
			distancias[G.getElementos().get(ref.getElement())] = 0;
			int min = distancias[G.getElementos().get(ref.getElement())];
			visitado[G.getElementos().get(ref.getElement())] = true;
			Cola.add(new Adyacencia<T>(ref, min));
			while (!Cola.isEmpty()) {
				Adyacencia<T> ady = Cola.poll();
				Nodo<T> u = G.getNodos().get(ady.getAdyacente().getElement());
				int distMinima = ady.getPonderacion();
				for (int i = 0; i < u.getAdyacentes().size(); i++) {
					Adyacencia<T> ady2 = u.getAdyacentes().get(i);
					Nodo<T> v = G.getNodos().get(ady2.getAdyacente().getElement());
					if (distancias[G.getElementos().get(v.getElement())] == 0)
						distancias[G.getElementos().get(v.getElement())] = Integer.MAX_VALUE;
					if (visitado[G.getElementos().get(v.getElement())] == false
							&& distMinima + ady2.getPonderacion() < distancias[G.getElementos().get(v.getElement())]) {
						distancias[G.getElementos().get(v.getElement())] = (distMinima + ady2.getPonderacion());
						v.setPadre(u);
						int nuevo = distancias[G.getElementos().get(v.getElement())];
						matrix[G.getElementos().get(ref.getElement())][G.getElementos().get(v.getElement())] = nuevo;
						matrix[G.getElementos().get(v.getElement())][G.getElementos().get(ref.getElement())] = nuevo;
						Cola.add(new Adyacencia<T>(v, nuevo));
					}
				}
			}
		}
		return matrix;
	}

	@Override
	public int[][] DijkstraMatriz(Grafo<T> G, T[] ref) {
		int[][] Matrix = G.darMatrizAdyacencia(G);
		V = Matrix.length;
		return Dijkstra(Matrix, ref, V, G);
	}

	private int[][] Dijkstra(int graph[][], T[] src, int v1, Grafo<T> G) {
		V = v1;
		int[][] M = new int[V][V];
		for (int x = 0; x < src.length; x++) {
			int dist[] = new int[V]; // Matriz de distancias.
			Boolean sptSet[] = new Boolean[V]; // Matriz que indica si los
												// nodos
												// ya
												// fueron visitados.
			for (int i = 0; i < V; i++) {
				dist[i] = Integer.MAX_VALUE;
				sptSet[i] = false;
				// La distancia de los nodos cambia a infinito y visitado
				// inicia
				// en
				// false.
			}

			// Distancia desde el nodo actual.
			dist[G.getElementos().get(src[x])] = 0;

			// Encuentra la minima distancia de los vertices.
			for (int count = 0; count < V - 1; count++) {
				int u = minimaDistancia(dist, sptSet, V); // se toma la
															// distancia
															// del
															// nodo actual a
															// los
															// demás.
				sptSet[u] = true; // el nodo se marca como visitado
				for (int v = 0; v < V; v++)
					// La distancia del nodo actual a los adyacentes cambia.
					if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE
							&& dist[u] + graph[u][v] < dist[v]) {
						dist[v] = dist[u] + graph[u][v];
						M[u][v] = dist[v];
						M[v][u] = dist[v];
					}
			}
		}
		// Devuelve el arreglo con las distancias más cortas.
		return M;
	}

	private int minimaDistancia(int dist[], Boolean sptSet[], int v1) {
		V = v1;
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (sptSet[v] == false && dist[v] <= min) {
				min = dist[v];
				min_index = v;
			}

		return min_index;
	}

	@Override
	public int[][] FloydWarshall(Grafo<T> G) {
		// TODO Auto-generated method stub
		int INFINITO = Integer.MAX_VALUE;
		int[][] Distancias = new int[G.getCantidad()][G.getCantidad()];
		int i, j, k;
		for (i = 0; i < G.getCantidad(); i++) {
			for (j = 0; j < G.getCantidad(); j++) {
				Distancias[i][j] = G.darMatrizAdyacencia(G)[i][j];
				if ((i != j) && G.darMatrizAdyacencia(G)[i][j] == 0)
					Distancias[i][j] = INFINITO;
			}
		}
		for (k = 0; k < G.getCantidad(); k++) {
			for (i = 0; i < G.getCantidad(); i++) {
				for (j = 0; j < G.getCantidad(); j++) {
					if (Distancias[i][k] != INFINITO && Distancias[k][j] != INFINITO
							&& Distancias[i][k] + Distancias[k][j] < Distancias[i][j])
						Distancias[i][j] = Distancias[i][k] + Distancias[k][j];
				}

			}
		}

		return Distancias;
	}

	@Override
	public void recorridoAmplitud(Grafo<T> G, Nodo<T> ref) {
		// TODO Auto-generated method stub
		G.getNodos().get(ref.getElement()).setColor(Nodo.GRAY);
		G.getNodos().get(ref.getElement()).setDistancia(0);
		Queue<Nodo<T>> Q = new LinkedList<Nodo<T>>();
		Q.add(ref);
		while (!Q.isEmpty()) {
			Nodo<T> u = G.getNodos().get(Q.poll().getElement());
			for (int i = 0; i < u.getAdyacentes().size(); i++) {
				Adyacencia<T> h = u.getAdyacentes().get(i);
				Nodo<T> v = G.getNodos().get(h.getAdyacente().getElement());
				if (v.getColor() == Nodo.WHITE) {
					v.setColor(Nodo.GRAY);
					v.setDistancia(u.getDistancia() + 1);
					v.setPadre(u);
					Q.add(v);
				}
				u.setColor(Nodo.BLACK);
			}
		}
	}

	@Override
	public void recorridoProfundidad(Grafo<T> G) {
		// TODO Auto-generated method stub
		for (Iterator<T> iterator = G.getNodos().keySet().iterator(); iterator.hasNext();) {
			T type = (T) iterator.next();
			Nodo<T> u = G.getNodos().get(type);
			if (u.getColor() == Nodo.WHITE) {
				DFSVisit(G, u);
			}
		}

	}

	private void DFSVisit(Grafo<T> G, Nodo<T> u) {
		int time = 0;
		time = time + 1;
		G.getNodos().get(u.getElement()).setDistancia(time);
		G.getNodos().get(u.getElement()).setColor(Nodo.GRAY);
		for (int i = 0; i < u.getAdyacentes().size(); i++) {
			Adyacencia<T> h = u.getAdyacentes().get(i);
			Nodo<T> v = G.getNodos().get(h.getAdyacente().getElement());
			if (v.getColor() == Nodo.WHITE) {
				v.setPadre(u);
				DFSVisit(G, v);
			}
		}
		u.setColor(Nodo.BLACK);
		time = time + 1;
		u.setDistancia(time);
	}

	public int[] getDistancias() {
		return Distancias;
	}

	public void setDistancias(int[] distancias) {
		Distancias = distancias;
	}

}
