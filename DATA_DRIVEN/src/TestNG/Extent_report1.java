package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Extent_report1 {
	public WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	@BeforeTest
		public void setReport() {
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")
					+ "\\extentReportFile.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Report");
		htmlReporter.config().setTheme(Theme.DARK);
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("HostName", "LocalHost");
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Tester", "Kajol");
	
		}
	
	@BeforeMethod()
		public void setup() {
			// Launch the Chrome browser.
			 System.setProperty("webdriver.chrome.driver", "F:\\chromedriver.exe");
			   driver = new ChromeDriver();
			driver.manage().window().maximize();
			// Open application.
			driver.get("https://www.techbeamers.com/");
		}
		
	
	@Test
	public void verifySeleniumBlog() {
		test=extent.createTest("checkBrowserpass");
		// get title.
				String title = driver.getTitle();
		// Verify title.
				if(title.equalsIgnoreCase("Programming and Testing Tutorials for Beginners - TechBeamers")) {
					test.log(Status.PASS, "Passes");
				}
				else {
					test.log(Status.FAIL," fail");
				}
				
				//fail
				
				test=extent.createTest("checkBrowserfail");
				// get title.
						String title1 = driver.getTitle();
				// Verify title.
						if(title.equalsIgnoreCase("Programmi- TechBeamers")) {
							test.log(Status.PASS, "Passes");
						}
						else {
							test.log(Status.FAIL," fail");
						}
	}
	 @AfterTest
	 public void end() {
		 extent.flush();
	 }
	
	 @AfterMethod
	    public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	           
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	 }
	}

