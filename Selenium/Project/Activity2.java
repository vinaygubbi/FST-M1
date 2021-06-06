package lmsActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity2 {
 
WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms/");
		Reporter.log("Test-Activity2 Started");
	}
	
	@Test
	public void findHeading() {
	  
		driver.findElement(By.xpath("//h1[contains(text(),'Learn from Industry Experts')]"));
		Reporter.log("Heading found - Learn from Industry Experts");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Test-Activity2 Completed");
	}

}
