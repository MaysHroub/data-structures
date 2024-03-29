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
	
	private void recursiveInit() {
		recursiveInit(0, arr.length);
	}
	
	private void recursiveInit(int i, int length) {
		if (i == length - 1) arr[i] = new CNode<>(null, 0);
		else {
			arr[i] = new CNode<>(null, i + 1);
			recursiveInit(i+1, length);
		}
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
	
	public void insertSorted(T data, int l) {
		int p = malloc();
		if (p == 0) {
			System.out.println("Out of space");
			return;
		}
		arr[p].data = data;
		if (isEmpty(l)) {
			arr[p].next = arr[l].next;
			arr[l].next = p;
			return;
		}
		int curr = arr[l].next, prev = 0;
		for (; curr != 0 && arr[curr].data.compareTo(data) < 0; prev = curr, curr = arr[curr].next);
		if (prev == 0) {      // insert first
			arr[p].next = arr[l].next;
			arr[l].next = p;
		} else if (curr == 0) {      // insert last
			arr[p].next = arr[prev].next;  // = 0
			arr[prev].next = p;
		} else {      // insert between  
			arr[p].next = curr;
			arr[prev].next = p;
		}
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
	
	public void recursiveInsertAtTail(T data, int l) {
		int p = malloc(); 
		if (p == 0) {
			System.out.println("Out of space");
			return;
		}
		recursiveInsertAtTail(data, l, p);
	}
	
	private void recursiveInsertAtTail(T data, int l, int p) {
		if (isLast(l)) {
			arr[p].data = data;
			arr[p].next = arr[l].next; // arr[p].next = 0
			arr[l].next = p;
			return;
		}
		recursiveInsertAtTail(data, arr[l].next, p);
	}
	
	public CNode<T> deleteFromHead(int l) {
		if (isEmpty(l)) return null;
		int p = arr[l].next;
		arr[l].next = arr[p].next;
		free(p);
		return arr[p];
	}
	
	public CNode<T> deleteFromTail(int l) {
		if (isEmpty(l)) return null;
		int prev = l;
		for (; !isLast(l); prev = l, l = arr[l].next);
		arr[prev].next = 0;
		free(l);
		return arr[l];
	}
	
	public CNode<T> recursiveDeleteFromTail(int l) {
		return recursiveDeleteFromTail(l, l);
	}
	
	private CNode<T> recursiveDeleteFromTail(int l, int prev) {
		if (isLast(l)) {
			arr[prev].next = 0;
			free(l);
			return arr[l];			
		}
		return recursiveDeleteFromTail(arr[l].next, l);
	}
	
	public int find(T data, int l) {
		while (!isLast(l)) {
			l = arr[l].next;
			if (arr[l].data.equals(data))
				return l;
		}
		return -1;
	}
	
	public int recursiveFind(T data, int l) {
		if (!isLast(l)) 
			if (arr[arr[l].next].data.equals(data))
				return arr[l].next;
			else
				return recursiveFind(data, arr[l].next);
		return -1;
	}
	
	public int findPrevious(T data, int l) {
		while (!isLast(l)) {
			if (arr[arr[l].next].data.equals(data))
				return l;
			l = arr[l].next;
		}
		return -1;
	}
	
	public int recursiveFindPrevious(T data, int l) {
		if (!isLast(l)) 
			if (arr[arr[l].next].data.equals(data))
				return l;
			else
				return recursiveFindPrevious(data, arr[l].next);
		return -1;
	}
	
	public void traverse(int l) {
		System.out.print("Head --> ");
		while (!isLast(l)) {
			l = arr[l].next;
			System.out.print(arr[l] + " --> ");
		}
		System.out.println("Null");
	}
	
	public void recursiveTraverse(int l) {
		System.out.print("Head --> ");
		helperRecursiveTraverse(l);
		System.out.println("Null");
	}
	
	private void helperRecursiveTraverse(int l) {
		if (!isLast(l)) {
			System.out.print(arr[arr[l].next] + " --> ");
			helperRecursiveTraverse(arr[l].next);
		}
	}

	public int length(int l) {
		int c = 0;
		while (!isLast(l)) {
			c++;
			l = arr[l].next;
		}
		return c;
	}
	
	public int recursiveLength(int l) {
		if (isLast(l)) return 0;
		return 1 + recursiveLength(arr[l].next);
	}
	
	public void removeList(int l) {
		while (l != 0) {
			int next = arr[l].next;
			free(l);
			l = next;
		}
	}
	
	public void recursiveRemoveList(int l) {
		if (l != 0) {
			recursiveRemoveList(arr[l].next);
			free(l);
		}
	}
	
	public int merge(int l1, int l2) {
		int resList = malloc();
		if (resList == 0) return 0;
		l1 = arr[l1].next; l2 = arr[l2].next;
		while (l1 != 0) {
			if (l2 != 0 && arr[l2].data.compareTo(arr[l1].data) < 0) {
				insertAtTail(arr[l2].data, resList);
				l2 = arr[l2].next;
			} else {
				insertAtTail(arr[l1].data, resList);
				l1 = arr[l1].next;
			}
		}
		while (l2 != 0) {
			insertAtTail(arr[l2].data, resList);
			l2 = arr[l2].next;
		}
		return resList;
	}
	
	public void mergeIntoFirstList(int l1, int l2) {
		int prev = l1;
		l1 = arr[l1].next;
		int temp = arr[l2].next;
		free(l2);
		l2 = temp;
		while (l1 != 0 && prev != l1) 
			if (l2 != 0 && arr[l2].data.compareTo(arr[l1].data) < 0) {
				int nextL2 = arr[l2].next;
				arr[prev].next = l2;
				arr[l2].next = l1;
				prev = l2;
				l2 = nextL2;
			} 
			else {
				prev = l1;
				l1 = arr[l1].next;
			}
		
		if (l2 != 0) 
			arr[prev].next = l2;
	}

	
}