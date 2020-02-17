package Junit;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitAnnotationExample extends Junit_Test_Report_Sample2 {
	WebDriver driver;
	
	@BeforeClass
	public static void BfreClass()
	{
		System.out.println("Before class is called");
	}
	
	@Before
	public void BfreTest()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();	
		System.out.println("Before Method is called");
	}
	
	@Test
	public void Test() throws InterruptedException{
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		System.out.println(title);
		System.out.println("1st Test Annotation is called");
//		assertEquals(title, "Google");
//		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[1]/div/div[1]/input")).sendKeys("google");
//		driver.findElement(By.xpath("//*[@id='tsf']/div[2]/div/div[3]/center/input[1]")).click();
//		String title1=driver.getTitle();
//	   System.out.println(title1);
//	   Thread.sleep(5000);
//	   assertEquals(title1, "Google");
		
	}
	
	@Ignore
	public void Ignoretest(){
		System.out.println("this line should not be printed");
	}
	
	@Test
	public void nextTest() {
		System.out.println("This is test two");
		assertTrue (true);
	}
	
	@After
	public void AftrTest(){
		System.out.println("Aftr Method is called");
		driver.quit();
	}
	
	@AfterClass
	public static void AftrClass()
	{
	
		System.out.println("After class is called");
	}
}
