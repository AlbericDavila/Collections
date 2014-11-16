/*
 * StackTest.java
 * This source file contains a class that tests the Stack interface and
 * implementation.
 */

package tests;

//import datastructures.LinkedStack;
import datastructures.ArrayStack;
import datastructures.ElementNotFoundException;
import datastructures.Stack;

public class StackTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Stack<String> stk = new ArrayStack<String>();
		
		System.out.println("After creating a new stack...");
		print(stk);
		System.out.println();
		
		stk.push("cat");
		stk.push("dog");
		stk.push("tree");
		stk.push("house");
		stk.push("boat");
		stk.push("woman");
		stk.push("man");
		
		System.out.println("After adding some elements...");
		print(stk);
		System.out.println();
		
		System.out.println("The top element is " + stk.peek());
		System.out.println();
				
		System.out.println("Removing: " + stk.pop());
		System.out.println("Removing: " + stk.pop());
		
		System.out.println("After removing the top two elements...");
		print(stk);
		System.out.println();
		
		System.out.println("The top element is " + stk.peek());
		System.out.println();
		
		stk.clear();
		System.out.println("After clearing the stack...");
		print(stk);
		System.out.println();
		
		System.out.println("Trying to get the top element...");
		try {
			System.out.println("The top element is " + stk.peek());
		}
		catch (ElementNotFoundException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
	
	// Prints the data, size and empty status of this stack.
	public static <E> void print(Stack<E> stk) {
		System.out.println("This is the stack: " + stk);
		System.out.println("Its size is " + stk.size());
		System.out.println("Is it empty? " + stk.isEmpty());
	}


}