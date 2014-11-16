//	By Alberic A. Davila Cadilla
//	Queue.java
//	
//	This source file contains an interface that describes a queue.

package datastructures;

public interface Queue<E> {
	
	// Adds the given element at the rear end of this queue.
	void enqueue(E element);
	
	// Removes and returns the element from the front end of this queue.
	E dequeue();
	
	// Returns the element at the front end of this queue.
	E peek();
	
	// Removes all elements from this queue.
	void clear();

	// Returns the number of elements in this queue.
	int size();

	// Returns true only if this queue has no elements.
	boolean isEmpty();

}