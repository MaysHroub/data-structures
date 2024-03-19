package testing;

import linkedlist.DoublyLinkedList;

public class TestDDL {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();
		
		// -------------- insert new data
		dll.insert(50);
		dll.traverse();
		dll.insert(60);
		dll.traverse();
		dll.insert(90);
		dll.traverse();

		dll.insert(40); // insert first
		dll.traverse();
		dll.insert(99); // insert last
		dll.traverse();
		dll.insert(55); // insert between
		dll.traverse();
		
		dll.delete(40);
		dll.traverse();
		dll.delete(99);
		dll.traverse();
		dll.delete(60);
		dll.traverse();
		dll.delete(44);
		dll.delete(101);
		dll.delete(57);
		dll.traverse();
		
	}

}
