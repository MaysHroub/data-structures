package testing;

import hashing.LinearOHash;
import hashing.QuadraticOHash;
import hashing.SHash;

public class TestHashing {

	public static void main(String[] args) {
		
		int i = 3;
		System.out.println((--i) * i);
		System.out.println(i);
		
		SHash<Integer> hashTable = new SHash<>(10);  // m = 10
		hashTable.add(1);
		hashTable.add(11);
		hashTable.add(21);
		hashTable.printLinkedList(1);
		hashTable.add(99);
		hashTable.add(65);
		hashTable.add(55);
		hashTable.printAllLinkedLists();
		System.out.println(hashTable.find(99));
		
		System.out.println("------------------");
		
		LinearOHash<Integer> linearHash = new LinearOHash<>(5); // m = 11
		linearHash.add(1);
		linearHash.add(2);
		linearHash.add(3);
		linearHash.add(-24);
		linearHash.add(-24);
		linearHash.traverse();
		System.out.println();
		
		linearHash.add(47); // rehash here 
		linearHash.add(22);
		linearHash.add(23);
		linearHash.traverse();
		System.out.println();
		
		System.out.println(linearHash.find(23));
		System.out.println(linearHash.delete(23));
		System.out.println(linearHash.find(23));
		linearHash.add(23);
		System.out.println(linearHash.find(23));
		
		System.out.println("------------------");
		
		QuadraticOHash<Integer> quadraticHash = new QuadraticOHash<>(10);
		quadraticHash.add(1);
		quadraticHash.add(2);
		quadraticHash.add(3);
		quadraticHash.traverse();System.out.println();
		quadraticHash.delete(1);
		quadraticHash.traverse();System.out.println();
		quadraticHash.add(1);
		quadraticHash.traverse();System.out.println();
		quadraticHash.add(-24);
		quadraticHash.add(-24);
		quadraticHash.add(47);
		quadraticHash.add(22);
		quadraticHash.add(23);
		
		quadraticHash.traverse();
		
		System.out.println();
		
		System.out.println(quadraticHash.find(23));
		
		System.out.println(quadraticHash.delete(23));
		
		System.out.println(quadraticHash.find(23));
		
		quadraticHash.add(23);
		
		System.out.println(quadraticHash.find(23));
		
	}

}
