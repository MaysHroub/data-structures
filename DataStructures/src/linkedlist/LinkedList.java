package linkedlist;


public class LinkedList<T extends Comparable<T>> {

	private Node<T> head;
	
	public void insertSorted(T data) {
		Node<T> newNode = new Node<>(data);
		
		if (head == null) {
			head = newNode;
			return;
		}
		
		Node<T> prev = null, curr = head;
		for (; curr != null && curr.getData().compareTo(data) < 0;
				prev = curr, curr = curr.getNext());
		
		if (prev == null /*or curr == head*/) {  // insert first
			newNode.setNext(head);
			head = newNode;
		}
		else if (curr == null)   // insert last
			prev.setNext(newNode);
		else {                   // insert between
			newNode.setNext(curr);
			prev.setNext(newNode);
		}
	}
	
	public void recursiveInsert(T data) {
		recursiveInsert(data, null, head);
	}
	
	private void recursiveInsert(T data, Node<T> prev, Node<T> curr) {
		if (curr == null || curr.getData().compareTo(data) >= 0) {
			Node<T> newNode = new Node<>(data);
			if (prev == null /*or curr == head*/) {  // insert first
				newNode.setNext(head);
				head = newNode;
			}
			else if (curr == null)   // insert last
				prev.setNext(newNode);
			else {                   // insert between
				newNode.setNext(curr);
				prev.setNext(newNode);
			}
		}
		else
			recursiveInsert(data, curr, curr.getNext());
	}
	
	public Node<T> find(T data) {
		Node<T> curr = head;
		for (; curr != null && curr.getData().compareTo(data) < 0;
				curr = curr.getNext());
		if (curr != null && curr.getData().compareTo(data) == 0)
			return curr;
		return null;
	}
	
	public Node<T> recursiveFind(T data) {
		return recursiveFind(data, head);
	}
	
	private Node<T> recursiveFind(T data, Node<T> curr) {
		if (curr == null || curr.getData().compareTo(data) > 0) 
			return null;
		if (curr != null && curr.getData().compareTo(data) == 0)
			return curr;
		return recursiveFind(data, curr.getNext());
	}
	
	public Node<T> delete(T data) {
		Node<T> prev = null, curr = head;
		for (; curr != null && curr.getData().compareTo(data) < 0;
				prev = curr, curr = curr.getNext());
		if (curr != null && curr.getData().compareTo(data) == 0) {
			if (prev == null)  // delete the first node
				head = curr.getNext();
			else                // delete a middle node or the last one
				prev.setNext(curr.getNext());
			return curr;
		}
		return null;
	}
	
	public Node<T> recursiveDelete(T data) {
		return recursiveDelete(data, null, head);
	}
	
	private Node<T> recursiveDelete(T data, Node<T> prev, Node<T> curr) {
		if (curr == null || curr.getData().compareTo(data) > 0)
			return null;
		if (curr != null && curr.getData().compareTo(data) == 0) {
			if (prev == null)  // delete the first node
				head = curr.getNext();
			else                // delete a middle node or the last node
				prev.setNext(curr.getNext());
			return curr;
		}
		return recursiveDelete(data, curr, curr.getNext());
	}
	
	public int length() {
		int count = 0;
		Node<T> curr = head;
		while (curr != null) {
			count++;
			curr = curr.getNext();
		}
		return count;
	}
	
	public void reverse() {
		Node<T> curr = head;
		while (curr != null && curr.getNext() != null) {
			Node<T> temp = curr.getNext();
			curr.setNext(curr.getNext().getNext());
			temp.setNext(head);
			head = temp;
		}
	}
	
	public void recursiveReverse() {
		recursiveReverse(head);
	}
	
	private void recursiveReverse(Node<T> curr) {
		if (curr == null || curr.getNext() == null) return;
		Node<T> temp = curr.getNext();
		curr.setNext(curr.getNext().getNext());
		temp.setNext(head);
		head = temp;
		recursiveReverse(curr);
	}
	
	public void traverse() {
		Node<T> curr = head;
		System.out.print("Head --> ");
		while (curr != null) {
			System.out.print(curr + " --> ");
			curr = curr.getNext();
		}
		System.out.println("Null");
	}
	
	@Override
	public String toString() {
		Node<T> curr = head;
		String linkedlist = "Head --> ";
		while (curr != null) {
			linkedlist += curr + " --> ";
			curr = curr.getNext();
		}
		return linkedlist + "Null";
	}
	
	
}

