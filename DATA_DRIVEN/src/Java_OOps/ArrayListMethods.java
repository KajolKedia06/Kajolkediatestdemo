package Java_OOps;

import java.util.ArrayList;
import java.util.ListIterator;

public class ArrayListMethods {
  public static void main(String args[]) {
	  ArrayList <String> list=new ArrayList<String>();
	  list.add("jhon");
	  list.add("sam");
	  list.add("rock");
	  ListIterator<String> itr=list.listIterator();
		System.out.println("Adding Element");
		while(itr.hasNext()) {
			System.out.println("List"+itr.next());
		}
		
		 ArrayList <String> list1=new ArrayList<String>();
		 list1.add("jhon1");
		  list1.add("sam1");
		 list1.addAll(1,list);
		 
		 
		 ListIterator<String> itr1=list1.listIterator();
		 while(itr1.hasNext()) {
				System.out.println("Added list in list 1"+itr1.next());
			}
  }
}
