package testing;

import trees.AVLTree;
import trees.BinarySearchTree;

public class TestTree {
	
	public static void main(String[] args) {
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(5);
		bst.insert(3);
		bst.insert(7);
		bst.traverseLevelOrder();
		
		AVLTree<Integer> avl = new AVLTree<>();
		avl.insert(1);
		avl.delete(1);
		avl.traverseInOrder();
	}
	

}

















