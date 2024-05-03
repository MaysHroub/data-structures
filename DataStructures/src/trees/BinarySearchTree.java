package trees;


import queue_pack.LinkedListQueue;
import stack.LinkedListStack;

public class BinarySearchTree<T extends Comparable<T>> {
	
	private TNode<T> root;
	
	// added setters and getters to be used in AVL class
	protected TNode<T> getRoot() {
		return root;
	}
	
	protected void setRoot(TNode<T> root) {
		this.root = root;
	}
	
	public void traverseInOrder() {
		traverseInOrder(root);
	}

	private void traverseInOrder(TNode<T> curr) {
		if (curr == null) return;
		traverseInOrder(curr.getLeft());
		System.out.print(curr + " ");
		traverseInOrder(curr.getRight());
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
			// visit the leftmost node and traverse its right subtree
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
		System.out.print(curr + " ");
		traversePreOrder(curr.getLeft());
		traversePreOrder(curr.getRight());
	}
	
	public void traversePostOrder() {
		traversePostOrder(root);
	}

	private void traversePostOrder(TNode<T> curr) {
		if (curr == null) return;
		traversePreOrder(curr.getLeft());
		traversePreOrder(curr.getRight());
		System.out.print(curr + " ");
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
			else /*if (comp < 0 && curr.hasRight())*/ return find(curr.getRight(), data);
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
	
	public TNode<T> largest() {
		return largest(root);
	}

	private TNode<T> largest(TNode<T> curr) {
		if (curr == null) return null;
		if (curr.getRight() == null) return curr;
		return smallest(curr.getRight());
	}
	
	public int height() {
		return height(root);
	}

	public int height(TNode<T> curr) {
		if (curr == null) return 0;
		if (curr.isLeaf()) return 1;
		return 1 + Math.max(height(curr.getLeft()), height(curr.getRight()));
	}
	
	public int size() {
		return size(root);
	}
	
	private int size(TNode<T> curr) {
		if (curr == null) return 0;
		return 1 + size(curr.getLeft()) + size(curr.getRight());
	}

	public void insert(T data) {
		if (root == null)
			root = new TNode<>(data);
		else 
			insert(data, root);
	}

	private void insert(T data, TNode<T> curr) {
		if (data.compareTo(curr.getData()) >= 0) { // insert into right subtree
			if (!curr.hasRight())
				curr.setRight(new TNode<>(data));
			else 
				insert(data, curr.getRight());			
		} else { // insert into left subtree
			if (!curr.hasLeft())
				curr.setLeft(new TNode<>(data));
			else 
				insert(data, curr.getLeft());	
		}
	}
	
	public TNode<T> delete(T data) {
		TNode<T> curr = root, parent = root;
		boolean isLeftChild = false;
		
		if (root == null) return null; // empty tree 
		
		while (curr != null && curr.getData().compareTo(data) != 0) {
			parent = curr;
			if (data.compareTo(curr.getData()) < 0) { // left subtree
				curr = curr.getLeft();
				isLeftChild = true;
			} else { // right subtree
				curr = curr.getRight();
				isLeftChild = false;
			}
		}
	
		if (curr == null) return null; // not found
		
		// case 1: deleted node is a leaf
		if (curr.isLeaf()) {
			if (curr == root) root = null; // tree has only one node
			else if (isLeftChild) parent.setLeft(null);
			else parent.setRight(null);
		}
		
		// case 2: deleted node has one child
		// broken into 2 sub-cases
		else if (curr.hasLeft() && !curr.hasRight()) { // has only left child
			if (curr == root)
				root = curr.getLeft();
			else if (isLeftChild) 
				parent.setLeft(curr.getLeft());
			else 
				parent.setRight(curr.getLeft());
			
		} else if (curr.hasRight() && !curr.hasLeft()) { // has only right child
			if (curr == root)
				root = curr.getRight();
			else if (isLeftChild) 
				parent.setLeft(curr.getRight());
			else 
				parent.setRight(curr.getRight());
		}
		
		// case 3: deleted node has 2 children
		else {
			TNode<T> successor = getSuccessor(curr);
			if (curr == root) 
				root = successor;
			else if (isLeftChild) 
				parent.setLeft(successor);
			else 
				parent.setRight(successor);
			successor.setLeft(curr.getLeft());
		}
		return curr;
	}

	private TNode<T> getSuccessor(TNode<T> node) {
		TNode<T> successorParent = node,
				successor = node,
				curr = node.getRight();
		
		while (curr != null) {
			successorParent = successor;
			successor = curr;
			curr = curr.getLeft();
		}
		if (successor != node.getRight()) { // fix successor connections
			successorParent.setLeft(successor.getRight());
			successor.setRight(node.getRight());
		}
		return successor;
	}
	
	public int countLeaves() {
		return countLeaves(root);
	}

	private int countLeaves(TNode<T> curr) {
		if (curr == null) return 0;
		if (curr.isLeaf()) return 1;
		return countLeaves(curr.getLeft()) + countLeaves(curr.getRight());
	}
	
	public int countParents() {
		return countParents(root);
	}

	private int countParents(TNode<T> curr) {
		if (curr == null) return 0;
		if (!curr.isLeaf()) return 1;
		return countParents(curr.getLeft()) + countParents(curr.getRight());
	}

}






















