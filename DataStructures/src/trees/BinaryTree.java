package trees;

import javax.lang.model.element.Element;

import stack.LinkedListStack;

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
	
	public void iterativeInOrderTraverse() {
		LinkedListStack<TNode<T>> nodeStack = new LinkedListStack<>();
		TNode<T> curr = root;
		while (!nodeStack.isEmpty() || curr != null) {
			// find leftmost node
			while (curr != null) {
				nodeStack.push(curr);
				curr = curr.getLeft();
			}
			// visit the mostleft node and traverse its right subtree
			if (!nodeStack.isEmpty()) {
				TNode<T> nextNode = nodeStack.pop();
				System.out.println(nextNode + " ");
				curr = nextNode.getRight();
			}
		}
	}
	
	public void traversePreOrder() {
		traversePreOrder(root);
	}

	private void traversePreOrder(TNode<T> curr) {
		if (curr == null) return;
		System.out.println(curr);
		if (curr.hasLeft()) traversePreOrder(curr.getLeft());
		else if (curr.hasRight()) traversePreOrder(curr.getRight());
	}
	
	public void traversePpstOrder() {
		traversePostOrder(root);
	}

	private void traversePostOrder(TNode<T> curr) {
		if (curr == null) return;
		if (curr.hasLeft()) traversePreOrder(curr.getLeft());
		else if (curr.hasRight()) traversePreOrder(curr.getRight());
		System.out.println(curr);
	}

}
