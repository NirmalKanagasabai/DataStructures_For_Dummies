package implementationClasses;

import interfaces.Stack;

public class BasicStackImpl<X> implements Stack<X> {
	
	int stackPointer;
	
	X[] stackArray;
	
	@SuppressWarnings("unchecked")
	BasicStackImpl() {
		
		this.stackPointer = 0;
		this.stackArray = (X[]) new Object[1000];
	}

	@Override
	public void push(X item) {
		
		if (stackPointer > 999) {
			throw new IllegalStateException("Stack Overflow");
		} else {
			stackArray[stackPointer] = item;
			stackPointer++;
		}
		
	}

	@Override
	public X pop() {
		X item;
		if (stackPointer == 0) {
			throw new IllegalStateException("Stack Underflow");
		} else {
			item = stackArray[stackPointer];
			stackPointer--;
		}		
		return item;
	}

	@Override
	public boolean contains(X item) {
		for (X x : stackArray) {
			if (x.equals(item)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public X access(X item) {	
		while (stackPointer > 0) {
			X poppedElement = pop();
			if (poppedElement.equals(item)) {
				return poppedElement;
			}
		}
		return null;
	}
	
	public int size() {
		return stackPointer;
	}

}
