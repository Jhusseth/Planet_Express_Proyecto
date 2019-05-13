package maxHeap;

public class Heap<T extends Comparable<? super T>> extends Object {

	protected T element;

	public Heap(T objeto) {
		element = objeto;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

	public int compareTo(Heap<T> elem) {
		return element.compareTo(elem.element);
	}

}