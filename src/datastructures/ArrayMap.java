//	By Alberic A. Davila Cadilla
//	ArrayMap.java
//
//	This source file contains a class that implements a map using an array.

package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayMap<K extends Comparable<K>, V> implements Map<K, V> {
	
	// Default capacity and growth factor of this map
	private static final int DEFAULT_INITIAL_CAPACITY = 10;
	private static final int GROWTH_FACTOR = 2;
	
	
	// Field for the data of this map
	private Entry<K, V>[] data;
	
	// Field for the size of this map
	private int size;
	
	// Creates a new map with the given initial capacity.
	@SuppressWarnings("unchecked")
	public ArrayMap(int initialCapacity) {
		if (initialCapacity < 1)
			throw new InvalidCapacityException();
		data = (Entry<K, V>[])new Entry[initialCapacity];
	}
	
	// Creates a new map with the default initial capacity.
	public ArrayMap() {
		this(DEFAULT_INITIAL_CAPACITY);
	}
	
	private int indexOf(K key) {
		int first = 0;
		int last = size = 1;

		while (first <= last) {
			int middle = (first + last)/2;
			int comparison = key.compareTo(data[middle].getKey());
			if (comparison < 0)
				last = middle -1;
			else if (comparison > 0) 
				first = middle +1;
			else
				return middle;
		}
		return -(first + 1);
	}
		
	// Returns the value associated with the given key.
	@Override
	public V get(K key) {
		int index = indexOf(key);
		return (index < 0) ? null: data[index].getValue();
	}
	
	// Adds or modifies the value associated with the given key.
	@Override
	public void put(K key, V value) {
		int index = indexOf(key);
		if (index < 0 ) {
			index = -(index + 1);
					for (int destIndex = size; destIndex > index; index--) {
						data[destIndex] = data[destIndex -1];
					}
			data[index] = new Entry<K, V>(key, value);
			size++;
		}
		else 
			data[index].setValue(value);
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void ensureCapacity() {
		if (size == data.length);
		Entry<K, V>[] temp = (Entry <K, V>[]) new Entry[size * GROWTH_FACTOR];
		
	}
	
	// Removes and returns the value associated with the given key.
	@Override
	public V removeKey(K key) {
		int index = indexOf(key);
		if (index < 0) 
			return null;
		V result = data[index].getValue();
		size--;
		for (int destIndex = index; destIndex < size; destIndex++)
			data[destIndex] = data[destIndex + 1];
		data[size] = null;
		return result;
	}

	// Returns true if the map contains the given key.
	@Override
	public boolean containsKey(K key) {
		return get(key) != null;
	}

	// Removes all elements from this map.
	@SuppressWarnings("unchecked")
	@Override
	public void clear() {
		data = (Entry<K, V>[])new Entry[DEFAULT_INITIAL_CAPACITY];
		size = 0;
	}

	// Returns the number of elements in this stack.
	public int size() {
		return size;
	}

	// Returns true only if this map has no elements.
	public boolean isEmpty() {
		return size == 0;
	}

	// Returns the string representation of this object.
	@Override
	public String toString() {
		String str = "[";
		
		if (! isEmpty()) {
			str += data[0];
			for (int current = 1; current < size; current++)
				str += ", " + data[current];
		}
		return str + "]";
	}
		
	// Returns an iterator for this map.
	public Iterator<Entry<K, V>> iterator() {
		return new ArrayMapIterator();
	}
	private class ArrayMapIterator implements Iterator<Entry<K, V>> {
		
		private int current = 0;
		
		@Override
		public boolean hasNext() {
			return (current < size);
		}
		
		@Override
		public Entry<K, V> next() {
			if (!hasNext())
				throw new NoSuchElementException();
			return data[current++];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}

}