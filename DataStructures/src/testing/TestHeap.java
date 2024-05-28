package testing;

import heap.MaxHeap;
import heap.MinHeap;

public class TestHeap {

	public static void main(String[] args) {

		Integer[] a = { 0, 55, 60, 70, 80, 20 };

		MaxHeap.maxHeapify(a);
		for (int i = 1; i < a.length; i++)
			System.out.print(a[i] + " ");

		System.out.println();

		MinHeap.minHeapify(a);
		for (int i = 1; i < a.length; i++)
			System.out.print(a[i] + " ");

	}

}
