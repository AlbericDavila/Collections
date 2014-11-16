//	By Alberic A. Davila Cadilla
//	bag.java
//
//	Simple interface for a "bag" data structure.

package datastructures;

public interface Bag<E> {

	void add(E elem);
	
	void remove(E elem);
	
	boolean contains(E elem);
	
	void clear();
	
	boolean isEmpty();
	
	int size();
}
