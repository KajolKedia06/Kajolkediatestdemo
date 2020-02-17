package Junit;

import static org.testng.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JunitClass2 {
	WebDriver driver;
	
	@Before
	public void BfreTest()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();	
	}
	
	@Test
	public void Test(){
		driver.get("https://www.google.com/");
		String title=driver.getTitle();
		assertEquals(title, "Google");
	}
	
	@Ignore
	public void Ignoretest(){
		System.out.println("this line should not be printed");
	}
	
	@After
	public void AftrTest(){
		driver.quit();
	}
	
}
