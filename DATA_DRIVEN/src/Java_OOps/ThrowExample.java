package Java_OOps;

public class ThrowExample {

	static int age;
	
	public static void display(int age){
		/*
		 * if(age<18) { throw new ArithmeticException("not valid");
		 * 
		 * } else { System.out.println("Welcome"); }
		 */
		if (age < 18) {
		      throw new ArithmeticException("Access denied - You must be at least 18 years old.");
		    }
		    else {
		      System.out.println("Access granted - You are old enough!");
		    }
	}
	
	public static void main(String args[]) {
		display(20);
}
}