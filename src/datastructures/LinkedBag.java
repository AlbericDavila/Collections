//	By Alberic A. Davila Cadilla
//	LinkedBag.java
//
//	This class implements a bag using links.

package datastructures;

public class LinkedBag<E> implements Bag<E> {
	
	private Node<E> first;
	private int count;
	
	// Hace add alfrente de la lista 
	@Override
	public void add(E elem) {
		Node<E> node = new Node<E>(elem, first);
		first = node;
		count++;
	}
	
	@Override
	public void remove(E elem) {
		Node<E> curr = positionOf(elem);
		if(curr == null) 
			throw new ElementNotFoundException();
		curr.data = first.data;
		first = first.next;
		count--;
	}
	
	@Override
	public boolean contains (E elem) {
		return (positionOf(elem) != null);
		
	}
		
	public boolean isEmpty() {
		return (count == 0);
	}
	
	public int size() {
		return count;
	}
	
	public void clear() {
		first = null;
		count = 0;
	}
	
	private Node<E> positionOf(E elem) {
		for(Node<E> curr = first; curr != null; curr = curr.next)
			if(elem.equals(curr.data))
				return curr;
		return null;
	}
	
	public String toString() {
		String str = "[";
		if(first != null) {
			str += first.data;
			for(Node<E> curr = first.getNext(); curr != null; curr = curr.next)
				str += ", " + curr.data;
		}
			return (str += "]");
			
		
	}


}
