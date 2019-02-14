package implementationClasses;

import interfaces.HashTable;

public class BasicHashTableImpl<X, Y> implements HashTable<X, Y> {
	
	private HashEntry[] hashTableObj;
	private int capacity;
	private int size;
	
	public BasicHashTableImpl(int tableSize) {
		this.capacity = tableSize;
		this.hashTableObj = new HashEntry[this.capacity];
		this.size = 0;
	}
	
	@Override
	public int getSize() {
		return this.size;
	}
	
	public int computeIndex(X key) {
		int index = key.hashCode() % this.capacity;
		
		while (hashTableObj[index] != null && !hashTableObj[index].getKey().equals(key)) {
			// Linear Probing
			index = (key.hashCode() + 1) % this.capacity;
		}
		
		return index;
	}

	@Override
	public Y get(X key) {
		int correspondingIndex = computeIndex(key);
		
		if (hashTableObj[correspondingIndex] == null) {
			return null;
		}
		return (Y) hashTableObj[correspondingIndex].getValue();
	}

	@Override
	public void put(X key, Y value) {
		int correspondingIndex = computeIndex(key);
		hashTableObj[correspondingIndex] = new HashEntry<X, Y>(key, value);
		size++;
	}
	
	@Override
	public Y delete(X key) {
		Y value = get(key);
		if (value != null) {
			int correspondingIndex = computeIndex(key);
			hashTableObj[correspondingIndex] = null;
			size--;
			
			correspondingIndex = (correspondingIndex + 1)  % this.capacity;
			
			while (hashTableObj[correspondingIndex] != null) {
				HashEntry he = hashTableObj[correspondingIndex];
				hashTableObj[correspondingIndex] = null;
				put((X)he.getKey(), (Y)he.getValue());
				size--;
				correspondingIndex = (correspondingIndex + 1) % this.capacity;
			}
		}
		return value;
	}
	
	@Override
	public boolean hasKey(X key) {
		boolean found = false;
		
		int correspondingIndex = computeIndex(key);
		if (hashTableObj[correspondingIndex].getKey().equals(key)) {
			found = true;
		}
		
		return found;
	}
	
	@Override
	public boolean hasValue(Y value) {
		boolean found = false;
		
		for (int i=0; i < this.capacity; i++) {
			HashEntry entry = hashTableObj[i];
			
			if (entry != null && entry.getValue().equals(value)) {
				found = true;
			}
		}
		return found;
	}

	
	private class HashEntry<X, Y> {
		private X key;
		private Y value;
		
		public HashEntry(X keyItem, Y valueItem) {
			this.key = keyItem;
			this.value = valueItem;
		}
		
		public X getKey() {
			return key;
		}
		public void setKey(X key) {
			this.key = key;
		}
		public Y getValue() {
			return value;
		}
		public void setValue(Y value) {
			this.value = value;
		}
		
	}
}
