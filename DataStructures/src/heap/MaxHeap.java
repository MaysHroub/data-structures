package heap;

public class MaxHeap<T extends Comparable<T>> implements MaxHeapInterface<T> {

	private T[] arr;
	
	@SuppressWarnings("unchecked")
	public MaxHeap(int size) {
		arr = (T[]) new Comparable[size];
	}
	
	@Override
	public void add(T data) {
		
	}

	@Override
	public T removeMax() {
		return null;
	}

	@Override
	public T getMax() {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public int getSize() {
		return 0;
	}

	@Override
	public void clear() {
		
	}
	
	private void swim(int k) {
		while (k > 1 && less(k/2, k)) {
			swap(k, k/2);
			k /= 2;
		}
	}
	
}