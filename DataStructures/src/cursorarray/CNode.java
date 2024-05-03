package cursorarray;

public class CNode<T extends Comparable<T>> {
	
	private T data;
	private int next;
	
	
	public CNode(T data, int next) {
		this.data = data;
		this.next = next;
	}
	
	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public CNode(T data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "[" + data + " |" + next + "]";
	}
	
}
