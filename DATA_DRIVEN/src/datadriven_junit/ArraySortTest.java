package datadriven_junit;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
@RunWith(Parameterized.class)
public class ArraySortTest {
 
  @Parameters
  public static Collection<Object[]> data() {
      return Arrays.asList(new Object[][] {
         { new String[] {"Google" }, new String[] {"Google" }},
         { new String[] {"Google" }, new String[] {"Google" }},
         });
  }
 
  private final String[] actual;
  private final String[] expected;
 
  public ArraySortTest(String[] actual, String[] expected){
      this.actual = actual; 
      this.expected = expected;
     
  }
  WebDriver driver;
	
	
	@Before
	public void BfreTest()
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();	
	}
 
  @Test
  public void testSort() throws InterruptedException{
	  System.out.println("Testing");
	  driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println(title);
		assertEquals(expected, actual);
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")).sendKeys("google");
		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[3]/center/input[1]")).click();
		String title1=driver.getTitle();
	   System.out.println(title1);
	   Thread.sleep(5000);
	   assertEquals(expected, actual);
      
     
      }
  @After
  public void endtest(){
	  driver.quit();
  }
  
}