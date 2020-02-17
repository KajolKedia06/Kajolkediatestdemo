
package TestNG;

import org.testng.annotations.Test;

public class decidingorder {

	@Test(priority=1)
	public void insert() {
		System.out.println("inserting demo data");
	}
	
	@Test(priority=3)
	public void select() {
		System.out.println("selecting demo data");
	}
	
	@Test(priority=2)
	public void update() {
		System.out.println("updating demo data");
	}
	
	@Test(priority=4)
	public void delete() {
		System.out.println("deleting demo data");
	}
}
