package lmsActivities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity5 {
 
WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms/");
		Reporter.log("Test-Activity5 Started");
	}
	
	@Test
	public void accessMyAccount() {
	  
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		Assert.assertEquals(driver.getTitle(), "My Account – Alchemy LMS");
		Reporter.log("My Account link clicked and title "+driver.getTitle()+" found");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Test-Activity5 Completed");
	}

}
