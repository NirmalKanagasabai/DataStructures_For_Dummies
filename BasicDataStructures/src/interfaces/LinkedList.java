package interfaces;

public interface LinkedList<X> {
	
	public void addNodeAtFirst(X item);
	
	public void addNodeInTheMiddle(X item);
	
	public void addNodeInTheEnd(X item);
	
	public X removeSpecificNode(X item);
	
	public X removeNodeFromTheFront();
	
	public X removeNodeFromTheEnd();
	
	public X removeNodeFromTheMiddle(int position);

}
