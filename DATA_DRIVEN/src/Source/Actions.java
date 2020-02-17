package Source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Actions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.switchTo().frame(0);
		
		WebElement Source =driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement Dest =driver.findElement(By.xpath("//div[@id='droppable']"));
		 Actions actions =new Actions(driver);
	      
	}

}
