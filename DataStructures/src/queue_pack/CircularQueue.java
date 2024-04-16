package queue_pack;

import java.lang.reflect.Array;

public class CircularQueue<T extends Comparable<T>> {

	private int count, front, back; 
	private T[] arr; // or make it of Comparable type
	
	
	@SuppressWarnings("unchecked")
	public CircularQueue(Class<T> clazz, int size) {
		arr = (T[]) Array.newInstance(clazz, size);
		front = -1;
		back = -1;
	}
	
	public void enqueue(T data) {
		if (count < arr.length) {
			back = ++back % (arr.length);
			arr[back] = data;
			++count;
			if (count == 1) front = back;
		}
	}
	
	public T dequeue() {
		if (count > 0) {
			T temp = arr[front];
			front = ++front % arr.length;
			--count;
			if (count == 0) front = back = -1;
			return temp;
		}
		return null;
	}
	
	public T getFront() {
		if (count == 0) return null;
		return arr[front];
	}
	
	public boolean isEmpty() { return count == 0; }
	
	public void clear() { count = 0; }
	
}
