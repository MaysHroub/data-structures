package testing;

import heap.MaxHeap;

public class TestHeap {

	public static void main(String[] args) {
		Integer[] a = {0, 55, 60, 70, 80, 20};
		// 55 80 70 60 20
		// 80 55 70 60 20
		// 80 60 70 55 20
		MaxHeap.heapify(a);
		for (int i = 1; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
	
	

}
