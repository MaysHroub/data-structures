package cursorarray;

public class CursorArray<T extends Comparable<T>> {

	private CNode<T>[] arr;
	
	public CursorArray(int size) {
		arr = new CNode[size];
		init();
	}
	
	private void init() {
		for (int i = 0; i < arr.length - 1; i++)
			arr[i] = new CNode<>(null, i + 1);
		arr[arr.length - 1] = new CNode<>(null, 0);
	}
	
	public int malloc() {
		int p = arr[0].next;
		arr[0].next = arr[p].next;
		return p;
	}
	
	public void free(int p) {
		arr[p].next = arr[0].next;
		arr[0].next = p;
	}
	
	public int createList() {
		int l = malloc();
		if (l == 0) 
			System.out.println("Out of space");
		else 
			arr[l].next = 0;
		return l;
	}
	
	public boolean isLast(int p) {
		return arr[p].next == 0;
	}
	
	public boolean isEmpty(int l) {
		return arr[l].next == 0;
	}
	
	public void insertAtHead(T data, int l) {
		int p = malloc();
		if (p == 0) {
			System.out.println("Out of space");
			return;
		}
		arr[p].data = data;
		arr[p].next = arr[l].next;
		arr[l].next = p;
	}
	
	public void insertAtTail(T data, int l) {
		int p = malloc();
		if (p == 0) {
			System.out.println("Out of space");
			return;
		}
		for (; !isLast(l); l = arr[l].next);
		arr[p].data = data;
		arr[p].next = arr[l].next; // arr[p].next = 0
		arr[l].next = p;
	}
	
	public void traverse(int l) {
		if (l == 0) {
			System.out.println("No such list");
			return;
		}
		System.out.print("Head -> ");
		while (!isLast(l)) {
			System.out.print(arr[l] + " -> ");
			l = arr[l].next;
		}
		System.out.print(arr[l] + " -> ");
		System.out.println("Null");
	}
	
}
