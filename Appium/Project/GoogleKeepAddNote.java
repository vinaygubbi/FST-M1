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

public class GoogleKeepAddNote {
	WebDriverWait wait;
	AppiumDriver<MobileElement> driver = null;

	@BeforeTest
	public void setup() throws MalformedURLException {

		// Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "Android Pixel");
		caps.setCapability("platformName", "Android");
		caps.setCapability("appPackage", "com.google.android.keep");
		caps.setCapability("appActivity", ".activities.BrowseActivity");
		caps.setCapability("noReset", true);

		// Instantiate Appium Driver
		URL serverURL = new URL("http://0.0.0.0:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(serverURL, caps);
		wait = new WebDriverWait(driver, 10);
	}

	@Test
	public void googleKeepAddNoteActivity() {

		String[] notesToAdd = { "Create a Note" };
		String[] titlesToAdd = { "Note-1" };

		for (String titleToAdd : titlesToAdd) {

			MobileElement notesBtn = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(MobileBy.id("new_note_button")));
			notesBtn.click();

			MobileElement newTitle = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(MobileBy.id("editable_title")));
			newTitle.sendKeys(titleToAdd);
			
			MobileElement notesDesc = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(MobileBy.id("edit_note_text")));
			notesDesc.sendKeys(notesToAdd);

			MobileElement backBtn = (MobileElement) wait
					.until(ExpectedConditions.elementToBeClickable(MobileBy.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]")));
			backBtn.click();
		}

		wait.until(ExpectedConditions.numberOfElementsToBe(MobileBy.id("browse_note_interior_content"), 1));
		List<MobileElement> notesAdded = driver.findElementsById("browse_note_interior_content");
		assertEquals(notesAdded.size(), 1);
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}
