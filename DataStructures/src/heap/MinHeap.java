package heap;

public class MinHeap<T extends Comparable<T>> implements MinHeapInterface<T> {

	private T[] arr;
	private int N;
	
	@Override
	public void add(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T removeMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getMin() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
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
