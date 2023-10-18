package dafzaportal;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseClass {
	
	protected WebDriver driver;
	
	@BeforeClass
	public void Setup()

	{
		String browsername = "Chrome";

		if (browsername.equals("Chrome"))

		{
			driver = new ChromeDriver();
		} else if (browsername.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browsername.equals("edge")) {
			driver = new EdgeDriver();
		}
		else if (browsername.equals("safari")) {
			driver = new SafariDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://dafz--devstaging.sandbox.my.site.com/dafzcustomer/s/login/");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

}

