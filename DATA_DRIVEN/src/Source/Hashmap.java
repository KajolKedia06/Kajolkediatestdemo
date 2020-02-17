package Source;

import java.util.HashMap;
import java.util.Map.Entry;

public class Hashmap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, String> ab=new HashMap<String, String>();
		ab.put("one","kajol");
		ab.put("two","kanu");
		ab.put("three","twinkle");
		System.out.print(ab.get("two"));
		for(String i:ab.keySet()) {
			System.out.println("Key"+i);
		}
		
		for(String i:ab.values()) {
			System.out.println("values"+i);
		}
			
		for(Entry<String, String> i:ab.entrySet()) {
			System.out.println("entry"+i.getKey()+"55"+i.getValue());
		}
	}
	
}
