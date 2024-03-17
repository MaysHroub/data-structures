package linkedlist;

public class LinkedList<T extends Comparable<T>> {
	
	Node<T> head;
	
	
	public void insert(T data) {
		Node<T> newNode = new Node<>(data);
		
		if (head == null) {
			head = newNode;
			return;
		}
		
		Node<T> prev = null, curr = head;
		for (; curr != null && curr.data.compareTo(data) < 0;
				prev = curr, curr = curr.next);
		
		if (prev == null /*or curr == head*/) {  // insert first
			newNode.next = head;
			head = newNode;
		}
		else if (curr == null)   // insert last
			prev.next = newNode;
		else {                   // insert between
			newNode.next = curr;
			prev.next = newNode;
		}
	}
	
}











