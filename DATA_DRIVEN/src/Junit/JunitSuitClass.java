package Junit;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


	@RunWith(Suite.class)
	@Suite.SuiteClasses({
		JunitAnnotationExample.class, //test case 1
		JunitClass2.class     //test case 2
	})
	public class JunitSuitClass {

	}

