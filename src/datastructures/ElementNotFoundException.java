//  By Alberic A. Davila
//  ElementNotFoundException.java
//
//  Exception for an element that is not found in a structure

package datastructures;

@SuppressWarnings("serial")
public class ElementNotFoundException extends RuntimeException {
	
	// Creates a new exception with the given message.
	public ElementNotFoundException(String message) {
		super(message);
	}
	
	// Creates a new exception with the default message.
	public ElementNotFoundException() {
		super("element was not found");
	}

}