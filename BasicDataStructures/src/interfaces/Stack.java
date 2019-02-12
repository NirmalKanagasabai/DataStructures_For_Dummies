package interfaces;

public interface Stack<X> {
	
	/*
	 *  Push Method to add new items to the stack.
	 *  @param - Takes in the item that needs to be added to the stack.
	 */
	public void push (X item);
	
	/*
	 *  Pop Method to remove items from the top of the stack.
	 */
	public X pop ();
	
	/*
	 *  Method to check if the Stack contains the given item.
	 */
	public boolean contains (X item);
	
	/*
	 *  Method to access the given item if the Stack has it.
	 */
	public X access (X item);
	
	/*
	 *  Method to print the contents of the stack.
	 */
	public void printStack();
	
	/*
	 *  Method to print the size of the stack.
	 */
	public int size();

}
