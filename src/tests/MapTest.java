/*
 * MapTest.java
 * By Antonio F. Huertas
 * Test application for the map interface and implementations.
 */

package tests;

import datastructures.*;

public class MapTest {

	// Serves as the entry point for this application.
	public static void main(String[] args) {
		Map<String, String> map = new LinkedMap<String, String>();
		
		System.out.println("After creating a new map...");
		print(map);
		System.out.println();
		
		map.put("house", "casa");
		map.put("dog", "perro");
		map.put("cat", "gato");
		map.put("tree", "‡rbol");
		map.put("woman", "mujer");
		map.put("man", "hombre");
		map.put("boat", "bote");
		
		System.out.println("After adding some elements...");
		print(map);
		System.out.println();
				
		System.out.println("Does it contains house? " + map.containsKey("house"));
		System.out.println("The definition of house is " + map.get("house"));
		System.out.println();
		
		System.out.println("Traversing the map...");
		for (Entry<String, String> element : map)
			System.out.println("Key: " + element.getKey() + 
					"\tValue: " + element.getValue());
		System.out.println();
		
		map.put("boat", "barco");
		
		System.out.println("After changing the definition of boat...");
		print(map);
		System.out.println();
		
		System.out.println("Removing: boat=>" + map.removeKey("boat"));
		System.out.println("Removing: house=>" + map.removeKey("house"));
		System.out.println("Removing: woman=>" + map.removeKey("woman"));
		
		System.out.println("After removing three elements...");
		print(map);
		System.out.println();
		
		System.out.println("Does it contains house? " + map.containsKey("house"));
		System.out.println("The definition of house is " + map.get("house"));
		System.out.println();
		
		map.clear();
		System.out.println("After clearing the map...");
		print(map);
		System.out.println();
		
		System.out.println("Trying to get the definition of boat...");
		String value = map.get("boat");
		if (value != null)
			System.out.println("boat is " + value);
		else
			System.out.println("Error: map does not contain boat");
	}

	// Prints the data, size and empty status of this map.
	public static <E> void print(Map<String, String> map) {
		System.out.println("This is the collection: " + map);
		System.out.println("Its size is " + map.size());
		System.out.println("Is it empty? " + map.isEmpty());
	}

}
