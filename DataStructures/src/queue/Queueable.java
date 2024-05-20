package queue;

public interface Queueable<T extends Comparable<T>> {
	
	void enqueue(T data);
	T dequeue();
	T getFront();
	boolean isEmpty();
	void clear();
	
}
