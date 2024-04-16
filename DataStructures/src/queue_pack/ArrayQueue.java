package queue_pack;

import java.lang.reflect.Array;

public class ArrayQueue<T extends Comparable<T>> {
	
	private int front, back; // front pointer is not necessary...
	private T[] arr; // or make it of Comparable type
	
	
	@SuppressWarnings("unchecked")
	public ArrayQueue(Class<T> clazz, int size) {
		arr = (T[]) Array.newInstance(clazz, size);
		front = -1;
		back = -1;
	}
	
	public void enqueue(T data) {
		if (isEmpty()) { // empty
			arr[0] = data;
			front++; back++;
		} 
		else if (back < arr.length - 1)  // not full
			arr[++back] = data;
	}
	
	public T dequeue() {
		if (isEmpty()) return null;
		T temp = arr[front];
		for (int i = 0; i < back; i++)
			arr[i] = arr[i+1];
		back--;
		return temp;
	}
	
	public T getFront() {
		if (isEmpty()) return null;
		return arr[front];
	}
	
	public boolean isEmpty() {
		return front == -1 && back == -1;
	}
	
	public void clear() {
		front = -1;
		back = -1;
	}

}
