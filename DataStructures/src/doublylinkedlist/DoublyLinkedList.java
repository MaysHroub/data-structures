package doublylinkedlist;

public class DoublyLinkedList<T extends Comparable<T>> {

	private DNode<T> head;

	public void insert(T data) {
		DNode<T> newNode = new DNode<>(data), curr = head;

		for (; curr != null && curr.getData().compareTo(data) < 0 && curr.getNext() != null; curr = curr.getNext());
		
		if (curr == null) // case 0: empty list
			head = newNode;
		else if (curr.getData().compareTo(data) >= 0 && curr.getPrev() == null) { // case 1: insert at first
			newNode.setNext(curr);
			curr.setPrev(newNode);
			head = newNode;
		} else if (curr.getData().compareTo(data) < 0 && curr.getNext() == null) { // case 3: insert at last
			newNode.setPrev(curr);
			curr.setNext(newNode);
		} else { // case 2: insert between
			newNode.setNext(curr);
			newNode.setPrev(curr.getPrev());
			curr.getPrev().setNext(newNode);
			curr.setPrev(newNode);
		}
	}

	public void recursiveInsert(T data) {
		recursiveInsert(data, head);
	}

	private void recursiveInsert(T data, DNode<T> curr) {
		if (curr != null && curr.getNext() != null && curr.getData().compareTo(data) < 0)
			recursiveInsert(data, curr.getNext());
		else {
			DNode<T> newNode = new DNode<>(data);
			if (head == null)
				head = newNode;
			else if (curr == head && curr.getData().compareTo(data) >= 0) { // insert first
				newNode.setNext(head);
				head.setPrev(newNode);
				head = newNode;
			} else if (curr.getNext() == null && curr.getData().compareTo(data) < 0) { // insert last
				newNode.setPrev(curr);
				curr.setNext(newNode);
			} else { // insert between
				newNode.setNext(curr);
				newNode.setPrev(curr.getPrev());
				curr.getPrev().setNext(newNode);
				curr.setPrev(newNode);
			}
		}
	}

	public DNode<T> delete(T data) {
		DNode<T> curr = head;

		for (; curr != null && curr.getData().compareTo(data) < 0;
				curr = curr.getNext());

		if (curr == null || curr.getData().compareTo(data) != 0)
			return null;

		if (curr.getPrev() == null && curr.getNext() == null) // delete 1 item
			head = null;
		else if (curr.getPrev() == null) { // delete the first item
			curr.getNext().setPrev(null);
			head = curr.getNext();
		}
		else if (curr.getNext() == null)  // delete the last item
			curr.getPrev().setNext(null);
		
		else {    // delete between                       
			curr.getNext().setPrev(curr.getPrev());
			curr.getPrev().setNext(curr.getNext());
		}
		return curr;
	}

	public DNode<T> recursiveDelete(T data) {
		return recursiveDelete(data, head);
	}

	private DNode<T> recursiveDelete(T data, DNode<T> curr) {
		if (curr == null || curr.getData().compareTo(data) > 0)
			return null;
		else if (curr.getData().compareTo(data) == 0) {
			if (curr.getPrev() == null && curr.getNext() == null) // delete 1 item
				head = null;
			else if (curr.getPrev() == null) { // delete the first item
				curr.getNext().setPrev(null);
				head = curr.getNext();
			}
			else if (curr.getNext() == null)  // delete the last item
				curr.getPrev().setNext(null);
			
			else {    // delete between                       
				curr.getNext().setPrev(curr.getPrev());
				curr.getPrev().setNext(curr.getNext());
			}
			return curr;
		}
		return recursiveDelete(data, curr.getNext());
	}

	public DNode<T> find(T data) {
		DNode<T> curr = head;

		if (head == null)
			return null;

		for (; curr.getNext() != null && curr.getData().compareTo(data) < 0; curr = curr.getNext());

		if (curr.getData().compareTo(data) != 0)
			return null;

		return curr;
	}

	public DNode<T> recursiveFind(T data) {
		return recursiveFind(data, head);
	}

	private DNode<T> recursiveFind(T data, DNode<T> curr) {
		if (curr == null)
			return null;
		else if (curr.getNext() == null || curr.getData().compareTo(data) >= 0)
			if (curr.getData().compareTo(data) == 0)
				return curr;
		return recursiveFind(data, curr.getNext());
	}

	public void removeDuplicates() {
		DNode<T> curr = head;
		if (curr == null)
			return;
		DNode<T> itr = curr.getNext();
		while (itr != null) {
			if (itr.getData() == curr.getData()) {
				itr = itr.getNext();
				if (itr == null)
					curr.setNext(itr);
			} else {
				curr.setNext(itr);
				itr.setPrev(curr);
				curr = itr;
				itr = itr.getNext();
			}
		}
	}
	
	public void removeDuplicates2() {
		DNode<T> curr = head;
		while (curr != null && curr.getNext() != null) {
			DNode<T> temp = curr.getNext();
			for (; temp != null && temp.getData().compareTo(curr.getData()) == 0;
					temp = temp.getNext());
			curr.setNext(temp);
			if (temp != null) temp.setPrev(curr);
			curr = curr.getNext();
		}
	}

	public void recursiveRemoveDuplicates() {
		if (head != null)
			recursiveRemoveDuplicates(head, head.getNext());
	}

	private void recursiveRemoveDuplicates(DNode<T> curr, DNode<T> itr) {
		if (curr == null)
			return;
		else if (itr == null) {
			curr.setNext(itr);
			return;
		} else if (itr.getData() == curr.getData())
			recursiveRemoveDuplicates(curr, itr.getNext());
		else {
			curr.setNext(itr);
			itr.setPrev(curr);
			recursiveRemoveDuplicates(itr, itr.getNext());
		}
	}

	public void reverse() {
		DNode<T> curr = head;
		while (curr != null && curr.getNext() != null) {
			DNode<T> temp = curr.getNext();
			curr.setNext(temp.getNext());
			head.setPrev(temp);
			temp.setNext(head);
			temp.setPrev(null);
			head = head.getPrev();
			temp = curr.getNext();
		}
	}
	
	public void reverse2() {
		DNode<T> curr = head, tempNext;
		while (curr != null) {
			head = curr;
			tempNext = curr.getNext();
			curr.setNext(curr.getPrev());
			curr.setPrev(tempNext);
			curr = tempNext;
		}
	}
	
	public static DNode reverseDLL(DoublyLinkedList dll) {
		DNode tempNext, curr = dll.head;
		while (curr != null) {
			dll.head = curr;
			tempNext = curr.getNext();
			curr.setNext(curr.getPrev());
			curr.setPrev(tempNext);
			curr = tempNext;
		}
		return dll.head;
	}

	public void recursiveReverse() {
		recursiveReverse(head);
	}

	private void recursiveReverse(DNode<T> curr) {
		if (curr == null || curr.getNext() == null)
			return;
		DNode<T> temp = curr.getNext();
		curr.setNext(temp.getNext());
		head.setPrev(temp);
		temp.setNext(head);
		temp.setPrev(null);
		head = head.getPrev();
		temp = curr.getNext();
		recursiveReverse(curr);
	}

	public int length() {
		DNode<T> curr = head;
		int count = 0;
		while (curr != null) {
			count++;
			curr = curr.getNext();
		}
		return count;
	}

	public int recursiveLength() {
		return recursiveLength(head);
	}

	private int recursiveLength(DNode<T> curr) {
		if (curr == null)
			return 0;
		return 1 + recursiveLength(curr.getNext());
	}

	public void traverse() {
		DNode<T> curr = head;
		System.out.print("Head --> ");
		while (curr != null) {
			System.out.print(curr + " --> ");
			curr = curr.getNext();
		}
		System.out.println("Null");
	}

	public void recursiveTraverse() {
		System.out.print("Head --> ");
		recursiveTraverse(head);
		System.out.println("Null");
	}

	private void recursiveTraverse(DNode<T> curr) {
		if (curr == null)
			return;
		System.out.print(curr + " --> ");
		recursiveTraverse(curr.getNext());
	}

	public void backwardTraverse() {
		DNode<T> curr = head;

		while (curr != null && curr.getNext() != null)
			curr = curr.getNext();

		System.out.print("Tail --> ");
		while (curr != null) {
			System.out.print(curr + " --> ");
			curr = curr.getPrev();
		}
		System.out.println("Null");
	}

	public void recursiveBackwardTraverse() {
		System.out.print("Tail --> ");
		recursiveBackwardTraverse(head);
		System.out.println("Null");
	}

	private void recursiveBackwardTraverse(DNode<T> curr) {
		if (curr == null)
			return;
		recursiveBackwardTraverse(curr.getNext());
		System.out.print(curr + " --> ");
	}
	
	@Override
	public String toString() {
		DNode<T> curr = head;
		String res = "Head --> ";
		while (curr != null) {
			res += curr + " --> ";
			curr = curr.getNext();
		}
		res += "Null";
		return res;
	}

}