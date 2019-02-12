package interfaces;

public interface Queue<X> {
	
	public int size();
	
	public void enQueue(X item);
	
	public X deQueue();
	
	public boolean checkIfFull();
	
	public boolean checkIfEmpty();
	
	public boolean contains(X item);
	
	public X accessItem(int position);
	
	public void printQueue();

}
