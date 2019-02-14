package interfaces;

public interface HashTable<X, Y> {
	
	public Y get(X key);
	
	public void put(X key, Y value);
	
	public Y delete(X key);
	
	public boolean hasKey(X key);
	
	public boolean hasValue (Y value);
	
	public int getSize();

}
