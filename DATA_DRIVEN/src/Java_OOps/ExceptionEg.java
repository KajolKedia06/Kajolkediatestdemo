package Java_OOps;

public class ExceptionEg {

	static void age(int age) throws InvalidAgeException {
		if(age<18) {
			throw new InvalidAgeException("OInvalidAgeException");

			
		}
		else {
			System.out.println("valcome");
		}
	}
	public static void main(String[] args) throws InvalidAgeException {
		// TODO Auto-generated method stub
		age(10);
	}

}
  