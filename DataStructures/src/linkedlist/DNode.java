package linkedlist;

public class DNode<T extends Comparable<T>> {
	
	T data;
	DNode<T> prev, next;
	
	public DNode(T data) {
		this.data = data;
	}

}
