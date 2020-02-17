package Keyword_driven_framework;
 
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
 
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 
public class Actions 
{
 public static WebDriver driver;
  
 public static void OpenBrowser()
 { 
 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
 driver=new ChromeDriver();
 }
  
 public static void navigate()
 { 
 
 driver.get("http://newtours.demoaut.com");
 }
  
 public static void input_Username()
 {
 driver.findElement(By.name("userName")).sendKeys("mercury"); 
 }
  
 public static void input_Password()
 {
 driver.findElement(By.name("password")).sendKeys("mercury");
 }
  
 public static void click_Login()
 {
 driver.findElement(By.name("login")).click();
 }
 

 public static void verify_login()
 {
 String pageTitle = driver.getTitle();
 Assert.assertEquals(pageTitle, "Find a Flight: Mercury Tours:");
 }
 
 public static void closeBrowser()
 {
 driver.quit();
 }
}