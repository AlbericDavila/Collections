//	By Alberic A. Davila Cadilla
//  LinkedQueue.java
//
//  This class implements a queue using links.

package datastructures;

public class LinkedQueue<E> implements Queue<E> {
	
	private Node<E> front, rear;
	
	private int count;
	
	@Override
	public void enqueue(E element) {
		Node<E> node = new Node<E>(element,null);
		if (front == null)
			front = rear = node;
		else 
			rear = rear.next = node;
		count++;
	}

	@Override
	public E dequeue() {
		if (isEmpty()) 
			throw new ElementNotFoundException("List is empty");
		E element = front.data;
		front = front.next;
		if (front == null)
			rear = null;
		count--;
		return element;
	}
	
	@Override
	public E peek() {
		if (isEmpty())
			throw new ElementNotFoundException("Cannot peek, list is empty");
		return front.data;
		
	}
	
	@Override 
	public boolean isEmpty() {
		return (count == 0);
	}
	
	@Override
	public int size() {
		return count;
	}
	
	@Override
	public void clear() {
		front = rear = null;
		count = 0;
	}
	
	public String toString() {
		String str = "[";
		if (!isEmpty()) {
			str += front.data;
			for(Node<E> current= front.next; current != null; current = current.next)
				str += ", " + current.data;
		}
		return str += "]";
	}
}
