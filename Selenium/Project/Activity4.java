package lmsActivities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity4 {
 
WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms/");
		Reporter.log("Test-Activity4 Started");
	}
	
	@Test
	public void find2ndCourseTitle() {
	  
		driver.findElement(By.xpath("//h3[text()='Email Marketing Strategies']"));
		Reporter.log("2nd Most Popular Course Title found - Email Marketing Strategies");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Test-Activity4 Completed");
	}

}
