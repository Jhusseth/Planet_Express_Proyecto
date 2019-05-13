package maxHeap;

public interface ImaxHeap<T extends Comparable<? super T>> {

	public void MaxHeapify(Heap<T>[] A, int i);

	public void BuildMaxHeap(Heap<T>[] A);

}