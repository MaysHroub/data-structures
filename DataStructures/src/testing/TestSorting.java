package testing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import data.Martyr;
import heap.MaxHeap;

public class TestSorting {

	public static void main(String[] args) {
		test4();
	}
	
	private static void test4() {
		String path = "C:\\Users\\ismae\\Downloads\\data (2).csv";
		ArrayList<Date> list = new ArrayList<>();
		try (Scanner in = new Scanner(new File(path))) {
			in.nextLine(); // 0.name, 1.event, 2.age, 3.location, 4.district, 5.gender
			while (in.hasNext()) {
				String[] tokens = in.nextLine().split(",");
				String[] dateInfo = tokens[1].split("/");
				@SuppressWarnings("deprecation")
				Date date = new Date(Integer.parseInt(dateInfo[2]) - 1900, Integer.parseInt(dateInfo[0]) - 1,
						Integer.parseInt(dateInfo[1]));
				list.add(date);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Date[] a1 = new Date[list.size()],
				a2 = new Date[list.size()],
				a3 = new Date[list.size()],
				a4 = new Date[list.size()];
		list.toArray(a1);
		list.toArray(a2);
		list.toArray(a3);
		list.toArray(a4);
		
		long insertionTime = 0, shellTime = 0, mergeTime = 0, quickTime = 0;
		long start;
		
		start = System.currentTimeMillis();
		insertionSort(a1);
		insertionTime = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		shellSort(a2);
		shellTime = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		mergeSort(a3);
		mergeTime = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		Arrays.sort(a4);
		quickTime = System.currentTimeMillis() - start;
		
		System.out.println("Sorting times in millis:");
		System.out.println("Insertion sort : " + insertionTime);
		System.out.println("Shell sort : " + shellTime);
		System.out.println("Merge sort : " + mergeTime);
		System.out.println("Quick sort : " + quickTime);
	}

	private static void test3() {
		int N = 10000;
		Integer[] a = new Integer[N];
		Random rand = new Random();
		
		long insertionTime = 0, shellTime = 0, mergeTime = 0, quickTime = 0;
		long start;
		
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			a[i] = rand.nextInt(100000);
		insertionSort(a);
		insertionTime = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			a[i] = rand.nextInt(100000);
		shellSort(a);
		shellTime = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			a[i] = rand.nextInt(100000);
		mergeSort(a);
		mergeTime = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		for (int i = 0; i < N; i++)
			a[i] = rand.nextInt(100000);
		Arrays.sort(a);
		quickTime = System.currentTimeMillis() - start;
		
		System.out.println("Sorting times in millis:");
		System.out.println("Insertion sort : " + insertionTime);
		System.out.println("Shell sort : " + shellTime);
		System.out.println("Merge sort : " + mergeTime);
		System.out.println("Quick sort : " + quickTime);
	}
	
	private static void test2() {
		String path = "C:\\Users\\ismae\\Downloads\\data (2).csv";
		ArrayList<Martyr> list = new ArrayList<>();
		try (Scanner in = new Scanner(new File(path))) {
			in.nextLine(); // 0.name, 1.event, 2.age, 3.location, 4.district, 5.gender
			while (in.hasNext()) {
				Martyr martyr = Martyr.constructMartyr(in.nextLine());
				if (martyr == null) continue;
				list.add(martyr);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Martyr[] a1 = new Martyr[list.size()],
				a2 = new Martyr[list.size()],
				a3 = new Martyr[list.size()],
				a4 = new Martyr[list.size()];
		list.toArray(a1);
		list.toArray(a2);
		list.toArray(a3);
		list.toArray(a4);
		
		long insertionTime = 0, shellTime = 0, mergeTime = 0, quickTime = 0;
		long start;
		
		start = System.currentTimeMillis();
		insertionSort(a1);
		insertionTime = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		shellSort(a2);
		shellTime = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		mergeSort(a3);
		mergeTime = System.currentTimeMillis() - start;
		
		start = System.currentTimeMillis();
		Arrays.sort(a4);
		quickTime = System.currentTimeMillis() - start;
		
		System.out.println("Sorting times in millis:");
		System.out.println("Insertion sort : " + insertionTime);
		System.out.println("Shell sort : " + shellTime);
		System.out.println("Merge sort : " + mergeTime);
		System.out.println("Quick sort : " + quickTime);
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
