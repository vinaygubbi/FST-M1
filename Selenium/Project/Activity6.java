package lmsActivities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity6 {
 
WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms/");
		Reporter.log("Test-Activity6 Started");
	}
	
	@Test
	public void accountLogin() {
	  
		driver.findElement(By.xpath("//a[text()='My Account']")).click();
		
		Assert.assertEquals(driver.getTitle(), "My Account – Alchemy LMS");
		Reporter.log("My Account Title: "+driver.getTitle());
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		
		driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.xpath("//input[@id='user_login']"));
		WebElement password = driver.findElement(By.xpath("//input[@id='user_pass']"));
		WebElement loginbtn = driver.findElement(By.xpath("//input[@id='wp-submit']"));
		
		username.sendKeys("root");
		password.sendKeys("pa$$w0rd");
		loginbtn.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).isDisplayed();
		
		Reporter.log("Login is successful");
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Test-Activity6 Completed");
	}

}
