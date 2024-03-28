package stack;

public class LinkedListStack<T> implements Stackable<T> {

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		if (isEmpty()) return null;
		return head.data;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
