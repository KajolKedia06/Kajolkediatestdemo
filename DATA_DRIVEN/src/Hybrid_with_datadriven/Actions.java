package Hybrid_with_datadriven;

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
 static String dataPath = "C:\\Selenium\\DATA_DRIVEN\\src\\Data\\keyword_datadriven.xlsx"; 
 ReadExcelData obj2=new ReadExcelData();
 public static void OpenBrowser()
 { 
 System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
 driver=new ChromeDriver();
 }
  
 public static void navigate()
 { 
 
 driver.get("https://www.crossword.in/login");
 }
  static String user=null;

 public static void input_Username() throws Exception
 {
	 int  iRow=1;
	 int iCol=0;
	 ReadExcelData.setExcelFile(dataPath, "Sheet1");
	 user = ReadExcelData.getCellData(iRow, iCol);
	 Properties prop = Read_OR.getObjectRepository();
	 

	 //System.out.println("username:"+Read_OR.prop.getProperty("username"));
	//System.out.println(">>>>>>>>>>>USERNAME<<<<<<<<<<<<<");
 //driver.findElement(By.name("username")).sendKeys("mercury");
	 
 driver.findElement(By.id(prop.getProperty("usernamecrosswrd"))).sendKeys(user); 
System.out.println("*************USERNAME END*************");

 }
  
 public static void input_Password() throws Exception
 {
	 System.out.println("*************PASSWORD STARTS*************");
	 int  iRow=1;
	 int  iCol=1;
	// Properties  prop = new Properties();

	 ReadExcelData.setExcelFile(dataPath, "Sheet1");
	 user = ReadExcelData.getCellData(1, 1);
	 Properties prop = Read_OR.getObjectRepository();
	 
	

	 driver.findElement(By.id(prop.getProperty("passwordcrosswrd"))).sendKeys(user);
 }
  
 public static void click_Login() throws IOException
 { Properties prop = Read_OR.getObjectRepository();
 driver.findElement(By.id("user_session_submit")).click();
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