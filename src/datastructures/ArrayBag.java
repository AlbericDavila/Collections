//	By Alberic A. Davila Cadilla
//	ArrayBag.java
//
//	This class implements a bag using an array.
//	The data type it handles is generic.

package datastructures;

public class ArrayBag<E>  implements Bag<E> {

	private static final int  DEFAULT_INITIAL_CAPACITY = 10;
	private static final int  GROWTH_FACTOR = 2;

	private E[] data;
	private int count;
	
	// Default constructor, sets default capacity
	public ArrayBag() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	// Constructor, set an initial capacity.
	@SuppressWarnings("unchecked")
	public ArrayBag(int initialCapacity) {
		if(initialCapacity < 0)
			throw new InvalidCapacityException();
		data = (E[]) new Object[initialCapacity];
	}
	
	// Add an element to the array bag.
	public void add(E elem) {
		ensureCapacity();
		data[count++] = elem;
	}
	
	// Remove an element from the array bag.
	public void remove(E elem) {
		int curr = positionOf(elem);
		if (curr == -1)
			throw new ElementNotFoundException();
		data[curr] = data[--count];
		data[count] = null;
	}
	
	// Checks if a specific element is in the array bag.
	public boolean contains(E elem) {
		return (positionOf(elem) != -1);
	}
	
	// Delete all the elements in the array bag.
	@SuppressWarnings("unchecked")
	public void clear() {
		data = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
		count = 0;
	}
	
	// Checks if the array bag is empty.
	public boolean isEmpty() {
		return (count == 0);
	}
	
	// Return the size of the array bag.
	public int size() {
		return count;
	}
	
	// Displays all the elements of the array bag.
	public String toString() {
		String str = "[";
		if(count > 0) {
			str += data[0];
			for(int index = 1; index < count; index++)
				str += ", " + data[index];
		}
		return (str += "]");
	}
	
	// If the maximum capacity is reaches, double the capacity
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if(count == data.length) {
			E[] temp = (E[]) new Object[count * GROWTH_FACTOR];
			for (int curr=0; curr<count; curr++)
				temp[curr] = data[curr];
		}
	}
	
	// Returns the index of the element being searched.
	private int positionOf(E elem) {
		for (int curr = 0; curr < count; curr++)
		if (elem.equals(data[curr]))
			return curr;
		return -1;
	}
	
}
