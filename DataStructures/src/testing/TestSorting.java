package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import heap.MaxHeap;

public class TestSorting {

	public static void main(String[] args) {
		String path = "C:\\Users\\ismae\\Downloads\\data (2).csv";
		int N = 9973;
		Martyr[] a1 = new Martyr[N],
				a2 = new Martyr[N],
				a3 = new Martyr[N],
				a4 = new Martyr[N];
		try (Scanner in = new Scanner(new File(path))) {
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static void test1() {
		int N = 100000;
		Integer[] a = new Integer[N];
		
		Random rand = new Random();
		for (int i = 0; i < N; i++)
			a[i] = rand.nextInt(100000);
		
		long heapTime = 0, mergeTime = 0, quickTime = 0;
		long start;
		start = System.currentTimeMillis();
		mergeSort(a);
		mergeTime = System.currentTimeMillis() - start;
		
		for (int i = 0; i < N; i++)
			a[i] = rand.nextInt(100000);
		
		start = System.currentTimeMillis();
		MaxHeap.heapSortAsc(a);
		heapTime = System.currentTimeMillis() - start;
		
		for (int i = 0; i < N; i++)
			a[i] = rand.nextInt(100000);
		
		start = System.currentTimeMillis();
		Arrays.sort(a);
		quickTime = System.currentTimeMillis() - start;
		
		System.out.println("Sorting times in millis:");
		System.out.println("Heap sort : " + heapTime);
		System.out.println("Merge sort : " + mergeTime);
		System.out.println("Quick sort : " + quickTime);
	}
	
	public static void mergeSort(Comparable[] data) {
		sort(data, 0, data.length - 1);
	}

	private static void sort(Comparable[] data, int left, int right) {
		if (left < right) {
			int m = (left + right) / 2; 
			sort(data, left, m); 
			sort(data, m + 1, right);  
			merge(data, left, m, right); 
		}
	}

	private static void merge(Comparable[] data, int left, int m, int right) {
		int n1 = m - left + 1;
		int n2 = right - m;
		Comparable[] leftArr = new Comparable[n1];
		Comparable[] rightArr = new Comparable[n2];
		for (int i = 0; i < n1; ++i)
			leftArr[i] = data[left + i];
		for (int j = 0; j < n2; ++j)
			rightArr[j] = data[m + 1 + j];
		int i = 0, j = 0;
		int k = left;
		while (i < n1 && j < n2) {
			if (leftArr[i].compareTo(rightArr[j]) <= 0) {
				data[k] = leftArr[i];
				i++;
			} else {
				data[k] = rightArr[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			data[k] = leftArr[i];
			i++;
			k++;
		}
		while (j < n2) {
			data[k] = rightArr[j];
			j++;
			k++;
		}
	}
	
	public static void shellSort(Comparable[] a) {
		int N = a.length;
		int h = 1;
		while (h < N/3) h = 3*h + 1;
		while (h >= 1) {
			for (int i = h; i < N; i++)
				for (int j = i; j >= h && a[j].compareTo(a[j-h]) < 0; j -= h) {
					Comparable temp = a[j];
					a[j] = a[j-h];
					a[j-h] = temp;
				}
			h /= 3;
		}
	}
	
	public static void insertionSort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++)
			for (int j = i; j > 0; j--)
				if (a[j].compareTo(a[j-1]) < 0) {
					Comparable temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
				else break;
	}

}
