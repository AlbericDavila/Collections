//	By Alberic A. Davila Cadilla
//	Stack.java
//
//	Inferface used for stacks.

package datastructures;

public interface Stack<E> {

	void push(E element);
	
	E pop();
	
	E peek();
	
	void clear();
	
	int size();
	
	boolean isEmpty();
	
}
