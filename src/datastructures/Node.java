//	By Alberic A. Davila Cadilla	
//	Node.java
//
//	This class represents a Node and it's used through out 
//	this entire project.
package datastructures;

public class Node<T> {

	T data;
	Node<T> next;
	
	//	Set the data(value)
	//	and pointer to the next node
	public Node(T data, Node<T> next) {
		this.data = data;
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	@Override
	public String toString() {
		return data + "-->" + next;
	}	
}
