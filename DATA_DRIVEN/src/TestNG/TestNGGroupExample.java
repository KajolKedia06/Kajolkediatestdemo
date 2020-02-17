package TestNG;
 
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
 
public class TestNGGroupExample {
 
    @BeforeGroups("database")
    public void setUpSecurity() {
        System.out.println("****BEFORE_Group**********");
    }
  
    @AfterGroups("database")
    public void tearDownSecurity() {
        System.out.println("*****AFTER_Group**********");
    }
 
 
    @Test(groups= "database")
    public void testInsert(){
        System.out.println("testInsert()");
    }
     
    @Test(groups= "database1")
    public void testUpdate(){
        System.out.println("testUpdate()");
    }

}