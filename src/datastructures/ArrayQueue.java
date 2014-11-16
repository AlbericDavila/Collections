//	By Alberic A. Davila Cadilla
//	ArrayQueue.java
//
//	This source file contains a class that implements a queue using an array.

package datastructures;

public class ArrayQueue<E> implements Queue<E> {

	// Field for the default capacity of this queue
	private static final int DEFAULT_INITIAL_CAPACITY = 10;

	// Field for the data of this queue
	private E[] data;

	// Fields for the front and rear indices of this queue
	private int front, rear;
	
	// Field for the number of elements in this queue.
	private int count;

	// Creates a new queue with the given initial capacity.
	@SuppressWarnings("unchecked")
	public ArrayQueue(int initialCapacity) {
		if (initialCapacity < 1)
			throw new InvalidCapacityException();
		data = (E[])new Object[initialCapacity];
		rear = data.length - 1;
	}

	// Creates a new queue with the default initial capacity.
	public ArrayQueue() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
		
	// Adds the given element at the rear end of this queue.
	@Override
	public void enqueue(E element) {
		ensureCapacity();
		rear = (rear + 1) % data.length;
		data[rear] = element;
		count++;		
	}

	// Ensures that the capacity of this queue allows for addition of an element.
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if (count == data.length) {
			E[] temp = (E[])new Object[data.length * 2];
			for (int current = 0; current < count; current++)
				temp[current] = data[(front + current) % data.length];
			data = temp;
			front = 0;
			rear = count - 1;
		}
	}
	
	// Removes and returns the element from the front end of this queue.
	@Override
	public E dequeue() {
		if (isEmpty())
			throw new ElementNotFoundException();
		E element = data[front];
		data[front] = null;
		front = (front + 1) % data.length;
		count--;
		return element;
	}

	// Returns the element at the front end of this queue.
	@Override
	public E peek() {
		if (isEmpty())
			throw new ElementNotFoundException();
		return data[front];
	}
	
	// Removes all elements from this queue.
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		data = (E[])new Object[DEFAULT_INITIAL_CAPACITY];
		front = 0;
		rear = data.length - 1;
		count = 0;
	}
	
	// Returns true if this queue contains no elements.
	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	// Returns the number of elements in this queue.
	@Override
	public int size() {
		return count;
	}
		
	// Returns the string representation of this queue.
	@Override
	public String toString() {
		String str = "[";
		
		if (! isEmpty()) {
			str += data[front];
			for (int current = 1; current < count; current++)
				str += ", " + data[(front + current) % data.length];
		}
		return str + "]";
	}

}