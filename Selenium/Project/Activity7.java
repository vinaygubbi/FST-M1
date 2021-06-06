package lmsActivities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity7 {
 
WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms/");
		Reporter.log("Test-Activity7 Started");
	}
	
	@Test
	public void findAllCourses() {
	  
		driver.findElement(By.xpath("//a[contains(text(),'All Courses')]")).click();
		
		WebElement courses = driver.findElement(By.xpath("//div[@class='ld-course-list-items row']"));		
		List<WebElement> numOfCourses = courses.findElements(By.xpath("./child::*"));
		Assert.assertEquals(numOfCourses.size(), 3);
		Reporter.log("Number of courses : "+numOfCourses.size());	
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Test-Activity7 Completed");
	}

}
