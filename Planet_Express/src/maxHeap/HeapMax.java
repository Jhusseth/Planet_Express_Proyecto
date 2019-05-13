package maxHeap;

public class HeapMax<T extends Comparable<? super T>> implements IHeap<T> {

	protected final static int TAMANIO = 20;
	protected final static int CRECIMINETO = 20;
	protected int size;
	protected Heap<T>[] heap;

	@SuppressWarnings("unchecked")
	public HeapMax(int capacidad) {
		heap = new Heap[capacidad];
		size = 0;
	}

	public HeapMax() {
		this(TAMANIO);
	}

	public T darPrimero() {
		T primero = null;
		if (size > 0) {
			primero = heap[0].getElement();
		}
		return primero;
	}

	@SuppressWarnings("unchecked")
	public void insertar(T elemento) {
		// Verifica si hay que aumentar el tamaño de la representación
		if (size == heap.length) {
			Heap<T> viejo[] = heap;
			heap = new Heap[heap.length + CRECIMINETO];
			System.arraycopy(viejo, 0, heap, 0, viejo.length);
		}

		Heap<T> aux = new Heap<T>(elemento);
		size++;
		int nuevo = size - 1; // Indice inicial del nuevo elemento
		int padre = ((nuevo + 1) / 2) - 1; // Indice del padre del nuevo
											// elemento

		if (size == 1) {
			padre = 0;
		}

		// Localice el sitio en el que debe ser insertado en elemento
		while (padre >= 0 && nuevo > 0 && aux.compareTo(heap[padre]) < 0) {
			heap[nuevo] = heap[padre];
			nuevo = padre;
			padre = ((nuevo + 1) / 2) - 1;
		}

		heap[nuevo] = aux;
	}

	@Override
	public void MaxHeapify(Heap<T>[] a, int i) {
		int largest = 0;
		int l = Left(i);
		int r = Right(i);
		if ((l <= getSize() - 1) && (a[l].compareTo(a[i]) > 0)) {
			largest = l;
		} else {
			largest = i;
		}
		if ((r <= getSize() - 1) && (a[r].compareTo(a[largest]) > 0)) {
			largest = r;
		}
		if (largest != i) {
			Heap<T> temporal = a[i];
			a[i] = a[largest];
			a[largest] = temporal;
			MaxHeapify(a, largest);
		}

	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public Heap<T>[] getHeap() {
		return heap;
	}

	public void setHeap(Heap<T>[] heap) {
		this.heap = heap;
	}

	@Override
	public void BuildMaxHeap(Heap<T>[] A) {
		int cantidad = Math.floorDiv(getSize() - 1, 2);
		for (int i = cantidad; i >= 0; i--) {
			MaxHeapify(A, i);
		}

	}

	@Override
	public int Parent(int i) {
		return Math.floorDiv(i, 2);
	}

	@Override
	public int Left(int i) {
		return (2 * i) + 1;
	}

	@Override
	public int Right(int i) {
		return (2 * i) + 2;
	}

	@Override
	public Heap<T>[] HeapSort(Heap<T>[] A) {
		int tamTemp = getSize();
		BuildMaxHeap(A);
		for (int i = getSize() - 1; i >= 1; i--) {
			Heap<T> temporal = A[0];
			A[0] = A[i];
			A[i] = temporal;
			setSize(size - 1);
			MaxHeapify(A, 0);
		}
		setSize(tamTemp);
		return A;
	}
}
