package Java_OOps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;


public class Itertaion {
	ArrayList<Integer> list=new ArrayList<>();
public static void ArrayItertaion() {
 int a[]=new int [10];
 
 for(int i=0;i<10;i++) {
	 a[i]=i;
 }
 System.out.println("ARRAY");
	
for(int itr:a) {
	System.out.println(itr);
	
}
	
	
}


public static void iterator() {
	ArrayList<Integer> list=new ArrayList<>();
	list.add(1);
	list.add(2);
	Iterator itr= list.iterator();
	//Iterator iterator = list.iterator(); 
	System.out.println("ITERATOR");
	while(itr.hasNext()) {
		
		System.out.println(itr.next());
	}
}
public static void listitr() {
	ArrayList<Integer> list=new ArrayList<>();
	list.add(1);
	list.add(2);
	ListIterator<Integer> itr=list.listIterator();
	System.out.println("LISTITERATOR");
	while(itr.hasNext()) {
		System.out.println("In forward direction"+itr.next());
	}
	while(itr.hasPrevious()) {
		System.out.println("in backward direction"+itr.previous());
	}
	
	
	}



public static void main(String args[]) {
	 ArrayItertaion();
	 iterator();
	listitr();
}

}
