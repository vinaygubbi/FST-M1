package lmsActivities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms/");
		Reporter.log("Test-Activity1 Started");
	}
	
	@Test
	public void findTitle() {
	  
		Assert.assertEquals(driver.getTitle(), "Alchemy LMS – An LMS Application");
		Reporter.log("Title: "+driver.getTitle());
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Test-Activity1 Completed");
	}
}
