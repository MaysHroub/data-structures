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
		for (; curr.next != null && curr.data.compareTo(data) < 0;
				curr = curr.next);
		
		if (curr == head) { // insert first
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		}
		else if (curr.next == null) { // insert last
			newNode.prev = curr;
			curr.next = newNode;
		}
		else { // insert between
			newNode.next = curr;
			newNode.prev = curr.prev;
			curr.prev.next = newNode;
			curr.prev = newNode;
		}
	}
	
	
	public DNode<T> delete(T data) {
		DNode<T> curr = head;
		for (; curr.next != null && curr.data.compareTo(data) < 0;
				curr = curr.next);
		
		if (curr.data.compareTo(data) != 0)
			return null;
		
		if (curr == head) 
			head = curr.next;
		else if (curr.next == null)
			curr.prev = null;
		else {
			curr.next.prev = curr.prev;
			curr.prev.next = curr.next;
		}
		return curr;
	}
	
}




