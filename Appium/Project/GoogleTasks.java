package project;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class GoogleTasks {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Android Pixel");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.apps.tasks");
		caps.setCapability("appActivity", ".ui.TaskListsActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL serverURL = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(serverURL, caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void googleTaskActivity() {

		String[] tasksToAdd = { "Google Task", "Google Keep - 1", "Google Keep - 2" };

		for (String taskToAdd : tasksToAdd) {

			MobileElement taskBtn = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
			taskBtn.click();

			MobileElement newTask = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));
			newTask.sendKeys(taskToAdd);

			MobileElement save = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_done")));
			save.click();
		}

		wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("task_name"), 3));
		List<MobileElement> tasksAdded = driver.findElementsById("task_name");
		assertEquals(tasksAdded.size(), 3);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
