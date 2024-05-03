package doublylinkedlist;


public class DNode<T extends Comparable<T>> {
	
	private T data;
	private DNode<T> prev, next;
	
	
	public DNode(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public DNode<T> getPrev() {
		return prev;
	}

	public void setPrev(DNode<T> prev) {
		this.prev = prev;
	}

	public DNode<T> getNext() {
		return next;
	}

	public void setNext(DNode<T> next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return data.toString();
	}
	
}
