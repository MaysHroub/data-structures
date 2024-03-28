package stack;

public class LinkedListStack<T> implements Stackable<T> {

	private class Node<T> {
		T data;
		Node<T> next;
		Node(T data) {
			this.data = data;
		}
	}
	
	@Override
	public void push(T data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
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
