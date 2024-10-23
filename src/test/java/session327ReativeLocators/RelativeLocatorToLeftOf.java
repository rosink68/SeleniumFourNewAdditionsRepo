package session327ReativeLocators;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLocatorToLeftOf {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://omayo.blogspot.com/");
		
		WebElement loginButton = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		
		// Finden des Submit-Buttons mit Relative Locators toLeftOf: links neben dem Login-Button ist 
		// der Submit-Button (im HTML-Code ist das <button>-Tag direkt über dem Login-Button)
		String textOnButton = driver.findElement(RelativeLocator.with(By.tagName("button")).toLeftOf(loginButton)).getText();
		System.out.println("Text on Button: " + textOnButton);
		
		driver.quit();
	}
}
