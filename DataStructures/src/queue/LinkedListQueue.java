package queue;


public class LinkedListQueue<T extends Comparable<T>> implements Queueable<T>{

	private class Node<T extends Comparable<T>> {
		T data;
		Node<T> next;
		Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> front, back;

	@Override
	public void enqueue(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty())
			front = newNode;
		else
			back.next = newNode;
		back = newNode;
	}

	@Override
	public T dequeue() {
		T temp = getFront();
		if (!isEmpty())
			front = front.next;
		if (front == null)
			back = null;
		return temp;

	}

	@Override
	public T getFront() {
		if (!isEmpty())
			return front.data;
		return null;
	}

	@Override
	public boolean isEmpty() {
		return (front == null) && (back == null);
	}

	@Override
	public void clear() {
		front = null;
		back = null;
	}
	
}
