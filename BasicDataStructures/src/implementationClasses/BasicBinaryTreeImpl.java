package implementationClasses;

import interfaces.BinaryTree;

public class BasicBinaryTreeImpl <X extends Comparable<X>> implements BinaryTree<X> {
	
	private Node root;
	private int size;
	
	public BasicBinaryTreeImpl() {
		this.root = null;
		this.size = 0;
	}
	
	@Override
	public int size() {
		return this.size;
	}
	
	@Override
	public void add(X item) {
		Node node = new Node(item);	
		if (root == null) {
			this.root = node;
			System.out.println("Set the root: " + node.getItem());
			this.size++;
		} else {
			this.insert(root, node);
		}
	}
	
	// Helper method
	private void insert(Node parent, Node child) {
		if (child.getItem().compareTo(parent.getItem()) < 0) {
			if (parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			} else {
				insert(parent.getLeft(), child);
			}
		} else if (child.getItem().compareTo(parent.getItem()) > 0){
			if (parent.getRight() == null) {
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			} else {
				insert(parent.getRight(), child);
			}
		} else {
			throw new IllegalArgumentException("The node already exists!");
		}
	}
	
	private class Node {
		
		Node left;
		Node right;
		Node parent;
		X item;
		
		public Node(X initializingItem) {
			this.item = initializingItem;
			left = null;
			right = null;
			parent = null;
		}
		
		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public X getItem() {
			return item;
		}

		public void setItem(X item) {
			this.item = item;
		}

	}
}
