package heap;

public class MaxHeap<T extends Comparable<T>> implements MaxHeapInterface<T> {

	private T[] arr;
	private int N;
	
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
			swap(k/2, k);
			k /= 2;
		}
	}
	
	private boolean less(int p, int c) {
		return arr[p].compareTo(arr[c]) < 0;
	}
	
	private void swap(int p, int c) {
		T temp = arr[p];
		arr[p] = arr[c];
		arr[c] = temp;
	}
	
}
