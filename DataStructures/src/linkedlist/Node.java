package linkedlist;

public class Node<T extends Comparable<T>> {
	
	T data;
	Node<T> next;
	
	public Node(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return data.toString();
	}
	
}
