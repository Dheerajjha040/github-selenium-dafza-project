package com.dafzaportal.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login {

	WebDriver driver;

	@BeforeMethod
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

	@Test(priority = 1)
	public void verifyLoginWithValidCredentials() {

		driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("dheeraj.jha@cloudearly.com");
		driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("Passw0rd@456");
		driver.findElement(By.xpath("//button//span['Log in']")).click();

		Assert.assertTrue(driver.findElement(By.xpath("//a[text()='Home']")).isDisplayed(),
				"Please enter the Valid Credentials");

	}

	@Test(priority = 2)
	public void verifyLoginWithInValidCredentials() {

		driver.findElement(By.xpath("//input[@placeholder = 'Username']")).sendKeys("dheeraj.jha@cloudearly.com");
		driver.findElement(By.xpath("//input[@placeholder = 'Password']")).sendKeys("jsdfksd");
		driver.findElement(By.xpath("//button//span['Log in']")).click();

		Assert.assertTrue(driver.findElement(By.xpath(
				"//div[text() ='Your login attempt has failed. Make sure the username and password are correct.']"))
				.isDisplayed(), "Expected warning message not displayed");

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
