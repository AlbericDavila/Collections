//	By Alberic A. Davila Cadilla
//	TreeMap.java
//
//	Class that implements a map as a binary search tree.

package datastructures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeMap<K extends Comparable<K>, V> implements Map<K, V> {

	// Field for the root node of this map
	private TreeNode<Entry<K, V>> root;

	// Field for the size of this map
	private int size;
	
	// Returns the value associated with the given key.
	@Override
	public V get(K key) {
		return getHelper(key, root);
	}

	private V getHelper(K key, TreeNode<Entry<K, V>> current) {
		if (current == null) {
			return null;
		}
		else 
		{
			int comparison = key.compareTo(current.data.getKey());
			if (comparison < 0)
				return getHelper(key, current.left);
			else if (comparison > 0)
				return getHelper(key, current.right);
			else
				return current.data.getValue();
		}
	}

	// Adds or modifies the value associated with the given key.
	@Override
	public void put(K key, V value) {
		root = putHelper(key, value, root);
	}

	private TreeNode<Entry<K, V>> putHelper(K key, V value, TreeNode<Entry<K, V>> current) {
		if (current == null) {
			current = new TreeNode<Entry<K, V>>(new Entry<K, V>(key, value), null, null);
			size++;
		}
		else {
			int comparison = key.compareTo(current.data.getKey());
			if (comparison < 0)
				current.left = putHelper(key, value, current.left);
			else if (comparison > 0)
				current.right = putHelper(key, value, current.right);
			else
				current.data.setValue(value);
		}
		return current;
	}

	// Removes and returns the value associated with the given key.
	@Override
	public V removeKey(K key) {
		V value = get(key);
		if (value == null)
			return null;

		root = removeHelper(key, root);
		size--;
		return value;
	}

	private TreeNode<Entry<K, V>> removeHelper(K key, TreeNode<Entry<K, V>> current) {
		if (current == null) {
			return null;
		}
		else 
		{
			int comparison = key.compareTo(current.data.getKey());
			if (comparison < 0)
				return removeHelper(key, current.left);
			else if (comparison > 0)
				return removeHelper(key, current.right);
			else
				current = deleteNode(current);
		}
		return current;
	}

	private TreeNode<Entry<K, V>> deleteNode(TreeNode<Entry<K, V>> node) {
		if (node.right == null)         // node with left child or leaf
			node = node.left;
		else if (node.left == null)     // node with right child or leaf
			node = node.right;
		else {                          // node with two children
			TreeNode<Entry<K, V>> successor = getSuccessor(node);
			node.data = successor.data;
			node.right = removeHelper(node.data.getKey(), node.right);
		}
		return node;
	}
	
	private TreeNode<Entry<K, V>> getSuccessor(TreeNode<Entry<K, V>> node) {
		TreeNode<Entry<K, V>> current = node.right;
		while (current.left != null)
			current = current.left;
		return current;
	}

	// Returns true if the map contains the given key.
	@Override
	public boolean containsKey(K key) {
		return get(key) != null;
	}

	// Removes all elements from this collection.
	@Override
	public void clear() {
		root = null;
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
		Iterator<Entry<K, V>> it = iterator();
		
		if (it.hasNext()) {
			str += it.next();
			
			while (it.hasNext())
				str += ", " + it.next();
		}
		return str + "]";
	}

	// Returns an iterator for this map.	
	@Override
	public Iterator<Entry<K, V>> iterator() {
		return new TreeMapIterator();
	}

	
	
	
	
	
	
	
	// Iterator private class
	private class TreeMapIterator implements Iterator<Entry<K, V>> {

		// Reference to a queue with the contents of the tree
		private Queue<Entry<K, V>> contents = new LinkedQueue<Entry<K, V>>();

		// Creates a new iterator using an inorder traversal.
		public TreeMapIterator() {
			inorder(root);
		}

		// Populates the contents queue by traversing the tree.
		private void inorder(TreeNode<Entry<K, V>> current) {
			if (current != null) {
				inorder(current.left);
				contents.enqueue(current.data);
				inorder(current.right);
			}
		}

		// Returns true only if this iterator has another element.
		@Override
		public boolean hasNext() {
			return !contents.isEmpty();
		}

		// Returns the next element in this iterator.
		@Override
		public Entry<K, V> next() {
			if (! hasNext())
				throw new NoSuchElementException();
			return contents.dequeue();
		}

		// Unsupported: Removes the current element from this iterator.
		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

}