package project;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Chrome_Activity1 {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Android Pixel");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL serverURL = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(serverURL, caps);
		wait = new WebDriverWait(driver, 10);
		
		 driver.get("https://www.training-support.net/selenium");
		// wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@text='Get Started!']"))).click();
	}

	@Test
	public void chromToDo() {

		String[] tasksToAdd = { "Add tasks to list", "Get number of tasks", "Clear the list" };
			
		MobileElement scroll = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(MobileBy
				.AndroidUIAutomator(
						"new UiScrollable(new UiSelector().scrollable(true))"+
						".scrollIntoView(new UiSelector().textContains(\"To-Do List\"))")));
		scroll.click();
			
		MobileElement addTaskBtn = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@text='Add Task']")));
		
		MobileElement newTask = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@resource-id='taskInput']")));

		MobileElement clearTask = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[contains(@text,'Clear List')]")));
		clearTask.click();
			
		for (String taskToAdd : tasksToAdd) {
			
			newTask.sendKeys(taskToAdd);
			addTaskBtn.click();
			
		}
				
		for (String strikeTask : tasksToAdd) {
			
			wait.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//*[@text='"+strikeTask+"']"))).click();
		}
				
		clearTask.click();
		
		boolean tasksCleared = (boolean) wait
				.until(ExpectedConditions.invisibilityOfElementLocated(MobileBy.xpath("//*[@text='Add more tasks to this list']")));
		
		Assert.assertTrue(tasksCleared);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
