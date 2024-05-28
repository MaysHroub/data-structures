package hashing;

import linkedlist.LinkedList;
import linkedlist.Node;

public class SHash<T extends Comparable<T>> {
	
	private LinkedList<T>[] table;
	private int size;
	
	@SuppressWarnings("unchecked")
	public SHash(int size) {
		this.size = size;
		table = new LinkedList[size];
		for (int i = 0; i < size; i++) 
			table[i] = new LinkedList<>();
	}
	
	public void add(T data) {
		int index = Math.abs(data.hashCode()) % size;
		table[index].insertSorted(data);
	}
	
	public Node<T> delete(T data) {
		int index = Math.abs(data.hashCode()) % size;
		return table[index].delete(data);
	}
	
	public Node<T> find(T data) {
		int index = Math.abs(data.hashCode()) % size;
		return table[index].find(data);
	}
	
	public void printLinkedList(int index) {
		if (index >= size) 
			System.out.println("Invalid index");
		else 
			table[index].traverse();
	}
	
	public void printAllLinkedLists() {
		for (int i = 0; i < size; i++) {
			System.out.print(i + " - ");
			table[i].traverse();
		}
	}
	
	public double avgLength() {
		int sum = 0;
		for (int i = 0; i < size; i++)
			sum += table[i].length();
		return (double) sum / size;
	}
	
}
