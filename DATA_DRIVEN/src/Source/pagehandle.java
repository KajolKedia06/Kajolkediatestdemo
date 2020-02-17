package Source;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class pagehandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("http://www.crossword.in/");
		String handle=driver.getWindowHandle();
		driver.switchTo().window(handle);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 

	}

}
