package TestNG;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(Itestlistner_Report.class)
public class Itestlistner_Subclass {
	public WebDriver driver;

	@Test
	public void testSimulation0() {

		Assert.assertTrue(true);

	}

	@Test
	public void testSimulation00() {

		Assert.assertTrue(false);

	}

	// Test case <testSimulation000> depends on the intentionally
	// failed test case <testSimulation00>

	@Test(dependsOnMethods = "testSimulation00")
	public void testSimulation000() {

	}
	}

