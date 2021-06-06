package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new FirefoxDriver();

		driver.get("https://www.training-support.net");
		
		driver.findElement(By.id("about-link")).click();

		driver.close();

	}

}
