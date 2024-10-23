package session327ReativeLocators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorBelow {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		
		driver.findElement(By.id("input-email")).sendKeys("hans.huckbein@gmail.com");
		WebElement password = driver.findElement(By.id("input-password"));
		password.sendKeys("12345");
		
		// Finden des Login-Buttons mit Relative Locators below: unter dem Password
		// ist der Login-Button (im HTML-Code ist das <input>-Tag direkt unter dem PW)
		driver.findElement(RelativeLocator.with(By.tagName("input")).below(password)).click();
	}
}
