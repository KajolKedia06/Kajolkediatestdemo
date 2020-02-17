package Hybrid_framework;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;
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
  
 public static void input_Username() throws IOException
 {
	 Properties prop = Read_OR.getObjectRepository();
	 
	 //System.out.println("username:"+Read_OR.prop.getProperty("username"));
	//System.out.println(">>>>>>>>>>>USERNAME<<<<<<<<<<<<<");
 //driver.findElement(By.name("username")).sendKeys("mercury");
 driver.findElement(By.name(prop.getProperty("username"))).sendKeys("mercury"); 

 }
  
 public static void input_Password() throws IOException
 {
	// Properties  prop = new Properties();
	 Properties prop = Read_OR.getObjectRepository();
 driver.findElement(By.name(prop.getProperty("password"))).sendKeys("mercury");
 }
  
 public static void click_Login() throws IOException
 { Properties prop = Read_OR.getObjectRepository();
 driver.findElement(By.name(prop.getProperty("login"))).click();
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