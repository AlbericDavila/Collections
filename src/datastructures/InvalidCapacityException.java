// 	By Alberic A. Davila Cadilla
//	InvalidCapacityException.java
// 
// Class that represents an exception for an invalid capacity.

package datastructures;

@SuppressWarnings("serial")
public class InvalidCapacityException extends RuntimeException {
	
	// Creates a new exception with the given message.
	public InvalidCapacityException(String message) {
		super(message);
	}
	
	// Creates a new exception with the default message.
	public InvalidCapacityException() {
		this("capacity is invalid");
	}

}