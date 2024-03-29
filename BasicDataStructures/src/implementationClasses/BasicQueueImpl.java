package implementationClasses;

import interfaces.Queue;

public class BasicQueueImpl<X> implements Queue<X> {
	
	private X[] queueArray;
	private int front;
	private int end;
	
	@SuppressWarnings("unchecked")
	public BasicQueueImpl() {
		this.front = -1;
		this.end = -1;
		this.queueArray = (X[]) new Object[1000];
	}
	
	@SuppressWarnings("unchecked")
	public BasicQueueImpl(int size) {
		this.front = -1;
		this.end = -1;
		this.queueArray = (X[]) new Object[size];
	}

	@Override
	public int size() {
		if (front == -1 && end == -1) {
			return 0;
		} else {
			// We add the one to get the inclusive subtraction value 
			return (end - front) + 1;
		}
	}

	@Override
	public void enQueue(X item) {
		if (checkIfEmpty()) {
			front++;
			end++;
			queueArray[front] = item;
		} else if (checkIfFull()) {
			throw new IllegalStateException("The queue is already full!");
		} else {
			end++;
			queueArray[end] = item;
		}
	}

	@Override
	public X deQueue() {
		
		X removedItem = null;
		
		if (checkIfEmpty()) {
			throw new IllegalStateException("The queue is already empty!");
		} 
		
		else if (front == end) {
			removedItem = queueArray[front];
			//queueArray[front] = null;
			front = -1;
			end = -1;
		} 
		
		else {
			removedItem = queueArray[front];
			//queueArray[front] = null;
			front++;
		}
		
		return removedItem;
	}
	
	@Override
	public boolean checkIfFull() {
		if ((end + 1) % queueArray.length == front) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean checkIfEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public boolean contains(X item) {
		if (checkIfEmpty()) {
			return false;
		} else {
			for (int i=front; i<end; i++) {
				if(queueArray[i].equals(item)) {
					return true;
				}
			}
			return false;
		}
	}
	
	@Override
	public X accessItem(int position) {
		
		int counter = 0;
		
		if (checkIfEmpty() || position > size()) {
			throw new IllegalArgumentException("The queue is empty or the position is greater than the size!");
		} 
		
		for (int i=front; i<end; i++) {
			if(counter == position) {
				return queueArray[i];
			}
			counter++;
		}
		
		throw new IllegalArgumentException("The item isn't found!");
	}

	@Override
	public void printQueue() {
		for (int i=0; i<size(); i++) {
			System.out.println(queueArray[i]);
		}		
	}
}
