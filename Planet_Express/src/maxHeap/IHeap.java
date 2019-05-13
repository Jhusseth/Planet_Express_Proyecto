package maxHeap;

public interface IHeap<T extends Comparable<? super T>> extends ImaxHeap<T> {

	public int Parent(int i);

	public int Left(int i);

	public int Right(int i);

	public Heap<T>[] HeapSort(Heap<T>[] A);

}
