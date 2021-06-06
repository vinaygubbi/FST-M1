package lmsActivities;

import org.testng.annotations.Test;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class Activity8 {
 
WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://alchemy.hguy.co/lms/");
		Reporter.log("Test-Activity8 Started");
	}
	
	@Test
	public void contactSupport() throws InterruptedException {
	  
		driver.findElement(By.xpath("//a[contains(text(),'Contact')]")).click();
		
		String fullName = driver.findElement(By.xpath("//label[contains(text(),'Full Name')]")).getAttribute("for");
		String email = driver.findElement(By.xpath("//label[contains(text(),'Email')]")).getAttribute("for");
		String subject = driver.findElement(By.xpath("//label[contains(text(),'Subject')]")).getAttribute("for");
		String comment = driver.findElement(By.xpath("//label[contains(text(),'Comment')]")).getAttribute("for");
		
		driver.findElement(By.id(fullName)).sendKeys("First Last");
		Thread.sleep(2000);
		driver.findElement(By.id(email)).sendKeys("abc@lms.com");
		Thread.sleep(2000);
		driver.findElement(By.id(subject)).sendKeys("LMS Project Testing");
		Thread.sleep(2000);
		driver.findElement(By.id(comment)).sendKeys("LMS Project Testing");
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//button[contains(text(),'Send Message')]")).click();
		
		WebElement message = driver.findElement(By.xpath("//div[contains(@class,'confirmation-container')]"));
		Assert.assertEquals(message.getText(), "Thanks for contacting us! We will be in touch with you shortly.");
		Reporter.log("Confirmation Message : "+message.getText());
		
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
		Reporter.log("Test-Activity8 Completed");
	}

}
