package trees;

import queue_pack.LinkedListQueue;
import stack.LinkedListStack;

public class BinarySearchTree<T extends Comparable<T>> {
	
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
	
	public void traverseLevelOrder() {
		if (root == null) return;
		LinkedListQueue<TNode<T>> queue = new LinkedListQueue<>();
		queue.enqueue(root);
		while (!queue.isEmpty()) {
			TNode<T> curr = queue.dequeue();
			System.out.println(curr);
			if (curr.hasLeft()) queue.enqueue(curr.getLeft());
			if (curr.hasRight()) queue.enqueue(curr.getRight());
		}
	}
	
	public TNode<T> find(T data) {
		return find(root, data);
	}

	private TNode<T> find(TNode<T> curr, T data) {
		if (curr != null) {
			int comp = curr.getData().compareTo(data);
			if (comp == 0) return curr;
			else if (comp > 0 && curr.hasLeft()) return find(curr.getLeft(), data);
			else if (comp < 0 && curr.hasRight()) return find(curr.getRight(), data);
		}
		return null;
	}
	
	public TNode<T> smallest() {
		return smallest(root);
	}

	private TNode<T> smallest(TNode<T> curr) {
		if (curr == null) return null;
		if (curr.getLeft() == null) return curr;
		return smallest(curr.getLeft());
	}

}
