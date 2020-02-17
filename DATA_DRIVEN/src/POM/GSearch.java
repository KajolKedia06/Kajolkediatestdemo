package POM;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import POM.GPageFactory;
public class GSearch {
private WebDriver driver;

@BeforeMethod
public void setup(){
System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
driver = new ChromeDriver();
}
@Test
public void searchingmethod(){ 
	driver.get("https://www.google.co.in");
//GPageFactory page =PageFactory.initElements(driver, GPageFactory.class);
	GPageFactory page=PageFactory.initElements(driver, GPageFactory.class);
	page.search.sendKeys("selenium"); 
	page.search.sendKeys(Keys.ENTER);
	page.linkclick.click();
	String s= page.header.getText();
	assertEquals("What is Selenium?", s);
	
}
}
