//	By Alberic A. Davila Cadilla
//  LinkedStack.java
//
//  Class that implements a stack using links.

package datastructures;

public class LinkedStack<E> implements Stack<E> {
	
	private Node<E> top = null;
	private int size = 0;
	
	@Override
	public void push(E element) {
		top = new Node<E>(element, top);
		size++;
	}
	
	@Override 
	public E peek() {
		// Return a reference to the top element 
		if(isEmpty())
			throw new ElementNotFoundException("Stack is empty :  peek is impossibru");
		return (top.data);
	}
	
	@Override
	public E pop() {
		// Return element to the top element
		// Remove it from the stack 
		if(isEmpty()) {
			throw new ElementNotFoundException("Stack is empty : pop is impossibru");
		}
		E element = top.data;
		top = top.next;
		size--;
		return element;
	}
	
	
	@Override
	public void clear() {
		top = null;
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		return size == 0;
	}
	
	@Override
	public int size() {
		@SuppressWarnings("unused")
		int len = 0;
		if(!isEmpty())
			for(Node<E> current = top; current != null; current = current.next)
				len++;
		return size;
	}
	
	public String toString() {
		String str = "[";
		if(!isEmpty()) {
			str += top.data;
			for (Node<E> current = top.next; current != null; current = current.next )
				str += ", " + current.data;
		}
		return str + "]";
	}

}
