//	By Alberic A. Davila Cadilla
//	ArrayStack.java
//
//	This class implements a stack using an array.
//	The data type it handles is generic.

package datastructures;

public class ArrayStack<E> implements Stack <E> {
	
	private static int DEFAULT_CAPACITY = 10;
	
	private E[] data;
	private int top = -1;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int initCapacity) {
		if(initCapacity < 1)
			throw new InvalidCapacityException("capacity is less than one");
		data = (E[]) new Object[initCapacity];
	}
	
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	@Override
	public void push(E element) {
		if (top + 1 == data.length)
			doubleCapacity();
		data[++top] = element; 
	}
	
	@SuppressWarnings("unchecked")
	private void doubleCapacity() {
		E[] temp = (E[]) new Object[data.length * 2];
		for(int current = top; current >=0; current--)
			temp[current] = data[current];
		data = temp;
	}
	
	public E pop() {
		if(isEmpty())
			throw new ElementNotFoundException("stack is empty : pop impossible");
		E element = data[top];
		data[top] = null;
		top--;
		return element;
	}
	
	public E peek() {
		if(isEmpty())
			throw new ElementNotFoundException("stack is empty : peek impossible");
		E element = data[top];
		return element;
	}
	
	@Override
	public int size() {
		return (top + 1);
	}
	
	@Override
	public boolean isEmpty() {
		return (top == -1);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		data = (E[]) new Object[DEFAULT_CAPACITY];
		top = -1; 
	}
	
	@Override
	public String toString() {
		String str = "[";
		
		if(!isEmpty()) {
			str += data[top];
			for (int current = top-1; current >= 0; current--)
				str += ", " + data[current];
		}
		return str + "]";
	}
}
