package linkedlist;

public class DoublyLinkedList<T extends Comparable<T>> {

	DNode<T> head;

	public void insert(T data) {
		DNode<T> newNode = new DNode<>(data);
		if (head == null) {
			head = newNode;
			return;
		}

		DNode<T> curr = head;
		for (; curr.next != null && curr.data.compareTo(data) < 0; curr = curr.next)
			;

		if (curr == head && curr.data.compareTo(data) >= 0) { // insert first
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else if (curr.next == null) { // insert last
			newNode.prev = curr;
			curr.next = newNode;
		} else { // insert between
			newNode.next = curr;
			newNode.prev = curr.prev;
			curr.prev.next = newNode;
			curr.prev = newNode;
		}
	}

	public void recursiveInsert(T data) {
		recursiveInsert(data, head);
	}

	private void recursiveInsert(T data, DNode<T> curr) {
		if (curr != null && curr.next != null && curr.data.compareTo(data) < 0)
			recursiveInsert(data, curr.next);
		else {
			DNode<T> newNode = new DNode<>(data);
			if (head == null)
				head = newNode;
			else if (curr == head && curr.data.compareTo(data) >= 0) { // insert first
				newNode.next = head;
				head.prev = newNode;
				head = newNode;
			} else if (curr.next == null && curr.data.compareTo(data) < 0) { // insert last
				newNode.prev = curr;
				curr.next = newNode;
			} else { // insert between
				newNode.next = curr;
				newNode.prev = curr.prev;
				curr.prev.next = newNode;
				curr.prev = newNode;
			}
		}
	}

	public DNode<T> delete(T data) {
		DNode<T> curr = head;

		if (head == null)
			return null;

		for (; curr.next != null && curr.data.compareTo(data) < 0; 
				curr = curr.next);

		if (curr.data.compareTo(data) != 0)
			return null;

		if (curr == head)
			head = curr.next;
		else if (curr.next == null)
			curr.prev.next = null;
		else {
			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;
		}
		return curr;
	}
	
	public DNode<T> recursiveDelete(T data) {
		return recursiveDelete(data, head);
	}
	
	private DNode<T> recursiveDelete(T data, DNode<T> curr) {
		if (curr == null) return null;
		else if (curr.next == null || curr.data.compareTo(data) >= 0) {
			if (curr.data.compareTo(data) != 0)
				return null;
			if (curr == head)
				head = curr.next;
			else if (curr.next == null)
				curr.prev.next = null;
			else {
				curr.next.prev = curr.prev;
				curr.prev.next = curr.next;
			}
			return curr;
		}
		return recursiveDelete(data, curr.next);
	}

	public DNode<T> find(T data) {
		DNode<T> curr = head;

		if (head == null)
			return null;

		for (; curr.next != null && curr.data.compareTo(data) < 0; curr = curr.next)
			;

		if (curr.data.compareTo(data) != 0)
			return null;

		return curr;
	}

	public DNode<T> recursiveFind(T data) {
		return recursiveFind(data, head);
	}

	private DNode<T> recursiveFind(T data, DNode<T> curr) {
		if (curr == null)
			return null;
		else if (curr.next == null || curr.data.compareTo(data) >= 0)
			if (curr.data.compareTo(data) == 0)
				return curr;
		return recursiveFind(data, curr.next);
	}
	
	public void removeDuplicates() {
		DNode<T> curr = head;
		if (curr == null) return;
		DNode<T> itr = curr.next;
		while (itr != null) {
			if (itr.data == curr.data) {
				itr = itr.next;
				if (itr == null)
					curr.next = itr;
			} else {
				curr.next = itr;
				itr.prev = curr;
				curr = itr;
				itr = itr.next;
			}
		}
	}
	
	public void recursiveRemoveDuplicates() {
		if (head != null)
			recursiveRemoveDuplicates(head, head.next);
	}
	
	private void recursiveRemoveDuplicates(DNode<T> curr, DNode<T> itr) {
		if (curr == null) 
			return;
		else if (itr == null) {
			curr.next = itr;
			return;
		} else if (itr.data == curr.data) 
			recursiveRemoveDuplicates(curr, itr.next);
		else {
			curr.next = itr;
			itr.prev = curr;
			recursiveRemoveDuplicates(itr, itr.next);
		}
	}
	
	public void reverse() {
		DNode<T> curr = head;
		while (curr != null && curr.next != null) {
			DNode<T> temp = curr.next;
			curr.next = temp.next;
			head.prev = temp;
			temp.next = head;
			temp.prev = null;
			head = head.prev;
			temp = curr.next;
		}
	}

	public int length() {
		DNode<T> curr = head;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}

	public int recursiveLength() {
		return recursiveLength(head);
	}

	private int recursiveLength(DNode<T> curr) {
		if (curr == null)
			return 0;
		return 1 + recursiveLength(curr.next);
	}

	public void traverse() {
		DNode<T> curr = head;
		System.out.print("Head --> ");
		while (curr != null) {
			System.out.print(curr + " --> ");
			curr = curr.next;
		}
		System.out.println("Null");
	}
	
	public void recursiveTraverse() {
		System.out.print("Head --> ");
		recursiveTraverse(head);
		System.out.println("Null");
	}
	
	private void recursiveTraverse(DNode<T> curr) {
		if (curr == null) return;
		System.out.print(curr + " --> ");
		recursiveTraverse(curr.next);
	}

	public void backwardReverse() {
		DNode<T> curr = head;
		
		while (curr != null && curr.next != null) 
			curr = curr.next;
		
		System.out.print("Tail --> ");
		while (curr != null) {
			System.out.print(curr + " --> ");
			curr = curr.prev;
		}
		System.out.println("Null");
	}
	
	public void recursiveBackwardReverse() {
		System.out.print("Tail --> ");
		recursiveBackwardReverse(head);
		System.out.println("Null");
	}

	private void recursiveBackwardReverse(DNode<T> curr) {
		if (curr == null) return;
		recursiveBackwardReverse(curr.next);
		System.out.print(curr + " --> ");
	}

}
