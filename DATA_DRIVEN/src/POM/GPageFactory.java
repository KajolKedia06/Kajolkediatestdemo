package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GPageFactory {
	@FindBy(how =How.XPATH ,using ="//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")
	 public WebElement search;
	
@FindBy(how = How.XPATH, using ="//ul[@class='erkvQe']")
public WebElement searchbtn;

@FindBy(how =How.PARTIAL_LINK_TEXT, using ="Selenium - Web Brow")
public WebElement linkclick;

@FindBy(how=How.XPATH,using="html/body/div[3]/div[2]/div[2]/h2[1]")
public WebElement header;
}

	



