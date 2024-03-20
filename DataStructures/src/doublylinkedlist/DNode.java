package doublylinkedlist;

public class DNode<T extends Comparable<T>> {
	
	T data;
	DNode<T> prev, next;
	
	public DNode(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
}
