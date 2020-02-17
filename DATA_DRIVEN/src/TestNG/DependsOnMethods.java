
package TestNG;

import org.testng.annotations.Test;

public class DependsOnMethods {

	@Test
	public void insert() {
		System.out.println("inserting demo data");
	}
	
	@Test(dependsOnMethods="insert")
	public void select() {
		System.out.println("selecting demo data");
	}
	
	@Test(dependsOnMethods="select")
	public void update() {
		System.out.println("updating demo data");
	}
	
	@Test(dependsOnMethods="update")
	public void delete() {
		System.out.println("deleting demo data");
	}
}
