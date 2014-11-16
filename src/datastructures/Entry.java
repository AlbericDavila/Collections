//	By Alberic A. Davila Cadilla
//	Entry.java
//
//	Class that represents a map entry.

package datastructures;

public class Entry<K, V> {
	
	// Fields for the key and value of this entry
	private K key;
	private V value;
	
	// Creates a new entry with the given key and value.
	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	// Returns the key of this entry.
	public K getKey() {
		return key;
	}

	// Returns the value of this entry.
	public V getValue() {
		return value;
	}

	// Modifies the value of this entry.
	public void setValue(V value) {
		this.value = value;
	}
	
	// Returns a string representation of this entry.
	@Override
	public String toString() {
		return key + "=>" + value;
	}

}