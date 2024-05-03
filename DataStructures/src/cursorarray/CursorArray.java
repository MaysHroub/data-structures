package cursorarray;


public class CursorArray<T extends Comparable<T>> {

private CNode<T>[] arr;
	
	public CursorArray(int size) {
		arr = new CNode[size];
		init(); // recursiveInit()
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
		int p = arr[0].getNext();
		arr[0].setNext(arr[p].getNext());
		return p;
	}
	
	public void free(int p) {
		arr[p].setNext(arr[0].getNext());
		arr[0].setNext(p);
	}
	
	public int createList() {
		int l = malloc();
		if (l == 0) 
			System.out.println("Out of space");
		else 
			arr[l].setNext(0);
		return l;
	}
	
	public boolean isLast(int p) {
		return arr[p].getNext() == 0;
	}
	
	public boolean isEmpty(int l) {
		return arr[l].getNext() == 0;
	}
	
	public boolean insertSorted(T data, int l) {
		int p = malloc();
		if (p == 0) {
			System.out.println("Out of space");
			return false;
		}
		arr[p].setData(data);
		if (isEmpty(l)) {
			arr[p].setNext(arr[l].getNext());
			arr[l].setNext(p);
			return true;
		}
		int curr = arr[l].getNext(), prev = 0;
		for (; curr != 0 && arr[curr].getData().compareTo(data) < 0; prev = curr, curr = arr[curr].getNext());
		if (prev == 0) {      // insert first
			arr[p].setNext(arr[l].getNext());
			arr[l].setNext(p);
		} else if (curr == 0) {      // insert last
			arr[p].setNext(arr[prev].getNext());  // = 0
			arr[prev].setNext(p);
		} else {      // insert between  
			arr[p].setNext(curr);
			arr[prev].setNext(p);
		}
		return true;
	}
	
	public boolean insertAtHead(T data, int l) {
		int p = malloc();
		if (p == 0) {
			System.out.println("Out of space");
			return false;
		}
		arr[p].setData(data);
		arr[p].setNext(arr[l].getNext());
		arr[l].setNext(p);
		return true;
	}
	
	public boolean insertAtTail(T data, int l) {
		int p = malloc();
		if (p == 0) {
			System.out.println("Out of space");
			return false;
		}
		for (; !isLast(l); l = arr[l].getNext());
		arr[p].setData(data);
		arr[p].setNext(arr[l].getNext()); // arr[p].next = 0
		arr[l].setNext(p);
		return true;
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
			arr[p].setData(data);
			arr[p].setNext(arr[l].getNext()); // arr[p].next = 0
			arr[l].setNext(p);
			return;
		}
		recursiveInsertAtTail(data, arr[l].getNext(), p);
	}
	
	public CNode<T> deleteFromHead(int l) {
		if (isEmpty(l)) return null;
		int p = arr[l].getNext();
		arr[l].setNext(arr[p].getNext());
		free(p);
		return arr[p];
	}
	
	public CNode<T> deleteFromTail(int l) {
		if (isEmpty(l)) return null;
		int prev = l;
		for (; !isLast(l); prev = l, l = arr[l].getNext());
		arr[prev].setNext(0);
		free(l);
		return arr[l];
	}
	
	public CNode<T> recursiveDeleteFromTail(int l) {
		return recursiveDeleteFromTail(l, l);
	}
	
	private CNode<T> recursiveDeleteFromTail(int l, int prev) {
		if (isLast(l)) {
			arr[prev].setNext(0);
			free(l);
			return arr[l];			
		}
		return recursiveDeleteFromTail(arr[l].getNext(), l);
	}
	
	public CNode<T> delete(T data, int l) {
		int prev = findPrevious(data, l);
		if (prev == -1) return null;
		int idxOfNodeToDelete = arr[prev].getNext();
		CNode<T> nodeToDelete = arr[idxOfNodeToDelete];
		arr[prev].setNext(nodeToDelete.getNext());
		free(idxOfNodeToDelete);
		return nodeToDelete;
	}
	
	public int find(T data, int l) {
		while (!isLast(l)) {
			l = arr[l].getNext();
			if (arr[l].getData().equals(data))
				return l;
		}
		return -1;
	}
	
	public int recursiveFind(T data, int l) {
		if (!isLast(l)) 
			if (arr[arr[l].getNext()].getData().equals(data))
				return arr[l].getNext();
			else
				return recursiveFind(data, arr[l].getNext());
		return -1;
	}
	
	public int findPrevious(T data, int l) {
		while (!isLast(l)) {
			if (arr[arr[l].getNext()].getData().equals(data))
				return l;
			l = arr[l].getNext();
		}
		return -1;
	}
	
	public int recursiveFindPrevious(T data, int l) {
		if (!isLast(l)) 
			if (arr[arr[l].getNext()].getData().equals(data))
				return l;
			else
				return recursiveFindPrevious(data, arr[l].getNext());
		return -1;
	}
	
	public void traverse(int l) {
		System.out.print("Head [" + l + "] --> ");
		while (!isLast(l)) {
			l = arr[l].getNext();
			System.out.print(arr[l] + " --> ");
		}
		System.out.println("Null");
	}
	
	public void recursiveTraverse(int l) {
		System.out.print("Head [" + l + "] --> ");
		helperRecursiveTraverse(l);
		System.out.println("Null");
	}
	
	private void helperRecursiveTraverse(int l) {
		if (!isLast(l)) {
			System.out.print(arr[arr[l].getNext()] + " --> ");
			helperRecursiveTraverse(arr[l].getNext());
		}
	}

	public int length(int l) {
		int c = 0;
		while (!isLast(l)) {
			c++;
			l = arr[l].getNext();
		}
		return c;
	}
	
	public int recursiveLength(int l) {
		if (isLast(l)) return 0;
		return 1 + recursiveLength(arr[l].getNext());
	}
	
	public void removeList(int l) {
		while (l != 0) {
			int next = arr[l].getNext();
			free(l);
			l = next;
		}
	}
	
	public void recursiveRemoveList(int l) {
		if (l != 0) {
			recursiveRemoveList(arr[l].getNext());
			free(l);
		}
	}
	
	public int merge(int l1, int l2) {
		if (length(0) < length(l1) + length(l2) + 1) 
			return -1;
		int resList = malloc();
		l1 = arr[l1].getNext(); l2 = arr[l2].getNext();
		while (l1 != 0) {
			if (l2 != 0 && arr[l2].getData().compareTo(arr[l1].getData()) < 0) {
				insertAtTail(arr[l2].getData(), resList);
				l2 = arr[l2].getNext();
			} else {
				insertAtTail(arr[l1].getData(), resList);
				l1 = arr[l1].getNext();
			}
		}
		while (l2 != 0) {
			insertAtTail(arr[l2].getData(), resList);
			l2 = arr[l2].getNext();
		}
		return resList;
	}
	
	public void mergeIntoFirstList(int l1, int l2) {
		int prev = l1;
		l1 = arr[l1].getNext();
		int temp = arr[l2].getNext();
		free(l2);
		l2 = temp;
		while (l1 != 0 && prev != l1) 
			if (l2 != 0 && arr[l2].getData().compareTo(arr[l1].getData()) < 0) {
				int nextL2 = arr[l2].getNext();
				arr[prev].setNext(l2);
				arr[l2].setNext(l1);
				prev = l2;
				l2 = nextL2;
			} 
			else {
				prev = l1;
				l1 = arr[l1].getNext();
			}
		
		if (l2 != 0) 
			arr[prev].setNext(l2);
	}
	
	public void clear() {
		for (int i = 0; i < arr.length - 1; i++)
			arr[i].setNext(i + 1);
		arr[arr.length - 1].setNext(0);
	}
	

	public String listToString(int l) {
		String list = "Head [" + l + "] --> ";
		while (!isLast(l)) {
			l = arr[l].getNext();
			list += arr[l] + " --> ";
		}
		list += "Null";
		return list;
	}
	
}