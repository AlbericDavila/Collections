/*
 * QueueTest.java
 * This source file contains a class that tests the Queue interface and
 * implementation.
 */

package tests;

import datastructures.LinkedQueue;
import datastructures.ElementNotFoundException;
import datastructures.Queue;

public class QueueTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Queue<String> que = new LinkedQueue<String>();
		
		System.out.println("After creating a new queue...");
		print(que);
		System.out.println();
		
		que.enqueue("cat");
		que.enqueue("dog");
		que.enqueue("tree");
		que.enqueue("house");
		que.enqueue("boat");
		que.enqueue("woman");
		que.enqueue("man");
		
		System.out.println("After adding some elements...");
		print(que);
		System.out.println();
		
		System.out.println("The front element is " + que.peek());
		System.out.println();
				
		System.out.println("Removing: " + que.dequeue());
		System.out.println("Removing: " + que.dequeue());
		
		System.out.println("After removing the two front elements...");
		print(que);
		System.out.println();
		
		System.out.println("The front element is " + que.peek());
		System.out.println();
		
		que.clear();
		System.out.println("After clearing the queue...");
		print(que);
		System.out.println();
		
		System.out.println("Trying to get the front element...");
		try {
			System.out.println("The front element is " + que.peek());
		}
		catch (ElementNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	// Prints the data, size and empty status of this queue.
	public static <E> void print(Queue<E> que) {
		System.out.println("This is the queue: " + que);
		System.out.println("Its size is " + que.size());
		System.out.println("Is it empty? " + que.isEmpty());
	}


}