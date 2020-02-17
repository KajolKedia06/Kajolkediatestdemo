package Java_OOps;

import java.util.*;  


public class LinkedList {
	public static void main(String args[]) {
		 // LinkedList <String> list=new LinkedList<String>();
		//LinkedList<String> ll=new LinkedList<String>();    
		 Map<Integer,String> map=new HashMap<Integer,String>();  
		  map.put(100,"Amit");  
		  map.put(101,"Vijay");  
		  map.put(102,"Rahul");  
		  //Elements can traverse in any order  
		  for(Map.Entry m:map.entrySet()){  
		   System.out.println(m.getKey()+" "+m.getValue());  
		  }  
		  
		  System.out.println("Getting only key");
		  for(Integer s:map.keySet()) {
			  System.out.println(s);
		 } 
	
	 for(String s:map.values()) {
	System.out.println(s);
}
	}

}