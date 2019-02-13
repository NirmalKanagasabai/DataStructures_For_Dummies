package implementationClasses;

import interfaces.LinkedList;

public class BasicLinkedListImpl<X> implements LinkedList<X>{
	
	private Node first;
	private Node last;
	private int nodeCount;
	
	public BasicLinkedListImpl() {
		this.first = null;
		this.last = null;
		this.nodeCount = 0;
	}
	
	@Override
	public int getSize() {
		return nodeCount;
	}
	
	@Override
	public void addNode(X item) {
		if ((first == null && last == null) && (nodeCount == 0)) {
			addNodeAtFirst(item);
		} else {
			addNodeInTheEnd(item);
		}
	}

	@Override
	public void addNodeAtFirst(X item) {
		first = new Node(item);
		last = first;
		nodeCount++;
	}

	@Override
	public void addNodeInTheMiddle(int position, X item) {
		if (position > getSize()) {
			throw new IllegalStateException("The position is greater than the size of the list");
		}
		
		Node newNode = new Node(item);
		Node currentNode = first;
		for (int i=1; i< position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		newNode.setNextNode(currentNode.getNextNode());
		currentNode.setNextNode(newNode);
		nodeCount++;
	}

	@Override
	public void addNodeInTheEnd(X item) {
		Node newLastNode = new Node(item);
		last.setNextNode(newLastNode);
		last = newLastNode;
		nodeCount++;
	}
	
	@Override
	public X removeNode() {
		if (first == null) {
			// Empty List
			throw new IllegalArgumentException("The list is empty. No nodes were removed!");
		} else {
			return removeNodeFromTheFront();
		}
	}
	
	@Override
	public X removeNodeFromTheFront() {
		X removedItem = first.getNodeItem();
		first = first.getNextNode();
		nodeCount--;
		return removedItem;
	}

	@Override
	public X removeNodeFromTheMiddle(int position) {
		if (position > getSize()) {
			throw new IllegalStateException("The position is greater than the size of the list");
		}
		
		Node currentNode = first;
		Node previousNode = first;
		for (int i=1; i<position && currentNode != null; i++) {
			previousNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		previousNode.setNextNode(currentNode.getNextNode());
		nodeCount--;
		return currentNode.getNodeItem();
	}

	@Override
	public X removeNodeFromTheEnd() {
		X removedItem = null;
		Node previousNode = first;
		Node currentNode = first;
		for (int i=1; i<getSize() && currentNode != null; i++) {
			if (currentNode.getNextNode().equals(last)) {
				previousNode = currentNode;
				previousNode.setNextNode(currentNode.getNextNode());
				removedItem = currentNode.getNodeItem();
			} else {
				currentNode = currentNode.getNextNode();
			}
		}
		nodeCount--;
		return removedItem;
	}
	
	@Override
	public X getItem(int position) {
		if (position > getSize()) {
			throw new IllegalStateException("The position is greater than the size of the list");
		}
		
		Node currentNode = first;
		for (int i=1; i<position && currentNode != null; i++) {
			currentNode = currentNode.getNextNode();
		}
		return currentNode.getNodeItem();
	}
	
	@Override
	public int find(X item) {
		
		if (first == null) {
			throw new IllegalStateException("The list is empty!");
		} 
		
		Node currentNode = first;
		for (int i=1; i<getSize() && currentNode != null; i++) {
			if (currentNode.getNodeItem().equals(item)) {
				return i;
			} else {
				currentNode = currentNode.getNextNode();
			}	
		}
		return -1;
	}
	
	public class Node {
		
		Node nextNode;
		X nodeItem;
		
		public Node(X item) {
			this.nodeItem = item;
			this.nextNode = null;
		}
		
		public void setNextNode(Node next) {
			this.nextNode = next;
		}
		
		public Node getNextNode() {
			return nextNode;
		}
		
		public X getNodeItem() {
			return nodeItem;
		}
	}

}
