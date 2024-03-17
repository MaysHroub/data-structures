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
	
	
	public void recursiveInsert(T data) {
		recursiveInsert(data, null, head);
	}
	
	private void recursiveInsert(T data, Node<T> prev, Node<T> curr) {
		if (curr == null || curr.data.compareTo(data) >= 0) {
			Node<T> newNode = new Node<>(data);
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
		recursiveInsert(data, curr, curr.next);
	}
	
	
	public Node<T> find(T data) {
		Node<T> curr = head;
		
		for (; curr != null && curr.data.compareTo(data) < 0;
				curr = curr.next);
		
		if (curr != null && curr.data.compareTo(data) == 0)
			return curr;
		
		return null;
	}
	
	
	public Node<T> recursiveFind(T data) {
		return recursiveFind(data, head);
	}
	
	private Node<T> recursiveFind(T data, Node<T> curr) {
		if (curr == null || curr.data.compareTo(data) > 0) 
			return null;
		if (curr != null && curr.data.compareTo(data) == 0)
			return curr;
		return recursiveFind(data, curr.next);
	}
	
	
	public Node<T> delete(T data) {
		Node<T> prev = null, curr = head;
		
		for (; curr != null && curr.data.compareTo(data) < 0;
				prev = curr, curr = curr.next);
		
		if (curr != null && curr.data.compareTo(data) == 0) {
			if (prev == null)  // delete the first node
				head = curr.next;
			else if (curr.next == null) // delete the last node
				prev.next = null;
			else                // delete a middle node
				prev.next = curr.next;
			return curr;
		}
		return null;
	}
	
	
	public Node<T> recursiveDelete(T data) {
		return recursiveDelete(data, null, head);
	}
	
	private Node<T> recursiveDelete(T data, Node<T> prev, Node<T> curr) {
		if (curr == null || curr.data.compareTo(data) > 0)
			return null;
		
		if (curr != null && curr.data.compareTo(data) == 0) {
			if (prev == null)  // delete the first node
				head = curr.next;
			else if (curr.next == null) // delete the last node
				prev.next = null;
			else                // delete a middle node
				prev.next = curr.next;
			return curr;
		}
		return recursiveDelete(data, curr, curr.next);
	}
	
	
	public void traverse() {
		Node<T> curr = head;
		System.out.print("Head --> ");
		while (curr != null) {
			System.out.print(curr + " --> ");
			curr = curr.next;
		}
		System.out.println("Null");
	}
	
	
}

