package lmsActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity3 {
 
WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms/");
		Reporter.log("Test-Activity3 Started");
	}
	
	@Test
	public void findFirstInfoBoxTitle() {
	  
		driver.findElement(By.xpath("//h3[contains(text(),'Actionable Training')]"));
		Reporter.log("First Info Box Title found - Actionable Training");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Test-Activity3 Completed");
	}

}
