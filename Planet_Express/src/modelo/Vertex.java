package modelo;

public class Vertex<E> implements Comparable<Vertex<E>> {
	
	private int location;
	private E data;
	
	public Vertex(E data) {
		this.data = data;
		++location;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	@Override
	public int compareTo(Vertex<E> v) {
		return this.compareTo(v);
	}
	

}
