/*
 * EntryTest.java
 * By Antonio F. Huertas
 * Test application for the Entry class.
 */

package tests;

import java.util.Scanner;
import datastructures.Entry;

public class EntryTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Entry<String, Integer> e1 = new Entry<String, Integer>("John", 20);
		Entry<String, Integer> e2 = new Entry<String, Integer>("Jane", 18);
		
		System.out.println("This is e1: " + e1);
		System.out.println("This is e2: " + e2);
		System.out.println("Are e1 and e2 equal? " + e1.equals(e2));
		System.out.println();
		
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter a new age for e2: ");
		e2.setValue(kb.nextInt());
		kb.close();
		
		System.out.println("Now, the key of e2 is " + e2.getKey() +
				" and its corresponding value is " + e2.getValue());
	}

}
