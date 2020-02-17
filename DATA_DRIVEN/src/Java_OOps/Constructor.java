package Java_OOps;

class Constructor {

	
	  int a ; static int b; final int c;
	  
	  void display() { System.out.print(a); System.out.print(b); 
	  System.out.print(c); }
	  
	  
	  Constructor() {
	  
	  
	  c=9; System.out.print(c);
	  
	  }
	  
	  
	  
	  public static void main(String args[]) { 
		  Constructor ob =new Constructor();
	  ob.display();
	  
	  }
	 
	  
	 

}




 