package testing;

import linkedlist.LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();

		// -------------- insert new data
//		list.insert(50);
//		list.insert(60);
//		list.insert(90);
//		list.traverse();
//		
//		list.insert(40); // insert first
//		list.insert(99); // insert last
//		list.insert(55); // insert between
//		list.traverse();

		// -------------- insert new data recursively
		list.recursiveInsert(50);
		list.recursiveInsert(60);
		list.recursiveInsert(90);
		list.traverse();

		list.recursiveInsert(40); // insert first
		list.recursiveInsert(99); // insert last
		list.recursiveInsert(55); // insert between
		list.traverse();
		
		System.out.println(list.length());

		// -------------- delete existing data
//		list.delete(40); // delete first
//		list.traverse();
//		list.delete(99); // delete last
//		list.traverse();
//		list.delete(60); // delete form the middle
//		list.traverse();

		// -------------- delete non-existing data
		System.out.println((list.delete(30) == null) ? "30 doesn't exist" : "30 is deleted");
		System.out.println((list.delete(98) == null) ? "98 doesn't exist" : "98 is deleted");
		System.out.println((list.delete(57) == null) ? "57 doesn't exist" : "57 is deleted");

		// -------------- delete existing data recursively
		list.recursiveDelete(40);
		list.traverse();
		list.recursiveDelete(99);
		list.traverse();
		list.recursiveDelete(55);
		list.traverse();

		// -------------- delete non-existing data recursively
		System.out.println((list.recursiveDelete(30) == null) ? "30 doesn't exist" : "30 is deleted");
		System.out.println((list.recursiveDelete(98) == null) ? "98 doesn't exist" : "98 is deleted");
		System.out.println((list.recursiveDelete(57) == null) ? "57 doesn't exist" : "57 is deleted");

		// -------------- search for existing data
//		System.out.println((list.find(50) == null) ? "50 doesn't exist" : "50 exists");
//		System.out.println((list.find(90) == null) ? "90 doesn't exist" : "90 exists");
//		System.out.println((list.find(60) == null) ? "60 doesn't exist" : "60 exists");

		// -------------- search for non-existing data
//		System.out.println((list.find(40) == null) ? "40 doesn't exist" : "40 exists");
//		System.out.println((list.find(99) == null) ? "99 doesn't exist" : "99 exists");
//		System.out.println((list.find(55) == null) ? "55 doesn't exist" : "55 exists");

		// -------------- search for existing data recursively
		System.out.println((list.recursiveFind(50) == null) ? "50 doesn't exist" : "50 exists");
		System.out.println((list.recursiveFind(90) == null) ? "90 doesn't exist" : "90 exists");
		System.out.println((list.recursiveFind(60) == null) ? "60 doesn't exist" : "60 exists");

		// -------------- search for non-existing data recursively
		System.out.println((list.recursiveFind(40) == null) ? "40 doesn't exist" : "40 exists");
		System.out.println((list.recursiveFind(99) == null) ? "99 doesn't exist" : "99 exists");
		System.out.println((list.recursiveFind(55) == null) ? "55 doesn't exist" : "55 exists");
		
		System.out.println(list.length());
	}

}
