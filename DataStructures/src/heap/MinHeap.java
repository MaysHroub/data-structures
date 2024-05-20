package heap;

public class MinHeap<T extends Comparable<T>> implements MinHeapInterface<T> {

	private T[] arr;
	private int N;
	
	@Override
	public void add(T data) {
		arr[++N] = data;
		swim(N);
	}

	@Override
	public T removeMin() {
		T min = arr[1];
		swap(1, N--);
		sink(1);
		arr[N+1] = null; // prevent loitering ??
		return min;
	}

	@Override
	public T getMin() {
		return arr[1];
	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int getSize() {
		return N;
	}

	@Override
	public void clear() {
		N = 0;
	}
	
	private void swim(int k) {
		while (k > 1 && bigger(k/2, k)) {
			swap(k/2, k);
			k /= 2;
		}
	}
	
	private boolean bigger(int p, int c) {
		return arr[p].compareTo(arr[c]) > 0;
	}
	
	private void swap(int p, int c) {
		T temp = arr[p];
		arr[p] = arr[c];
		arr[c] = temp;
	}
	
	private void sink(int k) {
		while (2*k <= N) {
			int j = 2*k;
			if (j < N && bigger(j, j+1)) j++;
			if (!bigger(k, j)) break;
			swap(k, j);
			k = j;
		}
	}

}
