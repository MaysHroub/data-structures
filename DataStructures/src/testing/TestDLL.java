package testing;

import linkedlist.DoublyLinkedList;

public class TestDLL {

	public static void main(String[] args) {
		DoublyLinkedList<Integer> dll = new DoublyLinkedList<>();

		dll.recursiveDelete(29);
		System.out.println(dll.recursiveFind(55));

		// -------------- insert new data
//		dll.insert(50);
//		dll.traverse();
//		dll.insert(60);
//		dll.traverse();
//		dll.insert(90);
//		dll.traverse();
//
//		dll.insert(40); // insert first
//		dll.traverse();
//		dll.insert(99); // insert last
//		dll.traverse();
//		dll.insert(55); // insert between
//		dll.traverse();

		System.out.println(dll.recursiveLength());
		
		// -------------- insert new data
		dll.recursiveTraverse();
		dll.recursiveInsert(55);
		dll.recursiveInsert(50);
		dll.recursiveInsert(90);
		dll.recursiveInsert(60);
		dll.recursiveInsert(99);
		dll.recursiveInsert(40);
		dll.traverse();
		dll.recursiveTraverse();
		
		System.out.println(dll.recursiveLength());

		// -------------- delete existing data
//		dll.delete(40);
//		dll.traverse();
//		dll.delete(99);
//		dll.traverse();
//		dll.delete(60);
//		dll.traverse();
//		// -------------- delete non-existing data
//		dll.delete(44);
//		dll.delete(101);
//		dll.delete(57);
//		dll.traverse();
		
		// -------------- delete existing data recursively
		dll.recursiveDelete(40);
		dll.traverse();
		dll.recursiveDelete(99);
		dll.traverse();
		dll.recursiveDelete(60);
		dll.traverse();
		// -------------- delete non-existing data recursively
		dll.recursiveDelete(44);
		dll.recursiveDelete(101);
		dll.recursiveDelete(57);
		dll.traverse();

		// -------------- search for existing data
//		System.out.println(dll.find(50));
//		System.out.println(dll.find(90));
//		System.out.println(dll.find(55));
//		// -------------- search for non-existing data
//		System.out.println(dll.find(40));
//		System.out.println(dll.find(99));
//		System.out.println(dll.find(60));
		
		// -------------- search for existing data recursively
		System.out.println(dll.recursiveFind(50));
		System.out.println(dll.recursiveFind(90));
		System.out.println(dll.recursiveFind(55));
		// -------------- search for non-existing data recursively
		System.out.println(dll.recursiveFind(44));
		System.out.println(dll.recursiveFind(98));
		System.out.println(dll.recursiveFind(66));
	}

}
