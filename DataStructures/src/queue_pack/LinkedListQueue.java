package queue_pack;

import linkedlist.Node;

public class LinkedListQueue<T extends Comparable<T>> {
	
	private Node<T> front, back;
	
	
	public void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty()) 
			front = newNode;
		else
			newNode.next = back;
		back = newNode;
	}
	
	public T dequeue() {
		if (isEmpty()) return null;
		T temp = front.data;
		front = front.next;
		return temp;
	}
	
	public T getFront() {
		if (isEmpty()) return null;
		return front.data;
	}
	
	public boolean isEmpty() {
		return front == null && back == null;
	}
	
	public void clear() {
		front = null;
		back = null;
	}
}
