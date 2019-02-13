package interfaces;

public interface LinkedList<X> {
	
	// Insert Operations
	
	public void addNode(X item);
	
	public void addNodeAtFirst(X item);
	
	public void addNodeInTheMiddle(int position, X item);
	
	public void addNodeInTheEnd(X item);
	
	// Remove Operations
	
	public X removeNode();
	
	public X removeNodeFromTheFront();
	
	public X removeNodeFromTheMiddle(int position);
	
	public X removeNodeFromTheEnd();
	
	// Miscellaneous Operations
	
	public int getSize();
		
	public X getItem(int position);
	
	public int find(X item);

}
