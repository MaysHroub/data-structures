package heap;

public interface MaxHeapInterface<T extends Comparable<T>> {
	
	void add(T data);
	T removeMax();
	T getMax();
	boolean isEmpty();
	int getSize();
	void clear();
	
}
