package  hashmap;

// Java program to illustrate 
// Java.util.HashMap 
import java.util.HashMap; 
import java.util.Map; 

public class mapping_one 
{ 
	public static void main(String[] args) 
	{ 
	
		HashMap<String, Integer> map = new HashMap<>(); 
		
		System.out.println( "map is:- " + map); 
		map.put("vishal", 10); 
		map.put("sachin", 30); 
		map.put("vaibhav", 20); 
		
		System.out.println("Size of map is:- " + map.size()); 
	
		System.out.println( "map is:- " + map); 
		if (map.containsKey("vishal")) 
		{ 
			Integer a = map.get("vishal"); 
			System.out.println("value for key \"vishal\" is:- " + a); 
		} 
		
		map.clear(); 
		System.out.println( "map is:- " + map); 
	} 
}
	
