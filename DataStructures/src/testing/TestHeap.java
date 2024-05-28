package testing;

import heap.MaxHeap;
import heap.MinHeap;

public class TestHeap {

	public static void main(String[] args) {

		Integer[] a = { 0, 55, 60, 70, 80, 20 };

		System.out.println("MaxHeap? " + MaxHeap.isMaxHeap(a));
		System.out.println("MinHeap? " + MinHeap.isMinHeap(a));
		
		MaxHeap.maxHeapify(a);
		for (int i = 1; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		
		System.out.println("MaxHeap? " + MaxHeap.isMaxHeap(a));
		System.out.println("MinHeap? " + MinHeap.isMinHeap(a));

		MinHeap.minHeapify(a);
		for (int i = 1; i < a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
		
		System.out.println("MaxHeap? " + MaxHeap.isMaxHeap(a));
		System.out.println("MinHeap? " + MinHeap.isMinHeap(a));

	}

}
