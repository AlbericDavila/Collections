//	By Alberic A. Davila Cadilla
//  LinkedMap.java
//
//  Class that implements a map using links.
 

package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedMap<K, V> implements Map<K, V> {

	// Field for the head node of this map
	private Node<Entry<K, V>> head = null;

	// Field for the size of this map
	private int size = 0;

	// Returns the value associated with the given key.
	@Override
	public V get(K key) {
		for (Node<Entry<K, V>> curr = head; curr != null; curr= curr.next) {
			if (key.equals(curr.data.getKey())) {
				return curr.data.getValue();
			}
		}
		return null;
	}

	// Adds or modifies the value associated with the given key.
	@Override
	public void put(K key, V value) {
		// Buscar si el valor exisiste, y si existe, reemplazarlo
		for (Node<Entry<K, V>> curr = head; curr != null; curr= curr.next) {
			if (key.equals(curr.data.getKey())) {
				curr.data.setValue(value);
				return;
			}
		}
		// If the data is not found, insert it at the begining of the link.
		head = new Node<Entry<K, V>>(new Entry<K, V>(key, value), head);
		size++;
	}

	// Removes and returns the value associated with the given key.
		@Override
		public V removeKey(K key) {
			Node<Entry<K, V>> previous = null, current = head;

			while (current != null && ! key.equals(current.data.getKey())) {
				previous = current;
				current = current.next;
			}
			if (current == null)
				return null;

			V value = current.data.getValue();
			if (current == head)      // removing first element
				head = current.next;
			else                      // removing inner or last element
				previous.next = current.next;
			size--;
			return value;
		}


	// Returns true if the map contains the given key.
	@Override
	public boolean containsKey(K key) {
		return (get(key) != null);
	}

	// Removes all elements from this map.
	@Override
	public void clear() {
		head = null;
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
			str += head.data;
			for (Node<Entry<K, V>> current = head.next; current != null; current = current.next)
				str += ", " + current.data;
		}
		return str + "]";
	}

	// Returns an iterator for this map.
		public Iterator<Entry<K, V>> iterator() {
			return new LinkedMapIterator();
		}

		// Iterator private class
		private class LinkedMapIterator implements Iterator<Entry<K, V>>  {

			// Field for the current node in this iterator
			private Node<Entry<K, V>> current = head;

			// Returns true only if this iterator has another element.
			@Override
			public boolean hasNext() {
				return current != null;
			}

			// Returns the next element in this iterator.
			@Override
			public Entry<K, V> next() {
				if (! hasNext())
					throw new NoSuchElementException();
				Entry<K, V> element = current.data;
				current = current.next;
				return element;
			}

			// Unsupported: Removes the current element from this iterator.
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

		}

	}

