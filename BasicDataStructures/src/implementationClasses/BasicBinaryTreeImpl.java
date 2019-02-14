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
	
	@Override
	public boolean contains(X item) {
		boolean result = false;
		Node tempNode = getNode(item);
		
		if (tempNode == null) {
			result = false;
		} else {
			result = true;
		}
		
		return result;
	}
	
	private Node getNode(X item) {
		Node tempNode = root;
		
		while (tempNode != null) {
			if (tempNode.getItem().compareTo(item) == 0) {
				return tempNode;
			} else if (tempNode.getItem().compareTo(item) < 0) {
				tempNode = root.getLeft();
			} else if (tempNode.getItem().compareTo(item) > 0) {
				tempNode = root.getRight();
			}
		}
		return null;
	}
	
	@Override
	public boolean delete(X item) {
		boolean result = false;
		if(this.root == null) {
			return false;
		}
		
		Node currentNode = getNode(item);
		if (currentNode != null) {
			if (currentNode.getLeft() == null && currentNode.getRight() == null) {
				unlink(currentNode, null);
				result = true;
			} else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
				unlink(currentNode, currentNode.getRight());
				result = true;
			} else if (currentNode.getLeft() == null && currentNode.getRight() != null) {
				unlink(currentNode, currentNode.getLeft());
				result = true;
			} else {
				Node child = currentNode.getLeft();
				
				while (child.getRight() != null && child.getLeft() != null) {
					child = child.getRight();
				}
				
				child.getParent().setRight(null);
				child.setLeft(currentNode.getLeft());
				child.setRight(currentNode.getRight());
				
				unlink(currentNode, child);
				result = true;
			}
		} else {
			result = false;
		}
		return result;
	}
	
	private void unlink(Node currentNode, Node newNode) {
		if (currentNode == this.root) {
			newNode.setLeft(currentNode.getLeft());
			newNode.setRight(currentNode.getRight());
			this.root = newNode;
		} else if (currentNode.getParent().getRight() == currentNode) {
			currentNode.getParent().setRight(newNode);
		} else {
			currentNode.getParent().setLeft(newNode);
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
