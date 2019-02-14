package interfaces;

public interface BinaryTree<X> {
	
	public int size();
	
	public void add(X item);
	
	public boolean contains(X item);
	
	public boolean delete (X item);
}
