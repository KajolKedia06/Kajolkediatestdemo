package Java_OOps;

public class Encapsulation {

	private int salary=40000;
//access modifier of get and set should be public 
	public int getSalary() {
		
		if(salary>1000)
		{
		System.out.println("nice salary");
		}
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = 50000;
		System.out.println("set salary called");
	}
	
	public static void main (String args[]) {
		Encapsulation ob=new Encapsulation();
		ob.getSalary();
		ob.setSalary(1000);
	}
}
