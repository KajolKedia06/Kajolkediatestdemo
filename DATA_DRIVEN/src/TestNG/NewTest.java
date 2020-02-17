package TestNG;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class NewTest {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver ; 
     
  @Test
  public void verifyHomepageTitle() {
       
      System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		driver=new ChromeDriver();	
      driver.get(baseUrl);
      String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
      driver.close();
      System.out.println("Test 1 completed");
  }
}