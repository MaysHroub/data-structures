package trees;

public class BinaryTree<T extends Comparable<T>> {
	
	private TNode<T> root;
	
	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(TNode<T> curr) {
		if (curr == null) return;
		if (curr.hasLeft()) traverseInOrder(curr.getLeft());
		System.out.println(curr + " ");
		if (curr.hasRight()) traverseInOrder(curr.getRight());
	}

}
