package TestNG;


import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;


public class Basic_Annotations {
    public String baseUrl = "https://www.google.com/";
    public WebDriver driver ; 
     
  @Test
  public void verifyHomepageTitle() throws InterruptedException, IOException {
       
      System.out.println("launching firefox browser"); 
      System.setProperty("webdriver.chrome.driver", "F:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();	
      driver.get(baseUrl);
      Thread.sleep(2000);
 
      
      driver.manage().window().maximize();
      Thread.sleep(2000);
      driver.manage().window().setSize(new Dimension(300, 400));
      System.out.println(driver.manage().window().getSize().getHeight());
      System.out.println(driver.manage().window().getSize().getWidth());
      String expectedTitle = "Welcome: google ";
      
      driver.manage().window().setPosition(new Point(20, 20));
      System.out.println("*****"+driver.manage().window().getPosition().getX());
      System.out.println("*****"+driver.manage().window().getPosition().getY());
      driver.manage().window().maximize();
      Actions actions =new Actions(driver);
      WebElement loc=driver.findElement(By.xpath("//a[@title='Google apps']"));
      actions.moveToElement(loc).build().perform();
      String loc1=driver.findElement(By.xpath("//a[@title='Google apps']")).getAttribute("title");
     System.out.println("+++++++++++++++"+loc1);
     takescreenshot(driver,"F:/kajolworkspace/DATA_DRIVEN/DATA_DRIVEN/screenshot/image.png");
      driver.quit();
  }
  public static void takescreenshot(WebDriver webdriver, String fileWithPath) throws IOException {
	  //Convert web driver object to TakeScreenshot
	  TakesScreenshot screenshot=((TakesScreenshot)webdriver);
	//Call getScreenshotAs method to create image file
	  File SrcFile=screenshot.getScreenshotAs(OutputType.FILE);
	//Move image file to new destination
      File DestFile=new File(fileWithPath);
      //Copy file at destination
      FileUtils.copyFile(SrcFile, DestFile);
	  
  }

}