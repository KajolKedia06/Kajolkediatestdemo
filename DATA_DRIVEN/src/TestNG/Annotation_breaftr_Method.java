package TestNG;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
@Test
public class Annotation_breaftr_Method {
    public String baseUrl = "http://demo.guru99.com/test/newtours/";
    public WebDriver driver; 
    public String expected = null;
    public String actual = null;
    	@BeforeClass
    	public void testBeforeclass(){
    		System.out.println("****BEFORE CLASS****");
    	}
        @BeforeTest
      public void launchBrowser() {
          System.out.println("launching chrome browser"); 
          System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
  		driver=new ChromeDriver();	
          driver.get(baseUrl);
          System.out.println("***BEFORETEST*");
      }
      
      @BeforeMethod
      public void verifyHomepageTitle() {
          String expectedTitle = "Welcome: Mercury Tours";
          String actualTitle = driver.getTitle();
          System.out.println("***BEFORE METHOD**"+actualTitle);
          Assert.assertEquals(actualTitle, expectedTitle);
      }
          @Test(priority = 0)
      public void register(){
          driver.findElement(By.linkText("REGISTER")).click() ;
          expected = "Register: Mercury Tours";
          actual = driver.getTitle();
          Assert.assertEquals(actual, expected);
          System.out.println("****TEST prioroty 0***");
      }
          @Test(priority = 1)
      public void support() {
            driver.findElement(By.linkText("SUPPORT")).click() ;
            expected = "Under Construction: Mercury Tours";
            actual = driver.getTitle();
            Assert.assertEquals(actual, expected);
            System.out.println("****TEST prioroty 1***");
      }
      @AfterMethod
      public void goBackToHomepage ( ) {
            driver.findElement(By.linkText("Home")).click() ;
            System.out.println("***AFTER METHOD**");
      }
       
      @AfterTest
      public void terminateBrowser(){
          driver.close();
          System.out.println("***AFTERTEST*");
      }
      @AfterClass
      public void afterclasstest(){
    	  System.out.println("***AFTER CLASS***");
      }
      
      /*Before suite
       * Before test
       * Before class
       * Data provider
       * Before method
       * Test
       */
       
      
}