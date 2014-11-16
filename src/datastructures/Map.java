//	By Alberic A. Davila Cadilla	
//	Map.java
//
//	Interface for a map.

package datastructures;

public interface Map<K, V> extends Iterable<Entry<K, V>> {
	
	// Returns the value associated with the given key.
	V get(K key);
	
	// Adds or modifies the value associated with the given key.
	void put(K key, V value);
	
	// Removes and returns the value associated with the given key.
	V removeKey(K key);
	
	// Returns true if the map contains the given key.
	boolean containsKey(K key);
	
	// Removes all elements from this map.
	void clear();

	// Returns the number of elements in this map.
	int size();

	// Returns true only if this map has no elements.
	boolean isEmpty();

}
