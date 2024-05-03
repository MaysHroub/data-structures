package stack;

public class LinkedListStack<T extends Comparable<T>> implements Stackable<T> {

	private class Node<T> {
		T data;
		Node<T> next;
		Node(T data) {
			this.data = data;
		}
	}
	
	private Node<T> head;
	
	@Override
	public void push(T data) {
		Node<T> newNode = new Node<>(data);
		if (isEmpty())
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
	}

	@Override
	public T pop() {
		if (isEmpty()) return null;
		T temp = head.data;
		head = head.next;
		return temp;
	}

	@Override
	public T peek() {
		if (isEmpty()) return null;
		return head.data;
	}

	@Override
	public boolean isEmpty() {
		return head == null;
	}

	@Override
	public void clear() {
		head = null;
	}

}
