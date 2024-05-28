package heap;

public class MaxHeap<T extends Comparable<T>> implements MaxHeapInterface<T> {

	private T[] arr;
	private int N;
	
	@SuppressWarnings("unchecked")
	public MaxHeap(int size) {
		arr = (T[]) new Comparable[size + 1];
	}
	
	@Override
	public void add(T data) {
		arr[++N] = data;
		swim(N);
	}

	@Override
	public T removeMax() {
		T max = arr[1];
		swap(1, N--);
		sink(1);
		arr[N+1] = null; // prevent loitering ??
		return max;
	}

	@Override
	public T getMax() {
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
	
	private void sink(int k) {
		while (2*k <= N) {
			int j = 2*k;
			if (j < N && less(j, j+1)) j++;
			if (!less(k, j)) break;
			swap(k, j);
			k = j;
		}
	}
	
	public static boolean isMaxHeap(Comparable[] a) {
		int N = a.length;
		for (int i = 1; i <= N/2; i++) {
			int lc = i*2, rc = lc + 1;
			if (lc < N && a[i].compareTo(a[lc]) < 0) return false;
			if (rc < N && a[i].compareTo(a[rc]) < 0) return false;
		}
		return true;
	}
	
	public static void heapSortAsc(Comparable[] a) {
		int N = a.length - 1;
		Comparable temp;
		
		maxHeapify(a);  // to a max-heap
		
		while (N > 1) {
			// 1. Swap the first element with the last element
			temp = a[1];
			a[1] = a[N];
			a[N] = temp;
			
			// 2. decrement N
			N--;
			
			// 3. sink[1]
			int k = 1;
			while (2*k <= N) {
				int j = 2*k;
				if (j < N && a[j].compareTo(a[j+1]) < 0) j++;
				if (a[k].compareTo(a[j]) >= 0) break;
				temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k = j;
			}
		}
	}
	
	public static void maxHeapify(Comparable[] a) {
		int N = a.length - 1, i = N / 2;
		Comparable temp;
		while (i-- > 0) {
			int k = i+1;
			while (2*k <= N) {
				int j = 2*k;
				if (j < N && a[j].compareTo(a[j+1]) < 0) j++;
				if (a[k].compareTo(a[j]) >= 0) break;
				temp = a[k];
				a[k] = a[j];
				a[j] = temp;
				k = j;
			}
		}
	}
	
}














