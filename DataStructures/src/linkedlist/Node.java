package linkedlist;

public class Node<T extends Comparable<T>> {
	
	public T data;
	public Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
}
