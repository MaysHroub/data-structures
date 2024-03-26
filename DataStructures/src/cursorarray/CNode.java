package cursorarray;

public class CNode<T extends Comparable<T>> {
	
	T data;
	int next;
	
	public CNode(T data) {
		this.data = data;
	}
	
	public CNode(T data, int next) {
		this.data = data;
		this.next = next;
	}
	
	@Override
	public String toString() {
		return "[" + data + " |" + next + "]";
	}
	
}
